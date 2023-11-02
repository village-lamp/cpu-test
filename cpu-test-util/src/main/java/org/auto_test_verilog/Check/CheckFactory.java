package org.auto_test_verilog.Check;

public class CheckFactory {

    public Check create(String type) {
        switch (type) {
            case "add":
                return new AddCheck();
            case "sub":
                return new SubCheck();
            case "ori":
                return new OriCheck();
            case "lw":
                return new LwCheck();
            case "sw":
                return new SwCheck();
            case "lui":
                return new LuiCheck();
            case "beq":
                return new BeqCheck();
            case "jal":
                return new JalCheck();
            case "jr":
                return new JrCheck();
            case "nop":
                return new NopCheck();
        }
        return null;
    }
}
