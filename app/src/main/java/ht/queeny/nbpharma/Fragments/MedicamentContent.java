package ht.queeny.nbpharma.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

import ht.queeny.nbpharma.Adapter.MedicamentAdapter;
import ht.queeny.nbpharma.Models.Medicaments;
import ht.queeny.nbpharma.R;
import ht.queeny.nbpharma.Settings.BackendlessSettings;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedicamentContent.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MedicamentContent extends Fragment {




    private OnFragmentInteractionListener mListener;

    private MedicamentAdapter medicamentAdapter;

    public MedicamentContent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String[] menuItems ={"Paracetamol", "Depandol" ,"Ti police", "Apetamine"};
        return inflater.inflate(R.layout.fragment_medicament_content, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setGroupBy("nom");

        final ListView listView = view.findViewById(R.id.lvmedicament);

        Backendless.Persistence.of(Medicaments.class).find(queryBuilder, new AsyncCallback<List<Medicaments>>() {
            @Override
            public void handleResponse(List<Medicaments> response) {
                medicamentAdapter = new MedicamentAdapter(getContext(), response);
                listView.setAdapter(medicamentAdapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.v("Backendless", fault.toString());
            }
        });

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        Backendless.initApp(getContext(), BackendlessSettings.APPLICATION_ID, BackendlessSettings.API_KEY);

    }





    // TODO: Rename method, update argument and onQueryTextChangehook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            //throw new RuntimeException(context.toString()
                    //+ " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
