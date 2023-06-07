package test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GrayScale extends JPanel {

    BufferedImage  image;
    static int width;
    static int height;
    String nazwa;

    public GrayScale(String nazwa , int wybor, int r) {
        try {

            File input = new File(nazwa);
            image = ImageIO.read(input);
            width = image.getWidth();
            height= image.getHeight();

            double[][] M_Gauss = new double[][] { {1,2,1}, {2,4,2}, {1,2,1}};


            for(int i =r;i<height-r;i++){
                for(int j=r;j<width-r;j++){

                    double x,y,z;
                    x=0;
                    y=0;
                    z=0;

                    if(wybor==1) {
                        for (int k = -r; k <= r; k++) {
                            for (int l = -r; l <= r; l++) {

                                Color c = new Color(image.getRGB(j + k, i + l));
                                x += c.getRed();
                                y += c.getGreen();
                                z += c.getBlue();


                            }
                        }
                        x = x / (Math.pow((r+r+1),2));
                        y = y / (Math.pow((r+r+1),2));
                        z = z / (Math.pow((r+r+1),2));

                        if (x < 0) {
                            x = 0;
                        }
                        if (y < 0) {
                            y = 0;
                        }
                        if (z < 0) {
                            z = 0;
                        }
                        if (x > 255) {
                            x = 255;
                        }
                        if (y > 255) {
                            y = 255;
                        }
                        if (z > 255) {
                            z = 255;
                        }
                    }
                    if(wybor ==2){
                        double suma=16;
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {

                                Color c = new Color(image.getRGB(j + k, i + l));
                                x += c.getRed() * M_Gauss[k + 1][l + 1];
                                y += c.getGreen() * M_Gauss[k + 1][l + 1];
                                z += c.getBlue() * M_Gauss[k + 1][l + 1];


                            }
                        }
                        x = x / suma;
                        y = y / suma;
                        z = z / suma;

                        if (x < 0) {
                            x = 0;
                        }
                        if (y < 0) {
                            y = 0;
                        }
                        if (z < 0) {
                            z = 0;
                        }
                        if (x > 255) {
                            x = 255;
                        }
                        if (y > 255) {
                            y = 255;
                        }
                        if (z > 255) {
                            z = 255;
                        }


                    }

                        Color newColor = new Color((int)x,(int)y,(int)z);
                    image.setRGB(j,i,newColor.getRGB());

                }
            }


            File ouptut = new File("grey.jpg");
            ImageIO.write(image, "jpg", ouptut);



        }catch(Exception e){}
    }






}

