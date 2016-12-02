package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ESPTradeUI.SignIn.Reply;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up!");
		lblSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSignUp.setBounds(6, 6, 117, 37);
		contentPane.add(lblSignUp);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(44, 55, 79, 16);
		contentPane.add(lblName);
		
		JLabel lblIdNumber = new JLabel("ID Number:");
		lblIdNumber.setBounds(44, 93, 79, 16);
		contentPane.add(lblIdNumber);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(44, 130, 79, 16);
		contentPane.add(lblGender);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(44, 169, 79, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(122, 50, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 88, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 125, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 164, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(44, 210, 208, 43);
		contentPane.add(btnCreateAccount);
	}
	
	private interface JDICTService
	{
		@GET("http://localhost:9999/espTrade/signup") Call<Reply> signup(@Query("idNumber") Long idNumber,
																			@Query("password") String password);
		
	}
	
	public class Reply {
		Object message;

		public Object getMessage() {
			return message;
		}
		
		Object accountName;
		
		public Object getAccount() {
			return accountName;
		}
	}
}
