
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backEnd.Instruction;

public class Optimise {
	
	private static Map<Integer, Integer> memory = new HashMap<Integer, Integer>(); //Map<Memory position, value>
	private static Integer[] registers = new Integer[15]; //there are 15 reg?
	private static Integer offset = 0; //used for SUB sp, sp and ADD sp, sp to store the proper position of value in memory
	
	public static List<Instruction> loadAndStore(List<Instruction> list, Map<String, Integer> currentStackMap, int stackTotal) {
		List<Instruction> result = new ArrayList<Instruction>();
		result.addAll(list);
		String instrPart; // STR or LDR
		String variable = null; 
		for(Instruction l : list) {
			if (l.toDeclare()) {
				stackTotal = l.allocateStackPos(stackTotal, currentStackMap);
			} // needed whether or not is is to be optimised
			int currRegCount; //current Register no. to be compared with previous
			String first = l.getInstructions().get(0).getString(); //first whole instruction (e.g. LDR r4, =2 or STR r4, [sp)
			if (l.getVariables() != null) {
				variable = l.getVariables().get(0).getVariable();
			}
			if(first.charAt(0) == 'B' || first.contains("BEQ") || first.contains(":")) {//if branch or label, memory and register clear
				memory.clear();
				for(int i = 0; i < 15; i++) {
					registers[i] = null;
				}
			}
			if(first.contains("SUB sp, sp")) { //calculate the proper offset
				if(l.getVariables() != null) {
					variable = l.getVariables().get(0).getVariable();
					offset += currentStackMap.get(variable);
				} else {
					offset += Integer.parseInt(first.substring(13, 14));
				}
				continue;
			}
			if(first.contains("ADD sp, sp")) {//calculate the proper offset
				if(l.getVariables() != null) {
					variable = l.getVariables().get(0).getVariable();
					offset -= currentStackMap.get(variable);
				} else {
					offset -= Integer.parseInt(first.substring(13, first.length()-1));
				}
				continue;
			}
			if(first.contains("ADDS r")) { //need to calculate registers operations
				currRegCount = Integer.parseInt(first.substring(6, 7));
				Integer lhsReg = Integer.parseInt(first.substring(10, 11));
				Integer rhsReg = Integer.parseInt(first.substring(14, 15));
				if(registers[currRegCount] == null || registers[lhsReg] == null || registers[rhsReg] == null) {
					continue;
				}
				registers[currRegCount] = registers[lhsReg] + registers[rhsReg];
				continue;
			}
			if(first.contains("SUBS r")) {
				currRegCount = Integer.parseInt(first.substring(6, 7));
				Integer lhsReg = Integer.parseInt(first.substring(10, 11));
				Integer rhsReg = Integer.parseInt(first.substring(14, 15));
				if(registers[currRegCount] == null || registers[lhsReg] == null || registers[rhsReg] == null) {
					continue;
				}
				registers[currRegCount] = registers[lhsReg] - registers[rhsReg];
				continue;
			}
			
			instrPart = first.substring(0, 3); //getting the LDR or STR etc.
			try {
				currRegCount = Integer.parseInt(first.substring(5, 6)); //try to parse number after r (e.g r4 <--get the 4)
			} catch (NumberFormatException e) {
				continue;
			} catch (StringIndexOutOfBoundsException e) {
				continue;
			}

			if(instrPart.equals("STR")) {
				Integer value;
				if(first.charAt(9) == 'r') continue;
				if(l.getVariables() == null) {
					value = findOffset(l, 14);
				} else {
					variable = l.getVariables().get(0).getVariable();
					value = currentStackMap.get(variable);
				}
				Integer index = offset - value;
				if(registers[currRegCount] == null) continue; 
				if(memory.get(index) == null) { //if null then add to memory but if not, check to see if equal
					memory.put(index, registers[currRegCount]);
					continue;
				}
				if(memory.get(index).equals(registers[currRegCount])) {
					result.remove(l);
				} else {
					memory.put(index, registers[currRegCount]);
				}
			}
			if(instrPart.equals("LDR")) {
				Integer value;
				if(l.getVariables() == null) {
					try {
						value = Integer.parseInt(first.substring(9, first.length() - 1));//for =number case
					} catch (NumberFormatException e) {
						registers[currRegCount] = null;
						continue;
					}
				} else {
					variable = l.getVariables().get(0).getVariable();
					value = currentStackMap.get(variable);
				}
				if(value == null) continue;
				if(first.charAt(9) == 's') { //check if ldr r_, s <--- stack pointer
					value = memory.get(offset - value);
				}
				if(registers[currRegCount] == value) {
					result.remove(l);
				} else {
					registers[currRegCount] = value;
				}
			}
		}
		return result;
		
	}
	
	private static Integer findOffset(Instruction l, int pos) {
		Integer result;
		try {
			int sqrbrac = l.toString().indexOf(']');
			System.out.println("SUBSTRING: " + l.toString().substring(14, sqrbrac));
			result = Integer.parseInt(l.toString().substring(14, sqrbrac));
		} catch (NumberFormatException e) {
			System.out.println("RESULT: " + null);
			return null;
		} catch (StringIndexOutOfBoundsException e) {
			result = 0;
		}
		System.out.println("RESULT: " + result);
		return result;
	}
}
