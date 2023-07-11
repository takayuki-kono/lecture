package com.example.lecture;

import org.springframework.boot.SpringApplication;

public class Test {

    public static void main(String[] args) {
        //20230710
        //クラスのインスタンスを生成してください
        class Dog implements Animal {
            int hear;
            String kindOfDog;
            Dog(int hear, String kindOfDog){
                this.hear = hear;
                this.kindOfDog = kindOfDog;
            }

            public void cry() {
            }

        }
        class Pomeranian extends Dog{
            Pomeranian(int hear){
                super(hear);
            }
        }
        //条件
        //・Animal interfaceを実装したクラスDogを継承したPomeranianクラス
        //・Dogクラスは毛の本数と犬種をパラメータにもつコンストラクタを定義する（Dogのhear / kindOfDog変数に代入）
        //・Pomeranianクラスは毛の本数をパラメータにもつコンストラクタを定義する（Dogのhear変数に代入）
        //・Animal interface にcryメソッドを定義する(非static)
        //new BlackCat();
    }

}
