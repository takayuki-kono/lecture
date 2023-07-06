package com.example.lecture;

public abstract class animal {

    int life = 100;

    public void die(){
        life = 0;
    };

    public abstract void cry();
}
