package coding_test_problem;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class SWEA1288 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input/swea_1288.txt"));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			boolean stop = true;
			int count =1;
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				temp.add(j);
			}

			while(stop) {
				int num1 = num*count;

				int [] arr = String.valueOf(num1)
						.chars()
						.map(c->c-'0')
						.toArray();
				for (int j = 0; j < arr.length; j++) {

					for (int k = 0; k < temp.size(); k++) {

						
						
						if(temp.get(k).equals(arr[j])) {
							temp.remove(k);
							break;
							
						}
					}
					
				}

//				System.out.println(temp);
				if(temp.isEmpty()) {
					stop = false;
				}
				count++;
				
			}
			
			System.out.printf("#%d %d",i+1,num*(count-1));
			System.out.println();

		}

	
		

	}

}
