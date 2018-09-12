package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static fr.wildcodeschool.blablawild.ItinerarySearchActivity.EXTRA_DEPARTURE;
import static fr.wildcodeschool.blablawild.ItinerarySearchActivity.EXTRA_NAME;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);


        Intent intentFromSearch = getIntent();
        String departure = intentFromSearch.getStringExtra(EXTRA_DEPARTURE);
        String name=intentFromSearch.getStringExtra(EXTRA_NAME);

        setTitle(departure+" >> "+name);

    }
}
