/*
 crap Game
Ahmad Alkurdy
02/17/2017
 */
package craps;
import java.util.Scanner;
/**
 *
 * @author ahmad
 */
public class Craps {

    public double balance;
   Scanner in=new Scanner(System.in);
  
   void print_game_rules()
   {
   System.out.println("************Instructions ********************");
   System.out.println("1.A player rolls two dice\n2.If the sum is 7 or 11 on the first throw ,the player wins.\n3.If the sum is 2, 3, or 12 on the first throw (called craps), the player loses (i.e. the house wins).\n4. If the sum is 4, 5, 6, 8, 9, or 10 on the first throw, then the sum becomes the player's \"point.\" \n5.To win, you must continue rolling the dice until you \"make your point\".\n5. The player loses by rolling a 7 before making the point.\n---------------------------------------------\n");
   }
  
   double set_bank_balance ()
   {
   
   balance = 1000;
   return balance;
   }
  
   double get_wager_amount ()
   {
   double wager;
   String statment = chatter();
   System.out.println("enter the wager amount for the round");
   wager=in.nextDouble();
   return wager;
   }
  
   int check_wager_amount (double wager, double balance)
   {
   if(wager > balance)
   return 0;
   else 
    return 1;
   
   }
   int roll_die ()
   {
   int ran = (int )(Math.random() * 6 + 1);
   return ran;
   }
  
   int calculate_sum_dice (int die1_value, int die2_value)
   {
   int sum=die1_value+die2_value;
   System.out.println("your round sum is:"+sum);
   return sum;
   }
  
   int is_win_loss_or_point (int sum_dice)
   {
   if(sum_dice==7 || sum_dice==11 )
   return 1;
   else if(sum_dice==2 ||sum_dice==3||sum_dice==12)
   return 0;
   else
   return -1;
   }
  

int is_point_loss_or_neither (int sum_dice, int point_value)
{
if(sum_dice==7)
return 0;
else if(sum_dice==point_value)
return 1;
else return -1;
}

double adjust_bank_balance (double bank_balance, double wager_amount, int add_or_subtract)
{
if(add_or_subtract==1)
bank_balance+=wager_amount;
else if (add_or_subtract==0)
bank_balance-=wager_amount;
return bank_balance;
}

static String chatter()
{
 String statment = null;
 switch((int)(Math.random()*5))
 {
     case 0:
         statment = "Oh, you are going for boke huh?";
        break;
     case 1:
         statment= "Oh,c'mon take a chance";
         break;
     case 2:
         statment = "Oh,you are up big now";
         break;
     case 3:
         statment = "You are a cheat!!!!";
         break;
     case 4:
         statment = "It's gonna get better";
        break;
 }
return statment;
}

    
    public static void main(String[] args) {
          Scanner on=new Scanner(System.in);
   Craps c= new Craps();
   c.print_game_rules ();
   int point=0;
   String statment = null;
   double initial_balance=c.set_bank_balance();
   double balance=initial_balance;
   int i=1;
   int x=0;
   int val=0;
   while(true)
   {
       statment = chatter();
       double wager=c.get_wager_amount();
      
       x=c.check_wager_amount(wager,balance);
       if(x==0)
       {System.out.println("wager is greater than the current balance in your account\n do you want to choose anothe wagon amount:If yes press 1 else press any key to exit");
       int ch=on.nextInt();
       if(ch==1)
           continue;
       else
           break;
       }
       int r1=c.roll_die();
       int r2=c.roll_die();
       int sum=c.calculate_sum_dice(r1,r2);
       if(i==1)
       {
              val=c.is_win_loss_or_point(sum);
           if (val==1)
           {
               System.out.println("Hey!!! you won the game");
               balance=c.adjust_bank_balance (balance, wager, 1);
                break;
           }
           else if( val==0)
           {
               System.out.println("oops!!! you loss the the game");
               balance= c.adjust_bank_balance (balance, wager, 0);
               break;
           }
           else
           {
           point=sum;
               System.out.println("you neither win nor loss.got your point continue with next round");
               
           }
       }
           else
           {
           val=c.is_point_loss_or_neither (sum,point);
               if(val==1)
               {
                   System.out.println("Hey!!! you won the game");
                   balance=c.adjust_bank_balance (balance, wager, 1);
                    break;
                }
               else if( val==0)
               {
                   System.out.println("oops!!! you loss the the game");
                   balance= c.adjust_bank_balance (balance, wager, 0);
                   break;
               }
               else if (val==-1)
                   System.out.println("continue with next throw");
           }
       
       i++;
   }
      
              
              
       }
}
    

