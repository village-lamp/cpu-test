#beq
	#offset = -1
	#beq1: beq $0, $0, beq1
	#offset < -1
	ori $t1, $0, 0
	ori $t2, $0, 1
	beq2: add $t1, $t2, $t1
	beq $t1, $t2, beq2
	nop
	#offset > -1
	ori $t1, $0, 43
	ori $t2, $0, 43
	beq $t1, $t2, beq3
	nop
	add $t2, $t1, $t2
	beq3:sub $t2, $t2, $t1
	
#bne
	#offset < -1
	ori $t1, $0, 0
	ori $t2, $0, 2
	beq4: add $t1, $t2, $t1
	bne $t1, $t2, beq4
	nop
	#offset > -1
	bne $t1, $k0, beq5
	nop
	add $t2, $t1, $t2
	beq5:sub $t2, $t2, $t1
