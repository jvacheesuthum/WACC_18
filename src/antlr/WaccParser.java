// Generated from ./WaccParser.g4 by ANTLR 4.4
package antlr;

  import SemanticAnalyser.*;
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WaccParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=1, TRUE=2, FALSE=3, MULTIPLY=4, DIVIDE=5, MOD=6, PLUS=7, MINUS=8, 
		GREATER=9, GREATER_EQUAL=10, LESS=11, LESS_EQUAL=12, IS_EQUAL=13, NOT_EQUAL=14, 
		AND=15, OR=16, NOT=17, LEN=18, ORD=19, CHR=20, OPEN_PARENTHESES=21, CLOSE_PARENTHESES=22, 
		OPEN_SQUARE_BRACKET=23, CLOSE_SQUARE_BRACKET=24, SINGLE_QUOTATION=25, 
		DOUBLE_QUOTATION=26, PAIR=27, FST=28, SND=29, NEWPAIR=30, INT=31, BOOL=32, 
		CHAR=33, STRING=34, CALL=35, SKIP=36, EQUAL_ASSIGN=37, READ=38, FREE=39, 
		RETURN=40, EXIT=41, PRINT=42, PRINTLN=43, IF=44, THEN=45, ELSE=46, FI=47, 
		WHILE=48, DO=49, DONE=50, BEGIN=51, END=52, SEMI_COLON=53, IS=54, INTEGER=55, 
		VARIABLE=56, WS=57, ESCAPED_CHAR=58, COMMENT=59, NUL=60, BS=61, HT=62, 
		LF=63, FF=64, CR=65, EMPTY=66, BACK_SLASH=67, CHARACTER=68, STR=69;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'true'", "'false'", "'*'", "'/'", "'%'", "'+'", "'-'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", 
		"'ord'", "'chr'", "'('", "')'", "'['", "']'", "'''", "'\"'", "'pair'", 
		"'fst'", "'snd'", "'newpair'", "'int'", "'bool'", "'char'", "'string'", 
		"'call'", "'skip'", "'='", "'read'", "'free'", "'return'", "'exit'", "'print'", 
		"'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", 
		"'begin'", "'end'", "';'", "'is'", "INTEGER", "VARIABLE", "WS", "ESCAPED_CHAR", 
		"COMMENT", "NUL", "'\b'", "'\t'", "'\n'", "'\f'", "'\r'", "EMPTY", "'\\'", 
		"CHARACTER", "STR"
	};
	public static final int
		RULE_ident = 0, RULE_pair_liter = 1, RULE_array_liter = 2, RULE_str_liter = 3, 
		RULE_char_liter = 4, RULE_bool_liter = 5, RULE_int_sign = 6, RULE_int_liter = 7, 
		RULE_array_elem = 8, RULE_binary_oper = 9, RULE_unary_oper = 10, RULE_expr = 11, 
		RULE_pair_elem_type = 12, RULE_pair_type = 13, RULE_array_type = 14, RULE_base_type = 15, 
		RULE_type = 16, RULE_pair_elem = 17, RULE_arg_list = 18, RULE_assign_rhs = 19, 
		RULE_assign_lhs = 20, RULE_stat = 21, RULE_param = 22, RULE_param_list = 23, 
		RULE_func = 24, RULE_program = 25;
	public static final String[] ruleNames = {
		"ident", "pair_liter", "array_liter", "str_liter", "char_liter", "bool_liter", 
		"int_sign", "int_liter", "array_elem", "binary_oper", "unary_oper", "expr", 
		"pair_elem_type", "pair_type", "array_type", "base_type", "type", "pair_elem", 
		"arg_list", "assign_rhs", "assign_lhs", "stat", "param", "param_list", 
		"func", "program"
	};

	@Override
	public String getGrammarFileName() { return "WaccParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WaccParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class IdentContext extends ParserRuleContext {
		public TYPE typename;
		public TerminalNode VARIABLE() { return getToken(WaccParser.VARIABLE, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); match(VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_literContext extends ParserRuleContext {
		public TerminalNode NUL() { return getToken(WaccParser.NUL, 0); }
		public Pair_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_literContext pair_liter() throws RecognitionException {
		Pair_literContext _localctx = new Pair_literContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pair_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); match(NUL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_literContext extends ParserRuleContext {
		public TYPE typename;
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WaccParser.OPEN_SQUARE_BRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WaccParser.CLOSE_SQUARE_BRACKET, 0); }
		public Array_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literContext array_liter() throws RecognitionException {
		Array_literContext _localctx = new Array_literContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(OPEN_SQUARE_BRACKET);
			{
			setState(57); expr(0);
			setState(60);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(58); match(COMMA);
				setState(59); expr(0);
				}
			}

			}
			setState(62); match(CLOSE_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Str_literContext extends ParserRuleContext {
		public TerminalNode STR() { return getToken(WaccParser.STR, 0); }
		public Str_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStr_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Str_literContext str_liter() throws RecognitionException {
		Str_literContext _localctx = new Str_literContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_str_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(STR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(WaccParser.CHARACTER, 0); }
		public Char_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitChar_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literContext char_liter() throws RecognitionException {
		Char_literContext _localctx = new Char_literContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_char_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_literContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(WaccParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(WaccParser.FALSE, 0); }
		public Bool_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBool_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literContext bool_liter() throws RecognitionException {
		Bool_literContext _localctx = new Bool_literContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_signContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public Int_signContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_sign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitInt_sign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_signContext int_sign() throws RecognitionException {
		Int_signContext _localctx = new Int_signContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_int_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literContext extends ParserRuleContext {
		public TerminalNode INTEGER(int i) {
			return getToken(WaccParser.INTEGER, i);
		}
		public Int_signContext int_sign() {
			return getRuleContext(Int_signContext.class,0);
		}
		public List<TerminalNode> INTEGER() { return getTokens(WaccParser.INTEGER); }
		public Int_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitInt_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literContext int_liter() throws RecognitionException {
		Int_literContext _localctx = new Int_literContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_int_liter);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(72); int_sign();
				}
			}

			setState(76); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(75); match(INTEGER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(78); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_elemContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_SQUARE_BRACKET() { return getTokens(WaccParser.OPEN_SQUARE_BRACKET); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET(int i) {
			return getToken(WaccParser.CLOSE_SQUARE_BRACKET, i);
		}
		public TerminalNode OPEN_SQUARE_BRACKET(int i) {
			return getToken(WaccParser.OPEN_SQUARE_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_SQUARE_BRACKET() { return getTokens(WaccParser.CLOSE_SQUARE_BRACKET); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Array_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_elemContext array_elem() throws RecognitionException {
		Array_elemContext _localctx = new Array_elemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80); ident();
			setState(85); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(81); match(OPEN_SQUARE_BRACKET);
					setState(82); expr(0);
					setState(83); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(87); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_operContext extends ParserRuleContext {
		public TYPE argtype;
		public TYPE returntype;
		public Binary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_oper; }
	 
		public Binary_operContext() { }
		public void copyFrom(Binary_operContext ctx) {
			super.copyFrom(ctx);
			this.argtype = ctx.argtype;
			this.returntype = ctx.returntype;
		}
	}
	public static class Bin_logicContext extends Binary_operContext {
		public TerminalNode AND() { return getToken(WaccParser.AND, 0); }
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public Bin_logicContext(Binary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBin_logic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bin_boolContext extends Binary_operContext {
		public TerminalNode IS_EQUAL() { return getToken(WaccParser.IS_EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(WaccParser.NOT_EQUAL, 0); }
		public Bin_boolContext(Binary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBin_bool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bin_compareContext extends Binary_operContext {
		public TerminalNode GREATER_EQUAL() { return getToken(WaccParser.GREATER_EQUAL, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(WaccParser.LESS_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(WaccParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(WaccParser.GREATER, 0); }
		public Bin_compareContext(Binary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBin_compare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bin_mathContext extends Binary_operContext {
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(WaccParser.MULTIPLY, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode DIVIDE() { return getToken(WaccParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
		public Bin_mathContext(Binary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBin_math(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operContext binary_oper() throws RecognitionException {
		Binary_operContext _localctx = new Binary_operContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binary_oper);
		try {
			setState(102);
			switch (_input.LA(1)) {
			case MULTIPLY:
				_localctx = new Bin_mathContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89); match(MULTIPLY);
				}
				break;
			case DIVIDE:
				_localctx = new Bin_mathContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90); match(DIVIDE);
				}
				break;
			case MOD:
				_localctx = new Bin_mathContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(91); match(MOD);
				}
				break;
			case PLUS:
				_localctx = new Bin_mathContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92); match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new Bin_mathContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(93); match(MINUS);
				}
				break;
			case GREATER:
				_localctx = new Bin_compareContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94); match(GREATER);
				}
				break;
			case GREATER_EQUAL:
				_localctx = new Bin_compareContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(95); match(GREATER_EQUAL);
				}
				break;
			case LESS:
				_localctx = new Bin_compareContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(96); match(LESS);
				}
				break;
			case LESS_EQUAL:
				_localctx = new Bin_compareContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(97); match(LESS_EQUAL);
				}
				break;
			case IS_EQUAL:
				_localctx = new Bin_boolContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(98); match(IS_EQUAL);
				}
				break;
			case NOT_EQUAL:
				_localctx = new Bin_boolContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(99); match(NOT_EQUAL);
				}
				break;
			case AND:
				_localctx = new Bin_logicContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(100); match(AND);
				}
				break;
			case OR:
				_localctx = new Bin_logicContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(101); match(OR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operContext extends ParserRuleContext {
		public TYPE argtype;
		public TYPE returntype;
		public Unary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_oper; }
	 
		public Unary_operContext() { }
		public void copyFrom(Unary_operContext ctx) {
			super.copyFrom(ctx);
			this.argtype = ctx.argtype;
			this.returntype = ctx.returntype;
		}
	}
	public static class Unary_minusContext extends Unary_operContext {
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public Unary_minusContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnary_minus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_notContext extends Unary_operContext {
		public TerminalNode NOT() { return getToken(WaccParser.NOT, 0); }
		public Unary_notContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnary_not(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_ordContext extends Unary_operContext {
		public TerminalNode ORD() { return getToken(WaccParser.ORD, 0); }
		public Unary_ordContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnary_ord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_chrContext extends Unary_operContext {
		public TerminalNode CHR() { return getToken(WaccParser.CHR, 0); }
		public Unary_chrContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnary_chr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_lenContext extends Unary_operContext {
		public TerminalNode LEN() { return getToken(WaccParser.LEN, 0); }
		public Unary_lenContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnary_len(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operContext unary_oper() throws RecognitionException {
		Unary_operContext _localctx = new Unary_operContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unary_oper);
		try {
			setState(109);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new Unary_notContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104); match(NOT);
				}
				break;
			case MINUS:
				_localctx = new Unary_minusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105); match(MINUS);
				}
				break;
			case LEN:
				_localctx = new Unary_lenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106); match(LEN);
				}
				break;
			case ORD:
				_localctx = new Unary_ordContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107); match(ORD);
				}
				break;
			case CHR:
				_localctx = new Unary_chrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(108); match(CHR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TYPE typename;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Expr_bracketsContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public Expr_bracketsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_brackets(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_intContext extends ExprContext {
		public Int_literContext int_liter() {
			return getRuleContext(Int_literContext.class,0);
		}
		public Expr_intContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_int(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_array_elemContext extends ExprContext {
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public Expr_array_elemContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_array_elem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_binaryContext extends ExprContext {
		public Binary_operContext binary_oper() {
			return getRuleContext(Binary_operContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_binaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_binary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_unaryContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_operContext unary_oper() {
			return getRuleContext(Unary_operContext.class,0);
		}
		public Expr_unaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_charContext extends ExprContext {
		public Char_literContext char_liter() {
			return getRuleContext(Char_literContext.class,0);
		}
		public Expr_charContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_char(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_strContext extends ExprContext {
		public Str_literContext str_liter() {
			return getRuleContext(Str_literContext.class,0);
		}
		public Expr_strContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_str(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_pairContext extends ExprContext {
		public Pair_literContext pair_liter() {
			return getRuleContext(Pair_literContext.class,0);
		}
		public Expr_pairContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_pair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_boolContext extends ExprContext {
		public Bool_literContext bool_liter() {
			return getRuleContext(Bool_literContext.class,0);
		}
		public Expr_boolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_identContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Expr_identContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_unaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(112); unary_oper();
				setState(113); expr(3);
				}
				break;
			case 2:
				{
				_localctx = new Expr_intContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115); int_liter();
				}
				break;
			case 3:
				{
				_localctx = new Expr_boolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116); bool_liter();
				}
				break;
			case 4:
				{
				_localctx = new Expr_charContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117); char_liter();
				}
				break;
			case 5:
				{
				_localctx = new Expr_strContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118); str_liter();
				}
				break;
			case 6:
				{
				_localctx = new Expr_pairContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119); pair_liter();
				}
				break;
			case 7:
				{
				_localctx = new Expr_identContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120); ident();
				}
				break;
			case 8:
				{
				_localctx = new Expr_array_elemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121); array_elem();
				}
				break;
			case 9:
				{
				_localctx = new Expr_bracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122); match(OPEN_PARENTHESES);
				setState(123); expr(0);
				setState(124); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_binaryContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(128);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(129); binary_oper();
					setState(130); expr(3);
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Pair_elem_typeContext extends ParserRuleContext {
		public TYPE typename;
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
	 
		public Pair_elem_typeContext() { }
		public void copyFrom(Pair_elem_typeContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Pair_elem_base_typeContext extends Pair_elem_typeContext {
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_elem_base_typeContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem_base_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairContext extends Pair_elem_typeContext {
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public PairContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pair_elem_array_typeContext extends Pair_elem_typeContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Pair_elem_array_typeContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem_array_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair_elem_type);
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Pair_elem_base_typeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137); base_type();
				}
				break;
			case 2:
				_localctx = new Pair_elem_array_typeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138); array_type(0);
				}
				break;
			case 3:
				_localctx = new PairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139); match(PAIR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_typeContext extends ParserRuleContext {
		public TYPE typename;
		public List<Pair_elem_typeContext> pair_elem_type() {
			return getRuleContexts(Pair_elem_typeContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public Pair_elem_typeContext pair_elem_type(int i) {
			return getRuleContext(Pair_elem_typeContext.class,i);
		}
		public Pair_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_typeContext pair_type() throws RecognitionException {
		Pair_typeContext _localctx = new Pair_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(PAIR);
			setState(143); match(OPEN_PARENTHESES);
			setState(144); pair_elem_type();
			setState(145); match(COMMA);
			setState(146); pair_elem_type();
			setState(147); match(CLOSE_PARENTHESES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_typeContext extends ParserRuleContext {
		public TYPE typename;
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
	 
		public Array_typeContext() { }
		public void copyFrom(Array_typeContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Array_type_arrayContext extends Array_typeContext {
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WaccParser.OPEN_SQUARE_BRACKET, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WaccParser.CLOSE_SQUARE_BRACKET, 0); }
		public Array_type_arrayContext(Array_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_type_array(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Array_type_pairContext extends Array_typeContext {
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WaccParser.OPEN_SQUARE_BRACKET, 0); }
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WaccParser.CLOSE_SQUARE_BRACKET, 0); }
		public Array_type_pairContext(Array_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_type_pair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Array_type_baseContext extends Array_typeContext {
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WaccParser.OPEN_SQUARE_BRACKET, 0); }
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WaccParser.CLOSE_SQUARE_BRACKET, 0); }
		public Array_type_baseContext(Array_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_type_base(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		return array_type(0);
	}

	private Array_typeContext array_type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Array_typeContext _localctx = new Array_typeContext(_ctx, _parentState);
		Array_typeContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_array_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				_localctx = new Array_type_baseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(150); base_type();
				setState(151); match(OPEN_SQUARE_BRACKET);
				setState(152); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case PAIR:
				{
				_localctx = new Array_type_pairContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154); pair_type();
				setState(155); match(OPEN_SQUARE_BRACKET);
				setState(156); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Array_type_arrayContext(new Array_typeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_array_type);
					setState(160);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(161); match(OPEN_SQUARE_BRACKET);
					setState(162); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public TYPE typename;
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
	 
		public Base_typeContext() { }
		public void copyFrom(Base_typeContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Base_type_charContext extends Base_typeContext {
		public TerminalNode CHAR() { return getToken(WaccParser.CHAR, 0); }
		public Base_type_charContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBase_type_char(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Base_type_intContext extends Base_typeContext {
		public TerminalNode INT() { return getToken(WaccParser.INT, 0); }
		public Base_type_intContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBase_type_int(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Base_type_stringContext extends Base_typeContext {
		public TerminalNode STRING() { return getToken(WaccParser.STRING, 0); }
		public Base_type_stringContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBase_type_string(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Base_type_boolContext extends Base_typeContext {
		public TerminalNode BOOL() { return getToken(WaccParser.BOOL, 0); }
		public Base_type_boolContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBase_type_bool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_base_type);
		try {
			setState(172);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new Base_type_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(168); match(INT);
				}
				break;
			case BOOL:
				_localctx = new Base_type_boolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169); match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new Base_type_charContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170); match(CHAR);
				}
				break;
			case STRING:
				_localctx = new Base_type_stringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(171); match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TYPE typename;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Type_basetypeContext extends TypeContext {
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Type_basetypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType_basetype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Type_pairtypeContext extends TypeContext {
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public Type_pairtypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType_pairtype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Type_arraytypeContext extends TypeContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Type_arraytypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType_arraytype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			setState(177);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new Type_basetypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174); base_type();
				}
				break;
			case 2:
				_localctx = new Type_arraytypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(175); array_type(0);
				}
				break;
			case 3:
				_localctx = new Type_pairtypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(176); pair_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_elemContext extends ParserRuleContext {
		public TYPE typename;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FST() { return getToken(WaccParser.FST, 0); }
		public TerminalNode SND() { return getToken(WaccParser.SND, 0); }
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pair_elem);
		try {
			setState(183);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(179); match(FST);
				setState(180); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); match(SND);
				setState(182); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); expr(0);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(186); match(COMMA);
				setState(187); expr(0);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_rhsContext extends ParserRuleContext {
		public TYPE typename;
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
	 
		public Assign_rhsContext() { }
		public void copyFrom(Assign_rhsContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Assign_rhs_call_emptyContext extends Assign_rhsContext {
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Assign_rhs_call_emptyContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs_call_empty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_rhs_newpairContext extends Assign_rhsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public TerminalNode NEWPAIR() { return getToken(WaccParser.NEWPAIR, 0); }
		public Assign_rhs_newpairContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs_newpair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_rhs_exprContext extends Assign_rhsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_rhs_exprContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_rhs_ar_literContext extends Assign_rhsContext {
		public Array_literContext array_liter() {
			return getRuleContext(Array_literContext.class,0);
		}
		public Assign_rhs_ar_literContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs_ar_liter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_rhs_callContext extends Assign_rhsContext {
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Assign_rhs_callContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs_call(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_rhs_pair_elemContext extends Assign_rhsContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public Assign_rhs_pair_elemContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs_pair_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assign_rhs);
		try {
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Assign_rhs_exprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(193); expr(0);
				}
				break;
			case 2:
				_localctx = new Assign_rhs_ar_literContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(194); array_liter();
				}
				break;
			case 3:
				_localctx = new Assign_rhs_newpairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(195); match(NEWPAIR);
				setState(196); match(OPEN_PARENTHESES);
				setState(197); expr(0);
				setState(198); match(COMMA);
				setState(199); expr(0);
				setState(200); match(CLOSE_PARENTHESES);
				}
				break;
			case 4:
				_localctx = new Assign_rhs_pair_elemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(202); pair_elem();
				}
				break;
			case 5:
				_localctx = new Assign_rhs_callContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(203); match(CALL);
				setState(204); ident();
				setState(205); match(OPEN_PARENTHESES);
				setState(206); arg_list();
				setState(207); match(CLOSE_PARENTHESES);
				}
				break;
			case 6:
				_localctx = new Assign_rhs_call_emptyContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(209); match(CALL);
				setState(210); ident();
				setState(211); match(OPEN_PARENTHESES);
				setState(212); match(CLOSE_PARENTHESES);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_lhsContext extends ParserRuleContext {
		public TYPE typename;
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
	 
		public Assign_lhsContext() { }
		public void copyFrom(Assign_lhsContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Assign_lhs_identContext extends Assign_lhsContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Assign_lhs_identContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_lhs_ident(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_lhs_pairContext extends Assign_lhsContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public Assign_lhs_pairContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_lhs_pair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_lhs_arrayContext extends Assign_lhsContext {
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public Assign_lhs_arrayContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_lhs_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assign_lhs);
		try {
			setState(219);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Assign_lhs_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216); ident();
				}
				break;
			case 2:
				_localctx = new Assign_lhs_arrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(217); array_elem();
				}
				break;
			case 3:
				_localctx = new Assign_lhs_pairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(218); pair_elem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public TYPE typename;
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Stat_skipContext extends StatContext {
		public TerminalNode SKIP() { return getToken(WaccParser.SKIP, 0); }
		public Stat_skipContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_skip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_statContext extends StatContext {
		public TerminalNode SEMI_COLON() { return getToken(WaccParser.SEMI_COLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public Stat_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_declareContext extends StatContext {
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQUAL_ASSIGN() { return getToken(WaccParser.EQUAL_ASSIGN, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Stat_declareContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_declare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_readContext extends StatContext {
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public Stat_readContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_read(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_ifContext extends StatContext {
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public Stat_ifContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_if(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_assignContext extends StatContext {
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode EQUAL_ASSIGN() { return getToken(WaccParser.EQUAL_ASSIGN, 0); }
		public Stat_assignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_assign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_exitContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public Stat_exitContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_exit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_begin_endContext extends StatContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public Stat_begin_endContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_begin_end(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_freeContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public Stat_freeContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_free(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_whileContext extends StatContext {
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Stat_whileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_while(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_returnContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public Stat_returnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_return(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_printContext extends StatContext {
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_printContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_print(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Stat_printlnContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public Stat_printlnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_println(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new Stat_skipContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(222); match(SKIP);
				}
				break;
			case PAIR:
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				_localctx = new Stat_declareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223); type();
				setState(224); ident();
				setState(225); match(EQUAL_ASSIGN);
				setState(226); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case VARIABLE:
				{
				_localctx = new Stat_assignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228); assign_lhs();
				setState(229); match(EQUAL_ASSIGN);
				setState(230); assign_rhs();
				}
				break;
			case READ:
				{
				_localctx = new Stat_readContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232); match(READ);
				setState(233); assign_lhs();
				}
				break;
			case FREE:
				{
				_localctx = new Stat_freeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234); match(FREE);
				setState(235); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new Stat_returnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236); match(RETURN);
				setState(237); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new Stat_exitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238); match(EXIT);
				setState(239); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new Stat_printContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240); match(PRINT);
				setState(241); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new Stat_printlnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242); match(PRINTLN);
				setState(243); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new Stat_ifContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244); match(IF);
				setState(245); expr(0);
				setState(246); match(THEN);
				setState(247); stat(0);
				setState(248); match(ELSE);
				setState(249); stat(0);
				setState(250); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new Stat_whileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252); match(WHILE);
				setState(253); expr(0);
				setState(254); match(DO);
				setState(255); stat(0);
				setState(256); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Stat_begin_endContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258); match(BEGIN);
				setState(259); stat(0);
				setState(260); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Stat_statContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(264);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(265); match(SEMI_COLON);
					setState(266); stat(2);
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public PARAM paramObj;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); type();
			setState(273); ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_listContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); param();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(276); match(COMMA);
				setState(277); param();
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public FUNCTION funObj;
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); type();
			setState(284); ident();
			setState(285); match(OPEN_PARENTHESES);
			setState(287);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) {
				{
				setState(286); param_list();
				}
			}

			setState(289); match(CLOSE_PARENTHESES);
			setState(290); match(IS);
			setState(291); stat(0);
			setState(292); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(BEGIN);
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(295); func();
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(301); stat(0);
			setState(302); match(END);
			setState(303); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11: return expr_sempred((ExprContext)_localctx, predIndex);
		case 14: return array_type_sempred((Array_typeContext)_localctx, predIndex);
		case 21: return stat_sempred((StatContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean array_type_sempred(Array_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u0134\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\5\4?\n\4\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\5\tL\n\t\3\t\6\tO\n\t\r\t\16\tP\3"+
		"\n\3\n\3\n\3\n\3\n\6\nX\n\n\r\n\16\nY\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13i\n\13\3\f\3\f\3\f\3\f\3\f\5\fp"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0081"+
		"\n\r\3\r\3\r\3\r\3\r\7\r\u0087\n\r\f\r\16\r\u008a\13\r\3\16\3\16\3\16"+
		"\5\16\u008f\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00a1\n\20\3\20\3\20\3\20\7\20\u00a6\n"+
		"\20\f\20\16\20\u00a9\13\20\3\21\3\21\3\21\3\21\5\21\u00af\n\21\3\22\3"+
		"\22\3\22\5\22\u00b4\n\22\3\23\3\23\3\23\3\23\5\23\u00ba\n\23\3\24\3\24"+
		"\3\24\7\24\u00bf\n\24\f\24\16\24\u00c2\13\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u00d9\n\25\3\26\3\26\3\26\5\26\u00de\n\26\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0109\n\27"+
		"\3\27\3\27\3\27\7\27\u010e\n\27\f\27\16\27\u0111\13\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\7\31\u0119\n\31\f\31\16\31\u011c\13\31\3\32\3\32\3\32"+
		"\3\32\5\32\u0122\n\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\7\33\u012b\n"+
		"\33\f\33\16\33\u012e\13\33\3\33\3\33\3\33\3\33\3\33\2\5\30\36,\34\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\4\3\2\4\5\3\2"+
		"\t\n\u0157\2\66\3\2\2\2\48\3\2\2\2\6:\3\2\2\2\bB\3\2\2\2\nD\3\2\2\2\f"+
		"F\3\2\2\2\16H\3\2\2\2\20K\3\2\2\2\22R\3\2\2\2\24h\3\2\2\2\26o\3\2\2\2"+
		"\30\u0080\3\2\2\2\32\u008e\3\2\2\2\34\u0090\3\2\2\2\36\u00a0\3\2\2\2 "+
		"\u00ae\3\2\2\2\"\u00b3\3\2\2\2$\u00b9\3\2\2\2&\u00bb\3\2\2\2(\u00d8\3"+
		"\2\2\2*\u00dd\3\2\2\2,\u0108\3\2\2\2.\u0112\3\2\2\2\60\u0115\3\2\2\2\62"+
		"\u011d\3\2\2\2\64\u0128\3\2\2\2\66\67\7:\2\2\67\3\3\2\2\289\7>\2\29\5"+
		"\3\2\2\2:;\7\31\2\2;>\5\30\r\2<=\7\3\2\2=?\5\30\r\2><\3\2\2\2>?\3\2\2"+
		"\2?@\3\2\2\2@A\7\32\2\2A\7\3\2\2\2BC\7G\2\2C\t\3\2\2\2DE\7F\2\2E\13\3"+
		"\2\2\2FG\t\2\2\2G\r\3\2\2\2HI\t\3\2\2I\17\3\2\2\2JL\5\16\b\2KJ\3\2\2\2"+
		"KL\3\2\2\2LN\3\2\2\2MO\79\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2"+
		"Q\21\3\2\2\2RW\5\2\2\2ST\7\31\2\2TU\5\30\r\2UV\7\32\2\2VX\3\2\2\2WS\3"+
		"\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\23\3\2\2\2[i\7\6\2\2\\i\7\7\2\2"+
		"]i\7\b\2\2^i\7\t\2\2_i\7\n\2\2`i\7\13\2\2ai\7\f\2\2bi\7\r\2\2ci\7\16\2"+
		"\2di\7\17\2\2ei\7\20\2\2fi\7\21\2\2gi\7\22\2\2h[\3\2\2\2h\\\3\2\2\2h]"+
		"\3\2\2\2h^\3\2\2\2h_\3\2\2\2h`\3\2\2\2ha\3\2\2\2hb\3\2\2\2hc\3\2\2\2h"+
		"d\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\25\3\2\2\2jp\7\23\2\2kp\7\n\2"+
		"\2lp\7\24\2\2mp\7\25\2\2np\7\26\2\2oj\3\2\2\2ok\3\2\2\2ol\3\2\2\2om\3"+
		"\2\2\2on\3\2\2\2p\27\3\2\2\2qr\b\r\1\2rs\5\26\f\2st\5\30\r\5t\u0081\3"+
		"\2\2\2u\u0081\5\20\t\2v\u0081\5\f\7\2w\u0081\5\n\6\2x\u0081\5\b\5\2y\u0081"+
		"\5\4\3\2z\u0081\5\2\2\2{\u0081\5\22\n\2|}\7\27\2\2}~\5\30\r\2~\177\7\30"+
		"\2\2\177\u0081\3\2\2\2\u0080q\3\2\2\2\u0080u\3\2\2\2\u0080v\3\2\2\2\u0080"+
		"w\3\2\2\2\u0080x\3\2\2\2\u0080y\3\2\2\2\u0080z\3\2\2\2\u0080{\3\2\2\2"+
		"\u0080|\3\2\2\2\u0081\u0088\3\2\2\2\u0082\u0083\f\4\2\2\u0083\u0084\5"+
		"\24\13\2\u0084\u0085\5\30\r\5\u0085\u0087\3\2\2\2\u0086\u0082\3\2\2\2"+
		"\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\31"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008f\5 \21\2\u008c\u008f\5\36\20\2"+
		"\u008d\u008f\7\35\2\2\u008e\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d"+
		"\3\2\2\2\u008f\33\3\2\2\2\u0090\u0091\7\35\2\2\u0091\u0092\7\27\2\2\u0092"+
		"\u0093\5\32\16\2\u0093\u0094\7\3\2\2\u0094\u0095\5\32\16\2\u0095\u0096"+
		"\7\30\2\2\u0096\35\3\2\2\2\u0097\u0098\b\20\1\2\u0098\u0099\5 \21\2\u0099"+
		"\u009a\7\31\2\2\u009a\u009b\7\32\2\2\u009b\u00a1\3\2\2\2\u009c\u009d\5"+
		"\34\17\2\u009d\u009e\7\31\2\2\u009e\u009f\7\32\2\2\u009f\u00a1\3\2\2\2"+
		"\u00a0\u0097\3\2\2\2\u00a0\u009c\3\2\2\2\u00a1\u00a7\3\2\2\2\u00a2\u00a3"+
		"\f\5\2\2\u00a3\u00a4\7\31\2\2\u00a4\u00a6\7\32\2\2\u00a5\u00a2\3\2\2\2"+
		"\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\37"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00af\7!\2\2\u00ab\u00af\7\"\2\2\u00ac"+
		"\u00af\7#\2\2\u00ad\u00af\7$\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2\2"+
		"\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af!\3\2\2\2\u00b0\u00b4"+
		"\5 \21\2\u00b1\u00b4\5\36\20\2\u00b2\u00b4\5\34\17\2\u00b3\u00b0\3\2\2"+
		"\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4#\3\2\2\2\u00b5\u00b6"+
		"\7\36\2\2\u00b6\u00ba\5\30\r\2\u00b7\u00b8\7\37\2\2\u00b8\u00ba\5\30\r"+
		"\2\u00b9\u00b5\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba%\3\2\2\2\u00bb\u00c0"+
		"\5\30\r\2\u00bc\u00bd\7\3\2\2\u00bd\u00bf\5\30\r\2\u00be\u00bc\3\2\2\2"+
		"\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\'\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00d9\5\30\r\2\u00c4\u00d9\5\6\4\2\u00c5"+
		"\u00c6\7 \2\2\u00c6\u00c7\7\27\2\2\u00c7\u00c8\5\30\r\2\u00c8\u00c9\7"+
		"\3\2\2\u00c9\u00ca\5\30\r\2\u00ca\u00cb\7\30\2\2\u00cb\u00d9\3\2\2\2\u00cc"+
		"\u00d9\5$\23\2\u00cd\u00ce\7%\2\2\u00ce\u00cf\5\2\2\2\u00cf\u00d0\7\27"+
		"\2\2\u00d0\u00d1\5&\24\2\u00d1\u00d2\7\30\2\2\u00d2\u00d9\3\2\2\2\u00d3"+
		"\u00d4\7%\2\2\u00d4\u00d5\5\2\2\2\u00d5\u00d6\7\27\2\2\u00d6\u00d7\7\30"+
		"\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00c3\3\2\2\2\u00d8\u00c4\3\2\2\2\u00d8"+
		"\u00c5\3\2\2\2\u00d8\u00cc\3\2\2\2\u00d8\u00cd\3\2\2\2\u00d8\u00d3\3\2"+
		"\2\2\u00d9)\3\2\2\2\u00da\u00de\5\2\2\2\u00db\u00de\5\22\n\2\u00dc\u00de"+
		"\5$\23\2\u00dd\u00da\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"+\3\2\2\2\u00df\u00e0\b\27\1\2\u00e0\u0109\7&\2\2\u00e1\u00e2\5\"\22\2"+
		"\u00e2\u00e3\5\2\2\2\u00e3\u00e4\7\'\2\2\u00e4\u00e5\5(\25\2\u00e5\u0109"+
		"\3\2\2\2\u00e6\u00e7\5*\26\2\u00e7\u00e8\7\'\2\2\u00e8\u00e9\5(\25\2\u00e9"+
		"\u0109\3\2\2\2\u00ea\u00eb\7(\2\2\u00eb\u0109\5*\26\2\u00ec\u00ed\7)\2"+
		"\2\u00ed\u0109\5\30\r\2\u00ee\u00ef\7*\2\2\u00ef\u0109\5\30\r\2\u00f0"+
		"\u00f1\7+\2\2\u00f1\u0109\5\30\r\2\u00f2\u00f3\7,\2\2\u00f3\u0109\5\30"+
		"\r\2\u00f4\u00f5\7-\2\2\u00f5\u0109\5\30\r\2\u00f6\u00f7\7.\2\2\u00f7"+
		"\u00f8\5\30\r\2\u00f8\u00f9\7/\2\2\u00f9\u00fa\5,\27\2\u00fa\u00fb\7\60"+
		"\2\2\u00fb\u00fc\5,\27\2\u00fc\u00fd\7\61\2\2\u00fd\u0109\3\2\2\2\u00fe"+
		"\u00ff\7\62\2\2\u00ff\u0100\5\30\r\2\u0100\u0101\7\63\2\2\u0101\u0102"+
		"\5,\27\2\u0102\u0103\7\64\2\2\u0103\u0109\3\2\2\2\u0104\u0105\7\65\2\2"+
		"\u0105\u0106\5,\27\2\u0106\u0107\7\66\2\2\u0107\u0109\3\2\2\2\u0108\u00df"+
		"\3\2\2\2\u0108\u00e1\3\2\2\2\u0108\u00e6\3\2\2\2\u0108\u00ea\3\2\2\2\u0108"+
		"\u00ec\3\2\2\2\u0108\u00ee\3\2\2\2\u0108\u00f0\3\2\2\2\u0108\u00f2\3\2"+
		"\2\2\u0108\u00f4\3\2\2\2\u0108\u00f6\3\2\2\2\u0108\u00fe\3\2\2\2\u0108"+
		"\u0104\3\2\2\2\u0109\u010f\3\2\2\2\u010a\u010b\f\3\2\2\u010b\u010c\7\67"+
		"\2\2\u010c\u010e\5,\27\4\u010d\u010a\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110-\3\2\2\2\u0111\u010f\3\2\2\2"+
		"\u0112\u0113\5\"\22\2\u0113\u0114\5\2\2\2\u0114/\3\2\2\2\u0115\u011a\5"+
		".\30\2\u0116\u0117\7\3\2\2\u0117\u0119\5.\30\2\u0118\u0116\3\2\2\2\u0119"+
		"\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\61\3\2\2"+
		"\2\u011c\u011a\3\2\2\2\u011d\u011e\5\"\22\2\u011e\u011f\5\2\2\2\u011f"+
		"\u0121\7\27\2\2\u0120\u0122\5\60\31\2\u0121\u0120\3\2\2\2\u0121\u0122"+
		"\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\7\30\2\2\u0124\u0125\78\2\2\u0125"+
		"\u0126\5,\27\2\u0126\u0127\7\66\2\2\u0127\63\3\2\2\2\u0128\u012c\7\65"+
		"\2\2\u0129\u012b\5\62\32\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012f\u0130\5,\27\2\u0130\u0131\7\66\2\2\u0131\u0132\7\2\2\3\u0132"+
		"\65\3\2\2\2\30>KPYho\u0080\u0088\u008e\u00a0\u00a7\u00ae\u00b3\u00b9\u00c0"+
		"\u00d8\u00dd\u0108\u010f\u011a\u0121\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}