package aplicacao;

public class Operacoes {

	public static boolean and (boolean p, boolean q) {
		
		return p && q;
	}
	
	public static boolean and (boolean p, boolean q, boolean r) {
		
		return p && q && r;
	}
	
	public static boolean and (boolean p, boolean q, boolean r, boolean s) {
		
		return p && q && r && s;
	}
	
	public static boolean or (boolean p, boolean q) {
		
		return p || q;
	}
	
	public static boolean or (boolean p, boolean q, boolean r) {
		
		return p || q || r;
	}
	
	public static boolean or (boolean p, boolean q, boolean r, boolean s) {
		
		return p || q || r || s;
	}
	
	public static boolean conditional (boolean p, boolean q) {
		
		return !p || q;
	}
	
	public static boolean biconditional (boolean p, boolean q) {
		
		return (!p || q) && (!q || p);
	}
}
