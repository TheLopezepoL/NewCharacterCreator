package ADT.Characters;

import ADT.Controller.MainController;
import ADT.Enums.EnumCharacters;
import ADT.State;
import ADT.Weapon.aWeapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCharacter extends JDialog {
    //private JTextField nameField;
    private JSpinner spinnerVida;
    private JSpinner spinnerNivel;
    private JSpinner spinnerCampos;
    private JSpinner spinnerAparicion;
    private JSpinner spinnerCosto;
    private JComboBox comboBoxTipo;
    private JComboBox comboBoxArma;
    private JButton addButton;
    private JButton createButton;
    private JButton cancelButton;


    protected Character.BuilderCharacter builderCharacter;
    private JPanel createCharacterPanel;
    private JComboBox namesComboBox;

    public CreateCharacter(JFrame parent){
        super(parent);
        setTitle("Create Character");
        setContentPane(createCharacterPanel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);

        //armasPersonaje = new ArrayList<aWeapon>();
        builderCharacter = new Character.BuilderCharacter();

        comboBoxTipo.setModel(new DefaultComboBoxModel<>(EnumCharacters.values()));

        for (String name : MainController.controlador.personajesJSON()){
            namesComboBox.addItem(name);
        }

        for (aWeapon item : MainController.controlador.getBaseWeapons()) {
            comboBoxArma.addItem(item.nombre);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreArmaAdd = comboBoxArma.getSelectedItem().toString();
                aWeapon armaAdd = MainController.controlador.getArmaByNombre(nombreArmaAdd);
                builderCharacter.addWeapon(armaAdd);
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String nombrePersonaje = namesComboBox.getSelectedItem().toString();
                //String nombrePersonaje = nameField.getText();
                int vidaPersonaje = (Integer) spinnerVida.getValue();
                int nivelPersonaje = (Integer) spinnerNivel.getValue();
                int valorPersonaje = (Integer) spinnerCosto.getValue();
                int camposPersonaje = (Integer) spinnerCampos.getValue();
                int nivelAparicionPersonaje = (Integer) spinnerAparicion.getValue();
                EnumCharacters tipoPj = (EnumCharacters) comboBoxTipo.getSelectedItem();

                if (MainController.controlador.getCharacterByNombre(nombrePersonaje) != null){
                    JOptionPane.showMessageDialog(null, "ERROR! Ya hay un personaje generado con este nombre");
                    return;
                }



                Character nuevoCharacter = builderCharacter.setName(nombrePersonaje)
                        .setVida(vidaPersonaje)
                        .setNivel(nivelPersonaje)
                        .setCosto(valorPersonaje)
                        .setCampos(camposPersonaje)
                        .setNivelAparicion(nivelAparicionPersonaje)
                        .setEstado(State.DEFAULT)
                        .setTipo(tipoPj)
                        .setImagen()
                        .addWeapon(MainController.controlador.getArmaDefault())
                        .build();

                if (nuevoCharacter != null){
                    MainController.controlador.getBaseCharacters().add(nuevoCharacter);
                    JOptionPane.showMessageDialog(null, "Success");

                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error");
                    dispose();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}


