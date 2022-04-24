package timekeeper;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    private static Model model;
    private static First_Page view;    
    Controller(Model mo,First_Page vi){
    Controller.model=mo;
    Controller.view=vi;
}
    public void update_view()
    {
        view.open();
        
    }
    public static void loginclicked(First_Page x)
    {
        model.loginclicked(x);        
    }
    public static void signupclicked(First_Page x)
    {
        model.signupclicked(x);
    }
    public static void signupclicked(LoginPage x)
    {
        model.signupclicked(x);
    }
    public static void loginclicked(LoginPage x)
    {
        model.loginclicked(x);
    }
    public static void signupfinalclicked(SignUp x)
    {
        model.signupfinalclicked(x);
    }
    public static void inserttaskclicked(Task_CRUD x)
    {
        model.inserttaskclick(x);
    }
    public static void inserttask(Insert_tasks x)
    {
        model.inserttask(x);
    }
    
    public static String[] loadProfile(String username)
    {
        return model.getemailpassword(username);
    }
    
    public static void updateProfile(String username, String email, String password)
    {
        model.updateProfile(username, email, password);
    }
    public static void inserttocrud(Insert_tasks x)
    {
        model.inserttocrud(x);
    }
    public static void logout(Task_CRUD x)
    {
        model.logout(x);
    }
    public static void profiletocrud(Profile x)
    {
        model.profiletocrud(x);
    }
    public static void viewall(Task_CRUD x) throws SQLException
    {
        model.viewall(x);
    }
    public static void viewall1(Task_CRUD x) throws SQLException
    {
        model.viewall1(x);
    }
    public static void viewtocrud(View_all x)
    {
        model.viewtocrud(x);
    }
    public static void viewtocrud(View_today x)
    {
        model.viewtocrud(x);
    }
    public static void viewprofile(Task_CRUD x)
    {
        model.viewprofile(x);
    }
    public static ArrayList <Data> show(View_all x) throws SQLException
    {
        return model.show(x);
//        model.putinto(x);
    }
    public static ArrayList <Data> show(View_today x) throws SQLException
    {
        return model.show(x);
//        model.putinto(x);
    }
    public static void updatetask(Task_CRUD x)
    {
        model.updatetask(x);
    }
    public static void updategetdata(Update_Task x)
    {
        model.updategetdata(x);
    }
    public static void updateselecteddisplay(Update_Task x)
    {
        model.updateselecteddisplay(x);
    }
    public static void updatetocrud(Update_Task x)
    {
        model.updatetocrud(x);
    }
    public static void updateinfo(Update_Task x)
    {
        model.updateinfo(x);
    }
    public static void completed(Task_CRUD x)
    {
        model.completed(x);
    }
    public static void deletetocrud(Delete_Page x)
    {
        model.deletetocrud(x);
    }
    public static void deletetask(Delete_Page x)
    {
        model.deletetask(x);
    }
    public static void performtask(Task_CRUD x)
    {
        model.performtask(x);
    }
    public static void performtocrud(Perform_Task x)
    {
        model.performtocrud(x);
    }
    public static void performtotodays(Perform_Task x) throws SQLException
    {
        model.performtotodays(x);
    }
    public static void startworking(Perform_Task x) throws SQLException, InterruptedException
    {
        model.startworking(x);
    }
    
 }
