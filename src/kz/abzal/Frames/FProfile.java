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

public class FProfile extends JFrame{
    private User user;
    private final Controller control;

    public FProfile(int id, Controller control) {
        //getting control and user from previous class
        this.control = control;
        user = control.getUserById(id);
    }

    public void start() {
        //setting image
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(FLogin.class.getResource("/resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //some jframe properties
        setTitle("Qazyna Bank Profile");
        setContentPane(new ImagePanel(myImage));
        setSize(800,320);
        setLayout(null);
        setVisible(true);

        //making name label
        JLabel label_name = new JLabel("Owner: " + user.getFull_name());
        label_name.setBounds(150,40,750,40);
        label_name.setFont(new Font("Verdana",Font.BOLD,26));
        add(label_name);


        //making balance text
        JLabel label_balance = new JLabel("Balance: " + user.getBalance() + " tg");
        label_balance.setBounds(50,100,750,40);
        label_balance.setFont(new Font("Verdana",Font.PLAIN,20));

        //money transfer button
        add(label_balance);
        JButton b=new JButton("Money transfer");
        b.setBounds(600,105,150, 30);
        BufferedImage finalMyImage = myImage;
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FTransfer trans = new FTransfer(user,control);
                trans.start();//changing jframe
                setVisible(false);
            }
        });
        add(b);

        //making deposit label
        JLabel label_deposit = new JLabel("Deposit: " + user.getDeposit_balance() + " tg" + " ( after 12 months: " + Math.round(user.getDeposit_balance()*1.15) + " tg)");
        label_deposit.setBounds(50,150,750,40);
        label_deposit.setFont(new Font("Verdana",Font.PLAIN,20));
        add(label_deposit);


        //making credit label
        JLabel label_credit = new JLabel("Loan balance: " + user.getCredit_balance() + " tg");
        label_credit.setBounds(50,200,750,40);
        label_credit.setFont(new Font("Verdana",Font.PLAIN,20));
        add(label_credit);

        //paying off label
        JButton b2=new JButton("Pay off early");
        b2.setBounds(600,205,150, 30);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user.getBalance() >= user.getCredit_balance() && user.getCredit_balance()>= 0){
                    control.subToId(user.getId(),user.getCredit_balance());
                    control.resetCredit(user.getId());
                    FProfile profile = new FProfile(user.getId(), control);
                    profile.start();//chaging jframe to previous
                    setVisible(false);
                }
            }
        });
        add(b2);


    }


}
