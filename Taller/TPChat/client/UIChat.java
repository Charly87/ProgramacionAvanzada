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
	private JTextField txtMensaje;
	private JTextArea txtPrincipal;
	private JButton btnEnviar;
	private Client client;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIChat window = new UIChat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UIChat() {
		try {
			client = new Client("Cliente 1");
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}		
		initialize();
		initializeEvents();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 482, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		panel.setMinimumSize(new Dimension(10, 50));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		btnEnviar = new JButton("ENVIAR");
		panel.add(btnEnviar, BorderLayout.EAST);

		txtMensaje = new JTextField();
		panel.add(txtMensaje, BorderLayout.CENTER);
		txtMensaje.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		txtPrincipal = new JTextArea();
		txtPrincipal.setEditable(false);
		scrollPane.setViewportView(txtPrincipal);
	}

	private void initializeEvents() {
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onSendClick(e);
			}
		});
		txtMensaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent VK) {
				if (VK.getKeyCode() == KeyEvent.VK_ENTER) {
					onPressEnter();
				}
			}
		});
	}

	private void onSendClick(MouseEvent e) {
		this.Send();
	}

	private void onPressEnter() {
		this.Send();
	}

	private void Send() {
		this.client.Send(txtMensaje.getText());
		txtPrincipal.append(txtMensaje.getText() + "\n");
		txtMensaje.setText("");

	}
}
