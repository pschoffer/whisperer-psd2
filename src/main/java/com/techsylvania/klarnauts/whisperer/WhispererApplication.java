package com.techsylvania.klarnauts.whisperer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WhispererApplication {

  public static void main(String[] args) {
    SpringApplication.run(WhispererApplication.class, args);
  }

}
