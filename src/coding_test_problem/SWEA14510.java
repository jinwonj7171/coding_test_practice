package coding_test_problem;

import java.io.*;
import java.util.*;

public class SWEA14510 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input/swea_14510.txt"));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= tc; i++) {
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st  = new StringTokenizer(br.readLine()," ");
            List <Integer> arr = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int max = Collections.max(arr);

            for (int j = 0; j < num; j++) {
                arr.set(j,max -arr.get(j));
            }
            int one =0;
            int two =0;
            for (int diff : arr) {
            	one += diff %2;
            	two += diff/2;
            	
				
			}
            while(two > one +1) {
            	two --;
            	one +=2;
            }
            int day;
            if (one>two) {
            	day = one*2 -1;
            }
            else {
            	day = two *2;
            }
            sb.append("#").append(i).append(" ").append(day).append("\n");
            
         

            
            
            
        }
        System.out.println(sb);


        

    }
    }