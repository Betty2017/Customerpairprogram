
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);

		String LastName = request.getParameter("LastName");
			System.out.print("The last name is" );
			System.out.println(LastName);
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select * from customers where LastName='"+LastName+"'";
			try{
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/Customers?"
	                                + "user=root&password=password");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					String[] vals=new String[12];
					//ArrayList<String> vals= new ArrayList<String>();
					int count=1;
					
					
					for(int i=0;i<vals.length;i++)
					{
						vals[i]=rs.getString(i+1);
						System.out.print(vals[i] + "\t");
						
					}
					count++;

					System.out.println(vals.length);
					
					String nextURL ="/output.jsp";
					String message ="<h1>Customer ID is "+ vals[11]+"</h1>";
					message += "<table>";
					
					message += "<tr> <td>"+vals[1]+"</td></tr>";
					
					message += "</table>";
					String message1 =vals[1] +" "+ vals[0]+"\n";
					String message2 =vals[4];
					String message3= vals[5]+vals[6]+vals[7];
					String message4 = vals[8];
					String message5= vals[9]+ vals[10];
					
					
					
					request.setAttribute("message", message);
					request.setAttribute("message1", message1);
					request.setAttribute("message2", message2);
					request.setAttribute("message3", message3);
					request.setAttribute("message4", message4);
					request.setAttribute("message5", message5);
					
					getServletContext().getRequestDispatcher(nextURL).forward(request,response);
				}
				}
			catch(Exception e){System.out.println(e);
			
			}
			
			
			
		}

	//public void printList (ArrayList<vals> list){
		//for(vals elem : list){
			//System.out.println(elem + " ");
		
	}
	
	



