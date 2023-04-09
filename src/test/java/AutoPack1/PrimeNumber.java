package AutoPack1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        int count,m = 0;
        if (num ==0 || num == 1)
        {
            System.out.println(num + " is not a prime number");
        }
        m=num/2;
        for (int i =2; i<=m;i++)
        {
            if(num%i==0){

            }
        }

            }

    }