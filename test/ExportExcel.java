package com.capgemini.drms.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.capgemini.drms.model.DrmsDemand;
/**
 * 
* @ClassName: ExportExcel 
* @Description: user the exit data export to excel 
* @author winson luo
* @date Jan 23, 2017 4:57:24 PM 
*
 */
public class ExportExcel {
		
	/**
	 * 	
	* @Title: export 
	* @Description: export the excel
	* @param @param list
	* @param @param fileName
	* @param @param headName
	* @param @param columsName
	* @param @param out   
	* @return void     
	* @throws
	 */
		
	public  void export(List<DrmsDemand> list,String fileName,String headName,String[] columsName,OutputStream out){
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("Demand");
		HSSFCellStyle cellStyle = workbook.createCellStyle(); 
		int colsum=columsName.length;
		
		sheet.setColumnWidth(0,20*256);
		sheet.setColumnWidth(1,15*256);
		sheet.setColumnWidth(2,15*256);
		sheet.setColumnWidth(3,10*256);
		sheet.setColumnWidth(4,15*256);
		sheet.setColumnWidth(5,21*256);
		sheet.setColumnWidth(6,20*256);
		sheet.setColumnWidth(7,20*256);
		sheet.setColumnWidth(8,22*256);
		sheet.setColumnWidth(9,20*256);
		sheet.setColumnWidth(10,20*256);
		sheet.setColumnWidth(11,20*256);
		sheet.setColumnWidth(12,20*256);
		sheet.setColumnWidth(13,20*256);
		
		
		
		
		
		//create title
	/*	HSSFRow row=sheet.createRow((short)0);
		row.setHeight((short)600); 
		HSSFCell cell=row.createCell(0);
		cell.setCellValue(new HSSFRichTextString(headName));
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		sheet.addMergedRegion(new CellRangeAddress((short)0, (short) 0,(short) 0, (short) colsum-1));
		HSSFCellStyle cellStyle = this.buildCellStyle(workbook,(short)300,HSSFFont.BOLDWEIGHT_BOLD);   
        cell.setCellStyle(cellStyle);*/
        
        
        
		//create columsTitle
		HSSFRow row1 = sheet.createRow((short)0);
		HSSFCellStyle columTitleCellStyle =this.buildCellStyle(workbook,(short)190,HSSFFont.BOLDWEIGHT_BOLD,cellStyle);  
		for (int i = 0; i < columsName.length; i++) {
			sheet.autoSizeColumn((short)i);
			HSSFCell columTitleCell=row1.createCell(i);
			columTitleCell.setCellType(HSSFCell.ENCODING_UTF_16);
			columTitleCell.setCellValue(new HSSFRichTextString(columsName[i]));
			columTitleCell.setCellStyle(columTitleCellStyle);
		}
		
		
		//build the excel body
		for (int i = 0; i < list.size(); i++) {
			HSSFRow countRow=sheet.createRow((short)(i+1));
			HSSFCell cell0=countRow.createCell(0);
			cell0.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell0.setCellType(HSSFCell.ENCODING_UTF_16);
			cell0.setCellValue(new HSSFRichTextString(list.get(i).getDmdShowId()));
			
			HSSFCell cell1=countRow.createCell(1);
			cell1.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell1.setCellType(HSSFCell.ENCODING_UTF_16);
			cell1.setCellValue(list.get(i).getDrmsOpp().getOppId());
			
			HSSFCell cell2=countRow.createCell(2);
			cell2.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell2.setCellType(HSSFCell.ENCODING_UTF_16);
			cell2.setCellValue(list.get(i).getDrmsResource().getResourceName());
			
			HSSFCell cell3=countRow.createCell(3);
			cell3.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell3.setCellType(HSSFCell.ENCODING_UTF_16);
			cell3.setCellValue(list.get(i).getDrmsSite().getSiteName());
			
			HSSFCell cell4=countRow.createCell(4);
			cell4.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell4.setCellType(HSSFCell.ENCODING_UTF_16);
			cell4.setCellValue(list.get(i).getDrmsDesigation().getDsgName());
			
			HSSFCell cell5=countRow.createCell(5);
			cell5.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell5.setCellType(HSSFCell.ENCODING_UTF_16);
			cell5.setCellValue(list.get(i).getDmdAlterdsg());
			
			HSSFCell cell6=countRow.createCell(6);
			cell6.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell6.setCellType(HSSFCell.ENCODING_UTF_16);
			cell6.setCellValue(list.get(i).getDmdProjName());
			
			HSSFCell cell7=countRow.createCell(7);
			cell7.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell7.setCellType(HSSFCell.ENCODING_UTF_16);
			cell7.setCellValue(list.get(i).getDmdPosition());
			
			HSSFCell cell8=countRow.createCell(8);
			cell8.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell8.setCellType(HSSFCell.ENCODING_UTF_16);
			cell8.setCellValue(list.get(i).getDrmsAssCapability().getCapName());
			
			HSSFCell cell9=countRow.createCell(9);
			cell9.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell9.setCellType(HSSFCell.ENCODING_UTF_16);
			cell9.setCellValue(list.get(i).getDrmsCapability().getCapName());
			
			HSSFCell cell10=countRow.createCell(10);
			cell10.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell10.setCellType(HSSFCell.ENCODING_UTF_16);
			cell10.setCellValue(list.get(i).getDrmsAllocationType().getAtpName());
			
			HSSFCell cell11=countRow.createCell(11);
			cell11.setCellStyle(this.buildCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell11.setCellType(HSSFCell.ENCODING_UTF_16);
			cell11.setCellValue(list.get(i).getDmdAllocRatio());
			
			HSSFCell cell12=countRow.createCell(12);
			cell12.setCellStyle(this.dateCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell12.setCellType(HSSFCell.ENCODING_UTF_16);
			cell12.setCellValue(list.get(i).getStartDate());
			
			HSSFCell cell13=countRow.createCell(13);
			cell13.setCellStyle(this.dateCellStyle(workbook,(short)200,HSSFFont.BOLDWEIGHT_NORMAL,cellStyle));
			cell13.setCellType(HSSFCell.ENCODING_UTF_16);
			cell13.setCellValue(list.get(i).getEndDate());
			
		}
		this.writeIntoExcel(workbook,fileName,out);
		
	}
	/**
	 * 
	* @Title: buildCellStyle 
	* @Description: the normel cellstyle
	* @param @param workbook
	* @param @param i
	* @param @param boldweight
	* @param @return     
	* @return HSSFCellStyle     
	* @throws
	 */
	
	public  HSSFCellStyle buildCellStyle(HSSFWorkbook workbook,short i,short boldweight,HSSFCellStyle cellStyle){
		
	    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    //set the bgcolor
	    //cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);  
	    //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    //set the cell border
	    cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    
	    
	    //cellStyle.setWrapText(true); 
	    HSSFFont font = workbook.createFont();  
	    font.setBoldweight(boldweight);  
	    font.setFontName("Arial");  
	    font.setFontHeight(i);  
	    cellStyle.setFont(font);  
	    return cellStyle;
	}
	
	
	/**
	 * 
	* @Title: dateCellStyle 
	* @Description: the date cell style 
	* @param @param workbook
	* @param @param i
	* @param @param boldweight
	* @param @return    
	* @return HSSFCellStyle    
	* @throws
	 */
	public HSSFCellStyle dateCellStyle(HSSFWorkbook workbook,short i,short boldweight,HSSFCellStyle cellStyle){
		HSSFDataFormat format= workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("dd,mmm,yyy"));
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    //set the bgcolor
	    //cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);  
	    //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    //set the cell border
	    cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    
	    
	    //cellStyle.setWrapText(true); 
	    HSSFFont font = workbook.createFont();  
	    font.setBoldweight(boldweight);  
	    font.setFontName("Arial");  
	    font.setFontHeight(i);  
	    cellStyle.setFont(font);  
	    return cellStyle;
	}
	
	/**
	 * 
	* @Title: writeIntoExcel 
	* @Description: write the stream into excel
	* @param @param wb
	* @param @param filename
	* @param @param out     
	* @return void     
	* @throws
	 */
	public void writeIntoExcel(HSSFWorkbook wb,String filename,OutputStream out){
		try {
			wb.write(out);
			out.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
	}

	
	
}
