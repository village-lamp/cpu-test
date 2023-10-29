### 说明：

**环境需求：**

+ 使用工具源代码需要jdk1.8+、使用jar包需要jre1.8+
+ 使用cpu-test.py需要python3

**github：**https://github.com/village-lamp/cpu-test

**testfirst.asm：** 数据生成工具生成的伪指令，目前表现为beq指令不使用标签，而使用十进制数

### 文件：

**cpu-test-util：**java项目源代码，实现基础功能

**cpu-test：**python项目源代码，用于调用cpu-test-util

### 使用：

package中包含cpu-test.py, cpu-test-util.jar以及resources文件夹

#### 1.使用cpu-test-util.jar（不建议）

可以单独使用cpu-test-util.jar（也可以使用源代码）

```cmd
java -jar cpu-test-util.jar [cmd] [para]
```

**参数列表：**

+ help 查询使用方式

+ generate 生成测试数据
  + 参数：存放生成的test.asm以及testfirst.asm路径
+ test 测试电路，生成测试批文件在jar包路径下
  + 参数1：电路文件路径
  + 参数2：测试文件路径
  + 参数3：存放结果文件的路径
+ check 检验答案是否正确
  + 参数1：结果文件
  + 参数2：生成器生成的testfirst.asm文件
  + 参数3：存放指令码的文件

#### 2.使用cpu-test.py

双击或使用指令：

```cmd
python cpu-test.py
```

按照说明输入即可

### 缺陷：

+ 对于多个电路的并行测试，目前只使用fc来比较两个输出文件是否相同。由于电路实现的不同，电路运行中一些无关的参数可能会有差异，此时无法很好地检验两个电路之间的正确性。
+ beq指令目前只有向后跳转功能
+ lw以及sw指令目前只能生成base为$0的指令
+ 工具中的check功能目前只支持testfirst.asm文件，只能用于自动生成数据测试

