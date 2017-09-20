import java.io.*;
import java.util.*;

public class Task {

    private BufferedReader input;
    private PrintWriter output;
    private StringTokenizer stoken;

    String fin = "./userPuzzles/assignmentPuzzle";
    String fout = "output";


    private void solve() { // some solving code...
        int n = nextInt();
        int[] mas = new int[n];
        for (int i = 0; i<n; i++){
            mas[i] = nextInt();
            System.out.println(mas[i]);
        }
    }

    Task() throws IOException {
        input = new BufferedReader(new FileReader(fin + ".txt"));
        output = new PrintWriter(new FileWriter(fout + ".txt"));

        solve();

        input.close();
        output.flush();
        output.close();
    }


    int nextInt() {
        return Integer.parseInt(nextToken());
    }


    long nextLong() {
        return Long.parseLong(nextToken());
    }


    double nextFloat() {
        return Float.parseFloat(nextToken());
    }


    double nextDouble() {
        return Double.parseDouble(nextToken());
    }


    String nextToken() {
        while ((stoken == null) || (!stoken.hasMoreTokens())) {
            try {
                String line = input.readLine();
                stoken = new StringTokenizer(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stoken.nextToken();
    }


    public static void main(String[] args) throws IOException {
        new Task();
    }

}
