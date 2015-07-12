package me.silvertriclops.perkatfinder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;

import javax.swing.Box;

public class Dialog extends JDialog {
	private static final long serialVersionUID = 2552792018106020215L;

	public Dialog(String error, String buttonText, ActionListener buttonAction) {
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lbError = new JLabel(error);
		panel_1.add(lbError);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_2.add(btnClose);
		
		if (buttonText != null) {
			Component horizontalStrut = Box.createHorizontalStrut(5);
			panel_2.add(horizontalStrut);
			JButton btnAction = new JButton(buttonText);
			btnAction.addActionListener(buttonAction);
			panel_2.add(btnAction);
		}
		
		
		getContentPane().add(panel);
		
		pack();
		this.setMaximumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Dialog("test", null, null);
	}

}
