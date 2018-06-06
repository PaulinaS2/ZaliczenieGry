package kolkoikrzyzyk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ElementsListener implements ActionListener{
    private Element[][] elemenst;
    private int[][] ints;
    JPanel plansza;
    public ElementsListener(Element[][] el, int[][] w, JPanel p){
        this.elemenst=el;
        this.ints=w;
        this.plansza=p;
    }

    private boolean sprawdz(int a, boolean t){
        if(a == 1){
            if(ints[0][0] == 1 && ints[0][1] == 1 && ints[0][2] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }

            if(ints[1][0] == 1 && ints[1][1] == 1 && ints[1][2] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }

            if(ints[2][0] == 1 && ints[2][1] == 1 && ints[2][2] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }
        }
        if(a == 2){
            if(ints[0][0] == 1 && ints[1][0] == 1 && ints[2][0] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }

            if(ints[0][1] == 1 && ints[1][1] == 1 && ints[2][1] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }

            if(ints[0][2] == 1 && ints[1][2] == 1 && ints[2][2] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }

            if(ints[0][0] == 1 && ints[1][1] == 1 && ints[2][2] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }

            if(ints[0][2] == 1 && ints[1][1] == 1 && ints[2][0] == 1){
                if(t) JOptionPane.showMessageDialog(null, "Wygrales!!");
                return true;
            }

            if(ints[0][2] == 2 && ints[1][1] == 2 && ints[2][0] == 2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }

            if(ints[0][0] == 2 && ints[0][1] == 2 && ints[0][2] == 2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }

            if(ints[1][0] == 2 && ints[1][1] == 2 && ints[1][2] == 2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }

            if(ints[2][0] == 2 && ints[2][1] == 2 && ints[2][2] == 2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }

            if(ints[0][0] == 2 && ints[1][0] == 2 && ints[2][0]==2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }

            if(ints[0][1] == 2 && ints[1][1] == 2 && ints[2][1] == 2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }

            if(ints[0][2] == 2 && ints[1][2] == 2 && ints[2][2] == 2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }

            if(ints[0][0] == 2 && ints[1][1] == 2 && ints[2][2] == 2){
                if(t) JOptionPane.showMessageDialog(null, "Wygral komputer!!");
                return true;
            }
        }
        return false;
    }

    public Pozycja checkMove(int x, int y, int dx, int dy, int coSpradzic){
        int ileZajetychPol = 0;
        Pozycja pustePole = null;
        for (int i = 0; i < 3; i++) {
            if(ints[x][y] == coSpradzic){
                ileZajetychPol ++;
            }else if(ints[x][y] == 0){
                pustePole = new Pozycja(x,y);
            }
            x += dx;
            y += dy;
        }

        if (ileZajetychPol == 2 && pustePole != null){
            return pustePole;
        }

        return null;
    }

    public boolean ruch(){
        int[][] check = {
                {0,0,1,0},
                {0,1,1,0},
                {0,2,1,0},
                {0,0,0,1},
                {1,0,0,1},
                {2,0,0,1},
                {0,0,1,1},
                {0,2,1,-1}
        };

        for (int j = 2; j > 1; j--) {
            for (int i = 0; i < check.length; i++) {
                int[] rzad = check[i];
                Pozycja p = checkMove(rzad[0], rzad[1], rzad[2], rzad[3], j);
                if (p != null) {
                    ints[p.x][p.y] = 2;
                    elemenst[p.x][p.y].stan = 2;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Element source = (Element) e.getSource();
        int x = 0, y = 0;
        boolean koniec = false;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (elemenst[i][j] == source) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        if(elemenst[x][y].stan == 0) {
            elemenst[x][y].stan = 1;
            ints[x][y] = 1;
            koniec = sprawdz(1, true);


            if (koniec) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        elemenst[i][j].stan = 0;
                        ints[i][j] = 0;
                    }
                }
                plansza.repaint();
            }
        }else{
           return;
        }

        boolean zrobionyRuch = ruch();

        if(zrobionyRuch == false) {
            Random rn = new Random();
            int rn1 = 0, rn2 = 0;
            int time = 0;
            if (koniec == false) {
                while (true) {
                    time++;
                    rn1 = rn.nextInt(3);
                    rn2 = rn.nextInt(3);
                    if (time > 70) {
                        koniec = true;
                        break;
                    }
                    if (elemenst[rn1][rn2].stan == 0) {
                        elemenst[rn1][rn2].stan = 2;
                        ints[rn1][rn2] = 2;
                        break;
                    }

                }
            }
        }

        plansza.repaint();
        koniec=sprawdz(2, true);
        boolean end=true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ints[i][j] == 0) end = false;
            }
        }
        if(sprawdz(1, false) == false && sprawdz(2, false) == false && end == true){
            JOptionPane.showMessageDialog(null, "Remis!");
            koniec=true;
        }
        if(koniec){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    elemenst[i][j].stan=0;
                    ints[i][j]=0;
                }
            }
            plansza.repaint();
            koniec=false;
        }
    }
}

class Pozycja{
    public int x, y;
    public Pozycja(int x, int y){
        this.x = x;
        this.y = y;
    }
}