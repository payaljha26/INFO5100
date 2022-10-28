public class WeightedGrades {
    
	// Variable declaration
	private double pointTotal;
	private double earnedPoints;
	private double assignmentPercentage;
	private double totalWeightedGrade;
	javaapp gui;
	
	
	// Using Getters and Settters
	
	//Method to get the Point Total Value
	public double getPointTotal() {
		return pointTotal;
	}
	
	//Method to set the Point Total Value
	public void setPointTotal(double pointTotal) {
		this.pointTotal = pointTotal;
	}
	
	//Method to get Earned Points Value
	public double getEarnedPoints() {
		return earnedPoints;
	}
	
	//Method to set the Earned Points Value
	public void setEarnedPoints(double earnedPoints) {
		this.earnedPoints = earnedPoints;
	}
	
	//Method to get the Assignment Percentage value
	public double getAssignmentPercentage() {
		return assignmentPercentage;
	}
	
	//Method to set the Assignment Percentage value
	public void setAssignmentPercentage(double assignmentPercentage) {
		this.assignmentPercentage = assignmentPercentage;
	}
	
	//Method to get and calculate the Weighted Grade value
	public double getTotalWeightedGrade() {
		return calculate();
	}
	
	public void totalWeightedGrade(double totalWeightedGrade) {
		this.totalWeightedGrade = totalWeightedGrade;
	}
	
	//Method to calculate and return the Weighted Grade Value
	private double calculate() {
		totalWeightedGrade = (earnedPoints/ pointTotal) * assignmentPercentage;
		return totalWeightedGrade;
	}
	
	
}
