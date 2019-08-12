import java.awt.GraphicsEnvironment;

public class Fonts {
	public static void main(String[] args) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontNames[] = ge.getAvailableFontFamilyNames();
		for (String name : fontNames) {
			System.out.println(name);
		}

	}
}
