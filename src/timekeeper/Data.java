/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package timekeeper;

/**
 *
 * @author santo
 */
class Data {
    private int time_needed,sl_no;
    private String task_name,priority,start,end;
    public Data(int sl_no,int time_needed,String task_name,String priority,String start,String end)
    {
        this.sl_no=sl_no;
        this.time_needed=time_needed;
        this.priority=priority;
        this.start=start;
        this.end=end;
        this.task_name=task_name;
        
    }
    public int getsl_no(){
        return sl_no;
    }
    public int gettime(){
        return time_needed;
    }
    public String getname(){
        return task_name;
    }
    public String getpriority(){
        return priority;
    }
    public String getstart(){
        return start;
    }
    public String getend(){
        return end;
    }
}
