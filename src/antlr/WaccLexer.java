// Generated from ./WaccLexer.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WaccLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'", "'A'", "'B'", "'C'", "'D'", "'E'"
	};
	public static final String[] ruleNames = {
		"COMMA", "TRUE", "FALSE", "MULTIPLY", "DIVIDE", "MOD", "PLUS", "MINUS", 
		"GREATER", "GREATER_EQUAL", "LESS", "LESS_EQUAL", "IS_EQUAL", "NOT_EQUAL", 
		"AND", "OR", "NOT", "LEN", "ORD", "CHR", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", 
		"OPEN_SQUARE_BRACKET", "CLOSE_SQUARE_BRACKET", "SINGLE_QUOTATION", "DOUBLE_QUOTATION", 
		"PAIR", "FST", "SND", "NEWPAIR", "INT", "BOOL", "CHAR", "STRING", "CALL", 
		"SKIP", "EQUAL_ASSIGN", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", 
		"IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", "BEGIN", "END", "SEMI_COLON", 
		"IS", "DIGIT", "INTEGER", "VARIABLE", "WS", "ESCAPED_CHAR", "HASH", "COMMENT", 
		"EOL", "NUL", "BS", "HT", "LF", "FF", "CR", "EMPTY", "BACK_SLASH", "CHARACTER", 
		"STR"
	};


	public WaccLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WaccLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2G\u01b8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+"+
		"\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\3\67\38\38\39\69\u0165\n9\r9\169\u0166\3:\3:\3:\7:\u016c\n:\f"+
		":\16:\u016f\13:\3;\6;\u0172\n;\r;\16;\u0173\3;\3;\3<\3<\3<\3<\5<\u017c"+
		"\n<\3=\3=\3>\3>\7>\u0182\n>\f>\16>\u0185\13>\3>\3>\3>\3>\3?\5?\u018c\n"+
		"?\3?\3?\5?\u0190\n?\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3G\3G\3H\3H\3"+
		"H\3H\3H\3H\3H\5H\u01a7\nH\3H\3H\3I\3I\3I\3I\3I\3I\3I\7I\u01b2\nI\fI\16"+
		"I\u01b5\13I\3I\3I\2\2J\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o\2q9s:u;w<y\2{=}\2\177>\u0081?\u0083@\u0085A\u0087"+
		"B\u0089C\u008bD\u008dE\u008fF\u0091G\3\2\b\5\2C\\aac|\5\2\13\f\17\17\""+
		"\"\b\2\62\62ddhhppttvv\4\2\f\f\17\17\4\2C\\c|\f\2\"\"$$))CGIKMNPQSSUW"+
		"aa\u01c3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2{\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\3\u0093\3\2\2\2\5\u0095\3\2\2\2\7\u009a\3\2\2\2\t\u00a0\3\2\2"+
		"\2\13\u00a2\3\2\2\2\r\u00a4\3\2\2\2\17\u00a6\3\2\2\2\21\u00a8\3\2\2\2"+
		"\23\u00aa\3\2\2\2\25\u00ac\3\2\2\2\27\u00af\3\2\2\2\31\u00b1\3\2\2\2\33"+
		"\u00b4\3\2\2\2\35\u00b7\3\2\2\2\37\u00ba\3\2\2\2!\u00bd\3\2\2\2#\u00c0"+
		"\3\2\2\2%\u00c2\3\2\2\2\'\u00c6\3\2\2\2)\u00ca\3\2\2\2+\u00ce\3\2\2\2"+
		"-\u00d0\3\2\2\2/\u00d2\3\2\2\2\61\u00d4\3\2\2\2\63\u00d6\3\2\2\2\65\u00d8"+
		"\3\2\2\2\67\u00da\3\2\2\29\u00df\3\2\2\2;\u00e3\3\2\2\2=\u00e7\3\2\2\2"+
		"?\u00ef\3\2\2\2A\u00f3\3\2\2\2C\u00f8\3\2\2\2E\u00fd\3\2\2\2G\u0104\3"+
		"\2\2\2I\u0109\3\2\2\2K\u010e\3\2\2\2M\u0110\3\2\2\2O\u0115\3\2\2\2Q\u011a"+
		"\3\2\2\2S\u0121\3\2\2\2U\u0126\3\2\2\2W\u012c\3\2\2\2Y\u0134\3\2\2\2["+
		"\u0137\3\2\2\2]\u013c\3\2\2\2_\u0141\3\2\2\2a\u0144\3\2\2\2c\u014a\3\2"+
		"\2\2e\u014d\3\2\2\2g\u0152\3\2\2\2i\u0158\3\2\2\2k\u015c\3\2\2\2m\u015e"+
		"\3\2\2\2o\u0161\3\2\2\2q\u0164\3\2\2\2s\u0168\3\2\2\2u\u0171\3\2\2\2w"+
		"\u017b\3\2\2\2y\u017d\3\2\2\2{\u017f\3\2\2\2}\u018f\3\2\2\2\177\u0191"+
		"\3\2\2\2\u0081\u0192\3\2\2\2\u0083\u0194\3\2\2\2\u0085\u0196\3\2\2\2\u0087"+
		"\u0198\3\2\2\2\u0089\u019a\3\2\2\2\u008b\u019c\3\2\2\2\u008d\u019d\3\2"+
		"\2\2\u008f\u019f\3\2\2\2\u0091\u01aa\3\2\2\2\u0093\u0094\7.\2\2\u0094"+
		"\4\3\2\2\2\u0095\u0096\7v\2\2\u0096\u0097\7t\2\2\u0097\u0098\7w\2\2\u0098"+
		"\u0099\7g\2\2\u0099\6\3\2\2\2\u009a\u009b\7h\2\2\u009b\u009c\7c\2\2\u009c"+
		"\u009d\7n\2\2\u009d\u009e\7u\2\2\u009e\u009f\7g\2\2\u009f\b\3\2\2\2\u00a0"+
		"\u00a1\7,\2\2\u00a1\n\3\2\2\2\u00a2\u00a3\7\61\2\2\u00a3\f\3\2\2\2\u00a4"+
		"\u00a5\7\'\2\2\u00a5\16\3\2\2\2\u00a6\u00a7\7-\2\2\u00a7\20\3\2\2\2\u00a8"+
		"\u00a9\7/\2\2\u00a9\22\3\2\2\2\u00aa\u00ab\7@\2\2\u00ab\24\3\2\2\2\u00ac"+
		"\u00ad\7@\2\2\u00ad\u00ae\7?\2\2\u00ae\26\3\2\2\2\u00af\u00b0\7>\2\2\u00b0"+
		"\30\3\2\2\2\u00b1\u00b2\7>\2\2\u00b2\u00b3\7?\2\2\u00b3\32\3\2\2\2\u00b4"+
		"\u00b5\7?\2\2\u00b5\u00b6\7?\2\2\u00b6\34\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8"+
		"\u00b9\7?\2\2\u00b9\36\3\2\2\2\u00ba\u00bb\7(\2\2\u00bb\u00bc\7(\2\2\u00bc"+
		" \3\2\2\2\u00bd\u00be\7~\2\2\u00be\u00bf\7~\2\2\u00bf\"\3\2\2\2\u00c0"+
		"\u00c1\7#\2\2\u00c1$\3\2\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7p\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8\7t\2\2\u00c8"+
		"\u00c9\7f\2\2\u00c9(\3\2\2\2\u00ca\u00cb\7e\2\2\u00cb\u00cc\7j\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd*\3\2\2\2\u00ce\u00cf\7*\2\2\u00cf,\3\2\2\2\u00d0\u00d1"+
		"\7+\2\2\u00d1.\3\2\2\2\u00d2\u00d3\7]\2\2\u00d3\60\3\2\2\2\u00d4\u00d5"+
		"\7_\2\2\u00d5\62\3\2\2\2\u00d6\u00d7\7)\2\2\u00d7\64\3\2\2\2\u00d8\u00d9"+
		"\7$\2\2\u00d9\66\3\2\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd"+
		"\7k\2\2\u00dd\u00de\7t\2\2\u00de8\3\2\2\2\u00df\u00e0\7h\2\2\u00e0\u00e1"+
		"\7u\2\2\u00e1\u00e2\7v\2\2\u00e2:\3\2\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5"+
		"\7p\2\2\u00e5\u00e6\7f\2\2\u00e6<\3\2\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9"+
		"\7g\2\2\u00e9\u00ea\7y\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec\7c\2\2\u00ec"+
		"\u00ed\7k\2\2\u00ed\u00ee\7t\2\2\u00ee>\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0"+
		"\u00f1\7p\2\2\u00f1\u00f2\7v\2\2\u00f2@\3\2\2\2\u00f3\u00f4\7d\2\2\u00f4"+
		"\u00f5\7q\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7n\2\2\u00f7B\3\2\2\2\u00f8"+
		"\u00f9\7e\2\2\u00f9\u00fa\7j\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7t\2\2"+
		"\u00fcD\3\2\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7t\2"+
		"\2\u0100\u0101\7k\2\2\u0101\u0102\7p\2\2\u0102\u0103\7i\2\2\u0103F\3\2"+
		"\2\2\u0104\u0105\7e\2\2\u0105\u0106\7c\2\2\u0106\u0107\7n\2\2\u0107\u0108"+
		"\7n\2\2\u0108H\3\2\2\2\u0109\u010a\7u\2\2\u010a\u010b\7m\2\2\u010b\u010c"+
		"\7k\2\2\u010c\u010d\7r\2\2\u010dJ\3\2\2\2\u010e\u010f\7?\2\2\u010fL\3"+
		"\2\2\2\u0110\u0111\7t\2\2\u0111\u0112\7g\2\2\u0112\u0113\7c\2\2\u0113"+
		"\u0114\7f\2\2\u0114N\3\2\2\2\u0115\u0116\7h\2\2\u0116\u0117\7t\2\2\u0117"+
		"\u0118\7g\2\2\u0118\u0119\7g\2\2\u0119P\3\2\2\2\u011a\u011b\7t\2\2\u011b"+
		"\u011c\7g\2\2\u011c\u011d\7v\2\2\u011d\u011e\7w\2\2\u011e\u011f\7t\2\2"+
		"\u011f\u0120\7p\2\2\u0120R\3\2\2\2\u0121\u0122\7g\2\2\u0122\u0123\7z\2"+
		"\2\u0123\u0124\7k\2\2\u0124\u0125\7v\2\2\u0125T\3\2\2\2\u0126\u0127\7"+
		"r\2\2\u0127\u0128\7t\2\2\u0128\u0129\7k\2\2\u0129\u012a\7p\2\2\u012a\u012b"+
		"\7v\2\2\u012bV\3\2\2\2\u012c\u012d\7r\2\2\u012d\u012e\7t\2\2\u012e\u012f"+
		"\7k\2\2\u012f\u0130\7p\2\2\u0130\u0131\7v\2\2\u0131\u0132\7n\2\2\u0132"+
		"\u0133\7p\2\2\u0133X\3\2\2\2\u0134\u0135\7k\2\2\u0135\u0136\7h\2\2\u0136"+
		"Z\3\2\2\2\u0137\u0138\7v\2\2\u0138\u0139\7j\2\2\u0139\u013a\7g\2\2\u013a"+
		"\u013b\7p\2\2\u013b\\\3\2\2\2\u013c\u013d\7g\2\2\u013d\u013e\7n\2\2\u013e"+
		"\u013f\7u\2\2\u013f\u0140\7g\2\2\u0140^\3\2\2\2\u0141\u0142\7h\2\2\u0142"+
		"\u0143\7k\2\2\u0143`\3\2\2\2\u0144\u0145\7y\2\2\u0145\u0146\7j\2\2\u0146"+
		"\u0147\7k\2\2\u0147\u0148\7n\2\2\u0148\u0149\7g\2\2\u0149b\3\2\2\2\u014a"+
		"\u014b\7f\2\2\u014b\u014c\7q\2\2\u014cd\3\2\2\2\u014d\u014e\7f\2\2\u014e"+
		"\u014f\7q\2\2\u014f\u0150\7p\2\2\u0150\u0151\7g\2\2\u0151f\3\2\2\2\u0152"+
		"\u0153\7d\2\2\u0153\u0154\7g\2\2\u0154\u0155\7i\2\2\u0155\u0156\7k\2\2"+
		"\u0156\u0157\7p\2\2\u0157h\3\2\2\2\u0158\u0159\7g\2\2\u0159\u015a\7p\2"+
		"\2\u015a\u015b\7f\2\2\u015bj\3\2\2\2\u015c\u015d\7=\2\2\u015dl\3\2\2\2"+
		"\u015e\u015f\7k\2\2\u015f\u0160\7u\2\2\u0160n\3\2\2\2\u0161\u0162\4\62"+
		";\2\u0162p\3\2\2\2\u0163\u0165\5o8\2\u0164\u0163\3\2\2\2\u0165\u0166\3"+
		"\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167r\3\2\2\2\u0168\u016d"+
		"\t\2\2\2\u0169\u016c\t\2\2\2\u016a\u016c\5o8\2\u016b\u0169\3\2\2\2\u016b"+
		"\u016a\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2"+
		"\2\2\u016et\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0172\t\3\2\2\u0171\u0170"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0176\b;\2\2\u0176v\3\2\2\2\u0177\u017c\t\4\2\2\u0178"+
		"\u017c\5\63\32\2\u0179\u017c\5\65\33\2\u017a\u017c\5\u008dG\2\u017b\u0177"+
		"\3\2\2\2\u017b\u0178\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017a\3\2\2\2\u017c"+
		"x\3\2\2\2\u017d\u017e\7%\2\2\u017ez\3\2\2\2\u017f\u0183\5y=\2\u0180\u0182"+
		"\n\5\2\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\5}"+
		"?\2\u0187\u0188\3\2\2\2\u0188\u0189\b>\2\2\u0189|\3\2\2\2\u018a\u018c"+
		"\5\u0089E\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2"+
		"\2\u018d\u0190\5\u0085C\2\u018e\u0190\5\u0089E\2\u018f\u018b\3\2\2\2\u018f"+
		"\u018e\3\2\2\2\u0190~\3\2\2\2\u0192\u0193\7\n\2\2\u0193\u0082\3\2\2\2"+
		"\u0194\u0195\7\13\2\2\u0195\u0084\3\2\2\2\u0196\u0197\7\f\2\2\u0197\u0086"+
		"\3\2\2\2\u0198\u0199\7\16\2\2\u0199\u0088\3\2\2\2\u019a\u019b\7\17\2\2"+
		"\u019b\u008a\3\2\2\2\u019d\u019e\7^\2\2\u019e\u008e\3\2\2\2\u019f\u01a6"+
		"\5\63\32\2\u01a0\u01a7\5u;\2\u01a1\u01a7\t\6\2\2\u01a2\u01a7\n\7\2\2\u01a3"+
		"\u01a4\5\u008dG\2\u01a4\u01a5\5w<\2\u01a5\u01a7\3\2\2\2\u01a6\u01a0\3"+
		"\2\2\2\u01a6\u01a1\3\2\2\2\u01a6\u01a2\3\2\2\2\u01a6\u01a3\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\5\63\32\2\u01a9\u0090\3\2\2\2\u01aa\u01b3\5"+
		"\65\33\2\u01ab\u01b2\5u;\2\u01ac\u01b2\t\6\2\2\u01ad\u01b2\n\7\2\2\u01ae"+
		"\u01af\5\u008dG\2\u01af\u01b0\5w<\2\u01b0\u01b2\3\2\2\2\u01b1\u01ab\3"+
		"\2\2\2\u01b1\u01ac\3\2\2\2\u01b1\u01ad\3\2\2\2\u01b1\u01ae\3\2\2\2\u01b2"+
		"\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\5\65\33\2\u01b7\u0092\3\2\2\2\16"+
		"\2\u0166\u016b\u016d\u0173\u017b\u0183\u018b\u018f\u01a6\u01b1\u01b3\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}