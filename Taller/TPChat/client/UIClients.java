package client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shared.PacketMessage;
import shared.PacketUser;

import javax.swing.DefaultListCellRenderer;
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
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class UIClients extends JFrame {

	private JPanel contentPane;
	private JList<String> usersList;
	private JLabel lblUsers;

	private JMenuItem mntmExit;
	private JMenuItem mntmConectar;
	private JMenuItem mntmPublicSession;
	private JMenuItem mntmPrivateSession;
	private JMenuItem mntmConfigIpPort;

	private Client client;
	private HashMap<String, UIChat> uiChats;
	private FileProperties file;

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

		this.file = new FileProperties("config.properties");

		setTitle("Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 379, 526);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmConectar = new JMenuItem("Conectar");
		mnArchivo.add(mntmConectar);

		mntmExit = new JMenuItem("Salir");
		mnArchivo.add(mntmExit);

		JMenu mnChat = new JMenu("Chat");
		menuBar.add(mnChat);

		mntmPublicSession = new JMenuItem("Sala de Chat");
		mnChat.add(mntmPublicSession);

		mntmPrivateSession = new JMenuItem("Sesión privada");
		mnChat.add(mntmPrivateSession);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmConfigIpPort = new JMenuItem("Configurar IP-Puerto");
		mnAyuda.add(mntmConfigIpPort);

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

		uiChats = new HashMap<String, UIChat>();

		usersList = new JList<String>();
		usersList.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof String) {
					((JLabel) renderer).setText(((String) value));
				}
				return renderer;
			}
		});
		scrollPane.setViewportView(usersList);

		lblUsers = new JLabel("Desconectado.");
		lblUsers.setBounds(0, 464, 373, 14);
		contentPane.add(lblUsers);
	}

	public void initializeEvents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				openExitWindowConfirmation();
			}
		});
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openExitWindowConfirmation();
			}
		});

		mntmPublicSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new UIChat();
			}
		});

		mntmPrivateSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPrivateWindowChat();
			}
		});
		mntmConfigIpPort.addActionListener(new ActionListener() {
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

		mntmConectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openLoginWindow();
			}
		});
	}

	/*
	 * Abre una ventana emergente preguntando si se quiere salir de la
	 * aplicacion
	 */
	private void openExitWindowConfirmation() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea salir del Chat", "Confirmación",
				JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	/*
	 * Abre una ventana privada de chat
	 */
	private void openPrivateWindowChat() {
		if (!usersList.isSelectionEmpty()) {
			UIChat uiChat = this.selectChat(usersList.getSelectedValue());
		} else
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", "Seleccionar Usuario",
					JOptionPane.INFORMATION_MESSAGE);
	}

	/*
	 * Abre una ventana de configuracion de IP y Puerto
	 */
	private void openConfigurationWindow() {
		new UIConfiguration(this, file);
	}

	/*
	 * Abre la ventana de Login
	 */
	private void openLoginWindow() {
		this.file.read();
		if (file.getIP() != null && file.getIP() != "" && file.getPuerto() > 0)
			new UILogin(this);
		else {
			JOptionPane.showMessageDialog(this,
					"Antes de conectar debe configurar una IP y un Puerto en el menú de Configuración", "Configuración",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/*
	 * Setea el cliente
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/*
	 * Se loguea usando el cliente
	 */
	public boolean login(String username, String password) throws ClassNotFoundException, IOException {
		if (this.client == null)
			this.client = new Client(this, this.file);

		return this.client.Login(username, password);
	}

	/*
	 * Envia el mensaje usando el cliente
	 */
	public void sendMessage(String username, String message) throws IOException {
		if (this.client != null)
			this.client.sendMessage(username, message);
	}

	/*
	 * Recibe un mensaje a mostrar, abre el chat correspondiente y lo muestra
	 */
	public void receiveMessage(String from, String to, String message) {
		String username = from.equals(this.client.getUsername()) ? to : from;
		this.selectChat(username).receiveMessage(from, message);
	}

	public UIChat selectChat(String username) {
		UIChat uiChat;
		if (uiChats.containsKey(username)) {
			uiChat = uiChats.get(username);
		} else {
			uiChat = new UIChat(username, this);
			uiChats.put(username, uiChat);
		}
		uiChat.setVisible(true);
		return uiChat;
	}

	/*
	 * Elimina la ventana chat de la lista
	 */
	public void removeChat(String username) {
		if (uiChats.containsKey(username)) {
			UIChat uiChat = uiChats.get(username);
			uiChat.dispose();
			uiChats.remove(username);			
		}
	}

	/*
	 * Actualiza la lista de usuarios conectados en la UI
	 */
	public void updateUsers(List<String> users) {
		DefaultListModel<String> modeloLista = new DefaultListModel<String>();
		if (users == null || users.size() == 0) {
			usersList.setModel(modeloLista);
		} else {
			for (String user : users) {
				// Si el usuario soy "yo" no lo agrego a la lista
				if (!this.client.getUsername().equals(user))
					modeloLista.addElement(user);
			}
			usersList.setModel(modeloLista);
		}

		lblUsers.setText("Cantidad de Usuarios Conectados: " + modeloLista.getSize());
	}

	/*
	 * Muestra un cuadro de dialogo
	 */
	public void showMessageDialog(String message, String title, int messageType) {
		JOptionPane.showMessageDialog(this, message, title, messageType);

	}

}
