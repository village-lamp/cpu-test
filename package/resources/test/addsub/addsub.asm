#addu
	# + +
		#small
		ori $t1, $0, 1
		ori $t2, $0, 2
		add $s0, $t1, $t2
		#huge
		lui $t1, 32767
		ori $t1, $t1, 65534
		lui $t2, 32766
		ori $t2, $t2, 54326
		add $s0, $t1, $t2
	# - -
		#small
		lui $t1, 65535
		ori $t1, $t1, 65535
		lui $t2, 65535
		ori $t2, $t2, 65534
		add $s0, $t1, $t2
		#huge
		lui $t1, 32768
		ori $t1, $t1, 0
		lui $t2, 32768
		ori $t2, $t2, 1
		add $s0, $t1, $t2
	# + -
		#huge
		lui $t1, 32768
		ori $t1, $t1, 0
		lui $t2, 32766
		ori $t2, $t2, 54326
		add $s0, $t1, $t2
		#small and huge
		lui $t1, 32768
		ori $t1, $t1, 0
		ori $t2, $0, 432
		add $s0, $t1, $t2
		
#sub
	# + +
		#small
		ori $t1, $0, 1
		ori $t2, $0, 2
		sub $s0, $t1, $t2
		#huge
		lui $t1, 32767
		ori $t1, $t1, 65534
		lui $t2, 32766
		ori $t2, $t2, 54326
		sub $s0, $t1, $t2
	# - -
		#small
		lui $t1, 65535
		ori $t1, $t1, 65535
		lui $t2, 65535
		ori $t2, $t2, 65534
		sub $s0, $t1, $t2
		#huge
		lui $t1, 32768
		ori $t1, $t1, 0
		lui $t1, 32768
		ori $t2, $t2, 1
		sub $s0, $t1, $t2
	# + -
		#huge
		lui $t1, 32768
		ori $t1, $t1, 0
		lui $t2, 32766
		ori $t2, $t1, 54326
		sub $s0, $t1, $t2
		#small and huge
		lui $t1, 32768
		ori $t1, $t1, 0
		ori $t2, $0, 432
		sub $s0, $t1, $t2
