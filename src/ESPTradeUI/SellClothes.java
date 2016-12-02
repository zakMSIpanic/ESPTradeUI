package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ESPTradeUI.SellShoes.replyClass;
import ESPTradeUI.SellShoes.sendClass;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SellClothes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellClothes frame = new SellClothes();
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
	public SellClothes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 481, 278);
		contentPane.add(panel);
		
		JLabel lblSellClothes = new JLabel("Sell Clothes!");
		lblSellClothes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSellClothes.setBounds(88, 20, 130, 36);
		panel.add(lblSellClothes);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(56, 68, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Brand:");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(56, 96, 61, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Color:");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_3.setBounds(56, 124, 61, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Size:");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_4.setBounds(56, 152, 61, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Price:");
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_5.setBounds(56, 180, 61, 16);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 63, 130, 26);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 91, 130, 26);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 119, 130, 26);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 148, 130, 26);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 176, 130, 26);
		panel.add(textField_4);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(258, 68, 176, 176);
		panel.add(textArea);
		
		JButton button = new JButton("Post for Selling");
		button.addActionListener(new ActionListener() {
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
				
				SellClothesService service = retrofit.create(SellClothesService.class);
				
				sendClass sender = new sendClass();
				sender.setName(textField.getText());
				sender.setBrand(textField_1.getText());
				sender.setColor(textField_2.getText());
				sender.setPrice(Double.parseDouble(textField_4.getText()));
				sender.setSize(textField_3.getText());
				
				Call<replyClass> call = service.sellClothes(sender.getName(), sender.getBrand(), sender.getColor(), sender.getSize(), sender.getPrice());
				
				Response<replyClass> response;
				
				try {
					response = call.execute();
					System.out.println(1);
					System.out.println(response.code());
					String reply = response.body().getData().toString();
					System.out.println(reply);
					textArea.setText("PLEASE");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(56, 208, 186, 36);
		panel.add(button);

	}
	private interface SellClothesService 
	{
		@GET("http://localhost:9999/espTrade/sellClothes") Call<replyClass> sellClothes(@Query("name") String name,
																					@Query("brand") String brand,
																					@Query("color") String color,
																					@Query("size") String size,
																					@Query("price") Double price);
		
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
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		String name = textField.getText();
		Double price = Double.parseDouble(textField_4.getText());
		String brand = textField_1.getText();
		String color = textField_2.getText();
		String size = textField_3.getText();
	}

	@Override
	public String toString() {
		return "SellClothes [contentPane=" + contentPane + ", textField=" + textField + ", textField_1=" + textField_1
				+ ", textField_2=" + textField_2 + ", textField_3=" + textField_3 + ", textField_4=" + textField_4
				+ "]";
	}
}
