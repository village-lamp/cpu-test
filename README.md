### 说明：

**环境需求：**

+ 使用工具源代码需要jdk1.8+、使用jar包需要jre1.8+
+ 使用cpu-test-verilog.py需要python3
+ 自动运行程序需要将iverilog路径加入path中

**github：**https://github.com/village-lamp/cpu-test

### 文件：

**cpu-test-util：**java项目源代码，实现基础功能

**cpu-test：**python项目源代码，用于调用cpu-test-util

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
  + 参数：存放生成的test.asm的路径
+ test 测试
  + 参数1：test.txt文件路径
  + 参数2：输出结果路径
+ run 运行，重编文件
  + 参数1：压缩包路径
  + 参数2：asm文件

#### 2.使用cpu-test-verilog.py

双击或使用指令：

```cmd
python cpu-test-verilog.py
```

按照说明输入即可

