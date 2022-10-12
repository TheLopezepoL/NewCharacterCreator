package ADT.Controller;

import ADT.Weapon.CreateWeapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JDialog{
    private JButton createWeaponButton;
    private JButton createCharacterButton;
    private JButton playButton;
    private JPanel menuPanel;

    public Menu(JFrame parent){
        super(parent);
        setTitle("Menu");
        setContentPane(menuPanel);
        setMinimumSize(new Dimension(480,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        createWeaponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateWeapon createWeapon = new CreateWeapon(null);
            }


        });
        setVisible(true);
    }
}
