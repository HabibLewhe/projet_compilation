package parser;
 // Generated from antlr/tl.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, Id=19, Int=20, Binop=21, Unop=22, WS=23;
	public static final int
		RULE_program = 0, RULE_methodDecl = 1, RULE_formal = 2, RULE_type = 3, 
		RULE_statement = 4, RULE_exp = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "methodDecl", "formal", "type", "statement", "exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'int'", "'boolean'", "'{'", "'}'", "'if'", 
			"'else'", "'while'", "'for'", "'print'", "';'", "'='", "'++'", "'return'", 
			"'true'", "'false'", null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "Id", "Int", "Binop", "Unop", 
			"WS"
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
	public String getGrammarFileName() { return "tl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				{
				setState(12);
				methodDecl();
				}
				}
				setState(17);
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

	public static class MethodDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			type();
			setState(19);
			match(Id);
			setState(20);
			match(T__0);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3 || _la==T__4) {
				{
				setState(21);
				formal();
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(22);
					match(T__1);
					setState(23);
					formal();
					}
					}
					setState(28);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(31);
			match(T__2);
			setState(32);
			statement();
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

	public static class FormalContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitFormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			type();
			setState(35);
			match(Id);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(T__3);
				}
				break;
			case T__4:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(T__4);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatWhileContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatVarDeclAffContext extends StatementContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatVarDeclAffContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatVarDeclAff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatVarDeclAff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatVarDeclAff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatVarDeclContext extends StatementContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public StatVarDeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatListContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatListContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAffContext extends StatementContext {
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatAffContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatAff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatAff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatAff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatPrintContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatPrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatIfContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatReturnContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatIncrContext extends StatementContext {
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public StatIncrContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatIncr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatIncr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatIncr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatForContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterStatFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitStatFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitStatFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new StatListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(T__5);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__15) | (1L << Id))) != 0)) {
					{
					{
					setState(42);
					statement();
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new StatIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(T__7);
				setState(50);
				match(T__0);
				setState(51);
				exp(0);
				setState(52);
				match(T__2);
				setState(53);
				statement();
				setState(54);
				match(T__8);
				setState(55);
				statement();
				}
				break;
			case 3:
				_localctx = new StatWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				match(T__9);
				setState(58);
				match(T__0);
				setState(59);
				exp(0);
				setState(60);
				match(T__2);
				setState(61);
				statement();
				}
				break;
			case 4:
				_localctx = new StatForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				match(T__10);
				setState(64);
				match(T__0);
				setState(65);
				statement();
				setState(66);
				exp(0);
				setState(67);
				statement();
				setState(68);
				match(T__2);
				setState(69);
				statement();
				}
				break;
			case 5:
				_localctx = new StatPrintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				match(T__11);
				setState(72);
				match(T__0);
				setState(73);
				exp(0);
				setState(74);
				match(T__2);
				setState(75);
				match(T__12);
				}
				break;
			case 6:
				_localctx = new StatAffContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				match(Id);
				setState(78);
				match(T__13);
				setState(79);
				exp(0);
				setState(80);
				match(T__12);
				}
				break;
			case 7:
				_localctx = new StatIncrContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				match(Id);
				setState(83);
				match(T__14);
				setState(84);
				match(T__12);
				}
				break;
			case 8:
				_localctx = new StatReturnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(85);
				match(T__15);
				setState(86);
				exp(0);
				setState(87);
				match(T__12);
				}
				break;
			case 9:
				_localctx = new StatVarDeclAffContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(89);
				type();
				setState(90);
				match(Id);
				setState(91);
				match(T__13);
				setState(92);
				exp(0);
				setState(93);
				match(T__12);
				}
				break;
			case 10:
				_localctx = new StatVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(95);
				type();
				setState(96);
				match(Id);
				setState(97);
				match(T__12);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExUnopContext extends ExpContext {
		public TerminalNode Unop() { return getToken(tlParser.Unop, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExUnopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExUnop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExUnop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExUnop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExIdContext extends ExpContext {
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public ExIdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExFalseContext extends ExpContext {
		public ExFalseContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExCallContext extends ExpContext {
		public TerminalNode Id() { return getToken(tlParser.Id, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExCallContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExParenthesisContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExParenthesisContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExIntContext extends ExpContext {
		public TerminalNode Int() { return getToken(tlParser.Int, 0); }
		public ExIntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExBinopContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode Binop() { return getToken(tlParser.Binop, 0); }
		public ExBinopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExTrueContext extends ExpContext {
		public ExTrueContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).enterExTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tlListener ) ((tlListener)listener).exitExTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tlVisitor ) return ((tlVisitor<? extends T>)visitor).visitExTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ExUnopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(102);
				match(Unop);
				setState(103);
				exp(7);
				}
				break;
			case 2:
				{
				_localctx = new ExIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				match(Int);
				}
				break;
			case 3:
				{
				_localctx = new ExTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(T__16);
				}
				break;
			case 4:
				{
				_localctx = new ExFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(T__17);
				}
				break;
			case 5:
				{
				_localctx = new ExParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(T__0);
				setState(108);
				exp(0);
				setState(109);
				match(T__2);
				}
				break;
			case 6:
				{
				_localctx = new ExCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				match(Id);
				setState(112);
				match(T__0);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__17) | (1L << Id) | (1L << Int) | (1L << Unop))) != 0)) {
					{
					setState(113);
					exp(0);
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(114);
						match(T__1);
						setState(115);
						exp(0);
						}
						}
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(123);
				match(T__2);
				}
				break;
			case 7:
				{
				_localctx = new ExIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(Id);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExBinopContext(new ExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(127);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(128);
					match(Binop);
					setState(129);
					exp(9);
					}
					} 
				}
				setState(134);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u0088\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000"+
		"\f\u0000\u0011\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001\u0019\b\u0001\n\u0001\f\u0001\u001c"+
		"\t\u0001\u0003\u0001\u001e\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"(\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004,\b\u0004\n\u0004\f\u0004"+
		"/\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004d\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005u\b\u0005\n\u0005\f\u0005"+
		"x\t\u0005\u0003\u0005z\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005~\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0083\b\u0005\n"+
		"\u0005\f\u0005\u0086\t\u0005\u0001\u0005\u0000\u0001\n\u0006\u0000\u0002"+
		"\u0004\u0006\b\n\u0000\u0000\u0098\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0002\u0012\u0001\u0000\u0000\u0000\u0004\"\u0001\u0000\u0000\u0000\u0006"+
		"\'\u0001\u0000\u0000\u0000\bc\u0001\u0000\u0000\u0000\n}\u0001\u0000\u0000"+
		"\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000\u0000\u000e"+
		"\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010"+
		"\u0001\u0000\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u000f"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0006\u0003\u0000\u0013\u0014"+
		"\u0005\u0013\u0000\u0000\u0014\u001d\u0005\u0001\u0000\u0000\u0015\u001a"+
		"\u0003\u0004\u0002\u0000\u0016\u0017\u0005\u0002\u0000\u0000\u0017\u0019"+
		"\u0003\u0004\u0002\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0019\u001c"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000\u0000\u0000\u001c\u001a"+
		"\u0001\u0000\u0000\u0000\u001d\u0015\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0003\u0000\u0000 !\u0003\b\u0004\u0000!\u0003\u0001\u0000\u0000\u0000"+
		"\"#\u0003\u0006\u0003\u0000#$\u0005\u0013\u0000\u0000$\u0005\u0001\u0000"+
		"\u0000\u0000%(\u0005\u0004\u0000\u0000&(\u0005\u0005\u0000\u0000\'%\u0001"+
		"\u0000\u0000\u0000\'&\u0001\u0000\u0000\u0000(\u0007\u0001\u0000\u0000"+
		"\u0000)-\u0005\u0006\u0000\u0000*,\u0003\b\u0004\u0000+*\u0001\u0000\u0000"+
		"\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u00000d\u0005"+
		"\u0007\u0000\u000012\u0005\b\u0000\u000023\u0005\u0001\u0000\u000034\u0003"+
		"\n\u0005\u000045\u0005\u0003\u0000\u000056\u0003\b\u0004\u000067\u0005"+
		"\t\u0000\u000078\u0003\b\u0004\u00008d\u0001\u0000\u0000\u00009:\u0005"+
		"\n\u0000\u0000:;\u0005\u0001\u0000\u0000;<\u0003\n\u0005\u0000<=\u0005"+
		"\u0003\u0000\u0000=>\u0003\b\u0004\u0000>d\u0001\u0000\u0000\u0000?@\u0005"+
		"\u000b\u0000\u0000@A\u0005\u0001\u0000\u0000AB\u0003\b\u0004\u0000BC\u0003"+
		"\n\u0005\u0000CD\u0003\b\u0004\u0000DE\u0005\u0003\u0000\u0000EF\u0003"+
		"\b\u0004\u0000Fd\u0001\u0000\u0000\u0000GH\u0005\f\u0000\u0000HI\u0005"+
		"\u0001\u0000\u0000IJ\u0003\n\u0005\u0000JK\u0005\u0003\u0000\u0000KL\u0005"+
		"\r\u0000\u0000Ld\u0001\u0000\u0000\u0000MN\u0005\u0013\u0000\u0000NO\u0005"+
		"\u000e\u0000\u0000OP\u0003\n\u0005\u0000PQ\u0005\r\u0000\u0000Qd\u0001"+
		"\u0000\u0000\u0000RS\u0005\u0013\u0000\u0000ST\u0005\u000f\u0000\u0000"+
		"Td\u0005\r\u0000\u0000UV\u0005\u0010\u0000\u0000VW\u0003\n\u0005\u0000"+
		"WX\u0005\r\u0000\u0000Xd\u0001\u0000\u0000\u0000YZ\u0003\u0006\u0003\u0000"+
		"Z[\u0005\u0013\u0000\u0000[\\\u0005\u000e\u0000\u0000\\]\u0003\n\u0005"+
		"\u0000]^\u0005\r\u0000\u0000^d\u0001\u0000\u0000\u0000_`\u0003\u0006\u0003"+
		"\u0000`a\u0005\u0013\u0000\u0000ab\u0005\r\u0000\u0000bd\u0001\u0000\u0000"+
		"\u0000c)\u0001\u0000\u0000\u0000c1\u0001\u0000\u0000\u0000c9\u0001\u0000"+
		"\u0000\u0000c?\u0001\u0000\u0000\u0000cG\u0001\u0000\u0000\u0000cM\u0001"+
		"\u0000\u0000\u0000cR\u0001\u0000\u0000\u0000cU\u0001\u0000\u0000\u0000"+
		"cY\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000d\t\u0001\u0000\u0000"+
		"\u0000ef\u0006\u0005\uffff\uffff\u0000fg\u0005\u0016\u0000\u0000g~\u0003"+
		"\n\u0005\u0007h~\u0005\u0014\u0000\u0000i~\u0005\u0011\u0000\u0000j~\u0005"+
		"\u0012\u0000\u0000kl\u0005\u0001\u0000\u0000lm\u0003\n\u0005\u0000mn\u0005"+
		"\u0003\u0000\u0000n~\u0001\u0000\u0000\u0000op\u0005\u0013\u0000\u0000"+
		"py\u0005\u0001\u0000\u0000qv\u0003\n\u0005\u0000rs\u0005\u0002\u0000\u0000"+
		"su\u0003\n\u0005\u0000tr\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000yq\u0001\u0000\u0000\u0000yz\u0001\u0000"+
		"\u0000\u0000z{\u0001\u0000\u0000\u0000{~\u0005\u0003\u0000\u0000|~\u0005"+
		"\u0013\u0000\u0000}e\u0001\u0000\u0000\u0000}h\u0001\u0000\u0000\u0000"+
		"}i\u0001\u0000\u0000\u0000}j\u0001\u0000\u0000\u0000}k\u0001\u0000\u0000"+
		"\u0000}o\u0001\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000~\u0084\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\n\b\u0000\u0000\u0080\u0081\u0005\u0015"+
		"\u0000\u0000\u0081\u0083\u0003\n\u0005\t\u0082\u007f\u0001\u0000\u0000"+
		"\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u000b\u0001\u0000\u0000"+
		"\u0000\u0086\u0084\u0001\u0000\u0000\u0000\n\u000f\u001a\u001d\'-cvy}"+
		"\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}