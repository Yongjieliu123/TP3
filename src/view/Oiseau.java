package view;

import java.awt.image.BufferedImage;

/**
 * creer un objet Oiseau
 */
public class Oiseau extends Thread{
    BufferedImage img;
     int w;//le largeur de l'oiseau
     int h;//le hauteur de l'oiseau
    int x;//les coordonnees de l'oiseau
    int y;// les coordonnees de l'oiseau
    private int n;//pour affiche difference de l'image de l'oiseau.

    public Oiseau(){
        img= APPImg.getImg("/img/0.png");//pour obtenir l'image de l'oiseau
        x=400;
        y=50;
        w=img.getWidth();
        h=img.getHeight();
        n=0;
    }
    @Override
    /**
     * pour l'oiseau peut deplacer de droite A gauche toujours
     */

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                n++;
                this.x-=50;
                this.img=APPImg.getImg("/img/"+n%8+".png");
                if(x==-100){
                    x=500;
                }
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
