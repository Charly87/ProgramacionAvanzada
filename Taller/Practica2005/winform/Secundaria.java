package winform;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Secundaria extends JDialog{

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private static JTextField txtPrincipal;
	
	private String nombre;
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	/**
	 * Launch the application.
	 */
	public static void main(JTextField texto) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secundaria window = new Secundaria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
		txtPrincipal = texto;
		
	}

	/**
	 * Create the application.
	 */
	public Secundaria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(125, 56, 276, 42);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(128, 128, 273, 42);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPrincipal.setText(txtNombre.getText()  + "," + txtApellido.getText());
			}
		});
		
		btnAceptar.setBounds(160, 203, 89, 23);
		panel.add(btnAceptar);
		
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(24, 66, 91, 23);
		panel.add(lbNombre);
		
		JLabel lbApellido = new JLabel("Apellido");
		lbApellido.setBounds(24, 138, 68, 23);
		panel.add(lbApellido);
	}
}
