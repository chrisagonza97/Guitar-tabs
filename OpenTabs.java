import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;


public class OpenTabs {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenTabs window = new OpenTabs();
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
	public OpenTabs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		final JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		final JTextPane txtpnEnterTabsFile = new JTextPane();
		txtpnEnterTabsFile.setText("Enter Tabs file name here");
		txtpnEnterTabsFile.setBounds(12, 241, 167, 22);
		frame.getContentPane().add(txtpnEnterTabsFile);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(txtpnEnterTabsFile.getText());
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String st;
					StringBuilder prnt = new StringBuilder();
					while((st=br.readLine())!=null){
						prnt.append(st+"\n");
					}
					textPane.setText(prnt.toString());
						
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnOpenFile.setBounds(191, 241, 97, 25);
		frame.getContentPane().add(btnOpenFile);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenu window = new MainMenu();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnReturn.setBounds(378, 241, 97, 25);
		frame.getContentPane().add(btnReturn);
		
		
		textPane.setText("  ");
		textPane.setBounds(12, 13, 463, 185);
		frame.getContentPane().add(textPane);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String output = textPane.getText();
				String filen = txtpnEnterTabsFile.getText();
				
				try{
		            //this is where i am writing my file to.
		        	String out =textPane.getText();
		            File file = new File(filen);
		            file.createNewFile();
		            FileWriter fw = new FileWriter(filen);
		            fw.write(out);
		            fw.flush();
		            fw.close();
		        }catch (Exception e){System.out.println("failed 1");}
			}
		});
		btnSave.setBounds(191, 211, 97, 25);
		frame.getContentPane().add(btnSave);
	}

}
