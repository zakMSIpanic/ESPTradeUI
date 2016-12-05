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
import retrofit2.http.POST;
import retrofit2.http.Query;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class BuyItem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String itemType;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyItem frame = new BuyItem();
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
	public BuyItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buy Item:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(6, 6, 101, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item ID:");
		lblNewLabel_1.setBounds(28, 51, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(101, 46, 161, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buy Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(28, 120, 222, 29);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(28, 161, 222, 98);
		contentPane.add(textArea);
		
		JLabel lblBuyerId = new JLabel("Buyer ID:");
		lblBuyerId.setBounds(28, 87, 61, 16);
		contentPane.add(lblBuyerId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 82, 161, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
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
				
				
				
				
				if (itemType.equals("clothes")) {
					Call<Reply> call;
					call = service.buyClothes(Long.parseLong(textField.getText()), Long.parseLong(textField_1.getText()));
					try {
						Response<Reply> response = call.execute();						

						
						//						Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
						//						Response<Reply> chikka = sendToChikka.execute();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (itemType.equals("item")){
					Call<Reply> call;
					call = service.buyItem(Long.parseLong(textField.getText()), Long.parseLong(textField_1.getText()));
					try {
						Response<Reply> response = call.execute();						

						
						//						Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
						//						Response<Reply> chikka = sendToChikka.execute();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					Call<Reply> call;
					call = service.buyShoes(Long.parseLong(textField.getText()), Long.parseLong(textField_1.getText()));
					try {
						Response<Reply> response = call.execute();						

						
						//						Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
						//						Response<Reply> chikka = sendToChikka.execute();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
	}
	
	private interface JDICTService
	{
		
		@POST("http://localhost:9999/espTrade/buyItem") Call<Reply> buyItem(@Query("itemID") Long id,
																			@Query("buyerID") Long buyerID);
		
		@POST("http://localhost:9999/espTrade/buyClothes") Call<Reply> buyClothes(@Query("itemID") Long id,
																				@Query("buyerID") Long buyerID);
		
		@POST("http://localhost:9999/espTrade/buyShoes") Call<Reply> buyShoes(@Query("itemID") Long id,
																			@Query("buyerID") Long buyerID);
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

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	
}
