package com.liy.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorApplicationTests {

    @Test
    public void run() throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\sql";
        File file = new File(path);
        String fullpath = file.getAbsolutePath();
        String[] fileList;
        String[] nextFileList;

        FileWriter fw = new FileWriter(path + "\\" + "create.sql");
        try{
            if (file.isDirectory()) {
                fileList = file.list();
                for (int i = 0; fileList.length > i; i++) {
                    File tempFile = new File(fullpath + "\\" + fileList[i]);
                    if (tempFile.isDirectory()) {
                        nextFileList = tempFile.list();
                        for (int k = 0; nextFileList.length > k; k++) {
                            if (nextFileList[k].contains(".sql")) {
                                FileReader fr = new FileReader(tempFile + "\\" + nextFileList[k]);
                                BufferedReader br = new BufferedReader(fr);
                                while (br.ready()) {
                                    fw.write(br.readLine() + "\n");
                                    System.out.println(br.readLine());
                                }
                                fw.write(";\n");
                                System.out.println(";");
                                fr.close();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if ( fw != null) {
                fw.flush();
                fw.close();
            }
        }
    }
}
