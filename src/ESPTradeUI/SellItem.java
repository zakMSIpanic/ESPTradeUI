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

public class SellItem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellItem frame = new SellItem();
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
	public SellItem() {
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
		
		JLabel lblSellItems = new JLabel("Sell Items!");
		lblSellItems.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSellItems.setBounds(97, 21, 102, 36);
		panel.add(lblSellItems);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(56, 68, 61, 16);
		panel.add(label_1);
		
		JLabel label_5 = new JLabel("Price:");
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_5.setBounds(56, 100, 61, 16);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 63, 130, 26);
		panel.add(textField);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 96, 130, 26);
		panel.add(textField_4);
		
		JButton button = new JButton("Post for Selling");
		button.setBounds(56, 142, 186, 36);
		panel.add(button);
	}

}
