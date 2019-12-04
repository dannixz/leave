package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.LeaveRecords;
import service.LeaveRecordsService;
import service.LeaveRecordsServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		String reason = request.getParameter("reason");
		LeaveRecordsService le = new LeaveRecordsServiceImpl();
		LeaveRecords leave = new LeaveRecords();
		leave.setLeaveTime(time);
		leave.setName(name);
		leave.setReason(reason);
		int num= le.AddLeave(leave);
		if (num > 0) {
			out.print("<script>alert('添加成功！');location.href='ShowServlet';</script>");
		} else {
			out.print("<script>alert('添加失败！');location.href='addLeave.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
