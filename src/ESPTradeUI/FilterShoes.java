package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class FilterShoes extends JFrame {

	private JPanel contentPane;
	private JTextField txtBrandShoes;
	private JTextField txtShoesSize;
	private JTextField txtShoesColor;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterShoes frame = new FilterShoes();
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
	public FilterShoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 450, 278);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Brand:");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(22, 82, 61, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Size:");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(22, 110, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Color:");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(22, 138, 61, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Price:");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_3.setBounds(22, 165, 61, 16);
		panel.add(label_3);
		
		JLabel lblFindShoes = new JLabel("Find Shoes!");
		lblFindShoes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFindShoes.setBounds(6, 20, 135, 31);
		panel.add(lblFindShoes);
		
		txtBrandShoes = new JTextField();
		txtBrandShoes.setColumns(10);
		txtBrandShoes.setBounds(77, 78, 130, 26);
		panel.add(txtBrandShoes);
		
		txtShoesSize = new JTextField();
		txtShoesSize.setColumns(10);
		txtShoesSize.setBounds(77, 106, 130, 26);
		panel.add(txtShoesSize);
		
		txtShoesColor = new JTextField();
		txtShoesColor.setColumns(10);
		txtShoesColor.setBounds(77, 134, 130, 26);
		panel.add(txtShoesColor);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(77, 161, 130, 26);
		panel.add(textField_3);
		
		JButton btnSubmitShoes = new JButton("Submit");
		btnSubmitShoes.setBounds(22, 207, 185, 50);
		panel.add(btnSubmitShoes);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(219, 31, 211, 226);
		panel.add(table);
	}
}
