import os
import re

mode = input("输入模式（0:单个电路,1:两个电路）:")
pattern = re.compile(r"\d+")
if pattern.match(mode):
    mode = int(mode)
else:
    print("模式格式错误，请输入0或1")
    exit(-1)
if mode > 1:
    print("模式格式错误，请输入0或1")
    exit(-1)
if mode == 0:
    circ = input("输入电路路径:")
    asm = input("输入测试文件路径（默认为自动生成）:")
    out = input("输入结果文件存放路径:")
    out += "\\out.txt"
    if asm == "":
        os.system("java -jar cpu-test-util.jar generate ./resources")
        asm = "./resources/test.asm"
    os.system("java -jar cpu-test-util.jar test " + circ + " "
              + asm + " " + out)
    os.system("run.bat")
    os.system("java -jar cpu-test-util.jar check " + out + " ./resources/testfirst.asm " +
              "./resources/test.txt");
else:
    circ1 = input("输入第一个电路路径:")
    circ2 = input("输入第二个电路路径:")
    asm = input("输入测试文件路径（默认为自动生成）:")
    out = input("输入结果文件存放路径:")
    if asm == "":
        os.system("java -jar cpu-test-util.jar generate .")
        asm = "."
    os.system("java -jar cpu-test-util.jar test " + circ1 + " "
              + asm + " " + out + "\\out1.txt")
    os.system("./resources/run.bat")
    os.system("java -jar cpu-test-util.jar test " + circ2 + " "
              + asm + " " + out + "\\out2.txt")
    os.system("./resources/run.bat")
    os.system("fc " + out + "\\out1.txt " + out + "\\out2.txt")
