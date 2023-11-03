import os

zis = input("输入zip文件路径[默认为当前路径(默认名为mips.zip)]:")
asm = input("输入asm文件路径[默认为自动生成]:")
out = input("输入结果存放路径[默认为不存放](如C:\\out.txt):")
if zis == "":
    zis = "./mips.zip"
if out == "":
    out = "./out.txt"
if asm == "":
    os.system("java -jar cpu-test-util.jar generate ./resources")
    asm = "./resources/test.asm"
os.system("java -jar cpu-test-util.jar run " + zis + " " + asm)
os.chdir("./resources/mips")
os.system("iverilog -o mips.vvp mips_tb.v")
os.system("vvp mips.vvp > " + out)
os.system("java -jar ../../cpu-test-util.jar test code.txt " + out)
