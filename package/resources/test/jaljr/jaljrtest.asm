#jal & jr
	ori $s0, $0, 0
	jal jal1
	nop
	add $s0, $ra, $0
	ori $t0, $0, 20
	add $s0, $s0, $t0
	jal jal2
	nop
	beq $0, $0, end
	nop
	
	jal1:
	ori $s0, $0, 1
	jr $ra
	nop
	
	jal2:
	jr $s0
	nop
	
	end:
