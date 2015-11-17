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
		RULE_array_elem = 8, RULE_binary_oper = 9, RULE_atom = 10, RULE_math = 11, 
		RULE_bin_bool = 12, RULE_unary_oper = 13, RULE_expr = 14, RULE_pair_elem_type = 15, 
		RULE_pair_type = 16, RULE_array_type = 17, RULE_base_type = 18, RULE_type = 19, 
		RULE_pair_elem = 20, RULE_arg_list = 21, RULE_assign_rhs = 22, RULE_assign_lhs = 23, 
		RULE_stat = 24, RULE_stat_return = 25, RULE_param = 26, RULE_param_list = 27, 
		RULE_func = 28, RULE_program = 29;
	public static final String[] ruleNames = {
		"ident", "pair_liter", "array_liter", "str_liter", "char_liter", "bool_liter", 
		"int_sign", "int_liter", "array_elem", "binary_oper", "atom", "math", 
		"bin_bool", "unary_oper", "expr", "pair_elem_type", "pair_type", "array_type", 
		"base_type", "type", "pair_elem", "arg_list", "assign_rhs", "assign_lhs", 
		"stat", "stat_return", "param", "param_list", "func", "program"
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
			setState(60); match(VARIABLE);
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
			setState(62); match(NUL);
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
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
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
			setState(64); match(OPEN_SQUARE_BRACKET);
			setState(73);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << VARIABLE) | (1L << NUL))) != 0) || _la==CHARACTER || _la==STR) {
				{
				{
				setState(65); expr();
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(66); match(COMMA);
					setState(67); expr();
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
			}

			setState(75); match(CLOSE_SQUARE_BRACKET);
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
			setState(77); match(STR);
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
			setState(79); match(CHARACTER);
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
			setState(81);
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
			setState(83);
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
			setState(86);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(85); int_sign();
				}
			}

			setState(89); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(88); match(INTEGER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(91); 
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

	public static class Array_elemContext extends ParserRuleContext {
		public TYPE typename;
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
			setState(93); ident();
			setState(98); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(94); match(OPEN_SQUARE_BRACKET);
					setState(95); expr();
					setState(96); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		public TerminalNode GREATER_EQUAL() { return getToken(WaccParser.GREATER_EQUAL, 0); }
		public TerminalNode AND() { return getToken(WaccParser.AND, 0); }
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(WaccParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(WaccParser.DIVIDE, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(WaccParser.NOT_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(WaccParser.LESS, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(WaccParser.LESS_EQUAL, 0); }
		public TerminalNode IS_EQUAL() { return getToken(WaccParser.IS_EQUAL, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode GREATER() { return getToken(WaccParser.GREATER, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
		public Binary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinary_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operContext binary_oper() throws RecognitionException {
		Binary_operContext _localctx = new Binary_operContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << MOD) | (1L << PLUS) | (1L << MINUS) | (1L << GREATER) | (1L << GREATER_EQUAL) | (1L << LESS) | (1L << LESS_EQUAL) | (1L << IS_EQUAL) | (1L << NOT_EQUAL) | (1L << AND) | (1L << OR))) != 0)) ) {
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

	public static class AtomContext extends ParserRuleContext {
		public TYPE typename;
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Atom_boolContext extends AtomContext {
		public Bool_literContext bool_liter() {
			return getRuleContext(Bool_literContext.class,0);
		}
		public Atom_boolContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAtom_bool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atom_bracketsContext extends AtomContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public Atom_bracketsContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAtom_brackets(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atom_charContext extends AtomContext {
		public Char_literContext char_liter() {
			return getRuleContext(Char_literContext.class,0);
		}
		public Atom_charContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAtom_char(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atom_identContext extends AtomContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Atom_identContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAtom_ident(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atom_intContext extends AtomContext {
		public Int_literContext int_liter() {
			return getRuleContext(Int_literContext.class,0);
		}
		public Atom_intContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAtom_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		try {
			setState(112);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INTEGER:
				_localctx = new Atom_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104); int_liter();
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new Atom_boolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105); bool_liter();
				}
				break;
			case CHARACTER:
				_localctx = new Atom_charContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106); char_liter();
				}
				break;
			case VARIABLE:
				_localctx = new Atom_identContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107); ident();
				}
				break;
			case OPEN_PARENTHESES:
				_localctx = new Atom_bracketsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(108); match(OPEN_PARENTHESES);
				setState(109); expr();
				setState(110); match(CLOSE_PARENTHESES);
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

	public static class MathContext extends ParserRuleContext {
		public TYPE argtype;
		public TYPE returntype;
		public MathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math; }
	 
		public MathContext() { }
		public void copyFrom(MathContext ctx) {
			super.copyFrom(ctx);
			this.argtype = ctx.argtype;
			this.returntype = ctx.returntype;
		}
	}
	public static class Expr_bin_atomContext extends MathContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Expr_bin_atomContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bin_atom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_bin_math_mathContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(WaccParser.MULTIPLY, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public TerminalNode DIVIDE() { return getToken(WaccParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
		public Expr_bin_math_mathContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bin_math_math(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_bin_math_atomContext extends MathContext {
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(WaccParser.MULTIPLY, 0); }
		public TerminalNode PLUS() { return getToken(WaccParser.PLUS, 0); }
		public TerminalNode DIVIDE() { return getToken(WaccParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public Expr_bin_math_atomContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bin_math_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathContext math() throws RecognitionException {
		return math(0);
	}

	private MathContext math(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MathContext _localctx = new MathContext(_ctx, _parentState);
		MathContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_math, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_bin_math_atomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115); atom();
				setState(116);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << MOD) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(117); atom();
				}
				break;
			case 2:
				{
				_localctx = new Expr_bin_atomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119); atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_bin_math_mathContext(new MathContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_math);
					setState(122);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(123);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << MOD) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(124); math(4);
					}
					} 
				}
				setState(129);
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

	public static class Bin_boolContext extends ParserRuleContext {
		public TYPE argtype;
		public TYPE returntype;
		public Bin_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_bool; }
	 
		public Bin_boolContext() { }
		public void copyFrom(Bin_boolContext ctx) {
			super.copyFrom(ctx);
			this.argtype = ctx.argtype;
			this.returntype = ctx.returntype;
		}
	}
	public static class Expr_bin_bool_math_eqContext extends Bin_boolContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public TerminalNode IS_EQUAL() { return getToken(WaccParser.IS_EQUAL, 0); }
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public TerminalNode NOT_EQUAL() { return getToken(WaccParser.NOT_EQUAL, 0); }
		public Expr_bin_bool_math_eqContext(Bin_boolContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bin_bool_math_eq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_bin_bool_boolContext extends Bin_boolContext {
		public Bin_boolContext bin_bool(int i) {
			return getRuleContext(Bin_boolContext.class,i);
		}
		public List<Bin_boolContext> bin_bool() {
			return getRuleContexts(Bin_boolContext.class);
		}
		public TerminalNode AND() { return getToken(WaccParser.AND, 0); }
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public Expr_bin_bool_boolContext(Bin_boolContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bin_bool_bool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_bin_bool_math_morelessContext extends Bin_boolContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public TerminalNode GREATER_EQUAL() { return getToken(WaccParser.GREATER_EQUAL, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(WaccParser.LESS_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(WaccParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(WaccParser.GREATER, 0); }
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public Expr_bin_bool_math_morelessContext(Bin_boolContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bin_bool_math_moreless(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_bin_mathContext extends Bin_boolContext {
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public Expr_bin_mathContext(Bin_boolContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr_bin_math(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bin_boolContext bin_bool() throws RecognitionException {
		return bin_bool(0);
	}

	private Bin_boolContext bin_bool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bin_boolContext _localctx = new Bin_boolContext(_ctx, _parentState);
		Bin_boolContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_bin_bool, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_bin_bool_math_eqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(131); math(0);
				setState(132);
				_la = _input.LA(1);
				if ( !(_la==IS_EQUAL || _la==NOT_EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(133); math(0);
				}
				break;
			case 2:
				{
				_localctx = new Expr_bin_bool_math_morelessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135); math(0);
				setState(136);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER) | (1L << GREATER_EQUAL) | (1L << LESS) | (1L << LESS_EQUAL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(137); math(0);
				}
				break;
			case 3:
				{
				_localctx = new Expr_bin_mathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139); math(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_bin_bool_boolContext(new Bin_boolContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_bin_bool);
					setState(142);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(143);
					_la = _input.LA(1);
					if ( !(_la==AND || _la==OR) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(144); bin_bool(5);
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 26, RULE_unary_oper);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new Unary_notContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150); match(NOT);
				}
				break;
			case MINUS:
				_localctx = new Unary_minusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151); match(MINUS);
				}
				break;
			case LEN:
				_localctx = new Unary_lenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(152); match(LEN);
				}
				break;
			case ORD:
				_localctx = new Unary_ordContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(153); match(ORD);
				}
				break;
			case CHR:
				_localctx = new Unary_chrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(154); match(CHR);
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
		public Bin_boolContext bin_bool() {
			return getRuleContext(Bin_boolContext.class,0);
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
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		try {
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new Expr_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157); int_liter();
				}
				break;
			case 2:
				_localctx = new Expr_boolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158); bool_liter();
				}
				break;
			case 3:
				_localctx = new Expr_charContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159); char_liter();
				}
				break;
			case 4:
				_localctx = new Expr_strContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(160); str_liter();
				}
				break;
			case 5:
				_localctx = new Expr_pairContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(161); pair_liter();
				}
				break;
			case 6:
				_localctx = new Expr_identContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(162); ident();
				}
				break;
			case 7:
				_localctx = new Expr_array_elemContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(163); array_elem();
				}
				break;
			case 8:
				_localctx = new Expr_unaryContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(164); unary_oper();
				setState(165); expr();
				}
				break;
			case 9:
				_localctx = new Expr_binaryContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(167); bin_bool(0);
				}
				break;
			case 10:
				_localctx = new Expr_bracketsContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(168); match(OPEN_PARENTHESES);
				setState(169); expr();
				setState(170); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 30, RULE_pair_elem_type);
		try {
			setState(177);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new Pair_elem_base_typeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174); base_type();
				}
				break;
			case 2:
				_localctx = new Pair_elem_array_typeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(175); array_type(0);
				}
				break;
			case 3:
				_localctx = new PairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(176); match(PAIR);
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
		enterRule(_localctx, 32, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(PAIR);
			setState(180); match(OPEN_PARENTHESES);
			setState(181); pair_elem_type();
			setState(182); match(COMMA);
			setState(183); pair_elem_type();
			setState(184); match(CLOSE_PARENTHESES);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_array_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				_localctx = new Array_type_baseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(187); base_type();
				setState(188); match(OPEN_SQUARE_BRACKET);
				setState(189); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case PAIR:
				{
				_localctx = new Array_type_pairContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191); pair_type();
				setState(192); match(OPEN_SQUARE_BRACKET);
				setState(193); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Array_type_arrayContext(new Array_typeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_array_type);
					setState(197);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(198); match(OPEN_SQUARE_BRACKET);
					setState(199); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 36, RULE_base_type);
		try {
			setState(209);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new Base_type_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(205); match(INT);
				}
				break;
			case BOOL:
				_localctx = new Base_type_boolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206); match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new Base_type_charContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207); match(CHAR);
				}
				break;
			case STRING:
				_localctx = new Base_type_stringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(208); match(STRING);
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
		enterRule(_localctx, 38, RULE_type);
		try {
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Type_basetypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(211); base_type();
				}
				break;
			case 2:
				_localctx = new Type_arraytypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212); array_type(0);
				}
				break;
			case 3:
				_localctx = new Type_pairtypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(213); pair_type();
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
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
	 
		public Pair_elemContext() { }
		public void copyFrom(Pair_elemContext ctx) {
			super.copyFrom(ctx);
			this.typename = ctx.typename;
		}
	}
	public static class Pair_elem_fstContext extends Pair_elemContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FST() { return getToken(WaccParser.FST, 0); }
		public Pair_elem_fstContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem_fst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pair_elem_sndContext extends Pair_elemContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(WaccParser.SND, 0); }
		public Pair_elem_sndContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem_snd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pair_elem);
		try {
			setState(220);
			switch (_input.LA(1)) {
			case FST:
				_localctx = new Pair_elem_fstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216); match(FST);
				setState(217); expr();
				}
				break;
			case SND:
				_localctx = new Pair_elem_sndContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218); match(SND);
				setState(219); expr();
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
		enterRule(_localctx, 42, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222); expr();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(223); match(COMMA);
				setState(224); expr();
				}
				}
				setState(229);
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
		enterRule(_localctx, 44, RULE_assign_rhs);
		try {
			setState(251);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new Assign_rhs_exprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230); expr();
				}
				break;
			case 2:
				_localctx = new Assign_rhs_ar_literContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(231); array_liter();
				}
				break;
			case 3:
				_localctx = new Assign_rhs_newpairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(232); match(NEWPAIR);
				setState(233); match(OPEN_PARENTHESES);
				setState(234); expr();
				setState(235); match(COMMA);
				setState(236); expr();
				setState(237); match(CLOSE_PARENTHESES);
				}
				break;
			case 4:
				_localctx = new Assign_rhs_pair_elemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(239); pair_elem();
				}
				break;
			case 5:
				_localctx = new Assign_rhs_callContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(240); match(CALL);
				setState(241); ident();
				setState(242); match(OPEN_PARENTHESES);
				setState(243); arg_list();
				setState(244); match(CLOSE_PARENTHESES);
				}
				break;
			case 6:
				_localctx = new Assign_rhs_call_emptyContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(246); match(CALL);
				setState(247); ident();
				setState(248); match(OPEN_PARENTHESES);
				setState(249); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 46, RULE_assign_lhs);
		try {
			setState(256);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new Assign_lhs_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(253); ident();
				}
				break;
			case 2:
				_localctx = new Assign_lhs_arrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(254); array_elem();
				}
				break;
			case 3:
				_localctx = new Assign_lhs_pairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(255); pair_elem();
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
	public static class Stat_return_middleContext extends StatContext {
		public Stat_returnContext stat_return() {
			return getRuleContext(Stat_returnContext.class,0);
		}
		public Stat_return_middleContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_return_middle(this);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new Stat_skipContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(259); match(SKIP);
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
				setState(260); type();
				setState(261); ident();
				setState(262); match(EQUAL_ASSIGN);
				setState(263); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case VARIABLE:
				{
				_localctx = new Stat_assignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265); assign_lhs();
				setState(266); match(EQUAL_ASSIGN);
				setState(267); assign_rhs();
				}
				break;
			case READ:
				{
				_localctx = new Stat_readContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269); match(READ);
				setState(270); assign_lhs();
				}
				break;
			case FREE:
				{
				_localctx = new Stat_freeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271); match(FREE);
				setState(272); expr();
				}
				break;
			case EXIT:
				{
				_localctx = new Stat_exitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273); match(EXIT);
				setState(274); expr();
				}
				break;
			case PRINT:
				{
				_localctx = new Stat_printContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275); match(PRINT);
				setState(276); expr();
				}
				break;
			case PRINTLN:
				{
				_localctx = new Stat_printlnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277); match(PRINTLN);
				setState(278); expr();
				}
				break;
			case IF:
				{
				_localctx = new Stat_ifContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279); match(IF);
				setState(280); expr();
				setState(281); match(THEN);
				setState(282); stat(0);
				setState(283); match(ELSE);
				setState(284); stat(0);
				setState(285); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new Stat_whileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287); match(WHILE);
				setState(288); expr();
				setState(289); match(DO);
				setState(290); stat(0);
				setState(291); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Stat_begin_endContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293); match(BEGIN);
				setState(294); stat(0);
				setState(295); match(END);
				}
				break;
			case RETURN:
				{
				_localctx = new Stat_return_middleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(297); stat_return();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Stat_statContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(300);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(301); match(SEMI_COLON);
					setState(302); stat(3);
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class Stat_returnContext extends ParserRuleContext {
		public TYPE typename;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public Stat_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_return; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_returnContext stat_return() throws RecognitionException {
		Stat_returnContext _localctx = new Stat_returnContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_stat_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(RETURN);
			setState(309); expr();
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
		enterRule(_localctx, 52, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); type();
			setState(312); ident();
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
		enterRule(_localctx, 54, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314); param();
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(315); match(COMMA);
				setState(316); param();
				}
				}
				setState(321);
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
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
			this.funObj = ctx.funObj;
		}
	}
	public static class Func_standardContext extends FuncContext {
		public TerminalNode SEMI_COLON() { return getToken(WaccParser.SEMI_COLON, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public Stat_returnContext stat_return() {
			return getRuleContext(Stat_returnContext.class,0);
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
		public Func_standardContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFunc_standard(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Func_ifContext extends FuncContext {
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(WaccParser.SEMI_COLON, i);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(WaccParser.SEMI_COLON); }
		public Stat_returnContext stat_return(int i) {
			return getRuleContext(Stat_returnContext.class,i);
		}
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Stat_returnContext> stat_return() {
			return getRuleContexts(Stat_returnContext.class);
		}
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public Func_ifContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFunc_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_func);
		int _la;
		try {
			setState(370);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new Func_standardContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(322); type();
				setState(323); ident();
				setState(324); match(OPEN_PARENTHESES);
				setState(326);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) {
					{
					setState(325); param_list();
					}
				}

				setState(328); match(CLOSE_PARENTHESES);
				setState(329); match(IS);
				setState(333);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(330); stat(0);
					setState(331); match(SEMI_COLON);
					}
					break;
				}
				setState(335); stat_return();
				setState(336); match(END);
				}
				break;
			case 2:
				_localctx = new Func_ifContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(338); type();
				setState(339); ident();
				setState(340); match(OPEN_PARENTHESES);
				setState(342);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) {
					{
					setState(341); param_list();
					}
				}

				setState(344); match(CLOSE_PARENTHESES);
				setState(345); match(IS);
				setState(349);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(346); stat(0);
					setState(347); match(SEMI_COLON);
					}
					break;
				}
				setState(351); match(IF);
				setState(352); expr();
				setState(353); match(THEN);
				setState(357);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(354); stat(0);
					setState(355); match(SEMI_COLON);
					}
					break;
				}
				setState(359); stat_return();
				setState(360); match(ELSE);
				setState(364);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(361); stat(0);
					setState(362); match(SEMI_COLON);
					}
					break;
				}
				setState(366); stat_return();
				setState(367); match(FI);
				setState(368); match(END);
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
		enterRule(_localctx, 58, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(372); match(BEGIN);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(373); func();
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(379); stat(0);
			setState(380); match(END);
			setState(381); match(EOF);
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
		case 11: return math_sempred((MathContext)_localctx, predIndex);
		case 12: return bin_bool_sempred((Bin_boolContext)_localctx, predIndex);
		case 17: return array_type_sempred((Array_typeContext)_localctx, predIndex);
		case 24: return stat_sempred((StatContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean math_sempred(MathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean array_type_sempred(Array_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean bin_bool_sempred(Bin_boolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u0182\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\5\4L\n\4\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\5\tY\n\t\3\t\6\t\\\n\t\r\t\16\t]\3\n\3"+
		"\n\3\n\3\n\3\n\6\ne\n\n\r\n\16\nf\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\fs\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r{\n\r\3\r\3\r\3\r\7\r\u0080"+
		"\n\r\f\r\16\r\u0083\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u008f\n\16\3\16\3\16\3\16\7\16\u0094\n\16\f\16\16\16\u0097"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\5\17\u009e\n\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00af\n\20"+
		"\3\21\3\21\3\21\5\21\u00b4\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c6\n\23\3\23\3\23\3\23"+
		"\7\23\u00cb\n\23\f\23\16\23\u00ce\13\23\3\24\3\24\3\24\3\24\5\24\u00d4"+
		"\n\24\3\25\3\25\3\25\5\25\u00d9\n\25\3\26\3\26\3\26\3\26\5\26\u00df\n"+
		"\26\3\27\3\27\3\27\7\27\u00e4\n\27\f\27\16\27\u00e7\13\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u00fe\n\30\3\31\3\31\3\31\5\31\u0103\n\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u012d"+
		"\n\32\3\32\3\32\3\32\7\32\u0132\n\32\f\32\16\32\u0135\13\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\35\7\35\u0140\n\35\f\35\16\35\u0143\13"+
		"\35\3\36\3\36\3\36\3\36\5\36\u0149\n\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0150\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0159\n\36\3\36\3"+
		"\36\3\36\3\36\3\36\5\36\u0160\n\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0168\n\36\3\36\3\36\3\36\3\36\3\36\5\36\u016f\n\36\3\36\3\36\3\36\3"+
		"\36\5\36\u0175\n\36\3\37\3\37\7\37\u0179\n\37\f\37\16\37\u017c\13\37\3"+
		"\37\3\37\3\37\3\37\3\37\2\6\30\32$\62 \2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<\2\t\3\2\4\5\3\2\t\n\3\2\6\22\3\2\6\n\3"+
		"\2\17\20\3\2\13\16\3\2\21\22\u01a5\2>\3\2\2\2\4@\3\2\2\2\6B\3\2\2\2\b"+
		"O\3\2\2\2\nQ\3\2\2\2\fS\3\2\2\2\16U\3\2\2\2\20X\3\2\2\2\22_\3\2\2\2\24"+
		"h\3\2\2\2\26r\3\2\2\2\30z\3\2\2\2\32\u008e\3\2\2\2\34\u009d\3\2\2\2\36"+
		"\u00ae\3\2\2\2 \u00b3\3\2\2\2\"\u00b5\3\2\2\2$\u00c5\3\2\2\2&\u00d3\3"+
		"\2\2\2(\u00d8\3\2\2\2*\u00de\3\2\2\2,\u00e0\3\2\2\2.\u00fd\3\2\2\2\60"+
		"\u0102\3\2\2\2\62\u012c\3\2\2\2\64\u0136\3\2\2\2\66\u0139\3\2\2\28\u013c"+
		"\3\2\2\2:\u0174\3\2\2\2<\u0176\3\2\2\2>?\7:\2\2?\3\3\2\2\2@A\7>\2\2A\5"+
		"\3\2\2\2BK\7\31\2\2CH\5\36\20\2DE\7\3\2\2EG\5\36\20\2FD\3\2\2\2GJ\3\2"+
		"\2\2HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2JH\3\2\2\2KC\3\2\2\2KL\3\2\2\2LM\3\2"+
		"\2\2MN\7\32\2\2N\7\3\2\2\2OP\7G\2\2P\t\3\2\2\2QR\7F\2\2R\13\3\2\2\2ST"+
		"\t\2\2\2T\r\3\2\2\2UV\t\3\2\2V\17\3\2\2\2WY\5\16\b\2XW\3\2\2\2XY\3\2\2"+
		"\2Y[\3\2\2\2Z\\\79\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^\21\3"+
		"\2\2\2_d\5\2\2\2`a\7\31\2\2ab\5\36\20\2bc\7\32\2\2ce\3\2\2\2d`\3\2\2\2"+
		"ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\23\3\2\2\2hi\t\4\2\2i\25\3\2\2\2js\5\20"+
		"\t\2ks\5\f\7\2ls\5\n\6\2ms\5\2\2\2no\7\27\2\2op\5\36\20\2pq\7\30\2\2q"+
		"s\3\2\2\2rj\3\2\2\2rk\3\2\2\2rl\3\2\2\2rm\3\2\2\2rn\3\2\2\2s\27\3\2\2"+
		"\2tu\b\r\1\2uv\5\26\f\2vw\t\5\2\2wx\5\26\f\2x{\3\2\2\2y{\5\26\f\2zt\3"+
		"\2\2\2zy\3\2\2\2{\u0081\3\2\2\2|}\f\5\2\2}~\t\5\2\2~\u0080\5\30\r\6\177"+
		"|\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\31\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\b\16\1\2\u0085\u0086\5\30"+
		"\r\2\u0086\u0087\t\6\2\2\u0087\u0088\5\30\r\2\u0088\u008f\3\2\2\2\u0089"+
		"\u008a\5\30\r\2\u008a\u008b\t\7\2\2\u008b\u008c\5\30\r\2\u008c\u008f\3"+
		"\2\2\2\u008d\u008f\5\30\r\2\u008e\u0084\3\2\2\2\u008e\u0089\3\2\2\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0095\3\2\2\2\u0090\u0091\f\6\2\2\u0091\u0092\t\b"+
		"\2\2\u0092\u0094\5\32\16\7\u0093\u0090\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\33\3\2\2\2\u0097\u0095\3\2\2"+
		"\2\u0098\u009e\7\23\2\2\u0099\u009e\7\n\2\2\u009a\u009e\7\24\2\2\u009b"+
		"\u009e\7\25\2\2\u009c\u009e\7\26\2\2\u009d\u0098\3\2\2\2\u009d\u0099\3"+
		"\2\2\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\35\3\2\2\2\u009f\u00af\5\20\t\2\u00a0\u00af\5\f\7\2\u00a1\u00af\5\n\6"+
		"\2\u00a2\u00af\5\b\5\2\u00a3\u00af\5\4\3\2\u00a4\u00af\5\2\2\2\u00a5\u00af"+
		"\5\22\n\2\u00a6\u00a7\5\34\17\2\u00a7\u00a8\5\36\20\2\u00a8\u00af\3\2"+
		"\2\2\u00a9\u00af\5\32\16\2\u00aa\u00ab\7\27\2\2\u00ab\u00ac\5\36\20\2"+
		"\u00ac\u00ad\7\30\2\2\u00ad\u00af\3\2\2\2\u00ae\u009f\3\2\2\2\u00ae\u00a0"+
		"\3\2\2\2\u00ae\u00a1\3\2\2\2\u00ae\u00a2\3\2\2\2\u00ae\u00a3\3\2\2\2\u00ae"+
		"\u00a4\3\2\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00a9\3\2"+
		"\2\2\u00ae\u00aa\3\2\2\2\u00af\37\3\2\2\2\u00b0\u00b4\5&\24\2\u00b1\u00b4"+
		"\5$\23\2\u00b2\u00b4\7\35\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2\2\2"+
		"\u00b3\u00b2\3\2\2\2\u00b4!\3\2\2\2\u00b5\u00b6\7\35\2\2\u00b6\u00b7\7"+
		"\27\2\2\u00b7\u00b8\5 \21\2\u00b8\u00b9\7\3\2\2\u00b9\u00ba\5 \21\2\u00ba"+
		"\u00bb\7\30\2\2\u00bb#\3\2\2\2\u00bc\u00bd\b\23\1\2\u00bd\u00be\5&\24"+
		"\2\u00be\u00bf\7\31\2\2\u00bf\u00c0\7\32\2\2\u00c0\u00c6\3\2\2\2\u00c1"+
		"\u00c2\5\"\22\2\u00c2\u00c3\7\31\2\2\u00c3\u00c4\7\32\2\2\u00c4\u00c6"+
		"\3\2\2\2\u00c5\u00bc\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c6\u00cc\3\2\2\2\u00c7"+
		"\u00c8\f\5\2\2\u00c8\u00c9\7\31\2\2\u00c9\u00cb\7\32\2\2\u00ca\u00c7\3"+
		"\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"%\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d4\7!\2\2\u00d0\u00d4\7\"\2\2\u00d1"+
		"\u00d4\7#\2\2\u00d2\u00d4\7$\2\2\u00d3\u00cf\3\2\2\2\u00d3\u00d0\3\2\2"+
		"\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\'\3\2\2\2\u00d5\u00d9"+
		"\5&\24\2\u00d6\u00d9\5$\23\2\u00d7\u00d9\5\"\22\2\u00d8\u00d5\3\2\2\2"+
		"\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9)\3\2\2\2\u00da\u00db\7"+
		"\36\2\2\u00db\u00df\5\36\20\2\u00dc\u00dd\7\37\2\2\u00dd\u00df\5\36\20"+
		"\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df+\3\2\2\2\u00e0\u00e5"+
		"\5\36\20\2\u00e1\u00e2\7\3\2\2\u00e2\u00e4\5\36\20\2\u00e3\u00e1\3\2\2"+
		"\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6-"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00fe\5\36\20\2\u00e9\u00fe\5\6\4\2"+
		"\u00ea\u00eb\7 \2\2\u00eb\u00ec\7\27\2\2\u00ec\u00ed\5\36\20\2\u00ed\u00ee"+
		"\7\3\2\2\u00ee\u00ef\5\36\20\2\u00ef\u00f0\7\30\2\2\u00f0\u00fe\3\2\2"+
		"\2\u00f1\u00fe\5*\26\2\u00f2\u00f3\7%\2\2\u00f3\u00f4\5\2\2\2\u00f4\u00f5"+
		"\7\27\2\2\u00f5\u00f6\5,\27\2\u00f6\u00f7\7\30\2\2\u00f7\u00fe\3\2\2\2"+
		"\u00f8\u00f9\7%\2\2\u00f9\u00fa\5\2\2\2\u00fa\u00fb\7\27\2\2\u00fb\u00fc"+
		"\7\30\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00e8\3\2\2\2\u00fd\u00e9\3\2\2\2"+
		"\u00fd\u00ea\3\2\2\2\u00fd\u00f1\3\2\2\2\u00fd\u00f2\3\2\2\2\u00fd\u00f8"+
		"\3\2\2\2\u00fe/\3\2\2\2\u00ff\u0103\5\2\2\2\u0100\u0103\5\22\n\2\u0101"+
		"\u0103\5*\26\2\u0102\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2"+
		"\2\2\u0103\61\3\2\2\2\u0104\u0105\b\32\1\2\u0105\u012d\7&\2\2\u0106\u0107"+
		"\5(\25\2\u0107\u0108\5\2\2\2\u0108\u0109\7\'\2\2\u0109\u010a\5.\30\2\u010a"+
		"\u012d\3\2\2\2\u010b\u010c\5\60\31\2\u010c\u010d\7\'\2\2\u010d\u010e\5"+
		".\30\2\u010e\u012d\3\2\2\2\u010f\u0110\7(\2\2\u0110\u012d\5\60\31\2\u0111"+
		"\u0112\7)\2\2\u0112\u012d\5\36\20\2\u0113\u0114\7+\2\2\u0114\u012d\5\36"+
		"\20\2\u0115\u0116\7,\2\2\u0116\u012d\5\36\20\2\u0117\u0118\7-\2\2\u0118"+
		"\u012d\5\36\20\2\u0119\u011a\7.\2\2\u011a\u011b\5\36\20\2\u011b\u011c"+
		"\7/\2\2\u011c\u011d\5\62\32\2\u011d\u011e\7\60\2\2\u011e\u011f\5\62\32"+
		"\2\u011f\u0120\7\61\2\2\u0120\u012d\3\2\2\2\u0121\u0122\7\62\2\2\u0122"+
		"\u0123\5\36\20\2\u0123\u0124\7\63\2\2\u0124\u0125\5\62\32\2\u0125\u0126"+
		"\7\64\2\2\u0126\u012d\3\2\2\2\u0127\u0128\7\65\2\2\u0128\u0129\5\62\32"+
		"\2\u0129\u012a\7\66\2\2\u012a\u012d\3\2\2\2\u012b\u012d\5\64\33\2\u012c"+
		"\u0104\3\2\2\2\u012c\u0106\3\2\2\2\u012c\u010b\3\2\2\2\u012c\u010f\3\2"+
		"\2\2\u012c\u0111\3\2\2\2\u012c\u0113\3\2\2\2\u012c\u0115\3\2\2\2\u012c"+
		"\u0117\3\2\2\2\u012c\u0119\3\2\2\2\u012c\u0121\3\2\2\2\u012c\u0127\3\2"+
		"\2\2\u012c\u012b\3\2\2\2\u012d\u0133\3\2\2\2\u012e\u012f\f\4\2\2\u012f"+
		"\u0130\7\67\2\2\u0130\u0132\5\62\32\5\u0131\u012e\3\2\2\2\u0132\u0135"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\63\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0136\u0137\7*\2\2\u0137\u0138\5\36\20\2\u0138\65\3\2\2"+
		"\2\u0139\u013a\5(\25\2\u013a\u013b\5\2\2\2\u013b\67\3\2\2\2\u013c\u0141"+
		"\5\66\34\2\u013d\u013e\7\3\2\2\u013e\u0140\5\66\34\2\u013f\u013d\3\2\2"+
		"\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u01429"+
		"\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\5(\25\2\u0145\u0146\5\2\2\2\u0146"+
		"\u0148\7\27\2\2\u0147\u0149\58\35\2\u0148\u0147\3\2\2\2\u0148\u0149\3"+
		"\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\7\30\2\2\u014b\u014f\78\2\2\u014c"+
		"\u014d\5\62\32\2\u014d\u014e\7\67\2\2\u014e\u0150\3\2\2\2\u014f\u014c"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\5\64\33\2"+
		"\u0152\u0153\7\66\2\2\u0153\u0175\3\2\2\2\u0154\u0155\5(\25\2\u0155\u0156"+
		"\5\2\2\2\u0156\u0158\7\27\2\2\u0157\u0159\58\35\2\u0158\u0157\3\2\2\2"+
		"\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\7\30\2\2\u015b\u015f"+
		"\78\2\2\u015c\u015d\5\62\32\2\u015d\u015e\7\67\2\2\u015e\u0160\3\2\2\2"+
		"\u015f\u015c\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162"+
		"\7.\2\2\u0162\u0163\5\36\20\2\u0163\u0167\7/\2\2\u0164\u0165\5\62\32\2"+
		"\u0165\u0166\7\67\2\2\u0166\u0168\3\2\2\2\u0167\u0164\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\5\64\33\2\u016a\u016e\7\60\2"+
		"\2\u016b\u016c\5\62\32\2\u016c\u016d\7\67\2\2\u016d\u016f\3\2\2\2\u016e"+
		"\u016b\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\5\64"+
		"\33\2\u0171\u0172\7\61\2\2\u0172\u0173\7\66\2\2\u0173\u0175\3\2\2\2\u0174"+
		"\u0144\3\2\2\2\u0174\u0154\3\2\2\2\u0175;\3\2\2\2\u0176\u017a\7\65\2\2"+
		"\u0177\u0179\5:\36\2\u0178\u0177\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d"+
		"\u017e\5\62\32\2\u017e\u017f\7\66\2\2\u017f\u0180\7\2\2\3\u0180=\3\2\2"+
		"\2\"HKX]frz\u0081\u008e\u0095\u009d\u00ae\u00b3\u00c5\u00cc\u00d3\u00d8"+
		"\u00de\u00e5\u00fd\u0102\u012c\u0133\u0141\u0148\u014f\u0158\u015f\u0167"+
		"\u016e\u0174\u017a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}