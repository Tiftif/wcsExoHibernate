package com.wcs.heroSpring.heroSpring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero {

    public Hero() {
    }

    public Hero(String name, int power, String comics) {
        this.name = name;
        this.power = power;
        this.comics = comics;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;

    private int power;

    private String comics;

    @Override
    public String toString() { 
        return "Hero [id=" + id + ", Name: " + name + 
                ", power: " + power + ", comics: " + comics + "]";
    }                    

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }    

    public String getComics() {
    	return comics;
    }
    
    public void setComics(String comics) {
    	this.comics = comics;
    }
}