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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Align;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.LegendLayout;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.crimereportapp.data.DataCache;

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

        DataCache dataCache = DataCache.get_instance();
        zipcode = dataCache.currentCityZip;
        TextView scoreText = view.findViewById(R.id.score_text);
        ImageView scoreBackground = view.findViewById(R.id.score_background);

        int score = randomCrimeScore();
        scoreText.setText(String.valueOf(score));

        if (score >= 80) {
            scoreBackground.setImageResource(R.drawable.score_circle);
        }
        else if (score >= 60) {
            scoreBackground.setImageResource(R.drawable.score_circle_risky);
        }
        else {
            scoreBackground.setImageResource(R.drawable.score_circle_dangerous);
        }


        AnyChartView anyChartView = view.findViewById(R.id.trend_chart);
        APIlib.getInstance().setActiveAnyChartView(anyChartView);

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



        AnyChartView summaryChart = view.findViewById(R.id.summary_chart);
        anyChartView.setProgressBar(view.findViewById(R.id.summary_progress_bar));
        APIlib.getInstance().setActiveAnyChartView(summaryChart);

        Pie pie = AnyChart.pie();

//        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
//            @Override
//            public void onClick(Event event) {
//                Toast.makeText(PieChartActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
//            }
//        });

        String[] crimeTypes = new String[] {
                "Assault",
                "Burglary",
                "Larceny",
                "Homicide",
                "Rape",
                "Robbery",
                "Arson",
                "Violent",
                "Theft"
        };

        List<DataEntry> summaryData = new ArrayList<>();

        for (String crimeType : crimeTypes) {
            summaryData.add(new ValueDataEntry(crimeType, randomCrimeNumberBasedOnType()));
        }

        pie.data(summaryData);

//        pie.title("Fruits imported in 2015 (in kg)");

        pie.labels().position("inside");
        pie.legend().enabled(false);

//        pie.legend().title().enabled(true);
//        pie.legend().title()
//                .text("Retail channels")
//                .padding(0d, 0d, 10d, 0d);

//        pie.legend()
//                .position("center-bottom")
//                .itemsLayout(LegendLayout.HORIZONTAL)
//                .align(Align.CENTER);

        summaryChart.setChart(pie);


        return view;
    }

    private int randomCrimeNumber() {
        return new Random().nextInt(500000 - 100000) + 100000;
    }

    private int randomCrimeNumberBasedOnType() {
        return new Random().nextInt(100000 - 1000) + 1000;
    }

    private int randomCrimeScore() {
        return new Random().nextInt(100 - 5) + 5;
    }


}