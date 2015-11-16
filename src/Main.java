import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import antlr.*;

public class Main {

	  public static void main(String[] args) throws Exception {

		    // create a CharStream that reads from standard input
		    ANTLRInputStream input = new ANTLRInputStream(System.in);

		    // create a lexer that feeds off of input CharStream
		    WaccLexer lexer = new WaccLexer(input);

		    // create a buffer of tokens pulled from the lexer
		    CommonTokenStream tokens = new CommonTokenStream(lexer);

		    // create a parser that feeds off the tokens buffer
		    WaccParser parser = new WaccParser(tokens);

		    ParseTree tree = parser.program(); // begin parsing at program rule

		    // build and run my custom visitor
		    System.out.println("====");
		    MyWaccVisitor visitor = new MyWaccVisitor();
		    visitor.visit(tree);
		    System.out.println("====");
		    System.exit(0);
		  }
	
}
