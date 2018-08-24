package ht.queeny.nbpharma.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ht.queeny.nbpharma.R;

public class MedicamentAdapter extends ArrayAdapter<MedicamentAdapter> {

            private String nomMedicament; //in database
            private String dateExpi; //in database
            private String imageMedicament;

            ArrayList<MedicamentAdapter> medicamentAdapters;
            Context context;
            int resource;

            public String getNomMedicament() {
                return nomMedicament;
            }

            public String getImageMedicament() {
                return imageMedicament;
            }

            private static class ViewHolder {
                TextView nomMedicament;
                TextView dateExpi;
                ImageView imageMedicament;
                private List<ht.queeny.nbpharma.Adapter.MedicamentAdapter> list;
                ArrayList<ht.queeny.nbpharma.Adapter.MedicamentAdapter> listMedicament;
            }

            public MedicamentAdapter(Context context, ArrayList<ht.queeny.nbpharma.Adapter.MedicamentAdapter> medoc) {
                super(context, R.layout.list_item, medoc);
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                ht.queeny.nbpharma.Adapter.MedicamentAdapter.ViewHolder viewHolder;
                final ht.queeny.nbpharma.Adapter.MedicamentAdapter medicamentAdapter = getItem(position);
                if (convertView == null) {
                    viewHolder = new ht.queeny.nbpharma.Adapter.MedicamentAdapter.ViewHolder();
                    LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    convertView = layoutInflater.inflate(R.layout.list_item, null, true);

                    viewHolder.nomMedicament = (TextView) convertView.findViewById(R.id.nomMedicament);
                    viewHolder.dateExpi = (TextView) convertView.findViewById(R.id.dateExpi);
                    viewHolder.imageMedicament = (ImageView) convertView.findViewById(R.id.imgMedoc);

                    //Cache the viewHolder object inside the fresh view
                    convertView.setTag(viewHolder);
                } else {
                    // View is being recycled, retrieve the viewHolder object from tag
                    viewHolder = (ht.queeny.nbpharma.Adapter.MedicamentAdapter.ViewHolder) convertView.getTag();
                }

                viewHolder.nomMedicament.setText(medicamentAdapter.getNomMedicament());
                viewHolder.dateExpi.setText(medicamentAdapter.getImageMedicament());
                viewHolder.imageMedicament.setVisibility(View.GONE);

                Picasso.with(getContext())
                        .load(medicamentAdapter.getImageMedicament())
                        .resize(220, 130).into(viewHolder.imageMedicament);

                return convertView;

            }

}





