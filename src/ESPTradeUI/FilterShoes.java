package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class FilterShoes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		setBounds(100, 100, 643, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 690, 278);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 642, 278);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Brand:");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(6, 67, 61, 16);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Size:");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(6, 105, 61, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Color:");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(6, 144, 61, 16);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Price:");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_3.setBounds(6, 183, 61, 16);
		panel_1.add(label_3);
		
		JLabel lblFindShoes = new JLabel("Find Shoes!");
		lblFindShoes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFindShoes.setBounds(6, 20, 135, 31);
		panel_1.add(lblFindShoes);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(53, 63, 142, 26);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 101, 142, 26);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(52, 139, 143, 26);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(53, 179, 142, 26);
		panel_1.add(textField_3);
		
		DefaultTableModel model = new DefaultTableModel(); 
		
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Brand");
		model.addColumn("Color");
		model.addColumn("Size");
		model.addColumn("Price");
		
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		table.setBounds(411, 31, 211, 229);
		panel_1.add(table);
		
		JButton button = new JButton("Find Brand");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				
				call = service.findShoesbyBrand(textField.getText());
				
				try {
					Response<Reply> response = call.execute();						
					
//					System.out.println(response.body().getMessage());
					model.setRowCount(0);
					for (Shoes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
					//				Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
					//				Response<Reply> chikka = sendToChikka.execute();
				} catch (IOException f) {
					f.printStackTrace();
				}	
			}
		});
		button.setBounds(229, 63, 153, 29);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Find Size");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				
				call = service.findShoesbySize(Integer.parseInt(textField_1.getText()));
				
				try {
					Response<Reply> response = call.execute();						
					

					model.setRowCount(0);
					for (Shoes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
				} catch (IOException f) {
					f.printStackTrace();
				}
			}
		});
		button_1.setBounds(229, 101, 153, 29);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Find Color");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				
				call = service.findShoesbyColor(textField_2.getText());
				
				try {
					Response<Reply> response = call.execute();						
					

					model.setRowCount(0);
					for (Shoes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
				} catch (IOException f) {
					f.printStackTrace();
				}
			}
			
		});
		button_2.setBounds(229, 140, 153, 29);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Find Price");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				
				call = service.findShoesbyPrice(Double.parseDouble(textField_3.getText()));
				
				try {
					Response<Reply> response = call.execute();						
					

					model.setRowCount(0);
					for (Shoes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
				} catch (IOException f) {
					f.printStackTrace();
				}
			
			}
		});
		button_3.setBounds(229, 179, 153, 29);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Buy Items");
		button_4.setBounds(53, 211, 329, 45);
		panel_1.add(button_4);
		
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
		
		call = service.listShoes();
		try {
			Response<Reply> response = call.execute();						
			
//			System.out.println(response.body().getMessage());
			
			for (Shoes c : response.body().getMessage()) {
				model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
			}
			//				Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
			//				Response<Reply> chikka = sendToChikka.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BuyItem buy = new BuyItem();
				buy.setItemType("shoes");
				buy.setVisible(true);
			}
		});
	}
	
	public class Reply {
		List<Shoes> message;

		public List<Shoes> getMessage() {
			return message;
		}

		public void setMessage(List<Shoes> message) {
			this.message = message;
		}
		
		
	}
	public class Shoes
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
		@GET("http://localhost:9999/espTrade/listShoes") Call<Reply> listShoes();	
		
		@GET("http://localhost:9999/espTrade/findShoesbyBrand") Call<Reply> findShoesbyBrand(@Query("brand") String brand);	
		
		@GET("http://localhost:9999/espTrade/findShoesbySize") Call<Reply> findShoesbySize(@Query("size") Integer brand);
		
		@GET("http://localhost:9999/espTrade/findShoesbyColor") Call<Reply> findShoesbyColor(@Query("color") String color);
		
		@GET("http://localhost:9999/espTrade/findShoesbyPrice") Call<Reply> findShoesbyPrice(@Query("price") Double price);
		
	}
}
