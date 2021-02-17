import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Tabs {
	ArrayList <String> notes = new ArrayList<String>(0);//not using
	ArrayList<Note> allnotes = new ArrayList<Note>();
	String title;
	int position=0;
	String he="e|";
	String b="B|";
	String g="G|";
	String d="D|";
	String a="A|";
	String le="E|";
	
	ArrayList<TabNote> heline = new ArrayList<TabNote>(0);
	ArrayList<TabNote> bline = new ArrayList<TabNote>(0);
	ArrayList<TabNote> gline = new ArrayList<TabNote>(0);
	ArrayList<TabNote> dline = new ArrayList<TabNote>(0);
	ArrayList<TabNote> aline = new ArrayList<TabNote>(0);
	ArrayList<TabNote> leline = new ArrayList<TabNote>(0);
	
	public Tabs(){
		//allnotes.add(new Note("G2s",-99,-99,-99,-99,-99,4));
		//allnotes.add(arg0)
	}
	
	public void addNote(String note,int e,int b, int g, int d,int a, int le){
		allnotes.add(new Note(note,position,e,b,g,d,a,le));
		position++;
		//notes.add(note);
	}
	
	public void createTabs(){
		int lastnote=0;
		//String wline=""; 
		for (int i=0;i<allnotes.size();i++){
			String wline="";
			if(i==0){
				int min=98;
				if(allnotes.get(i).highe<min&&allnotes.get(i).highe!=-99){
					min =allnotes.get(i).highe;
					wline="he";
				}
				if(allnotes.get(i).bstring<min&&allnotes.get(i).bstring!=-99){
					min =allnotes.get(i).bstring;
					wline="b";
				}
				if(allnotes.get(i).gstring<min&&allnotes.get(i).gstring!=-99){
					min =allnotes.get(i).gstring;
					wline="g";
				}
				if(allnotes.get(i).dstring<min&&allnotes.get(i).dstring!=-99){
					min =allnotes.get(i).dstring;
					wline="d";
				}
				if(allnotes.get(i).astring<min&&allnotes.get(i).astring!=-99){
					min =allnotes.get(i).astring;
					wline="a";
				}
				if(allnotes.get(i).lowe<min&&allnotes.get(i).lowe!=-99){
					min =allnotes.get(i).lowe;
					wline="le";
				}
				
				if(wline.equals("he")){
					allnotes.get(i).fret=min;
					allnotes.get(i).string="he";
					lastnote=min;
					//he+=min;
				}
				if(wline.equals("b")){
					lastnote=min;
					allnotes.get(i).fret=min;
					allnotes.get(i).string="b";
					//b+=min;
				}
				if(wline.equals("g")){
					lastnote=min;
					allnotes.get(i).fret=min;
					allnotes.get(i).string="g";
					//g+=min;
				}
				if(wline.equals("d")){
					allnotes.get(i).fret=min;
					allnotes.get(i).string="d";
					//d+=min;
				}
				if(wline.equals("a")){
					lastnote=min;
					allnotes.get(i).fret=min;
					allnotes.get(i).string="a";
					//a+=min;
				}
				if(wline.equals("le")){
					lastnote=min;
					allnotes.get(i).fret=min;
					allnotes.get(i).string="le";
					//le+=min;
				}
				
				
			}
			int difference=30;
			int fret=0;
			if (Math.abs(allnotes.get(i).highe-lastnote)<difference){
				difference=Math.abs(allnotes.get(i).highe-lastnote);
				wline="he";
				fret=allnotes.get(i).highe;
			}
			if (Math.abs(allnotes.get(i).bstring-lastnote)<difference){
				difference=Math.abs(allnotes.get(i).bstring-lastnote);
				wline="b";
				fret=allnotes.get(i).bstring;
			}
			if (Math.abs(allnotes.get(i).gstring-lastnote)<difference){
				difference=Math.abs(allnotes.get(i).gstring-lastnote);
				wline="g";
				fret=allnotes.get(i).gstring;
			}
			if (Math.abs(allnotes.get(i).dstring-lastnote)<difference){
				difference=Math.abs(allnotes.get(i).dstring-lastnote);
				wline="d";
				fret=allnotes.get(i).dstring;
			}
			if (Math.abs(allnotes.get(i).astring-lastnote)<difference){
				difference=Math.abs(allnotes.get(i).astring-lastnote);
				wline="a";
				fret=allnotes.get(i).astring;
			}
			if (Math.abs(allnotes.get(i).lowe-lastnote)<difference){
				difference=Math.abs(allnotes.get(i).lowe-lastnote);
				wline="e";
				fret=allnotes.get(i).lowe;
			}
			if(wline.equals("he")){
				allnotes.get(i).fret=fret;
				allnotes.get(i).string="he";
				lastnote=fret;
				//he+=min;
			}
			if(wline.equals("b")){
				lastnote=fret;
				allnotes.get(i).fret=fret;
				allnotes.get(i).string="b";
				//b+=min;
			}
			if(wline.equals("g")){
				lastnote=fret;
				allnotes.get(i).fret=fret;
				allnotes.get(i).string="g";
				//g+=min;
			}
			if(wline.equals("d")){
				allnotes.get(i).fret=fret;
				allnotes.get(i).string="d";
				//d+=fret;
			}
			if(wline.equals("a")){
				lastnote=fret;
				allnotes.get(i).fret=fret;
				allnotes.get(i).string="a";
				//a+=min;
			}
			if(wline.equals("le")){
				lastnote=fret;
				allnotes.get(i).fret=fret;
				allnotes.get(i).string="le";
				//le+=min;
			}
			
		}
		makeTabs();
	}
	
	public void makeTabs(){
		
		for(int i=0; i<allnotes.size();i++){
			if(allnotes.get(i).string.equals("he")){
				heline.add(new TabNote(""+allnotes.get(i).fret,allnotes.get(i).position));
			}
			if(allnotes.get(i).string.equals("b")){
				bline.add(new TabNote(""+allnotes.get(i).fret,allnotes.get(i).position));
			}
			if(allnotes.get(i).string.equals("g")){
				gline.add(new TabNote(""+allnotes.get(i).fret,allnotes.get(i).position));
			}
			if(allnotes.get(i).string.equals("d")){
				dline.add(new TabNote(""+allnotes.get(i).fret,allnotes.get(i).position));
			}
			if(allnotes.get(i).string.equals("a")){
				aline.add(new TabNote(""+allnotes.get(i).fret,allnotes.get(i).position));
			}
			if(allnotes.get(i).string.equals("le")){
				leline.add(new TabNote(""+allnotes.get(i).fret,allnotes.get(i).position));
			}
		}
		StringBuilder output = new StringBuilder("e|");
		int notecount=allnotes.size();
		int lastpos=0;
		for(int i=0;i<heline.size();i++){//high e
			
			for(int j=0; j<=heline.get(i).pos-lastpos-1;j++){
				output.append("-");
			}
			lastpos=heline.get(i).pos;
			output.append(""+heline.get(i).fret);
				
		}
		for(int i=0;i<notecount-lastpos+3;i++){
			output.append("-");
		}
		output.append("| \n");
		
		output.append("B|");
		//int notecount=allnotes.size();
		 lastpos=0;
		for(int i=0;i<bline.size();i++){//high e
			
			for(int j=0; j<=bline.get(i).pos-lastpos-1;j++){
				output.append("-");
			}
			lastpos=bline.get(i).pos;
			output.append(""+bline.get(i).fret);
				
		}
		for(int i=0;i<notecount-lastpos+3;i++){
			output.append("-");
		}
		output.append("| \n");
		
		output.append("G|");
		//int notecount=allnotes.size();
		lastpos=0;
		for(int i=0;i<gline.size();i++){//high e
			
			for(int j=0; j<=gline.get(i).pos-lastpos-1;j++){
				output.append("-");
			}
			lastpos=gline.get(i).pos;
			output.append(""+gline.get(i).fret);
				
		}
		for(int i=0;i<notecount-lastpos+3;i++){
			output.append("-");
		}
		output.append("| \n");
		
		output.append("D|");
		//int notecount=allnotes.size();
		lastpos=0;
		for(int i=0;i<dline.size();i++){//high e
			
			for(int j=0; j<=dline.get(i).pos-lastpos-1;j++){
				output.append("-");
			}
			lastpos=dline.get(i).pos;
			output.append(""+dline.get(i).fret);
				
		}
		for(int i=0;i<notecount-lastpos+3;i++){
			output.append("-");
		}
		output.append("| \n");
		
		output.append("A|");
		//int notecount=allnotes.size();
		lastpos=0;
		for(int i=0;i<aline.size();i++){//high e
			
			for(int j=0; j<=aline.get(i).pos-lastpos-1;j++){
				output.append("-");
			}
			lastpos=aline.get(i).pos;
			output.append(""+aline.get(i).fret);
				
		}
		for(int i=0;i<notecount-lastpos+3;i++){
			output.append("-");
		}
		output.append("| \n");
		output.append("E|");
		//int notecount=allnotes.size();
		lastpos=0;
		for(int i=0;i<leline.size();i++){//high e
			
			for(int j=0; j<=leline.get(i).pos-lastpos-1;j++){
				output.append("-");
			}
			lastpos=leline.get(i).pos;
			output.append(""+leline.get(i).fret);
				
		}
		for(int i=0;i<notecount-lastpos+3;i++){
			output.append("-");
		}
		output.append("| \n");
		String out = output.toString();
		title+=".txt";
		//write to a file, a new file
		try {
			PrintWriter outs = new PrintWriter(title);
			outs.print(out);
			
			outs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
