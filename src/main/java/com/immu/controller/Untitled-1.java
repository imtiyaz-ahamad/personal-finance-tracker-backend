import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        if(T>=1 && T<=100){
        while(T>0){
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        if((A+B)%2!=0 || (B+C)%2!=0 )
            System.out.println("YES");
        else
            System.out.println("NO");    
        
            T--;
        }
        
        }
        
        
    }
}