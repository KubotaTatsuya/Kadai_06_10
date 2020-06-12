package logic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.BBSbean;
import dao.BBSdao;

/**
 * Servlet implementation class BBStop
 */
@WebServlet("/BBStop")
@MultipartConfig(maxFileSize=1073741824)
public class BBStop extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBStop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String message = request.getParameter("message");
		Part file_in = request.getPart("file");
		String file = this.getFileName(file_in);
		if(file.equals("")){
			file=null;
		}else{
			file_in.write("C:\\pleiades\\workspace\\kadai_9\\WebContent\\upload\\" + file);

		}

		System.out.println(file);
		BBSbean s;
		if(name != null || mail!=null || message!=null || file!=null){
			s = new BBSbean(name,mail,message,file);
			BBSdao.insertComment(s);
		}
		ArrayList<BBSbean> array=BBSdao.selectAllComment();
		session.setAttribute("list",array);
		response.sendRedirect("http://localhost:8080/kadai_9");

	}
	private String getFileName(Part file_in) {
		String file_name = null;
		for (String dispotion : file_in.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				file_name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				file_name = file_name.substring(file_name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return file_name;
	}
}
