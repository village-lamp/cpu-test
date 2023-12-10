#mult
ori $t0, $0, 0x343
lui $t1, 0xf300
ori $t1, $t1, 0x3459
mult $t0, $t1
mfhi $s0
mflo $s1
#multu
multu $t0, $t1
mfhi $s0
mflo $s1