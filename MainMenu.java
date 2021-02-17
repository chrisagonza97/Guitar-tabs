import java.awt.EventQueue;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainMenu {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnGuitarTabs = new JTextPane();
		txtpnGuitarTabs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnGuitarTabs.setText("        Guitar Tabs");
		txtpnGuitarTabs.setBounds(130, 13, 167, 30);
		frame.getContentPane().add(txtpnGuitarTabs);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(btnExit);
		
		JButton btnRecordTabs = new JButton("Record tabs");
		btnRecordTabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				RecordTabs window = new RecordTabs();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnRecordTabs.setBounds(12, 52, 112, 46);
		frame.getContentPane().add(btnRecordTabs);
		
		JButton btnNewButton = new JButton("View Tabs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				OpenTabs window = new OpenTabs();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(12, 111, 112, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guitar Tuner");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				try {
					Guituner window = new Guituner();
					window.frame.setVisible(true);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(12, 170, 112, 46);
		frame.getContentPane().add(btnNewButton_1);
	}
}
