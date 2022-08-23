public class ImageToAscii {


    private ImageProcessor processor;
    private  static final String ASCIICHARS  = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";

    public ImageToAscii(String imageFullPath){
        processor = new ImageProcessor(imageFullPath);
    }

    public void printAsciiMatrix () {
        char[][] pixels = setAsciiMatrix(processor.getBrightnessMatrix());
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                System.out.print(pixels[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] setAsciiMatrix(int[][] brightnessMatrix)
    {
        char[][] asciiMatrix = new char[brightnessMatrix.length][];
        int rowCount = 0;
        for (int[] row : brightnessMatrix)
        {
            char[] asciiRow = new char[row.length];
            int cellCount = 0;
            for (int cell : row)
            {
                asciiRow[cellCount] = convertToAscii(cell);
                cellCount++;
            }

            asciiMatrix[rowCount] = asciiRow;
            rowCount++;
        }
        return asciiMatrix;
    }

    private static char convertToAscii(int brightnessValue)
    {
        char asciiValue;
        int asciiIndex;
        asciiIndex = (int) ((ASCIICHARS.length() - 1) * (brightnessValue / 255.0));
        asciiValue = ASCIICHARS.charAt(asciiIndex);
        return asciiValue;
    }
}
