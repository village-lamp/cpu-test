import os

zis = input("输入zip文件路径[默认为当前路径(默认名为mips.zip)]:")
asm = input("输入asm文件路径[默认为自动生成]:")
out = input("输入结果存放路径[默认为不存放](如C:\\out.txt):")
if zis == "":
    zis = "./mips.zip"
if out == "":
    out = "./resources/out.txt"
if asm == "":
    os.system("java -jar cpu-test-util.jar generate ./resources")
    asm = "./resources"
os.system("java -jar cpu-test-util.jar run " + zis + " " + asm)
os.system("iverilog -o ./resources/mips/mips.vvp ./resources/mips/mips_tb.v")
os.system("vvp ./resources/mips/mips.vvp > ./resources/out.txt")
os.system("java -jar cpu-test-util.jar test ./resources/mips/code.txt " + out)
