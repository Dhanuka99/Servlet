package lk.ijse.javaee.sarvlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;


@MultipartConfig
@WebServlet(urlPatterns = "/up")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("rrrrrrr");
        //java EE file upload method is getPart(); file content or byte cases
        Part file = req.getPart("uploader");

        String submittedFileName = file.getSubmittedFileName();
        System.out.println(submittedFileName);
        String realPath = getServletContext().getRealPath("");

        InputStream inputStream = file.getInputStream();

        File file1 = new File(realPath + File.separator + submittedFileName);
        file1.createNewFile();

        FileOutputStream out = new FileOutputStream(file1);

        int read;
        byte[] buffer = new byte[1024];
        while ((read=inputStream.read(buffer,0,buffer.length))!=-1){
            out.write(buffer,0,buffer.length);
        }
        out.close();
    }
}
