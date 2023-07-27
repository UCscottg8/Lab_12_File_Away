import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class TextFiles
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src\\test.txt");
        // System.out.println("Path is: " + target);

        try  // Code that might trigger the exception goes here
        {
            inFile = new Scanner(target);

            while(inFile.hasNextLine())
            {
                line = inFile.nextLine();
                System.out.println(line);
            }

            inFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }


    }

}

