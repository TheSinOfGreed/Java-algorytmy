package test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GrayScale extends JPanel {

    BufferedImage  image;
    static int width;
    static int height;
    String nazwa;

    public GrayScale(String nazwa , int wybor) {
        try {

            File input = new File(nazwa);
            image = ImageIO.read(input);
            width = image.getWidth();
            height= image.getHeight();

            double[][] M_Gauss ;


            for(int i =1;i<height-1;i++){
                for(int j=1;j<width-1;j++){

                    double x,y,z;
                    x=0;
                    y=0;
                    z=0;

                    if(wybor ==1){
                        M_Gauss= new double[][] { {0,0,0}, {0,1,-1}, {0,0,0}};
                        double suma=1;
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
                    if(wybor ==2){
                        M_Gauss= new double[][] { {1,1,1}, {0,0,0}, {-1,-1,-1}};
                        double suma=1;
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
                    if(wybor ==3){
                        M_Gauss= new double[][] { {1,2,1}, {0,0,0}, {-1,-2,-1}};
                        double suma=1;
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
                    if(wybor ==4){
                        M_Gauss= new double[][] { {0,0,0}, {0,1,0}, {0,-1,0}};
                        double suma=1;
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
                    if(wybor ==5){
                        M_Gauss= new double[][] { {1,0,-1}, {1,0,-1}, {1,0,-1}};
                        double suma=1;
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
                    if(wybor ==6){
                        M_Gauss= new double[][] { {1,0,-1}, {2,0,-2}, {1,0,-1}};
                        double suma=1;
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
                    if(wybor ==7){
                        M_Gauss= new double[][] { {0,-1,0}, {-1,4,-1}, {0,-1,0}};
                        double suma=1;
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
                    if(wybor ==8){
                        LinkedList<Integer> r = new LinkedList();
                        LinkedList<Integer> g = new LinkedList();
                        LinkedList<Integer> b = new LinkedList();

                        for (int l = j-1; l <j+ 1; l++){
                             for(int k = i-1; k < i+1; k++){

                                Color c = new Color(image.getRGB(j,i));
                                r.add(c.getRed());
                                 g.add(c.getGreen());
                                 b.add(c.getBlue());


                            }
                        }
                        Collections.sort(r);
                        Collections.sort(g);
                        Collections.sort(b);
                        x = r.getFirst();
                        y = g.getFirst();
                        z = b.getFirst();

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

