package ADT.Controller;

import ADT.Characters.CharacterSelection;
import ADT.Characters.CloneCharacter;
import ADT.Weapon.CreateWeapon;
import ADT.Characters.CreateCharacter;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JDialog{
    private JButton createWeaponButton;
    private JButton createCharacterButton;
    private JButton playButton;
    private JPanel menuPanel;
    private JButton cloneCharacterButton;
    private JButton visualizerButton;

    public Menu(JFrame parent){
        super(parent);
        setTitle("Menu");
        setContentPane(menuPanel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        createWeaponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateWeapon createWeapon = new CreateWeapon(null);
            }


        });

        createCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateCharacter createCharacter = new CreateCharacter(null);
            }




        });

        cloneCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CloneCharacter cloneCharacter = new CloneCharacter(null);
            }




        });

        visualizerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CharacterVisualizer characterVisualizer = new CharacterVisualizer(null);
            }
        });


        playButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (MainController.controlador.getBaseCharacters().size() == 0){
                    JOptionPane.showMessageDialog(null, "Debe crear personaje antes de jugar");
                }
                else{
                    dispose();
                    CharacterSelection seleccion = new CharacterSelection(null);
                }

                }
        });

        setVisible(true);



    }
}
