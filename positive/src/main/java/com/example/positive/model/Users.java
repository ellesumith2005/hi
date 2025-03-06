package com.example.positive.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Column
String username;

@Column
String email;

@Column
String password;

public String getName()
{
    return this.username;
}
public void setName(String username)
{
    this.username = username;
}
public String getEmail()
{
    return this.email;
}
public void setEmail(String email){
    this.email=email;
}
public String getPassword()
{
    return this.password;
}
public void setPassword(String password)
{
    this.password=password;
}
}