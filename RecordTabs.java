import java.awt.EventQueue;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JButton;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecordTabs {

	static float G4= (float) 391.9954;//4
	static float C4= (float) 261.6256;//1
	static float E4= (float) 329.6279;//2
	static float A4= (float) 440.0000;//3
	
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
	static Tabs tabs = new Tabs();
	JFrame frame;
	static AudioDispatcher adp;
	private JTextPane txtpnEnterSongName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordTabs window = new RecordTabs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecordTabs() {
		initialize();
	}
	public static void readNotes(final JTextPane txtpnInstructions) throws LineUnavailableException{
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
			        		SwingUtilities.invokeLater(new Runnable() {
	        		            public void run() {
	        		            	txtpnInstructions.setText("notes recording in: " + (5-countdown+1)+" seconds");
	        		            }
	        		          });
			        	}
			        	if((int) time==5&&flag==false){
			        		flag=true;
			        		System.out.println("now");
			        		SwingUtilities.invokeLater(new Runnable() {
	        		            public void run() {
	        		            	txtpnInstructions.setText("now");
	        		            }
	        		          });
			        	}
			        	
			        	time=time*10;//making sure it happens once a second
			        	int temp = (int)time;
			        	time = (double)temp/10;
			        	if(time==timecount){
			        	timecount=timecount+1.0;
			        	if(pitchDetectionResult.getPitch()>70.0){
			        		float pitch=pitchDetectionResult.getPitch();
			        		if (pitch>(G2s+A2)/2&&pitch<(A2+A2s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A2");
		        		            }
		        		          });
			        			System.out.println("A2");
			        			//tabs.notes.add("A2");
			        			tabs.addNote("A2",-99,-99,-99,-99,0,5);
			        		}
			        		if (pitch>(A2+A2s)/2&&pitch<(A2s+B2)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A2s");
		        		            }
		        		          });
			        			System.out.println("A2s");
			        			//tabs.notes.add("A2s");
			        			tabs.addNote("A2s",-99,-99,-99,-99,1,6);
			        			
			        		}
			        		if (pitch>(A2s+B2)/2&&pitch<(B2+C3)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("B2");
		        		            }
		        		          });
			        			System.out.println("B2");
			        			//tabs.notes.add("B2");
			        			tabs.addNote("B2",-99,-99,-99,-99,2,7);
			        		}
			        		if (pitch>(B2+C3)/2&&pitch<(C3+C3s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C3");
		        		            }
		        		          });
			        			System.out.println("C3");
			        			//tabs.notes.add("C3");
			        			tabs.addNote("C3",-99,-99,-99,-99,3,8);
			        		}
			        		if (pitch>(C3+C3s)/2&&pitch<(C3s+D3)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C3s");
		        		            }
		        		          });
			        			System.out.println("C3s");
			        			//tabs.notes.add("C3s");
			        			tabs.addNote("C3s",-99,-99,-99,-99,4,9);
			        		}
			        		if (pitch>(C3s+D3)/2&&pitch<(D3+D3s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("D3");
		        		            }
		        		          });
			        			System.out.println("D3");
			        			//tabs.notes.add("D3");
			        			tabs.addNote("D3",-99,-99,-99,0,5,10);
			        		}
			        		if (pitch>(D3+D3s)/2&&pitch<(D3s+E3)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("D3s");
		        		            }
		        		          });
			        			System.out.println("D3s");
			        			//tabs.notes.add("D3s");
			        			tabs.addNote("D3s",-99,-99,-99,1,6,11);
			        		}
			        		if (pitch>(D3s+E3)/2&&pitch<(E3+F3)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("E3");
		        		            }
		        		          });
			        			System.out.println("E3");
			        			//tabs.notes.add("E3");
			        			tabs.addNote("E3",-99,-99,-99,2,7,12);
			        		}
			        		if (pitch>(E3+F3)/2&&pitch<(F3+F3s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("F3");
		        		            }
		        		          });
			        			System.out.println("F3");
			        			//tabs.notes.add("F3");
			        			tabs.addNote("F3",-99,-99,-99,3,8,13);
			        		}
			        		if (pitch>(F3+F3s)/2&&pitch<(F3s+G3)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("F3s");
		        		            }
		        		          });
			        			System.out.println("F3s");
			        			//tabs.notes.add("F3s");
			        			tabs.addNote("F3s",-99,-99,-99,4,9,14);
			        		}
			        		if (pitch>(F3s+G3)/2&&pitch<(G3+G3s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("G3");
		        		            }
		        		          });
			        			System.out.println("G3");
			        			//tabs.notes.add("G3");
			        			tabs.addNote("G3",-99,-99,0,5,10,15);
			        		}
			        		if (pitch>(G3+G3s)/2&&pitch<(G3s+A3)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("G3s");
		        		            }
		        		          });
			        			System.out.println("G3s");
			        			//tabs.notes.add("G3s");
			        			tabs.addNote("G3s",-99,-99,1,6,11,16);
			        		}
			        		if (pitch>(G3s+A3)/2&&pitch<(A3+A3s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A3");
		        		            }
		        		          });
			        			System.out.println("A3");
			        			//tabs.notes.add("A3");
			        			tabs.addNote("A3",-99,-99,2,7,12,17);
			        		}
			        		if (pitch>(A3+A3s)/2&&pitch<(A3s+B3)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A3s");
		        		            }
		        		          });
			        			System.out.println("A3s");
			        			//tabs.notes.add("A3s");
			        			tabs.addNote("A3s",-99,-99,3,8,13,18);
			        		}
			        		if (pitch>(A3s+B3)/2&&pitch<(B3+C4)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("B3");
		        		            }
		        		          });
			        			System.out.println("B3");
			        			//tabs.notes.add("B3");
			        			tabs.addNote("B3",-99,0,4,9,14,19);
			        		}
			        		if (pitch>(B3+C4)/2&&pitch<(C4+C4s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C4");
		        		            }
		        		          });
			        			System.out.println("C4");
			        			//tabs.notes.add("C4");
			        			tabs.addNote("C4",-99,1,5,10,15,20);
			        		}
			        		if (pitch>(C4+C4s)/2&&pitch<(C4s+D4)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C4s");
		        		            }
		        		          });
			        			System.out.println("C4s");
			        			//tabs.notes.add("C4s");
			        			tabs.addNote("C4s",-99,2,6,11,16,21);
			        		}
			        		if (pitch>(C4s+D4)/2&&pitch<(D4+D4s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("D4");
		        		            }
		        		          });
			        			System.out.println("D4");
			        			//tabs.notes.add("D4");
			        			tabs.addNote("D4",-99,3,7,12,17,22);
			        		}
			        		if (pitch>(D4+D4s)/2&&pitch<(D4s+E4)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("D4s");
		        		            }
		        		          });
			        			System.out.println("D4s");
			        			//tabs.notes.add("D4s");
			        			tabs.addNote("D4s",-99,4,8,13,18,99);
			        		}
			        		if (pitch>(D4s+E4)/2&&pitch<(E4+F4)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("E4");
		        		            }
		        		          });
			        			System.out.println("E4");
			        			//tabs.notes.add("E4");
			        			tabs.addNote("E4",0,5,9,14,19,99);
			        		}
			        		if (pitch>(E4+F4)/2&&pitch<(F4+F4s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("F4");
		        		            }
		        		          });
			        			System.out.println("F4");
			        			//tabs.notes.add("F4");
			        			tabs.addNote("F4",1,6,10,15,20,99);
			        		}
			        		if (pitch>(F4+F4s)/2&&pitch<(F4s+G4)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("F4s");
		        		            }
		        		          });
			        			System.out.println("F4s");
			        			//tabs.notes.add("F4s");
			        			tabs.addNote("F4s",2,7,11,16,21,99);
			        		}
			        		if (pitch>(F4s+G4)/2&&pitch<(G4+G4s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("G4");
		        		            }
		        		          });
			        			System.out.println("G4");
			        			//tabs.notes.add("G4");
			        			tabs.addNote("G4",3,8,12,17,22,99);
			        		}
			        		if (pitch>(G4+G4s)/2&&pitch<(G4s+A4)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("G4s");
		        		            }
		        		          });
			        			System.out.println("G4s");
			        			//tabs.notes.add("G4s");
			        			tabs.addNote("G4s",4,9,13,18,99,99);
			        		}
			        		if (pitch>(G4s+A4)/2&&pitch<(A4+A4s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A4");
		        		            }
		        		          });
			        			System.out.println("A4");
			        			//tabs.notes.add("A4");
			        			tabs.addNote("A4",5,10,14,19,99,99);
			        		}
			        		if (pitch>(A4+A4s)/2&&pitch<(A4s+B4)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A4s");
		        		            }
		        		          });
			        			System.out.println("A4s");
			        			//tabs.notes.add("A4s");
			        			tabs.addNote("A4s",6,11,15,20,99,99);
			        		}
			        		if (pitch>(A4s+B4)/2&&pitch<(B4+C5)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("B4");
		        		            }
		        		          });
			        			System.out.println("B4");
			        			//tabs.notes.add("B4");
			        			tabs.addNote("B4",7,12,16,21,99,99);
			        		}
			        		if (pitch>(B4+C5)/2&&pitch<(C5+C5s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C5");
		        		            }
		        		          });
			        			System.out.println("C5");
			        			//tabs.notes.add("C5");
			        			tabs.addNote("C5",8,13,17,22,99,99);
			        		}
			        		if (pitch>(C5+C5s)/2&&pitch<(C5s+D5)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C5s");
		        		            }
		        		          });
			        			System.out.println("C5s");
			        			//tabs.notes.add("C5s");
			        			tabs.addNote("C5s",9,14,18,99,99,99);
			        		}
			        		if (pitch>(C5s+D5)/2&&pitch<(D5+D5s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("D5");
		        		            }
		        		          });
			        			System.out.println("D5");
			        			//tabs.notes.add("D5");
			        			tabs.addNote("D5",10,15,19,99,99,99);
			        		}
			        		if (pitch>(D5+D5s)/2&&pitch<(D5s+E5)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("D5s");
		        		            }
		        		          });
			        			System.out.println("D5s");
			        			//tabs.notes.add("D5s");
			        			tabs.addNote("D5s",11,16,20,99,99,99);
			        		}
			        		if (pitch>(D5s+E5)/2&&pitch<(E5+F5)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("E5");
		        		            }
		        		          });
			        			System.out.println("E5");
			        			//tabs.notes.add("E5");
			        			tabs.addNote("E5",12,17,21,99,99,99);
			        		}
			        		if (pitch>(E5+F5)/2&&pitch<(F5+F5s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("F5");
		        		            }
		        		          });
			        			System.out.println("F5");
			        			//tabs.notes.add("F5");
			        			tabs.addNote("F5",13,18,22,99,99,99);
			        		}
			        		if (pitch>(F5+F5s)/2&&pitch<(F5s+G5)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("F5s");
		        		            }
		        		          });
			        			System.out.println("F5s");
			        			//tabs.notes.add("F5s");
			        			tabs.addNote("F5s",14,19,99,99,99,99);
			        		}
			        		if (pitch>(F5s+G5)/2&&pitch<(G5+G5s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("G5");
		        		            }
		        		          });
			        			System.out.println("G5");
			        			//tabs.notes.add("G5");
			        			tabs.addNote("G5",15,19,99,99,99,99);
			        		}
			        		if (pitch>(G5+G5s)/2&&pitch<(G5s+A5)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("G5s");
		        		            }
		        		          });
			        			System.out.println("G5s");
			        			//tabs.notes.add("G5s");
			        			tabs.addNote("G5s",16,20,99,99,99,99);
			        		}
			        		if (pitch>(G5s+A5)/2&&pitch<(A5+A5s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A5");
		        		            }
		        		          });
			        			System.out.println("A5");
			        			//tabs.notes.add("A5");
			        			tabs.addNote("A5",17,21,99,99,99,99);
			        		}
			        		if (pitch>(A5+A5s)/2&&pitch<(A5s+B5)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("A5s");
		        		            }
		        		          });
			        			System.out.println("A5s");
			        			//tabs.notes.add("A5s");
			        			tabs.addNote("A2",18,22,99,99,99,99);
			        		}
			        		if (pitch>(A5s+B5)/2&&pitch<(B5+C6)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("B5");
		        		            }
		        		          });
			        			System.out.println("B5");
			        			//tabs.notes.add("B5");
			        			tabs.addNote("B5",19,99,99,99,99,99);
			        		}
			        		if (pitch>(B5+C6)/2&&pitch<(C6+C6s)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C6");
		        		            }
		        		          });
			        			System.out.println("C6");
			        			//tabs.notes.add("C6");
			        			tabs.addNote("C6",20,99,99,99,99,99);
			        		}
			        		if (pitch>(C6+C6s)/2&&pitch<(C6s+D6)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("C6s");
		        		            }
		        		          });
			        			System.out.println("C6s");
			        			//tabs.notes.add("C6s");
			        			tabs.addNote("C6s",21,99,99,99,99,99);
			        		}
			        		if (pitch>(C6s+D6)/2){
			        			SwingUtilities.invokeLater(new Runnable() {
		        		            public void run() {
		        		            	txtpnInstructions.setText("D6");
		        		            }
		        		          });
			        			System.out.println("D6");
			        			//tabs.notes.add("D6");
			        			tabs.addNote("D6",22,99,99,99,99,99);
			        		}
			        		
			        	}
			        }
			        }
			    };
			    adp = AudioDispatcherFactory.fromDefaultMicrophone(2048, 0);
			    adp.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
			    adp.run();
				}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRecordTabs = new JLabel("Record Tabs");
		lblRecordTabs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRecordTabs.setBounds(157, 13, 110, 47);
		frame.getContentPane().add(lblRecordTabs);
		
		final JTextPane txtpnInstructions = new JTextPane();
		//final JTextPane textPane = new JTextPane();
		txtpnInstructions.setText("Instructions: Notes must be played at 60 beats per minute. \r\nBefore pressing \"Start Recording\", Enter the title of the tabs below.");
		txtpnInstructions.setBounds(48, 54, 348, 89);
		frame.getContentPane().add(txtpnInstructions);
		
		JButton btnStartRecording = new JButton("Start Recording");
		btnStartRecording.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabs.title=txtpnEnterSongName.getText();
				new Thread(new Runnable(){
					public void run(){
						try {
							readNotes(txtpnInstructions);
							System.out.println("");
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		btnStartRecording.setBounds(12, 201, 126, 39);
		frame.getContentPane().add(btnStartRecording);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenu window = new MainMenu();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnReturn.setBounds(319, 201, 101, 39);
		frame.getContentPane().add(btnReturn);
		
		JButton btnStopRecording = new JButton("Stop Recording");
		btnStopRecording.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adp.stop();
				tabs.createTabs();
			}
		});
		btnStopRecording.setBounds(173, 201, 119, 39);
		frame.getContentPane().add(btnStopRecording);
		
		//JTextPane textPane;
		txtpnEnterSongName = new JTextPane();
		txtpnEnterSongName.setText("enter song name here");
		txtpnEnterSongName.setBounds(58, 166, 323, 22);
		frame.getContentPane().add(txtpnEnterSongName);
	}
}
