import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class gwt_class_39 {
	public static class ReportsServiceImpl extends RemoteServiceServlet {
	    public String myMethod(String s) {

	        File f = new File("/excelTestFile.xls");

	        String filename = f.getName();

	        int length = 0;

	        try {
	            HttpServletResponse resp = getThreadLocalResponse();
	            ServletOutputStream op = resp.getOutputStream();
	            ServletContext context = getServletContext();
	            resp.setContentType("application/octet-stream");
	            resp.setContentLength((int) f.length());
	            resp.setHeader("Content-Disposition", "attachment; filename*=\"utf-8''" + filename + "");

	            byte[] bbuf = new byte[1024];
	            DataInputStream in = new DataInputStream(new FileInputStream(f));

	            while ((in != null) && ((length = in.read(bbuf)) != -1)) {
	                op.write(bbuf, 0, length);
	            }

	            in.close();
	            op.flush();
	            op.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        return "Server says: " + filename;
	    }
	}
}