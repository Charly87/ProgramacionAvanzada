package winform;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class chat {

	private JFrame frame;
	private JTextField txtMensaje;
	private JTextArea txtPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat window = new chat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		panel.setMinimumSize(new Dimension(10, 50));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtPrincipal.append(txtMensaje.getText()+"\n");
				txtMensaje.setText("");
			}
		});
	
		panel.add(btnEnviar, BorderLayout.EAST);
		
		txtMensaje = new JTextField();
		txtMensaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent VK) {
			  if(VK.getKeyCode() == KeyEvent.VK_ENTER){
				  txtPrincipal.append(txtMensaje.getText()+"\n");
					txtMensaje.setText("");
			  }
			}
		});
		panel.add(txtMensaje, BorderLayout.CENTER);
		txtMensaje.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		txtPrincipal = new JTextArea();
		txtPrincipal.setEditable(false);
		scrollPane.setViewportView(txtPrincipal);
	}
}
