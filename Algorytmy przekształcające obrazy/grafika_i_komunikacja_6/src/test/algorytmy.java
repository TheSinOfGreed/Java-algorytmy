package test;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class algorytmy  {

    BufferedImage image;

    int width;
    int height;

    static int[] tablicar = new int[256];
    static int[] tablicag = new int[256];
    static int[] tablicab = new int[256];



    public algorytmy(int wybor,double kontrast,String obraz) {
        try{

            File input = new File(obraz);
            image = ImageIO.read(input);
            width = image.getWidth();
            height= image.getHeight();


            for (int i = 0; i < tablicar.length; i++)
            {

                tablicar[i] = 0;
                tablicag[i] = 0;
                tablicab[i] = 0;

            }



            for(int i =0;i<height;i++){
                for(int j=0;j<width;j++){

                    Color c = new Color(image.getRGB(j,i));
                    double red = (c.getRed());
                    double green = (c.getGreen());
                    double blue = (c.getBlue());

                    double x,y,z;
                    x=1;
                    y=1;
                    z=1;

                    if(wybor==1){

                        x = (127/(127-kontrast)) * ((red) - kontrast);
                    y= (127/(127-kontrast)) * ((green) - kontrast);
                    z=   (127/(127-kontrast)) * ((blue) - kontrast);
                    if(x>255){x=255;}
                    if(y>255){y=255;}
                    if(z>255){z=255;}
                    if (x<0) {x = 0;}
                    if (y<0) {y = 0;}
                    if (z<0) {z = 0;}

                        this.tablicar[(int)red] += 1;
                        this.tablicag[(int)green] += 1;
                        this.tablicab[(int)blue] += 1;



                    }

                    if(wybor==2){

                        x = ((127+kontrast)/127)* (red- kontrast);
                        y= ((127+kontrast)/127)* (green- kontrast);
                        z=   ((127+kontrast)/127)* (blue- kontrast);
                        if(x>255){x=255;}
                        if(y>255){y=255;}
                        if(z>255){z=255;}
                        if (x<0) {x = 0;}
                        if (y<0) {y = 0;}
                        if (z<0) {z = 0;}

                        this.tablicar[(int)red] += 1;
                        this.tablicag[(int)green] += 1;
                        this.tablicab[(int)blue] += 1;

                    }





                    Color newColor = new Color((int)x,(int)y,(int)z);
                    image.setRGB(j,i,newColor.getRGB());
                }

            }

            File ouptut = new File("eren_yegar.png");
            ImageIO.write(image, "png", ouptut);


        }catch(Exception e){}





}}
