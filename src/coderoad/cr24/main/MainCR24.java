package coderoad.cr24.main;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;











import coderoad.cr24.exception.JsonException;
import coderoad.cr24.model.Cases;
import coderoad.cr24.model.JsonSelenium;
import coderoad.cr24.model.ListInspector;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.ListRecorder;
import coderoad.cr24.model.Target;

public class MainCR24 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		String filePath="C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json";
		convertJsonToJavaObject(filePath);		
	}
	
	
	public static void convertJsonToJavaObject(String filePath){

		ObjectMapper mapper=new ObjectMapper();
		JsonSelenium inspector;
		try {
			inspector = mapper.readValue(new File("C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json"), JsonSelenium.class);
			String jsonString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inspector);
			checkValidJson(jsonString);
			System.out.println(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	
	
    public static void checkValidJson(final String json) throws JsonException{
        try {
            final JsonParser parser = new ObjectMapper().getJsonFactory().createJsonParser(json);
            while (parser.nextToken() != null) {}
        } catch (JsonParseException jpe) {
        	throw new JsonException("The contactJson contains a JSON malformed", jpe);
        } catch (IOException ioe) {            //
        	throw new JsonException("The contactJson cannot be readed", ioe);
        }
    }	
	

}
