import javax.sound.sampled.LineUnavailableException;
import javax.swing.JTextPane;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;


public class TuneThread extends Thread{
	static float G4= (float) 391.9954;//4
	static float C4= (float) 261.6256;//1
	static float E4= (float) 329.6279;//2
	static float A4= (float) 440.0000;//3
	
	static float E2= (float) 82.4069;
	static float A2= (float) 110.000;
	static float D3= (float) 146.8324;
	static float G3= (float) 195.9977;
	static float B3= (float) 246.9417;
	static JTextPane textPane;
	
	public TuneThread(JTextPane textPane){
		this.textPane=textPane;
	}
	public void run(){
		try {
			tuneE();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void tuneE() throws LineUnavailableException{
		PitchDetectionHandler handler = new PitchDetectionHandler() {
			        
			        public void handlePitch(PitchDetectionResult pitchDetectionResult,
			                AudioEvent audioEvent) {
			        	if (pitchDetectionResult.getPitch()>70.0){
			        		//System.out.println(audioEvent.getTimeStamp() + " " +pitchDetectionResult.getPitch());
			        		final float pitch=pitchDetectionResult.getPitch();
			        		if(pitch<(E2+A2)/2){
			        			if(pitch<E2-(E2*.01)){
			        				System.out.println("tune low E string up: frequency is: "+pitch+", should be: "+E2);
			        				textPane.setText("tune low E string up: frequency is: "+pitch+", should be: "+E2);
			        				
			        				//SwingUtilities
			        			
			        				
			        			}
			        			if(pitch>(E2*.01)+E2){
			        				System.out.println("tune low E string down: frequency is: "+pitch+", should be: "+E2);
			        				textPane.setText("tune low E string down: frequency is: "+pitch+", should be: "+E2);
			        				try {
										Thread.sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
			        				java.awt.EventQueue.invokeLater(new Runnable() {
			        			        public void run() {
			        			                    textPane.setText("tune low E string up: frequency is: "+pitch+", should be: "+E2);
			        			        }
			        			    });
			        			}
			        			if(pitch<(E2*.01)+E2&&pitch>E2-(E2*.01)){
			        				System.out.println("low E string is tuned");
			        				textPane.setText("low E string is tuned");
			        				java.awt.EventQueue.invokeLater(new Runnable() {
			        			        public void run() {
			        			                    textPane.setText("tune low E string up: frequency is: "+pitch+", should be: "+E2);
			        			        }
			        			    });
			        				try {
										Thread.sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
			        				
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
