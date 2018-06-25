package ca.dal.csci3130.coursesmanagementsystem;

public class UserInformation {
    public String Id;
    public String Name;
    public String Faculty;
    public String MailAddress;
    public UserInformation(){

    }
    public UserInformation(String Id,String Name,String Faculty,String MailAddress){
        this.Id = Id;
        this.Name=Name;
        this.Faculty=Faculty;
        this.MailAddress = MailAddress;
    }
   /* public String getId(){
        return Id;
    }
    public String getName (){
        return Name;
    }
    public String getFaculty (){
        return Faculty;
    }
    public String getMailAddress (){
        return MailAddress;
    }*/




}
