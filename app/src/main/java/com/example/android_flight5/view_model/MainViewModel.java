package com.example.android_flight5.view_model;

public class MainViewModel {

    private String name;
    private String type;
    private String message;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }


    public String getName()
    {
        return this.name;
    }



    public String getType()
    {
        return this.type;
    }
}
