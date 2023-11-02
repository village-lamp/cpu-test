package org.data_generator.generator;

import org.Constant;
import org.data_generator.Manager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * beq指令生成器类
 */
public class BeqGenerator extends Generator implements Constant {

    @Override
    public void generate(ArrayList<Integer> list) {
        int rs = randReg();
        int rt = randReg();
        if (Manager.getBeqs() >= 12) {
            int i = 0;
        }
        int label = randInt(Manager.getLastBeq(), Manager.getMax() - 1);
        int lines = ((label - PC_BEGIN) >> 2) - 1;
        while (label < Manager.getPc() &&
                Manager.getCode().get(lines).matches(".*[lw].*")) {
            label += 4;
            ++lines;
        }
        if (label == Manager.getPc()) {
            label += 4;
            ++lines;
        }
        if (label < Manager.getPc()) {
            Manager.getCode().add(lines, String.format("ori $%d, $%d, %d",
                    getCounter(), getCounter(), MAX_LOOP));
            Manager.putAddBeqLabel(lines + 1, Manager.getBeqs() + 1);
            Manager.putAddBeqLabel((Manager.getPc() + 16 - PC_BEGIN) >> 2, Manager.getBeqs());
            SubGenerator subGenerator = new SubGenerator();
            subGenerator.generate(new ArrayList<>(Arrays.asList(getCounter(), 30, getCounter())));
            Manager.getCode().add(String.format("beq $%d, $0, beq", getCounter()) + Manager.getBeqs());
            Manager.addBeqs();
            Manager.setPc(Manager.getPc() + 8);
        } else {
            Manager.putAddBeqLabel(lines, Manager.getBeqs());
        }
        Manager.getCode().add(String.format("beq $%d, $%d, beq", rs, rt) + Manager.getBeqs());
        Manager.addBeqs();
        Manager.setPc(Manager.getPc() + 4);
        Manager.setLastBeq(Manager.getPc());
    }
}
