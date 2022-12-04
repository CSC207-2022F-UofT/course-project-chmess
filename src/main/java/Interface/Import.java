package Interface;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Import implements ImportInt{
    /**
     * Imports starting position from given file.
     *
     * @param fileName name of file from which to take starting position (must be located in Interface folder)
     */
    public String importGame (String fileName) {
        StringBuilder data = null;
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine().strip());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Check that file name is correct.");
            e.printStackTrace();
        }
        assert data != null;
        return data.toString();
    }
}