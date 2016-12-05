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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SellShoes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Long sellerID;
	
	

	public Long getSellerID() {
		return sellerID;
	}

	public void setSellerID(Long sellerID) {
		this.sellerID = sellerID;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellShoes frame = new SellShoes();
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
	public SellShoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSellShoes = new JLabel("Sell Shoes!");
		lblSellShoes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSellShoes.setBounds(100, 20, 102, 36);
		contentPane.add(lblSellShoes);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblName.setBounds(56, 68, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblBrand.setBounds(56, 96, 61, 16);
		contentPane.add(lblBrand);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblColor.setBounds(56, 124, 61, 16);
		contentPane.add(lblColor);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSize.setBounds(56, 152, 61, 16);
		contentPane.add(lblSize);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPrice.setBounds(56, 180, 61, 16);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(116, 63, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 91, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 119, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 148, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(116, 176, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnPostForSelling = new JButton("Post for Selling");
		btnPostForSelling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
				interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
				OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
				
				Gson gson = new GsonBuilder().create();
				Retrofit retrofit = new Retrofit.Builder()
						.client(client)
						.baseUrl("http://localhost:9999/") // a legit base url is needed regardless
						.addConverterFactory(GsonConverterFactory.create(gson))
						.build();
				
				SellShoesService service = retrofit.create(SellShoesService.class);
				
				sendClass sender = new sendClass();
				sender.setName(textField.getText());
				sender.setBrand(textField_1.getText());
				sender.setColor(textField_2.getText());
				sender.setPrice(Double.parseDouble(textField_4.getText()));
				sender.setSize(Integer.parseInt(textField_3.getText()));
				
				Call<replyClass> call = service.sellShoes(sender.getName(), sender.getBrand(), sender.getColor(), sender.getSize(), sender.getPrice(), sellerID);
				
				Response<replyClass> response;
				
				try {
					response = call.execute();
					System.out.println(response.code());
					String reply = response.body().getData().toString();
					System.out.println(reply);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnPostForSelling.setBounds(56, 208, 186, 36);
		contentPane.add(btnPostForSelling);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(264, 63, 176, 176);
		contentPane.add(textArea);
	}
	
	private interface SellShoesService 
	{
		@POST("http://localhost:9999/espTrade/sellShoes") Call<replyClass> sellShoes(@Query("name") String name,
																					@Query("brand") String brand,
																					@Query("color") String color,
																					@Query("size") Integer size,
																					@Query("price") Double price,
																					  @Query("sellerID") Long id);
		
	}
	
	public class replyClass
	{
		Object data;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}
	}
	
	public class sendClass
	{
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
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
		String name = textField.getText();
		Double price = Double.parseDouble(textField_3.getText());
		String brand = textField_1.getText();
		String color = textField_2.getText();
		Integer size = Integer.parseInt(textField_4.getText());
	}
}
