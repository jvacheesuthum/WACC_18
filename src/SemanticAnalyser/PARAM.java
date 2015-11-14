package SemanticAnalyser;

/**
 * Created by vasin on 14/11/2015.
 */
public class PARAM extends IDENTIFIER {
    TYPE type;

    public PARAM(TYPE t) {
        type = t;
    }

    public TYPE TYPE(){
        return type;
    }
}
