/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebeans;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author julia
 */
@Named(value = "chartBean")
@RequestScoped
public class chartBean {
    private LineChartModel model;

    /**
     * Creates a new instance of chartBean
     */
    public chartBean() {
        model = new LineChartModel();
        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("SIN");    
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("COS");
        
        for(Integer i=0; i <= 360; i+=10){
            series1.set(i, sin( Math.toRadians(i)));
            series2.set(i, cos( Math.toRadians(i)));
        }

        model.addSeries(series1);
        model.addSeries(series2);
        model.setTitle("Sin & Cos <0;360>");
        model.setLegendPosition("e");
        model.setZoom(true);
        
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(360);
        xAxis.setTickInterval("10");        
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(-1);
        yAxis.setMax(1);
    }

    /**
     * @return the model
     */
    public LineChartModel getModel() {
        return model;
    }
}
