import SemanticAnalyser.*;
import antlr.WaccParser;
import antlr.WaccParserBaseVisitor;
import com.sun.istack.internal.NotNull;

import java.util.List;

public class MyWaccVisitor<T> extends WaccParserBaseVisitor<T> {
    SymbolTable currentTable = new SymbolTable(null);
    currentTable.add("int",new TYPE());


    @Override public T visitStat_stat(@NotNull WaccParser.Stat_statContext ctx) {
        //WaccParser.StatContext first = ctx.stat(0);  // assuming parameter 0 returns first stat
        //WaccParser.StatContext second = ctx.stat(1); // assuming parameter 1 return second stat
        //visit(first);
        //visit(second); //but we need to return

        //or
        //List<WaccParser.StatContext> stats = ctx.stat();
        //return visit(stats); // assuming visit can take in list

        //or
        return visitChildren(ctx);
    }

    @Override public T visitStat_assign(@NotNull WaccParser.Stat_assignContext ctx) {
        WaccParser.Assign_lhsContext lhs = ctx.assign_lhs();
        WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();

        // blah blah

    }

    @Override public T visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
        WaccParser.TypeContext type = ctx.type();
        WaccParser.IdentContext id  = ctx.ident();
        WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();

        DeclarationAST D = new DeclarationAST(currentTable);
        D.check();

        //check for assign because we in wacc we do declare and assign at the same time


    }

    @Override
    public T visitFunc(@NotNull WaccParser.FuncContext ctx) {
        return visitChildren(ctx);
    }
}