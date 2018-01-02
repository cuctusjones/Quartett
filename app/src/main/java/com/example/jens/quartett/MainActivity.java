package com.example.jens.quartett;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);



        textView.setText(readDeck("bikes").toString());


    }


    public Deck readDeck(String deckName) {
        Deck deck = new Deck();
        try {


            ArrayList<Card> cardArrayList = new ArrayList<>();
            ArrayList<Property> propertyArrayList = new ArrayList<>();
            JSONObject obj = new JSONObject(Utilities.loadJSONFromAsset(this, deckName));

            deck.setName(obj.getString("name"));
            deck.setDescription(obj.getString("description"));

            JSONArray cards = obj.getJSONArray("cards");
            JSONArray properties = obj.getJSONArray("properties");


            for (int i = 0; i < cards.length(); i++) {
                Card card = new Card();
                ArrayList<Image> images = new ArrayList<>();
                ArrayList<Value> values = new ArrayList<>();
                JSONObject jcard = cards.getJSONObject(i);
                card.setId(jcard.getInt("id"));

                card.setName(jcard.getString("name"));
                JSONArray jimages = jcard.getJSONArray("images");
                JSONArray jvalues = jcard.getJSONArray("values");

                for (int j = 0; i < jimages.length(); j++) {

                    JSONObject jimage = jimages.getJSONObject(j);
                    Image image = new Image(jimage.getInt("id"), jimage.getString("filename"));
                    images.add(image);

                }

                for (int k = 0; k < jvalues.length(); k++) {
                    JSONObject jvalue = jvalues.getJSONObject(k);
                    Value value = new Value(jvalue.getDouble("value"), jvalue.getInt("propertyId"));
                    values.add(value);
                }
                card.setImages(images);
                card.setValues(values);


                cardArrayList.add(card);


            }


            deck.setCards(cardArrayList);

            for (int i = 0; i < properties.length(); i++) {
                JSONObject jproperty = properties.getJSONObject(i);
                Property property = new Property(jproperty.getString("text"),
                        jproperty.getInt("compare"), jproperty.getInt("id"), jproperty.getString("unit"), jproperty.getInt("precision"));

                propertyArrayList.add(property);
            }

            deck.setProperties(propertyArrayList);





        } catch (JSONException je) {
            je.printStackTrace();
        }

        return deck;
    }
}
