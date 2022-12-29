package project;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class Gacha {

	private Main parent;
	JFrame frame;

	
	/**
	 * Create the application.
	 */
	public Gacha(Main parent) {
		this.parent = parent;
		initialize();
	}

	private ActionListener goListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			playBGM();
			if (parent.money >= 50000) {
				parent.money -= 50000;
				doGacha();
			}
			else {
				JOptionPane.showMessageDialog(null, "돈이 부족합니다!");
			}
		}
	};private ActionListener backListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Out.frameOut.setVisible(true);
			parent.checkEverything();
		}
	};
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("가챠 뽑기");
		frame.setBounds(100, 100, 415, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnGo = new JButton();
		btnGo.setBounds(120, 428, 175, 84);
		btnGo.addActionListener(goListener);
		btnGo.setContentAreaFilled(false);
		frame.getContentPane().add(btnGo);
		
		JButton btnBack = new JButton();
		btnBack.setBounds(281, 541, 108, 47);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(backListener);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("image\\gachabg.jpg"));
		lblNewLabel.setBounds(0, 0, 400, 600);
		frame.getContentPane().add(lblNewLabel);
	}
	
		
	void playBGM() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sound\\sound6.wav"));
					Clip clip = AudioSystem.getClip();
					clip.stop();
					clip.open(ais);
					clip.start();
		} catch (Exception e1) {
			
		}
	}
	
		
	void doGacha() {
		int random = (int) (Math.random() * 10 + 1);
			switch (random) {
			case 1: case 2:
				parent.gacha1 = 1;
				JOptionPane.showMessageDialog(null, "아이템1을 뽑았습니다!");
				break;
			case 3: case 4:
				parent.gacha2 = 1;
				JOptionPane.showMessageDialog(null, "아이템2를 뽑았습니다!");
				break;
			case 5: case 6:
				parent.gacha3 = 1;
				JOptionPane.showMessageDialog(null, "아이템3을 뽑았습니다!");
				break;
			case 7: case 8:
				parent.gacha4 = 1;
				JOptionPane.showMessageDialog(null, "아이템4를 뽑았습니다!");
				break;
			case 9:
				parent.gacha5 = 1;
				JOptionPane.showMessageDialog(null, "아이템5를 뽑았습니다!");
				break;
			case 10:
				parent.gacha6 = 1;
				JOptionPane.showMessageDialog(null, "아이템6을 뽑았습니다!");
				break;
			default:
				break;
			}
		}
}
