package timekeeper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Model {
    String usernames;
    private static JFrame frame;
    static int conset=0;
    private final String url = "jdbc:postgresql://localhost:5432/timekeeper";
    private final String user = "postgres";
    private final String password = "postgres";
    Connection conn = null;
    public void connect() {
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println("Not set");
            System.out.println(e.getMessage());
        }
    }
    int count_users(String us)
    {
        Statement stmt;
        try {
            stmt = conn.createStatement();            
            ResultSet rs = stmt.executeQuery("select * from login where username= "+us);
            int count=0;
            while(rs.next())
            {
                count+=1;
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    int check_login(String us,String pass)
    {
        Statement stmt;
        try {
            stmt = conn.createStatement();            
            ResultSet rs = stmt.executeQuery("select * from login where username= "+us+" and password="+pass);
            int count=0;
            while(rs.next())
            {
                count+=1;
            }
            if(count>=1)
            {
                return 1;
            }
            else{
                return 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public int main_login(String us,String pass)
    {
        int user_exists=count_users(us);
        if(user_exists==1)
        {
            int temp=check_login(us,pass); 
            if(temp==1)
            {
                return 1;
            }
            else{
                return 2;                
            }
        }
        else
        {
            return 0;            
        }       
    }
    public int create_account(String us,String pass,String email)
    {
        int user_exists=count_users(us);
        if(user_exists==1)
        {
            return 2;
        }
        else
        {
           Statement stmt;
            try {
            stmt = conn.createStatement();            
            stmt.executeUpdate("insert into login values("+us+","+pass+","+email+")");
            System.out.println("Insertion to login succesful");
            return 1;
            }catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        return 0;
    }
    public void loginclicked(First_Page x)
    {
        new LoginPage().setVisible(true);
        x.close(); 
    }
    public void signupclicked(First_Page x)
    {
        new SignUp().setVisible(true);
        x.close();
    }
    public void signupclicked(LoginPage x)
    {
        new SignUp().setVisible(true);
        x.close();
    }
    public void loginclicked(LoginPage x)
    {
        String username="'"+x.jTextField3.getText()+"'";
        String password="'"+x.jPasswordField1.getText()+"'";
        if(conset==0)
        {
            connect();
            conset=1;
        }
        int login_validated=main_login(username, password);
        switch (login_validated) {
            case 1:
                usernames=username;
                new Task_CRUD().setVisible(true);
            case 2:
                x.jLabel3.setText("Wrong password for given username");
                break;
            default:
                x.jLabel3.setText("No user with this username exists");
                break;
        }
        x.close();
    }
    public void signupfinalclicked(SignUp x)
    {
        if(conset==0)
        {
            connect();
            conset=1;
        }
        String username="'"+x.jTextField3.getText()+"'";
        String pas1="'"+x.jPasswordField1.getText()+"'";
        String pas2="'"+x.jPasswordField2.getText()+"'";
        String email="'"+x.jTextField1.getText()+"'";
        if(pas2.equals(pas1))
        {
            int temp=create_account(username,pas1, email);
            if(temp==1)
            {
                usernames=username;
                new Task_CRUD().setVisible(true);
                x.close();
            }
            else if(temp==2)
            {
                x.jLabel1.setText("Another User with same username exists");
            }
            
        }
        else
        {
            x.jLabel1.setText("Passwords dont match");
        }
    }
    public void inserttaskclick(Task_CRUD x)
    {        
        new Insert_tasks().setVisible(true);       
        x.close();
    }
    public void inserttask(Insert_tasks x)
    {
        if(conset==0)
        {
            connect();
            conset=1;
        }
        String us="'"+usernames+"'";
        String task_name="'"+x.jTextField1.getText()+"'";
        String priority="'"+x.jTextField2.getText()+"'";
        String time_needed="'"+x.jTextField3.getText()+"'";
        String start_date="'"+x.jTextField4.getText()+"'";
        String end_date="'"+x.jTextField5.getText()+"'";
        System.out.println("username is "+usernames);
        Statement stmt;
        try {
            stmt = conn.createStatement();            
            stmt.executeUpdate("insert into tasks(username,task_name,priority,time_needed_more,start_date,end_date) values("+usernames+","+task_name+","+priority+","+time_needed+","+start_date+","+end_date+")");
            System.out.println("Insertion to tasks succesful");
            x.jTextField1.setText("");
            x.jTextField2.setText("");
            x.jTextField3.setText("");
            x.jTextField4.setText("");
            x.jTextField5.setText("");
            x.jLabel7.setText("Task has been inserted");
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());            
        }    
    }         
        

    public int updateProfile(String us ,String email, String pwd){
//        if(conset==0)
//        {
//            connect();
//            conset=1;
//        }
        if(conn==null)connect();
        Statement stmt;
        try 
        {
            stmt = conn.createStatement();            
            stmt.executeUpdate("update login set email = '"+email+"' , password = '"+pwd+"' where username = '"+us+"';");
            System.out.println("Updated profile succesfully");
            return 1;
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
//    public int saveProfile(String us ,String email, String pwd)
//    {
//        
//    
//    }
    
//    public void loadProfile(String username)
//    {
//        if(conset==0)
//        {
//            connect();
//            conset=1;
//        }
//    }
    public String[] getemailpassword(String us) {
//        if(conset==0)
//        {
//            connect();
//            conset=1;
//        }
        if(conn==null)connect();
        Statement stmt;
        String em1 = null;
        String em2 = null;
        try 
        {
            stmt = conn.createStatement();            
            ResultSet rs = stmt.executeQuery("select * from login where username='"+us+"';");
//            System.out.println(rs);
//            System.out.println("Updated profile succesfully");
            while (rs.next())
            {
                if(rs.getString("username").equals(us)){
                    em1 = rs.getString("email");
                    em2 = rs.getString("password");
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            
        }
        String[] res = {em1,em2};
        return res;
    }
    public void inserttocrud(Insert_tasks x)
    {
        new Task_CRUD().setVisible(true);
        x.close();
    }
    
}
