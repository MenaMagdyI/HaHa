package mina.com.jokeslib;

import java.util.Random;

public class joker {

    private static String[] mJokes = {
            "Why Android Programmers wear glasses? Because they can't C#",
            "Why did a programmer quit his job? Because he didn't get arrays",
            "What is programmer's favorite hangout place? Foo Bar"};


    public static String[] getJokes() {
        return mJokes;
    }

    public static String getJoke() {
        Random random = new Random();
        return mJokes[random.nextInt(mJokes.length)];


    }
}
