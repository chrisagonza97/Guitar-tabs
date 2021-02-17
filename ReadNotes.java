import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.TargetDataLine;

import javax.swing.JTextPane;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
//import be.tarsos.dsp.io.TarsosDSPAudioFormat;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.*;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;
public class ReadNotes {
	//all possible notes that can be played on the guitar
	
	
	
	
	
	static float E2= (float) 82.4069;
	static float G2s= (float) 103.8262;
	static float A2= (float) 110.000;
	static float A2s= (float) 116.5409;
	static float B2= (float) 123.4708;
	static float C3= (float) 130.8128;
	static float C3s=(float) 138.5913;
	static float D3= (float) 146.8324;
	static float D3s= (float) 155.5635;
	static float E3= (float) 164.8138;
	static float F3= (float) 174.6141;
	static float F3s= (float) 184.9972;
	static float G3= (float) 195.9977;
	static float G3s= (float) 207.6523;
	static float A3 = (float) 220.0000;
	static float A3s= (float) 233.0819;
	static float B3= (float) 246.9417;
	static float C4= (float) 261.6256;//1
	static float C4s= (float) 277.1826;
	static float D4= (float) 293.6648;
	static float D4s= (float) 311.1270;
	static float E4= (float) 329.6279;//2
	static float F4 = (float) 349.2282;
	static float F4s= (float) 369.9944;
	static float G4= (float) 391.9954;//4
	static float G4s = (float) 415.3047;
	static float A4= (float) 440.0000;//3
	static float A4s= (float) 466.1638;
	static float B4= (float) 493.8833;
	static float C5= (float) 523.2511;
	static float C5s= (float) 554.3652;
	static float D5= (float) 587.329;
	static float D5s= (float) 622.2540;
	static float E5= (float) 659.2551;
	static float F5= (float) 698.4564;
	static float F5s=(float)739.9888;
	static float G5=(float)783.9908;
	static float G5s=(float)830.6093;
	static float A5=(float)880.0000;
	static float A5s=(float)932.3275;
	static float B5=(float)987.7666;
	static float C6=(float)1046.5023;
	static float C6s=(float)1108.7304;
	static float D6=(float)1174.6590;
	static Tabs tabs = new Tabs();
	
	public static void main(String[] args) throws LineUnavailableException {
		readNotes();
		

	}

	public static void readNotes() throws LineUnavailableException{
PitchDetectionHandler handler = new PitchDetectionHandler() {
	double timecount = 5.5;
	int countdown = 0;
	boolean flag=false;
	//boolean exflag=false;
	
	        public void handlePitch(PitchDetectionResult pitchDetectionResult,
	                AudioEvent audioEvent) {
	        	double time = audioEvent.getTimeStamp();
	        	
	        	if((int)time==countdown&&countdown<5){
	        		countdown++;
	        		System.out.println("notes recording in: " + (5-countdown+1)+" seconds");
	        	}
	        	if((int) time==5&&flag==false){
	        		flag=true;
	        		System.out.println("now");
	        	}
	        	
	        	time=time*10;
	        	int temp = (int)time;
	        	time = (double)temp/10;
	        	if(time==timecount){
	        	timecount=timecount+1.0;
	        	if(pitchDetectionResult.getPitch()>70.0){
	        		float pitch=pitchDetectionResult.getPitch();
	        		if (pitch>(G2s+A2)/2&&pitch<(A2+A2s)/2){
	        			System.out.println("A2");
	        			tabs.notes.add("A2");
	        		}
	        		if (pitch>(A2+A2s)/2&&pitch<(A2s+B2)/2){
	        			System.out.println("A2s");
	        			tabs.notes.add("A2s");
	        		}
	        		if (pitch>(A2s+B2)/2&&pitch<(B2+C3)/2){
	        			System.out.println("B2");
	        			tabs.notes.add("B2");
	        		}
	        		if (pitch>(B2+C3)/2&&pitch<(C3+C3s)/2){
	        			System.out.println("C3");
	        			tabs.notes.add("C3");
	        		}
	        		if (pitch>(C3+C3s)/2&&pitch<(C3s+D3)/2){
	        			System.out.println("C3s");
	        			tabs.notes.add("C3s");
	        		}
	        		if (pitch>(C3s+D3)/2&&pitch<(D3+D3s)/2){
	        			System.out.println("D3");
	        			tabs.notes.add("D3");
	        		}
	        		if (pitch>(D3+D3s)/2&&pitch<(D3s+E3)/2){
	        			System.out.println("D3s");
	        			tabs.notes.add("D3s");
	        		}
	        		if (pitch>(D3s+E3)/2&&pitch<(E3+F3)/2){
	        			System.out.println("E3");
	        			tabs.notes.add("E3");
	        		}
	        		if (pitch>(E3+F3)/2&&pitch<(F3+F3s)/2){
	        			System.out.println("F3");
	        			tabs.notes.add("F3");
	        		}
	        		if (pitch>(F3+F3s)/2&&pitch<(F3s+G3)/2){
	        			System.out.println("F3s");
	        			tabs.notes.add("F3s");
	        		}
	        		if (pitch>(F3s+G3)/2&&pitch<(G3+G3s)/2){
	        			System.out.println("G3");
	        			tabs.notes.add("G3");
	        		}
	        		if (pitch>(G3+G3s)/2&&pitch<(G3s+A3)/2){
	        			System.out.println("G3s");
	        			tabs.notes.add("G3s");
	        		}
	        		if (pitch>(G3s+A3)/2&&pitch<(A3+A3s)/2){
	        			System.out.println("A3");
	        			tabs.notes.add("A3");
	        		}
	        		if (pitch>(A3+A3s)/2&&pitch<(A3s+B3)/2){
	        			System.out.println("A3s");
	        			tabs.notes.add("A3s");
	        		}
	        		if (pitch>(A3s+B3)/2&&pitch<(B3+C4)/2){
	        			System.out.println("B3");
	        			tabs.notes.add("B3");
	        		}
	        		if (pitch>(B3+C4)/2&&pitch<(C4+C4s)/2){
	        			System.out.println("C4");
	        			tabs.notes.add("C4");
	        		}
	        		if (pitch>(C4+C4s)/2&&pitch<(C4s+D4)/2){
	        			System.out.println("C4s");
	        			tabs.notes.add("C4s");
	        		}
	        		if (pitch>(C4s+D4)/2&&pitch<(D4+D4s)/2){
	        			System.out.println("D4");
	        			tabs.notes.add("D4");
	        		}
	        		if (pitch>(D4+D4s)/2&&pitch<(D4s+E4)/2){
	        			System.out.println("D4s");
	        			tabs.notes.add("D4s");
	        		}
	        		if (pitch>(D4s+E4)/2&&pitch<(E4+F4)/2){
	        			System.out.println("E4");
	        			tabs.notes.add("E4");
	        		}
	        		if (pitch>(E4+F4)/2&&pitch<(F4+F4s)/2){
	        			System.out.println("F4");
	        			tabs.notes.add("F4");
	        		}
	        		if (pitch>(F4+F4s)/2&&pitch<(F4s+G4)/2){
	        			System.out.println("F4s");
	        			tabs.notes.add("F4s");
	        		}
	        		if (pitch>(F4s+G4)/2&&pitch<(G4+G4s)/2){
	        			System.out.println("G4");
	        			tabs.notes.add("G4");
	        		}
	        		if (pitch>(G4+G4s)/2&&pitch<(G4s+A4)/2){
	        			System.out.println("G4s");
	        			tabs.notes.add("G4s");
	        		}
	        		if (pitch>(G4s+A4)/2&&pitch<(A4+A4s)/2){
	        			System.out.println("A4");
	        			tabs.notes.add("A4");
	        		}
	        		if (pitch>(A4+A4s)/2&&pitch<(A4s+B4)/2){
	        			System.out.println("A4s");
	        			tabs.notes.add("A4s");
	        		}
	        		if (pitch>(A4s+B4)/2&&pitch<(B4+C5)/2){
	        			System.out.println("B4");
	        			tabs.notes.add("B4");
	        		}
	        		if (pitch>(B4+C5)/2&&pitch<(C5+C5s)/2){
	        			System.out.println("C5");
	        			tabs.notes.add("C5");
	        		}
	        		if (pitch>(C5+C5s)/2&&pitch<(C5s+D5)/2){
	        			System.out.println("C5s");
	        			tabs.notes.add("C5s");
	        		}
	        		if (pitch>(C5s+D5)/2&&pitch<(D5+D5s)/2){
	        			System.out.println("D5");
	        			tabs.notes.add("D5");
	        		}
	        		if (pitch>(D5+D5s)/2&&pitch<(D5s+E5)/2){
	        			System.out.println("D5s");
	        			tabs.notes.add("D5s");
	        		}
	        		if (pitch>(D5s+E5)/2&&pitch<(E5+F5)/2){
	        			System.out.println("E5");
	        			tabs.notes.add("E5");
	        		}
	        		if (pitch>(E5+F5)/2&&pitch<(F5+F5s)/2){
	        			System.out.println("F5");
	        			tabs.notes.add("F5");
	        		}
	        		if (pitch>(F5+F5s)/2&&pitch<(F5s+G5)/2){
	        			System.out.println("F5s");
	        			tabs.notes.add("F5s");
	        		}
	        		if (pitch>(F5s+G5)/2&&pitch<(G5+G5s)/2){
	        			System.out.println("G5");
	        			tabs.notes.add("G5");
	        		}
	        		if (pitch>(G5+G5s)/2&&pitch<(G5s+A5)/2){
	        			System.out.println("G5s");
	        			tabs.notes.add("G5s");
	        		}
	        		if (pitch>(G5s+A5)/2&&pitch<(A5+A5s)/2){
	        			System.out.println("A5");
	        			tabs.notes.add("A5");
	        		}
	        		if (pitch>(A5+A5s)/2&&pitch<(A5s+B5)/2){
	        			System.out.println("A5s");
	        			tabs.notes.add("A5s");
	        		}
	        		if (pitch>(A5s+B5)/2&&pitch<(B5+C6)/2){
	        			System.out.println("B5");
	        			tabs.notes.add("B5");
	        		}
	        		if (pitch>(B5+C6)/2&&pitch<(C6+C6s)/2){
	        			System.out.println("C6");
	        			tabs.notes.add("C6");
	        		}
	        		if (pitch>(C6+C6s)/2&&pitch<(C6s+D6)/2){
	        			System.out.println("C6s");
	        			tabs.notes.add("C6s");
	        		}
	        		if (pitch>(C6s+D6)/2){
	        			System.out.println("D6");
	        			tabs.notes.add("D6");
	        		}
	        		
	        	}
	        }
	        }
	    };
	    AudioDispatcher adp = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
	    adp.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
	    adp.run();
		}
}
