
public class Note {

	String notename;
	int highe;
	int bstring;
	int gstring;
	int dstring;
	int astring;
	int lowe;
	
	int position;
	
	int fret;
	String string;
	
	public Note(String name,int pos,int e,int b,int g, int d, int a, int le){
		notename = name;
		position = pos;
		highe = e;
		bstring = b;
		gstring = g;
		dstring = d;
		astring = a;
		lowe = le;
	}
	
	
}
