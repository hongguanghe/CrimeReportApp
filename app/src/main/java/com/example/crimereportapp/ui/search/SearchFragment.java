package com.example.crimereportapp.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.crimereportapp.CityInfoFragment;
import com.example.crimereportapp.R;
import com.example.crimereportapp.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {

//    private FragmentSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        TextView sample = view.findViewById(R.id.text_home);
        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityInfoFragment cif = new CityInfoFragment();
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.nav_host_fragment_activity_main, cif).commit();
            }
        });

        return view;
//        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}