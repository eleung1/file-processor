package com.eric.fileprocessor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.PollableChannel;

public class FileProcessorTest {
  
  private int fileCount = 5;
  
  @Test
  public void testSequentialFileProcessing() throws Exception {
    System.out.println("\n\n#### Starting Sequential processing test ####");
    System.out.println("Populating directory with files");
    for (int i = 0; i < fileCount; i++) {
      //File file = new File("file_dirs/input/file_" + i + ".txt");
      File file = new File("C:/my_test/input/file_" + i + ".txt");
      BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("hello " + i);
        out.close();
    }
    System.out.println("Populated directory with files");
    Thread.sleep(2000);
    System.out.println("Starting Spring Integration Sequential File processing");
    
    //ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/spring/integration/sequentialFileProcessing-config.xml");
    ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("FileProcessor-context.xml");
    
    
    PollableChannel filesOutChannel = ac.getBean("transformedFileChannel", PollableChannel.class);
    
    // fileCount - 1 because 1 of the file is a duplicate and will not make it to the final endpoint
    for (int i = 0; i < fileCount - 1; i++) {
      System.out.println("Finished processing " + filesOutChannel.receive(10000).getPayload());
    }
    ac.stop();
  }
  
}
