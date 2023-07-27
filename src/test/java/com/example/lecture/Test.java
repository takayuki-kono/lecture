package com.example.lecture;

import org.springframework.boot.SpringApplication;

import java.util.*;

import static java.lang.String.valueOf;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
////        test.test_20230710();
//        test.test_20230719();
//        test.kadai_20230724();
        test.kadai_20230724();
    }

    public void test_20230727(){
    }



    class ThreadTestThread extends Thread {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.print('o');
            }
        }
    }

    public void kadai_20230725() {
        //下記③④を複数回（十回以上）実行
        //③ ②を呼び出す処理を記述したrunメソッドThreadをRunnable（ラムダ式）で渡す形で定義
        //④Threadの処理を実行
        // （※出力が自然数になるように定義）
//        Appender appender = Appender.getAppender();
        for(int i=0;i<10;i++){
            Thread t = new Thread( () -> {
                    Appender.getAppender().append();
            } );
//            Thread t = new Thread(Appender.getAppender()::append);
            t.start();
        }
    }

//    public class Appender{
//        static int count;
//
//        static com.example.lecture.Appender appender =  new Appender();
//
//        private Appender(){
//        }
//
//        public static Appender getAppender(Test test){
//            return appender;
//        }
//
//        public synchronized void append() throws InterruptedException{
//            count++;
//            Thread.sleep(1000);
//            System.out.println(count);
//        }
//
//    }



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

    public void kadai_20230724() {
        //0か1のランダム数を定義
        //ランダム変数で1を割る
        //（数回実行して、エラーが投げられた場合、"無限"を出力）
        System.out.println("無限");
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
        // 格納した順を保持しない
//        Map<String, Cat> catMap = new HashMap<>();
        // 格納した順を保持する
        Map<String, Cat> catMap = new LinkedHashMap<>();
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

    }
        public void test_20230710(){
        //20230710
        //クラスのインスタンスを生成してください
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
        //条件
        //・Animal interfaceを実装したクラスDogを継承したPomeranianクラス
        //・Dogクラスは毛の本数と犬種をパラメータにもつコンストラクタを定義する（Dogのhear / kindOfDog変数に代入）
        //・Pomeranianクラスは毛の本数をパラメータにもつコンストラクタを定義する（Dogのhear変数に代入）
        //・Animal interface にcryメソッドを定義する(非static)
        //new BlackCat();

    }

}
