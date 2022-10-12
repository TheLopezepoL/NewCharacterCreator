package ADT.Weapon;

import ADT.Controller.MainController;
import ADT.Enums.EnumWeapons;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateWeapon extends JDialog{
    private JTextField txtName;
    private JSpinner spAlcance;
    private JSpinner spDanho;
    private JSpinner spRadio;
    private JSpinner spVelocidad;
    private JButton createButton;
    private JButton cancelButton;
    private JComboBox cbTipo;
    private JPanel createWeaponPanel;

    public CreateWeapon(JFrame parent){
        super(parent);
        setTitle("Create Weapon");
        setContentPane(createWeaponPanel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);

        cbTipo.setModel(new DefaultComboBoxModel<>(EnumWeapons.values()));
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                int alcance = (Integer) spAlcance.getValue();
                int danho = (Integer) spDanho.getValue();
                int velocidad = (Integer) spVelocidad.getValue();
                int radio = (Integer) spRadio.getValue();
                EnumWeapons tipo = (EnumWeapons) cbTipo.getSelectedItem();

                aWeapon arma = MainController.controlador.createBaseWeapon(name,alcance,danho,radio,velocidad,1,tipo);
                if (arma != null){
                    MainController.controlador.getBaseWeapons().add(arma);
                    JOptionPane.showMessageDialog(null, "Success");
                    MainController.controlador.printArmas();
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
