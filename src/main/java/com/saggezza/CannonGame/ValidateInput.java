package com.saggezza.CannonGame;

public class ValidateInput implements IValidateInput {

    @Override
    public boolean checkInput(int velocity, int angle) {

        return velocity >= 1 && velocity <= 20 && angle >= 1 && angle <= 90;
    }
}

