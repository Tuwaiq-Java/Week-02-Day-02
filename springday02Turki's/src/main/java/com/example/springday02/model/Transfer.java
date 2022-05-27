package com.example.springday02.model;

public class Transfer {
    private  String IDfrom;
    private String IDto;

    public Transfer(String IDfrom, String IDto) {
        this.IDfrom = IDfrom;
        this.IDto = IDto;
    }


    public String getIDfrom() {
        return IDfrom;
    }

    public void setIDfrom(String IDfrom) {
        this.IDfrom = IDfrom;
    }

    public String getIDto() {
        return IDto;
    }

    public void setIDto(String IDto) {
        this.IDto = IDto;
    }
}
