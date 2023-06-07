package test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GrayScale extends JPanel {

    BufferedImage  image;
    static int width;
    static int height;
    static int wybor;
    double gamma =0.33;
    String nazwa;
    double wartosc;
    public GrayScale(int wybor, String nazwa, double wartosc) {

        try {
            this.wybor = wybor;
            File input = new File(nazwa);
            image = ImageIO.read(input);
            width = image.getWidth();
            height= image.getHeight();

            for(int i =0;i<height;i++){
                for(int j=0;j<width;j++){

                    Color c = new Color(image.getRGB(j,i));
                    double red =(double) (c.getRed());
                    double green = (double)(c.getGreen());
                    double blue = (double)(c.getBlue());

                    double x,y,z;
                    x=0;
                    y=0;
                    z=0;



                        if(wybor==1) {
                            //zaciemnienie
                            x = red - wartosc;
                            y = green - wartosc;
                            z = blue - wartosc;
                            if (x < 0) {
                                x = 0;
                            }
                            if (y < 0) {
                                y = 0;
                            }
                            if (z < 0) {
                                z = 0;
                            }
                        }
                        if(wybor==2){
                            //rozjasnienie
                        x = red +wartosc;
                        y= green+wartosc;
                        z= blue+wartosc;
                        if(x>255){x=255;}
                        if(y>255){y=255;}
                        if(z>255){z=255;}
                        }
                        if(wybor==3){
                            //natyw
                        x = 255-red;
                        y=  255-green;
                        z=  255-blue;
                        }
                        if(wybor==4){
                            //gamma


                            if(Math.pow(red/255,wartosc) >=0 && Math.pow(red/255,wartosc) <=255){

                            x = Math.pow(red/255,wartosc)*255;}
                            else{
                                x=red;
                            }

                            if(Math.pow(green/255,wartosc) >=0 && Math.pow(green/255,wartosc) <=255){
                            y=Math.pow(green/255,wartosc)*255;}
                            else{
                                y=green;
                            }
                            if(Math.pow(blue/255,wartosc) >=0 && Math.pow(blue/255,wartosc) <=255){
                            z=Math.pow(blue/255,wartosc)*255;}
                            else{
                                z=blue;
                            }
                        }




                    Color newColor = new Color((int)x,(int)y,(int)z);
                    image.setRGB(j,i,newColor.getRGB());

                }
            }


            Dimension dimension = new Dimension(width, height);
            setPreferredSize(dimension);



        }catch(Exception e){}
    }





    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }
}
