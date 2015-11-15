package SemanticAnalyser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasin on 14/11/2015.
 */
public class FUNCTION extends IDENTIFIER {
    public TYPE returntype;
    public List<PARAM> formals = new ArrayList<PARAM>();
    public SymbolTable symtab;

    public FUNCTION(TYPE returntype){
        this.returntype = returntype;
    }
    
}
