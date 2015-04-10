package coderoad.cr24.main;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;










import coderoad.cr24.model.Cases;
import coderoad.cr24.model.JsonSelenium;
import coderoad.cr24.model.ListInspector;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.ListRecorder;
import coderoad.cr24.model.Target;

public class MainCR24 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		//jsonToObject();
		

		/*
		ObjectMapper mapper=new ObjectMapper();
		ListRecorder recorder=mapper.readValue(new File("C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json"), ListRecorder.class);
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(recorder));
		*/
		
		/*
		ObjectMapper mapper=new ObjectMapper();
		ListInspector inspector=mapper.readValue(new File("C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json"), ListInspector.class);
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inspector));
		*/
		ObjectMapper mapper=new ObjectMapper();
		JsonSelenium inspector=mapper.readValue(new File("C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json"), JsonSelenium.class);
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inspector));		
		
	}
	
	
	public static void jsonToObject(){
		
		System.out.println("Calling jsonToObject...");
		ObjectMapper objectMapper=new ObjectMapper();
		
		try{
			Recorder movimiento=objectMapper.readValue(new File("C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json"), Recorder.class);
			System.out.println("BaseUrl: "+movimiento.getBaseUrl());
			System.out.println("command: "+movimiento.getCommand());
			System.out.println("Target: "+movimiento.getTarget());
			System.out.println("Value: "+movimiento.getValue());
			
			System.out.println("************ JSON **********");
			System.out.println(movimiento);
			
		}catch(JsonGenerationException e){
			e.printStackTrace();
		}catch (JsonMappingException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
    private void checkValidJson(final String json) {
        try {
            final JsonParser parser = new ObjectMapper().getJsonFactory().createJsonParser(json);
            while (parser.nextToken() != null) {}
        } catch (JsonParseException jpe) {
            //throw new HubSpotConnectorException("The contactJson contains a JSON malformed", jpe);
        } catch (IOException ioe) {
            //throw new HubSpotConnectorException("The contactJson cannot be readed", ioe);
        }
    }	
	

}
