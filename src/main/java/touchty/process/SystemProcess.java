package touchty.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemProcess {
    public static void checkDirectory() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","dir");
        processBuilder.directory(new File("D:/"));
        Process process = processBuilder.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    /**
     * 查看ip地址【Windows系统下】
     */
    public static void checkPhysicAddress() {
        ProcessBuilder processBuilder = new ProcessBuilder("ipconfig", "/all");
        try {
            Process process = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("IPv4") != -1) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println("checkDirectory");
        checkDirectory();

        System.out.println("checkPhysicAddress");
        checkPhysicAddress();
    }
}
