#cal_rr/cal_ri mv_fr
li $t0, 0xfd39c0f9
li $t1, 0x00df0300
mult $t0, $t1

#rs0 br_r2 jr
ori $t0, 0x3028
add $t2, $t0, $0 #
beq $t2, $t1, beq1 #
nop
ori $s0, $0, 1
beq1:
ori $t3, $0, 0x3034 #
jr $t3 #
nop
ori $t1, $0, 1
mfhi $t1
mfhi $t0 #
beq $t0, $t1, beq3 #
nop
ori $s0, $0, 1
beq3:
ori $t0, $0, 1
ori $t1, $0, 0x3068
divu $t1, $t0
mflo $s0 #
jr $s0 #
nop
ori $s0, $0, 1

#rs1 cal_rr cal_ri load store
ori $t1, $0, 12328
sw $t1, 0($0)
lw $t0, 0($0)
add $t3, $t0, $t0 #
sub $t4, $t3, $0 # #
lw $t0, -24656($t4) #

ori $t3, $0, 4 #
ori $t3, $t3, 8 # #
sw $t3, 0($t3) #

mult $t2, $t3
mfhi $t0 #
or $t1, $t0, $t1 #

mfhi $t1 #
addi $t1, $t1, 0x9898 #

ori $t1, $0, 100
ori $t2, $0, 10
multu $t1, $t2
mflo $t0 #
sw $t1, 0($t0) #

mflo $t1 #
lw $t1, 0($t1) #

#rt0 br_r2
ori $t1, $0, 0
ori $t2, $0, 0
ori $t0, 0x3028
add $t2, $t0, $t0 #
beq $t1, $t2, beq2 #
nop
ori $s0, $0, 1
beq2:
mflo $t0
mflo $t1 #
beq $t0, $t1, beq4 #
nop
ori $s0, $0, 1
beq4:

#rt1 cal_rr mul_div
add $t3, $t0, $t0 #
sub $t4, $t3, $t0 #

ori $t4, $0, 100
mflo $t2 #
sltu $t0, $t2, $t4 #

addi $t0, $0, 100
addi $t1, $0, -100 #
multu $t0, $t1 #
mfhi $t1
mflo $t0 #
multu $t0, $t0 #
mfhi $t1
mflo $t0

#rt2 store
add $t5, $0, $t0 #
sw $t5, 100($0) #

mflo $t2 #
sw $t2, 100($0) #
