package model;

import view.Affichage;

public class Etat {
    private int hauteur =200;//l'ordonnee de l'oval
    /** construiteur de model.Etat */
    public Etat(){
        this.hauteur=hauteur;
    }
    /** un methode pour obtenir l'ordonne de l'oval */
    public int getHauteur(){
        return  this.hauteur=hauteur;
    }
    /** un methode pour changer l'ordonne del'oval */
    public void jump(){
        if(this.hauteur<Affichage.HAUT){
            this.hauteur=hauteur-20;

        }else{
            this.hauteur=hauteur;
        }
    }

    public void moveDown(){

        if(this.hauteur<Affichage.HAUT+400){

            this.hauteur=hauteur+20;
        }else{
            this.hauteur=hauteur;
        }
    }

}
