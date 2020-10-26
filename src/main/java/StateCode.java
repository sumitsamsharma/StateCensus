import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
public class StateCode {

    @CsvBindByName(column = "SrNo")
    private String srNo;

    @CsvBindByName(column = "State",required = true)
    private String state;

    @CsvBindByName(column = "Name")
    private String Name;

    @CsvBindByName(column = "TIN", required = true)
    private String Tin;

    public StateCode() {

    }

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state=state;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setTin(String Tin) {
        this.Tin = Tin;
    }
    public String getTin() {
        return Tin;
    }



    @Override
    public String toString() {
        return  "srNo='" + srNo + '\'' +
                ", StateName='" + state + '\'' +
                ", Name='" + Name + '\'' +
                ", TIN ='" + Tin + '\'' +"\n";
    }
}

class StateCodeAnalyser {

    public StateCodeAnalyser() {
    }

    public static <E>  int openCsvBuilder(String csvFilePath, Object myClass) throws CensusException {
        int counter = 0;
        try {
            Iterator<Object> myIterator = getIterator(csvFilePath, myClass);
            while ( myIterator.hasNext() ) {
                counter++;
                Object myObj = myIterator.next();
            }
        } catch (CensusException e){
            throw e;
        } catch (RuntimeException e){
            throw new CensusException(CensusException.CensusExceptionType.DELIMITER_ISSUE,
                    "Error related to delimiter at record no. : " +(counter+1));
        }
        return counter;
    }

    public static Iterator<Object> getIterator(String csvFilePath, Object myClass) throws CensusException {
        Reader reader = null;
        CsvToBean<Object> csvToBean;
        try {
            reader = Files.newBufferedReader(Paths.get(csvFilePath));
            csvToBean = new CsvToBeanBuilder(reader).withType((Class) myClass).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<Object> iter= csvToBean.iterator();
            return iter;
        } catch (NoSuchFileException e) {
            throw new CensusException(CensusException.CensusExceptionType.NO_SUCH_FILE,
                    "file doesn't exists, Enter correct file");
        } catch (RuntimeException e){
            throw new CensusException(CensusException.CensusExceptionType.INCORRECT_DATA_ISSUE,
                    "delimiter error at line 1" +
                            "related to headers or incorrect extension / input file ");
        } catch (IOException e) {
            throw new CensusException(CensusException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION,
                    "Some other IO related exception");
        }
    }

}