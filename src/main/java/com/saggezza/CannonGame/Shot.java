package com.saggezza.CannonGame;

public class Shot implements IShot{

    @Override
    public double[] computeVelocityAngle(int velocity, int angle) {

        double degrees = (angle *(Math.PI/180));
        double x =  ((Math.cos(degrees))* velocity);
        double y =  ((Math.sin(degrees))* velocity);

        double[] shotXY = new double[2];
        shotXY[0] = x;
        shotXY[1] = y;
        return shotXY;
    }
}
