package screenShot;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class CapturePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage img;
    private JFileChooser chooser;
    private Dimension psize;

    public CapturePanel(BufferedImage img){
        super();
        this.img = img;
        psize = new Dimension(img.getWidth(),img.getHeight());
        this.setPreferredSize(psize);
        chooser = new JFileChooser();
    }

    public void paint(Graphics g) {
        if (img != null) {
            g.drawImage(img,0,0,this);
        }
    }

    public void saveJPEG(){
        int result = chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();
        if(result == JFileChooser.APPROVE_OPTION){
            try{
                ImageIO.write(img,"jpeg",file);
            } catch(Exception e){}
        }
    }
}