package projet;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * Équipe Piccolo
 */

public class GUI {
	
	
	
	public static void afficherCartes(final int carte1, final int carte2) {
		EventQueue.invokeLater(new Runnable()
        {
            public void run(){
                ImageFrame frame = new ImageFrame(carte1, carte2);
                Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
                frame.setPreferredSize(new Dimension(200, 155));
                Dimension windowSize = new Dimension(frame.getPreferredSize());
                int posHoriz = screenSize.width / 2 - windowSize.width / 2;
                int posVerti = -100 + screenSize.height / 2 - windowSize.height / 2;
                frame.pack();   
                frame.setLocation(posHoriz, posVerti);
                frame.setVisible(true);
                frame.setAlwaysOnTop(true);
            }
        }
		);
	}
}

class ImageFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public ImageFrame(int carte1, int carte2) {
        setTitle("Cartes");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ImageComponent component = new ImageComponent(carte1, carte2);
        add(component);
    }

    public static final int DEFAULT_WIDTH = 200;
    public static final int DEFAULT_HEIGHT = 150;
}


class ImageComponent extends JComponent{

	private static final long serialVersionUID = 1L;
    private Image image1;
    private Image image2;
    
    public ImageComponent(int carte1, int carte2) {
        try{
            File imageTemp1 = new File("Deck\\" + carte1 + ".png");
            image1 = ImageIO.read(imageTemp1);
            File imageTemp2 = new File("Deck\\" + carte2 + ".png");
            image2 = ImageIO.read(imageTemp2);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void paintComponent (Graphics g) {
        if(image1 == null) return;
        g.drawImage(image1, 10, 10, this);
        g.drawImage(image2, 100, 10, this);
    }

}