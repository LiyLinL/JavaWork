package com.liy.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorApplicationTests {

    @Test
    public void test() throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\Administrator\\Desktop\\sql\\create.sql");
        BufferedWriter bw = new BufferedWriter(fw);

        String path = "C:\\Users\\Administrator\\Desktop\\sql";
        File file = new File(path);
        String fullpath = file.getAbsolutePath();
        String[] fileList;
        String[] nextFileList;

        if (file.isDirectory()) {
            fileList = file.list();
            asc(fileList, false);
            for (int i = 0; fileList.length > i; i++) {
                File tempFile = new File(fullpath + "\\" + fileList[i]);
                if (tempFile.isDirectory()) {
                    nextFileList = tempFile.list();
                    for (int k = 0; nextFileList.length > k; k++) {
                        if (nextFileList[k].contains(".sql")) {
                            FileReader fr = new FileReader(tempFile + "\\" + nextFileList[k]);
                            BufferedReader br = new BufferedReader(fr);
                            while (br.ready()) {
                                bw.write(br.readLine());
                                bw.flush();
                            }
                            bw.write(";\n");
                            bw.flush();
                            br.close();
                            break;
                        }
                    }
                }
            }
            bw.close();
        }
    }

    public void asc( String[] strs, boolean asc ) {
        List<String> fileList = Arrays.asList(strs);
        Collections.sort(fileList, new Comparator<String>() {
            @Override
            public int compare( String o1, String o2 ) {
                if (asc) {
                    return o1.compareTo(o2);
                } else {
                    return o2.compareTo(o1);
                }
            }
        });
    }
}
