package com.liy.generator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

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

                            StringBuffer p1 = new StringBuffer(tempFile.getAbsolutePath()).append("\\").append(nextFileList[k]);
                            StringBuffer p2 = new StringBuffer(tempFile.getAbsolutePath()).append("\\").append(fileList[i]).append(".sql");
                            new File(p1.toString()).renameTo(new File(p2.toString()));

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

    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
    }

    @Test
    public void testController() throws Exception {
        // perform执行一个请求
        mvc.perform(MockMvcRequestBuilders.get("/test") // 請求方法
                .contentType(MediaType.ALL) // 發送數據格式
                .accept(MediaType.ALL_VALUE) // 接收數據格式
                .session(session) // session
        ).andExpect(MockMvcResultMatchers.status().isOk()) // 请求的状态响应是否为200，如果不是则抛异常
        .andDo(MockMvcResultHandlers.print()); // 结果处理，输出整个响应结果信息
    }
}
