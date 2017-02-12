package JacobsonKarel;

public class JacobsonKarel {
	
	private static double estimatedRTT = 4;
	private static double deviation = 1;
	
	public static void main (String[] args) {
		double timeoutVal = estimatedRTT + 4 * deviation;
		int n = 0;
		while (timeoutVal >= 4.0) {
			timeoutVal = getNewTimeoutVal(1);
			n++;
		}
		System.out.println(n);
	}
	
	public static double getNewTimeoutVal (double sampleRTT) {
		double difference = sampleRTT - estimatedRTT;
		estimatedRTT = estimatedRTT + (difference / 8);
		deviation = deviation + (Math.abs(difference) - deviation)/8;
		return estimatedRTT + 4 * deviation;
	}
}
