package control;

import model.Etat;
import view.Affichage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/** ici, on ajoute l'evenement de clic par souris, et chaque fois que l'on clic le souris, il dois renouveler l'ecran,
 * donc on dois heriter JPanel pour utiliser la fonction reepaint()*/
public class Control extends JPanel implements MouseListener {
    Etat etat;
    Affichage affichage;
    /** construiteur
     *@param etat  Synchroniser qu"un seul etat
     * @param affichage  Synchroniser qu"un seul etat*/
    public Control(Etat etat, Affichage affichage){
        this.etat=etat;
        this.affichage=affichage;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(!affichage.testperdu()) {
            etat.jump();
            affichage.repaint();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
