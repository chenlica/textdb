package Engine.SchemaSupport.exception;

/*
 * Thrown to indicate that an exception occurs when constructing a query plan.
 */
public class PlanGenException extends AmberException {

    private static final long serialVersionUID = -9145104915599667725L;

    public PlanGenException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
    
    public PlanGenException(String errorMessage) {
        super(errorMessage);
    }
    
    public PlanGenException(Throwable throwable) {
        super(throwable);
    }

}
