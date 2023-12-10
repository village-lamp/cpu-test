mfc0 $k1, $13
ori $k0, $0, 1
sw $k0, 32512($0)
nop
sw $0, 32512($0)
sw $k0, 32528($0)
nop
sw $0, 32528($0)
sb $0, 32544($0)
mfc0 $k0, $12
and $k1, $k0, $k1
andi $k0, $k1, 4096
bne $k0, $0, start
nop
andi $k1, $k1, 3072
bne $k1, $0, end
start: mfc0 $k0, $14
addi $k0, $k0, 4
end: mtc0 $k0, $14
eret