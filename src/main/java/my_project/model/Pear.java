package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Pear extends Fruit {

    private boolean toTheRight;
    private double directionTimer;
    private double speed;

    public Pear(double x, double y){
        super(x,y);
        width = 25;
        height = 305;
        toTheRight= false;
        directionTimer=0;
        speed=150;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    public void update(double dt){
        super.update(dt);
        movement(dt);
    }

    public void movement(double dt){
        directionTimer+=dt;
        if(directionTimer>1.5){
            directionTimer=0;
            toTheRight=!toTheRight;
        }
        if(toTheRight==true){
            if(x<=1000){
                x+=dt*speed;
            }
        }else{
            if(x>=0){
                x-=dt*speed;
            }
        }
    }

    //TODO 04 Lege eine Methode jumpBack() an, die bei Aufruf das Pear-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    public void jumpBack(){
        y=-50;
        x = Math.random()*975;
    }


}

