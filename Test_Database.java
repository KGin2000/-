package M;

import java.util.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

import M.Transaction_Line.state;
public class Test_Database
{
    static private String db_name = "dpfinal";
    static private String name = "root";
    static private String pass = "";
    static private String hostname = "127.0.0.1";
    static private String db_driver = "com.mysql.cj.jdbc.Driver";
    static private Connection conn ;
    static String url = "jdbc:mysql://"+hostname+"/"+ db_name;
    

    public static void main(String[]args)
    {
        int Number;
        Scanner sc = new Scanner(System.in);
        boolean loops = true;
        int num;
        while(loops)
        {
            System.out.println ("<-----MENU----->");
            System.out.println ("เลือก 1 = 'โอนเงิน' ");
            System.out.println ("เลือก 2 = 'สืบค้นข้อมูลธุรกรรม' ");
            System.out.println ("เลือก 3 = 'ยืนยัน' ");
            System.out.println ("เลือก 4 = 'ยกเลิก' ");
            System.out.print   ("กรุณาใส่หมายเลขที่ต้องการทำ -> ");  num = sc.nextInt();
            System.out.println();
            if(1 <= num ||num <=4)
            {
                switch(num)
                {
                    case 1 : System.out.println ("ยืนยันคำสั่ง 'โอนเงิน'");
                             Insert_Transaction_Data();
                             break;
                    case 2 : System.out.println ("ยืนยันคำสั่ง 'สืบค้นข้อมูลธุรกรรม'");
                             Insert_Transaction_Line();
                             break;
                    case 3 : System.out.println ("ยืนยันคำสั่ง 'ยืนยัน'");
                             Update_AwaitingToCom();
                             break;
                    case 4 : System.out.println ("ยืนยันคำสั่ง 'ยกเลิก'");
                             Update_AwaitingToIncom();
                             break;
                    default : System.out.println("ไม่มีรายการที่กำหนด กรุณาใส่เลขใหม่อีกครั้ง");  
                               
                }
                
            } 
        }
    }


    public Test_Database() 
    {
        try 
        {
            Class.forName(db_driver);
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }

    public static int Insert_Transaction_Data()
    {
        Scanner sc = new Scanner(System.in);
        String ID_Transaction = GenTransection_ID();
        System.out.print ("Source Wallet ID -> ");      String ID_Source_Wallet= sc.next();
        System.out.print ("Destination Wallet ID -> "); String ID_Destination_Wallet= sc.next();
        System.out.print ("Coin amount -> ");           String Coin = sc.next();
        double Coin_Rate= CS_KMITL_COIN_GR();

        String sql = "INSERT INTO `dpfinal`.`transaction` (`ID_Transaction`,`ID_Source_Wallet`,`ID_Destination_Wallet`,`Coin`,`Coin_Rate`) \n" +
                     "VALUE ('" + ID_Transaction+" ',' "+ID_Source_Wallet+" ',' "+ID_Destination_Wallet+" ',' "+Coin+" ',' "+Coin_Rate+"');";
        try
        {
            conn = DriverManager.getConnection(url,name,pass);
            Statement myStmt = conn.createStatement();
            myStmt.executeUpdate(sql);
            myStmt.close();
            return 1;
        }
        catch(Exception e) 
        {  
            return 0;
        }
    }

    public static int Insert_Transaction_Line()
    {
    String ID_Transaction_Line = "TH1234567891011";
    String sql = "INSERT INTO `dpfinal`.`transaction_line` (`ID_Transaction_Line`,`State`) \n" +
                 "VALUE ('" + ID_Transaction_Line+" ',' "+state.Awaiting+"');";
    try
    {
            conn = DriverManager.getConnection(url,name,pass);
            Statement myStmt = conn.createStatement();
            myStmt.executeUpdate(sql);
            myStmt.close();
            return 1;
    }
    catch(Exception e) 
    {  
            return 0;
    }
}
    public static int Update_AwaitingToCom()
    { //เปลี่ยนจาก awaiting เป็น Complete
        String ID_Transaction_Line = "TH1234567891011";
        String sql = "UPDATE transaction_line\n"+
                     "SET State = 'Complete'\n"+
                     "WHERE ID_Transaction_Line = '"+ID_Transaction_Line+"' AND State = '"+state.Awaiting+"';";
        try
        {
            conn = DriverManager.getConnection(url,name,pass);
            Statement myStmt = conn.createStatement();
            myStmt.executeUpdate(sql);
            myStmt.close();
            return 1;
        }
        catch(Exception e) 
        { 
            return 0;
        }
            
    }

        public static int Update_AwaitingToIncom(){ //เปลี่ยนจาก awaiting เป็น Incomplete
            String sql = "UPDATE transaction_line\n"+
                         "SET State = 'Incomplete'\n"+
                         "WHERE State = 'Awaiting';";
        try{
        conn = DriverManager.getConnection(url,name,pass);
        Statement myStmt = conn.createStatement();
        myStmt.executeUpdate(sql);
        myStmt.close();
        return 1;
        }
        catch (Exception e)
        {
        System.out.println(e); 
        return 0;
        } 
    }
   
    public static String GenTransection_ID(){
        String Transection_id = "";
        String [] arr = {"A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O"
                        ,"P","Q","R","S","T","U","V","X","Y","Z"};
        Random random = new Random();
        String s = String.valueOf(System.currentTimeMillis());
        int select1 = random.nextInt(arr.length);
        int select2 = random.nextInt(arr.length);
        Transection_id = arr[select1]+arr[select2]+s; 
        return Transection_id;
    }

    public static double CS_KMITL_COIN_GR() {

        double x = Math.random() * 500;
        System.out.println(x);
        return x;
    }

}

