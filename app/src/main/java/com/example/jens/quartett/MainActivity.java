package com.example.jens.quartett;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        readDeck("bikes");
        textView.setText("");



    }




    public void readDeck(String deckName){

        try{
            JSONObject obj = new JSONObject(Utilities.loadJSONFromAsset(this,deckName));
            String name = obj.getString("name");






        }catch (JSONException je){
            je.printStackTrace();
        }


    }
}
