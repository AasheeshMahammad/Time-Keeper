package timekeeper;
public class Mvc_Main {
     public static void main(String[]args)
    {
        Model mos=new Model();
        First_Page view1=new First_Page();        
        Controller controller=new Controller(mos,view1);
        controller.update_view();    }     
}