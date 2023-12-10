#load
#rs0 br_r2 jr
ori $t0, $0, 0x3028
sw $t0, 0($0)
lw $t1, 0($0) #
beq $t1, $t0, beq1 #
nop
ori $s0, $0, 1
beq1:
lw $ra, 0($0) #
jr $ra #
nop
ori $t1, $0, 1

#rs1 cal_rr load store cal_ri mv_to mul_div
lw $t2, 0($0) #
add $t3, $t2, $t2 #

lw $t3, 0($0) #
lw $t4, -12328($t3) # #
sw $t4, -12324($t4) #

lw $t5, 4($0) #
ori $t5, $t5, 0x0f00 #

lw $t6, 4($0) #
mthi $t6 #
mfhi $t0

lh $t0, 0($0) #
multu $t0, $t0 #
mfhi $t1
mflo $t0

ori $t0, $0, 0
ori $t1, $0, 0
ori $t2, $0, 0
ori $t3, $0, 0
ori $t4, $0, 0
ori $t5, $0, 0
ori $t6, $0, 0

#rt0 br_r2
ori $t0, $0, 0x3028
sw $t0, 0($0)
lw $t1, 0($0) #
beq $t0, $t1, beq2 #
nop
ori $s0, $0, 1
beq2:

#rt1 mul_div
lw $t2, 0($0) #
add $t3, $t2, $t2 #

lb $t2, 1($0) #
divu $t2, $t3 #
mfhi $t0
mflo $t1

#rt2 store
lw $t3, 0($0) #
sw $t3, 4($0) #
