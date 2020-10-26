import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCodeAnalyserTest {
    public static final String STATECODE_CSVFILE= "C:\\Users\\sharm\\Desktop\\InteliJ\\StateCode.csv";
    public static final String WRONG_FILE = "/wrong.txt";
    @Test
    public void GivenStateCodesCsvFile_IfCorrectNumOfRecords_Should_ReturnTrue() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(STATECODE_CSVFILE, StateCode.class);
            System.out.println(count);
            Assert.assertEquals(29, count);
        } catch (CensusException e) {
            e.printStackTrace();
        }
    }
/*
    @Test
    public void GivenStateCensusCsvFile_If_DoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(WRONG_FILE, StateCode.class);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void GivenTheStateCensusCsvFile_FileExtIncorrect_ShouldThrow_CensusException() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(STATECODE_CSVFILE, StateCode.class);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }

    @Test
    public void GivenStateCensusCSVFile_DelimiterIncorrect_ReturnsCensusException() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(STATECODE_CSVFILE, StateCode.class);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.CensusExceptionType.DELIMITER_ISSUE, e.type);

        }
    }

 */

}