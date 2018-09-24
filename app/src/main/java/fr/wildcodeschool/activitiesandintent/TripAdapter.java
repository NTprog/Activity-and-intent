package fr.wildcodeschool.activitiesandintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TripAdapter extends ArrayAdapter<TripModel> {


    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }

        public View getView ( int position, View convertView, ViewGroup parent){

            // Get the data item for this position
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_trip, parent, false);
            }

            tripViewHolder viewHolder = (tripViewHolder) convertView.getTag();
            if(viewHolder == null) {
                viewHolder = new tripViewHolder();
                // Lookup view for data population
                viewHolder.firstName = (TextView) convertView.findViewById(R.id.firstName);
                viewHolder.lastName = (TextView) convertView.findViewById(R.id.lastName);
                viewHolder.prix = (TextView) convertView.findViewById(R.id.prix);
                viewHolder.date= (TextView) convertView.findViewById(R.id.date);
                convertView.setTag(viewHolder);
            }

            TripModel trip = (TripModel) getItem(position);
            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy-kk:mm");

            // Populate the data into the template view using the data object
            viewHolder.firstName.setText(trip.getFirstName());
            viewHolder.lastName.setText(trip.getLastName());
            viewHolder.prix.setText(String.valueOf(trip.getPrix()));
            viewHolder.date.setText(formatDate.format(trip.getDate()));

            // Return the completed view to render on screen
            return convertView;
        }
    }
    class tripViewHolder{
        public TextView firstName;
        public TextView lastName;
        public TextView date;
        public TextView prix;
}
