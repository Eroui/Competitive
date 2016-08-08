import java.util.Scanner;

public class FroshWeek{
    public static long inv=0;
    public static void Merge(int [] A, int p, int q, int r){
        int n1,n2;
        n1= q-p+1;
        n2 = r-q;
        int j=0,i=0;
        int L[] = new int[n1+2];
        int R[] = new int[n2+2];
        
        for(i=1; i<=n1; i++){
            L[i]=A[p+i-1];
        }
        for(j=1; j<=n2; j++){
            R[j]=A[q+j];
        }
        L[n1+1] = Integer.MAX_VALUE;
        R[n2+1] = Integer.MAX_VALUE;
        i=1; 
        j=1;
        for(int k=p; k<=r; k++){
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }
            else{
                A[k]=R[j];
                j++;
                inv = inv+n1-i+1;
            }
        }
    }
    
    public static void MergeSort(int [] A, int p, int r){
        if(p < r){
            int q;
            q = (p+r)/2;
            MergeSort(A, p, q);
            MergeSort(A, q+1, r);
            Merge(A,p,q,r);
        }
    }
    
 public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] v = new int[1000001];
        int n;
        while(sc.hasNext()){
            inv = 0;
            n= sc.nextInt();
            for(int i=1; i<=n; i++)v[i]=sc.nextInt();
            
            MergeSort(v, 1, n);
            System.out.println(inv);
        }
    }
}