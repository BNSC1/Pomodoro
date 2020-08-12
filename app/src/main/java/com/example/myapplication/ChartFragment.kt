package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.LineData


/**
 * A simple [Fragment] subclass.
 */
class ChartFragment : Fragment() {
    var chart: BarChart? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chart=getView()?.findViewById(R.id.chart) as BarChart
        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(0f,30f))
        entries.add(BarEntry(0f, 30f))
        var lineData=LineData(dataSet)
    }
}