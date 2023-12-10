package org.check.syscall_checker;

import org.check.Checker;
import org.mips.Mips;

public class SyscallChecker extends Checker {

    @Override
    public String check(String code, Mips mips) {
        return "ExcCode:8";
    }
}
