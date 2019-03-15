package customException;

public class UnsupportedBrowserException extends Exception{

	String message;
	public UnsupportedBrowserException(String message)
	{
		this.message=message;
	}
	
}
