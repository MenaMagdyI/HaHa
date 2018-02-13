package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Mena on 2/12/2018.
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {
    public MyApi myApiService = null;

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory()
                    , null)
                    .setRootUrl(MainActivity.GENYMOTION_ROOTURL)
                    .setApplicationName("haha")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return  myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
