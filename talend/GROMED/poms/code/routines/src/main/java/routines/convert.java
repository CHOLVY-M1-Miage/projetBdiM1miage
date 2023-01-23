package routines;

public class convert {

	/*
	 * toBoolean: -comparaise 2 chaines de caractère et retour
	 * True: quand les chaîne sont identîques
	 * False: quand les chaîne sont diffèrente
	 */
	public static boolean toBoolean(String src, String ref) {
    	return src.toUpperCase().equals(ref.toUpperCase());
    }
    
	/*
	 * toSlug: -concaténer prénom + nom
	 * 			-  convertir la chaine en mininuscule
	 */
    public static String getSlug(String firstName, String lastName) {
    	return (firstName + "-" + lastName + TalendString.getAsciiRandomString(4)).toLowerCase();
    }
    
    /*
     * prixCut: -retourne le ième prix(en entier)
     * 
     */
    public static float getPrixI(String prixString,int i) {
    	if (prixString.equals("//")){ return (float) -100.0;}
    	String stringPrix = prixString.split("/")[i];
    	return  Float.parseFloat(stringPrix.replaceAll(",", "."));
    }
}