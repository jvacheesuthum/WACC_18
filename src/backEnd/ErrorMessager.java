package backEnd;

import java.util.List;

public class ErrorMessager {
	
	// if you need an error message or something in the header or footer that may be used more than once, add it here
	// make a boolean switch to turn it on
	// make a method to turn the boolean switch, and its dependencies. such as runtime error and pstring if your error uses these.
	
	private boolean pString = false;
	private boolean pLn = false;
	private boolean pChar = false;
	private boolean pNull = false;
	private boolean pReadInt = false;
	private boolean pArray = false;
	private boolean pPrintInt = false;
	private boolean pPair = false;
	private boolean pOverflow = false;
	private boolean pRuntime = false;
	private boolean pDivZero = false;
	
	private int headerindex = 0;
	
	public void pOverflow() {
		pOverflow = true;
		pRuntime = true;
		pString = true;
	}
	
	public void pDivZero() {
		pDivZero = true;
		pRuntime = true;
		pString = true;
	}
	
	public void pArray(){
		pArray = true;
		pRuntime = true;
		pString = true;
	}
	
	public void pFreepair(){
		pPair = true;
		pRuntime = true;
	}
	
	public void addErrorMessages(List<Instruction> header, List<Instruction> footer) {
		if (pString) {
			footer.add(new Instruction("p_print_string:\nPUSH {lr}\nLDR r1, [r0]\nADD r2, r0, #4\nLDR r0, =msg_0\nADD r0, r0, #4\nBL printf\nMOV r0, #0\nBL fflush\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_0:\n.word 5\n.ascii	\"%.*s\\0\"\n"));
			headerindex ++;
		}
		if (pLn) {
			footer.add(new Instruction("p_print_ln:\nPUSH {lr}\nLDR r0, =msg_1\nADD r0, r0, #4\nBL puts\nMOV r0, #0\nBL fflush\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_1:\n.word 1\n.ascii	\"\\0\"\n"));
			headerindex ++;
		}
		if (pChar) {
			footer.add(new Instruction("p_read_char:\nPUSH {lr}\nMOV r1, r0\nLDR r0, =msg_2\nADD r0, r0, #4\nBL scanf\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_2:\n.word 4\n.ascii	\" %c\\0\"\n"));
			headerindex ++;
		}
		if (pNull) {
			footer.add(new Instruction("p_check_null_pointer:\nPUSH {lr}\nCMP r0, #0\nLDREQ r0, =msg_3\nBLEQ p_throw_runtime_error\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_3:\n.word 50\n.ascii	\"NullReferenceError: dereference a null reference\\n\\0\"\n"));
			headerindex ++;
		}
		if (pReadInt) {
			footer.add(new Instruction("p_read_int:\nPUSH {lr}\nMOV r1, r0\nLDR r0, =msg_4\nADD r0, r0, #4\nBL scanf\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_4:\n.word 3\n.ascii	\"%d\\0\"\n"));
			headerindex ++;
		}
		if (pArray) {
			footer.add(new Instruction("p_check_array_bounds:\nPUSH {lr}\nCMP r0, #0\nLDRLT r0, =msg_5\nBLLT p_throw_runtime_error\nLDR r1, [r1]\nCMP r0, r1\nLDRCS r0, =msg_6\nBLCS p_throw_runtime_error\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_5:\n.word 44\n.ascii	\"ArrayIndexOutOfBoundsError: negative index\\n\\0\"\n"));
			header.add(headerindex, new Instruction("msg_6:\n.word 45\n.ascii	\"ArrayIndexOutOfBoundsError: index too large\\n\\0\"\n"));
			headerindex ++;
		}
		if (pPrintInt) {
			footer.add(new Instruction("p_print_int:\nPUSH {lr}\nMOV r1, r0\nLDR r0, =msg_7\nADD r0, r0, #4\nBL printf\nMOV r0, #0\nBL fflush\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_7:\n.word 3\n.ascii	\"%d\\0\"\n"));
			headerindex ++;
		}
		if (pPair) {
			footer.add(new Instruction("p_free_pair:\nPUSH {lr}\nCMP r0, #0\nLDREQ r0, =msg_8\nBEQ p_throw_runtime_error\nPUSH {r0}\nLDR r0, [r0]\nBL free\nLDR r0, [sp]\nLDR r0, [r0, #4]\nBL free\nPOP {r0}\nBL free\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_8:.word 50\n.ascii	\"NullReferenceError: dereference a null reference\\n\\0\"\n"));
			headerindex ++;
		}
		if (pOverflow) {
			footer.add(new Instruction("p_throw_overflow_error:\nLDR r0, =msg_9\nBL p_throw_runtime_error\n"));
			header.add(headerindex, new Instruction("msg_9:\n.word 82\n.ascii	\"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"\n"));
			headerindex ++;
		}
		if (pRuntime) {
			footer.add(new Instruction("p_throw_runtime_error:\nBL p_print_string\nMOV r0, #-1\nBL exit\n"));
		}
		if (pDivZero) {
			footer.add(new Instruction("p_check_divide_by_zero:\nPUSH {lr}\nCMP r1, #0\nLDREQ r0, =msg_10\nBLEQ p_throw_runtime_error\nPOP {pc}\n"));
			header.add(headerindex, new Instruction("msg_10:\n.word 45\n.ascii	\"DivideByZeroError: divide or modulo by zero\\n\\0\"\n"));
			headerindex ++;
		}
	}

}
