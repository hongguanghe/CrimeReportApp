package com.example.crimereportapp;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CityInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CityInfoFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    private int zipcode = 84604;
    private FragmentContainerView cornerLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CityInfoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CityInfoFragment newInstance(String param1, String param2) {
        CityInfoFragment fragment = new CityInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_info, container, false);

        AnyChartView anyChartView = view.findViewById(R.id.trend_chart);
        anyChartView.setProgressBar(view.findViewById(R.id.trend_progress_bar));
        cornerLayout = view.findViewById(R.id.fragmentContainerView);
        cornerLayout.setClipToOutline(true);

        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        for (int i = 12; i < 22; i++) {
            data.add(new ValueDataEntry(i, randomCrimeNumber()));
        }

        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: ,}");

        cartesian.animation(true);
//        cartesian.title("Top 10 Cosmetic Products by Revenue");

        cartesian.yScale().minimum(0d);


//        cartesian.yAxis(0).labels().format("{%Value / 100}{groupsSeparator: }");
        cartesian.yAxis(false);
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

//        cartesian.xAxis(0).title("Product");
//        cartesian.yAxis(0).title("Revenue");

        anyChartView.setChart(cartesian);
        return view;
    }

    private int randomCrimeNumber() {
        return new Random().nextInt(500000 - 100000) + 100000;
    }

}