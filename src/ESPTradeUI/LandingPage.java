package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class LandingPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage frame = new LandingPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public LandingPage(String name, String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 300, 400, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccoun = new JLabel(name);
		lblAccoun.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAccoun.setBounds(33, 9, 128, 23);
		contentPane.add(lblAccoun);
		
		JLabel lblNewLabel = new JLabel(id);
		lblNewLabel.setBounds(266, 6, 128, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnShoes = new JButton("Shoes");
		btnShoes.setBounds(74, 83, 242, 48);
		contentPane.add(btnShoes);
		
		JButton btnClothes = new JButton("Clothes");
		btnClothes.setBounds(74, 132, 242, 48);
		contentPane.add(btnClothes);
		
		JButton btnThings = new JButton("Things");
		btnThings.setBounds(74, 181, 242, 48);
		contentPane.add(btnThings);
		
		JLabel lblHiLookingFor = new JLabel("Hi!, ");
		lblHiLookingFor.setBounds(6, 11, 26, 23);
		contentPane.add(lblHiLookingFor);
		
		JButton btnNewButton = new JButton("Lost Items");
		btnNewButton.setBounds(74, 232, 242, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Looking For?");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(6, 56, 102, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSellSomething = new JButton("Sell Something");
		btnSellSomething.setBounds(277, 313, 117, 29);
		contentPane.add(btnSellSomething);
		
	}

	public LandingPage() {
		// TODO Auto-generated constructor stub
	}
}
