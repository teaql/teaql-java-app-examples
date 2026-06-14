import os
import re

directory = "generated-lib/lib/src/main/java"

def process_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()

    original = content

    # Replace ObjectUtil.equals(a, b) -> java.util.Objects.equals(a, b)
    content = re.sub(r'ObjectUtil\.equals\((.*?),\s*(.*?)\)', r'java.util.Objects.equals(\1, \2)', content)

    if original != content:
        with open(filepath, 'w') as f:
            f.write(content)

for root, _, files in os.walk(directory):
    for file in files:
        if file.endswith('.java'):
            process_file(os.path.join(root, file))

print("Done")
