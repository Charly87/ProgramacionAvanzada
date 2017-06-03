package inventario;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ConJList {

	private JFrame frame;
	private DefaultListModel dm = new DefaultListModel();
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConJList window = new ConJList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConJList() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();	
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	
		ImageIcon icon = new ImageIcon("TPChat\\Pocion.png");		
		dm.add(0, icon);
		dm.add(1, icon);
		dm.add(2, icon);
		dm.add(3, icon);
		dm.add(4, icon);
		dm.add(5, icon);
		dm.add(6, icon);
		dm.add(7, icon);
		dm.add(8, icon);
		dm.add(9, icon);
		
		list = new JList(dm);
		list.setSize(300,0);
		list.setMaximumSize(new Dimension(300,0));
		list.setVisibleRowCount(2);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		scrollPane.setViewportView(list);
	}
}
