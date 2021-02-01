package control;

import model.Parcours;
import view.Affichage;

import javax.swing.*;

public class Avancer implements Runnable{
    Parcours parcours;
    Affichage affichage;

    /**
     * Constructeur
     * @param parcours
     * @param affichage
     */
    public Avancer(Parcours parcours, Affichage affichage){
        this.parcours=parcours;
        this.affichage=affichage;
    }

    /**
     * pour avancer ligne
     */
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
                parcours.setter();
                affichage.revalidate();
                affichage.repaint();
                if(affichage.testperdu()){
                    break;
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null,"Score:"+ parcours.getter());
    }
}
