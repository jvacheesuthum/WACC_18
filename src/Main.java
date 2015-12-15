import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

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

		    
		    
		    ParseTree tree = parser.program(); // begin parsing at program rule

		   
		    // build and run my custom visitor
		    
		    String filename = args[0].substring(args[0].lastIndexOf('/')+1, args[0].length()-5);
		    
		    if (filename.contains("printAllTypes")) {
	//	    	System.exit(0);
		    }
		    
		    
		    System.out.println("====");
		    //MyWaccVisitor visitor = new OptimisedWaccVisitor(filename + ".s");
		    MyWaccVisitor visitor = new MyWaccVisitor(filename + ".s");
		    visitor.visit(tree);
		    System.out.println("====");
		    System.exit(0);
		  }
	
}
