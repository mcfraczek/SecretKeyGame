package test.java;

import main.java.logic.services.objectServices.markedLetter.SingleLetterSleepService;
import main.java.logic.services.objectServices.markedLine.MarkedLineObjectService;
import org.junit.Assert;
import org.junit.Test;

public class SingleLetterSleepServiceTest {

    @Test
    public void thereIsAMark() {
        MarkedLineObjectService service = new SingleLetterSleepService();
        String line = "njkasda<t=1000>njkdassdanjkasnjk<>nsajkdsa";
        String line2 = "njkasda<t=1000>njkdassdanjkasnjknsajkdsa";
        Assert.assertTrue(service.thereIsAMark(line));
        Assert.assertFalse(service.thereIsAMark(line2));
    }


}