package semantic;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import support.Errors;
import ast.*;

public class SymbolTable {
	//pour les fonctions : 
	private Map<String,MethodSig> methods;
	//pour les blocs : chaque bloc
	// est associé à sa table locale.
	private Map<Block,Map<String,Type>> blocks;

	public SymbolTable(){
		this.methods=new HashMap<>();
		this.blocks=new HashMap<>();
	}

	public void addMethod(String nom,MethodSig ms){
		methods.putIfAbsent(nom, ms);
	}
	public void addLocalVariable(Block block,String nom,Type type){
		blocks.get(block).put(nom, type);
	}
	public void localTable(Block b){
		//Ajoute la table locale du block b
		if(blocks.get(b)==null){
			Map<String,Type> localT =new HashMap<>();
			blocks.put(b,localT);
		}
	}
	public MethodSig methodLookup(String name){
		//… récupérer une methode par son nom afin de la visualiser

		MethodSig method = methods.get(name);
		return method;
	}
	public Type variableLookup(String name,Stack<Block> visitedBlocks) {
		//retourne le type d’une variable, dans un historique
		//de blocs donné. Lève une erreur si le bloc, n’est
		//pas associé à une table locale, mais peut retourner
		//null (sans forcément lever une erreur si l’on n’a
		//pas trouvé de type).

		Type t = null;
		while (!visitedBlocks.empty()) {

			Block b = visitedBlocks.peek();

			if (blocks.get(b) == null) {
				throw new IllegalStateException("Le bloc n'est associé à aucune table");
			} else {

				if (blocks.get(b).get(name) != null)
					t = blocks.get(b).get(name);
				else
					return null;
			}
		}

		return t;
	}


}
