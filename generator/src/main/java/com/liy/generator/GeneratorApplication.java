package com.liy.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan({ "com.liy.generator.mapper" })
@EnableAsync
@RestController
public class GeneratorApplication {

    private static String[] args;
    private static ConfigurableApplicationContext context;

    public static void main( String[] args ) {
        GeneratorApplication.args = args;
        GeneratorApplication.context = SpringApplication.run(GeneratorApplication.class, args);
    }

    @GetMapping("restart")
    public void restart() {
        ExecutorService threadPool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPool.execute(() -> {
            context.close();
            context = SpringApplication.run(GeneratorApplication.class, args);
        });
        threadPool.shutdown();
    }

}
