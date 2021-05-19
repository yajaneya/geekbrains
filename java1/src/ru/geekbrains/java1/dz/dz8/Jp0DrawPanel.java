package ru.geekbrains.java1.dz.dz8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Jp0DrawPanel extends JPanel {

    private String imgFile = "empty.png";
    private boolean bow = false;
    private boolean cucumber = false;
    private boolean garlic = false;
    private boolean tomato = false;
    private Color colImg = new Color(238,238,238);
    private Color colVeg = new Color(238,238,238);
    private int plEmk = 50;


    public void paintComponent(Graphics g) {
        try
        {
            Image img = ImageIO.read(Jp0DrawPanel.class.getResourceAsStream(imgFile));
            g.drawImage(img, 175-(110+plEmk)/2, 150-(110+plEmk)/2, 110+plEmk, 110+plEmk, colImg, null);
            Image imgCucumber = ImageIO.read(Jp0DrawPanel.class.getResourceAsStream("cucumber.png"));
            Image imgTomato = ImageIO.read(Jp0DrawPanel.class.getResourceAsStream("tomato.png"));
            Image imgBow = ImageIO.read(Jp0DrawPanel.class.getResourceAsStream("bow.png"));
            Image imgGarlic = ImageIO.read(Jp0DrawPanel.class.getResourceAsStream("Garlic.png"));
            if (cucumber) g.drawImage(imgCucumber, 130, 120, 30, 30, colVeg, null);
            if (tomato) g.drawImage(imgTomato, 160, 120, 30, 30, colVeg, null);
            if (bow) g.drawImage(imgBow, 130, 140, 30, 30, colVeg, null);
            if (garlic) g.drawImage(imgGarlic, 160, 140, 30, 30, colVeg, null);
//            g.;
        }
        catch(IOException ex)
        {
            System.out.println("Не возможно найти файл!");
        }

    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public void setColImg(Color colImg) {
        this.colImg = colImg;
    }

    public void setColVeg(Color colVeg) {
        this.colVeg = colVeg;
    }

    public void setPlEmk(int plEmk) {
        this.plEmk = plEmk;
    }

    public void setVeg (boolean cucumber, boolean tomato, boolean bow, boolean garlic) {
        this.cucumber = cucumber;
        this.tomato = tomato;
        this.bow = bow;
        this.garlic = garlic;
    }
}
