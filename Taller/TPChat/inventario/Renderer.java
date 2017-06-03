package inventario;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Renderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		// ASSIGN TO VALUE THAT IS PASSED
		ItemImage is = (ItemImage) value;

		//setText(is.getName());
		setIcon(is.getImg());
		setSize(10, 10);
		setPreferredSize(new Dimension(100, 100));
		// SET BACKGROUND AND FOREGROUND COLORS TO CUSTOM LIST ROW
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {

			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		setEnabled(true);
		setFont(list.getFont());

		return this;

	}

}
