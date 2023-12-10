#lui jal
li $t0, 0xfd39c0f9
li $t1, 0x00df0300
mult $t0, $t1

#rt0 br_r2
lui $t0, 0xab94
lui $t1, 0xab94 #
beq $t0, $t1, beq1 #
nop
ori $s0, $0, 1
beq1:
ori $t0, $0, 0x304c
ori $ra, $0, 0x3044
jal1:
beq $t0, $ra, beq2 #
nop
ori $s0, $0, 1
jr $ra
nop
jal jal1 #
nop
beq2:
mflo $t0
nop
nop
nop
mflo $t1 #
beq $t0, $t1, beq5 #
nop
ori $s0, $0, 1
beq5:

#rt1 cal_rr mul_div
lui $t1, 0x3240 #
add $t1, $t1, $t1 #

jal jal2 #
nop
jal2:
add $t1, $ra, $ra #
lui $t0, 0x3243
lui $t1, 0xff9d #
divu $t0, $t1 #
mfhi $t0
mflo $t1
jal jal8 #
nop
jal8:
mult $t0, $ra #
mfhi $t0
mflo $t1

#rt2 store
jal jal3 #
nop
jal3:
sw $t1, -6000($ra) #

#rs1 cal_rr load store cal_ri mv_to mul_div
lui $t1, 0x3430 #
ori $t1, $t1, 0x4344 #

jal jal4 #
nop
jal4:
ori $t1, $ra, 0x30fe #

lui $t2, 0x9fab #
and $t1, $t2, $t2 #

jal jal9 #
nop
jal9:
addi $t1, $ra, -100 #

lui $t0, 0x3402 #
mthi $t0 #
mfhi $t1
jal jal10 #
nop
jal10:
mtlo $ra #
mflo $t0

jal jal11 #
nop
jal11:
sh $t0, -3002($ra) #

jal jal12 #
nop
jal12:
lb $t1, -3014($ra) #

lui $t0, 0x4343 #
divu $t0, $t1 #
mflo $t0
mfhi $t1

jal jal7 #
nop
jal7:
multu $ra, $t0 #
mflo $t0 
mfhi $t1

#rs0 br_r2 jr
lui $t0, 0xab94
lui $t1, 0xab94 #
beq $t1, $t0, beq3 #
nop
ori $s0, $0, 1
beq3:
ori $t0, $0, 0x4000
jal jal5 #
nop
jal5:
beq $ra, $t0, beq4 #
nop
ori $s0, $0, 1
beq4:
mfhi $t1
mfhi $t0 #
beq $t0, $t1, beq7 #
nop
ori $s0, $0, 1
beq7:
jal jal6 #
nop
beq $0, $0, end
nop
jal6:
jr $ra #
nop
end:
ori $t0, $0, 1
ori $t1, $0, 0x31a4
divu $t1, $t0
mflo $s0 #
jr $s0 #
nop
ori $s0, $0, 1

