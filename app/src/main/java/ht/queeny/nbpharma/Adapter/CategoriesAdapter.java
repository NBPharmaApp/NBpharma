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
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ht.queeny.nbpharma.R;

/**
 * Created by root on 8/21/18.
 */

public class CategoriesAdapter extends ArrayAdapter<CategoriesAdapter> {

    private String descCategorie; //in database
    private String objectCategorie; //in database

    ArrayList<CategoriesAdapter> CategoriesAdapter;
    Context context;
    int resource;

    public String getDescCategorie() {
        return descCategorie;
    }

    public String getObjectCategorie() {
        return objectCategorie;
    }

    private static class ViewHolder {
        TextView descCategorie;
        TextView objectCategorie;
        private List<CategoriesAdapter> list;
        ArrayList<CategoriesAdapter> listCategories;
    }

    public CategoriesAdapter(Context context, ArrayList<CategoriesAdapter> categories) {
        super(context, R.layout.list_item, categories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final CategoriesAdapter categoriesAdapter = getItem(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null, true);

            viewHolder.descCategorie = (TextView) convertView.findViewById(R.id.DescCategorie);
            viewHolder.objectCategorie = (TextView) convertView.findViewById(R.id.ObjectCategorie);


            //Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.descCategorie.setText(CategoriesAdapter.getDescCategorie());
        viewHolder.objectCategorie.setText(CategoriesAdapter.getObjectCategorie());

        // Picasso.with(getContext())
        //   .load(CategorieAdapter.getImageMedicament())
        //  .resize(220, 130).into(viewHolder.imageMedicament);

        return convertView;

    }
}
