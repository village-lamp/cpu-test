#and
#huge
lui $t0, 0xfd03
ori $t0, $t0, 0x349f
lui $t1, 0x7fd3
ori $t1, $t1, 0x0000
and $s0, $t0, $t1
#small
ori $t0, $0, 0x43
ori $t1, $0, 0x1f30
and $s0, $t0, $t1
#zero
and $0, $t0, $t1

#or
#huge
lui $t0, 0xfd03
ori $t0, $t0, 0x349f
lui $t1, 0x7fd3
ori $t1, $t1, 0x0000
or $s0, $t0, $t1
#small
ori $t0, $0, 0x43
ori $t1, $0, 0x1f30
or $s0, $t0, $t1
#zero
or $0, $t0, $t1