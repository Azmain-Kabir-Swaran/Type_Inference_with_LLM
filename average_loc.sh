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

calculate_avg_loc() {
    prefix="$1"
    display_name="$2"
    total_lines=$(find "$directory" -name "${prefix}*.java" -print0 | xargs -0 cat | wc -l)
    file_count=$(find "$directory" -name "${prefix}*.java" | wc -l)

    if [ $file_count -eq 0 ]; then
        echo "No Java files found for category $display_name in the directory you provided: $directory."
        return
    fi

    average=$(echo "($total_lines + $file_count/2) / $file_count" | bc)
    echo "Average LOC for $display_name: $average"
}

# Calculate average LOC for each category
calculate_avg_loc "Android" "Android"
calculate_avg_loc "Class" "JDK"
calculate_avg_loc "hibernate" "Hibernate"
calculate_avg_loc "JodaTime" "JodaTime"
calculate_avg_loc "gwt_class" "GWT"
calculate_avg_loc "xstream_class" "XStream"

# Calculate overall average LOC for all Java files in the directory
total_lines_all=$(find "$directory" -name "*.java" -print0 | xargs -0 cat | wc -l)
file_count_all=$(find "$directory" -name "*.java" | wc -l)
if [ $file_count_all -gt 0 ]; then
    average_all=$(echo "($total_lines_all + $file_count_all/2) / $file_count_all" | bc)
    echo "Overall average LOC for all Java files in $directory: $average_all"
else
    echo "No Java files found in the directory $directory."
fi