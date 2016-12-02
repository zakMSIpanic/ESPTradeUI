package ESPTradeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FilterViewLostItems extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterViewLostItems frame = new FilterViewLostItems();
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
	public FilterViewLostItems() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLostItems = new JLabel("Lost Items:");
		lblLostItems.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLostItems.setBounds(6, 19, 88, 37);
		contentPane.add(lblLostItems);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(16, 68, 364, 204);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("View All");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(122, 25, 174, 29);
		contentPane.add(btnNewButton);
	}
}
