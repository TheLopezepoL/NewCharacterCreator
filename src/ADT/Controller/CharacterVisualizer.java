package ADT.Controller;

import ADT.Characters.Character;
import ADT.State;
import ADT.Weapon.aWeapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterVisualizer extends JDialog{
    private JComboBox comboBoxStates;
    private JButton updateStateButton;
    private JComboBox comboBoxWeapons;
    private JButton updateWeaponButton;
    private JLabel characterImage;
    private JComboBox comboBoxCharacters;
    private JButton updateCharacterButton;
    private JLabel weaponImage;
    private JLabel charNombreLabel;
    private JLabel charVidaLabel;
    private JLabel charNivelLabel;
    private JLabel charCamposLabel;
    private JLabel charAparicionLabel;
    private JLabel charCostoLabel;
    private JLabel weaponNombreLabel;
    private JLabel weaponAlcanceLabel;
    private JLabel weaponDanhoLabel;
    private JLabel weaponRadioLabel;
    private JLabel weaponVelocidadLabel;
    private JLabel weaponNivelLabel;
    private JLabel weaponTipoLabel;
    private JButton volverButton;
    private JPanel basePanel;
    private Character actualCharacter;

    public CharacterVisualizer(JFrame parent) {
        super(parent);
        setTitle("Character Visualizer");
        setContentPane(basePanel);
        setMinimumSize(new Dimension(600,600));
        setModal(true);
        setLocationRelativeTo(parent);

        for (Character character : MainController.controlador.getBaseCharacters()) {
            comboBoxCharacters.addItem(character.getNombre());
        }

        for (State state : State.values()) {
            comboBoxStates.addItem(state.toString());
        }

        updateStateButton.setEnabled(false);
        updateWeaponButton.setEnabled(false);

        updateCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Get Personaje
                int index = comboBoxCharacters.getSelectedIndex();
                if (index != -1) {
                    actualCharacter = MainController.controlador.getBaseCharacterByIndex(index);

                    // Cargar Informacion
                    charNombreLabel.setText(actualCharacter.getNombre());
                    charVidaLabel.setText(actualCharacter.getVida() + "");
                    charNivelLabel.setText(actualCharacter.getNivel() + "");
                    charCamposLabel.setText(actualCharacter.getCampos() + "");
                    charAparicionLabel.setText(actualCharacter.getNivelAparicion() + "");
                    charCostoLabel.setText(actualCharacter.getCosto() + "");

                    // Cargar Armas
                    comboBoxWeapons.removeAllItems();
                    for (aWeapon weapon : actualCharacter.getArmas()) {
                        comboBoxWeapons.addItem(weapon.nombre);
                    }

                    // Desbloquear botones
                    updateStateButton.setEnabled(true);
                    updateWeaponButton.setEnabled(true);
                } else
                    JOptionPane.showMessageDialog(null, "Seleccione un personaje");
            }
        });

        updateStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Get estado
                State state = State.valueOf(comboBoxStates.getSelectedItem().toString());

                // Get URL

                String url = controllerSingleton.getController().datos(actualCharacter.getNombre(), actualCharacter.getNivel(),state);
                Image image = controllerSingleton.getController().getImage(url).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

                // Set Image
                //Image image = actualCharacter.getImagen().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                characterImage.setIcon(new ImageIcon(image));
                //characterImage.setIcon((Icon) image);
            }
        });

        updateWeaponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Get arma
                int indexWeapon = comboBoxWeapons.getSelectedIndex();
                if (indexWeapon != -1) {
                    aWeapon weapon = actualCharacter.getWeaponIndex(indexWeapon);

                    // Cargar Informacion
                    weaponNombreLabel.setText(weapon.nombre);
                    weaponAlcanceLabel.setText(weapon.alcance + "");
                    weaponDanhoLabel.setText(weapon.danho + "");
                    weaponRadioLabel.setText(weapon.radioExplosion + "");
                    weaponVelocidadLabel.setText(weapon.velocidadDeAtaque + "");
                    weaponNivelLabel.setText(weapon.nivel + "");
                    weaponTipoLabel.setText(weapon.tipo);

                    // Cargar Imagen
                    String url = controllerSingleton.getController().datosArma(weapon.nombre, weapon.nivel);
                    Image image = controllerSingleton.getController().getImage(url).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

                    weaponImage.setIcon(new ImageIcon(image));
                }
            }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        setVisible(true);
    }
}
