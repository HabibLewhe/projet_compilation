package semantic;

import java.util.*;

import ast.*;
import support.Errors;

public class TableBuilder extends ast.BaseVisitor<Void>{
	//NÉCESSITE QUE VOUS AYEZ
	//CODÉ LE VISITEUR GÉNÉRIQUE DE VOTRE AST
	
	private final SymbolTable symbolTable;
	private final Stack<Block> visitedBlocks;//historique des blocs visités : représente l’imbrication courante
	public TableBuilder(){
		super(null);
		visitedBlocks=new Stack<Block>();
		symbolTable=new SymbolTable();
	}

	public SymbolTable getTable(){
		//si la table contient des erreurs, les afficher ici
		//et quitter le programme.
		return symbolTable;
	}

	@Override
	public Void visit(Block b){
		//le visiteur entre dans le bloc
		super.visit(b);
		//le visiteur sort du bloc
		return null;
	}
	@Override
	public Void visit(StatVarDecl vd){
		//regarder (à l’aide de la méthode lookup de la table
		//des symboles) si la variable a déjà été déclarée
		//dans un bloc parent. Si c’est le cas, lever une
		//erreur.
		Type t = symbolTable.variableLookup(vd.getId().getName(), visitedBlocks);
		if(t != null){
			throw new IllegalStateException("La variable à déjà été déclarée dans al bloc parent");
		} else{
			//Sinon, enregistrer la déclaration dans la table
			//locale correspondant au bloc courant (celui au
			//sommet de la pile, récupérable grâce à peek() de la
			//classe Stack.

			Block currentBlock = visitedBlocks.peek();
			symbolTable.addLocalVariable(currentBlock, vd.getId().getName(),vd.getType());
		}


		return null;
	}

	@Override
	public Void visit(MethodDecl md){
		//récupérer le bloc correspondant au corps de la
		//méthode, ainsi que la signature de la méthode.
		Block b = md.getBlock();
		MethodSig sig = symbolTable.methodLookup(md.getId().getName());
		//créer la table locale associée à ce bloc, et y
		//ajouter les variables correspondant aux paramètres.
		symbolTable.localTable(b);
		//entrer dans le bloc (pile)
		//
		//visiter le bloc (super.visit(b))
		super.visit(b);
		//sortir du bloc.
		
		return null;
	}
}
