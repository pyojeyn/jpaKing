package com.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@DiscriminatorValue("M")
public class Movie extends Item{
    private String director;
    private String actor;

}
