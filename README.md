
# ASCII ART

The intent of this JAVA program is to create graphics or art form from the ASCII characters.These images were popular prior to the Internet and broadband when people connected via a bulletin board system. ASCII art may still be found on the Internet today and is a popular way to create a unique image.
Just pipe in your image and see the magic!

## How it works

1. The ImageType.java file checks the type of the image. It only allows jpg, jpeg, png, and gif.
2. The ImagePreprocessor.java converts the image to a pixel matrix and then to a brightness matrix.
3. The ImageToAscii.java file converts the brightness value to a corresponding ASCII character and prints the ASCII matrix on the console.

## How to use

1. Clone or download the repository.
2. Compile and run the `Driver.java` file, passing the path to the image file as a command-line argument.

```java
  javac Driver.java
  java Driver path/to/image.jpg
```

3. The ASCII art will be printed to the console.

## Requirements

- Java JDK (tested with version 8 and above)
- An image file in jpg, png, or gif format.

## Future Improvements

- Add the option to save the ASCII art output to a file.
- Improve the brightness to ASCII character mapping for better quality ASCII art.
- Allow the user to specify the width and height of the output ASCII art.


