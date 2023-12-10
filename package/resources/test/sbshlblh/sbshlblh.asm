#sb
ori $t0, 0x3420
ori $t1, 0xffff
sw $t1, 0($0)
sb $t0, 0($0)
sb $t0, 3($0)
#sh
sh $t1, 6($0)
#lb
lb $s0, 1($0)
lb $s1, 5($0)
#lh
lh $s2, 0($0)
