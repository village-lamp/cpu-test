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

$\color{red}{注：运行失败代表数据生成错误}$

### 问题：

+ 覆盖率不足：

  转发方面：缺少cal_rr<jal   cal_ri<jal   br_r2<load  loac<cal_rr  load<load  load<lui   load<jal   store<load   store<lui   store<jal   jr<load  jr<cal_rr

  难出现 jr<cal_ri  

  暂停方面：缺少br_r2<cal_rr  br_r2<load  load<load  store<load  jr<cal_rr  jr<load

  难出现  jr<cal_ri

+ 还是有死循环的几率

+ 目前其实只做了自动生成的部分，手动添加指令文件暂时没有实现

### 改进：

+ 目前将寄存器分为了高级中级低级三类，而计算类指令只计算高级寄存器，使得相关的一些冒险难以出现，所以将计算类指令更改为使用所有寄存器。
+ 目前向dm中存储的全部都是高级寄存器，可以将dm中也分为三个区域
+ jr使用中级寄存器的情况不容易出现，考虑再增加一类寄存器（可能实现起来较难）

