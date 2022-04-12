package com.example.crimereportapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChartDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChartDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChartDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment summary_chart.
     */
    // TODO: Rename and change types and number of parameters
    public static ChartDetailFragment newInstance(String param1, String param2) {
        ChartDetailFragment fragment = new ChartDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chart_detail, container, false);
//        AnyChartView summaryChart = view.findViewById(R.id.summary_chart);
////        anyChartView.setProgressBar(view.findViewById(R.id.summary_progress_bar));
//        APIlib.getInstance().setActiveAnyChartView(summaryChart);
//
//        Pie pie = AnyChart.pie();
//
////        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
////            @Override
////            public void onClick(Event event) {
////                Toast.makeText(PieChartActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        List<DataEntry> summaryData = new ArrayList<>();
//        data.add(new ValueDataEntry("Apples", 6371664));
//        data.add(new ValueDataEntry("Pears", 789622));
//        data.add(new ValueDataEntry("Bananas", 7216301));
//        data.add(new ValueDataEntry("Grapes", 1486621));
//        data.add(new ValueDataEntry("Oranges", 1200000));
//
//        pie.data(summaryData);
//
//        pie.title("Fruits imported in 2015 (in kg)");
//
//        pie.labels().position("outside");
//
//        pie.legend().title().enabled(true);
//        pie.legend().title()
//                .text("Retail channels")
//                .padding(0d, 0d, 10d, 0d);
//
//        pie.legend()
//                .position("center-bottom")
//                .itemsLayout(LegendLayout.HORIZONTAL)
//                .align(Align.CENTER);
//
//        summaryChart.setChart(pie);
        return view;
    }
}