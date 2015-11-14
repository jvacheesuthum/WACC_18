package SemanticAnalyser;

/**
 * Created by vasin on 11/11/2015.
 */
public class DeclarationAST {
    String typename;
    String varname;
    VARIABLE varObj;

    SymbolTable ST;

    public DeclarationAST(SymbolTable ST){
        this.ST = ST;
    }

    public void check(){
        IDENTIFIER T = ST.lookup(typename);
        IDENTIFIER V = ST.lookup(varname);

        // all the checkings
        if (T == null) throw new Error("unknown type in declaration ast !!!!"); //assuming the symbol table returns null if lookup not found
        else if (!(T instanceof TYPE)) throw new Error("not type in declaration ast !!!!");
        else if (!(T.isDeclarable())) throw new Error("cannot declare object in declaration ast !!!!");
        else if (V != null) throw new Error("variable already declared in declaration ast !!!!"); // assuming the symbol table returns null if lookup not found
        else {
            VARIABLE varObj = new VARIABLE((TYPE) T);
            ST.add(varname, varObj);
        }
    }
}
