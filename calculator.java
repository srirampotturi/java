import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("***********-------------------CALCULATOR-------------------***********");
        Scanner sc=new Scanner(System.in);
        double re=0;
        boolean bo=true;
        while(true)
        {
            double a=re;
            if(bo==true)
            {
                System.out.print("Enter A value ");
                a=sc.nextFloat();
                bo=false;
            }
            System.out.print("1.+\n2.-\n3.*\n4./\n5.^\n6.%\n7.=\n8.CA\nEnter Your Choice: ");
            int ch=sc.nextInt();
            if(ch>=1&&ch<=6)
            {
                System.out.print("Enter B value ");
                float b=sc.nextFloat();
            }
            if(ch==1)
            {
                re=a+b;
                System.out.println(a+" + "+b+"="+re);
            }
            else if(ch==2)
            {
                re=a-b;
                System.out.println(a+"-"+b+"="+re);
            }
            else if(ch==3)
            {
                re=b*a;
                System.out.println(a+"*"+b+"="+re);
            }
            else if(ch==4)
            {
                re=a/b;
                System.out.println(a+"/"+b+"="+re);
            }
            else if(ch==5)
            {
                re=Math.pow(a,b);
                System.out.println(a+"^"+b+"="+re);
            }
            else if(ch==6)
            {
                re=a%b;
                System.out.println(a+"%"+b+"="+re);
            }
            else if(ch==7)
            {
                System.out.println(re);
            }
            else if(ch==8)
            {
                re=0;
                bo=true;
            }
     
        }
    }
}
