#andi
ori $t1, 0x3433
andi $t1, $t1, 0xf8c0
andi $0, $t1, 0x342
#addi
addi $t0, $0, 32767
addi $t0, $t0, -32768
addi $t0, $t0, -4234
addi $0, $t0, 34