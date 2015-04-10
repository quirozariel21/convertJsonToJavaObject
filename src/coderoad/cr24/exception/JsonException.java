package coderoad.cr24.exception;

public class JsonException extends Exception{
	
	public JsonException(){
		super();
	}
	
	public JsonException(String messagge){
		super(messagge);
	}

	public JsonException(Throwable causeBy){
		super(causeBy);
	}
	
	public JsonException(String message,Throwable causeBy){
		super(message,causeBy);
	}			
}
