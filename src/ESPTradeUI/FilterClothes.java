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
import javax.swing.table.DefaultTableModel;

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

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FilterClothes extends JFrame {

	private JPanel contentPane;
	private JTextField txtClothesBrand;
	private JTextField txtClothesSize;
	private JTextField txtClothesColor;
	private JTextField txtClothesPrice;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

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
		setBounds(100, 100, 654, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Brand:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(6, 67, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSize.setBounds(6, 105, 61, 16);
		contentPane.add(lblSize);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblColor.setBounds(6, 144, 61, 16);
		contentPane.add(lblColor);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPrice.setBounds(6, 183, 61, 16);
		contentPane.add(lblPrice);
		
		JLabel lblFindClothes = new JLabel("Find Clothes!");
		lblFindClothes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFindClothes.setBounds(6, 20, 135, 31);
		contentPane.add(lblFindClothes);
		
		txtClothesBrand = new JTextField();
		txtClothesBrand.setBounds(53, 63, 142, 26);
		contentPane.add(txtClothesBrand);
		txtClothesBrand.setColumns(10);
		
		txtClothesSize = new JTextField();
		txtClothesSize.setBounds(53, 101, 142, 26);
		contentPane.add(txtClothesSize);
		txtClothesSize.setColumns(10);
		
		txtClothesColor = new JTextField();
		txtClothesColor.setBounds(52, 139, 143, 26);
		contentPane.add(txtClothesColor);
		txtClothesColor.setColumns(10);
		
		txtClothesPrice = new JTextField();
		txtClothesPrice.setBounds(53, 179, 142, 26);
		contentPane.add(txtClothesPrice);
		txtClothesPrice.setColumns(10);
		
		DefaultTableModel model = new DefaultTableModel(); 
		
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Brand");
		model.addColumn("Color");
		model.addColumn("Size");
		model.addColumn("Price");
		
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(423, 31, 211, 229);
		contentPane.add(table);
		
		
		
		btnNewButton = new JButton("Find Brand");
		btnNewButton.addMouseListener(new MouseAdapter() {
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
				
				call = service.findClothesbyBrand(txtClothesBrand.getText());
				
				try {
					Response<Reply> response = call.execute();						
					
//					System.out.println(response.body().getMessage());
					model.setRowCount(0);
					for (Clothes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
					//				Call<Reply> sendToChikka = service.sendChikka("SEND", "639177777428", "29290091", message_id, message_sent, "b2418ebf7f826869fc8626dcee056e7d0845ad2cb5b76e9de87f9d9038049262",  "860326f64656b1901624f3147b11c76ab43d508a52af3467775e1794b463e112");
					//				Response<Reply> chikka = sendToChikka.execute();
				} catch (IOException f) {
					f.printStackTrace();
				}	
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(229, 63, 153, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find Size");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
				
				call = service.findClothesbySize(txtClothesSize.getText());
				
				try {
					Response<Reply> response = call.execute();						
					

					model.setRowCount(0);
					for (Clothes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
				} catch (IOException f) {
					f.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(229, 101, 153, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Find Color");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
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
				
				call = service.findClothesbyColor(txtClothesColor.getText());
				
				try {
					Response<Reply> response = call.execute();						
					

					model.setRowCount(0);
					for (Clothes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
				} catch (IOException f) {
					f.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(229, 140, 153, 29);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Find Price");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
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
				
				call = service.findClothesbyPrice(Double.parseDouble(txtClothesPrice.getText()));
				
				try {
					Response<Reply> response = call.execute();						
					

					model.setRowCount(0);
					for (Clothes c : response.body().getMessage()) {
						model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
					}
				} catch (IOException f) {
					f.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(229, 179, 153, 29);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Buy Items");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(53, 211, 329, 45);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BuyItem buy = new BuyItem();
				buy.setItemType("clothes");
				buy.setVisible(true);
			}
		});
		
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
		
		call = service.listClothes();
		try {
			Response<Reply> response = call.execute();						
			
//			System.out.println(response.body().getMessage());
			
			for (Clothes c : response.body().getMessage()) {
				model.addRow(new Object[]{c.getId(), c.getName(), c.getBrand(),c.getColor(),c.getSize(), c.getPrice()});
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
		
		@GET("http://localhost:9999/espTrade/findClothesbySize") Call<Reply> findClothesbySize(@Query("size") String size);
		
		@GET("http://localhost:9999/espTrade/findClothesbyColor") Call<Reply> findClothesbyColor(@Query("color") String color);
		
		@GET("http://localhost:9999/espTrade/findClothesbyPrice") Call<Reply> findClothesbyPrice(@Query("price") Double price);
		
	}
}
