/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jhovarie
 */
@WebServlet(urlPatterns = {"/UploadDownloadFile"})
public class UploadDownloadFile extends HttpServlet {
    private final String currenthost = "http://192.168.1.62:8080";
    private final String currentuser = System.getProperty("user.name");
    private final String currentdir = System.getProperty("user.dir");
    private boolean isMultipart;
    //private int maxFileSize = 50 * 1024;
    // private int maxMemSize = 4 * 1024;
    private int maxFileSize = 500000 * 1024;
    private int maxMemSize = 40000 * 1024;
    private File file;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        /*
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadDownloadFile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadDownloadFile at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("--> doGet -->");
        String filePath;

        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            throw new ServletException("File Name can't be null or empty");
        }
        final String clientip = request.getRemoteAddr().replace(":", "_");
        filePath = "/Users/"+currentuser+"/GlassFish_Server/glassfish/domains/domain1/tmpfiles/Uploaded/" + clientip + "/";
        File file = new File(filePath + File.separator + fileName);

        System.out.println("download file = " + file);
        if (!file.exists()) {
            throw new ServletException("File doesn't exists on server.");
        }
        System.out.println("File location on server::" + file.getAbsolutePath());
        ServletContext ctx = getServletContext();
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;
        while ((read = fis.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("File downloaded at client successfully");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String filePath;
        final String clientip = request.getRemoteAddr().replace(":", "_");
        filePath = "/Users/"+currentuser+"/GlassFish_Server/glassfish/domains/domain1/tmpfiles/Uploaded/" + clientip + "/";
        System.out.println("filePath = " + filePath);
        // filePath = "/Users/jhovarie/Desktop/webuploaded/";
        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdirs();
        }

        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        //factory.setRepository(new File("c:\\temp"));
        factory.setRepository(new File(filePath));
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);
            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='" + currenthost + "/UploadDownloadFile/index.html'><< BACK <<</a><br/>");
            String fileName = "";
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    out.println("Uploaded Filename: " + fileName + "<br>");
                }
            }

            out.println("Target Location = " + filePath);
            out.write("<br/><a href=\"UploadDownloadFile?fileName=" + fileName + "\">Download " + fileName + "</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            System.out.println("Error in Process " + ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
