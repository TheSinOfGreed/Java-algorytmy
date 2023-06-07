package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class algorytmy extends JPanel {

    BufferedImage image;
    BufferedImage image2;
    int width;
    int height;
    static int wybor;



    public algorytmy(int wybor,String obraz1,String obraz2) {
        try{

            File input = new File(obraz1);
            File input2 = new File(obraz2);
            image = ImageIO.read(input);
            image2 = ImageIO.read(input2);
            width = image.getWidth();
            height= image.getHeight();

            for(int i =0;i<height;i++){
                for(int j=0;j<width;j++){

                    Color c = new Color(image.getRGB(j,i));
                    double red = (c.getRed());
                    double green = (c.getGreen());
                    double blue = (c.getBlue());
                    double x,y,z;
                    x=0;
                    y=0;
                    z=0;
                    Color c2 = new Color(image2.getRGB(j,i));
                    double red2 = (c2.getRed());
                    double green2 = (c2.getGreen());
                    double blue2 = (c2.getBlue());


                    if ( i>0 && i<height && j>0 && j<width ){

                        if(wybor==1){
                            x = (red/255 + red2/255)*255.0;
                            y= (green/255 + green2/255)*255.0;
                            z=(blue/255 + blue2/255)*255.0;
                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==2){
                            x = (red/255 + red2/255-1)*255.0;
                            y= (green/255 + green2/255-1)*255.0;
                            z=(blue/255 + blue2/255-1)*255.0;
                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==3){
                            x = (red/255 - red2/255)*255.0;
                            y= (green/255 - green2/255)*255.0;
                            z=(blue/255 - blue2/255)*255.0;
                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = x*-1;}
                            if (y<0) {y = y*-1;}
                            if (z<0) {z = z*-1;}

                        }
                        if(wybor==4){
                            x = (red/255 * red2/255)*255.0;
                            y= (green/255 * green2/255)*255.0;
                            z=(blue/255 * blue2/255)*255.0;
                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}

                        }
                        if(wybor==5){
                            x = (1-(1-red/255)*(1-red2/255))*255;
                            y= (1-(1-green/255)*(1-green2/255))*255;
                            z=(1-(1-blue/255)*(1-blue2/255))*255;
                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}

                        }
                        if(wybor==6){
                            x = 1-red/255 - red2/255;
                            y= 1-green/255 - green2/255;
                            z=  1-blue/255 - blue2/255;
                            if (x<0) {x = x*-1;}
                            if (y<0) {y = y*-1;}
                            if (z<0) {z = z*-1;}
                            x = (1 -x)*255;
                            y= (1 -y)*255;
                            z=  (1 -z)*255;


                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                        }
                        if(wybor==7){

                            if(red <red2){x=red;}
                            else{x=red2;}
                            if(green <green2){y=green;}
                            else{y=green2;}
                            if(blue <blue2){z=blue;}
                            else{z=blue2;}
                        }
                        if(wybor==8){

                            if(red >red2){x=red;}
                            else{x=red2;}
                            if(green >green2){y=green;}
                            else{y=green2;}
                            if(blue >blue2){z=blue;}
                            else{z=blue2;}
                        }
                        if(wybor==9){

                            x=(red/255 +red2/255 - 2* red/255 * red2/255)*255;
                            y=(green/255 +green2/255 - 2* green/255 * green2/255)*255;
                            z=(blue/255 +blue2/255 - 2* blue/255 * blue2/255)*255;


                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==10){

                            if(red/255<0.5){x=(2*red/255*red2/255)*255;}
                            else{x= (1-2*(1-red/255)*(1-red2/255))*255;}

                            if(green/255<0.5){y=(2*green/255*green2/255)*255;}
                            else{y= (1-2*(1-green/255)*(1-green2/255))*255;}

                            if(blue/255<0.5){z=(2*blue/255*blue2/255)*255;}
                            else{z= (1-2*(1-blue/255)*(1-blue2/255))*255;}

                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==11){

                            if(red2/255<0.5){x=(2*red/255*red2/255)*255;}
                            else{x= (1-2*(1-red/255)*(1-red2/255))*255;}

                            if(green2/255<0.5){y=(2*green/255*green2/255)*255;}
                            else{y= (1-2*(1-green/255)*(1-green2/255))*255;}

                            if(blue2/255<0.5){z=(2*blue/255*blue2/255)*255;}
                            else{z= (1-2*(1-blue/255)*(1-blue2/255))*255;}

                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==12){

                            if(red2/255<0.5){x=(2*red/255*red2/255+Math.pow(red/255,2)*(1-2*red2/255))*255;}
                            else{x= (Math.sqrt(red/255)*(2*red2/255-1)+(2*red/255)*(1-red2/255))*255;}

                            if(green2/255<0.5){y=(2*green/255*green2/255+Math.pow(green/255,2)*(1-2*green2/255))*255;}
                            else{y= (Math.sqrt(green/255)*(2*green2/255-1)+(2*green/255)*(1-green2/255))*255;}

                            if(blue2/255<0.5){z=(2*blue/255*blue2/255+Math.pow(blue/255,2)*(1-2*blue2/255))*255;}
                            else{z= (Math.sqrt(blue/255)*(2*blue2/255-1)+(2*blue/255)*(1-blue2/255))*255;}

                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==13){

                            x=((red/255)/(1-red2/255))*255;
                            y=((green/255)/(1-green2/255))*255;
                            z=((blue/255)/(1-blue2/255))*255;

                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==14){

                            x=(1-(1-red/255)/(red2/255))*255;
                            y=(1-(1-green/255)/(green2/255))*255;
                            z=(1-(1-blue/255)/(blue2/255))*255;

                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
                        if(wybor==15){

                            x=(Math.pow(red/255,2)/(1-red2/255))*255;
                            y=(Math.pow(green/255,2)/(1-green2/255))*255;
                            z=(Math.pow(blue/255,2)/(1-blue2/255))*255;

                            if(x>255){x=255;}
                            if(y>255){y=255;}
                            if(z>255){z=255;}
                            if (x<0) {x = 0;}
                            if (y<0) {y = 0;}
                            if (z<0) {z = 0;}
                        }
//                        if(wybor==16){
//
//
//
//                            x=((1-alfa)*red2/255 + alfa *red/255)*255;
//                            y=((1-alfa)*green2/255 + alfa *green/255)*255;
//                            z=((1-alfa)*blue2/255 + alfa *blue/255)*255;
//
//                            if(x>255){x=255;}
//                            if(y>255){y=255;}
//                            if(z>255){z=255;}
//                            if (x<0) {x = 0;}
//                            if (y<0) {y = 0;}
//                            if (z<0) {z = 0;}
//                        }

                    }
                    else{
                        x=red;
                        y=green;
                        z=blue;
                    }
                    Color newColor = new Color((int)x,(int)y,(int)z);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("grey.jpg");
            ImageIO.write(image, "jpg", ouptut);


        }catch(Exception e){}


    }
    public algorytmy(int wybor,String obraz1,String obraz2,double alfa){
        try{

            File input = new File(obraz1);
            File input2 = new File(obraz2);
            image = ImageIO.read(input);
            image2 = ImageIO.read(input2);
            width = image.getWidth();
            height= image.getHeight();

            for(int i =0;i<height;i++){
                for(int j=0;j<width;j++){

                    Color c = new Color(image.getRGB(j,i));
                    double red = (c.getRed());
                    double green = (c.getGreen());
                    double blue = (c.getBlue());
                    double x,y,z;
                    x=0;
                    y=0;
                    z=0;
                    Color c2 = new Color(image2.getRGB(j,i));
                    double red2 = (c2.getRed());
                    double green2 = (c2.getGreen());
                    double blue2 = (c2.getBlue());


                    if ( i>0 && i<height && j>0 && j<width ){

        if(wybor==16){



            x=((1-alfa)*red2/255 + alfa *red/255)*255;
            y=((1-alfa)*green2/255 + alfa *green/255)*255;
            z=((1-alfa)*blue2/255 + alfa *blue/255)*255;

            if(x>255){x=255;}
            if(y>255){y=255;}
            if(z>255){z=255;}
            if (x<0) {x = 0;}
            if (y<0) {y = 0;}
            if (z<0) {z = 0;}
        }

    }else{
        x=red;
        y=green;
        z=blue;
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
