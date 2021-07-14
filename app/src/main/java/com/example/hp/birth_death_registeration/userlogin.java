package com.example.hp.birth_death_registeration;

public class userlogin {

    String id,uUsername,uPassword,uRepassword,uName,uAddress,uPhone,uEmail,uAdharCard;
    boolean flg;
    public userlogin(){}
    public userlogin( String id ,String uUsername,String uPassword,String uRepassword,String uName,String uAddress,String uPhone,String uEmail,String uAdharCard, boolean flg)
    {
        this.flg=flg;
        this.id=id;
        this.uUsername=uUsername;
        this.uPassword=uPassword;
        this.uRepassword=uRepassword;
        this.uName=uName;
        this.uAddress=uAddress;
        this.uPhone=uPhone;
        this.uEmail=uEmail;
        this.uAdharCard=uAdharCard;

    }

    public boolean getFlg() {
        return flg;
    }

    public String getId(){
        return  id;
    }
    public String getuUsername()
    {
        return uUsername;
    }
    public String getuPassword()
    {
        return  uPassword;
    }
    public String getuRepassword()
    {
        return uRepassword;
    }
    public String getuName()
    {
        return uName;
    }
    public String getuAddress()
    {
        return uAddress;
    }
    public String getuPhone()
    {
        return uPhone;
    }
    public String getuEmail()
    {
        return uEmail;
    }
    public String getuAdharCard()
    {
        return uAdharCard;
    }

}
