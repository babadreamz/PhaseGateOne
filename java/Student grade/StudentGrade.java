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
			}	
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
			average[row]= sum / numberOfSubjects;
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
	System.out.println("STUDENT\tSUB1\tSUB2\tSUB3\tTOTAL\tAVERAGE\tPOSITION");
	for(int row = 0; row < dosier.length; row++){
		System.out.print("STUDENT 1" + (row + 1) + "\t");
		for(int col = 0; col < dosier[row].length; col++){
			System.out.print(dosier[row][col] + "\t");
			}
		System.out.printf("%d\t%.2f\t%d\n", total[row], average[row], position[row]);
		}
}
}  