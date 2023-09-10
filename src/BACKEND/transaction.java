package BACKEND;

public class transaction  {
    public  transaction(String address_rec , String address_sen , int ammount){

        if(wallet_check( address_rec) && wallet_check(address_sen) == true)
        {

            if(check_balance(address_sen) > ammount)
            {

                //set the new balance on the wallets
            }
        }


    }

    public static boolean wallet_check (String adress){
       String address_db;
        address_db="address";
       //retrive address from database,
        return address_db.equals(adress);
    }
    public int check_balance(String address_sen){
        
        int balance;
        balance = 2000;
        //get the balance of the sender_balance
        return balance;
    }




}
