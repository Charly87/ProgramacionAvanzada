package ConJList;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;

public class ListPanel extends JPanel {

    private static final int N = 5;
    private DefaultListModel dlm = new DefaultListModel();
    private JList list = new JList(dlm);

    public ListPanel() {
        super(new GridLayout());
        
        // Cargas los Items
        for (int i = 0; i < 10; i++) {
        	ImageIcon icon = new ImageIcon("Inventario\\Pocion.png");		
        	dlm.addElement(icon);  
        }
        
        // Hace que la orientacion sea Horizontal
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        // Hace que ponga la cantidad máxima horizontal luego continua en
        // la linea de abajo
        list.setVisibleRowCount(-1);
        
        // Creo el Scroll
        JScrollPane scrollPane = new JScrollPane();
		this.add(scrollPane, BorderLayout.CENTER);
		
		// Agrego el JList al scroll
		scrollPane.setViewportView(list);
		// Seteo el ancho Maximo del Scroll ( Sin esto, no funciona )
		scrollPane.setPreferredSize(new Dimension(500, 500));
		
		//*******************************************************
		// Esto es para dar formato al Item( Borde, color, etc ).
		//*******************************************************
        //list.setCellRenderer(new ListRenderer());
        //list.addListSelectionListener(new SelectionHandler());
    }

    private void display() {
        JFrame f = new JFrame("ListPanel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ListPanel().display();
            }
        });
    }
    
//*****************************************************
//Esto es para dar formato al Item( Borde, color, etc ).
//*****************************************************
//    private class ListRenderer extends DefaultListCellRenderer {
//
//        public ListRenderer() {
//            this.setBorder(BorderFactory.createLineBorder(Color.red));
//        }
//
//        @Override
//        public Component getListCellRendererComponent(JList list, Object
//            value, int index, boolean isSelected, boolean cellHasFocus) {
//            JComponent jc =  (JComponent) super.getListCellRendererComponent(
//                list, value, index, isSelected, cellHasFocus);
//            jc.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.BLACK));
//            return jc;
//        }
//    }
//
//    private class SelectionHandler implements ListSelectionListener {
//
//        @Override
//        public void valueChanged(ListSelectionEvent e) {
//            if (!e.getValueIsAdjusting()) {
//                System.out.println(Arrays.toString(list.getSelectedValues()));
//            }
//        }
//    }
}