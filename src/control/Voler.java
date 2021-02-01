package control;

import model.Etat;
import view.Affichage;

import java.util.Random;
public class Voler extends Thread{
        public static final Random rand = new Random();
    Etat etat;
    Affichage affichage;

    public Voler(Etat etat, Affichage affichage) {
            this.etat=etat;
            this.affichage=affichage;
        }
        @Override
        public void run() {
           while(true) {
                try {
                    etat.moveDown();
                    affichage.repaint();
                    Thread.sleep(1000);
                    if(affichage.testperdu()){
                        break;
                    }
               }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        }
