package V;

import java.util.Scanner;
import M.Transaction;

public class MenuTransaction {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean loops = true;
        int Number;
        //functions x = new functions(); 
        while(loops)
        {
            System.out.println  ("<-----MENU----->");
            System.out.println  ("เลือก 1 = 'โอนเงิน' ");
            System.out.println  ("เลือก 2 = 'สืบค้นข้อมูลธุรกรรม' ");
            System.out.println  ("เลือก 3 = 'ยืนยัน' ");
            System.out.println  ("เลือก 4 = 'ยกเลิก' ");
            System.out.print    ("กรุณาใส่หมายเลขที่ต้องการทำ -> ");  Number = sc.nextInt();
            if(1 <= Number || Number <=4)
            {
                switch(Number)
                {
                    case 1 : System.out.println("ยืนยันคำสั่ง 'โอนเงิน'");
                             Transaction transaction =  Tranfer(sc);
                             //addController(transection)
                             //transaction.ID_Source_Wallet; in c
                             break;
                    case 2 : System.out.println("ยืนยันคำสั่ง 'สืบค้นข้อมูลธุรกรรม'");
                             String Search = Search_Info_Transaction(sc);
                             break;
                    case 3 : System.out.println("ยืนยันคำสั่ง 'ยืนยัน'");
                             String submit = submitTransaction(sc);
                             //submitController(submit);
                             break;
                    case 4 : System.out.println("ยืนยันคำสั่ง 'ยกเลิก'");
                             loops = false;
                             break;
                    default : System.out.println("กรุณาใส่เลขที่กำหนด");
                }
            }
        }
    }
    
    public static Transaction Tranfer(Scanner sc)
    {
        String ID_Transaction,ID_Source_Wallet,ID_Destination_Wallet;
        double Coin,Coin_Rate;
        System.out.println("<-----ข้อมูลธุรกรรม----->");
        System.out.print("กรุณาใส่หมายเลขธุรกรรม -> ");
        ID_Transaction        = sc.next();
        System.out.print("กรุณาใส่หมายเลขกระเป๋าเงินต้นทาง -> ");
        ID_Source_Wallet      = sc.next();
        System.out.print("กรุณาใส่หมายเลขกระเป๋าเงินปลายทาง -> ");
        ID_Destination_Wallet = sc.next();
        System.out.print("กรุณาใส่หมายจำนวนเหรียญที่ต้องการทำธุรกรรม -> ");
        Coin                  = sc.nextDouble();
        System.out.print("กรุณาใส่อัตราแลกเปลี่ยน -> ");
        Coin_Rate             = sc.nextDouble();

        return new Transaction(ID_Transaction,ID_Source_Wallet,ID_Destination_Wallet,Coin,Coin_Rate);

    }
    public static String submitTransaction(Scanner sc){
        String Transection_ID;
        System.out.print("กรุณาใส่หมายเลขธุรกรรมที่ต้องการยืนยัน -> ");
        Transection_ID = sc.next();
        return Transection_ID;

    }

    public static String Search_Info_Transaction(Scanner sc){
        String Transection_Target;
        System.out.print("กรุณาใส่หมายเลขธุรกรรมที่ต้องการสีบค้นข้อมูล -> ");
        Transection_Target = sc.next();
        
        return Transection_Target;

    }


    // public static Transaction submiTransaction2(Scanner sc){
    //     String Transection_ID,Wallet_ID;
    //     Transection_ID = sc.next();
    //     Wallet_ID = sc.next();
    //     return new Transaction(Transection_ID,Wallet_ID);

    // }
}
