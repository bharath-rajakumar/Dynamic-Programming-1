import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int number_of_delegates = 0;
				int number_of_panels = 0;
				String temp_delegate_reader;
				int min_panel_size = 0;
				int max_panel_size = 0;
				int temp_size = 0;
				int temp_panel_size = 0;
				int temp_d_i_j = 0;
				Boolean flag = false;
				ArrayList<Integer> panel_size = new ArrayList<Integer>();
				//case 1
				//ArrayList<String> delegates = new ArrayList<String>(Arrays.asList("R","R","R","D","D","D","R","R","R","R","D","D","D","D","R","D","R","R","D","D"));
				//int temp_number_of_panels = 3;
				//case 2
				ArrayList<String> delegates = new ArrayList<String>(Arrays.asList("R","R","R","D","D","D","R","R","R","R","D","D","D","D","R","D","R","R","D","D"));
				int temp_number_of_panels = 5;
				//case 3
				//ArrayList<String> delegates = new ArrayList<String>(Arrays.asList("D","D","R","R","D","R","R","D","D","R","D","R","R","D","R","D","D","D","R","R","R","R","R","R","R","D","R","D","D","R","R","D","D","D","R","R","D","R","R","D","D","D","D","D","D","R","D","D","R","R","R","D","D","D","D","R","D","R","R","D","R","D","D","R","D","D","R","D","D","D"));
				//int temp_number_of_panels = 5;
				//case 4
				//ArrayList<String> delegates = new ArrayList<String>(Arrays.asList("D","D","R","R","D","R","R","D","D","R","D","R","R","D","R","D","D","D","R","R","R","R","R","R","R","D","R","D","D","R","R","D","D","D","R","R","D","R","R","D","D","D","D","D","D","R","D","D","R","R","R","D","D","D","D","R","D","R","R","D","R","D","D","R","D","D","R","D","D","D"));
				//int temp_number_of_panels = 4;
				//case 5
				//ArrayList<String> delegates = new ArrayList<String>(Arrays.asList("D","D","R","R","D","R","R","D","D","R","D","R","R","D","R","D","D","D","R","R","R","R","R","R","R","D","R","D","D","R","R","D","D","D","R","R","D","R","R","D","D","D","D","D","D","R","D","D","R","R","R","D","D","D","D","R","D","R","R","D","R","D","D","R","D","D","R","D","D","D"));
				//int temp_number_of_panels = 3;
				//case 6
				//ArrayList<String> delegates = new ArrayList<String>(Arrays.asList("D","R","R","R","D","R","R","R","D","R","D","D","D","D","R","D","R","R","D","D","R","D","R","D","R","R","R","R","R","D","R","R","R","R","R","D","D","D","D","R","D","D","R","D","D","D","D","D","D","R","D","D","R","R","D","D","D","R","R","R","D","D","R","R","R","D","D","R","D","D"));
				//int temp_number_of_panels = 5;
				ArrayList<Integer> team_size = new ArrayList<Integer>();
				
				//Scanner inputReader = new Scanner(System.in);
				
				/*System.out.println("Enter the number of delegates(N)");
				number_of_delegates = inputReader.nextInt();
				System.out.println("Enter the number of issues/panels(K) to be formed");
				number_of_panels = inputReader.nextInt();*/
				
				number_of_delegates = delegates.size();
				number_of_panels = temp_number_of_panels;
				System.out.println("Panel Size " + delegates.size());
				System.out.println("Number of panels " + temp_number_of_panels);
									
				/*System.out.println("Enter the order of arrival for Team Daredevils(D) and Razorbacks(R)");
				for(int i = 0; i < number_of_delegates; i++)
				{
					temp_delegate_reader = inputReader.next();
					if((temp_delegate_reader.equalsIgnoreCase("D"))||(temp_delegate_reader.equalsIgnoreCase("R")))
					{
						//Convert it to upper case
						delegates.add(temp_delegate_reader.toUpperCase());
					}
					else
					{
						System.out.println("Enter D for Daredevils or R for Razerbacks");
						i = i - 1;
					}
				}*/
				
				//Find the minimum and maximum size of each panel
				min_panel_size = (int) Math.ceil((2*(double)number_of_delegates)/(3*(double)number_of_panels));
				max_panel_size = (int) Math.floor((4*number_of_delegates)/(3*number_of_panels));
				
				System.out.println("min size " + min_panel_size);
				System.out.println("max size " + max_panel_size);
				//Store all possible sizes in an arraylist
				for(int i = min_panel_size; i <= max_panel_size; i++)
				{
					panel_size.add(i);
				}
						
				System.out.println("The arrival order of the delegates are");
				System.out.println(delegates);
				
				System.out.println("The various panel sizes that can be formed are:");
				System.out.println(panel_size);
				//Create an array to store the results of minimum discord
				int d[][] = new int [number_of_panels + 1][number_of_delegates + 1];
				int best[][] = new int [number_of_panels + 1][number_of_delegates + 1];
				
				System.out.println("Discord Table");
				
				//Calculate discord for all possible positions and team sizes and store it in an array
				//Array row will vary from 0 to 20 
				for(int  i = 0; i < number_of_panels + 1; i++) 
				{
					for(int j = 0; j  <  number_of_delegates + 1; j++)  
					{
						if((i==0)&&(j==0))
						{
							d[i][j] = 0; //base case d[0][0] to form the 0th panel with 0 delegates
						}
						else if((i==0)&&(j<=number_of_delegates)) 
						{
							d[i][j] = -1; //assign d[o][j] to -1 (ie to form 0 panels with 1 to 20 delegates the discord will be -1)
						}
						else if (j < min_panel_size)
						{
							d[i][j] = -1; //assign d[i][j] to -1 (ie to form i panels with less than min_panel_size 
						}				  //the discord will be -1)
						else
						{
							d[i][j] = -1;
							
							for(int k = min_panel_size; k <= max_panel_size; k++)
							{
								
								if(j - k < 0)
								{
									temp_d_i_j = -1;				//neglect such cases					
								}
								else if (d[i - 1][j-k] == -1)
								{
									temp_d_i_j = -1;				//neglect such cases					
								}
								else 
								{										
									temp_d_i_j = d[i-1][j-k] + discord(j-k+1,j,delegates);																			
								}
								//check if temp_d_i_j is the minimum discord for d[i][j]								
								if( (temp_d_i_j >= 0 && temp_d_i_j <  d[i][j]) || d[i][j] == -1)
								{
									d[i][j] = temp_d_i_j ;
									best[i][j] = j-k;
								}																
							}													
						}
						System.out.print("d[" + i +"]["+ j + "]" + d[i][j] + ",");
						System.out.print("B[" + best[i][j] +"],");
					}
					System.out.println();
				}			
				
				//Print the team size for which the discord was minimal
				for(int i = number_of_panels; i >= 1 ; i--)
				{
					for(int j = number_of_delegates; j > 0 ; j--)
					{					
						System.out.println(",i:" + i + ",j:" + j);
						team_size.add(j - best[i][j]);
						System.out.println(j - best[i][j]);	
						j = best[i][j] + 1;
						i = i - 1;
					}
				}
				
				System.out.println("Team Size: ");
				Collections.reverse(team_size);
				System.out.println(team_size);
				System.out.println("Minimum discord: " + d[number_of_panels][number_of_delegates]);
	}
	
	public static int discord(int s, int f, ArrayList<String> d)
	{
		int start_pos = s;
		int finish_pos = f;
		int count_of_R = 0;
		int count_of_D = 0;
		int temp = 0;
		ArrayList<String> team = new ArrayList<String>(d);		
		int team_discord = 0;
		for(int i = start_pos - 1; i <= finish_pos - 1; i++)
		{
			if(team.get(i).equals("R"))
			{
				count_of_R = count_of_R + 1;
			}
			else
			{
				count_of_D = count_of_D + 1;
			}
		}
		temp = Math.abs(count_of_D - count_of_R);
		team_discord = (int)Math.pow((temp),2);
		return team_discord;
	}

}
