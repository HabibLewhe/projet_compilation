package ast;
 public enum BinOp{
	ADD{
		public String toString(){
			return "+";
		}
	},
	MIN{
		public String toString(){
			return "-";
		}
	},
	LT{
		public String toString(){
			return "<";
		}
	},
	MULT{
		public String toString(){
			return "*";
		}
	},
	AND{
		public String toString(){
			return "&&";
		}
	},
	EQ{
		public String toString(){
			return "==";
		}
	}


}
