package backEnd;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by vasin on 05/12/2015.
 */
public class Instruction_Return extends Instruction{

    private int stackCountOffset = 0;

    public Instruction_Return(List<InstructionFragment> instructionFragments, VariableFragment total) {
        super(instructionFragments, total);
    }

    @Override
    public void varsToPos(Map<String, Integer> st, int willneverbeused) {
        // given stack map, gives a position string to all variables in this instruction
        VariableFragment v = variables.get(0);
        Integer varPosition = st.get(v.getVariable());
        stackCountOffset += varPosition;
        v.pointToStackPosition(stackCountOffset);
        variables = null;
    }

    public void addStackCount(Integer x){
        stackCountOffset += x;
    }

    @Override
    public String toString() {
        assert !toDeclare() && !needsVarPos() : "not a complete instruction!";
        if(stackCountOffset == 0) return "";

        String result = "";
        for (InstructionFragment instr : instructions) {
            result += instr.getString();
        }
        return result;
    }
}
