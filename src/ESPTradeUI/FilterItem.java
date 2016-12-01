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

public class FilterItem extends JFrame {

	private JPanel contentPane;
	private JTextField txtItemsName;
	private JTextField txtItemsPrice;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterItem frame = new FilterItem();
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
	public FilterItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFindItems = new JLabel("Find Items!");
		lblFindItems.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFindItems.setBounds(6, 6, 135, 31);
		contentPane.add(lblFindItems);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblName.setBounds(22, 68, 61, 16);
		contentPane.add(lblName);
		
		txtItemsName = new JTextField();
		txtItemsName.setColumns(10);
		txtItemsName.setBounds(77, 64, 130, 26);
		contentPane.add(txtItemsName);
		
		txtItemsPrice = new JTextField();
		txtItemsPrice.setColumns(10);
		txtItemsPrice.setBounds(77, 108, 130, 26);
		contentPane.add(txtItemsPrice);
		
		JLabel label_4 = new JLabel("Price:");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_4.setBounds(22, 112, 61, 16);
		contentPane.add(label_4);
		
		JButton btnItemsSubmit = new JButton("Submit");
		btnItemsSubmit.setBounds(22, 165, 185, 50);
		contentPane.add(btnItemsSubmit);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		table.setBounds(219, 17, 211, 234);
		contentPane.add(table);
	}
}
