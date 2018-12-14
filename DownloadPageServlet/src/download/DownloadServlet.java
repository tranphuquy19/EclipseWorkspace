package download;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet(name = "download", urlPatterns = { "/download" })
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		String fileName = "Oneindir.com-MTLB.R2018a.Win.rar";
		String filePath = "C:\\Users\\tranp\\Downloads\\Compressed\\";
		FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
		byte[] outputByte = new byte[6144];
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		//response.setContentLength(fileInputStream.available());

		while((fileInputStream.read(outputByte, 0, 6144)) != -1) out.write(outputByte, 0, 6144);
		fileInputStream.close();
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
