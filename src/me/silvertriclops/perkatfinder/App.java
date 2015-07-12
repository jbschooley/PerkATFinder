package me.silvertriclops.perkatfinder;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {
	private static final long serialVersionUID = 2542400305706754239L;
	private JTextField tfEmail;
	private JPasswordField tfPassword;
	private JTextField tfUserID;
	private JTextField tfAccessToken;
	private JPanel loading = new JPanel();
	private JButton btnSubmit = new JButton("Submit");
	
	
	public App() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JLayeredPane panel_4 = new JLayeredPane();
		getContentPane().add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel_4.setLayer(panel, 1);
		panel_4.add(panel);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 0;
		panel_1.add(lblEmail, gbc_lblEmail);
		
		tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmail.gridx = 1;
		gbc_tfEmail.gridy = 0;
		panel_1.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);
		tfEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPassword.requestFocus();
			}
		});
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		panel_1.add(lblPassword, gbc_lblPassword);
		
		tfPassword = new JPasswordField();
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPassword.gridx = 1;
		gbc_tfPassword.gridy = 1;
		panel_1.add(tfPassword, gbc_tfPassword);
		tfPassword.addActionListener(submit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 0, 5, 0));
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JSeparator separator = new JSeparator();
		separator.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_3.add(separator);
		
		panel_3.add(loading);
		loading.setVisible(false);
		loading.setLayout(new BoxLayout(loading, BoxLayout.X_AXIS));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		loading.add(horizontalStrut_1);
		
		JLabel lblNewLabel = new JLabel("");
		loading.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(App.class.getResource("/loading.gif")));
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		panel_3.add(horizontalStrut);
		
		panel_3.add(btnSubmit);
		btnSubmit.addActionListener(submit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblUserId = new JLabel("User ID");
		GridBagConstraints gbc_lblUserId = new GridBagConstraints();
		gbc_lblUserId.anchor = GridBagConstraints.EAST;
		gbc_lblUserId.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserId.gridx = 0;
		gbc_lblUserId.gridy = 0;
		panel_2.add(lblUserId, gbc_lblUserId);
		
		tfUserID = new JTextField();
		tfUserID.setBackground(Color.WHITE);
		tfUserID.setEditable(false);
		GridBagConstraints gbc_tfUserID = new GridBagConstraints();
		gbc_tfUserID.insets = new Insets(0, 0, 5, 0);
		gbc_tfUserID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUserID.gridx = 1;
		gbc_tfUserID.gridy = 0;
		panel_2.add(tfUserID, gbc_tfUserID);
		tfUserID.setColumns(10);
		
		JLabel lblAccessToken = new JLabel("Access Token");
		GridBagConstraints gbc_lblAccessToken = new GridBagConstraints();
		gbc_lblAccessToken.anchor = GridBagConstraints.EAST;
		gbc_lblAccessToken.insets = new Insets(0, 0, 0, 5);
		gbc_lblAccessToken.gridx = 0;
		gbc_lblAccessToken.gridy = 1;
		panel_2.add(lblAccessToken, gbc_lblAccessToken);
		
		tfAccessToken = new JTextField();
		tfAccessToken.setBackground(Color.WHITE);
		tfAccessToken.setEditable(false);
		GridBagConstraints gbc_tfAccessToken = new GridBagConstraints();
		gbc_tfAccessToken.anchor = GridBagConstraints.NORTH;
		gbc_tfAccessToken.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAccessToken.gridx = 1;
		gbc_tfAccessToken.gridy = 1;
		panel_2.add(tfAccessToken, gbc_tfAccessToken);
		tfAccessToken.setColumns(10);
		
		pack();
		setSize(400, getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Perk UID/Token Finder");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	ActionListener submit = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Thread thSubmit = new Thread() {
				public void run() {
					btnSubmit.setEnabled(false);
					loading.setVisible(true);
					tfEmail.setEnabled(false);
					tfPassword.setEnabled(false);
					String pw =  new String(tfPassword.getPassword());
					tfPassword.setText("");
					String[] data = GetAuth.getAuth(tfEmail.getText(), pw);
					switch (data[0]) {
					case "0":
						tfUserID.setText(data[1]);
						tfAccessToken.setText(data[2]);
						break;
					case "1":
						new Dialog("Email or password incorrect", null, null);
						break;
					case "2":
						new Dialog("Something's wrong; please check your internet connection", null, null);
						break;
					}
					btnSubmit.setEnabled(true);
					loading.setVisible(false);
					tfEmail.setEnabled(true);
					tfPassword.setEnabled(true);
				}
			};
			thSubmit.start();
		}
	};

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new App();
	}

}
