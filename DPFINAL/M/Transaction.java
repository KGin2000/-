package M;

import java.lang.Thread.State;

interface ControlObject{
    String ToString();
}

public class Transaction implements ControlObject
{
    public String ID_Transaction;
    public String ID_Source_Wallet;
    public String ID_Destination_Wallet;
    public double Coin;
    public double Coin_Rate;

    // public Transaction(String ID_Transaction,String ID_Source_Wallet){
    //     this.ID_Transaction = ID_Transaction;
    //     this.ID_Source_Wallet = ID_Source_Wallet;
    // }//<<

    public Transaction(Transaction transaction)
    {
        this.ID_Transaction         = transaction.ID_Transaction;
        this.ID_Source_Wallet       = transaction.ID_Source_Wallet;
        this.ID_Destination_Wallet  = transaction.ID_Destination_Wallet;
        this.Coin                   = transaction.Coin;
        this.Coin_Rate              = transaction.Coin_Rate;
    }

    public Transaction(){}

    public Transaction(String ID_Transaction,String ID_Source_Wallet,String ID_Destination_Wallet,double Coin,double Coin_Rate)
    {
        this.ID_Transaction         = ID_Transaction;
        this.ID_Source_Wallet       = ID_Source_Wallet;
        this.ID_Destination_Wallet  = ID_Destination_Wallet;
        this.Coin                   = Coin;
        this.Coin_Rate              = Coin_Rate;
    }
    @Override
    public String ToString()
    {
        return ID_Destination_Wallet+","+ID_Source_Wallet+","+ID_Destination_Wallet+","+Coin+","+Coin_Rate;
    }
}
