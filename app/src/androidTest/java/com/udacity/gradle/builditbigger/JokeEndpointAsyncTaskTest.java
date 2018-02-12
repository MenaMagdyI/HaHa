package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import mina.com.jokeslib.joker;

import java.util.concurrent.ExecutionException;

/**
 * Created by mena on 02/12/18.
 */

public class JokeEndpointAsyncTaskTest extends AndroidTestCase {

    public void getValidJokesFromEndpointAsyncTask() {
        EndpointAsyncTask testTask = new EndpointAsyncTask();
        testTask.execute();

        String joke = "";
        try {
            joke = testTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String[] jokes = joker.getJokes();
        boolean flag = false;
        for (int i=0 ; i< jokes.length ; i++) {
            if(joke.equals(jokes[i])) {
                flag = true;
                break;
            }
        }

        assertEquals(flag, true);

    }
}
