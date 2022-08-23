import java.awt.image.BufferedImage;

public class Driver {

    public static void main(String[] args) {

        ImageToAscii asciiImage = new ImageToAscii(args[0]);
        asciiImage.printAsciiMatrix();
    }
}
