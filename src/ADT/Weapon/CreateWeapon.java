package ADT.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWeapon extends JDialog{
    private JTextField textField1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JButton createButton;
    private JButton cancelButton;
    private JComboBox comboBox1;
    private JPanel createWeaponPanel;

    public CreateWeapon(JFrame parent){
        super(parent);
        setTitle("Create Weapon");
        setContentPane(createWeaponPanel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);




        setVisible(true);
    }
}
