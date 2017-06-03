package inventario;

import javax.swing.Icon;

public class ItemImage {
	// FIELDS
	private String name;
	private Icon img;

	// CONSTRUCTOR
	public ItemImage(String text,Icon icon)
    {
        this.name=text;
        this.img=icon;
    }

	// GETTERS AND SET
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Icon getImg() {
		return img;
	}

	public void setImg(Icon img) {
		this.img = img;
	}
}
