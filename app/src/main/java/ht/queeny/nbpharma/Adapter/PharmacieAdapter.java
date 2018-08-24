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

public class PharmacieAdapter extends ArrayAdapter<PharmacieAdapter> {

    private String NomPharmacie; //in database
    private String ImagesParmacie; //in database

    ArrayList<PharmacieAdapter> PharmacieAdapter;
    Context context;
    int resource;

    public String getNomPharmacie() {
        return NomPharmacie;
    }

    public String getImagesParmacie() {
        return ImagesParmacie;
    }

    private static class ViewHolder {
        TextView NomPharmacie;
        ImageView ImagesParmacie;

        private List<PharmacieAdapter> list;
        ArrayList<PharmacieAdapter> listPharmacie;
    }

    public PharmacieAdapter(Context context, ArrayList<PharmacieAdapter> pharmacie) {
        super(context, R.layout.list_item, pharmacie);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PharmacieAdapter.ViewHolder viewHolder;
        final PharmacieAdapter pharmacieAdapter = getItem(position);
        if (convertView == null) {
            viewHolder = new PharmacieAdapter.ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null, true);

            viewHolder.NomPharmacie = (TextView) convertView.findViewById(R.id.NomPharmacie);
            viewHolder.ImagesParmacie = (ImageView) convertView.findViewById(R.id.ImagesPharmacie);

            //Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (PharmacieAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.NomPharmacie.setText(PharmacieAdapter.getNomPharmacie());
        viewHolder.ImagesParmacie.setVisibility(View.GONE);

        Picasso.with(getContext())
                .load(PharmacieAdapter.getImagesPharmacie())
                .resize(220, 130).into(viewHolder.ImagesPharmacie);

        return convertView;

    }

}
