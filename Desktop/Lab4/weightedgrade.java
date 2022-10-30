package Lab4;
import java.util.List ;


public class Weighted_Grades {
	
	private List<Double> pointsTotal ;
	private List<Double> earnedPoints ;
	private List<Double> assignmentPercentage ;
	public List<Double> getpointsTotal() {
		return pointsTotal ;
	}
	
	public void setpointsTotal ( List<Double> pointsTotal) {
		this.pointsTotal = pointsTotal ;
	}
	
	public List<Double> getearnedPoints () {
		return earnedPoints ;
	}
	
	public void setearnedPoints (List<Double> earnedPoints) {
		this.earnedPoints = earnedPoints ;
	}
	public List<Double> getassignmentPercentage() {
		return assignmentPercentage;
	}
	
	public void setassignmentPercentage (List<Double> assignmentPercentage) {
		this.assignmentPercentage = assignmentPercentage ;
	}
	private Double calculatetotalWeightedGrade ( double pointsTotal , double earnedPoints , double assignmentPercentage) {
		return ((earnedPoints/pointsTotal) * (assignmentPercentage));
	}
	
	
	public String gettotalGrade (int Count) {
		double totalWeightedGrade = 0.0 ;
		
		for ( int i = 0 ; i < Count ; i++) {
			double weightedgrade  = calculatetotalWeightedGrade (pointsTotal.get(i), earnedPoints.get(i), assignmentPercentage.get(i));
			totalWeightedGrade = totalWeightedGrade + weightedgrade ;
		}
		
		System.out.println (" The Total weighted grade is "+ totalWeightedGrade);
		
		private void getFinalGrade() {
			
			if(totalWeightedgrade >= 90 && totalWeightedgrade <= 100) {
				grade = 'A';
			}
			else if (totalWeightedgrade >= 80 && totalWeightedgrade < 90) {
				grade = 'B';
			}
			else if (totalWeightedgrade >= 70 && totalWeightedgrade< 80) {
				grade = 'C';
			}
			else if (totalWeightedgrade >= 60 && totalWeightedgrade < 70) {
				grade = 'D';
			}
			else {
				grade ='F';
			}
		}
		
		public void printScore() {
			getTotalWeightedGradeArray();
			getFinalGrade();
			System.out.println("Your total weighted grade is --> "+ totalWeightedgrade + " and your final grade is --> "+ grade);	
		}
	}

}
