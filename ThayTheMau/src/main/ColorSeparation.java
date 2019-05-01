package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

class Picture {

String img_name;
BufferedImage buf_img;
int width;
int height;

public Picture(String name) {
    this.img_name = name;

    try {
        buf_img = ImageIO.read(new File(img_name));
    } catch (IOException ex) {
        Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public Picture(int w, int h) {
    this.width = w;
    this.height = h;
    buf_img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
}

public int width() {
    width = buf_img.getWidth();
    return width;
}

public int height() {
    height = buf_img.getHeight();
    return height;
}

public Color get(int col, int row) {
    Color color = new Color(buf_img.getRGB(col, row));
    return color;
}

public void set(int col, int row, Color color) {
    buf_img.setRGB(col, row, color.getRGB());
}

public void show() {
    try {

        File saveAs = new File("D:\\" + new Random().nextInt() + ".png");
        ImageIO.write(buf_img, "png", saveAs);

        Desktop.getDesktop().open(saveAs);
    } catch (IOException ex) {
        Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
    }
   }

 }

public class ColorSeparation {

public static void main(String[] args) {

    // read in the picture specified by command-line argument
    Picture picture = new Picture("C:/Users/Tran Phu Quy/Downloads/anhngoctrinh.jpg");
    int width = picture.width();
    int height = picture.height();

    // create three empy pictures of the same dimension
    Picture pictureR = new Picture(width, height);


    // separate colors
    for (int col = 0; col < width; col++) {
        for (int row = 0; row < height; row++) {
            Color color = picture.get(col, row);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            float temp = (float) (1.0/8.0);
            System.out.println(r/32+"."+g/32+"."+b/32);
            pictureR.set(col, row, new Color((int)255/(1+ r/32), (int)255/(1 + g/32), (int)255/(1 + b/32)));

        }
    }

    // display  picture in its own window
    pictureR.show();

  }

}