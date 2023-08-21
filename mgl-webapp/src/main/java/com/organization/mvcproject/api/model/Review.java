package com.organization.mvcproject.api.model;

public interface Review {
    
    Integer getRating();
    
    void setRating(Integer rating);
    
    String getBody();
    
    void setBody(String body);
    
    String getAuthor();
    
    void setAuthor(String author);

}
