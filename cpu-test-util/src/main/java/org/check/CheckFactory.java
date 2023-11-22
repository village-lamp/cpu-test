package org.check;

import com.sun.org.apache.xpath.internal.operations.Div;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.check.LoadChecker.LbChecker;
import org.check.LoadChecker.LhChecker;
import org.check.LoadChecker.LwChecker;
import org.check.br_r2_checker.BeqChecker;
import org.check.br_r2_checker.BneChecker;
import org.check.cal_ri_checker.AddiChecker;
import org.check.cal_ri_checker.AndiChecker;
import org.check.cal_ri_checker.OriChecker;
import org.check.cal_rr_checker.*;
import org.check.jal_checker.JalChecker;
import org.check.jr_checker.JrChecker;
import org.check.lui_checker.LuiChecker;
import org.check.mul_div_checker.DivChecker;
import org.check.mul_div_checker.DivuChecker;
import org.check.mul_div_checker.MultChecker;
import org.check.mul_div_checker.MultuChecker;
import org.check.mv_fr_checker.MfhiChecker;
import org.check.mv_fr_checker.MfloChecker;
import org.check.mv_to_checker.MthiChecker;
import org.check.mv_to_checker.MtloChecker;
import org.check.nop_checker.NopChecker;
import org.check.store_checker.SbChecker;
import org.check.store_checker.ShChecker;
import org.check.store_checker.SwChecker;

/**
 * check简单工厂类
 */
public class CheckFactory {

    public Checker create(String type) {
        switch (type) {
            case "add":
                return new AddChecker();
            case "sub":
                return new SubChecker();
            case "and":
                return new AndChecker();
            case "or":
                return new OrChecker();
            case "slt":
                return new SltChecker();
            case "sltu":
                return new SltuChecker();
            case "ori":
                return new OriChecker();
            case "addi":
                return new AddiChecker();
            case "andi":
                return new AndiChecker();
            case "lw":
                return new LwChecker();
            case "lh":
                return new LhChecker();
            case "lb":
                return new LbChecker();
            case "sw":
                return new SwChecker();
            case "sh":
                return new ShChecker();
            case "sb":
                return new SbChecker();
            case "lui":
                return new LuiChecker();
            case "beq":
                return new BeqChecker();
            case "bne":
                return new BneChecker();
            case "jal":
                return new JalChecker();
            case "jr":
                return new JrChecker();
            case "mult":
                return new MultChecker();
            case "multu":
                return new MultuChecker();
            case "div":
                return new DivChecker();
            case "divu":
                return new DivuChecker();
            case "mflo":
                return new MfloChecker();
            case "mfhi":
                return new MfhiChecker();
            case "mtlo":
                return new MtloChecker();
            case "mthi":
                return new MthiChecker();
            case "nop":
                return new NopChecker();
        }
        return null;
    }
}
