#sw
	#base = 0
	lui $t1, 65234
	ori $t1, $t1, 4324
	sw $t1, 44($0)
	#offset < 0
	lui $t1, 13523
	ori $t1, $t1, 94
	ori $t2, $0, 52
	sw $t1, -4($t2)
	
#lw
	#base = 0
	lw $t1, 48($0)
	#offset < 0
	ori $t2, $0, 48
	lw $t2, -4($t2)
