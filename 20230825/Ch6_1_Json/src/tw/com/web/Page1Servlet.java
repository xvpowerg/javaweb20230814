package tw.com.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = "{\r\n" + 
				"     \"firstName\": \"John\",\r\n" + 
				"     \"lastName\": \"Smith\",\r\n" + 
				"     \"sex\": \"male\",\r\n" + 
				"     \"age\": 25,\r\n" + 
				"     \"address\": \r\n" + 
				"     {\r\n" + 
				"         \"streetAddress\": \"21 2nd Street\",\r\n" + 
				"         \"city\": \"New York\",\r\n" + 
				"         \"state\": \"NY\",\r\n" + 
				"         \"postalCode\": \"10021\"\r\n" + 
				"     },\r\n" + 
				"     \"phoneNumber\": \r\n" + 
				"     [\r\n" + 
				"         {\r\n" + 
				"           \"type\": \"home\",\r\n" + 
				"           \"number\": \"212 555-1234\"\r\n" + 
				"         },\r\n" + 
				"         {\r\n" + 
				"           \"type\": \"fax\",\r\n" + 
				"           \"number\": \"646 555-4567\"\r\n" + 
				"         }\r\n" + 
				"     ]\r\n" + 
				" }";
		System.out.println(json);
		ObjectMapper objMapper =  new ObjectMapper();
		Map map = objMapper.readValue(json, Map.class);
		System.out.println(map);
		System.out.println(map.get("lastName"));
		Map addressMap = (Map)map.get("address");
		System.out.println(addressMap.get("streetAddress"));
	}
}
