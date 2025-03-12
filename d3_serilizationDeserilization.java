package restAssyred;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//poj-===SERILIZATION---->JSON Object-----DESERI------->POJO
public class d3_serilizationDeserilization {
	//@Test
	void CovertPojoToJson() throws JsonProcessingException
	{
		POJO_CLASS_serilization_desri data=new POJO_CLASS_serilization_desri();
		 data.setId(5);
		 data.setName("Kapil");
		 data.setPhone_number("1234567890");
		 data.setBranch("CSE");
		
		 
		 //convert java object -->json (SERILIZATION)
		 ObjectMapper objMapper=new ObjectMapper();
		 
		String jsondata= objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	
		System.out.println(jsondata);
	
	}
	
	@Test
	void CovertJsonToPojo() throws JsonProcessingException
	{
		POJO_CLASS_serilization_desri data=new POJO_CLASS_serilization_desri();
		 String jsondata="{\r\n"
		 		+ "  \"name\" : \"Kapil\",\r\n"
		 		+ "  \"id\" : 5,\r\n"
		 		+ "  \"phone_number\" : \"1234567890\",\r\n"
		 		+ "  \"branch\" : \"CSE\"\r\n"
		 		+ "}";
		
		 
		 //convert json to java object(pojo) (DESERILIZATION)
		 ObjectMapper objMapper=new ObjectMapper();
		 
		 POJO_CLASS_serilization_desri poj=objMapper.readValue(jsondata,POJO_CLASS_serilization_desri.class);
		System.out.println( poj.getId());
		System.out.println( poj.getBranch());
		 System.out.println(poj.getClass());
		System.out.println( poj.getPhone_number());
	}
}
