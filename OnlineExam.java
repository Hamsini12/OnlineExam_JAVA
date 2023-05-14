import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
class sample
{
static int marks = 0;
static int totalQuestions = 5;
static final int examtime=5;
static final int remaindertime=1;
static final int submittime=1;
static Timer timer = new Timer();
String username;
String password;
void LoginForm(String username, String password) 
{
this.username = username;
this.password = password;
}
void updateProfile() 
{
Scanner read=new Scanner(System.in);
System.out.print("Enter your new username: ");
String newUsername =read.nextLine();
System.out.print("Enter your new password: ");
String newPassword =read.nextLine();
this.username = newUsername;
this.password = newPassword;
System.out.println("Your profile has been updated.");
}
void updatePassword() 
{
Scanner read=new Scanner(System.in);
System.out.print("Enter your current password: ");
String currentPassword =read.nextLine();
if (currentPassword.equals(this.password)) 
{
System.out.print("Enter your new password: ");
String newPassword =read.nextLine();
this.password = newPassword;
System.out.println("Your password has been updated.");
} 
else 
{
System.out.println("Incorrect password. Password update failed.");
}
}
public void startExam() 
{
Scanner read = new Scanner(System.in);
System.out.println("You have "+examtime+ "minutes to complete the exam.");
System.out.println("Please answer the following questions:");
timer.schedule(new TimerTask() 
{
int remainingtime=examtime - remaindertime;
@Override
public void run() 
{
System.out.println("You have"+remainingtime+" minute to end");
remainingtime--;
if(remainingtime==submittime)
{
System.out.println("You have"+submittime+"mintes for the completion");
}
if(remainingtime==0)
{
timer.cancel();
submitExam();
showmenu();
}
}
},remaindertime*60*1000,60*1000);
System.out.println("Question 1: Statistics is a branch of_______");
System.out.println("a. Civil");
System.out.println("b. Engineering");
System.out.println("c. Mathematics");
System.out.println("d. CSE");
String answer1 = read.nextLine();
if (answer1.equalsIgnoreCase("c")) 
{
marks += 1;
}
System.out.println("Question 2:Find the mean 0f 2,3,4,5,6");
System.out.println("a. 2");
System.out.println("b. 3");
System.out.println("c. 4");
System.out.println("d. 1");
String answer2 = read.nextLine();
if (answer2.equalsIgnoreCase("c")) 
{
marks += 1;
}
System.out.println("Question 3: What is the output of print(a1%in%t) statement");
System.out.println("a. FALSE");
System.out.println("b. TRUE");
System.out.println("c. 0");
System.out.println("d. 1");
String answer3 = read.nextLine();
if (answer3.equalsIgnoreCase("a")) 
{
marks += 1;
}
System.out.println("Question 4: write.csv() function is used to");
System.out.println("a. import the data");
System.out.println("b. export the sata");
System.out.println("c. a&b");
System.out.println("d. None of the Above");
String answer4 = read.nextLine();
if (answer4.equalsIgnoreCase("b")) 
{
marks += 1;
}
System.out.println("Question 5: head()function is used to");
System.out.println("a. Display first 5 rows");
System.out.println("b. Display first 4 rows");
System.out.println("c. Display first 2 rows");
System.out.println("d. Display first 3 rows");
String answer5 = read.nextLine();
if (answer5.equalsIgnoreCase("a")) 
{
marks += 1;
}
submitExam();
sessionclose();
}
public static void submitExam() 
{
timer.cancel();
System.out.println("Time's up! Your exam has been submitted automatically.");
System.out.println("You scored " + marks + " out of " + totalQuestions + ".");
}
public void showmenu()
{
Scanner read=new Scanner(System.in);
System.out.println("1. Update Profile");
System.out.println("2. Update Password");
System.out.println("3. StartExam");
System.out.println("4. logout");
System.out.println("choose one of the above options");
int choice = read.nextInt();
switch(choice)
{
    case 1:
          updateProfile();
          showmenu();
          break;
    case 2:
          updatePassword();
          showmenu();
          break;
    case 3:
          startExam();
          break;
    case 4:
          logout();
          break;
    default:
           System.out.println("Invalid choice. Please try again.");
           showmenu();
}
}
public void showmenu1()
{
Scanner read=new Scanner(System.in);
System.out.println("1. Update Profile");
System.out.println("2. Update Password");
System.out.println("3. logout");
System.out.println("choose one of the above options");
int choice = read.nextInt();
switch(choice)
{
    case 1:
          updateProfile();
          showmenu1();
          break;
    case 2:
          updatePassword();
          showmenu1();
          break;
    case 3:
          logout();
          break;
    default:
           System.out.println("Invalid choice. Please try again.");
           showmenu1();
}
}
void sessionclose()
{
showmenu1();
}
void logout()
{
Scanner read=new Scanner(System.in);
System.out.println("___THANK YOU!___");
read.close();
System.exit(0);
}
}
class OnlineExam
{
public static void main(String args[])
{
Scanner read=new Scanner(System.in);
System.out.println("Username:");
String username=read.nextLine();
System.out.println("Password:");
String password=read.nextLine();
sample s=new sample();             
s.LoginForm(username,password);
s.showmenu();
}
}
