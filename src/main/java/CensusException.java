public class CensusException extends Exception{
    enum CensusExceptionType
    {
        INCORRECT_DATA_ISSUE,NO_SUCH_FILE, SOME_OTHER_IO_EXCEPTION, DELIMITER_ISSUE,  NO_SUCH_CLASS
    }
    CensusExceptionType type;
    private String message;

    public CensusException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}