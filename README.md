# Type Inference with Large Language Model

```
.
├── Java_Type_Inference
│   ├── Codes
│   │   ├── Code_Fixing.ipynb
│   │   ├── Compilation_Rate.ipynb
│   │   ├── One-shot_Final_Benchmark.ipynb
│   │   ├── One-shot_Prompt_Learning_with_ChatGPT_(GPT-3.5_Turbo).ipynb
│   │   ├── Zero-shot_Final_Benchmark.ipynb
│   │   └── Zero-shot_Prompt_Learning_with_ChatGPT_(GPT-3.5_Turbo).ipynb
│   ├── Results
│   │   ├── compiled-classes
│   │   │   ├── one-shot-compiled
│   │   │   │   ├── androidExamples
│   │   │   │   ├── com
│   │   │   │   ├── common_JDK
│   │   │   │   ├── gwt
│   │   │   │   ├── hibernate
│   │   │   │   ├── jodatime
│   │   │   │   └── xstream
│   │   │   └── zero-shot-compiled
│   │   │       ├── androidExamples
│   │   │       ├── com
│   │   │       ├── common_JDK
│   │   │       ├── gwt
│   │   │       ├── hibernate
│   │   │       ├── jodatime
│   │   │       └── xstream
│   │   ├── final-benchmark
│   │   │   ├── one-shot-json
│   │   │   │   ├── Android01.json
│   │   │   │   ├── ...
│   │   │   │   ├── ...
│   │   │   │   └── xstream_class_9.json
│   │   │   └── zero-shot-json
│   │   │       ├── Android01.json
│   │   │       ├── ...
│   │   │       ├── ...
│   │   │       └── xstream_class_9.json
│   │   ├── llm_fixes
│   │   │   ├── fixed_codes
│   │   │   │   ├── one-shot-fix
│   │   │   │   └── zero-shot-fix
│   │   │   ├── llm-compiled-classes
│   │   │   │   ├── one-shot-compiled
│   │   │   │   └── zero-shot-compiled
│   │   │   └── llm-logs
│   │   │       ├── one-shot-logs
│   │   │       └── zero-shot-logs
│   │   ├── logs
│   │   │   ├── one-shot-logs
│   │   │   │   ├── compile_fail
│   │   │   │   └── compile_success
│   │   │   └── zero-shot-logs
│   │   │       ├── compile_fail
│   │   │       └── compile_success
│   │   ├── Result_Code_Fixing.ipynb
│   │   ├── Result_Compilation_Rate.ipynb
│   │   ├── Result_One-shot_Final_Benchmark.ipynb
│   │   ├── Result_One-shot_Prompt_Learning_with_ChatGPT_(GPT-3.5_Turbo).ipynb
│   │   ├── Result_Zero-shot_Final_Benchmark.ipynb
│   │   └── Result_Zero-shot_Prompt_Learning_with_ChatGPT_(GPT-3.5_Turbo).ipynb
│   └── snippets_for_test
│       ├── all-one-shot
│       │   ├── Android01.java
│       │   ├── ...
│       │   ├── ...
│       │   └── xstream_class_9.java
│       └── all-zero-shot
│           ├── Android01.java
│           ├── ...
│           ├── ...
│           └── xstream_class_9.java
└── README.md
```
### We used ChatGPT's GPT 3.5 Turbo model to do our experiment for Java Type Inference.

We introduced prompt and tested Java codes from StackOverflow to get the Fully Qualified Name (FQN) of types. All the codes and results are stored in the [Java_Type_Inference](https://github.com/Azmain-Kabir-Swaran/Type_Inference_with_LLM/tree/main/Java_Type_Inference) folder.

Inside that folder, [Codes](https://github.com/Azmain-Kabir-Swaran/Type_Inference_with_LLM/tree/main/Java_Type_Inference/Codes) folder contains the python notebooks for One-shot and Zero-shot prompt learning.