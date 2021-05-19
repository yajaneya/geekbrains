package ru.geekbrains.java1.dz.dz8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class Win extends JFrame {
    public Win() {

        setBounds(200, 100, 700, 600);
        setTitle("Овощи в ёмкость...");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JPanel[] jp = new JPanel[4];
        for (int i = 0; i < 4; i++) {
            jp[i] = new JPanel();
            this.add(jp[i]);
            jp[i].setBackground(new Color(100 + i * 40, 100 + i * 40, 100 + i * 40));
        }

        jp[0].setLayout(new BorderLayout());
        Jp0DrawPanel jp0DP = new Jp0DrawPanel();
        jp[0].add(jp0DP,BorderLayout.CENTER);

        jp[1].setLayout(new FlowLayout());
        JRadioButton[] jrb = new JRadioButton[4];
        ButtonGroup bgr = new ButtonGroup();
        ButtonGroup bgr2 = new ButtonGroup();
        ButtonGroup bgr3 = new ButtonGroup();
        String[] textButton = {"Кружка", "Банка", "Пустая", "Заполненная"};
        String[] textChekBox = {"Огурец", "Томат", "Лук", "Чеснок"};
        for (int i = 0; i < jrb.length; i++) {
            jrb[i] = new JRadioButton(textButton[i]);
            if (i < 2) {
                bgr.add(jrb[i]);
            } else {
                bgr2.add(jrb[i]);
            }
            jp[1].add(jrb[i]);
        }
        JCheckBox[] jcb = new JCheckBox[4];
        for (int i = 0; i < jcb.length; i++) {
            jcb[i] = new JCheckBox(textChekBox[i]);
            jp[1].add(jcb[i]);
        }

        JButton button = new JButton("Отобразить");
        jp[1].add(button);

        ActionListener actlist = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb[0].isSelected()){
                    jp0DP.setImgFile("cup.png");
                } else if (jrb[1].isSelected()){
                    jp0DP.setImgFile("bank.png");
                } else {
                    jp0DP.setImgFile("empty.png");
                    jp0DP.repaint();
                }

                if (jrb[3].isSelected()) {
                    jp0DP.setVeg(jcb[0].isSelected(),jcb[1].isSelected(),jcb[2].isSelected(),jcb[3].isSelected());
                } else {
                    jp0DP.setVeg(false, false, false, false);
                }
                jp0DP.repaint();
            }
        };

        button.addActionListener(actlist);

        jp[2].setLayout(new GridLayout(2,2));
        String[] comboStr = {"Белый", "Серый", "Синий", "Желтый"};
        JLabel jlab21 = new JLabel("Фон емкости");
        JLabel jlab22 = new JLabel("Фон овоща");
        jlab21.setLocation(5,5);

        JComboBox<String> jcombo1 = new JComboBox<>(comboStr);
        JComboBox<String> jcombo2 = new JComboBox<>(comboStr);
        jp[2].add(jlab21);
        jp[2].add(jlab22);
        jp[2].add(jcombo1);
        jp[2].add(jcombo2);

        jcombo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (jcombo1.getSelectedItem().toString()){
                    case "Белый":
                        jp0DP.setColImg(Color.white);
                        jp0DP.repaint();
                        break;
                    case "Серый":
                        jp0DP.setColImg(new Color(238,238,238));
                        jp0DP.repaint();
                        break;
                    case "Синий":
                        jp0DP.setColImg(Color.blue);
                        jp0DP.repaint();
                        break;
                    case "Желтый":
                        jp0DP.setColImg(Color.yellow);
                        jp0DP.repaint();
                        break;
                }
             }
        });

        jcombo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (jcombo2.getSelectedItem().toString()){
                    case "Белый":
                        jp0DP.setColVeg(Color.white);
                        jp0DP.repaint();
                        break;
                    case "Серый":
                        jp0DP.setColVeg(new Color(238,238,238));
                        jp0DP.repaint();
                        break;
                    case "Синий":
                        jp0DP.setColVeg(Color.blue);
                        jp0DP.repaint();
                        break;
                    case "Желтый":
                        jp0DP.setColVeg(Color.yellow);
                        jp0DP.repaint();
                        break;
                }            }
        });

        jp[3].setLayout(null);
         JSlider js = new JSlider();
        JLabel jlab = new JLabel("Value: 50");
        js.setMaximum(100);
        js.setMinimum(0);
        js.setValue(50);
        jp[3].add(jlab);
        jp[3].add(js);

        js.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jlab.setText("Value: " + js.getValue());
                jp0DP.setPlEmk(js.getValue());
                jp0DP.repaint();
            }
        });

        jlab.setBounds(10, 10, 100, 20);
        js.setBounds(20, 40, 300, 100);
        js.setBackground(new Color(160, 255, 160));


        JMenuBar mainMenu = new JMenuBar();
        JMenu mUpr = new JMenu("Управление");

        JMenuItem miOtobr = new JMenuItem("Отобразить");
        JMenuItem miExit = new JMenuItem("Выход");

        setJMenuBar(mainMenu);

        mainMenu.add(mUpr);

        mUpr.add(miOtobr);
        mUpr.addSeparator();
        mUpr.add(miExit);

        miOtobr.addActionListener(e -> button.doClick());
        miExit.addActionListener(e -> System.exit(0));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.out.println("GOOD BYE, Baby!!!");
            }
        });

        setVisible(true);
    }
}
