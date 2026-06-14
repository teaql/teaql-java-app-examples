import os
import re

directory = "generated-lib/lib/src/main/java"

def process_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()

    original = content
    # Remove imports
    content = re.sub(r'import cn\.hutool\.core\.util\..*?;\n', '', content)

    # Replace ObjectUtil.equal(a, b) -> java.util.Objects.equals(a, b)
    content = re.sub(r'ObjectUtil\.equal\((.*?),\s*(.*?)\)', r'java.util.Objects.equals(\1, \2)', content)

    # Replace StrUtil.trim(x) -> (x == null ? null : x.trim())
    # Actually for case "name": this.name = StrUtil.trim((String) value);
    # Let's replace StrUtil.trim(x) -> (x == null ? null : ((String)x).trim())
    content = re.sub(r'StrUtil\.trim\(\(String\)\s*(.*?)\)', r'(\1 == null ? null : ((String)\1).trim())', content)
    content = re.sub(r'StrUtil\.trim\((.*?)\)', r'(\1 == null ? null : \1.trim())', content)

    if original != content:
        with open(filepath, 'w') as f:
            f.write(content)

for root, _, files in os.walk(directory):
    for file in files:
        if file.endswith('.java'):
            process_file(os.path.join(root, file))

print("Done")
