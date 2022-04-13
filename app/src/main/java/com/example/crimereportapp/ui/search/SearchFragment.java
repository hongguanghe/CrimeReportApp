package com.example.crimereportapp.ui.search;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.crimereportapp.data.DataCache;
import com.example.crimereportapp.CityInfoFragment;
import com.example.crimereportapp.R;

import java.util.List;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {

//    private FragmentSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ImageView myCityImage = view.findViewById(R.id.myCityImage);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.provo);
        RoundedBitmapDrawable img = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        img.setCornerRadius(150);

        myCityImage.setImageDrawable(img);

        Button myCityButton = view.findViewById(R.id.myCityButton);
        Button currentLocationButton = view.findViewById(R.id.currLocationButton);

        myCityButton.setOnClickListener(v -> {
            CityInfoFragment cif = new CityInfoFragment();
            //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, cif).commit();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.nav_host_fragment_activity_main, cif).commit();
        });

        currentLocationButton.setOnClickListener(v -> {
            CityInfoFragment cif = new CityInfoFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.nav_host_fragment_activity_main, cif).commit();
        });

        SearchView searchView = view.findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(this);

        return view;

        /*TextView sample = view.findViewById(R.id.text_home);
        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityInfoFragment cif = new CityInfoFragment();
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.nav_host_fragment_activity_main, cif).commit();
            }
        });*/

//      return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        List<String> searchResults = DataCache.get_instance().getSearchResults(query);

        if (searchResults.size() > 0) {
            Toast.makeText(getActivity(), searchResults.get(0), Toast.LENGTH_SHORT).show();
            DataCache.get_instance().setCurrentCityName(searchResults.get(0));
        }

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}