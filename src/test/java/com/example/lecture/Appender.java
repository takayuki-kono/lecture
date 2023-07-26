package com.example.lecture;

//下記の①②属性のAppenderを定義し、シングルトンとして保持
//①static変数定義（int型）
//②下記アイウの処理を含む非staticメソッド　
//　　ア　①の変数を加算
//　　イ　一秒待機
//　　ウ　①の変数を出力
public class Appender {
    static int num;
    //1つのクラスが1つしかインスタンスを持たない状態：シングルトン
    private static Appender appender = new Appender();
    //コンストラクタ(クラスと同じ名前を持つメソッド)
    private Appender(){
    }
    //static変数をリターンするメソッド
    public static Appender getAppender(){
        return appender;
    }
    public synchronized void count(){
        num++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.print(num+",");
    }
}
