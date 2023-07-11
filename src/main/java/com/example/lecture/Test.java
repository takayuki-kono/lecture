package com.example.lecture;


//条件
//・Animal interfaceを実装したクラスDogを継承したPomeranianクラス
//・Dogクラスは毛の本数と犬種をパラメータにもつコンストラクタを定義する（Dogのhear / kindOfDog変数に代入）
//・Pomeranianクラスは毛の本数をパラメータにもつコンストラクタを定義する（Dogのhear変数に代入）
//・Animal interface にcryメソッドを定義する(非static)


interface Animal {
    void cry();
}

class Dog implements Animal {


    public class Main {
        public static void main(String[] args) {
            Pomeranian pomeranian = new Pomeranian(100);
            pomeranian.cry();
        }
    }
    private int numOfHairs;
    private String kindOfDog;

    public Dog(int numOfHairs, String kindOfDog) {
        this.numOfHairs = numOfHairs;
        this.kindOfDog = kindOfDog;
    }

    @Override
    public void cry() {
        System.out.println("bowwow");
    }
}

class Pomeranian extends Dog {
    public Pomeranian(int numOfHairs) {
    }
}
