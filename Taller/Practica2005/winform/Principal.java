package winform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtSalida = new JTextField();
		txtSalida.setBounds(70, 47, 311, 52);
		panel.add(txtSalida);
		txtSalida.setColumns(10);
		
		JButton btnFormulario = new JButton("Formulario");
		btnFormulario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			  Secundaria s = new Secundaria();
			   s.main(txtSalida);			   
		       //txtSalida.setText(s.getApellido() + "," + s.getNombre());
			}
		});
		btnFormulario.setBounds(175, 159, 104, 31);
		panel.add(btnFormulario);
	}
}
