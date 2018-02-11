package mina.com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class jokesActivity extends AppCompatActivity {

    TextView joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        joke = (TextView) findViewById(R.id.joke_tv);

        String sentJoke = getIntent().getStringExtra("joke");

        joke.setText(sentJoke);


    }
}
