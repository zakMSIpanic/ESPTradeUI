package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SellClothes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellClothes frame = new SellClothes();
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
	public SellClothes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 300, 278);
		contentPane.add(panel);
		
		JLabel lblSellClothes = new JLabel("Sell Clothes!");
		lblSellClothes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSellClothes.setBounds(88, 20, 130, 36);
		panel.add(lblSellClothes);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(56, 68, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Brand:");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(56, 96, 61, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Color:");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_3.setBounds(56, 124, 61, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Size:");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_4.setBounds(56, 152, 61, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Price:");
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_5.setBounds(56, 180, 61, 16);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 63, 130, 26);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 91, 130, 26);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 119, 130, 26);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 148, 130, 26);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 176, 130, 26);
		panel.add(textField_4);
		
		JButton button = new JButton("Post for Selling");
		button.setBounds(56, 208, 186, 36);
		panel.add(button);
	}

}
