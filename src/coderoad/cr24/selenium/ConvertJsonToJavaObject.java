package coderoad.cr24.selenium;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import coderoad.cr24.exception.JsonException;
import coderoad.cr24.model.JsonSelenium;
import static coderoad.cr24.utils.UtilsMethods.*;


public class ConvertJsonToJavaObject {
	
	private String filePath;
		
	public ConvertJsonToJavaObject(){
	}	
	
	public ConvertJsonToJavaObject(String filePath){
		this.filePath=filePath;
	}	

	
	public JsonSelenium convertJsonToJavaObject(String filePath){

		ObjectMapper mapper=new ObjectMapper();
		JsonSelenium jsonSelenium=null;
		try {
			jsonSelenium = mapper.readValue(new File(PATH_FILE_JSON), JsonSelenium.class);
			//jsonSelenium = mapper.readValue(filePath,JsonSelenium.class);
			String jsonString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSelenium);
			checkValidJson(jsonString);
			System.out.println(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonSelenium;
	}	
	
	
    private void checkValidJson(final String json) throws JsonException{
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
