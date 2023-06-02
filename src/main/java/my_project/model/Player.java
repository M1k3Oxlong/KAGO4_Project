package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Graph;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private int points;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;

    public Player(double x, double y){
        this.x = x;
        this.y = y;
        speed = 1500;
        width = 80;
        height = 400;

        this.keyToGoLeft    = KeyEvent.VK_A;
        this.keyToGoRight   = KeyEvent.VK_D;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
        drawTool.setCurrentColor(Color.RED);
        drawTool.drawText(10,10,Integer.toString(points));
    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
        if(x<0){
            x=0;
        }
        if(x> Config.WINDOW_WIDTH-20-width){
            x=Config.WINDOW_WIDTH-20-width;
        }
        if(direction == 0){
            x = x + speed*dt;
        }
        if(direction == 2){
            x = x - speed*dt;
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            System.out.println("Mutter");
        }
    }

    public void score(){
        points+=10;
    }
    public void antiScore(){
        points-=10;
    }
}
