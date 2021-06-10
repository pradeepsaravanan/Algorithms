package chapter2;
import java.util.Scanner;

public class insertion_sort {
    public static void main(String[] args) {
        int a[];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of elements:");
        int n = in.nextInt();
        a = new int[n]; 
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        sort(a);
        in.close();
    }

    static void sort(int[] a)
    {
        int i=0,j=0,key;
        for(j=1;j<a.length;j++){
            key = a[j];
            i = j-1;
            while(i>=0 && a[i]>key){
                a[i+1] = a[i];
                i = i-1;
            }
            a[i+1] = key;
        }
        for(i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
