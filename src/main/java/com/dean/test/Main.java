package com.dean.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Main {

	public static void main(String[] args) {
		
		// Pass some parameters to the cover page
	    Map<String, Object> map = new HashMap<>();
	    map.put("orgName", "Sample Organization");
	    map.put("surveyName", "Sample Survey Name");
	    
	    // Create data for the table report
	    List<Object> tableDataList = new ArrayList<>();
	    tableDataList.add(new DataObject(1L, "Dean"));
	    tableDataList.add(new DataObject(2L, "Li"));
	    tableDataList.add(new DataObject(3L, "Emily"));
	    tableDataList.add(new DataObject(4L, "Kim"));
	    tableDataList.add(new DataObject(5L, "Mia"));
	    tableDataList.add(new DataObject(6L, "Liam"));
	    
	    List<Wrapper> tableData = new ArrayList<>();
	    tableData.add(new Wrapper(1L, "wrapper1", tableDataList));
	    
	    // Create data for the chart report
	    List<Object> chartDataList = new ArrayList<>();
	    chartDataList.add(new ChartDataObject("Title 1", 25, "Category1"));
	    chartDataList.add(new ChartDataObject("Title 2", 40, "Category1"));
	    chartDataList.add(new ChartDataObject("Title 3", 15, "Category1"));
	    chartDataList.add(new ChartDataObject("Title 4", 20, "Category1"));
	    
	    List<Wrapper> chartData = new ArrayList<>();
	    chartData.add(new Wrapper(2L, "wrapper2", chartDataList));
	    
	    try
	    {

	    	JasperReport jr1 = JasperCompileManager.compileReport("/Users/defrati/Documents/dev/stuff/cover.jrxml");
	    	JasperPrint jp1 = JasperFillManager.fillReport(jr1, map, new JREmptyDataSource());
	    	
	    	JasperReport jr2 = JasperCompileManager.compileReport("/Users/defrati/Documents/dev/stuff/tableTemplate.jrxml");
	    	JasperPrint jp2 = JasperFillManager.fillReport(jr2, new HashMap(), new JRBeanCollectionDataSource(tableData));
	    	
	    	JasperReport jr3 = JasperCompileManager.compileReport("/Users/defrati/Documents/dev/stuff/chartTemplate.jrxml");
	    	JasperPrint jp3 = JasperFillManager.fillReport(jr3, new HashMap(), new JRBeanCollectionDataSource(chartData));
	    	
	    	List pages = jp2.getPages();

            for (int j = 0; j < pages.size(); j++) {
            	JRPrintPage object = (JRPrintPage)pages.get(j);
            	jp1.addPage(object);
            }

	    	pages = jp3.getPages();

            for (int j = 0; j < pages.size(); j++) {
            	JRPrintPage object = (JRPrintPage)pages.get(j);
            	jp1.addPage(object);
            }
            
            //JasperViewer.viewReport(jp1,false);
            JasperExportManager.exportReportToPdfFile(jp1, "simple_report.pdf");
	    }
	    catch (JRException e)
	    {
	      e.printStackTrace();
	    }
	}
}
