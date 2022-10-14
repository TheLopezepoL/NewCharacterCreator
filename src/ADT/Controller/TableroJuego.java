package ADT.Controller;

import ADT.Characters.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableroJuego extends JDialog {
    private JFrame window = new JFrame();
    private JPanel panelInfo = new JPanel();
    private JPanel panelTablero = new JPanel();
    private JTextArea consola;
    private JLabel vida;

    private JButton[][] botonesTablero;

    public TableroJuego(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        panelInfo = new JPanel();
        panelInfo.setLayout( new BorderLayout() );
        // Add some buttons
        consola = new JTextArea( "North" );
        panelInfo.add( consola);


        panelTablero.setBackground(Color.BLUE);
        panelInfo.setBackground(Color.GREEN);
        panelTablero.setLayout(new GridLayout(4, 4));

        Character[][] tablero = MainController.controlador.getTablero();
        botonesTablero = new JButton[tablero.length][tablero[0].length];

        window.setSize(600,500);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
                                consola.append("\nMain");
                                MainController.turnoMain = false;
                                window.invalidate();
                                window.validate();
                                window.repaint();
                            }
                        });
                    }

                    else if(MainController.controlador.getEnemigos().contains(personaje)){
                        botonesTablero[r][c].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("Enemy");
                                consola.append("\nEnemy");
                                MainController.turnoMain = false;
                                window.invalidate();
                                window.validate();
                                window.repaint();
                            }
                        });                    }
                }
                else {
                    botonesTablero[r][c].setForeground(Color.WHITE);
                }
                //botonesTablero[r][c].addActionListener(new TileListener());
                panelTablero.add(botonesTablero[r][c]);
            }
        }
        JSplitPane splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneH.setLeftComponent( panelTablero );
        splitPaneH.setRightComponent( panelInfo );
        window.add(splitPaneH);
        window.setVisible(true);
    }
}
