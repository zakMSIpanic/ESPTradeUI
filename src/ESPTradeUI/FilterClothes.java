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

public class FilterClothes extends JFrame {

	private JPanel contentPane;
	private JTextField txtClothesBrand;
	private JTextField txtClothesSize;
	private JTextField txtClothesColor;
	private JTextField txtClothesPrice;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterClothes frame = new FilterClothes();
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
	public FilterClothes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Brand:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 82, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSize.setBounds(22, 110, 61, 16);
		contentPane.add(lblSize);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblColor.setBounds(22, 138, 61, 16);
		contentPane.add(lblColor);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPrice.setBounds(22, 165, 61, 16);
		contentPane.add(lblPrice);
		
		JLabel lblFindClothes = new JLabel("Find Clothes!");
		lblFindClothes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFindClothes.setBounds(6, 20, 135, 31);
		contentPane.add(lblFindClothes);
		
		txtClothesBrand = new JTextField();
		txtClothesBrand.setBounds(77, 78, 130, 26);
		contentPane.add(txtClothesBrand);
		txtClothesBrand.setColumns(10);
		
		txtClothesSize = new JTextField();
		txtClothesSize.setBounds(77, 106, 130, 26);
		contentPane.add(txtClothesSize);
		txtClothesSize.setColumns(10);
		
		txtClothesColor = new JTextField();
		txtClothesColor.setBounds(77, 134, 130, 26);
		contentPane.add(txtClothesColor);
		txtClothesColor.setColumns(10);
		
		txtClothesPrice = new JTextField();
		txtClothesPrice.setBounds(77, 161, 130, 26);
		contentPane.add(txtClothesPrice);
		txtClothesPrice.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(22, 210, 185, 50);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(219, 31, 211, 229);
		contentPane.add(table);
	}
}
