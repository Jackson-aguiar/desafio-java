package exception;

public class VotacaoException extends RuntimeException {
    public VotacaoException(){
        super("Voto inválido");
    }
    public VotacaoException(String message){
        super(message);
    }
}
