package com.capgemini.drms.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
/** 
* @ClassName: FileUploadServlet 
* @Description: upload person face picture 
* @author winson luo
* @date Feb 14, 2017 11:50:11 AM 
*  
*/
public class FileUploadUtil {
	private static final long serialVersionUID = 1L;  
	  
/*    public static String upload(HttpServletRequest request) throws ServletException, IOException {  
          
        String fileName = null;  
        String realPath=null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
        
        
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        ServletContext servletContext = request.getServletContext();  
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");  
        factory.setRepository(repository);  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {  
            List<FileItem> items = upload.parseRequest(request);  
            for(FileItem item : items) {  
                String type = item.getContentType();  
                if(type == null) {  
                    continue;  
                }   
                fileName = item.getName();  
                String path = request.getServletContext().getRealPath("/");
                realPath=path.substring(0, path.indexOf("DRMS"))+"DrmsStaticResource/images";
                File dir = new File(realPath);  
                File f = new File(dir, fileName);  
                if(!f.exists()) {  
                	f.createNewFile();  
                    item.write(f); 
                }  
                       
            }  
        } catch (FileUploadException e) {  
              
        } catch (Exception e) {  
             
        }  
        return fileName;  
    } */ 
	public static String upload(HttpServletRequest request) throws ServletException, IOException {
		String fileName = null;  
        String realPath=null;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			Iterator<String> ite = multiRequest.getFileNames();
			while(ite.hasNext()){
				MultipartFile file = multiRequest.getFile(ite.next());
				if(file!=null){
					fileName = file.getOriginalFilename();
					String path = request.getServletContext().getRealPath("/");
	                realPath=path.substring(0, path.indexOf("DRMS"))+"DrmsStaticResource/images";
					File localFile = new File(realPath,file.getOriginalFilename());
					try {
						file.transferTo(localFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return fileName; 
    }  
    
}
