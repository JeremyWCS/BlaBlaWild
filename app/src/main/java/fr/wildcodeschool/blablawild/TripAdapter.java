package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for firstname
        TextView textFirstname = (TextView) convertView.findViewById(R.id.text_firstname);
        // Populate the data into the template view using the trip model
        textFirstname.setText(trip.getFirstname());

        // Lookup view for Lastname
        TextView textLastname = (TextView) convertView.findViewById(R.id.text_lastname);
        // Populate the data into the template view using the trip model
        textLastname.setText(trip.getLastname());


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-kk:mm", Locale.FRENCH);

        // Lookup view for Date
        TextView textDate = (TextView) convertView.findViewById(R.id.text_date);
        // Populate the data into the template view using the trip model
        textDate.setText(sdf.format(trip.getDate()));

        // Lookup view for Price
        TextView textPrice = (TextView) convertView.findViewById(R.id.text_price);
        // Populate the data into the template view using the trip model
        textPrice.setText(Integer.toString(trip.getPrice()));

        return convertView;
    }


}
