package com.capgemini.drms.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	/**
	 * @Title: writExcel
	 * @author winson luo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param datas 表格里面数据
	 * @param @param columNames 表格的列名
	 * @param @param fileName 下载的文件的将显示的文件名
	 * @param @param sheetName Excel的sheet 显示的名字
	 * @param @param resp 返回给前端 的文件下载
	 * @return void 返回类型
	 * @throws
	 */
	public static void writExcel(List<List<Object>> datas, String[] columNames,
			String fileName, String sheetName, HttpServletResponse resp) {
		try {
			OutputStream out = resp.getOutputStream();
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/x-download");
			resp.setHeader("Content-Disposition", "attachment;filename="
					+ fileName);
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(sheetName);
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			int rownums = 0;
			HSSFRow row1 = sheet.createRow((short) rownums);
			HSSFCellStyle columTitleCellStyle = stringCellStyle(workbook,
					(short) 190, HSSFFont.BOLDWEIGHT_BOLD, cellStyle);
			for (int i = 0; i < columNames.length; i++) {
				sheet.autoSizeColumn((short) i);
				HSSFCell columTitleCell = row1.createCell(i);
				columTitleCell.setCellType(HSSFCell.ENCODING_UTF_16);
				columTitleCell.setCellValue(new HSSFRichTextString(
						columNames[i]));
				columTitleCell.setCellStyle(columTitleCellStyle);
			}
			rownums++;
			for (int i = 0; i < datas.size(); i++) {
				HSSFRow datarow = sheet.createRow((short) rownums);
				rownums++;
				List<Object> innerlist = datas.get(i);
				int cellnum = 0;
				for (Object object : innerlist) {
					if (object!=null) {
						String datatype = object.getClass().toString();
						HSSFCell cell = datarow.createCell(cellnum);
						sheet.autoSizeColumn(cellnum);
						cellnum++;
						judgeCell(workbook, (short) 200,HSSFFont.BOLDWEIGHT_NORMAL, cellStyle, datatype, cell,object);
					}else {
						HSSFCell cell = datarow.createCell(cellnum);
						sheet.autoSizeColumn(cellnum);
						cellnum++;
						object="";
						buildStringCell(cell, object, workbook,(short) 200, HSSFFont.BOLDWEIGHT_NORMAL,cellStyle);
					}
					
					

				}
			}
			workbook.write(out);
			out.close();

		} catch (IOException e) {

		}

	}

	public static void buildStringCell(HSSFCell cell, Object object,HSSFWorkbook workbook,
			short i, short boldweight, HSSFCellStyle cellStyle) {
		cell.setCellStyle(stringCellStyle(workbook, (short) 200,HSSFFont.BOLDWEIGHT_NORMAL, cellStyle));
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(object.toString());
	}

	public static void buildDateCell(HSSFCell cell, Object object,HSSFWorkbook workbook,
			short i, short boldweight, HSSFCellStyle cellStyle) {
		cell.setCellStyle(dateCellStyle(workbook, (short) 200,HSSFFont.BOLDWEIGHT_NORMAL, cellStyle));
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(((Date) object));
	}

	public static void judgeCell(HSSFWorkbook workbook,short i, short boldweight, HSSFCellStyle cellStyle, String datatype,HSSFCell cell,Object object) {
		int ii = datatype.lastIndexOf(".");
		String key = datatype.substring(ii + 1, datatype.length());
		switch (key) {
		case "String":
			buildStringCell(cell,object,workbook, (short) 200,HSSFFont.BOLDWEIGHT_NORMAL, cellStyle);
			 break;
		case "Date":
			buildDateCell(cell,object,workbook, (short) 200,HSSFFont.BOLDWEIGHT_NORMAL, cellStyle);
			 break;
		default:
			buildStringCell(cell,object,workbook, (short) 200,HSSFFont.BOLDWEIGHT_NORMAL, cellStyle);
			 break;
		}

	}

	public static HSSFCellStyle stringCellStyle(HSSFWorkbook workbook, short i,
			short boldweight, HSSFCellStyle cellStyle) {

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// set the bgcolor
		// cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		// cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// set the cell border
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// cellStyle.setWrapText(true);
		HSSFFont font = workbook.createFont();
		font.setBoldweight(boldweight);
		font.setFontName("Arial");
		font.setFontHeight(i);
		cellStyle.setFont(font);
		return cellStyle;
	}

	public static HSSFCellStyle dateCellStyle(HSSFWorkbook workbook, short i,
			short boldweight, HSSFCellStyle cellStyle) {
		HSSFDataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("dd,mmm,yyy"));
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// set the bgcolor
		// cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		// cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// set the cell border
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// cellStyle.setWrapText(true);
		HSSFFont font = workbook.createFont();
		font.setBoldweight(boldweight);
		font.setFontName("Arial");
		font.setFontHeight(i);
		cellStyle.setFont(font);
		return cellStyle;
	}

}
