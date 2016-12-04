package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AdminUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
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
	public AdminUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminFunctions = new JLabel("Admin Functions");
		lblAdminFunctions.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAdminFunctions.setBounds(6, 6, 170, 40);
		contentPane.add(lblAdminFunctions);
		
		JLabel lblNewLabel = new JLabel("Postings:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(16, 51, 81, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delete Shoes");
		btnNewButton.setBounds(26, 80, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Clothes");
		btnNewButton_1.setBounds(143, 80, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Items");
		btnNewButton_2.setBounds(260, 80, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete All Posts");
		btnNewButton_3.setBounds(100, 107, 192, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblUsers = new JLabel("Users:");
		lblUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblUsers.setBounds(16, 148, 61, 16);
		contentPane.add(lblUsers);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(26, 165, 161, 29);
		contentPane.add(btnDeleteUser);
		
		JButton btnNewButton_4 = new JButton("Delete All Users");
		btnNewButton_4.setBounds(199, 165, 161, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Delete EVERYTHING!");
		btnNewButton_5.setBounds(26, 206, 331, 51);
		contentPane.add(btnNewButton_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(376, 21, 263, 235);
		contentPane.add(textArea);
	}
}
