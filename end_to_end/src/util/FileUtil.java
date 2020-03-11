//package util;
//
//import java.io.*;
//import java.nio.file.Files;
//
//public class FileUtil {
//
//    public static void writeFile(String fileRelPath, String data) throws Exception {
//
//        File file = new File(fileRelPath);
//
//        BufferedWriter buffer =
//                new BufferedWriter(new FileWriter(new File("").getAbsolutePath() + System.getProperty("file.separator") + file));
//
//        buffer.write(data);
//        buffer.close();
//        System.out.println("Success writing to ftp.client container");
//    }
//
//    public static String readFile(String fileRelPath) throws Exception {
//
//        File file = new File(fileRelPath);
//
//        BufferedReader br =
//                new BufferedReader(new FileReader(new File("").getAbsolutePath() + System.getProperty("file.separator") + file));
//
//        StringBuilder sb = new StringBuilder();
//        String st;
//        while ((st = br.readLine()) != null)
//            sb.append(st);
//
//        br.close();
//
//        System.out.println("Success reading from file");
//        return sb.toString();
//    }
//
//    public static BufferedInputStream initConversionToBytes(String fileRelPath) {
//
//        File file = new File(fileRelPath);
//        try {
//            return new BufferedInputStream(new FileInputStream(new File("").getAbsolutePath() + System.getProperty("file.separator") + file));
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//    }
//
//    public static void sendFile(NetworkUtil nc, BufferedInputStream fileBufferedStream, String fileName) {
//
//        nc.write("put: " + fileName);
//
//        final int BUFFER_SIZE = 1000000;
//
//        int bytesRead = 0;
//        byte[] byteDataArray2 = new byte[100];
//        System.out.println("before beginning of while loop");
//        int count = 0;
//        long bytesWritten = 0;
//        FileData fileData = new FileData(byteDataArray2, "", fileName, 0, false);
//        byte[] byteDataArray = new byte[BUFFER_SIZE];
//
//        try {
//            while (true) {
//                count++;
//
//                bytesRead = fileBufferedStream.read(byteDataArray);
//
//                fileData.setDataArray(byteDataArray);
//                fileData.setBytesRead(bytesRead);
//
//                fileData.setBytesRead(bytesRead);
//                fileData.setDataArray(byteDataArray);
//
//                bytesWritten += fileData.getBytesRead();
//
//                System.out.println("while loop instance" + count);
//
//                if (bytesRead == -1) {
//                    System.out.println("eof reached");
//
//                    fileData.setEOF(true);
//                    Integer a = fileData.getBytesRead();
//                    System.out.println(a);
//                    nc.writeUnshared(fileData);
//                    break;
//                } else {
//                    System.out.println("writing object time" + count);
//
//                    nc.writeUnshared(fileData);
//                    Integer a = fileData.getBytesRead();
//                    System.out.println(a);
//                    System.out.println("After writing object" + count);
//                }
//
//            }
//
//
//            System.out.println("Total bytes sent " + bytesWritten);
//
//
//        } catch (Exception e) {
//            String errorMessage = "Could not transfer file!!!";
//            System.out.println("Exception faced in get");
//            FileData fileDataErr = new FileData(byteDataArray2, errorMessage, fileName, 0, true);
//            nc.write(fileDataErr);
//        }
//
//
//    }
//
//    /*  TODO:
//    public static void receiveFile(NetworkUtil nc, BufferedInputStream fileBufferedStream, String fileName) {
//
//
//        System.out.println("Before sending get to ftp.server");
//        //send command
//
//        nc.write("get "+ fileName);
//
//
//        File file = new File(tokens.get(1));
//        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
//
//
//
//        System.out.println("Opened file");
//
//        long bytesWriten = 0;
//
//
//        while (true) {
//
//            Object o = objectInputStream.readUnshared();
//
//
//            System.out.println("read object");
//
//
//            if (o instanceof FileData) {
//
//                FileData fileData = (FileData) o;
//
//
//                if (!fileData.getErrorMessage().equals("")) {
//                    System.out.println(fileData.getErrorMessage());
//                    updateLog(fileData.getErrorMessage());
//                    break;
//                } else if (fileData.isEOF() || fileData.getBytesRead() == -1) {
//                    fileOutputStream.close();
//                    System.out.println("EOF reached");
//                    break;
//                } else {
//                    System.out.println("reading data");
//                    Integer a = fileData.getBytesRead();
//                    Boolean b = fileData.isEOF();
//                    System.out.println(a.toString() + b.toString());
//
//                    fileOutputStream.write(fileData.getDataArray(), 0, fileData.getBytesRead());
//                    bytesWriten += fileData.getBytesRead();
//                }
//
//
//            } else {
//                fileOutputStream.close();
//                Files.deleteIfExists(file.toPath());
//                break;
//            }
//
//
//        }
//
//        System.out.println("Total bytes recieved " + bytesWriten);
//        System.out.println("Closing file, done recieving");
//
//
//    }
//    */
//}
