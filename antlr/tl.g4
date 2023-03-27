grammar tl;

//Lexèmes

Id : [a-zA-Z][0-9a-zA-Z_]*;
Int : [0-9]+;
Binop : '&&' |'<' | '+' | '-' |'*'|'=='|'+=' ;
Unop : '!' ;
WS : [ \t\r\n]+ -> skip;

//Règles de grammaire


program : methodDecl*;

methodDecl : type Id '(' (formal (',' formal)*)? ')' statement ;

formal : type Id;

type : 'int'		#intType
	|'boolean'	#boolType
;
 statement : '{' statement* '}'				#statList
	|'if' '(' exp ')' statement 'else' statement	#statIf
	|'while' '(' exp ')' statement			#statWhile
	|'for' '(' statement  exp  statement ')' statement 		#statFor
	|'print' '(' exp ')' ';'			#statPrint
	|Id '=' exp ';'					#statAff
	|Id '++' ';'					#statIncr
	|'return' exp ';'				#statReturn
	|type Id '=' exp ';'				#statVarDeclAff
	|type Id ';'					#statVarDecl
;

exp : exp Binop exp			#exBinop
	|Unop exp			#exUnop
	|Int				#exInt		
	|'true'				#exTrue
	|'false'			#exFalse	
	|'(' exp ')'			#exParenthesis
	|Id '(' (exp (',' exp)*)?  ')'	#exCall
	|Id				#exId
;


