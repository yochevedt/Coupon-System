import java.util.logging.Level;



public  class Logger {
	
    public static Level level=Level.ALL;
    
    public static java.util.logging.Logger getLogger(){
    	final Throwable t = new Throwable();
    	final StackTraceElement methodCaller = t.getStackTrace()[1];
    	final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(methodCaller.getClassName());

    	return logger;
    	
    	
    }
	
	
	
}
