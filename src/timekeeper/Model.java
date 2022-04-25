package timekeeper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Model {
    String usernames;
    private static JFrame frame;
    static int conset=0;
    private final String url = "jdbc:postgresql://localhost:5432/timekeeper";
    private final String user = "postgres";
    private final String password = "postgres";
    boolean flag=false;
    int timers;
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
        System.out.println("Login validted is"+login_validated);
        switch (login_validated) {
            case 1:
                usernames=username;
                new Task_CRUD().setVisible(true);
                x.close();
                break;
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
        LocalDate date = LocalDate.now();
        LocalDate start_dates=LocalDate.parse((x.jTextField4.getText()));
        LocalDate end_dates=LocalDate.parse((x.jTextField5.getText()));
        if(!((start_dates.isEqual(date)||start_dates.isAfter(date)) && start_dates.isBefore(end_dates)))
        {
            x.jLabel7.setText("Please check your start date it should be after todays date and before end date");
        }        
        else
        {
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
    public void profiletocrud(Profile x)
    {
        new Task_CRUD().setVisible(true);
        x.close();
    }
    public void logout(Task_CRUD x)
    {
        Model.frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to Logout","Timekeeper",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
        x.close();
        System.out.println("Thanks for using time keeper");
        
    }
    public void viewall(Task_CRUD x) throws SQLException
    {
        new View_all().dos();
        x.close();
    }
    public void viewall1(Task_CRUD x) throws SQLException
    {
        new View_today().dos();
        x.close();
    }
    public void viewtocrud(View_all x)
    {
        new Task_CRUD().setVisible(true);
        x.close();
        
    }
    public void viewtocrud(View_today x)
    {
        new Task_CRUD().setVisible(true);
        x.close();
        
    }
    public ArrayList <Data> show(View_all x)
    {
        ArrayList<Data> datalist=new ArrayList<>();
        if(conset==0)
        {
            connect();
            conset=1;
        }
        String query="SELECT * FROM TASKS where username="+usernames;
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Data data;        
            while(rs.next())
            {
                data=new Data(rs.getInt("sl_no"),rs.getInt("time_needed_more"),rs.getString("task_name"),rs.getString("priority"),rs.getDate("start_date").toString(),rs.getDate("end_date").toString());
                datalist.add(data);
            }

            
        } catch (Exception ex) {
            System.out.println("No tasks");
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datalist;
    }
        
    

    public ArrayList <Data> show(View_today x) throws SQLException
    {
        ArrayList<Data> datalist=new ArrayList<>();
        if(conset==0)
        {
            connect();
            conset=1;
        }
        LocalDate date = LocalDate.now();
        System.out.println("Date is "+date);
        java.sql.Date sqlDate = java.sql.Date.valueOf( date );
        String query="SELECT * FROM TASKS where username="+usernames+" and start_date<end_date and start_date<="+"'"+sqlDate+"'"+"and '"+sqlDate+"'<=end_date";
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Data data;        
        while(rs.next())
        {
            data=new Data(rs.getInt("sl_no"),rs.getInt("time_needed_more"),rs.getString("task_name"),rs.getString("priority"),rs.getDate("start_date").toString(),rs.getDate("end_date").toString());
            datalist.add(data);
        }        
        return datalist;
    }
    public void viewprofile(Task_CRUD x)
    {
        new Profile(usernames).setVisible(true);
        x.close();
    }
    public void updatetask(Task_CRUD x)
    {
        new Update_Task(usernames).setVisible(true);
        x.close();
    }
    public void updategetdata(Update_Task x)
    {
        String slno=x.jTextField1.getText();
        int slo=Integer.parseInt(slno);
        String query="SELECT * FROM TASKS where username="+usernames+" and sl_no="+slo;
        Statement stmt;
        if(conset==0)
        {
            connect();
            conset=1;
        }
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String name= rs.getString("task_name");
                String priority= rs.getString("priority");
                String time_needed= rs.getString("time_needed_more");
                String start_date= rs.getString("start_date");
                String end_date= rs.getString("end_date");
                String []list={name,priority,time_needed,start_date,end_date};
                DefaultListModel demoList = new DefaultListModel();
                demoList.addElement(name);
                demoList.addElement(priority);
                demoList.addElement(time_needed);
                demoList.addElement(start_date);
                demoList.addElement(end_date);
                x.jList1.setModel(demoList);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void updateselecteddisplay(Update_Task x)
    {
        System.out.println((String)x.jList1.getSelectedValue());
        x.jTextField2.setText((String)x.jList1.getSelectedValue());
    }
    public void updatetocrud(Update_Task x)
    {
        new Task_CRUD().setVisible(true);
        x.close();
    }
    public void updateinfo(Update_Task x)
    {
        String slno=x.jTextField1.getText();
        int slo=Integer.parseInt(slno);
        String info = x.jTextField2.getText();
        int index = x.jList1.getSelectedIndex();
        String query = null;
        if(index==0)
        {
            query="update tasks set task_name="+"'"+info+"'"+"where username="+usernames+" and sl_no="+slo;
        }
        else if(index==1)
        {
            query="update tasks set priority="+"'"+info+"'"+"where username="+usernames+" and sl_no="+slo;
        }
        else if(index==2)
        {
            query="update tasks set time_needed_more="+Integer.parseInt(info)+"where username="+usernames+" and sl_no="+slo;
        }
        else if(index==3)
        {
            query="update tasks set start_date="+"'"+info+"'"+"where username="+usernames+" and sl_no="+slo;
        }
        else if(index==4)
        {
            query="update tasks set end_date="+"'"+info+"'"+"where username="+usernames+" and sl_no="+slo;
        }
        
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            x.jLabel3.setText("Updation Sucessfuly completed");
            updategetdata(x);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void completed(Task_CRUD x)
    {
        new Delete_Page().setVisible(true);
        x.close();
    }
    public void deletetocrud(Delete_Page x)
    {
        new Task_CRUD().setVisible(true);
        x.close();
    }
    public void deletetask(Delete_Page x)
    {
        String slno=x.jTextField1.getText();
        String query1="SELECT * FROM TASKS where username="+usernames+"and sl_no="+slno;
        Statement stmt1;
        int found=0;
        try {
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(query1);
            while(rs.next())
            {
                found=1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }       
        String query = "DELETE FROM TASKS WHERE username="+usernames+" AND sl_no="+Integer.parseInt(slno);
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            if(found>0){
                x.jLabel3.setText("Deleted the task sucessfully");
            }
            else{
                x.jLabel3.setText("No task with given serial number");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void performtask(Task_CRUD x)
    {
        new Perform_Task().setVisible(true);
        x.close();
    }
    public void performtocrud(Perform_Task x)
    {
        new Task_CRUD().setVisible(true);
        x.close();
    }
    public void performtotodays(Perform_Task x) throws SQLException{
        new View_today().setVisible(true);
        x.close();
    }
    public void startworking(Perform_Task x) throws SQLException, InterruptedException
    {
        ArrayList<Data> datalist=new ArrayList<>();
        if(conset==0)
        {
            connect();
            conset=1;
        }
        int sl_no=Integer.parseInt(x.jTextField1.getText());
        LocalDate date = LocalDate.now();
        System.out.println("Date is "+date);
        java.sql.Date sqlDate = java.sql.Date.valueOf( date );
        String query="SELECT * FROM TASKS where username="+usernames+" and start_date<end_date and start_date<="+"'"+sqlDate+"'"+"and '"+sqlDate+"'<=end_date"+" and sl_no="+sl_no;
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int time_needed_more=0;
        int boo=0;
        while(rs.next())
        {
            time_needed_more=rs.getInt("time_needed_more");
            boo=1;
        }
        if(time_needed_more ==0 && boo==1)
        {
            x.jLabel3.setText("Time needed more for this task is 0 so deleting this task");
            String query1 = "DELETE FROM TASKS WHERE username="+usernames+" AND sl_no="+sl_no;
            Statement stmt1;
            try {
                stmt1 = conn.createStatement();
                stmt1.executeUpdate(query1);
                Thread.sleep(1000);
                x.jLabel3.setText("Deleted the task sucessfully");
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else if(boo==0)
        {
            x.jLabel3.setText("No task with given serial number found");
        }
        else{
            
            x.jLabel3.setText("Working on Task "+String.valueOf(sl_no)+"For 60 mins and break for 10 mins");
            if(!flag)
            {
                x.jButton2.setEnabled(false);
                x.jButton1.setEnabled(false);
                x.jButton3.setEnabled(false);
                timers=3600;
                Timer timer=new Timer();
                TimerTask task= new TimerTask() {
                    @Override
                    public void run() {
                        x.jLabel4.setText("Time Left for Break:"+covertto(timers));  
                        if(timers<=0)
                        {
                            x.jLabel4.setText("Time Left for Break: "+covertto(timers)+" Click on start again to take a break");
                            x.jButton3.setEnabled(true);
                            timer.cancel();                          
                            flag=true;
                        }
                        timers=timers-5;
                    }
                };
                timer.scheduleAtFixedRate(task,0,5000);                
            }
            else{
                x.jButton2.setEnabled(true);
                x.jButton1.setEnabled(true);
                x.jLabel3.setText("Taking a break for 10 mins and timeneeded reduced by 1 hr");
                String query1 = "update tasks set time_needed_more="+(time_needed_more-1)+"where username="+usernames+" and sl_no="+sl_no;
                Statement stmt1;
                try {
                    stmt1 = conn.createStatement();
                    stmt1.executeUpdate(query1);
                } catch (SQLException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                }
                timers=600;
                Timer timer1=new Timer();
                TimerTask task1= new TimerTask() {
                    @Override
                    public void run() {
                        x.jLabel4.setText("Time left in break:"+covertto(timers));                        
                        if(timers<=0)
                        {
                            x.jLabel4.setText("Time Left for Break: "+covertto(timers)+" Click on Start again to Start Working");
                            timer1.cancel();                                                      
                            flag=false;
                        }
                        timers=timers-5;
                    }
                };
                timer1.scheduleAtFixedRate(task1,0, 5000);
            }
        }
    }
    public String covertto(int num)
    {
        String conv="";
        int mins=(int)num/60;
        int seconds=num%60;
        conv=conv+String.valueOf(mins)+":"+String.valueOf(seconds);
        return conv;
    }
}
