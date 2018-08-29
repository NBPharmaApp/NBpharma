package ht.queeny.nbpharma.Adapter;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import ht.queeny.nbpharma.Models.Medicaments;
import ht.queeny.nbpharma.R;


public class MedicamentAdapter extends ArrayAdapter<Medicaments> {

    private Context context;
    private List<Medicaments> medicamentsList;

    public MedicamentAdapter(Context context, List<Medicaments> list)
    {
        super(context, R.layout.medicament_row_layout, list);

        this.context = context;
        this.medicamentsList = list;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.medicament_row_layout, parent, false);

        TextView address = convertView.findViewById(R.id.nomMedoc);
        //ImageView image = convertView.findViewById(R.id.imageView3);
        address.setText(medicamentsList.get(position).getNom());

        return convertView;

    }
}




