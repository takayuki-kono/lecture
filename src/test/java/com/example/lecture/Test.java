package com.example.lecture;

import org.springframework.boot.SpringApplication;

import java.util.*;

import static java.lang.String.valueOf;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        test.test_20230710();
//        test.test_20230719();
//        test.kadai_20230720();
//        test.kadai_20230724();
        test.test_20230725();
    }

    class ThreadTestThread extends Thread {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.print('o');
            }
        }
    }

    public void kadai_20230725() {
        //インスタンスが一意になるよう（シングルトン）、下記の属性を定義したクラスAppenderを定義
        //①static変数（int型）
        //②下記の処理を定義したメソッド
        //　ア　①の変数を加算
        //　イ　一秒待機
        //　ウ　①の変数を出力
        //下記の処理を記述したrunメソッドThreadをRunnableで渡す形で定義
        //①Appenderの②のメソッドを呼び出す
        //このメソッドの内で、Threadの処理を複数回（十回以上）実行させる
        //（※出力される数字が自然数になるように定義）
    }

//    class RunnableTestThread implements Runnable {
//        public void run() {
//            for (int i = 0; i < 1000; i++) {
//                System.out.print('o');
//            }
//        }
//    }

    public void test_20230725(){
        ThreadTestThread tt = new ThreadTestThread();
        tt.start();
        for (int i = 0; i < 1000; i++) {
            System.out.print('.');
        }

//        RunnableTestThread tt2 = new RunnableTestThread();
//        Thread t = new Thread(tt);
        Thread t = new Thread( () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print('o');
            }
        } );
        t.start();

        for (int i = 0; i < 1000; i++) {
            System.out.print('.');
        }
    }

    public void test_20230719(){
        String a = "b";
//        String b = "b";
        String b = "b@";

        b = b.replace("@", "");
//        b = "b";
        System.out.println(a);
        System.out.println(b);

//        a.equals(b);
        System.out.println(a == b);
        System.out.println(Objects.equals(a, b));

        //含まれるかどうか
        a.contains("b");
        //正規表現に当てはまるかどうか
        a.matches("[a-z]");
        //空文字かどうか
        a.isEmpty();
        //空白を削除
        a.trim();
        //切り取り
        a = "abc".substring(1, 2);
        //違う型から変換
        String one = valueOf(1);

        // 結合するたびインスタンスが生成される
        // 結合する際に、結合するindexを数える
        String c = "a" + "b" + "c";

        // 結合するたびインスタンスが生成されない
        // 結合する際に、結合するindexを数えない
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        sb.toString();

    }

    public void test_20230720() {
        List<Cat> list = new ArrayList<>();
//        list.add(new Cat("a"));
//        list.add(new Cat("b"));
        List<String> o = new ArrayList<>();
        HashSet<String> l = new HashSet<>();
        for(Cat m : list){
            if(o.contains(m.getName())){
                o.add(m.getName());
                m.getName();
            }
            if(l.add(m.getName())){
            }
        }
        Map<String, Cat> catMap = new HashMap<>();
//        catMap.put("a", new Cat("a"));
        for(Map.Entry<String, Cat> m : catMap.entrySet()){
            m.getKey();
//            catMap.get(m.getKey());
            m.getValue();
        }
        LinkedList<String> list2 = new LinkedList<>();
    }

    public void kadai_20230720() {
        // Mapに下記のペアで格納する
        //・"sazae"/Catオブジェクトのname"tama"/color"yellow"
        //・"doraemon"/Catオブジェクトのname"me"/color"white"
        //・"kiteretu"/Catオブジェクトのname"korosuke"/color"yellow"
        // Mapに順序処理をかける（格納した順）
        //colorが重複しないように格納した順にvalueのCatオブジェクトのcallメソッドを呼び、"tama""me"の順で出力させる

        //Mapに順序処理をかけるためにLinkedHashMapを使用
        Map<String, Cat> map = new LinkedHashMap<>();
        map.put("sazae", new Cat("tama", "yellow")); //aのインスタンス
        map.put("doraemon", new Cat("me","white")); //bインスタンス
        map.put("kiteretu", new Cat("korosuke","yellow")); //cインスタンス

        //重複を許さず、順番も守るsetを作成
        //最初は
        Set<String> set = new LinkedHashSet();
        //Set<Cat> catset = new LinkedHashSet();
        for(Map.Entry<String, Cat> m : map.entrySet()){
            if(set.add(m.getValue().getColor())){
                //これをifの条件とし、cat.call()を呼ぶ
                //あくまで条件式としてなので、nameは別に代入してやる
                //catset.add(m.getValue());
                // ::
                // これだとcallが呼びたいnameが定義されていない、catsetに対してcallを呼びたい
                m.getValue().call();
                // 新規にインスタンスを作成して、値を代入する必要はない
                // 単純にforで入力されている内容を出力すればよい
                // また、call()メソッドをstaticにすると、name参照できなくなるため注意
            }
        }
        //で作っていたが、初期化の際にまとめて定義できるらしい
        //Set<Cat> set = new LinkedHashSet<>(map.values());
        //ただし、これだとvalueはname, colorの2つの要素を持つため、"tama"と"korosuke"は重複していないとみなされる
        //かといって、colorだけを格納したsetを作っても、name情報がないのでcall()メソッドで出力できない

//        Catクラスにequals()メソッドとhashCode()メソッドをオーバーライドしてcolorの値を元に重複を判定できる（GPT談）
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Cat cat = (Cat) o;
//            return Objects.equals(color, cat.color);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(color);
//        }

//        callメソッドで出力
//        for(Cat cat : catset){
//            cat.call();
//        }
    }
        public void test_20230710(){
        //20230710
        //クラスのインスタンスを生成してください
        //条件
        //・Animal interfaceを実装したクラスDogを継承したPomeranianクラス
        //・Dogクラスは毛の本数と犬種をパラメータにもつコンストラクタを定義する（Dogのhear / kindOfDog変数に代入）
        //・Pomeranianクラスは毛の本数をパラメータにもつコンストラクタを定義する（Dogのhear変数に代入）
        //・Animal interface にcryメソッドを定義する(非static)
        class Dog implements Animal {
            int hear;
            String kindOfDog;
            Dog(int hear, String kindOfDog){
                this.hear = hear;
                this.kindOfDog = kindOfDog;
            }

            @Override
            public void cry() {

            }

        }
        class Pomeranian extends Dog{

//            public static final String kindOfDog = "pomeranian";

            Pomeranian(int hear){
                super(hear, "pomeranian");
                this.kindOfDog = "p";

                var a = "a";
                Dog[] xx = { new Dog(hear, "pomeranian"), new Dog(hear, "pomeranian")};
                List<Dog> b = new ArrayList<Dog>(){
                    {
                        add(new Dog(100, "pomeranian"));
                    }
                };
            }
        }
        //new BlackCat();
    }

}
