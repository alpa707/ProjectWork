package kz.abzal.Frames;

import kz.abzal.UIElements.ImagePanel;
import kz.abzal.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FLogin extends JFrame{
    private final Controller control;

    public FLogin(Controller control) {
        this.control = control; //getting control from superclass
    }

    public void start() {
        //changing background image
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(FLogin.class.getResource("/resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //setting title and background
        setTitle("Qazyna Bank");
        setContentPane(new ImagePanel(myImage));


        //making label: Qazyna Bank
        JLabel label_bank = new JLabel("Qazyna Bank");
        label_bank.setBounds(282,160,236,40);
        label_bank.setFont(new Font("Verdana",Font.BOLD,32));
        add(label_bank);

        //making login text
        JLabel label_login = new JLabel("Login or IIN:");
        label_login.setBounds(353,200,94,40);
        label_login.setFont(new Font("Verdana",Font.PLAIN,14));
        add(label_login);

        //making field for login
        JTextField login = new JTextField();
        login.setBounds(340,230,120,30);
        add(login);

        //making password text
        JLabel label_pass = new JLabel("Password:");
        label_pass.setBounds(363,260,74,40);
        label_pass.setFont(new Font("Verdana",Font.PLAIN,14));
        add(label_pass);

        //making password field
        JPasswordField pass = new JPasswordField();
        pass.setEchoChar('*');
        pass.setBounds(340,290,120,30);
        add(pass);

        //making entering button
        JButton b=new JButton("Enter");
        b.setBounds(360,330,80, 30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//listener of this button
                if (control.checkPass(login.getText(),String.valueOf(pass.getPassword()))){
                    FProfile profile = new FProfile(control.getRepo().getUser().getId(), control);
                    profile.start();//changing JFrame process
                    setVisible(false);
                }else{
                    b.setText("Wrong!");
                }
            }
        });
        add(b);

        //some jframe properties
        setSize(800,640);
        setLayout(null);
        setVisible(true);
    }
}
