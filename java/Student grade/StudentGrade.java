import java.util.Scanner;
public class StudentGrade{
public static void main(String [] args){

	Scanner scan = new Scanner(System.in);
	System.out.print("How many students do you have? ");
	int numberOfStudent = scan.nextInt();
	System.out.print("How many subjects do they offer? ");
	int numberOfSubjects = scan.nextInt();	

	int[][] dosier = new int[numberOfStudent][numberOfSubjects];
	for(int stRow = 0; stRow < dosier.length; stRow++){
		System.out.println("Enter the scores for student" + (stRow + 1) + ": ");
		for(int stCol =0; stCol < dosier[stRow].length; stCol++){
			System.out.print("Subject" + (stCol + 1) + ": ");
			dosier[stRow][stCol] = scan.nextInt();
			while (true){
				if(dosier[stRow][stCol] < 0 || dosier[stRow][stCol] > 100){
					System.out.print("Scores must be between 1 and 100 only");
					}
				else{
					break;
					}
				}
			}
		System.out.println();	
		}
	int[] total = new int[numberOfStudent];
	double[] average = new double[numberOfStudent];
	int[] position = new int[numberOfStudent];

	for(int row = 0; row < dosier.length; row++){
		int sum = 0;
		for(int col = 0; col < dosier[col].length; col++){
			sum += dosier[row][col];
			}
			total[row] = sum;
			average[row]= (double)sum / numberOfSubjects;
		}	
	for(int row = 0; row < dosier.length; row++){
		int pos = 1;
		for(int col = 0; col < dosier.length; col++){
			if(total[col] > total[row]){
				pos++;
				}
			}	
		position[row] = pos;
		}
	System.out.println("STUDENT\t\tSUB1\tSUB2\tSUB3\tTOTAL\tAVERAGE\tPOSITION");
	for(int row = 0; row < dosier.length; row++){
		System.out.print("STUDENT " + (row + 1) + "\t");
		for(int col = 0; col < dosier[row].length; col++){
			System.out.print(dosier[row][col] + "\t");
			}
		System.out.printf("%d\t%.2f\t%d\n\n", total[row], average[row], position[row]);
		}
		

		

	for(int row = 0; row < numberOfSubjects; row++){
		int sumOfSubject = 0;
		double averageOfSubject = 0;
		int pass = 0;
		int fail = 0;
		int count = 0;
		int counter = 0;
		int maxScore = 0;
		int lowScore = 100;
		System.out.println("SUBJECT SUMMARY\nSUBJECT" + (row + 1) + ": \n");
		for(int col = 0; col < dosier.length; col++){
			if(dosier[col][row] > maxScore){
				maxScore = dosier[col][row];
				count = col;
			}
			if(dosier[col][row] < lowScore){
				lowScore = dosier[col][row];
				counter = col;
				}
			if(dosier[col][row] > 40){
				pass += 1;
				}else{ fail += 1;}
			sumOfSubject += dosier[col][row]; 
			}
			averageOfSubject =(double) sumOfSubject / numberOfStudent;
			System.out.println("Highest Scoring student is : Student " + (count + 1) + " Scoring " + maxScore);
			System.out.println("Lowest Scoring student is : Student " + (counter + 1) + " Scoring " + lowScore);
			System.out.println("Total is: " + sumOfSubject);
			System.out.println("Average is: " + averageOfSubject);
			System.out.println("Number of passes: " + pass);
			System.out.println("Number of failures: " + fail);
		}
}
}  