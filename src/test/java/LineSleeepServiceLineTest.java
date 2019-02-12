package test.java;

import main.java.logic.services.objectServices.markedLine.LineSleeepServiceLine;
import main.java.logic.services.objectServices.markedLine.MarkedLineObjectService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LineSleeepServiceLineTest {

    @Test
    void thereIsAMark() {
        MarkedLineObjectService markedLineObjectService = new LineSleeepServiceLine();
        Assert.assertTrue(markedLineObjectService.thereIsAMark("[5000]"));
        Assert.assertFalse(markedLineObjectService.thereIsAMark("[5000"));
    }
}