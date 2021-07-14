package com.example.hp.birth_death_registeration;

import java.util.jar.Attributes;

public class DoctorData {
    String id,Username,Password,FullName,Address,Phone,Adhar,Education,HospitalName,Regno,email;
    public DoctorData(String id1,String st1,String st2,String st4,String st5,String st6,String st7,String st8,String st9,String st10,String st11)
    {
        this.id=id1;
        this.Username=st1;
        this.Password=st2;
     //   this.str3=st3;
        this.FullName=st4;
        this.Address=st5;
        this.Phone=st6;
        this.email=st7;
        this.Adhar=st8;
        this.Education=st9;
        this.HospitalName=st10;
        this.Regno=st11;

    }

    public String getUsername() {
        return Username;
    }

}
