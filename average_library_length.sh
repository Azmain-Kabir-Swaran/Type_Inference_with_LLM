#!/bin/bash

# Check if a directory argument is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <directory_path>"
    exit 1
fi

directory="$1"

# Check if the directory exists
if [ ! -d "$directory" ]; then
    echo "The directory you provided: $directory does not exist."
    exit 1
fi

calculate_import_length() {
    prefix="$1"
    display_name="$2"
    
    # Extract import statements, then compute the average length using awk
    average_length=$(find "$directory" -name "${prefix}*.java" -exec cat {} \+ | grep -oP 'import .*?;' | awk '{ total += length($0); count++ } END { print (count ? total / count : 0) }')
    
    # Round the result
    rounded_length=$(printf "%.0f" $average_length)
    
    echo "Average length of import statements for $display_name: $rounded_length"
}

# Calculate average import statement length for each category
calculate_import_length "Android" "Android"
calculate_import_length "Class" "JDK"
calculate_import_length "hibernate" "Hibernate"
calculate_import_length "JodaTime" "JodaTime"
calculate_import_length "gwt_class" "GWT"
calculate_import_length "xstream_class" "XStream"

# Calculate overall average import statement length for all Java files in the directory
average_length_all=$(find "$directory" -name "*.java" -exec cat {} \+ | grep -oP 'import .*?;' | awk '{ total += length($0); count++ } END { print (count ? total / count : 0) }')

# Round the overall average
rounded_length_all=$(printf "%.0f" $average_length_all)

echo "Overall average length of import libraries: $rounded_length_all"