package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UILogin extends JDialog {
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UILogin window = new UILogin(null);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UILogin(JFrame parentFrame) {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
		setLocationRelativeTo(parentFrame);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnConnect = new JButton("Conectar");
		btnConnect.setBounds(17, 83, 89, 23);
		getContentPane().add(btnConnect);
		
		JLabel lblUsername = new JLabel("Usuario:");
		lblUsername.setBounds(29, 14, 46, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(29, 42, 77, 14);
		getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(114, 11, 116, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(114, 39, 116, 20);
		getContentPane().add(txtPassword);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(132, 83, 89, 23);
		getContentPane().add(btnCancel);
		setVisible(true);	
	}
}
