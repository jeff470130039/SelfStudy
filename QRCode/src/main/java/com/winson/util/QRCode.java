package com.winson.util;

import java.io.File;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCode {
	
	public static String buildQRCode(String text,String path){
        int width = 300;  
        int height = 300;   
        String format = "png";  
        HashMap hints = new HashMap();    
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        try {  
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE,width,height,hints);  
            File outputFile = new File(path+"."+format);  
            MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		return path+"."+format;
	}
	public static String readQRCode(){
		return null;
	}
	public static void main(String[] args){
		String text=" 简单点吧！";
		String path="D:\\toyou";
		System.out.println(buildQRCode(text,path));
	}
}
