import os


def clear_tests():
    path = "./resources/test"
    for root, dirs, files in os.walk(path):
        print(root, dirs, files)


def init():
    # 解压缩
    os.system("java -jar cpu-test-util.jar depress " + zis)
    os.chdir("./resources/mips")
    # 清理资源测试文件夹
    clear_tests()


if __name__ == '__main__':
    zis = input("输入zip文件路径[./mips.zip)]:") or "./mips.zip"
    auto = input("是否自动生成(y/s)[y]:") or "y"
    times = input("输入测试次数[10]:") or "10"
    init()


# if asm == "./resources":
#     for i in range(0, int(times)):
#         os.system("java -jar ../../cpu-test-util.jar generate .")
#         os.system("java -jar ../../cpu-test-util.jar run .")
#         os.system("iverilog -o mips.vvp mips_tb.v")
#         os.system("vvp mips.vvp > " + out)
#         print()
#         os.system("java -jar ../../cpu-test-util.jar check " + out + " out.txt")
#         print()
