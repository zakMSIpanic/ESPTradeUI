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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SellItem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellItem frame = new SellItem();
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
	public SellItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 498, 278);
		contentPane.add(panel);
		
		JLabel lblSellItems = new JLabel("Sell Items!");
		lblSellItems.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSellItems.setBounds(97, 21, 102, 36);
		panel.add(lblSellItems);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(56, 68, 61, 16);
		panel.add(label_1);
		
		JLabel label_5 = new JLabel("Price:");
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_5.setBounds(56, 100, 61, 16);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 63, 130, 26);
		panel.add(textField);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 96, 130, 26);
		panel.add(textField_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(269, 63, 176, 176);
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

				SellItemsService service = retrofit.create(SellItemsService.class);
				
				sendClass sender = new sendClass();
				sender.setName(textField.getText());
				sender.setPrice(Double.parseDouble(textField_4.getText()));
				
				Call<replyClass> call = service.sellItems(sender.getName(), sender.getPrice());
				
				Response<replyClass> response;
				
				try {
					response = call.execute();
					System.out.println(1);
					System.out.println(response.code());
					String reply = response.body().getData().toString();
					System.out.println(reply);
					textArea.setText(reply);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(56, 142, 186, 36);
		panel.add(button);
		
	}
	
	private interface SellItemsService 
	{
		@GET("http://localhost:9999/espTrade/sellItem") Call<replyClass> sellItems(@Query("name") String name,
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
		String name = textField.getText();
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
		Double price = Double.parseDouble(textField_4.getText());
	}

}
