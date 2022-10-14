package ADT.Controller;

import ADT.Characters.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JDialog {
    private JPanel Panel;

    private JButton[][] botonesTablero;

    public Tablero(JFrame parent){
        super(parent);
        setTitle("Create Character");

        Panel.setLayout(new GridLayout(4, 4));
        Panel.setPreferredSize(new Dimension(400, 400));

        setContentPane(Panel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);

        Character[][] tablero = MainController.controlador.getTablero();
        botonesTablero = new JButton[tablero.length][tablero[0].length];

        for(int r = 0; r < tablero.length; r++)
        {
            for(int c = 0; c < tablero[0].length; c++)
            {
                Character personaje = tablero[r][c];
                botonesTablero[r][c] = new JButton("O");
                if (tablero[r][c] != null){
                    Image newimg = personaje.getImagen().getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
                    botonesTablero[r][c].setIcon(new ImageIcon(newimg));
                    //Es Main Character?
                    if(personaje == MainController.controlador.getMainCharacter()){
                        botonesTablero[r][c].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("Main");
                            }
                            });
                    }

                    else if(MainController.controlador.getEnemigos().contains(personaje)){
                        botonesTablero[r][c].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("Enemy");
                            }
                        });                    }
                }
                else {
                    botonesTablero[r][c].setForeground(Color.WHITE);
                }
                //botonesTablero[r][c].addActionListener(new TileListener());
                Panel.add(botonesTablero[r][c]);
            }
        }
        setVisible(true);
    }
}
