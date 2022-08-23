import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;

public class ImageProcessor {

    private Image_Type imageType;
    private String imagePath;

    public ImageProcessor(String imageFullPath){
        imagePath = imageFullPath;
        imageType = new Image_Type(imagePath);
    }

    public int[][] getBrightnessMatrix(){
        BufferedImage image = getImage(imagePath);
        int[][] pixels = getPixelsFromImage(image);
        return setBrightnessMatrix(pixels);
    }

    private BufferedImage getImage(String imageFullPath){
        BufferedImage bufferedImage = null;
        try {
            if (imageFullPath == null) {
                throw new NullPointerException("Image full path cannot be null or empty");
            }
            boolean isImage = imageType.isFileAnImage();
            if (!isImage) {
                throw new ImagingOpException(Image_Type.IMAGE_ALLOW_TYPES);
            }
            String tempImagePath = imageFullPath;
            bufferedImage = ImageIO.read(new File(tempImagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }


    private static int[][] getPixelsFromImage(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException();
        }
        int h = bufferedImage.getHeight();
        int w = bufferedImage.getWidth();
        int[][] pixels = new int[h][w];
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {
                pixels[j][i] = bufferedImage.getRGB(i, j);
            }
        }
        return pixels;
    }

     private static int[][] setBrightnessMatrix(int[][] pixels) {
        int r, g, b;
        int average;
        int[][] avg = new int[pixels.length][pixels[0].length];

        for (int i = 0; i < pixels.length; ++i) {
            for (int j = 0; j < pixels[0].length; ++j) {
                r = (pixels[i][j]>>16) & 0xff ;
                g = (pixels[i][j]>>8) & 0xff ;
                b = (pixels[i][j]) & 0xff ;
                average=(r+g+b)/3;
                avg[i][j]=average;
            }
        }
        return avg;
    }
}
