package com.test.demo.dto;

public class CustomerDTO {
    private Long id;
    private String name;
    private String facebookId;

    // Constructors, getters, setters

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String facebookId) {
        this.id = id;
        this.name = name;
        this.facebookId = facebookId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
}
