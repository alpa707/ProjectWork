package kz.abzal.Frames;

import kz.abzal.Controller;
import kz.abzal.Entities.User;
import kz.abzal.UIElements.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FTransfer extends JFrame{
    private User user;
    private final Controller control;

    public FTransfer(User user, Controller control) {
        this.control = control;
        this.user = user;
    }

    public void start() {
        //changing background
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(FLogin.class.getResource("/resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //some jframe properties
        setTitle("Transfer");
        setContentPane(new ImagePanel(myImage));
        setSize(300,300);
        setLayout(null);
        setVisible(true);

        //Recipient label
        JLabel label = new JLabel("Recipient ID: ");
        label.setBounds(40,40,120,40);
        label.setFont(new Font("Verdana",Font.BOLD,14));
        add(label);

        //field for id
        JTextField id = new JTextField();
        id.setBounds(160,45,90,30);
        add(id);

        //label for money amount
        JLabel label2 = new JLabel("Enter amount: ");
        label2.setBounds(40,110,120,40);
        label2.setFont(new Font("Verdana",Font.BOLD,14));
        add(label2);

        //field for money
        JTextField summ = new JTextField();
        summ.setBounds(160,115,90,30);
        add(summ);

        //transfer button
        JButton b = new JButton("Transfer!");
        b.setBounds(90,185,120,60);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(user.getBalance() >= Integer.parseInt(summ.getText())){
                        user.setBalance(user.getBalance()-Integer.parseInt(summ.getText()));
                        control.addToId(Integer.parseInt(id.getText()),Integer.parseInt(summ.getText()));
                        control.subToId(user.getId(),Integer.parseInt(summ.getText()));
                        FProfile profile = new FProfile(user.getId(), control);
                        profile.start();//change jframe
                        setVisible(false);
                    }
                }catch(Exception throwables){
                    System.out.println("PLEASE, ENTER NUMBERS, NOT CHAR!");
                }

            }
        });
        add(b);

    }
}
