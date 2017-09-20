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

            while((line = bufferedReader.readLine()) != null) {
                // /System.out.println(line);
                String[] values = line.split(" ");
                for(int i =0; i < values.length; i++)
                {
                  //System.out.println(values[i]);
                  puzzle.add(Integer.parseInt(values[i]));
                }
            }

            //System.out.println("ArrayList size: " + puzzle.size());
            // convert it to array
            Integer[] intArray = puzzle.toArray(new Integer[puzzle.size()]);

            puzzleArr = Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();
            //int[]  puzzleArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
            //String [] countries = list.toArray(new String[list.size()]);

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
            // Or we could just do this:
            // ex.printStackTrace();
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
