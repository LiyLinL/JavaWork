package com.liy.generator;

import com.liy.generator.jms.jmsService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import java.net.URI;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private jmsService jmsService;

    private MockMvc mvc;
    private MockHttpSession session;

    @Test
    public void goPath() {
        String zPath = "C:\\Users\\Administrator\\Desktop\\Z\\index\\YO\\Z_";
        String vPath = "C:\\Users\\Administrator\\Desktop\\V\\export\\YO\\VI";
        String zCreate = "C:\\Users\\Administrator\\Desktop\\sql\\Zcreate.sql";
        String vCreate = "C:\\Users\\Administrator\\Desktop\\sql\\Vcreate.sql";

        Map<String, String> map = new HashMap<>();
        map.put(zPath, zCreate);
        map.put(vPath, vCreate);
        map.forEach(( k, v ) -> {
            try {
                create(k, v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void create( String path, String pathC ) throws IOException {
        String createPath = pathC.replaceAll("\\\\\\w*\\.\\w*", "");
        File cPath = new File(createPath);
        if (!cPath.exists()) { // Check資料夾存在
            cPath.mkdirs();
        }
        File create = new File(pathC);
        if (!create.exists()) { // Check檔案存在
            create.createNewFile();
        }
        FileWriter fw = new FileWriter(pathC); // write in here
        BufferedWriter bw = new BufferedWriter(fw);

        String[] fileList;
        String[] nextFileList;
        File file = new File(path);
        String fullpath = file.getAbsolutePath();

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
                                String line = br.readLine();
                                line = line.contains("\"YO\"") ? line.replace("\"YO\"", "\"WIP\"") : line;
                                bw.write(line + "\n");
                                bw.flush();
                            }
                            bw.write(";\n");
                            bw.flush();
                            br.close();
                            // Create.sql rename to Z_*.sql
                            StringBuffer p1 = new StringBuffer(tempFile.getAbsolutePath()).append("\\").append(nextFileList[k]);
                            StringBuffer p2 = new StringBuffer("C:\\Users\\Administrator\\Desktop\\sql\\").append(fileList[i]).append(".sql");
                            new File(p1.toString()).renameTo(new File(p2.toString()));

                            break;
                        }
                    }
                }
            }
            bw.close();
        }
    }

    public static void asc( String[] strs, boolean asc ) {
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
                .andDo(MockMvcResultHandlers.print()) // 结果处理，输出整个响应结果信息
                .andReturn();
    }

    @Test
    public void rest() throws JSONException, IOException {
        RestTemplate restTemplate = new RestTemplate();
//        try {
//            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8088/del", String.class);
//            System.out.println(response);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
            public static final String METHOD_NAME = "DELETE";

            @SuppressWarnings("unused")
            public HttpDeleteWithBody() {
            }

            @SuppressWarnings("unused")
            public HttpDeleteWithBody( URI uri ) {
                setURI(uri);
            }

            public HttpDeleteWithBody( String uri ) {
                setURI(URI.create(uri));
            }

            public String getMethod() {
                return METHOD_NAME;
            }
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDeleteWithBody httpDelete = new HttpDeleteWithBody("http://localhost:8088/del");
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        array.put("A");
        array.put("B");
        jsonObject.put("list", array);

        System.out.println(jsonObject.toString());

        StringEntity param = new StringEntity(jsonObject.toString(), "UTF-8");
        param.setContentEncoding("UTF-8");
        httpDelete.setEntity(param);
        httpDelete.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpDelete.addHeader("X-Requested-With", "XMLHttpRequest");

        CloseableHttpResponse response = httpClient.execute(httpDelete);

        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void jms() throws InterruptedException {
        System.out.println(jmsService.sendMessage("Q", "Test:" + UUID.randomUUID().toString().replaceAll("-","")));
    }
}
