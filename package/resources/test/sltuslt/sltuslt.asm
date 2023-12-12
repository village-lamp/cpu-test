#sltu
lui $t0, 0x8000
lui $t1, 0x342f
sltu $s0, $t0, $t1
sltu $s1, $t1, $t0
#slt
lui $t0, 0x8000
slt $s0, $t0, $t1
slt $s1, $t1, $t0