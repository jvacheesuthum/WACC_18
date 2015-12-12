
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import backEnd.Instruction;

public class Optimise {

	public static List<Instruction> loadAndStore(List<Instruction> list, Map<String, Integer> currentStackMap, int stackTotal) {

		int prevRegCount = -1;
		String instrPart;
		boolean afterStr = false;
		List<Integer> indexToRemove = new LinkedList<Integer>();
		String variable = null;
		for(Instruction l : list) {
			if (l.toDeclare()) {
				stackTotal = l.allocateStackPos(stackTotal, currentStackMap);
			}
			int currRegCount;
			String first = l.getInstructions().get(0).getString();
			instrPart = first.substring(0, 3);
			try {
				currRegCount = Integer.parseInt(first.substring(5, 6));
			} catch (NumberFormatException e) {
				continue;
			} catch (StringIndexOutOfBoundsException e) {
				continue;
			}
			if(instrPart.equals("STR") && l.getVariables() != null) {
				prevRegCount = currRegCount;
				variable = l.getVariables().get(0).getVariable();
				afterStr = true;
			}
			if(instrPart.equals("LDR") && afterStr && prevRegCount == currRegCount && l.getVariables() != null) {
				if(l.getVariables().get(0).getVariable().equals(variable)) {
	//					indexToRemove.add(list.indexOf(l) - 1);
						indexToRemove.add(list.indexOf(l));
						prevRegCount = 0;
						variable = null;
				}
				
				afterStr = false;
			}

		}
		List<Instruction> tempList = new ArrayList<Instruction>();
		tempList.addAll(list);
		ListIterator<Integer> it = indexToRemove.listIterator(indexToRemove.size());
		Integer index;
		while(it.hasPrevious()) {
			index = it.previous();
			tempList.remove((int)index);
			it.remove();
		}
		return tempList;
	}
}
