//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.TargetDataLine;

import javax.swing.JTextPane;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
//import be.tarsos.dsp.io.TarsosDSPAudioFormat;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.*;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;


public class driver {
	//pitches of the Ukulele Strings.
	static float G4= (float) 391.9954;//4
	static float C4= (float) 261.6256;//1
	static float E4= (float) 329.6279;//2
	static float A4= (float) 440.0000;//3
	
	static float E2= (float) 82.4069;
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
	static float C4s= (float) 277.1826;
	static float D4= (float) 293.6648;
	static float D4s= (float) 311.1270;
	static float F4 = (float) 349.2282;
	static float F4s= (float) 369.9944;
	static float G4s = (float) 415.3047;
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
	
	//static float E4= (float) 329.6276;
	public static void main(String[] args) throws LineUnavailableException {
		
		//tuneUke();
		tuneGuitar();
	}
	public static void tuneUke() throws LineUnavailableException{
		PitchDetectionHandler handler = new PitchDetectionHandler() {
	        
	        public void handlePitch(PitchDetectionResult pitchDetectionResult,
	                AudioEvent audioEvent) {
	        	if (pitchDetectionResult.getPitch()>70.0){
	        		//System.out.println(audioEvent.getTimeStamp() + " " +pitchDetectionResult.getPitch());
	        		float pitch=pitchDetectionResult.getPitch();
	        		if(pitch<(G4+A4)/2&&pitch>(E4+G4)/2){
	        			if(pitch<G4-(G4*.01)){
	        				System.out.println("tune G string up: frequency is: "+pitch+", should be: "+G4);
	        			}
	        			if(pitch>(G4*.01)+G4){
	        				System.out.println("tune G string down: frequency is: "+pitch+", should be: "+G4);
	        			}
	        			if(pitch<(G4*.01)+G4&&pitch>G4-(G4*.01)){
	        				System.out.println("G string is tuned");
	        				
	        			}
	        		}
	        		if (pitch<(C4+E4)/2){
	        			if(pitch<C4-(C4*.01)){
	        				System.out.println("tune C string up: frequency is: "+pitch+", should be: "+C4);
	        			}
	        			if(pitch>(C4*.01)+C4){
	        				System.out.println("tune C string down: frequency is: "+pitch+", should be: "+C4);
	        			}
	        			if(pitch<(C4*.01)+C4&&pitch>C4-(C4*.01)){
	        				System.out.println("C string is tuned");
	        				
	        			}
	        		}
	        		if (pitch<(E4+G4)/2&&pitch>(C4+E4)/2){
	        			if(pitch<E4-(E4*.01)){
	        				System.out.println("tune E string up: frequency is: "+pitch+", should be: "+E4);
	        			}
	        			if(pitch>(E4*.01)+E4){
	        				System.out.println("tune E string down: frequency is: "+pitch+", should be: "+E4);
	        			}
	        			if(pitch<(E4*.01)+E4&&pitch>E4-(E4*.01)){
	        				System.out.println("E string is tuned");
	        				
	        			}
	        		}
	        		if(pitch>(G4+A4)/2){
	        			if(pitch<A4-(A4*.01)){
	        				System.out.println("tune A string up: frequency is: "+pitch+", should be: "+A4);
	        			}
	        			if(pitch>(A4*.01)+A4){
	        				System.out.println("tune A string down: frequency is: "+pitch+", should be: "+A4);
	        			}
	        			if(pitch<(A4*.01)+A4&&pitch>A4-(A4*.01)){
	        				System.out.println("A string is tuned");
	        				
	        			}
	        			//if(atuned==true){
	        				//System.out.println("instrument is tuned");
	        				//return;
	        			//}
	        		}
	        	}	
	            //Handle pitch here, tell user to tune up or tune down
	        }
	    };
	    AudioDispatcher adp = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
	    adp.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
	    adp.run();
		}
	public static void tuneGuitar() throws LineUnavailableException{
		PitchDetectionHandler handler = new PitchDetectionHandler() {
	        
	        public void handlePitch(PitchDetectionResult pitchDetectionResult,
	                AudioEvent audioEvent) {
	        	if (pitchDetectionResult.getPitch()>70.0){
	        		//System.out.println(audioEvent.getTimeStamp() + " " +pitchDetectionResult.getPitch());
	        		float pitch=pitchDetectionResult.getPitch();
	        		if(pitch<(E2+A2)/2){
	        			if(pitch<E2-(E2*.01)){
	        				System.out.println("tune low E string up: frequency is: "+pitch+", should be: "+E2);
	        			}
	        			if(pitch>(E2*.01)+E2){
	        				System.out.println("tune low E string down: frequency is: "+pitch+", should be: "+E2);
	        			}
	        			if(pitch<(E2*.01)+E2&&pitch>E2-(E2*.01)){
	        				System.out.println("low E string is tuned");
	        				
	        			}
	        		}
	        		if (pitch>=(A2+E2)/2&&pitch<(A2+D3)/2){
	        			if(pitch<A2-(A2*.01)){
	        				System.out.println("tune A string up: frequency is: "+pitch+", should be: "+A2);
	        			}
	        			if(pitch>(A2*.01)+A2){
	        				System.out.println("tune A string down: frequency is: "+pitch+", should be: "+A2);
	        			}
	        			if(pitch<(A2*.01)+A2&&pitch>A2-(A2*.01)){
	        				System.out.println("A string is tuned");
	        				
	        			}
	        		}
	        		if (pitch<(D3+G3)/2&&pitch>=(A2+D3)/2){
	        			if(pitch<D3-(D3*.01)){
	        				System.out.println("tune D string up: frequency is: "+pitch+", should be: "+D3);
	        			}
	        			if(pitch>(D3*.01)+D3){
	        				System.out.println("tune D string down: frequency is: "+pitch+", should be: "+D3);
	        			}
	        			if(pitch<(D3*.01)+D3&&pitch>D3-(D3*.01)){
	        				System.out.println("D string is tuned");
	        				
	        			}
	        		}
	        		if(pitch<(B3+G3)/2&&pitch>=(G3+D3)/2){
	        			if(pitch<G3-(G3*.01)){
	        				System.out.println("tune G string up: frequency is: "+pitch+", should be: "+G3);
	        			}
	        			if(pitch>(G3*.01)+G3){
	        				System.out.println("tune G string down: frequency is: "+pitch+", should be: "+G3);
	        			}
	        			if(pitch<(G3*.01)+G3&&pitch>G3-(G3*.01)){
	        				System.out.println("G string is tuned");
	        				
	        			}
	        		
	        			//if(atuned==true){
	        				//System.out.println("instrument is tuned");
	        				//return;
	        			//}
	        		}
	        		if (pitch<(E4+B3)/2&&pitch>=(B3+G3)/2){
	        			if(pitch<B3-(B3*.01)){
	        				System.out.println("tune B string up: frequency is: "+pitch+", should be: "+B3);
	        			}
	        			if(pitch>(B3*.01)+B3){
	        				System.out.println("tune B string down: frequency is: "+pitch+", should be: "+B3);
	        			}
	        			if(pitch<(B3*.01)+B3&&pitch>B3-(B3*.01)){
	        				System.out.println("B string is tuned");
	        				
	        			}
	        		}
	        		if(pitch>(B3+E4)/2){
	        			if(pitch<E4-(E4*.01)){
	        				System.out.println("tune high E string up: frequency is: "+pitch+", should be: "+E4);
	        			}
	        			if(pitch>(E4*.01)+E4){
	        				System.out.println("tune high E string down: frequency is: "+pitch+", should be: "+E4);
	        			}
	        			if(pitch<(E4*.01)+E4&&pitch>E4-(E4*.01)){
	        				System.out.println("high E string is tuned");
	        				
	        			}
	        		}
	        	}	
	            //Handle pitch here, tell user to tune up or tune down
	        }
	    };
	    AudioDispatcher adp = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
	    adp.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
	    adp.run();
		}
	public static void tuneLowE(final JTextPane txtpnTestText) throws LineUnavailableException{
		PitchDetectionHandler handler = new PitchDetectionHandler() {
	        
	        public void handlePitch(PitchDetectionResult pitchDetectionResult,
	                AudioEvent audioEvent) {
	        	if (pitchDetectionResult.getPitch()>70.0){
	        		//System.out.println(audioEvent.getTimeStamp() + " " +pitchDetectionResult.getPitch());
	        		float pitch=pitchDetectionResult.getPitch();
	        		if(pitch<(E2+A2)/2){
	        			if(pitch<E2-(E2*.01)){
	        				txtpnTestText.setText("tune low E string up: frequency is: "+pitch+", should be: "+E2);
	        				
	        			}
	        			if(pitch>(E2*.01)+E2){
	        				txtpnTestText.setText("tune low E string down: frequency is: "+pitch+", should be: "+E2);
	        			}
	        			if(pitch<(E2*.01)+E2&&pitch>E2-(E2*.01)){
	        				txtpnTestText.setText("low E string is tuned");
	        				
	        			}
	        		}
	        		return;
	        	}	
	            //Handle pitch here, tell user to tune up or tune down
	        }
	    };
	    AudioDispatcher adp = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
	    adp.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
	    adp.run();
		}
}
