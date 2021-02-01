package view;

import model.Etat;
import model.Parcours;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;


public class Affichage extends JPanel {
    public static final int LARG = 600;//c'est le longeur de l'ecran du jeu
    public static final int HAUT = 400;//c'est le hauteur de l'ecran du jeu
    public static final int widht = 50;//c'est le longeur de l'oval
    public static final int height = 80;//c'est le hauteur de l'oval
    public static final int OvalX=200;
    //c'est un ecart pour deplacer l'oval de chaque clic.
    Etat etat;//creer un objet etat
    Parcours parcours;
    Oiseau oiseau;
   int n=0;
    /** construiteur pour obtenir meme model.Etat */
    public Affichage(Etat etat,Parcours parcours,Oiseau oiseau) {
        setPreferredSize(new Dimension(LARG, HAUT));
      this.etat=etat;
      this.parcours=parcours;
      this.oiseau=oiseau;
    }
    /** affichage */
    public void paint(Graphics g){
            super.paint(g);
            Stroke s=new BasicStroke(10,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(s);
            g.drawOval(OvalX,etat.getHauteur(),widht,height);
            ArrayList<Point> L = this.parcours.getParcours();
            for (int i = 0; i < L.size() - 1; i++) {
                Line2D line = new Line2D.Double(L.get(i).x, L.get(i).y, L.get(i + 1).x, L.get(i + 1).y);
                g2.draw(line);
                g.drawString("Score"+parcours.getter(),20,20);
            }
            g.drawImage(oiseau.img,oiseau.x,oiseau.y,oiseau.w/3,oiseau.h/3,null);


    }

    /**
     * qui renvoie vrai si l’ovale est sorti de la ligne brisée.
     * ici, on a besoin verifier si les coordonnées du cercle sont entre deux points
     * on definit y pour verifier si y est dans le cercle, le methode est (y-y2)/(y1-y2)=(x-x2)/(x1-x2);
     * @return
     */
    public boolean testperdu(){
        int x1 = 0,y1 = 0;
        int x2 = 0,y2=0;
        int y3;
        ArrayList<Point> L = this.parcours.getParcours();
        for(int i=0;i<L.size()-1;i++) {
            if (OvalX + widht / 2 >= L.get(i).x && OvalX + widht / 2 <= L.get(i + 1).x) {
                x1 = L.get(i).x;
                y1 = L.get(i).y;
                x2 = L.get(i + 1).x;
                y2 = L.get(i + 1).y;
            }
        }
        y3=((OvalX+widht/2-x1)*(y2-y1))/(x2-x1)+y1;
        if(y3>etat.getHauteur()&&y3<etat.getHauteur()+height){
            return false;
        }else{
            return true;
        }

    }
}
