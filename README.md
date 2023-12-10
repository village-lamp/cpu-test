### 说明：

**环境需求：**

+ 使用工具源代码需要jdk1.8+、使用jar包需要jre1.8+
+ 使用cpu-test-verilog.py需要python3
+ 自动运行程序需要将iverilog路径加入path中

**github：** https://github.com/village-lamp/cpu-test

### 文件：

**cpu-test-util：** java项目源代码，实现基础功能

**cpu-test：** python项目源代码，用于调用cpu-test-util

### 使用：

package中包含cpu-test-verilog.py, cpu-test-util.jar以及resources文件夹

#### 1.使用cpu-test-util.jar（不建议）

可以单独使用cpu-test-util.jar（也可以使用源代码）

```cmd
java -jar cpu-test-util.jar [cmd] [para]
```

**参数列表：**

+ help 查询使用方式
+ generate 生成测试数据
  + 参数：存放生成的文件的路径
+ run 运行txt获取正确答案
  + 参数：test.txt文件路径
+ depress 解压，重编文件
  + 参数：压缩包文件

+ check 检查答案
  + 参数1：输出结果文件
  + 参数2：正确结果文件


#### 2.使用cpu-test-verilog.py

双击或使用指令：

```cmd
python cpu-test-verilog.py
```

按照说明输入即可

模式1：自动生成模式，数据来源为自动生成

$\color{red}{注:自动生成数据中含有除以0的情况，默认处理方式为保持hi和lo不变}$

模式2：手动测试模式，可以将测试的asm放置在package/resources/test下，新建一个文件夹中。test文件夹下已经有许多的测试。

$\color{red}{注:未完成}$

