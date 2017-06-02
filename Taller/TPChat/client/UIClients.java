package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIClients extends JFrame {

	private JPanel contentPane;
	private JList<String> usersList;
	private JLabel lblUsers;

	private JMenuItem mntmSalir;
	private JMenuItem mntmSalaDeChat;
	private JMenuItem mntmSesionPrivada;
	private JMenuItem mntmConfigIpPuerto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIClients frame = new UIClients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UIClients() {
		initialize();
		initializeEvents();
	}

	public void initialize() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setTitle("Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 379, 526);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mnArchivo.add(mntmConectar);

		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);

		JMenu mnChat = new JMenu("Chat");
		menuBar.add(mnChat);

		mntmSalaDeChat = new JMenuItem("Sala de Chat");
		mnChat.add(mntmSalaDeChat);

		mntmSesionPrivada = new JMenuItem("Sesión privada");
		mnChat.add(mntmSesionPrivada);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmConfigIpPuerto = new JMenuItem("Configurar IP-Puerto");
		mnAyuda.add(mntmConfigIpPuerto);

		JMenuItem mntmAcerca = new JMenuItem("Acerca");
		mnAyuda.add(mntmAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 373, 462);
		contentPane.add(scrollPane);

		usersList = new JList<String>();

		scrollPane.setViewportView(usersList);

		lblUsers = new JLabel("Cantidad de Usuarios conectados: ");
		lblUsers.setBounds(0, 464, 373, 14);
		contentPane.add(lblUsers);

		String str[] = { "Pepe", "Juan", "Julio", "Lucas", "Leo" };
		addUser(str);

		setVisible(true);
	}

	public void initializeEvents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				openExitWindowConfirmation();
			}
		});
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openExitWindowConfirmation();
			}
		});

		mntmSalaDeChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UIChat();
			}
		});

		mntmSesionPrivada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openPrivateWindowChat();
			}
		});
		mntmConfigIpPuerto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openConfigurationWindow();
			}
		});
		usersList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
					openPrivateWindowChat();
			}
		});
	}

	private void openExitWindowConfirmation() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea salir del Chat", "Confirmación",
				JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public void addUser(String str[]) {
		DefaultListModel<String> modeloLista = new DefaultListModel<String>();
		for (String item : str)
			modeloLista.addElement(item);
		usersList.setModel(modeloLista);
		lblUsers.setText("Cantidad de Usuarios Conectados: " + modeloLista.getSize());
	}

	private void openPrivateWindowChat() {
		if (!usersList.isSelectionEmpty())
			new UIChat();
		else
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", "Seleccionar Usuario",
					JOptionPane.INFORMATION_MESSAGE);
	}

	private void openConfigurationWindow() {
		new UIConfiguration(this);
	}
}
