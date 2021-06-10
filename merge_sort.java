package chapter2;

import java.util.Scanner;

public class merge_sort {
    public static int a[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of elements:");
        int n = in.nextInt();
        a = new int[n]; 
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        mergeSort(a,0,n-1);
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
        in.close();;
    }

    public static void mergeSort(int[] a, int p, int r){
         
        if(p<r){
           int q = (p+r)/2;
           mergeSort(a, p, q);
           mergeSort(a, q+1, r);
           merge(a,p,q,r);
        }
    }

    public static void merge(int[] a,int p,int q,int r) {
        int n1 = q-p+1;
        int n2 = r-q;
        int L[] = new int[n1+1];
        int R[] = new int[n2+1];

        for(int i=0;i<n1;i++){
            L[i] = a[p+i];
        }
        for(int j=0;j<n2;j++){
            R[j] = a[q+1+j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i=0;
        int j=0;
        for(int k=p;k<=r;k++){
            if(L[i]<= R[j]){
                a[k] = L[i];
                i++;
            }
            else{
                a[k] = R[j];
                j++;
            }
        }
    }
}
