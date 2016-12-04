package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextField;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ESPTradeUI.SignIn.Reply;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import javax.swing.JList;

public class FilterClothes extends JFrame {

	private JPanel contentPane;
	private JTextField txtClothesBrand;
	private JTextField txtClothesSize;
	private JTextField txtClothesColor;
	private JTextField txtClothesPrice;

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
		
		JList list = new JList();
		list.setBounds(226, 31, 201, 222);
		contentPane.add(list);
		DefaultListModel model1 = new DefaultListModel();
		
		Gson gson = new GsonBuilder().create();
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
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
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				model1.removeAllElements();
				Call<Reply> call;
				call = service.findClothesbyBrand(txtClothesBrand.getText());
				try {
					Response<Reply> response = call.execute();						

					
					
					list.setModel(model1);
					
					for (Clothes c : response.body().getMessage()) {
						model1.addElement("ID: " +c.getId());
						model1.addElement("Name: " + c.getName());
						model1.addElement("Price: " + c.getPrice());
						model1.addElement("Brand: " + c.getBrand());
						model1.addElement("Color: " + c.getColor());
						model1.addElement("Size: " + c.getSize());
						model1.addElement("--------------");
					}
					
					 
					
					
					
					//				Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
					//				Response<Reply> chikka = sendToChikka.execute();
				} catch (IOException e) {
					e.printStackTrace();
				}

				
				
			
			}
		});
		
		
		
//		java.net.Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.admu.edu.ph", 3128));
		
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setViewportView(list);
		
		

		call = service.listClothes();
		try {
			Response<Reply> response = call.execute();						

			
			
			list.setModel(model1);
			
			for (Clothes c : response.body().getMessage()) {
				model1.addElement("ID: " +c.getId());
				model1.addElement("Name: " + c.getName());
				model1.addElement("Price: " + c.getPrice());
				model1.addElement("Brand: " + c.getBrand());
				model1.addElement("Color: " + c.getColor());
				model1.addElement("Size: " + c.getSize());
				model1.addElement("--------------");
			}
			
			 
			
			
			
			//				Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
			//				Response<Reply> chikka = sendToChikka.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public class Reply {
		List<Clothes> message;

		public List<Clothes> getMessage() {
			return message;
		}

		public void setMessage(List<Clothes> message) {
			this.message = message;
		}
		
		
	}
	
	public class Clothes
	{
		private Long id;
		private String name;
		private Double price;
		private Boolean sold;
		private Account seller;
		private String color;
		private String size;
		private String brand;
		
		public String getColor() {
			return color;
		}
		
		public String getBrand() {
			return brand;
		}
		
		public String getSize() {
			return size;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Boolean getSold() {
			return sold;
		}
		public void setSold(Boolean sold) {
			this.sold = sold;
		}
		public Account getSeller() {
			return seller;
		}
		public void setSeller(Account seller) {
			this.seller = seller;
		}
	}
	
	public class Account 
	{
		private Long idNumber;
		
		private String name;
		
		private String sex;
		
		private String password;
	}
	
	private interface JDICTService
	{
		@GET("http://localhost:9999/espTrade/listClothes") Call<Reply> listClothes();	
		
		@GET("http://localhost:9999/espTrade/findClothesbyBrand") Call<Reply> findClothesbyBrand(@Query("brand") String brand);	
	}
}
