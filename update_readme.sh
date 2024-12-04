#!/bin/bash

directory="src/"

# File name to count
file_name="Main.java"

# Count files with the specified name recursively
count=$(find "$directory" -type f -name "$file_name" | grep -c "$file_name")

sed -i '' -e '1d' README.md
sed -i '' '1s/^/![progress](https:\/\/img.shields.io\/badge\/Progress:-'"$count"'_\/_75-plastic)\n/' README.md
git add .
