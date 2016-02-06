package try_It.lesson10.errorHandling;

public class TooManyBikesException extends Exception {

	TooManyBikesException(String msgText)
	{
		super(msgText);
	}
}
