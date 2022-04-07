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
    private static JFrame frame;
    static int conset;
    private final String url = "jdbc:postgresql://localhost:5432/login_details";
    private final String user = "postgres";
    private final String password = "postgres";
    Connection conn = null;
    public void connect() {
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
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
            case 2:
                x.jLabel3.setText("Wrong password for given username");
                break;
            default:
                x.jLabel3.setText("No user with this username exists");
                break;
        }
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
//                
                
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
    
}
