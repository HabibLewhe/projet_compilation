package main;

import java.io.*;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.tlLexer;
import parser.tlParser;
import ast.*;
import printers.*;
import support.*;

import java.nio.file.*;


public class Test{


	private enum ErrorCode{
		SYNTAX_ERROR
	}

	private static InputStream getInputStream(String file){
		try{
			if (file != null){
				return new FileInputStream(file);
			}
		}catch (FileNotFoundException e){
			System.out.println("Erreur : Fichier "+file+ " non trouvé.");
		}
		return System.in;
	}
	private static void exitCode(ErrorCode c){
		System.exit(c.ordinal());
	}

	private static ParseTree parse(InputStream inputStream) throws IOException{
		CharStream input = CharStreams.fromStream(inputStream);

		tlLexer lexer = new tlLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		tlParser parser = new tlParser(tokens);

		ParseTree tree = parser.exp();

		if(parser.getNumberOfSyntaxErrors()!=0){
			System.out.println("erreur de syntaxe : sortie après analyse syntaxique");
			exitCode(ErrorCode.SYNTAX_ERROR);
		}

		return tree;
	}

					
	public static void main(String[] args) throws IOException{

		String file = args[0];
		//String file = "./tests/test2.tl";
		System.out.println("---- Analyse Syntaxique -----");
		InputStream inputStream = getInputStream(file);
		ParseTree tree = parse(inputStream);
		
		System.out.println("---- Construction AST -----");	
		AstBuild astB=new AstBuild();
		//Program ast= (Program) tree.accept(astB);
		Expression ast= (Expression) tree.accept(astB);
		System.out.println("---- Affichage AST -----");
		//AstPrinter printer = new AstPrinter();
		AstMIPSPrinter mipsPrinter = new AstMIPSPrinter();
		ast.accept(mipsPrinter);
		System.out.print("\n");
	}
}
