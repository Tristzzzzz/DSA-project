package helpz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static BufferedImage getSpriteAtlas(){

        BufferedImage img = null;
        InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("/res/spriteatlas.png");
        try {
            if (is != null) {
                img = ImageIO.read(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
}
