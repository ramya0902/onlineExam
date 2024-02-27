import java.util.Scanner;
public class OnlineExam{
    private String username;
    private String password;
    private boolean loginid;
    private int  timeleft;
    private int questioncount;
    private int[] useranswer;
    private int[] correctanswer;
     
    public OnlineExam(String username,String password)
    {
        this.username=username;
        this.password=password;
        System.out.println("Successfully your are registered");
        this.loginid=false;
        this.timeleft=10;
        this.questioncount=10;
        this.useranswer=new int[questioncount];
        this.correctanswer=new int[questioncount];
        for(int i=0;i<questioncount;i++)
        {
            correctanswer[i]=(int)Math.round(Math.random());

        }
    }
    public void login(){
        System.out.println("log in to give the Exam");
        Scanner obj=new Scanner(System.in);
        System.out.println("Username:");
        String name=obj.nextLine();
        System.out.println("Password:");
        String inpassword=obj.nextLine();
        if(name.equals(username) && inpassword.equals(password))
        {
            loginid=true;
            System.out.println("Login successful All the Best");

        }
        else
        {
            System.out.println("Login failed,please try again");
        }
    }
    public void logout()
    {
        loginid=false;
        System.out.println("Logout Successfully");
    }
    public void startExam()
    {

        if(!(loginid))
        {
            System.out.println("please login first");
            return;

        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("You have"+timeleft+"minutes to complete exam");
        for(int i=0;i<questioncount;i++)
        {
            System.out.println("Question"+(i+1)+":");
            System.out.println("1.option 1");
            System.out.println("2.option 2");
            System.out.println("Your answer (1 or 2):");
            int ans=scanner.nextInt();
            useranswer[i]=ans;
        }
        System.out.println("Would you like to submit?  \n1:yes \n2:no");
        int n=scanner.nextInt();
        if(n==1)
        {
            submitExam();
        }
        else{
            try{
                Thread.sleep(timeleft*10*1000);

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
                submitExam();
            }

        }
        }
        public void submitExam()
        {
            if(!(loginid))
            {
                System.out.println("Please login first.");
                return;
            }
        
        int res=0;
        for(int i=0;i<questioncount;i++)
        {
            if(useranswer[i]==correctanswer[i])
            {
                res++;
            }
        }
        System.out.println("your score is "+res+"out of"+questioncount+".");
        System.out.println("Best of luck");
        logout();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the username and password");
        String uname=sc.nextLine();
        String pword=sc.nextLine();
        OnlineExam os=new OnlineExam(uname,pword);
        os.login();
        os.startExam();
    }
}