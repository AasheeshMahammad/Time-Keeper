package timekeeper;
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
    public static String[] loadProfile(String username)
    {
        return model.getemailpassword(username);
    }
    
    public static void updateProfile(String username, String email, String password)
    {
        model.updateProfile(username, email, password);
    }
    
 }
