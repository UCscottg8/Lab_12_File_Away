import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class JFileChooserDemo
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // This is a File object not a String filename

                System.out.println("Processing file: " + target);

                inFile = new Scanner(target);

                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);

                inFile.close();
            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // Code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}

