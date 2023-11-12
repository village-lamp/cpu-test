import os

zis = input("输入zip文件路径[默认为当前路径(默认名为mips.zip)]:") or "./mips.zip"
asm = input("输入asm文件路径[默认为自动生成]:") or "./resources"
out = input("输入结果存放路径[默认为不存放](如C:\\out.txt):") or "./out1.txt"
times = input("输入测试次数[默认为10]:") or "10"
os.system("java -jar cpu-test-util.jar depress " + zis)
os.chdir("./resources/mips")

if asm == "./resources":
    for i in range(0, int(times)):
        os.system("java -jar ../../cpu-test-util.jar generate .")
        os.system("java -jar ../../cpu-test-util.jar run .")
        os.system("iverilog -o mips.vvp mips_tb.v")
        os.system("vvp mips.vvp > " + out)
        print()
        os.system("java -jar ../../cpu-test-util.jar check " + out + " out.txt")
        print()
