package com.example.lecture;

import lombok.Data;

@Data
public class Cat implements Animal{

    public String name;

    private Status status;
    private Status2 status2;

    @Data
    protected class Status{
        int life = 100;
//        String name;
    }

    @Data
    protected class Status2{
        int life;
        String name;

        Status2(){
            this.life = status.getLife();
        }


    }
    public Cat(String name){
        this.name = name;
    }

//    public Cat(String name){
//        status = new Status();
////        status.setName(name);
//        status2 = new Status2();
//        System.out.println(status2.getLife());
//    }


    @Override
    public void cry() {
//        super.
//        System.out.println("mew");

    }

//    public void
}
