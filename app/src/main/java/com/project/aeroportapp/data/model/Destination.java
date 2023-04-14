package com.project.aeroportapp.data.model;

public class Destination {
        private String name;
        private Boolean abroad;
        public Destination(String Name, Boolean Abroad)
        {
           name = Name;
           abroad = Abroad;
        }

    public String getName() {
        return name;
    }

    public Boolean getAbroad() {
        return abroad;
    }
}

