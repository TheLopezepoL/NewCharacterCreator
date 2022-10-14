package ADT.Characters;

import ADT.Controller.MainController;
import ADT.Controller.Tablero;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterSelection extends JDialog{

    private JPanel CharacterSelectionPanel;
    private JComboBox comboBoxProtagonista;
    private JComboBox comboBoxEnemigo;
    private JButton jugarButton;
    private JButton cancelarButton;
    private JComboBox comboBoxCantEnemigos;
    private JSpinner spinnerCantEnemigos;

    public CharacterSelection(JFrame parent){
        super(parent);
        setTitle("Character Selection");
        setContentPane(CharacterSelectionPanel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);



        for (Character item : MainController.controlador.getBaseCharacters()) {
            comboBoxProtagonista.addItem(item.nombre);
            comboBoxEnemigo.addItem(item.nombre);
        }

        for(int i = 1;i<=3;i++){
            comboBoxCantEnemigos.addItem(Integer.toString(i));
        }


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreProtagonista = comboBoxProtagonista.getSelectedItem().toString();
                String nombreEnemigos = comboBoxEnemigo.getSelectedItem().toString();
                int cantidadEnemigos = Integer.valueOf((String) comboBoxCantEnemigos.getSelectedItem());
                Character protagonista = MainController.controlador.getCharacterByNombre(nombreProtagonista);
                Character enemigo = MainController.controlador.getCharacterByNombre(nombreEnemigos);

                //MAIN CARACTER
                MainController.controlador.setMainCharacter(protagonista);
                MainController.controlador.addToTablero(protagonista);
                //ENEMIGOS
                int x = 3;
                int y = 3;
                for(int i = 1; i <= cantidadEnemigos; i++){
                    Character clonPersonaje = enemigo.deepClone();
                    MainController.controlador.getEnemigos().add(clonPersonaje);
                    clonPersonaje.setPos(x,y);
                    MainController.controlador.addToTablero(clonPersonaje);
                    x--;

                }


                JOptionPane.showMessageDialog(null, "Success");


                dispose();
                // llamar a crear el form de tablero
                Tablero tableroForm = new Tablero();
            }
        });



        setVisible(true);


    }

    }

