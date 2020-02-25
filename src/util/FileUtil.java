package util;

import java.io.*;

public class FileUtil {

    public static void writeFile(String fileRelPath, String data) throws Exception {
        File file = new File(fileRelPath);
        BufferedWriter buffer = new BufferedWriter(
                new FileWriter(new File("").getAbsolutePath() + System.getProperty("file.separator") + file));
        buffer.write(data);
        buffer.close();
        System.out.println("Success writing to client container");
    }

    private String readFile(String fileRelPath) throws Exception {
        File file = new File(fileRelPath);

        BufferedReader br = new BufferedReader(
                new FileReader(new File("").getAbsolutePath() + System.getProperty("file.separator") + file));
        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null)
            sb.append(st);

        br.close();
        return sb.toString();
    }
}
