package com.eric.fileprocessor.validation.filter;

import org.springframework.integration.annotation.Filter;

public class HeaderTrailerFilter {
  
  @Filter
  public boolean isValidHeaderTrailer() {
    System.out.println("Checking if header/trailer are valid");
    return true;
  }
}
