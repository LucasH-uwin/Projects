import java_cup.runtime.*;
%%

%implements java_cup.runtime.Scanner
%type Symbol
%function next_token
%class A4Scanner
%unicode
%eofval{ 
return null;
%eofval}
%state COMMENT

IDENTIFIER = [a-zA-Z][a-zA-Z0-9]*
NUMBER = [0-9]+(\.[0-9]+)?
%%

<YYINITIAL> "/**" { yybegin(COMMENT); }
<COMMENT> "**/" { yybegin(YYINITIAL); }
<COMMENT> [ \t\r\n\f]+ { }
<COMMENT> . { }

<YYINITIAL> "INT"    { return new Symbol(A4Symbol.INT); }
<YYINITIAL> "BEGIN"  { return new Symbol(A4Symbol.BEGIN); }
<YYINITIAL> "END"    { return new Symbol(A4Symbol.END); }
<YYINITIAL> "WRITE"  { return new Symbol(A4Symbol.WRITE); }
<YYINITIAL> "READ"   { return new Symbol(A4Symbol.READ); }
<YYINITIAL> "IF"     { return new Symbol(A4Symbol.IF); }
<YYINITIAL> "ELSE"   { return new Symbol(A4Symbol.ELSE); }
<YYINITIAL> "RETURN" { return new Symbol(A4Symbol.RETURN); }
<YYINITIAL> "MAIN"   { return new Symbol(A4Symbol.MAIN); }
<YYINITIAL> "STRING" { return new Symbol(A4Symbol.STRING); }
<YYINITIAL> "REAL"   { return new Symbol(A4Symbol.REAL); }
<YYINITIAL> "TRUE"   { return new Symbol(A4Symbol.TRUE); }
<YYINITIAL> "FALSE"   { return new Symbol(A4Symbol.FALSE); }

<YYINITIAL> ";"        { return new Symbol(A4Symbol.SEMI); }
<YYINITIAL> ":="       { return new Symbol(A4Symbol.ASSIGN); }
<YYINITIAL> "!="       { return new Symbol(A4Symbol.NOTEQUAL); }
<YYINITIAL> \"[^\"]*\" { return new Symbol(A4Symbol.QSTRING, yytext()); }
<YYINITIAL> \'[^\']*\' { return new Symbol(A4Symbol.QSTRING, yytext()); }
<YYINITIAL> "=="       { return new Symbol(A4Symbol.BEQUAL); }
<YYINITIAL> "="       { return new Symbol(A4Symbol.EQUAL); }
<YYINITIAL> [+-]   { return new Symbol(A4Symbol.ASOPERATION, yytext()); }
<YYINITIAL> [*/]   { return new Symbol(A4Symbol.MDOPERATION, yytext()); }
<YYINITIAL> "("        { return new Symbol(A4Symbol.LPAREN); }
<YYINITIAL> ")"        { return new Symbol(A4Symbol.RPAREN); }
<YYINITIAL> ","        { return new Symbol(A4Symbol.COMMA); }

<YYINITIAL> {IDENTIFIER} { return new Symbol(A4Symbol.IDENTIFIER, yytext()); }
<YYINITIAL> {NUMBER} { return new Symbol(A4Symbol.NUMBER, yytext()); }  

<YYINITIAL> [ \t\r\n\f]+ { }
<YYINITIAL> . { return new Symbol(A4Symbol.error); }