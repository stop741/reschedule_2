
package reschedule.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
//import static reschedule.pkg1.reschedule_2.Task_Reschedule;




public class reschedule_2 {
    
    
    public  void main(String args[]) {
                    //Task_Reschedule(start_index_search, Task_ID, period, Deadline, priority, current_emplyee_id, femplyee_id, semplyee_id);
                   // GetCurrentIndex(currentIndex);

}
    
    
    public  int GetCurrentIndex() 
            {
                int currentIndex = 0;
                DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
   Date currentDate=new Date();

String formattedDate;

        formattedDate = dateFormat.format(currentDate);
     //   formattedDate="2017-04-13"; السطر هذا للتيست فقط
     int toMinuteInterval=0;
     LocalTime time=LocalTime.now();
       //System.out.println("time is "+time);
     int m=time.getMinute();
       //System.out.println("m is "+m);
     int total=m+30;
     int rm;
      int h=time.getHour();
     if (m>30) {rm=00;
     h=h+1;
     }
     else{ 
         
         rm=30;}
    
      // System.out.println("h is "+h);
     Time near=new Time(h,rm,0); 
       SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
       String formattedTime;

        formattedTime = sdf.format(near);
      //System.out.println("near is "+formattedTime);
       //int currentIndex=0;
      try{
      Class.forName("com.mysql.jdbc.Driver");
    
        String user="root";
         String pass="1234";
          Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hc",user,pass);//بعدها الباث حق القاعدة 
          JOptionPane.showMessageDialog(null, "successfully connected");
          //System.out.print("connected ....");
           Statement stmt=con.createStatement();
   

    ResultSet rs=null;
    String sql= "SELECT uniteTimeIndix FROM task  WHERE ( date='"+formattedDate+"' and startTime='"+formattedTime+"' ) ";
       rs=stmt.executeQuery(sql);
       if(rs.next()){
      
       currentIndex=rs.getInt("uniteTimeIndix");
       }
      
        //System.out.print("currentIndex is "+currentIndex);
        
      }catch(Exception e){}
      
              return currentIndex;
            }
    
                
            
    //int selected_id=0;
    


        public static int reminder_availabiliy(String Task_ID, int current_index_r, int period_r)// current emp, id task, 
        {
            //reminder_availabiliy(String Task_ID, int current_index_r, int period_r)
            // سو مانحتاج الكرنت امب
            //الكرنت امبلوي شكله عشان الكرنت اندكس
            //يبي لنا جدول تتبع التاس للتيستنق لكل فاريابل
            //Date r_deadline, rDate
            
            //ماينفع تكون من فونكشن وحدة عشان الكويري يختلف الفاريابل حقه سو نحتاج كونكشن جديد
            
            int reminder_r = 0;
            int deadline_index_r = 0;
            int reminder_availability_r = 0;
            
            
            ///////////////////////////////////////////////////////////////////// for "current index index"
            
            
            //int currentIndex=0;
       
            //query
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conr= DriverManager.getConnection("jdbc:mysql://localhost:3306/hc","root","1234");
            JOptionPane.showMessageDialog(null, "successfully connected");
            System.out.print("connected");  
            Statement stmtr=conr.createStatement();
            ResultSet rsr = null;

            //وش اسوي بالi?
            // String sqlr= "SELECT * WHERE uniteTimeIndix = '"+i+"' AND idFemployee = '"+emplyee_id+"'";
            
            //r_deadline = rsr.getDate("deadLine");
            //uniteTimeIndix//current employee
            //String sql= "SELECT  FROM   WHERE (uniteTimeIndix='"+current_index_r+"' AND '"++"')";
            String sql= "SELECT uniteTimeIndix FROM task  WHERE (idTask = '"+Task_ID+"' AND r_deadline = '"+deadLine+"')";//correct

            //String sql= "SELECT uniteTimeIndix FROM task  WHERE ( date='"+formattedDate+"' and startTime='"+formattedTime+"' ) ";

            rsr=stmtr.executeQuery(sql);
             
            if(rsr.next())
            { 
                //current index is i or start index search, check the code,---------> i
                //what is the date exactly??-----------------------> is the current date  of "search"
                //Date rDate = rsr.getDate("date"); // باقي تحويل الديت لانتجر لايجاد الفرق باي فونكشنperiod_index_r
                //what about the deadline, and what about function of current time by arwa
                //the variable
                      
                //deadline_index_r = rsr.getInt("uniteTimeIndix");
                
                //reminder_index_r = deadline_index_r - current_date_r; //r_reminder = r_deadline - rDate "i.date";
                //reminder_availability_index_r = reminder_index_r - period_r;
                                
            }
               
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(null, "fail inserted "+ex);
            }
            
            reminder_r = deadline_index_r - current_index_r; //r_reminder = r_deadline - rDate "i.date";
            reminder_availability_r = reminder_r - period_r;
                
            return  reminder_availability_r ;
            
            /////////////////////////////////////////////////////////////////////// for "deadline index"
            

              
            //query
            /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conr= DriverManager.getConnection("jdbc:mysql://localhost:3306/hc","root","1234");
            JOptionPane.showMessageDialog(null, "successfully connected");
            System.out.print("connected");  
            Statement stmtr=conr.createStatement();
            ResultSet rsr = null;

            
            //وش اسوي بالi?
            // String sqlr= "SELECT * WHERE uniteTimeIndix = '"+i+"' AND idFemployee = '"+emplyee_id+"'";
            //String sql= "SELECT uniteTimeIndix FROM task  WHERE ( date='"+formattedDate+"' and startTime='"+formattedTime+"' ) ";
            //rDate = rsr.getDate("date");
            //String sql = "SELECT uniteTimeIndix FROM task  WHERE ( '"+rDate+"')";
            rsr=stmtr.executeQuery(sql);
             
            if(rsr.next())
            {             
                //int rDate_index = rsr.getInt("uniteTimeIndix");
            }
               
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(null, "fail inserted "+ex);
            }*/
            
            /////////////////////////////////////////////////////////////
            
            // reminder_r = deadline_r - start_index_search_r;
            // reminder_availability_r = reminder_r - period_r;
            
            
            

        }
        
        public void Task_shift(int index_start_put, int task_ID, int period, String Task_name, String femplyee_id_1,String semplyee_id_1, int terminal)
        {
            // عطاني ايرور مع  سيليكت فشلت الستاتيك
            //shift(index_start_put,task_ID,period,Task_name,first_emplyee_id,second_emplyee_id,Deadline,periorty,Tj_save[no_of_culomns],terminal);
            // هنا كويري التمبراري
            if (selected_id != 0)
            {
                
            }
            /*
            
            */
        }
        
         public void make_decision(int start_index_search_d, String Task_ID_d,int period_d, Date deadline_d, int priority_d , String current_emplyee_id_d, String femplyee_id_d, String semplyee_id_d, Date added_date_d)
        {
            //يمكن لان مو كل الداتا من الفونكشن الرئيسية
            
            
            selected_id=0;
            if (current_emplyee_id_d == femplyee_id_d)
            {
                current_emplyee_id_d = semplyee_id_d;
                start_index_search_d = 1;
                Task_Reschedule(start_index_search_d, Task_ID_d, period_d, deadline_d, priority_d, current_emplyee_id_d, femplyee_id_d, semplyee_id_d);
            }
            else
            {
                make_decision(start_index_search_d, Task_ID_d, period_d, deadline_d, priority_d , current_emplyee_id_d, femplyee_id_d, semplyee_id_d, added_date_d);
            }
            //break;
        }
         //كويري
                
            
        
         //public static shift(index_start_put,task_ID,period,Task_name,first_emplyee_id,second_emplyee_id,Deadline,periorty ,Tj_save[no_of_culomns],terminal)

    
    //public static void //current time
         
         
         ////////////////////////////////////////////////////////////////////////////////////////////////////
         //////////////////////////////////////////////////////////////////////////////////////////////////// reshedule

        
    public  void Task_Reschedule(int start_index_search, String Task_ID, int period, Date Deadline,int priority, String current_emplyee_id, String femplyee_id, String semplyee_id)
    {
        //Task_Reschedule(start_index_search, Task_ID, period, Deadline,priority, current_emplyee_id, femplyee_id, semplyee_id);

        int terminal= 0;
        int comp;
        int selected_id=0;
        boolean reschudle_finished=false;
        int index_start_put;
        start_index_search=1;
        terminal=start_index_search + period -1;
        //cuurent_index
        //start_index_search = cuurent_index + 1; // اي اضافة للتاسك تكون للاندكس بعد الحالي ماينفع يضيف شي في نفس الوقت 
        //int currentIndex_s = 0;
        int current_index = GetCurrentIndex();
        
        
        //********************************************************** -----------> { priority 1 }
        for(int i=start_index_search; i <= terminal; i++)
        {
            ////////////////////////////////////////////////////////////////////////// 1
            //if(Tj_ID == comp|| Tj_priority = 0)
            int Tj_ID = 0;
            int Tj_priority = 0;
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hc","root","1234");
            JOptionPane.showMessageDialog(null, "successfully connected");
            
            System.out.print("connected");  
            Statement stmt1=con.createStatement();
            
            ResultSet rs1 = null;
          
            String sql= "SELECT * WHERE uniteTimeIndix = '"+start_index_search+1+"' AND idFemployee = '"+emplyee_id+"'";
            
            if(rs1.next())
            {
                Tj_priority = rs1.getInt("priority");
                Tj_ID = rs1.getInt("idTask"); 
                
            }
            
            

          
    }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, "fail inserted "+ex);
        }
        
        ///////////////////////////////////////////////////////////////////////// 2
         int pre_Tj_ID =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con2= DriverManager.getConnection("jdbc:mysql://localhost:3306/hc","root","1234");
            JOptionPane.showMessageDialog(null, "successfully connected");
            System.out.print("connected");  
            ResultSet rs2 = null;
             int x = i-1;
            String sql2= "SELECT * WHERE uniteTimeIndix = '"+--i+"' AND idFemployee = '"+emplyee_id+"'";
            Statement stmt2=con2.createStatement();
            if(rs2.next())
            {
                //pre_Tj_priority = rs2.getInt("priority");
                pre_Tj_ID = rs2.getInt("idTask");
                
               
            }
            
        }
        catch(Exception ex2){
        JOptionPane.showMessageDialog(null, "fail inserted "+ex2);}
        
        ///////////////////////////////////////////////////////////////////////// 3
        int post_Tj_ID = 0; 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con3= DriverManager.getConnection("jdbc:mysql://localhost:3306/hc","root","1234");
            JOptionPane.showMessageDialog(null, "successfully connected");
            System.out.print("connected");  
            ResultSet rs3 = null;
            
            int y = i+1;
            String sql3= "SELECT * WHERE uniteTimeIndix = '"+ ++i+"' AND idFemployee = '"+current_emplyee_id+"'";
            Statement stmt3=con3.createStatement();
            if(rs3.next())
            {
                //pre_Tj_priority = rs2.getInt("priority");
                post_Tj_ID = rs3.getInt("idTask"); 
                
               
            }
            
        }
        catch(Exception ex3){
        JOptionPane.showMessageDialog(null, "fail inserted "+ex3);}
        
        /////////////////////////////////////////////////////////////////////////////////****************************   ALGORITHM
        
      
        if (i==terminal)  
                {
                    comp = pre_Tj_ID;
                }
        else
                    comp= post_Tj_ID; //يقارن الاندكس باللي بعده ما عدا اذا وصل لاخر اندكس في الفترة يقارن به مع اللي قبله 
                    if(selected_id==0)
                        continue;
                    else {
                        if(Tj_ID == comp || Tj_priority == 0)
                        {
                            if(Tj_priority < priority)
                            {
                                selected_id=0;
                                int reminder_availabiliy= reminder_availabiliy(Task_ID, current_index, period)
;
                                //GetCurrentIndex(reminder_availabiliy_temp);
                                if(Tj_priority == 6 && reminder_availabiliy <= 0)
                                {
                                    selected_id=0;
                                    if(current_emplyee_id==femplyee_id)
                                    {
                                        current_emplyee_id=semplyee_id;
                                        Task_Reschedule(start_index_search, Task_ID, period, Deadline,priority, current_emplyee_id, femplyee_id, semplyee_id);

                                    }
                                    else
                                    {
                                        //make_decision(Task_name_1, period_1, deadline_1, priority_1 , femplyee_id_1, semplyee_id_1, added_date_1);// مااسندنا قيمة صفرية
                                    }
                                    break;
                                }
                                    if(Tj_priority!=0)
                                    {
                                        selected_id=Tj_ID; //temporary
                                    }
                                    if (i==terminal) ////////////////////////????????وراها مكررة؟
                                    {
                                        index_start_put=start_index_search; // just in 7, 8 priority
                                        //Tj_save[no_of_culomns]=selected_id;//ناقصها تكون زي المخزن يحفظ كامل معلومات التي جي عشان ما نفقدها ونوديها تسوي ريسكجول
                                        //temp column
                                        //shift(index_start_put,task_ID,period,Task_name,first_emplyee_id,second_emplyee_id,Deadline,periorty ,Tj_save[no_of_culomns],terminal);
                                        reschudle_finished=true;
                                        break;
                                    }
                            }
                            else if (Tj_priority == priority)//////////////شكل الجي الثانية الي كانت موجودة هي للاندكس؟! 
                            {
                                // shift to second employee
                                selected_id=0;
                                if (current_emplyee_id == femplyee_id)
                                {
                                    current_emplyee_id = semplyee_id;
                                    Task_Reschedule(start_index_search, Task_ID, period, Deadline,priority, current_emplyee_id, femplyee_id, semplyee_id);
                                }
                                else 
                                { 
                                    //make_ decision(Task_name,period,deadline,priority , femplyee_id,semplyee_id,added_date);
                                }
                                break;
                            }
                        }
                        else if (Tj_priority > priority) //في حالة اذا 8 ميتينق مهم   
                        {
                            selected_id=0;
                            if (current_emplyee_id == femplyee_id)
                            {
                                current_emplyee_id = semplyee_id;
                                Task_Reschedule(start_index_search, Task_ID, period, Deadline,priority, current_emplyee_id, femplyee_id, semplyee_id);
                            }
                            else
                            {
                                //make_ decision(Task_name,period,deadline,priority , femplyee_id,semplyee_id,added_date);
                            }
                            break;
                        }
                    }
        }
            


                        


                            
                                
                                
                            
                          
                                        

                                            
                                            
                                            
                                            /*
                             else if (Tj[j].periorty==Ts_periorty) {
selected_id=0;
if (current_emplyee_id==femplyee_id){
current_emplyee_id=semplyee_id;

reschudle(start_index_search,period,Task_ID,current_emplyee_id,femplyee_id,semplyee_id,Deadline,periorty);

}else { make_ decision(Task_name,period,deadline,priority , femplyee_id,semplyee_id,added_date); }
exit;//خروج لكن الشرط انتفى بالتالي اذا فيه لوب قبل مفترض تكمل بالاي بلس ون
}

                                    
*/
                                }
                            
                                
                        }
                    }
//if ( Tj[j].periorty==6&&reminder_availabiliy()<=0) //ما حطينا هنا المتغيرات اللي لازم تتمرر

//selected_id=0;
//if (current_emplyee_id==femplyee_id){
//current_emplyee_id=semplyee_id;


                    
                
    
    
}
            //
            
            // if(Tj[unit_time_index-1] == Tj[unit_time_index]  \\ لما يعارض ID tasks معه, راح يوقف
            //if(Ts[priority] > Tj[priority])//  بتكون قبل الشرط الاساسي
            //Tnew = Tj;  \\ call function
            //Tj = Ts;
            //Ts = Tnew;

        }
        }

        
        
       
   


