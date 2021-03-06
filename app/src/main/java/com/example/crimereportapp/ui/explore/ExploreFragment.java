package com.example.crimereportapp.ui.explore;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.crimereportapp.CityInfoActivity;
import com.example.crimereportapp.CityInfoFragment;
import com.example.crimereportapp.R;
import com.example.crimereportapp.data.DataCache;
import com.example.crimereportapp.databinding.FragmentExploreBinding;

public class ExploreFragment extends Fragment {

//    private FragmentExploreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        ImageView saltLakeImage = view.findViewById(R.id.SaltLakeExplore);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.saltlake);
        RoundedBitmapDrawable img = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        img.setCornerRadius(150);
        saltLakeImage.setImageDrawable(img);

        ImageView newYorkImage = view.findViewById(R.id.NewYorkExplore);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.newyork);
        img = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        img.setCornerRadius(300);
        newYorkImage.setImageDrawable(img);

        ImageView sanFranImage = view.findViewById(R.id.SanFranExplore);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.sanfrancisco);
        img = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        img.setCornerRadius(150);
        sanFranImage.setImageDrawable(img);

        ImageView chicagoImage = view.findViewById(R.id.ChicagoExplore);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.chicago);
        img = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        img.setCornerRadius(150);
        chicagoImage.setImageDrawable(img);

        Button saltLakeButton = view.findViewById(R.id.saltLakeButton);
        saltLakeButton.setOnClickListener(v -> {
            DataCache.get_instance().currentCityZip = 84150;
            DataCache.get_instance().currentCityName = "Salt Lake City";
            Intent cif = new Intent(getActivity(), CityInfoActivity.class);
            startActivity(cif);
        });

        Button newYorkButton = view.findViewById(R.id.newYorkButton);
        newYorkButton.setOnClickListener(v -> {
            DataCache.get_instance().currentCityZip = 10001;
            DataCache.get_instance().currentCityName = "New York City";
            Intent cif = new Intent(getActivity(), CityInfoActivity.class);
            startActivity(cif);
        });

        Button sanFranButton = view.findViewById(R.id.sanFranButton);
        sanFranButton.setOnClickListener(v -> {
            DataCache.get_instance().currentCityZip = 94117;
            DataCache.get_instance().currentCityName = "San Francisco";
            Intent cif = new Intent(getActivity(), CityInfoActivity.class);
            startActivity(cif);
        });

        Button chicagoButton = view.findViewById(R.id.chicagoButton);
        chicagoButton.setOnClickListener(v -> {
            DataCache.get_instance().currentCityZip = 60602;
            DataCache.get_instance().currentCityName = "Chicago";
            Intent cif = new Intent(getActivity(), CityInfoActivity.class);
            startActivity(cif);
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}