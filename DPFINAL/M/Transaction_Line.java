package M;

public class Transaction_Line<String,State> implements ControlObject
{
    public enum state{Awaiting,Incomplete,Complete}
    public String Transaction_ID;
    public State state;

    public Transaction_Line(String Transaction_ID,State state)
    {
        this.Transaction_ID = Transaction_ID;
        this.state = state;
    }

    /*public Transaction_Line(Transection_Line transection_Line){
        this.Transection_ID = (String)transection_Line.Transection_ID;
        this.state = (State)transection_Line.state;
    }*/
    
    @Override
    public java.lang.String ToString(){
        return Transaction_ID+" "+state;
    }
}
