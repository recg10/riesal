package cl.devap.ict.exception;


/**
 * 
 * Excepción que permite manejar las condiciones de error a nivel de sistema que se produzcan en el
 * Sistema PP.FF.
 * 
 * @author INDRA
 *
 */
public class RuntimeIctException extends IctException {

	private static final long serialVersionUID = 1L;

	public RuntimeIctException(IctExceptionEnum ppffExceptionEnum, Throwable cause) {
		super(ppffExceptionEnum, cause);
	}
	
	public RuntimeIctException(IctExceptionEnum ppffExceptionEnum, Throwable cause, String... parameters) {
		super(ppffExceptionEnum, cause, parameters);
	}

}
