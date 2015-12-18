import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import extension.BinopTreeReorder;
import extension.VariableVisitor;
import SemanticAnalyser.SyntaxErrorListener;
import antlr.*;

public class Main {

	  public static void main(String[] args) throws Exception {

		  	File file = new File(args[0]);
		  	String str = "";
		 
		  	BufferedReader br = new BufferedReader(new FileReader(file));
		  	try {
		  		StringBuilder sb = new StringBuilder();
		  		String line = br.readLine();
		  		
		  		while (line != null) {
		  			sb.append(line);
		  			sb.append("\n");
		  			line = br.readLine();
		  		}
		  		str = sb.toString();
		  	} finally {
		  		br.close();
		  	}
		  //System.out.println("FILE: " + str);
		  	

		  	
		    // create a CharStream that reads from standard input
		    ANTLRInputStream input = new ANTLRInputStream(str);

		    // create a lexer that feeds off of input CharStream
		    WaccLexer lexer = new WaccLexer(input);
		    lexer.removeErrorListeners();
		    lexer.addErrorListener(SyntaxErrorListener.INSTANCE);

		  	
		    
		    // create a buffer of tokens pulled from the lexer
		    CommonTokenStream tokens = new CommonTokenStream(lexer);

		    // create a parser that feeds off the tokens buffer
		    WaccParser parser = new WaccParser(tokens);
		    parser.removeErrorListeners();
		    parser.addErrorListener(SyntaxErrorListener.INSTANCE);

		    
		    String filename = args[0].substring(args[0].lastIndexOf('/')+1, args[0].length()-5);
		    
		    ParseTree tree = parser.program(); // begin parsing at program rule
		    // build and run my custom visitor
		    
		  	MyWaccVisitor visitor = new MyWaccVisitor(filename + ".s");
		    
		    //check optimisations
		    if (args.length > 1) {
		    	switch (args[1]) {
		    	case "-cEval": visitor = new OptimisedWaccVisitor(filename + ".s"); break;
		    	case "-cProp": detectConstantVars(tree);
		    					visitor = new OptimisedWaccVisitor(filename + ".s"); break;
		    	case "-cPBtr": detectConstantVars(tree); btr(tree);
		    					visitor = new OptimisedWaccVisitor(filename + ".s"); break;
		    	case "-CFA": visitor = new WaccVisitorWithCFA(filename + ".s"); break;
		    	// add here!
		    	case "-IE": Optimise.optimise = true; break;
		    	}
		    }

		    System.out.println("====");
		    visitor.visit(tree);
		    System.out.println("====");
		    System.exit(0);
		  }

	private static void btr(ParseTree tree) {
	    System.out.println("====Optimising 2 ====");
    	tree = new BinopTreeReorder().visit(tree).getCtx();
    	System.out.println("====Finished Second Pass====");
	}

	private static void detectConstantVars(ParseTree tree) {
	    System.out.println("====Optimising====");
	    tree = new VariableVisitor().visit(tree);
	    System.out.println("====Finished First Pass====");
	}
	
}
