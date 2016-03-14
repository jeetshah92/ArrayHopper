import java.io.*;
import java.util.*;

public class Solution {
    
public static ArrayList<Integer> nodes = new ArrayList<Integer>();
    
public static int minJumps(int[] arr, int l, int h)
{
if (arr[l] <= 0)
	return Integer.MAX_VALUE;
	
 if(arr[l] > h) {
    nodes.add(l);
    return 1;
  }
    
nodes.add(0);
int numOfHops = 0;
int max = 0;
int minIndex = 0;
for (int i = l; i <= h;)
{
    numOfHops++;
    
    
    max = (i+1) + arr[i+1];
    minIndex = i + 1;
    for(int j = i+1; j<= (i + arr[i]) && j<=h; j++) {
        
        
        if( j + arr[j] >= max && arr[j] > 0 ) {
            
            minIndex = j;
            max = j + arr[j];
        }
     }
      
     if(arr[minIndex] <= 0) {
         
         return Integer.MAX_VALUE;
     }
     
    
     if(minIndex + arr[minIndex] > h) {
         
         nodes.add(minIndex);
         break;
         
     } else {
         
         nodes.add(minIndex);
         i =  minIndex;
         
     }
}


return numOfHops+1;
}
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
         ArrayList<Integer> input = new ArrayList<Integer>();
         Scanner sc =  new Scanner(System.in);
         while(sc.hasNextInt()){
            
             input.add(sc.nextInt());
         }
        
        int[] arr = new int[input.size()];
        int i = 0;
        for(int a : input) {
            
            arr[i++] = a;
        }
        
        if(arr.length > 0) {
            
            int minLength = minJumps(arr,0,arr.length - 1);
            if(minLength != Integer.MAX_VALUE) {
                
                int count = 0 ;
                
                for(int a : nodes) {
                    
                    if(count == 0) {
                        
                        System.out.print(a+",");
                        count++;
                        
                    } else {
                        
                        System.out.print(" "+a+",");
                    }
                }
                System.out.print(" out");
                System.out.println();
                
            } else {
                
                 System.out.print("failure");
                 System.out.println();
                
            }
            
        } else {
            
            System.out.print("failure");
            System.out.println();
        }
        
    }
}