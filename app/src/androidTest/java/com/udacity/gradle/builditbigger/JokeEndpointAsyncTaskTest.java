package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import mina.com.jokeslib.joker;

import java.util.concurrent.ExecutionException;

/**
 * Created by mena on 02/12/18.
 */
@RunWith(AndroidJUnit4.class)
public class JokeEndpointAsyncTaskTest extends AndroidTestCase {

    @Test
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
