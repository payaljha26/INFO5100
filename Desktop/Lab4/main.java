package Lab4;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//MAIN 

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in) ; //Collection i/p from the user
		
		int count = 0 ;
		List<Double> pointsTotal = new LinkedList<>();
		List<Double> earnedPoints = new LinkedList<>();
		List<Double> assignmentPercentage = new LinkedList<>();
		Weighted_Grades wg = new Weighted_Grades () ;
		
		do {
			System.out.println("Please enter the number of subjects for which the grades is to calcualted");
			count = sc.nextInt();
			
		} while (count <= 0);
		
		for ( int i = 0 ; i< count ; i++ ) {
			System.out.println (" Enter the Total points for the Subject");
			pointsTotal.add(sc.nextDouble());
			System.out.println (" Enter the Earned points for the Subject");
			earnedPoints.add(sc.nextDouble());
			System.out.println (" Enter the assignment % for the Subject");
			assignmentPercentage.add(sc.nextDouble());
			
		}
		
		wg.setpointsTotal(pointsTotal);
		wg.setearnedPoints(earnedPoints);
		wg.setassignmentPercentage(assignmentPercentage);
		
		System.out.println("The total grade is : " + wg.gettotalGrade(count));
		
	}

}
