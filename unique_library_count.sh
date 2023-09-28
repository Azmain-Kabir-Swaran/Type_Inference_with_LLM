#!/bin/bash

# Check if a directory argument is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <directory_path>"
    exit 1
fi

directory="$1"

# Check if the directory exists
if [ ! -d "$directory" ]; then
    echo "The directory $directory does not exist."
    exit 1
fi

calculate_unique_imports() {
    prefix="$1"
    display_name="$2"
    
    # Extract import statements, sort them, and count unique lines
    unique_import_count=$(find "$directory" -name "${prefix}*.java" -exec cat {} \+ | grep -oP 'import .*?;' | sort | uniq | wc -l)
    
    echo "Unique import statements for $display_name: $unique_import_count"
}

# Calculate unique import statements count for each category in the specified order
calculate_unique_imports "Android" "Android"
calculate_unique_imports "Class" "JDK"
calculate_unique_imports "hibernate" "Hibernate"
calculate_unique_imports "JodaTime" "JodaTime"
calculate_unique_imports "gwt_class" "GWT"
calculate_unique_imports "xstream_class" "XStream"

# Calculate overall unique import statement count for all Java files in the directory
unique_import_count_all=$(find "$directory" -name "*.java" -exec cat {} \+ | grep -oP 'import .*?;' | sort | uniq | wc -l)
echo "Overall unique import statements: $unique_import_count_all"