package ADT.Characters;

import ADT.Controller.MainController;

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

                MainController.controlador.setMainCharacter(protagonista);

                for(int i = 1; i <= cantidadEnemigos; i++){
                    Character clonPersonaje = enemigo.deepClone();
                    MainController.controlador.getEnemigos().add(clonPersonaje);
                }
                // llamar a crear el form de tablero

                JOptionPane.showMessageDialog(null, "Success");
                dispose();
            }
        });



        setVisible(true);


    }

    }

