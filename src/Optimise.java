
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import backEnd.Instruction;
import backEnd.PositionFragment;
import backEnd.VariableFragment;

public class Optimise {

	public static List<Instruction> loadAndStore(List<Instruction> list, Map<String, Integer> currentStackMap, int stackTotal) {
		String instrPart; // STR or LDR
		Integer[] registers = new Integer[15]; //there are 15 reg?
		Map<Integer, Integer> memory = new HashMap<Integer, Integer>(); //Map<Memory position, value>
		Integer offset = 0;
		
		List<Integer> indexToRemove = new LinkedList<Integer>(); // List for index in instrList to be removed
		String variable = null; //
		for(Instruction l : list) {
			if (l.toDeclare()) {
				stackTotal = l.allocateStackPos(stackTotal, currentStackMap);
			} // needed whether or not is is to be optimised
//			if (l.needsVarPos()) {
//				l.varsToPos(currentStackMap, 0);
//			}
			int currRegCount; //current Register no. to be compared with previous
			String first = l.getInstructions().get(0).getString(); //first whole instruction (e.g. LDR r4, =2 or STR r4, [sp)
			System.out.println("=============BEGIN==============");
			System.out.println("INSTRUCTION: " + l);
			System.out.println("FIRST: " + first);
			if (l.getVariables() != null) {
				variable = l.getVariables().get(0).getVariable();
				System.out.println("STR VARIABLE: " + variable);
				System.out.println("STR VARIABLE AFTER LOOKUP: " + currentStackMap.get(variable));
			}
//			if(first.contains(":")) {
////				afterStr = false;
//				continue;
//			} //if label, continue on next instruction
			if(first.contains("SUB sp, sp")) {
				if(l.getVariables() != null) {
					variable = l.getVariables().get(0).getVariable();
					offset += currentStackMap.get(variable);
				} else {
					offset += Integer.parseInt(first.substring(13, 14));
				}
				System.out.println("OFFSET: " + offset);
				System.out.println("=============END==============");
				continue;
			}
			if(first.contains("ADD sp, sp")) {
				Integer prevOffset = offset;
				if(l.getVariables() != null) {
					variable = l.getVariables().get(0).getVariable();
					offset -= currentStackMap.get(variable);
				} else {
					offset -= Integer.parseInt(first.substring(13, 14));
				}
				memory = clear(prevOffset, offset, memory);
				System.out.println("OFFSET: " + offset);
				System.out.println("=============END==============");
				continue;
			}
			
			instrPart = first.substring(0, 3); //getting the LDR or STR etc.
			System.out.println("instrPart: " + instrPart);
			try {
				currRegCount = Integer.parseInt(first.substring(5, 6)); //try to parse number after r (e.g r4 <--get the 4)
			} catch (NumberFormatException e) {
//				count++;
				System.out.println("=============END==============");
				continue;
			} catch (StringIndexOutOfBoundsException e) {
//				count++;
				System.out.println("=============END==============");
				continue;
			}

			if(instrPart.equals("STR")) {
				System.out.println("IN STR");
//				prevRegCount = currRegCount;
//				variable = l.getVariables().get(0).getVariable();
//				System.out.println("STR VARIABLE: " + variable);
//				afterStr = true;
				Integer value;
				if(l.getVariables() == null) {
					value = findOffset(l, 14);
//					if(value == null)
				} else {
					variable = l.getVariables().get(0).getVariable();
					value = currentStackMap.get(variable);
				}
				Integer index = offset - value;
				System.out.println("STR index: " + index);
				if(memory.get(index) == null) {
					memory.put(index, registers[currRegCount]);
					System.out.println("MEMORY print: " + memory);
					continue;
				}
				if(memory.get(index).equals(registers[currRegCount])) {
					indexToRemove.add(list.indexOf(l));
				} else {
					memory.put(index, registers[currRegCount]);
					System.out.println("REGISTER R: " + registers[currRegCount]);
				}
				System.out.println("MEMORY print: " + memory);
			}
			if(instrPart.equals("LDR")/* && afterStr && prevRegCount == currRegCount*/) {
				System.out.println("IN LDR");
				Integer value;
				if(l.getVariables() == null) {
					try {
						System.out.println("SUBSTRING: " + first.substring(9, first.length()));
						 value = Integer.parseInt(first.substring(9, first.length() - 1));//for =number case
					} catch (NumberFormatException e) {
						continue;
					}
				} else {
					variable = l.getVariables().get(0).getVariable();
					value = currentStackMap.get(variable);
				}
				System.out.println("VALUE BEFORE: " + value);
				System.out.println("OFFSET: " + offset);
				if(first.charAt(9) == 's') {
					value = memory.get(offset - value);
				}
				System.out.println("REG VALUE: " + registers[currRegCount]);
				System.out.println("VALUE AFTER: " + value);
				if(registers[currRegCount] == value) {
					indexToRemove.add(list.indexOf(l));
				} else {
					registers[currRegCount] = value;
				}
			}
//			count++;
			System.out.println("=============END==============");
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
	
	private static Integer findOffset(Instruction l, int pos) {
		Integer result;
		try {
			System.out.println("SUBSTRING: " + l.toString().substring(14, l.toString().length() - 2));
			result = Integer.parseInt(l.toString().substring(14, l.toString().length() - 2));
		} catch (NumberFormatException e) {
			System.out.println("RESULT: " + null);
			return null;
		} catch (StringIndexOutOfBoundsException e) {
			result = 0;
		}
		System.out.println("RESULT: " + result);
		return result;
	}

	private static Map<Integer, Integer> clear(Integer prevOffset, Integer offset, Map<Integer, Integer> memory) {
		System.out.println("CLEAR prevoffset: " + prevOffset);
		System.out.println("CLEAR offset: " + offset);
		System.out.println("CLEAR memory before: " + memory);
		Integer count = prevOffset;
		Map<Integer, Integer> clearedMem = new HashMap<Integer, Integer>();
		clearedMem.putAll(memory);
		while(count > offset) {
			clearedMem.remove(count);
			count--;
		}
		System.out.println("CLEAR memory after: " + clearedMem);
		return clearedMem;
	}
}
