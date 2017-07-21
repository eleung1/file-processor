package com.eric.fileprocessor.validation.filter;

import java.io.File;

import org.springframework.integration.annotation.Filter;

public class DuplicateFilter {
  
  @Filter
  public boolean isNotDuplicate(File input) {
    System.out.println(String.format("Checking for duplicate: new file=[%s]", input.getAbsolutePath()));
    return !duplicateCheck(input);
  }
  
  
  /**
   * Mock implementation of duplicate check.
   * 
   * @param newFileName
   * @return TRUE is newFile is a duplicate, FALSE otherwise.
   */
  public boolean duplicateCheck(File newFile) {
    String oldFileName = "file_0.txt";
    return oldFileName.equalsIgnoreCase(newFile.getName());
  }
}
