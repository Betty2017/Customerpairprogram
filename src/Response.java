

import java.io.IOException;
import java.util.Scanner;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Response
 */
@WebServlet("/Response")
public class Response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Response() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

			
		int number = Integer.parseInt(request.getParameter("number"));
		System.out.print("The number is" );
		System.out.println(number);
		String sql=null; 
		String LastName = request.getParameter("LastName");
		System.out.print("The last name is " );
		System.out.println(LastName);
		
		if (number ==1){
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			sql = "select * from customers where LastName='"+LastName+"'";
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/Customers?"
						+ "user=root&password=password");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					String[] vals=new String[12];

					for(int i=0;i<vals.length;i++)
					{
						vals[i]=rs.getString(i+1);
						System.out.print(vals[i] + "\t");

					}


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
					String message6= "Press (1) to search for another customer or press (2) to Edit the customer's address.";


					request.setAttribute("message", message);
					request.setAttribute("message1", message1);
					request.setAttribute("message2", message2);
					request.setAttribute("message3", message3);
					request.setAttribute("message4", message4);
					request.setAttribute("message5", message5);

					request.setAttribute("message6", message6);

					getServletContext().getRequestDispatcher(nextURL).forward(request,response);
				}
			}
			catch(Exception e){System.out.println(e);

			}



		}

		
		if (number ==2)
		{
				
			Connection con=null; 
			ResultSet rs = null;
			
			
			
	
       
        
   
	
			Scanner sc = new Scanner(System.in);
		
			
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost/Customers?"+ "user=root&password=password");
			
				String[] vals=new String[12];
				/*					
				for(int i=0;i<vals.length;i++)
				{
					vals[i]=rs.getString(i+1);
					System.out.print(vals[i] + "\t");
					
				} 
				
			*/
				
		
     		
				System.out.println("Please input desired Address. If no change enter 'N'");
				String add=sc.nextLine();
				
				if(!add.equalsIgnoreCase("N"))
				{
					vals[4]=add;
				}
				System.out.println("Please input desired City. If no change enter 'N'");
				String city=sc.nextLine();
				
				if(!city.equalsIgnoreCase("N"))
				{
					vals[5]=city;
				}
				System.out.println("Please input desired State. If no change enter 'N'");
				String state=sc.nextLine();
				
				if(!state.equalsIgnoreCase("N"))
				{
					vals[6]=state;
				}
				System.out.println("Please input desired ZIP. If no change enter 'N'");
				String zip=sc.nextLine();
				
				if(!zip.equalsIgnoreCase("N"))
				{
					vals[7]=zip;
				}
				
				sql =("UPDATE from customers SET StreetAddress = ?, City = ?, State = ?, ZipCode=? where LastName='"+LastName+""); 
		            
		        PreparedStatement  preparedStmt;
		     	preparedStmt = con.prepareStatement(sql);
		     	
				  
     		
     		
		     	preparedStmt.setString(1, add);
		     	preparedStmt.setString(2, city);
		     	preparedStmt.setString(3, state);
		     	preparedStmt.setString(4, zip);
		     	
		     	preparedStmt.executeUpdate();
     		    		
     		
     	
			/*
					System.out.println("The Updated result is ");
					for(int i=0;i<1;i++)
					{
						System.out.print("Customer Number:"+vals[11] + "\n");
						System.out.print(vals[1] +" "+ vals[0]+"\n");
						System.out.print(vals[4] +"\n");
						System.out.print(vals[5] +" "+ vals[6]+vals[7]+"\n");
						System.out.print(vals[8]+"\n");
						System.out.print(vals[9] +" at "+ vals[10]+"\n\n");
						
						
					}
					
					
				*/	
					
					System.out.println("Thank You good bye!");
					
		}
					
				
			
			
		catch(Exception e){
			System.out.println(e);
		
		}
		finally
		{
			
		}
		
	}}
}
		
	
	


