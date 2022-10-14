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

        window.setSize(600,500);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cargarTablero();

        JSplitPane splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneH.setLeftComponent( panelTablero );
        splitPaneH.setRightComponent( panelInfo );
        window.add(splitPaneH);
        window.setVisible(true);
    }

    public void cargarTablero(){
        panelTablero.removeAll();

        Character[][] tablero = MainController.controlador.getTablero();
        botonesTablero = new JButton[tablero.length][tablero[0].length];

        for( int r = 0; r < tablero.length; r++)
        {
            for(int c = 0; c < tablero[0].length; c++)
            {
                Character personaje = tablero[r][c];
                botonesTablero[r][c] = new JButton("O");
                if (tablero[r][c] != null) {
                    Image newimg = personaje.getImagen().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                    botonesTablero[r][c].setIcon(new ImageIcon(newimg));
                }
                else {
                    botonesTablero[r][c].setForeground(Color.WHITE);
                }
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

                            MainController.controlador.getMainCharacter().getTipo().atacar(MainController.controlador.getMainCharacter(), personaje);
                            MainController.turnoMain = false;
                            cargarTablero();
                            window.invalidate();
                            window.validate();
                            window.repaint();
                        }
                    });

                    if (personaje.getVida() <= 0){
                        botonesTablero[r][c].setEnabled(false);

                    }
                }
                else{
                    botonesTablero[r][c].putClientProperty( "x", r);
                    botonesTablero[r][c].putClientProperty( "y", c);
                    botonesTablero[r][c].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Character mainPj = MainController.controlador.getMainCharacter();
                            int oldX = mainPj.getPosX();
                            int oldY = mainPj.getPosY();
                            int newX = (Integer)(((JButton)e.getSource()).getClientProperty( "x" ));
                            int newY = (Integer)(((JButton)e.getSource()).getClientProperty( "y" ));
                            if (MainController.controlador.getMainCharacter().getTipo().moverse(mainPj,newX,newY)){
                                MainController.controlador.refreshMatriz(MainController.controlador.getMainCharacter(),oldX,oldY);
                            }

                            cargarTablero();
                            window.invalidate();
                            window.validate();
                            window.repaint();
                            MainController.turnoMain = false;

                        }
                    });
                }


                //botonesTablero[r][c].addActionListener(new TileListener());
                panelTablero.add(botonesTablero[r][c]);
            }
        }
        panelTablero.revalidate();
        panelTablero.repaint();
        return;
    }
}
