package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
		
		btnCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Gson gson = new GsonBuilder().create();
				HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
				interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
				
//				java.net.Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.admu.edu.ph", 3128));
				
				
				OkHttpClient client = new OkHttpClient.Builder()
						.addInterceptor(interceptor)
						.build();
				
				Retrofit retrofit = new Retrofit.Builder()
						.baseUrl("http://localhost:9999/") // a legit base url is needed regardless
						.client(client)
						.addConverterFactory(GsonConverterFactory.create(gson))
						.build();
				
				JDICTService service = retrofit.create(JDICTService.class);	
				
				
				Call<Reply> call;
				
					call = service.signup(Long.parseLong(textField_1.getText()), textField.getText(), textField_3.getText(), textField_2.getText());
					try {
						Response<Reply> response = call.execute();						
						
						if (response.body().getMessage().equals("Login successful!")) {
							LandingPage lp = new LandingPage(response.body().getAccount().toString(), textField.getText());
							
							lp.setVisible(true);
						}
//						Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
//						Response<Reply> chikka = sendToChikka.execute();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				
			}
		});
	}
	
	private interface JDICTService
	{
		@GET("http://localhost:9999/espTrade/signup") Call<Reply> signup(@Query("idNumber") Long idNumber,
																		@Query("name") String name,
																		@Query("password") String password,
																		@Query("sex") String sex);
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
