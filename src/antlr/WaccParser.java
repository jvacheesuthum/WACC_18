// Generated from ./WaccParser.g4 by ANTLR 4.4
package antlr;
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
		FST=26, WHILE=46, DOUBLE_QUOTATION=65, MOD=6, HT=60, CHAR=31, DO=47, NOT=17, 
		AND=15, ESCAPED_CHAR=56, ORD=19, CHARACTER=55, IF=42, FREE=37, CLOSE_PARENTHESES=22, 
		GREATER=9, THEN=43, MULTIPLY=4, NOT_EQUAL=14, COMMA=1, IS=52, DONE=48, 
		PRINTLN=41, BEGIN=49, LESS=11, RETURN=38, PLUS=7, PAIR=25, SINGLE_QUOTATION=64, 
		COMMENT=57, NEWPAIR=28, DIVIDE=5, INTEGER=53, EXIT=39, BS=59, OPEN_SQUARE_BRACKET=23, 
		SND=27, ELSE=44, BOOL=30, SEMI_COLON=51, INT=29, EQUAL_ASSIGN=35, MINUS=8, 
		TRUE=2, PRINT=40, FF=62, CHR=20, NUL=58, FI=45, EMPTY=66, CLOSE_SQUARE_BRACKET=24, 
		SKIP=34, WS=67, BACK_SLASH=68, VARIABLE=54, READ=36, OR=16, OPEN_PARENTHESES=21, 
		LEN=18, IS_EQUAL=13, LESS_EQUAL=12, CALL=33, END=50, CR=63, FALSE=3, GREATER_EQUAL=10, 
		STRING=32, LF=61;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'true'", "'false'", "'*'", "'/'", "'%'", "'+'", "'-'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", 
		"'ord'", "'chr'", "'('", "')'", "'['", "']'", "'pair'", "'fst'", "'snd'", 
		"'newpair'", "'int'", "'bool'", "'char'", "'string'", "'call'", "'skip'", 
		"'='", "'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'begin'", 
		"'end'", "';'", "'is'", "INTEGER", "VARIABLE", "CHARACTER", "ESCAPED_CHAR", 
		"COMMENT", "NUL", "'\b'", "'\t'", "'\n'", "'\f'", "'\r'", "'''", "'\"'", 
		"EMPTY", "WS", "'\\'"
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
		public List<TerminalNode> CHARACTER() { return getTokens(WaccParser.CHARACTER); }
		public TerminalNode CHARACTER(int i) {
			return getToken(WaccParser.CHARACTER, i);
		}
		public List<TerminalNode> DOUBLE_QUOTATION() { return getTokens(WaccParser.DOUBLE_QUOTATION); }
		public TerminalNode DOUBLE_QUOTATION(int i) {
			return getToken(WaccParser.DOUBLE_QUOTATION, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(DOUBLE_QUOTATION);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CHARACTER) {
				{
				{
				setState(65); match(CHARACTER);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71); match(DOUBLE_QUOTATION);
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
		public List<TerminalNode> SINGLE_QUOTATION() { return getTokens(WaccParser.SINGLE_QUOTATION); }
		public TerminalNode SINGLE_QUOTATION(int i) {
			return getToken(WaccParser.SINGLE_QUOTATION, i);
		}
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
			setState(73); match(SINGLE_QUOTATION);
			setState(74); match(CHARACTER);
			setState(75); match(SINGLE_QUOTATION);
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
			setState(77);
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
			setState(79);
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
			setState(82);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(81); int_sign();
				}
			}

			setState(85); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(84); match(INTEGER);
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
			setState(89); ident();
			setState(94); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(90); match(OPEN_SQUARE_BRACKET);
					setState(91); expr(0);
					setState(92); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(96); 
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
			setState(98);
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

	public static class Unary_operContext extends ParserRuleContext {
		public TerminalNode LEN() { return getToken(WaccParser.LEN, 0); }
		public TerminalNode MINUS() { return getToken(WaccParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(WaccParser.NOT, 0); }
		public TerminalNode CHR() { return getToken(WaccParser.CHR, 0); }
		public TerminalNode ORD() { return getToken(WaccParser.ORD, 0); }
		public Unary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnary_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operContext unary_oper() throws RecognitionException {
		Unary_operContext _localctx = new Unary_operContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public Unary_operContext unary_oper() {
			return getRuleContext(Unary_operContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public Binary_operContext binary_oper() {
			return getRuleContext(Binary_operContext.class,0);
		}
		public Char_literContext char_liter() {
			return getRuleContext(Char_literContext.class,0);
		}
		public Str_literContext str_liter() {
			return getRuleContext(Str_literContext.class,0);
		}
		public Int_literContext int_liter() {
			return getRuleContext(Int_literContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Pair_literContext pair_liter() {
			return getRuleContext(Pair_literContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public Bool_literContext bool_liter() {
			return getRuleContext(Bool_literContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr(this);
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
			setState(117);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(103); unary_oper();
				setState(104); expr(3);
				}
				break;
			case 2:
				{
				setState(106); int_liter();
				}
				break;
			case 3:
				{
				setState(107); bool_liter();
				}
				break;
			case 4:
				{
				setState(108); char_liter();
				}
				break;
			case 5:
				{
				setState(109); str_liter();
				}
				break;
			case 6:
				{
				setState(110); pair_liter();
				}
				break;
			case 7:
				{
				setState(111); ident();
				}
				break;
			case 8:
				{
				setState(112); array_elem();
				}
				break;
			case 9:
				{
				setState(113); match(OPEN_PARENTHESES);
				setState(114); expr(0);
				setState(115); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(119);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(120); binary_oper();
					setState(121); expr(3);
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPair_elem_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair_elem_type);
		try {
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); array_type(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); match(PAIR);
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
			setState(133); match(PAIR);
			setState(134); match(OPEN_PARENTHESES);
			setState(135); pair_elem_type();
			setState(136); match(COMMA);
			setState(137); pair_elem_type();
			setState(138); match(CLOSE_PARENTHESES);
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
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WaccParser.OPEN_SQUARE_BRACKET, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WaccParser.CLOSE_SQUARE_BRACKET, 0); }
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArray_type(this);
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
			setState(149);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(141); base_type();
				setState(142); match(OPEN_SQUARE_BRACKET);
				setState(143); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case PAIR:
				{
				setState(145); pair_type();
				setState(146); match(OPEN_SQUARE_BRACKET);
				setState(147); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Array_typeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_array_type);
					setState(151);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(152); match(OPEN_SQUARE_BRACKET);
					setState(153); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(158);
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

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(WaccParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(WaccParser.INT, 0); }
		public TerminalNode STRING() { return getToken(WaccParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(WaccParser.CHAR, 0); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBase_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_base_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) ) {
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

	public static class TypeContext extends ParserRuleContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162); array_type(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163); pair_type();
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
			setState(170);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(166); match(FST);
				setState(167); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(168); match(SND);
				setState(169); expr(0);
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
			setState(172); expr(0);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173); match(COMMA);
				setState(174); expr(0);
				}
				}
				setState(179);
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
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WaccParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WaccParser.OPEN_PARENTHESES, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEWPAIR() { return getToken(WaccParser.NEWPAIR, 0); }
		public Array_literContext array_liter() {
			return getRuleContext(Array_literContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_rhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assign_rhs);
		try {
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); array_liter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182); match(NEWPAIR);
				setState(183); match(OPEN_PARENTHESES);
				setState(184); expr(0);
				setState(185); match(COMMA);
				setState(186); expr(0);
				setState(187); match(CLOSE_PARENTHESES);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(189); pair_elem();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(190); match(CALL);
				setState(191); ident();
				setState(192); match(OPEN_PARENTHESES);
				setState(193); arg_list();
				setState(194); match(CLOSE_PARENTHESES);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(196); match(CALL);
				setState(197); ident();
				setState(198); match(OPEN_PARENTHESES);
				setState(199); match(CLOSE_PARENTHESES);
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
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssign_lhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assign_lhs);
		try {
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203); ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205); pair_elem();
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
		public TerminalNode SKIP() { return getToken(WaccParser.SKIP, 0); }
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public TerminalNode EQUAL_ASSIGN() { return getToken(WaccParser.EQUAL_ASSIGN, 0); }
		public TerminalNode SEMI_COLON() { return getToken(WaccParser.SEMI_COLON, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat(this);
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
			setState(249);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(209); match(SKIP);
				}
				break;
			case PAIR:
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(210); type();
				setState(211); ident();
				setState(212); match(EQUAL_ASSIGN);
				setState(213); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case VARIABLE:
				{
				setState(215); assign_lhs();
				setState(216); match(EQUAL_ASSIGN);
				setState(217); assign_rhs();
				}
				break;
			case READ:
				{
				setState(219); match(READ);
				setState(220); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(221); match(FREE);
				setState(222); expr(0);
				}
				break;
			case RETURN:
				{
				setState(223); match(RETURN);
				setState(224); expr(0);
				}
				break;
			case EXIT:
				{
				setState(225); match(EXIT);
				setState(226); expr(0);
				}
				break;
			case PRINT:
				{
				setState(227); match(PRINT);
				setState(228); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(229); match(PRINTLN);
				setState(230); expr(0);
				}
				break;
			case IF:
				{
				setState(231); match(IF);
				setState(232); expr(0);
				setState(233); match(THEN);
				setState(234); stat(0);
				setState(235); match(ELSE);
				setState(236); stat(0);
				setState(237); match(FI);
				}
				break;
			case WHILE:
				{
				setState(239); match(WHILE);
				setState(240); expr(0);
				setState(241); match(DO);
				setState(242); stat(0);
				setState(243); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(245); match(BEGIN);
				setState(246); stat(0);
				setState(247); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(251);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(252); match(SEMI_COLON);
					setState(253); stat(2);
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
			setState(259); type();
			setState(260); ident();
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
			setState(262); param();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(263); match(COMMA);
				setState(264); param();
				}
				}
				setState(269);
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
			setState(270); type();
			setState(271); ident();
			setState(272); match(OPEN_PARENTHESES);
			setState(274);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) {
				{
				setState(273); param_list();
				}
			}

			setState(276); match(CLOSE_PARENTHESES);
			setState(277); match(IS);
			setState(278); stat(0);
			setState(279); match(END);
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
			setState(281); match(BEGIN);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(282); func();
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(288); stat(0);
			setState(289); match(END);
			setState(290); match(EOF);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3F\u0127\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\5\4?\n\4\3\4\3\4"+
		"\3\5\3\5\7\5E\n\5\f\5\16\5H\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\5\tU\n\t\3\t\6\tX\n\t\r\t\16\tY\3\n\3\n\3\n\3\n\3\n\6\na\n\n\r"+
		"\n\16\nb\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\rx\n\r\3\r\3\r\3\r\3\r\7\r~\n\r\f\r\16\r\u0081\13\r"+
		"\3\16\3\16\3\16\5\16\u0086\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0098\n\20\3\20\3\20\3\20"+
		"\7\20\u009d\n\20\f\20\16\20\u00a0\13\20\3\21\3\21\3\22\3\22\3\22\5\22"+
		"\u00a7\n\22\3\23\3\23\3\23\3\23\5\23\u00ad\n\23\3\24\3\24\3\24\7\24\u00b2"+
		"\n\24\f\24\16\24\u00b5\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00cc"+
		"\n\25\3\26\3\26\3\26\5\26\u00d1\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00fc\n\27\3\27\3\27\3\27\7\27\u0101"+
		"\n\27\f\27\16\27\u0104\13\27\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u010c"+
		"\n\31\f\31\16\31\u010f\13\31\3\32\3\32\3\32\3\32\5\32\u0115\n\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\7\33\u011e\n\33\f\33\16\33\u0121\13\33"+
		"\3\33\3\33\3\33\3\33\3\33\2\5\30\36,\34\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\2\7\3\2\4\5\3\2\t\n\3\2\6\22\4\2\n\n\23\26"+
		"\3\2\37\"\u0138\2\66\3\2\2\2\48\3\2\2\2\6:\3\2\2\2\bB\3\2\2\2\nK\3\2\2"+
		"\2\fO\3\2\2\2\16Q\3\2\2\2\20T\3\2\2\2\22[\3\2\2\2\24d\3\2\2\2\26f\3\2"+
		"\2\2\30w\3\2\2\2\32\u0085\3\2\2\2\34\u0087\3\2\2\2\36\u0097\3\2\2\2 \u00a1"+
		"\3\2\2\2\"\u00a6\3\2\2\2$\u00ac\3\2\2\2&\u00ae\3\2\2\2(\u00cb\3\2\2\2"+
		"*\u00d0\3\2\2\2,\u00fb\3\2\2\2.\u0105\3\2\2\2\60\u0108\3\2\2\2\62\u0110"+
		"\3\2\2\2\64\u011b\3\2\2\2\66\67\78\2\2\67\3\3\2\2\289\7<\2\29\5\3\2\2"+
		"\2:;\7\31\2\2;>\5\30\r\2<=\7\3\2\2=?\5\30\r\2><\3\2\2\2>?\3\2\2\2?@\3"+
		"\2\2\2@A\7\32\2\2A\7\3\2\2\2BF\7C\2\2CE\79\2\2DC\3\2\2\2EH\3\2\2\2FD\3"+
		"\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7C\2\2J\t\3\2\2\2KL\7B\2\2LM\7"+
		"9\2\2MN\7B\2\2N\13\3\2\2\2OP\t\2\2\2P\r\3\2\2\2QR\t\3\2\2R\17\3\2\2\2"+
		"SU\5\16\b\2TS\3\2\2\2TU\3\2\2\2UW\3\2\2\2VX\7\67\2\2WV\3\2\2\2XY\3\2\2"+
		"\2YW\3\2\2\2YZ\3\2\2\2Z\21\3\2\2\2[`\5\2\2\2\\]\7\31\2\2]^\5\30\r\2^_"+
		"\7\32\2\2_a\3\2\2\2`\\\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\23\3\2\2"+
		"\2de\t\4\2\2e\25\3\2\2\2fg\t\5\2\2g\27\3\2\2\2hi\b\r\1\2ij\5\26\f\2jk"+
		"\5\30\r\5kx\3\2\2\2lx\5\20\t\2mx\5\f\7\2nx\5\n\6\2ox\5\b\5\2px\5\4\3\2"+
		"qx\5\2\2\2rx\5\22\n\2st\7\27\2\2tu\5\30\r\2uv\7\30\2\2vx\3\2\2\2wh\3\2"+
		"\2\2wl\3\2\2\2wm\3\2\2\2wn\3\2\2\2wo\3\2\2\2wp\3\2\2\2wq\3\2\2\2wr\3\2"+
		"\2\2ws\3\2\2\2x\177\3\2\2\2yz\f\4\2\2z{\5\24\13\2{|\5\30\r\5|~\3\2\2\2"+
		"}y\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\31\3\2"+
		"\2\2\u0081\177\3\2\2\2\u0082\u0086\5 \21\2\u0083\u0086\5\36\20\2\u0084"+
		"\u0086\7\33\2\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3"+
		"\2\2\2\u0086\33\3\2\2\2\u0087\u0088\7\33\2\2\u0088\u0089\7\27\2\2\u0089"+
		"\u008a\5\32\16\2\u008a\u008b\7\3\2\2\u008b\u008c\5\32\16\2\u008c\u008d"+
		"\7\30\2\2\u008d\35\3\2\2\2\u008e\u008f\b\20\1\2\u008f\u0090\5 \21\2\u0090"+
		"\u0091\7\31\2\2\u0091\u0092\7\32\2\2\u0092\u0098\3\2\2\2\u0093\u0094\5"+
		"\34\17\2\u0094\u0095\7\31\2\2\u0095\u0096\7\32\2\2\u0096\u0098\3\2\2\2"+
		"\u0097\u008e\3\2\2\2\u0097\u0093\3\2\2\2\u0098\u009e\3\2\2\2\u0099\u009a"+
		"\f\5\2\2\u009a\u009b\7\31\2\2\u009b\u009d\7\32\2\2\u009c\u0099\3\2\2\2"+
		"\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\37"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\t\6\2\2\u00a2!\3\2\2\2\u00a3"+
		"\u00a7\5 \21\2\u00a4\u00a7\5\36\20\2\u00a5\u00a7\5\34\17\2\u00a6\u00a3"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7#\3\2\2\2\u00a8"+
		"\u00a9\7\34\2\2\u00a9\u00ad\5\30\r\2\u00aa\u00ab\7\35\2\2\u00ab\u00ad"+
		"\5\30\r\2\u00ac\u00a8\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad%\3\2\2\2\u00ae"+
		"\u00b3\5\30\r\2\u00af\u00b0\7\3\2\2\u00b0\u00b2\5\30\r\2\u00b1\u00af\3"+
		"\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\'\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00cc\5\30\r\2\u00b7\u00cc\5\6\4"+
		"\2\u00b8\u00b9\7\36\2\2\u00b9\u00ba\7\27\2\2\u00ba\u00bb\5\30\r\2\u00bb"+
		"\u00bc\7\3\2\2\u00bc\u00bd\5\30\r\2\u00bd\u00be\7\30\2\2\u00be\u00cc\3"+
		"\2\2\2\u00bf\u00cc\5$\23\2\u00c0\u00c1\7#\2\2\u00c1\u00c2\5\2\2\2\u00c2"+
		"\u00c3\7\27\2\2\u00c3\u00c4\5&\24\2\u00c4\u00c5\7\30\2\2\u00c5\u00cc\3"+
		"\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c8\5\2\2\2\u00c8\u00c9\7\27\2\2\u00c9"+
		"\u00ca\7\30\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00b6\3\2\2\2\u00cb\u00b7\3"+
		"\2\2\2\u00cb\u00b8\3\2\2\2\u00cb\u00bf\3\2\2\2\u00cb\u00c0\3\2\2\2\u00cb"+
		"\u00c6\3\2\2\2\u00cc)\3\2\2\2\u00cd\u00d1\5\2\2\2\u00ce\u00d1\5\22\n\2"+
		"\u00cf\u00d1\5$\23\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d1+\3\2\2\2\u00d2\u00d3\b\27\1\2\u00d3\u00fc\7$\2\2\u00d4"+
		"\u00d5\5\"\22\2\u00d5\u00d6\5\2\2\2\u00d6\u00d7\7%\2\2\u00d7\u00d8\5("+
		"\25\2\u00d8\u00fc\3\2\2\2\u00d9\u00da\5*\26\2\u00da\u00db\7%\2\2\u00db"+
		"\u00dc\5(\25\2\u00dc\u00fc\3\2\2\2\u00dd\u00de\7&\2\2\u00de\u00fc\5*\26"+
		"\2\u00df\u00e0\7\'\2\2\u00e0\u00fc\5\30\r\2\u00e1\u00e2\7(\2\2\u00e2\u00fc"+
		"\5\30\r\2\u00e3\u00e4\7)\2\2\u00e4\u00fc\5\30\r\2\u00e5\u00e6\7*\2\2\u00e6"+
		"\u00fc\5\30\r\2\u00e7\u00e8\7+\2\2\u00e8\u00fc\5\30\r\2\u00e9\u00ea\7"+
		",\2\2\u00ea\u00eb\5\30\r\2\u00eb\u00ec\7-\2\2\u00ec\u00ed\5,\27\2\u00ed"+
		"\u00ee\7.\2\2\u00ee\u00ef\5,\27\2\u00ef\u00f0\7/\2\2\u00f0\u00fc\3\2\2"+
		"\2\u00f1\u00f2\7\60\2\2\u00f2\u00f3\5\30\r\2\u00f3\u00f4\7\61\2\2\u00f4"+
		"\u00f5\5,\27\2\u00f5\u00f6\7\62\2\2\u00f6\u00fc\3\2\2\2\u00f7\u00f8\7"+
		"\63\2\2\u00f8\u00f9\5,\27\2\u00f9\u00fa\7\64\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00d2\3\2\2\2\u00fb\u00d4\3\2\2\2\u00fb\u00d9\3\2\2\2\u00fb\u00dd\3\2"+
		"\2\2\u00fb\u00df\3\2\2\2\u00fb\u00e1\3\2\2\2\u00fb\u00e3\3\2\2\2\u00fb"+
		"\u00e5\3\2\2\2\u00fb\u00e7\3\2\2\2\u00fb\u00e9\3\2\2\2\u00fb\u00f1\3\2"+
		"\2\2\u00fb\u00f7\3\2\2\2\u00fc\u0102\3\2\2\2\u00fd\u00fe\f\3\2\2\u00fe"+
		"\u00ff\7\65\2\2\u00ff\u0101\5,\27\4\u0100\u00fd\3\2\2\2\u0101\u0104\3"+
		"\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103-\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0105\u0106\5\"\22\2\u0106\u0107\5\2\2\2\u0107/\3\2\2\2\u0108"+
		"\u010d\5.\30\2\u0109\u010a\7\3\2\2\u010a\u010c\5.\30\2\u010b\u0109\3\2"+
		"\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\61\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\5\"\22\2\u0111\u0112\5\2\2"+
		"\2\u0112\u0114\7\27\2\2\u0113\u0115\5\60\31\2\u0114\u0113\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\30\2\2\u0117\u0118\7"+
		"\66\2\2\u0118\u0119\5,\27\2\u0119\u011a\7\64\2\2\u011a\63\3\2\2\2\u011b"+
		"\u011f\7\63\2\2\u011c\u011e\5\62\32\2\u011d\u011c\3\2\2\2\u011e\u0121"+
		"\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0122\u0123\5,\27\2\u0123\u0124\7\64\2\2\u0124\u0125\7"+
		"\2\2\3\u0125\65\3\2\2\2\26>FTYbw\177\u0085\u0097\u009e\u00a6\u00ac\u00b3"+
		"\u00cb\u00d0\u00fb\u0102\u010d\u0114\u011f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}