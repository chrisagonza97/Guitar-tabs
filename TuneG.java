import java.awt.EventQueue;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TuneG {
	static float G4= (float) 391.9954;//4
	static float C4= (float) 261.6256;//1
	static float E4= (float) 329.6279;//2
	static float A4= (float) 440.0000;//3
	
	static float E2= (float) 82.4069;
	static float A2= (float) 110.000;
	static float D3= (float) 146.8324;
	static float G3= (float) 195.9977;
	static float B3= (float) 246.9417;
	JFrame frame;
	static AudioDispatcher adp;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TuneG window = new TuneG();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws LineUnavailableException 
	 */
	public TuneG() throws LineUnavailableException {
		
		final JTextPane textPane =initialize();
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adp.stop();
				frame.dispose();
				try {
					new Guituner();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnReturn.setBounds(27, 215, 97, 25);
		frame.getContentPane().add(btnReturn);
		
		JButton btnTune = new JButton("Tune");
		btnTune.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//tuneE(textPane);
				textPane.setText("tuning");
				//TuneThread thread = new TuneThread(textPane);
				//thread.start();
				new Thread(new Runnable(){
					public void run(){
						try {
							tuneG(textPane);
							//System.out.println("fnr");
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		btnTune.setBounds(160, 59, 97, 25);
		frame.getContentPane().add(btnTune);
		//tuneG(textPane);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws LineUnavailableException 
	 */
	private static void tuneG(final JTextPane textPane) throws LineUnavailableException{
PitchDetectionHandler handler = new PitchDetectionHandler() {
	        
	        public void handlePitch(PitchDetectionResult pitchDetectionResult,
	                AudioEvent audioEvent) {
	        	if (pitchDetectionResult.getPitch()>70.0){
	        		//System.out.println(audioEvent.getTimeStamp() + " " +pitchDetectionResult.getPitch());
	        		final float pitch=pitchDetectionResult.getPitch();
	        		//if(pitch<(B3+G3)/2&&pitch>=(G3+D3)/2){
	        			if(pitch<G3-(G3*.01)){
	        				//System.out.println("tune G string up: frequency is: "+pitch+", should be: "+G3);
	        				SwingUtilities.invokeLater(new Runnable() {
	        		            public void run() {
	        		            	textPane.setText("tune G string up: frequency is: "+pitch+", should be: "+G3);
	        		            }
	        		          });
	        			}
	        			if(pitch>(G3*.01)+G3){
	        				//System.out.println("tune G string down: frequency is: "+pitch+", should be: "+G3);
	        				SwingUtilities.invokeLater(new Runnable() {
	        		            public void run() {
	        		            	textPane.setText("tune G string up: frequency is: "+pitch+", should be: "+G3);
	        		            }
	        		          });
	        			}
	        			if(pitch<(G3*.01)+G3&&pitch>G3-(G3*.01)){
	        				//System.out.println("G string is tuned");
	        				SwingUtilities.invokeLater(new Runnable() {
	        		            public void run() {
	        		            	textPane.setText("G string is tuned");
	        		            }
	        		          });
	        				
	        			}
	        		
	        			//if(atuned==true){
	        				//System.out.println("instrument is tuned");
	        				//return;
	        			//}
	        		//}	        		
	        	}	
	            //Handle pitch here, tell user to tune up or tune down
	        }
	    };
	    adp = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
	    adp.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
	    adp.run();
	}
	private JTextPane initialize() throws LineUnavailableException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTuningLowE = new JLabel("Tuning G String:");
		lblTuningLowE.setBounds(125, 13, 186, 16);
		frame.getContentPane().add(lblTuningLowE);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(27, 95, 380, 73);
		frame.getContentPane().add(textPane);
		return textPane;
	}
}
