package ADT.Characters;

import javax.swing.*;
import ADT.Controller.MainController;
import ADT.Enums.EnumCharacters;
import ADT.Weapon.aWeapon;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CloneCharacter extends JDialog {
    private JComboBox comboBoxPersonajes;
    private JSpinner spinnerCantidadClon;
    private JButton cancelarButton;
    private JButton clonarButton;

    private JPanel cloneCharacterPanel;

    public CloneCharacter(JFrame parent){
        super(parent);
        setTitle("Clone character");
        setContentPane(cloneCharacterPanel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);

        for (Character item : MainController.controlador.getBaseCharacters()) {
            comboBoxPersonajes.addItem(item.nombre);
        }

        clonarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String nombrePersonajeClonado = comboBoxPersonajes.getSelectedItem().toString();
            int cantidadClones = (Integer) spinnerCantidadClon.getValue();
            Character personajeAClonar = MainController.controlador.getCharacterByNombre(nombrePersonajeClonado);

            for(int i = 1; i <= cantidadClones; i++){
                Character clonPersonaje = personajeAClonar.deepClone();
                MainController.controlador.getGeneratedCharacters().add(clonPersonaje);
                }
            //ArrayList<Character> hola = MainController.controlador.getGeneratedCharacters();
            JOptionPane.showMessageDialog(null, "Success");
            dispose();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}
