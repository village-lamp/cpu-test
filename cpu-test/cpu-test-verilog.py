import os
import re
import subprocess
import shutil


def my_system_run(cmd):
    return subprocess.run(cmd.split(" "), stdout=subprocess.PIPE, text=True).stdout


def clear_tests():
    path = '.\\resources\\test'
    for file in os.listdir(path):
        if re.match('test\\d+', file):
            os.system('rd /s /q ' + os.path.join(path, file))


def init():
    # 解压缩
    out_put = my_system_run('java -jar cpu-test-util.jar depress ' + zis)
    if re.search('失败', out_put) is not None:
       exit(-1)
    # 清理资源测试文件夹
    clear_tests()


def generate_tests(generate_times):
    path = '.\\resources\\test'
    generate_times = int(generate_times)
    count = 0
    while 1:
        if count >= generate_times:
            break
        count += 1
        sub_path = path + '\\test' + str(count)
        os.mkdir(sub_path)
        while 1:
            my_system_run('java -jar cpu-test-util.jar generate ' + sub_path)
            output = my_system_run('java -jar cpu-test-util.jar run ' + sub_path)
            if output != '运行失败\n':
                break


def run_tests():
    path = '.\\resources\\test'
    for file in os.listdir(path):
        sub_path = os.path.join(path, file)
        for sub_file in os.listdir(sub_path):
            if sub_file.split('.')[1] == 'asm':
                my_system_run('java -jar ./resources/Mars4_5.jar ' +
                              os.path.join(sub_path, sub_file) +
                              ' db nc mc CompactDataAtZero a dump .text HexText ' +
                              sub_path + '\\code.txt')
                my_system_run('java -jar cpu-test-util.jar run ' + sub_path)


def check():
    path = '.\\resources\\test'
    mips_path = '.\\resources\\mips'
    code_txt = mips_path + '\\code.txt'
    tb = mips_path + '\\mips_tb.v'
    for file in os.listdir(path):
        if auto == 'y' and not re.match('test\\d+', file):
            continue
        print('\n*************')
        print(file)
        sub_path = os.path.join(path, file)
        if os.path.exists(code_txt):
            os.remove(code_txt)
        if os.path.exists(tb):
            os.remove(tb)
        shutil.copy(sub_path + '\\code.txt', mips_path)
        shutil.copy(sub_path + '\\mips_tb.v', tb)
        os.chdir('.\\resources\\mips')
        my_system_run('iverilog -o mips.vvp mips_tb.v')
        os.system('vvp mips.vvp > ..\\test\\' + file + '\\out.txt')
        os.chdir('..\\..')
        os.system('java -jar cpu-test-util.jar check ' +
                  sub_path + '\\out.txt ' +
                  sub_path + '\\stdout.txt')


if __name__ == '__main__':
    zis = input('输入zip文件路径[./mips.zip)]:') or './mips.zip'
    auto = input('是否自动生成(y/n)[y]:') or 'y'
    init()

    # 自动生成
    if auto == 'y':
        times = input('输入测试次数[10]:') or '10'
        generate_tests(times)
    else:
        run_tests()

    check()
