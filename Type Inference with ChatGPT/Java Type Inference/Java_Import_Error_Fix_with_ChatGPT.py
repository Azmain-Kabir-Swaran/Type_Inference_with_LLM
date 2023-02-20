import glob
import json
import os
import re

from tqdm import tqdm
from sklearn.metrics import accuracy_score, f1_score, precision_score, recall_score

from chatgpt_wrapper import ChatGPT


model = ChatGPT()

os.chdir('/Users/swaran/Desktop/alljavajsons')

inputFiles = []
correctOutputFiles = []


    
numbers = re.compile(r'(\d+)')
def numericalSort(value):
    parts = numbers.split(value)
    parts[1::2] = map(int, parts[1::2])
    return parts

for file in sorted(glob.glob("*.java.json"), key=numericalSort):
    inputFiles.append(file)

for file in sorted(glob.glob("*.benchmark_log.json"), key=numericalSort):
    correctOutputFiles.append(file)

# print(inputFiles)
# print('\n\n\n')
# print(correctOutputFiles)


def get_codes(inputFiles):
    codes = []
    for code in inputFiles:
        codes.append(str(json.load(open(code))['originalContent']))
    return codes


def get_correct_outputs(correctOutputFiles):
    correct_outputs = []
    for output in correctOutputFiles:
        correct_output_list = json.load(open(output))['total_imports']
        correct_output_list = ["import "+i+";" for i in correct_output_list]
        correct_outputs.append(correct_output_list)
        
    for import_lines in correct_outputs:
        if "import gen.R;" in import_lines:
            import_lines.remove("import gen.R;")
    
    return correct_outputs


def get_dataset(codes, correct_outputs):
    dataset = {
        "codes": codes,
        "correct_outputs": correct_outputs
    }
    return dataset



def get_test_examples_and_y_true(dataset):
    sample_list = []

#     for i in range(0, 10):
    for i in range(0, len(dataset["codes"])):
        sample_list.append(dict(codes=dataset["codes"][i], correct_outputs=dataset["correct_outputs"][i]))
    
    # print(sample_list)
    
    test_examples = [(example["codes"], example["correct_outputs"]) for example in sample_list]
    y_true = [correct_outputs for _, correct_outputs in test_examples]
    return test_examples, y_true


# Android Classes

print("\nTotal Android Codes: {}\n".format(len(inputFiles[:50])))
# print(inputFiles[:50])
android_codes = get_codes(inputFiles[:50])
# print(android_codes)
android_correct_outputs = get_correct_outputs(correctOutputFiles[:50])
# print(android_correct_outputs)
android_dataset = get_dataset(android_codes, android_correct_outputs)
# print(android_dataset)
android_test_examples, android_y_true = get_test_examples_and_y_true(android_dataset)
# print(android_test_examples)



# JDK Classes

print("Total JDK Codes: {}\n".format(len(inputFiles[50:73])))
# print(inputFiles[50:73])
jdk_codes = get_codes(inputFiles[50:73])
# print(jdk_codes)
jdk_correct_outputs = get_correct_outputs(correctOutputFiles[50:73])
# print(jdk_correct_outputs)
jdk_dataset = get_dataset(jdk_codes, jdk_correct_outputs)
# print(jdk_dataset)
jdk_test_examples, jdk_y_true = get_test_examples_and_y_true(jdk_dataset)
# print(jdk_test_examples)



# Hibernate Classes

print("Total Hibernate Codes: {}\n".format(len(inputFiles[73:74] + inputFiles[174:224])))
# print(inputFiles[73:74] + inputFiles[174:224])
hibernate_codes = get_codes(inputFiles[73:74] + inputFiles[174:224])
# print(hibernate_codes)
hibernate_correct_outputs = get_correct_outputs(correctOutputFiles[73:74] + correctOutputFiles[174:224])
# print(hibernate_correct_outputs)
hibernate_dataset = get_dataset(hibernate_codes, hibernate_correct_outputs)
# print(hibernate_dataset)
hibernate_test_examples, hibernate_y_true = get_test_examples_and_y_true(hibernate_dataset)
# print(hibernate_test_examples)


# Joda-Time Classes

print("Total JodaTime Codes: {}\n".format(len(inputFiles[74:124])))
# print(inputFiles[74:124])
jodatime_codes = get_codes(inputFiles[74:124])
# print(jodatime_codes)
jodatime_correct_outputs = get_correct_outputs(correctOutputFiles[74:124])
# print(jodatime_correct_outputs)
jodatime_dataset = get_dataset(jodatime_codes, jodatime_correct_outputs)
# print(jodatime_dataset)
jodatime_test_examples, jodatime_y_true = get_test_examples_and_y_true(jodatime_dataset)
# print(jodatime_test_examples)



# GWT Classes

print("Total GWT Codes: {}\n".format(len(inputFiles[124:174])))
# print(inputFiles[124:174])
gwt_codes = get_codes(inputFiles[124:174])
# print(gwt_codes)
gwt_correct_outputs = get_correct_outputs(correctOutputFiles[124:174])
# print(gwt_correct_outputs)
gwt_dataset = get_dataset(gwt_codes, gwt_correct_outputs)
# print(gwt_dataset)
gwt_test_examples, gwt_y_true = get_test_examples_and_y_true(gwt_dataset)
# print(gwt_test_examples)


# XStream Classes

print("Total XStream Codes: {}\n".format(len(inputFiles[224:268])))
# print(inputFiles[224:268])
xstream_codes = get_codes(inputFiles[224:268])
# print(xstream_codes)
xstream_correct_outputs = get_correct_outputs(correctOutputFiles[224:268])
# print(xstream_correct_outputs)
xstream_dataset = get_dataset(xstream_codes, xstream_correct_outputs)
# print(xstream_dataset)
xstream_test_examples, xstream_y_true = get_test_examples_and_y_true(xstream_dataset)
# print(xstream_test_examples)



# Zero-Shot

def get_prediction(code_snippet):
    prompt=f"Infer only correct imports:\n\"\"\"{code_snippet}\"\"\""
    response = model.ask(prompt)
    return response


def get_predictions(dataset):
    y_pred = []
    for code_snippet, correct_imports in tqdm(dataset):
        pattern = r'^import\s.*;$'
        regex = re.compile(pattern, re.MULTILINE)
        predicted_imports = regex.findall(get_prediction(code_snippet))
        y_pred.append(predicted_imports)
    return y_pred

def pred_process(y_pred, y_true):
    y_pred_processed = []
    y_true_processed = []
    
    for pred, correct_imports in zip(y_pred, y_true):
        max_length = max(len(pred), len(correct_imports))
        correct_preds = list(set(pred).intersection(correct_imports))
#         print('Correct Predictions:', correct_preds)
#         wrong_preds = max_length - len(correct_preds)
#         print('Wrong Predictions:', wrong_preds)

        for i in range(0, max_length):
            if i<len(correct_preds):
                y_pred_processed.append(1)
                y_true_processed.append(1)
            else:
                if i<len(correct_imports):
                    y_pred_processed.append(0)
                    y_true_processed.append(1)
                else:
                    y_pred_processed.append(1)
                    y_true_processed.append(0)
            
    # print(y_pred_processed)
    # print(y_true_processed)
    return y_pred_processed, y_true_processed

def eval_performance(y_pred, y_true):
    print(json.dumps({
        "accuracy": accuracy_score(y_pred, y_true),
        "f1": f1_score(y_pred, y_true),
        "precision": precision_score(y_pred, y_true),
        "recall": recall_score(y_pred, y_true)
    }, indent=2))


# Prediction for Android Classes

print("\nPrediction for Android Classes:\n")
y_pred = get_predictions(android_test_examples)
print("\nPredicted Import List:", y_pred)
print("\nCorrect Import List:", android_y_true)
y_pred_processed, y_true_processed = pred_process(y_pred, android_y_true)
eval_performance(y_pred_processed, y_true_processed)


# Prediction for JDK Classes

print("\nPrediction for JDK Classes:\n")
y_pred = get_predictions(jdk_test_examples)
print("\nPredicted Import List:", y_pred)
print("\nCorrect Import List:", jdk_y_true)
y_pred_processed, y_true_processed = pred_process(y_pred, jdk_y_true)
eval_performance(y_pred_processed, y_true_processed)


# Prediction for Hibernate Classes

print("\nPrediction for Hibernate Classes:\n")
y_pred = get_predictions(hibernate_test_examples)
print("\nPredicted Import List:", y_pred)
print("\nCorrect Import List:", hibernate_y_true)
y_pred_processed, y_true_processed = pred_process(y_pred, hibernate_y_true)
eval_performance(y_pred_processed, y_true_processed)


# Prediction for Joda-Time Classes

print("\nPrediction for Joda-Time Classes:\n")
y_pred = get_predictions(jodatime_test_examples)
print("\nPredicted Import List:", y_pred)
print("\nCorrect Import List:", jodatime_y_true)
y_pred_processed, y_true_processed = pred_process(y_pred, jodatime_y_true)
eval_performance(y_pred_processed, y_true_processed)


# Prediction for GWT Classes

print("\nPrediction for GWT Classes:\n")
y_pred = get_predictions(gwt_test_examples)
print("\nPredicted Import List:", y_pred)
print("\nCorrect Import List:", gwt_y_true)
y_pred_processed, y_true_processed = pred_process(y_pred, gwt_y_true)
eval_performance(y_pred_processed, y_true_processed)


# Prediction for XStream Classes

print("\nPrediction for XStream Classes\n")
y_pred = get_predictions(xstream_test_examples)
print("\nPredicted Import List:", y_pred)
print("\nCorrect Import List:", xstream_y_true)
y_pred_processed, y_true_processed = pred_process(y_pred, xstream_y_true)
eval_performance(y_pred_processed, y_true_processed)
