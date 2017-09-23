import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileToMatrix{

    int[] puzzleArr;
    public FileToMatrix(String fileName) {
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            ArrayList<Integer> puzzle = new ArrayList<Integer>();

            while((line = bufferedReader.readLine()) != null)
            {
                //Split the line of values into seperate strings of ints
                String[] values = line.split(" ");

                if(values.length >= 5)
                {
                //For loop for parsing each of the strings to Integers
                for(int i =0; i < values.length; i++)
                  puzzle.add(Integer.parseInt(values[i]));
                }//accounting for both file formats
            }

            // convert it to array of Integer since we can't have ArrayList<int> :(
            Integer[] intArray = puzzle.toArray(new Integer[puzzle.size()]);
            //Some weird Java 8 magic going on here...
            puzzleArr = Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +
                fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + fileName + "'");
        }
    }
    /*
    For testing can be removed
    public void printPuzzleArr(){
      for(int i = 0; i < puzzleArr.length; i++)
        System.out.println(puzzleArr[i] + "");
    }
    */
    public int[] getPuzzleArr(){
      return puzzleArr;
    }

    public static void main(String[] args)
    {
      FileToMatrix fm = new FileToMatrix("./userPuzzles/assignmentPuzzle.txt");
    }
}/*Reference: https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
              https://stackoverflow.com/questions/6881458/converting-a-string-array-into-an-int-array-in-java
 */
