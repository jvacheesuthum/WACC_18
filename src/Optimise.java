
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
	
	private static Map<Integer, Integer> memory = new HashMap<Integer, Integer>(); //Map<Memory position, value>
	private static Integer[] registers = new Integer[15]; //there are 15 reg?
	private static Integer offset = 0;
	
	public static List<Instruction> optimiseInstructions(List<Instruction> list, Map<String, Integer> currentStackMap, int stackTotal) {
		List<List<Instruction>> sections = new ArrayList<List<Instruction>>();
		List<Instruction> result = new ArrayList<Instruction>();
		int fromIndex = 0;
		for(Instruction l : list) {
			if(l.toString().contains(":")) {
				List<Instruction> section = list.subList(fromIndex, list.indexOf(l));
				sections.add(section);
				fromIndex = list.indexOf(l);
			}
			if(l.toString().contains(".ltorg")) {
				List<Instruction> section = list.subList(fromIndex, list.indexOf(l) + 1);
				sections.add(section);
			}
		}
		
		List<Instruction> main = sections.remove(1);
		sections.add(main);
		for(int i = sections.size() - 1; i > 0; i--) {
			main = sections.get(i);
			main = loadAndStore(main, currentStackMap, stackTotal);
			memory.clear();
			result.addAll(main);
		}
		return result;
	}
	public static List<Instruction> loadAndStore(List<Instruction> list, Map<String, Integer> currentStackMap, int stackTotal) {
		List<Instruction> result = new ArrayList<Instruction>();
		result.addAll(list);
		String instrPart; // STR or LDR
		String variable = null; //
		for(Instruction l : list) {
			System.out.print("Registers: [");
			for(int i = 0; i < 15; i++) {
				System.out.print(registers[i] + ", ");
			}
			System.out.print("]\n");
			System.out.println("Memory: " + memory);
			if (l.toDeclare()) {
				stackTotal = l.allocateStackPos(stackTotal, currentStackMap);
			} // needed whether or not is is to be optimised
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
			if(first.charAt(0) == 'B' || first.contains("BEQ")) {
				memory.clear();
			}
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
					offset -= Integer.parseInt(first.substring(13, first.length()-1));
				}
				System.out.println("PREVOFFSET BEFORE CLEAR: " + prevOffset);
				System.out.println("OFFSET BEFORE CLEAR: " + offset);
//				memory = clear(prevOffset, offset, memory);
				System.out.println("OFFSET: " + offset);
				System.out.println("=============END==============");
				continue;
			}
			if(first.contains("ADDS r")) {
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

				Integer value;
				if(l.getVariables() == null) {
					value = findOffset(l, 14);
				} else {
					variable = l.getVariables().get(0).getVariable();
					value = currentStackMap.get(variable);
				}
				System.out.println("OFFSET IN STR: " + offset);
				System.out.println("VALUE IN STR: " + value);
				Integer index = offset - value;
				System.out.println("STR index: " + index);
				if(memory.get(index) == null) {
					memory.put(index, registers[currRegCount]);
					System.out.println("MEMORY print: " + memory);
					continue;
				}
				if(registers[currRegCount] == null) continue;
				if(memory.get(index).equals(registers[currRegCount])) {
					result.remove(l);
				} else {
					memory.put(index, registers[currRegCount]);
					System.out.println("REGISTER R: " + registers[currRegCount]);
				}
				System.out.println("MEMORY print: " + memory);
			}
			if(instrPart.equals("LDR")) {
				System.out.println("IN LDR");
				Integer value;
				if(l.getVariables() == null) {
					try {
						System.out.println("SUBSTRING: " + first.substring(9, first.length()));
						value = Integer.parseInt(first.substring(9, first.length() - 1));//for =number case
					} catch (NumberFormatException e) {
						registers[currRegCount] = null;
						continue;
					}
				} else {
					variable = l.getVariables().get(0).getVariable();
					value = currentStackMap.get(variable);
				}
				System.out.println("VALUE BEFORE: " + value);
				System.out.println("OFFSET: " + offset);
				if(first.charAt(9) == 's') {
//					if(value == 0) continue;
					value = memory.get(offset - value);
				}
				if(value == null) continue;
				System.out.println("REG VALUE: " + registers[currRegCount]);
				System.out.println("VALUE AFTER: " + value);
				if(registers[currRegCount] == value /*&& (registers[currRegCount] != null || value != null)*/) {
					result.remove(l);
				} else {
					registers[currRegCount] = value;
				}
			}
			System.out.println("=============END==============");
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
