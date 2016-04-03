package core;

import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dineshgurumurthy on 3/25/16.
 */
public class AbstractTest {

    protected Path parentDir;

    @Before
    public void beforeTest() {
        String unixFilePath = "/Users/dineshgurumurthy/dev/coursera/resources/algs4-data/";
        String windowsFilePath = "C:\\Users\\dinesh\\dev\\java\\resources\\algs4-data\\";

        Path unixPath = Paths.get(unixFilePath);
        Path windowsPath = Paths.get(windowsFilePath);
        if (Files.exists(unixPath)) {
            parentDir = unixPath;
        } else if (Files.exists(windowsPath)) {
            parentDir = windowsPath;
        }
    }

    protected String getFilePath(String filePath) {
        return parentDir + (OSValidator.isWindows() ? "\\" : "/") + filePath;
    }

}
