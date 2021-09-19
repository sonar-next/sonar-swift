// Generated from /Users/mark/Github/sonar-swift/objclang/src/main/antlr/ObjectiveCPreprocessorParser.g4 by ANTLR 4.9.1
package com.backelite.sonarqube.objectivec.internal;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ObjectiveCPreprocessorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AUTO=1, BREAK=2, CASE=3, CHAR=4, CONST=5, CONTINUE=6, DEFAULT=7, DO=8, 
		DOUBLE=9, ELSE=10, ENUM=11, EXTERN=12, FLOAT=13, FOR=14, GOTO=15, IF=16, 
		INLINE=17, INT=18, LONG=19, REGISTER=20, RESTRICT=21, RETURN=22, SHORT=23, 
		SIGNED=24, SIZEOF=25, STATIC=26, STRUCT=27, SWITCH=28, TYPEDEF=29, UNION=30, 
		UNSIGNED=31, VOID=32, VOLATILE=33, WHILE=34, BOOL_=35, COMPLEX=36, IMAGINERY=37, 
		TRUE=38, FALSE=39, BOOL=40, Class=41, BYCOPY=42, BYREF=43, ID=44, IMP=45, 
		IN=46, INOUT=47, NIL=48, NO=49, NULL_=50, ONEWAY=51, OUT=52, PROTOCOL_=53, 
		SEL=54, SELF=55, SUPER=56, YES=57, AUTORELEASEPOOL=58, CATCH=59, CLASS=60, 
		DYNAMIC=61, ENCODE=62, END=63, FINALLY=64, IMPLEMENTATION=65, INTERFACE=66, 
		IMPORT=67, PACKAGE=68, PROTOCOL=69, OPTIONAL=70, PRIVATE=71, PROPERTY=72, 
		PROTECTED=73, PUBLIC=74, REQUIRED=75, SELECTOR=76, SYNCHRONIZED=77, SYNTHESIZE=78, 
		THROW=79, TRY=80, ATOMIC=81, NONATOMIC=82, RETAIN=83, ATTRIBUTE=84, AUTORELEASING_QUALIFIER=85, 
		BLOCK=86, BRIDGE=87, BRIDGE_RETAINED=88, BRIDGE_TRANSFER=89, COVARIANT=90, 
		CONTRAVARIANT=91, DEPRECATED=92, KINDOF=93, STRONG_QUALIFIER=94, TYPEOF=95, 
		UNSAFE_UNRETAINED_QUALIFIER=96, UNUSED=97, WEAK_QUALIFIER=98, NULL_UNSPECIFIED=99, 
		NULLABLE=100, NONNULL=101, NULL_RESETTABLE=102, NS_INLINE=103, NS_ENUM=104, 
		NS_OPTIONS=105, ASSIGN=106, COPY=107, GETTER=108, SETTER=109, STRONG=110, 
		READONLY=111, READWRITE=112, WEAK=113, UNSAFE_UNRETAINED=114, IB_OUTLET=115, 
		IB_OUTLET_COLLECTION=116, IB_INSPECTABLE=117, IB_DESIGNABLE=118, NS_ASSUME_NONNULL_BEGIN=119, 
		NS_ASSUME_NONNULL_END=120, EXTERN_SUFFIX=121, IOS_SUFFIX=122, MAC_SUFFIX=123, 
		TVOS_PROHIBITED=124, IDENTIFIER=125, LP=126, RP=127, LBRACE=128, RBRACE=129, 
		LBRACK=130, RBRACK=131, SEMI=132, COMMA=133, DOT=134, STRUCTACCESS=135, 
		AT=136, ASSIGNMENT=137, GT=138, LT=139, BANG=140, TILDE=141, QUESTION=142, 
		COLON=143, EQUAL=144, LE=145, GE=146, NOTEQUAL=147, AND=148, OR=149, INC=150, 
		DEC=151, ADD=152, SUB=153, MUL=154, DIV=155, BITAND=156, BITOR=157, BITXOR=158, 
		MOD=159, ADD_ASSIGN=160, SUB_ASSIGN=161, MUL_ASSIGN=162, DIV_ASSIGN=163, 
		AND_ASSIGN=164, OR_ASSIGN=165, XOR_ASSIGN=166, MOD_ASSIGN=167, LSHIFT_ASSIGN=168, 
		RSHIFT_ASSIGN=169, ELIPSIS=170, CHARACTER_LITERAL=171, STRING_START=172, 
		HEX_LITERAL=173, OCTAL_LITERAL=174, BINARY_LITERAL=175, DECIMAL_LITERAL=176, 
		FLOATING_POINT_LITERAL=177, WS=178, MULTI_COMMENT=179, SINGLE_COMMENT=180, 
		BACKSLASH=181, SHARP=182, STRING_NEWLINE=183, STRING_END=184, STRING_VALUE=185, 
		DIRECTIVE_IMPORT=186, DIRECTIVE_INCLUDE=187, DIRECTIVE_PRAGMA=188, DIRECTIVE_DEFINE=189, 
		DIRECTIVE_DEFINED=190, DIRECTIVE_IF=191, DIRECTIVE_ELIF=192, DIRECTIVE_ELSE=193, 
		DIRECTIVE_UNDEF=194, DIRECTIVE_IFDEF=195, DIRECTIVE_IFNDEF=196, DIRECTIVE_ENDIF=197, 
		DIRECTIVE_TRUE=198, DIRECTIVE_FALSE=199, DIRECTIVE_ERROR=200, DIRECTIVE_WARNING=201, 
		DIRECTIVE_BANG=202, DIRECTIVE_LP=203, DIRECTIVE_RP=204, DIRECTIVE_EQUAL=205, 
		DIRECTIVE_NOTEQUAL=206, DIRECTIVE_AND=207, DIRECTIVE_OR=208, DIRECTIVE_LT=209, 
		DIRECTIVE_GT=210, DIRECTIVE_LE=211, DIRECTIVE_GE=212, DIRECTIVE_STRING=213, 
		DIRECTIVE_ID=214, DIRECTIVE_DECIMAL_LITERAL=215, DIRECTIVE_FLOAT=216, 
		DIRECTIVE_NEWLINE=217, DIRECTIVE_MULTI_COMMENT=218, DIRECTIVE_SINGLE_COMMENT=219, 
		DIRECTIVE_BACKSLASH_NEWLINE=220, DIRECTIVE_TEXT_NEWLINE=221, DIRECTIVE_TEXT=222;
	public static final int
		RULE_directive = 0, RULE_directiveText = 1, RULE_preprocessorExpression = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"directive", "directiveText", "preprocessorExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'auto'", "'break'", "'case'", "'char'", "'const'", "'continue'", 
			"'default'", "'do'", "'double'", null, "'enum'", "'extern'", "'float'", 
			"'for'", "'goto'", null, "'inline'", "'int'", "'long'", "'register'", 
			"'restrict'", "'return'", "'short'", "'signed'", "'sizeof'", "'static'", 
			"'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", "'void'", 
			"'volatile'", "'while'", "'_Bool'", "'_Complex'", "'_Imaginery'", "'true'", 
			"'false'", "'BOOL'", "'Class'", "'bycopy'", "'byref'", "'id'", "'IMP'", 
			"'in'", "'inout'", "'nil'", "'NO'", "'NULL'", "'oneway'", "'out'", "'Protocol'", 
			"'SEL'", "'self'", "'super'", "'YES'", "'@autoreleasepool'", "'@catch'", 
			"'@class'", "'@dynamic'", "'@encode'", "'@end'", "'@finally'", "'@implementation'", 
			"'@interface'", "'@import'", "'@package'", "'@protocol'", "'@optional'", 
			"'@private'", "'@property'", "'@protected'", "'@public'", "'@required'", 
			"'@selector'", "'@synchronized'", "'@synthesize'", "'@throw'", "'@try'", 
			"'atomic'", "'nonatomic'", "'retain'", "'__attribute__'", "'__autoreleasing'", 
			"'__block'", "'__bridge'", "'__bridge_retained'", "'__bridge_transfer'", 
			"'__covariant'", "'__contravariant'", "'__deprecated'", "'__kindof'", 
			"'__strong'", null, "'__unsafe_unretained'", "'__unused'", "'__weak'", 
			null, null, null, "'null_resettable'", "'NS_INLINE'", "'NS_ENUM'", "'NS_OPTIONS'", 
			"'assign'", "'copy'", "'getter'", "'setter'", "'strong'", "'readonly'", 
			"'readwrite'", "'weak'", "'unsafe_unretained'", "'IBOutlet'", "'IBOutletCollection'", 
			"'IBInspectable'", "'IB_DESIGNABLE'", null, null, null, null, null, "'__TVOS_PROHIBITED'", 
			null, null, null, "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'->'", 
			"'@'", "'='", null, null, null, "'~'", "'?'", "':'", null, null, null, 
			null, null, null, "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
			"'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", 
			"'^='", "'%='", "'<<='", "'>>='", "'...'", null, null, null, null, null, 
			null, null, null, null, null, "'\\'", null, null, null, null, null, null, 
			null, null, "'defined'", null, "'elif'", null, "'undef'", "'ifdef'", 
			"'ifndef'", "'endif'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AUTO", "BREAK", "CASE", "CHAR", "CONST", "CONTINUE", "DEFAULT", 
			"DO", "DOUBLE", "ELSE", "ENUM", "EXTERN", "FLOAT", "FOR", "GOTO", "IF", 
			"INLINE", "INT", "LONG", "REGISTER", "RESTRICT", "RETURN", "SHORT", "SIGNED", 
			"SIZEOF", "STATIC", "STRUCT", "SWITCH", "TYPEDEF", "UNION", "UNSIGNED", 
			"VOID", "VOLATILE", "WHILE", "BOOL_", "COMPLEX", "IMAGINERY", "TRUE", 
			"FALSE", "BOOL", "Class", "BYCOPY", "BYREF", "ID", "IMP", "IN", "INOUT", 
			"NIL", "NO", "NULL_", "ONEWAY", "OUT", "PROTOCOL_", "SEL", "SELF", "SUPER", 
			"YES", "AUTORELEASEPOOL", "CATCH", "CLASS", "DYNAMIC", "ENCODE", "END", 
			"FINALLY", "IMPLEMENTATION", "INTERFACE", "IMPORT", "PACKAGE", "PROTOCOL", 
			"OPTIONAL", "PRIVATE", "PROPERTY", "PROTECTED", "PUBLIC", "REQUIRED", 
			"SELECTOR", "SYNCHRONIZED", "SYNTHESIZE", "THROW", "TRY", "ATOMIC", "NONATOMIC", 
			"RETAIN", "ATTRIBUTE", "AUTORELEASING_QUALIFIER", "BLOCK", "BRIDGE", 
			"BRIDGE_RETAINED", "BRIDGE_TRANSFER", "COVARIANT", "CONTRAVARIANT", "DEPRECATED", 
			"KINDOF", "STRONG_QUALIFIER", "TYPEOF", "UNSAFE_UNRETAINED_QUALIFIER", 
			"UNUSED", "WEAK_QUALIFIER", "NULL_UNSPECIFIED", "NULLABLE", "NONNULL", 
			"NULL_RESETTABLE", "NS_INLINE", "NS_ENUM", "NS_OPTIONS", "ASSIGN", "COPY", 
			"GETTER", "SETTER", "STRONG", "READONLY", "READWRITE", "WEAK", "UNSAFE_UNRETAINED", 
			"IB_OUTLET", "IB_OUTLET_COLLECTION", "IB_INSPECTABLE", "IB_DESIGNABLE", 
			"NS_ASSUME_NONNULL_BEGIN", "NS_ASSUME_NONNULL_END", "EXTERN_SUFFIX", 
			"IOS_SUFFIX", "MAC_SUFFIX", "TVOS_PROHIBITED", "IDENTIFIER", "LP", "RP", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "STRUCTACCESS", 
			"AT", "ASSIGNMENT", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", 
			"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
			"MUL", "DIV", "BITAND", "BITOR", "BITXOR", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
			"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
			"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "ELIPSIS", "CHARACTER_LITERAL", 
			"STRING_START", "HEX_LITERAL", "OCTAL_LITERAL", "BINARY_LITERAL", "DECIMAL_LITERAL", 
			"FLOATING_POINT_LITERAL", "WS", "MULTI_COMMENT", "SINGLE_COMMENT", "BACKSLASH", 
			"SHARP", "STRING_NEWLINE", "STRING_END", "STRING_VALUE", "DIRECTIVE_IMPORT", 
			"DIRECTIVE_INCLUDE", "DIRECTIVE_PRAGMA", "DIRECTIVE_DEFINE", "DIRECTIVE_DEFINED", 
			"DIRECTIVE_IF", "DIRECTIVE_ELIF", "DIRECTIVE_ELSE", "DIRECTIVE_UNDEF", 
			"DIRECTIVE_IFDEF", "DIRECTIVE_IFNDEF", "DIRECTIVE_ENDIF", "DIRECTIVE_TRUE", 
			"DIRECTIVE_FALSE", "DIRECTIVE_ERROR", "DIRECTIVE_WARNING", "DIRECTIVE_BANG", 
			"DIRECTIVE_LP", "DIRECTIVE_RP", "DIRECTIVE_EQUAL", "DIRECTIVE_NOTEQUAL", 
			"DIRECTIVE_AND", "DIRECTIVE_OR", "DIRECTIVE_LT", "DIRECTIVE_GT", "DIRECTIVE_LE", 
			"DIRECTIVE_GE", "DIRECTIVE_STRING", "DIRECTIVE_ID", "DIRECTIVE_DECIMAL_LITERAL", 
			"DIRECTIVE_FLOAT", "DIRECTIVE_NEWLINE", "DIRECTIVE_MULTI_COMMENT", "DIRECTIVE_SINGLE_COMMENT", 
			"DIRECTIVE_BACKSLASH_NEWLINE", "DIRECTIVE_TEXT_NEWLINE", "DIRECTIVE_TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ObjectiveCPreprocessorParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ObjectiveCPreprocessorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DirectiveContext extends ParserRuleContext {
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
	 
		public DirectiveContext() { }
		public void copyFrom(DirectiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PreprocessorDefContext extends DirectiveContext {
		public TerminalNode SHARP() { return getToken(ObjectiveCPreprocessorParser.SHARP, 0); }
		public TerminalNode DIRECTIVE_IFDEF() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_IFDEF, 0); }
		public TerminalNode DIRECTIVE_ID() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ID, 0); }
		public TerminalNode DIRECTIVE_IFNDEF() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_IFNDEF, 0); }
		public TerminalNode DIRECTIVE_UNDEF() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_UNDEF, 0); }
		public PreprocessorDefContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorErrorContext extends DirectiveContext {
		public TerminalNode SHARP() { return getToken(ObjectiveCPreprocessorParser.SHARP, 0); }
		public TerminalNode DIRECTIVE_ERROR() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ERROR, 0); }
		public DirectiveTextContext directiveText() {
			return getRuleContext(DirectiveTextContext.class,0);
		}
		public PreprocessorErrorContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorError(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorConditionalContext extends DirectiveContext {
		public TerminalNode SHARP() { return getToken(ObjectiveCPreprocessorParser.SHARP, 0); }
		public TerminalNode DIRECTIVE_IF() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_IF, 0); }
		public PreprocessorExpressionContext preprocessorExpression() {
			return getRuleContext(PreprocessorExpressionContext.class,0);
		}
		public TerminalNode DIRECTIVE_ELIF() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ELIF, 0); }
		public TerminalNode DIRECTIVE_ELSE() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ELSE, 0); }
		public TerminalNode DIRECTIVE_ENDIF() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ENDIF, 0); }
		public PreprocessorConditionalContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorImportContext extends DirectiveContext {
		public TerminalNode SHARP() { return getToken(ObjectiveCPreprocessorParser.SHARP, 0); }
		public DirectiveTextContext directiveText() {
			return getRuleContext(DirectiveTextContext.class,0);
		}
		public TerminalNode DIRECTIVE_IMPORT() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_IMPORT, 0); }
		public TerminalNode DIRECTIVE_INCLUDE() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_INCLUDE, 0); }
		public PreprocessorImportContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorImport(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorPragmaContext extends DirectiveContext {
		public TerminalNode SHARP() { return getToken(ObjectiveCPreprocessorParser.SHARP, 0); }
		public TerminalNode DIRECTIVE_PRAGMA() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_PRAGMA, 0); }
		public DirectiveTextContext directiveText() {
			return getRuleContext(DirectiveTextContext.class,0);
		}
		public PreprocessorPragmaContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorPragma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorPragma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorPragma(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorDefineContext extends DirectiveContext {
		public TerminalNode SHARP() { return getToken(ObjectiveCPreprocessorParser.SHARP, 0); }
		public TerminalNode DIRECTIVE_DEFINE() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_DEFINE, 0); }
		public TerminalNode DIRECTIVE_ID() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ID, 0); }
		public DirectiveTextContext directiveText() {
			return getRuleContext(DirectiveTextContext.class,0);
		}
		public PreprocessorDefineContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorDefine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorWarningContext extends DirectiveContext {
		public TerminalNode SHARP() { return getToken(ObjectiveCPreprocessorParser.SHARP, 0); }
		public TerminalNode DIRECTIVE_WARNING() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_WARNING, 0); }
		public DirectiveTextContext directiveText() {
			return getRuleContext(DirectiveTextContext.class,0);
		}
		public PreprocessorWarningContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorWarning(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorWarning(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorWarning(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_directive);
		int _la;
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PreprocessorImportContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				match(SHARP);
				setState(7);
				_la = _input.LA(1);
				if ( !(_la==DIRECTIVE_IMPORT || _la==DIRECTIVE_INCLUDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(8);
				directiveText();
				}
				break;
			case 2:
				_localctx = new PreprocessorConditionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
				match(SHARP);
				setState(10);
				match(DIRECTIVE_IF);
				setState(11);
				preprocessorExpression(0);
				}
				break;
			case 3:
				_localctx = new PreprocessorConditionalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(12);
				match(SHARP);
				setState(13);
				match(DIRECTIVE_ELIF);
				setState(14);
				preprocessorExpression(0);
				}
				break;
			case 4:
				_localctx = new PreprocessorConditionalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(15);
				match(SHARP);
				setState(16);
				match(DIRECTIVE_ELSE);
				}
				break;
			case 5:
				_localctx = new PreprocessorConditionalContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(17);
				match(SHARP);
				setState(18);
				match(DIRECTIVE_ENDIF);
				}
				break;
			case 6:
				_localctx = new PreprocessorDefContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(19);
				match(SHARP);
				setState(20);
				match(DIRECTIVE_IFDEF);
				setState(21);
				match(DIRECTIVE_ID);
				}
				break;
			case 7:
				_localctx = new PreprocessorDefContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(22);
				match(SHARP);
				setState(23);
				match(DIRECTIVE_IFNDEF);
				setState(24);
				match(DIRECTIVE_ID);
				}
				break;
			case 8:
				_localctx = new PreprocessorDefContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(25);
				match(SHARP);
				setState(26);
				match(DIRECTIVE_UNDEF);
				setState(27);
				match(DIRECTIVE_ID);
				}
				break;
			case 9:
				_localctx = new PreprocessorPragmaContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(28);
				match(SHARP);
				setState(29);
				match(DIRECTIVE_PRAGMA);
				setState(30);
				directiveText();
				}
				break;
			case 10:
				_localctx = new PreprocessorErrorContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(31);
				match(SHARP);
				setState(32);
				match(DIRECTIVE_ERROR);
				setState(33);
				directiveText();
				}
				break;
			case 11:
				_localctx = new PreprocessorWarningContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(34);
				match(SHARP);
				setState(35);
				match(DIRECTIVE_WARNING);
				setState(36);
				directiveText();
				}
				break;
			case 12:
				_localctx = new PreprocessorDefineContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(37);
				match(SHARP);
				setState(38);
				match(DIRECTIVE_DEFINE);
				setState(39);
				match(DIRECTIVE_ID);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DIRECTIVE_TEXT_NEWLINE || _la==DIRECTIVE_TEXT) {
					{
					setState(40);
					directiveText();
					}
				}

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

	public static class DirectiveTextContext extends ParserRuleContext {
		public List<TerminalNode> DIRECTIVE_TEXT() { return getTokens(ObjectiveCPreprocessorParser.DIRECTIVE_TEXT); }
		public TerminalNode DIRECTIVE_TEXT(int i) {
			return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_TEXT, i);
		}
		public List<TerminalNode> DIRECTIVE_TEXT_NEWLINE() { return getTokens(ObjectiveCPreprocessorParser.DIRECTIVE_TEXT_NEWLINE); }
		public TerminalNode DIRECTIVE_TEXT_NEWLINE(int i) {
			return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_TEXT_NEWLINE, i);
		}
		public DirectiveTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directiveText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterDirectiveText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitDirectiveText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitDirectiveText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveTextContext directiveText() throws RecognitionException {
		DirectiveTextContext _localctx = new DirectiveTextContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_directiveText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				_la = _input.LA(1);
				if ( !(_la==DIRECTIVE_TEXT_NEWLINE || _la==DIRECTIVE_TEXT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIRECTIVE_TEXT_NEWLINE || _la==DIRECTIVE_TEXT );
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

	public static class PreprocessorExpressionContext extends ParserRuleContext {
		public PreprocessorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocessorExpression; }
	 
		public PreprocessorExpressionContext() { }
		public void copyFrom(PreprocessorExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PreprocessorParenthesisContext extends PreprocessorExpressionContext {
		public TerminalNode DIRECTIVE_LP() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_LP, 0); }
		public PreprocessorExpressionContext preprocessorExpression() {
			return getRuleContext(PreprocessorExpressionContext.class,0);
		}
		public TerminalNode DIRECTIVE_RP() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_RP, 0); }
		public PreprocessorParenthesisContext(PreprocessorExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorNotContext extends PreprocessorExpressionContext {
		public TerminalNode DIRECTIVE_BANG() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_BANG, 0); }
		public PreprocessorExpressionContext preprocessorExpression() {
			return getRuleContext(PreprocessorExpressionContext.class,0);
		}
		public PreprocessorNotContext(PreprocessorExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorBinaryContext extends PreprocessorExpressionContext {
		public Token op;
		public List<PreprocessorExpressionContext> preprocessorExpression() {
			return getRuleContexts(PreprocessorExpressionContext.class);
		}
		public PreprocessorExpressionContext preprocessorExpression(int i) {
			return getRuleContext(PreprocessorExpressionContext.class,i);
		}
		public TerminalNode DIRECTIVE_EQUAL() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_EQUAL, 0); }
		public TerminalNode DIRECTIVE_NOTEQUAL() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_NOTEQUAL, 0); }
		public TerminalNode DIRECTIVE_AND() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_AND, 0); }
		public TerminalNode DIRECTIVE_OR() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_OR, 0); }
		public TerminalNode DIRECTIVE_LT() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_LT, 0); }
		public TerminalNode DIRECTIVE_GT() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_GT, 0); }
		public TerminalNode DIRECTIVE_LE() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_LE, 0); }
		public TerminalNode DIRECTIVE_GE() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_GE, 0); }
		public PreprocessorBinaryContext(PreprocessorExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorConstantContext extends PreprocessorExpressionContext {
		public TerminalNode DIRECTIVE_TRUE() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_TRUE, 0); }
		public TerminalNode DIRECTIVE_FALSE() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_FALSE, 0); }
		public TerminalNode DIRECTIVE_DECIMAL_LITERAL() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_DECIMAL_LITERAL, 0); }
		public TerminalNode DIRECTIVE_STRING() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_STRING, 0); }
		public PreprocessorConstantContext(PreprocessorExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorConditionalSymbolContext extends PreprocessorExpressionContext {
		public TerminalNode DIRECTIVE_ID() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ID, 0); }
		public TerminalNode DIRECTIVE_LP() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_LP, 0); }
		public PreprocessorExpressionContext preprocessorExpression() {
			return getRuleContext(PreprocessorExpressionContext.class,0);
		}
		public TerminalNode DIRECTIVE_RP() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_RP, 0); }
		public PreprocessorConditionalSymbolContext(PreprocessorExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorConditionalSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorConditionalSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorConditionalSymbol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreprocessorDefinedContext extends PreprocessorExpressionContext {
		public TerminalNode DIRECTIVE_DEFINED() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_DEFINED, 0); }
		public TerminalNode DIRECTIVE_ID() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_ID, 0); }
		public TerminalNode DIRECTIVE_LP() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_LP, 0); }
		public TerminalNode DIRECTIVE_RP() { return getToken(ObjectiveCPreprocessorParser.DIRECTIVE_RP, 0); }
		public PreprocessorDefinedContext(PreprocessorExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).enterPreprocessorDefined(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCPreprocessorParserListener ) ((ObjectiveCPreprocessorParserListener)listener).exitPreprocessorDefined(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ObjectiveCPreprocessorParserVisitor ) return ((ObjectiveCPreprocessorParserVisitor<? extends T>)visitor).visitPreprocessorDefined(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreprocessorExpressionContext preprocessorExpression() throws RecognitionException {
		return preprocessorExpression(0);
	}

	private PreprocessorExpressionContext preprocessorExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PreprocessorExpressionContext _localctx = new PreprocessorExpressionContext(_ctx, _parentState);
		PreprocessorExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_preprocessorExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIRECTIVE_TRUE:
				{
				_localctx = new PreprocessorConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(51);
				match(DIRECTIVE_TRUE);
				}
				break;
			case DIRECTIVE_FALSE:
				{
				_localctx = new PreprocessorConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(DIRECTIVE_FALSE);
				}
				break;
			case DIRECTIVE_DECIMAL_LITERAL:
				{
				_localctx = new PreprocessorConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				match(DIRECTIVE_DECIMAL_LITERAL);
				}
				break;
			case DIRECTIVE_STRING:
				{
				_localctx = new PreprocessorConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				match(DIRECTIVE_STRING);
				}
				break;
			case DIRECTIVE_ID:
				{
				_localctx = new PreprocessorConditionalSymbolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				match(DIRECTIVE_ID);
				setState(60);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(56);
					match(DIRECTIVE_LP);
					setState(57);
					preprocessorExpression(0);
					setState(58);
					match(DIRECTIVE_RP);
					}
					break;
				}
				}
				break;
			case DIRECTIVE_LP:
				{
				_localctx = new PreprocessorParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(DIRECTIVE_LP);
				setState(63);
				preprocessorExpression(0);
				setState(64);
				match(DIRECTIVE_RP);
				}
				break;
			case DIRECTIVE_BANG:
				{
				_localctx = new PreprocessorNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(DIRECTIVE_BANG);
				setState(67);
				preprocessorExpression(6);
				}
				break;
			case DIRECTIVE_DEFINED:
				{
				_localctx = new PreprocessorDefinedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(DIRECTIVE_DEFINED);
				setState(73);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIRECTIVE_ID:
					{
					setState(69);
					match(DIRECTIVE_ID);
					}
					break;
				case DIRECTIVE_LP:
					{
					setState(70);
					match(DIRECTIVE_LP);
					setState(71);
					match(DIRECTIVE_ID);
					setState(72);
					match(DIRECTIVE_RP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(89);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new PreprocessorBinaryContext(new PreprocessorExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_preprocessorExpression);
						setState(77);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(78);
						((PreprocessorBinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIRECTIVE_EQUAL || _la==DIRECTIVE_NOTEQUAL) ) {
							((PreprocessorBinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						preprocessorExpression(6);
						}
						break;
					case 2:
						{
						_localctx = new PreprocessorBinaryContext(new PreprocessorExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_preprocessorExpression);
						setState(80);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(81);
						((PreprocessorBinaryContext)_localctx).op = match(DIRECTIVE_AND);
						setState(82);
						preprocessorExpression(5);
						}
						break;
					case 3:
						{
						_localctx = new PreprocessorBinaryContext(new PreprocessorExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_preprocessorExpression);
						setState(83);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(84);
						((PreprocessorBinaryContext)_localctx).op = match(DIRECTIVE_OR);
						setState(85);
						preprocessorExpression(4);
						}
						break;
					case 4:
						{
						_localctx = new PreprocessorBinaryContext(new PreprocessorExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_preprocessorExpression);
						setState(86);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(87);
						((PreprocessorBinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 209)) & ~0x3f) == 0 && ((1L << (_la - 209)) & ((1L << (DIRECTIVE_LT - 209)) | (1L << (DIRECTIVE_GT - 209)) | (1L << (DIRECTIVE_LE - 209)) | (1L << (DIRECTIVE_GE - 209)))) != 0)) ) {
							((PreprocessorBinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						preprocessorExpression(3);
						}
						break;
					}
					} 
				}
				setState(93);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return preprocessorExpression_sempred((PreprocessorExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean preprocessorExpression_sempred(PreprocessorExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00e0a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2,\n\2\5\2.\n\2\3\3\6\3\61\n\3\r\3\16\3\62\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4L\n\4\5\4N\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\4\2\3\6\5\2\4\6\2\6\3\2\u00bc\u00bd"+
		"\3\2\u00df\u00e0\3\2\u00cf\u00d0\3\2\u00d3\u00d6\2w\2-\3\2\2\2\4\60\3"+
		"\2\2\2\6M\3\2\2\2\b\t\7\u00b8\2\2\t\n\t\2\2\2\n.\5\4\3\2\13\f\7\u00b8"+
		"\2\2\f\r\7\u00c1\2\2\r.\5\6\4\2\16\17\7\u00b8\2\2\17\20\7\u00c2\2\2\20"+
		".\5\6\4\2\21\22\7\u00b8\2\2\22.\7\u00c3\2\2\23\24\7\u00b8\2\2\24.\7\u00c7"+
		"\2\2\25\26\7\u00b8\2\2\26\27\7\u00c5\2\2\27.\7\u00d8\2\2\30\31\7\u00b8"+
		"\2\2\31\32\7\u00c6\2\2\32.\7\u00d8\2\2\33\34\7\u00b8\2\2\34\35\7\u00c4"+
		"\2\2\35.\7\u00d8\2\2\36\37\7\u00b8\2\2\37 \7\u00be\2\2 .\5\4\3\2!\"\7"+
		"\u00b8\2\2\"#\7\u00ca\2\2#.\5\4\3\2$%\7\u00b8\2\2%&\7\u00cb\2\2&.\5\4"+
		"\3\2\'(\7\u00b8\2\2()\7\u00bf\2\2)+\7\u00d8\2\2*,\5\4\3\2+*\3\2\2\2+,"+
		"\3\2\2\2,.\3\2\2\2-\b\3\2\2\2-\13\3\2\2\2-\16\3\2\2\2-\21\3\2\2\2-\23"+
		"\3\2\2\2-\25\3\2\2\2-\30\3\2\2\2-\33\3\2\2\2-\36\3\2\2\2-!\3\2\2\2-$\3"+
		"\2\2\2-\'\3\2\2\2.\3\3\2\2\2/\61\t\3\2\2\60/\3\2\2\2\61\62\3\2\2\2\62"+
		"\60\3\2\2\2\62\63\3\2\2\2\63\5\3\2\2\2\64\65\b\4\1\2\65N\7\u00c8\2\2\66"+
		"N\7\u00c9\2\2\67N\7\u00d9\2\28N\7\u00d7\2\29>\7\u00d8\2\2:;\7\u00cd\2"+
		"\2;<\5\6\4\2<=\7\u00ce\2\2=?\3\2\2\2>:\3\2\2\2>?\3\2\2\2?N\3\2\2\2@A\7"+
		"\u00cd\2\2AB\5\6\4\2BC\7\u00ce\2\2CN\3\2\2\2DE\7\u00cc\2\2EN\5\6\4\bF"+
		"K\7\u00c0\2\2GL\7\u00d8\2\2HI\7\u00cd\2\2IJ\7\u00d8\2\2JL\7\u00ce\2\2"+
		"KG\3\2\2\2KH\3\2\2\2LN\3\2\2\2M\64\3\2\2\2M\66\3\2\2\2M\67\3\2\2\2M8\3"+
		"\2\2\2M9\3\2\2\2M@\3\2\2\2MD\3\2\2\2MF\3\2\2\2N]\3\2\2\2OP\f\7\2\2PQ\t"+
		"\4\2\2Q\\\5\6\4\bRS\f\6\2\2ST\7\u00d1\2\2T\\\5\6\4\7UV\f\5\2\2VW\7\u00d2"+
		"\2\2W\\\5\6\4\6XY\f\4\2\2YZ\t\5\2\2Z\\\5\6\4\5[O\3\2\2\2[R\3\2\2\2[U\3"+
		"\2\2\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\7\3\2\2\2_]\3\2\2\2\n"+
		"+-\62>KM[]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}