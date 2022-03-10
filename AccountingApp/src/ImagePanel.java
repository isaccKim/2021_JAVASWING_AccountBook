import java.awt.*;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image img;

	public ImagePanel (Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null))); //Background 사이즈에 맞게  패널 크기를 정해주는 함
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public Dimension getDim() {
		return new Dimension(img.getWidth(null),img.getHeight(null)+40); // 이미지 사이즈를 리턴 하는 함수 
	}
}
