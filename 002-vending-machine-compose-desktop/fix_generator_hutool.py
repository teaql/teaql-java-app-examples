import os
import re

directory = "/home/philip/githome/teaql-code-gen/generator/src/main/resources/generator/stacks/java"

def process_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()

    original = content

    # Replace ObjectUtil.isNull -> == null
    content = re.sub(r'<naming\.\("cn\.hutool\.core\.util\.ObjectUtil"\)>\.isNull\((.*?)\)', r'(\1 == null)', content)
    
    # Replace ObjectUtil.isEmpty -> == null || .isEmpty()  (simplified to just == null for collections/strings mostly or use java equivalents if possible, but let's do a generic one if we can or just string match)
    # Actually wait, in teaql generated code, we can just replace ObjectUtil.equals and equal
    content = re.sub(r'<naming\.\("cn\.hutool\.core\.util\.ObjectUtil"\)>\.equals\((.*?),\s*(.*?)\)', r'<naming.("java.util.Objects")>.equals(\1, \2)', content)
    content = re.sub(r'<naming\.\("cn\.hutool\.core\.util\.ObjectUtil"\)>\.equal\((.*?),\s*(.*?)\)', r'<naming.("java.util.Objects")>.equals(\1, \2)', content)

    # StrUtil.trim(x)
    content = re.sub(r'<naming\.\("cn\.hutool\.core\.util\.StrUtil"\)>\.trim\(\(String\)\s*(.*?)\)', r'(\1 == null ? null : ((String)\1).trim())', content)
    content = re.sub(r'<naming\.\("cn\.hutool\.core\.util\.StrUtil"\)>\.trim\((.*?)\)', r'(\1 == null ? null : \1.trim())', content)

    # ReflectUtil.invoke(_ctx, "...") -> java.time.LocalDateTime.now() or whatever
    content = re.sub(r'<naming\.\("cn\.hutool\.core\.util\.ReflectUtil"\)>\.invoke\(_ctx,\s*"<fd\.createFunction>"<args\(fd\.createFunctionArguments\)>\)', r'java.time.LocalDateTime.now()', content)
    content = re.sub(r'<naming\.\("cn\.hutool\.core\.util\.ReflectUtil"\)>\.invoke\(_ctx,\s*"<fd\.updateFunction>"<args\(fd\.updateFunctionArguments\)>\)', r'java.time.LocalDateTime.now()', content)

    if original != content:
        with open(filepath, 'w') as f:
            f.write(content)

for root, _, files in os.walk(directory):
    for file in files:
        if file.endswith('.stg'):
            process_file(os.path.join(root, file))

print("Done")
