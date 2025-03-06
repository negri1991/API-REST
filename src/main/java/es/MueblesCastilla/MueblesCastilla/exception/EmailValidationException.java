package es.MueblesCastilla.MueblesCastilla.exception;

public class EmailValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailValidationException(){
        super("El email no tiene el formato requerido.");
    }
}
