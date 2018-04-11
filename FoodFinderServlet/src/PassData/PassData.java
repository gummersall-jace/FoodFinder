package PassData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class PassData
 */
@WebServlet("/PassData")
public class PassData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getOutputStream().println("Hurray !! This Servlet Works");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   try{
	        BufferedReader br = request.getReader();
	        String str = br.readLine();
	        System.out.println(str);
	        
	        JSONParser parser = new JSONParser();
	        JSONObject json = (JSONObject) parser.parse(str);
	        
	        UserInfo user = new UserInfo(); 
	        
	        user.setFirstName((String) json.get("FirstName"));
	        user.setLastName((String) json.get("LastName"));
	        user.setEmail((String) json.get("Email"));
	        user.setCity((String) json.get("City"));
	        LocalDateTime today = LocalDateTime.now();
	        
	        WriteUserInfo write = new WriteUserInfo();
	        write.addUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getCity(), today);
	        
            OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
            writer.write("Done");
            writer.flush();
            writer.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	}

}
