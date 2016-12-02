package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

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

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setType(Type.UTILITY);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 350, 260);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(131, 48, 181, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID Number:");
		lblNewLabel.setBounds(35, 54, 84, 21);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 99, 181, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(35, 104, 84, 16);
		contentPane.add(lblPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(100, 150, 144, 44);
		contentPane.add(btnSubmit);
		
		btnSubmit.addMouseListener(new MouseAdapter() {
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
				
					call = service.login(Long.parseLong(textField_1.getText()), textField.getText());
					try {
						Response<Reply> response = call.execute();						
						
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
		@GET("http://localhost:9999/espTrade/login") Call<Reply> login(@Query("idNumber") Long idNumber,
																			@Query("password") String password);
		
	}
	
	public class Reply {
		Object title;

		public Object getTitle() {
			return title;
		}
		
		Object gross;

		public Object getGross() {
			return gross;
		}

	}
	
}
