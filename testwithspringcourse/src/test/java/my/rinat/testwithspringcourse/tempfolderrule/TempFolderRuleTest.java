package my.rinat.testwithspringcourse.tempfolderrule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

public class TempFolderRuleTest {

    @Rule
    public TemporaryFolder tempFolder = TemporaryFolder.builder()
            .assureDeletion()
            .build();

    @Test
    public void testRule() throws IOException {
        final var tempFile = tempFolder.newFile("myTempFile.txt");
        Assert.assertTrue(tempFile.isFile());
        Assert.assertEquals(tempFolder.getRoot().getAbsolutePath(), tempFile.getParentFile().getAbsolutePath());
    }
}
