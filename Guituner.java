import java.awt.EventQueue;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
//import be.tarsos.dsp.io.TarsosDSPAudioFormat;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.*;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;



public class Guituner {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guituner window = new Guituner();
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
	public Guituner() throws LineUnavailableException {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws LineUnavailableException{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextPane txtpnTestText = new JTextPane();
		txtpnTestText.setText("");
		txtpnTestText.setBounds(206, 99, 201, 47);
		frame.getContentPane().add(txtpnTestText);
		
		JButton btnTuneLowE = new JButton("Low E");
		btnTuneLowE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					tuneLowE window2 = new tuneLowE();
					window2.NewScreen();
					frame.dispose();
					//window2.frame.setVisible(true);
					txtpnTestText.setText("tuning low E");
					//driver.tuneLowE(txtpnTestText);
				} catch (/*LineUnavailableException*/ Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnTuneLowE.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(btnTuneLowE);
		
		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					TuneA window2 = new TuneA();
					window2.NewScreen();
					frame.dispose();
					//window2.frame.setVisible(true);
					txtpnTestText.setText("tuning A");
					//driver.tuneLowE(txtpnTestText);
				} catch (/*LineUnavailableException*/ Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnA.setBounds(12, 51, 97, 25);
		frame.getContentPane().add(btnA);
		
		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					TuneD window2 = new TuneD();
					window2.NewScreen();
					frame.dispose();
					//window2.frame.setVisible(true);
					txtpnTestText.setText("tuning D");
					//driver.tuneLowE(txtpnTestText);
				} catch (/*LineUnavailableException*/ Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnD.setBounds(12, 89, 97, 25);
		frame.getContentPane().add(btnD);
		
		JButton btnG = new JButton("G");
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					TuneG window2= new TuneG();
					window2.NewScreen();
					frame.dispose();
					//window2.frame.setVisible(true);
					txtpnTestText.setText("tuning G");
					//driver.tuneLowE(txtpnTestText);
				} catch (/*LineUnavailableException*/ Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnG.setBounds(12, 126, 97, 25);
		frame.getContentPane().add(btnG);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					TuneB window2 = new TuneB();
					window2.NewScreen();
					frame.dispose();
					//window2.frame.setVisible(true);
					txtpnTestText.setText("tuning low B");
					//driver.tuneLowE(txtpnTestText);
				} catch (/*LineUnavailableException*/ Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnB.setBounds(12, 164, 97, 25);
		frame.getContentPane().add(btnB);
		
		JButton btnHighE = new JButton("High e");
		btnHighE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					TuneHighE window2 = new TuneHighE();
					window2.NewScreen();
					frame.dispose();
					//window2.frame.setVisible(true);
					txtpnTestText.setText("tuning High E");
					//driver.tuneLowE(txtpnTestText);
				} catch (/*LineUnavailableException*/ Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnHighE.setBounds(12, 202, 97, 25);
		frame.getContentPane().add(btnHighE);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenu window = new MainMenu();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnReturn.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(btnReturn);
		
		
		
		
	}
}
