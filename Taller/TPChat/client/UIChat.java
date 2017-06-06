package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UIChat {

	private JFrame frame;
	private JTextField txtMessage;
	private JTextArea txtAreaMessage;
	private JButton btnSend;

	private String username;
	private UIClients uiClients;

	public UIChat(String username, UIClients uiClients) {
		this.username = username;
		this.uiClients = uiClients;
		initialize();
		initializeEvents();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle(this.username);
		frame.setBounds(100, 100, 482, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		panel.setMinimumSize(new Dimension(10, 50));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		btnSend = new JButton("ENVIAR");
		panel.add(btnSend, BorderLayout.EAST);

		txtMessage = new JTextField();
		panel.add(txtMessage, BorderLayout.CENTER);
		txtMessage.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		txtAreaMessage = new JTextArea();
		txtAreaMessage.setEditable(false);
		scrollPane.setViewportView(txtAreaMessage);
		
		frame.setVisible(true);
	}

	private void initializeEvents() {
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onSendClick(e);
			}
		});
		txtMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent VK) {
				if (VK.getKeyCode() == KeyEvent.VK_ENTER) {
					onPressEnter();
				}
			}
		});
	}

	private void onSendClick(MouseEvent e) {
		this.sendMessage();
	}

	private void onPressEnter() {
		this.sendMessage();
	}

	private void sendMessage() {
		this.uiClients.sendMessage(this.username, txtMessage.getText());
		this.receiveMessage(txtMessage.getText());
		this.txtMessage.setText("");
	}

	public void receiveMessage(String message) {
		txtAreaMessage.append(message + "\n");
	}
}
