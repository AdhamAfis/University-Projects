import java.util.Scanner;

public class ComplexClac {
	private Scanner sc = new Scanner(System.in);

	public ComplexClac() {
		double realNum, imaginaryNum;
		System.out.print("Enter Real Number : ");
		realNum = sc.nextDouble();
		System.out.print("Enter Imaginary Number : ");
		imaginaryNum = sc.nextDouble();
		System.out.println("Choose Equation : 0.Linear\t\t1.Exponential\t\t2.Trigonometric\t\t3.Hyperbolic");
		int eqnChoice = sc.nextInt();
		switch (eqnChoice) {
			case 0 -> lnEqn(realNum, imaginaryNum);
			case 1 -> expoEqn(realNum, imaginaryNum);
			case 2 -> trigEqn(realNum, imaginaryNum);
			case 3 -> hyperbolicEqn(realNum, imaginaryNum);
		}
	}

	public void lnEqn(double realNum, double imaginaryNum) {
		double[] angleNR = computeAngleAndR(realNum, imaginaryNum);
		double lnRealNum = Math.log(angleNR[0]);
		if (angleNR[0] != 1 && angleNR[1] != 0 && angleNR[0] != 0) {
			System.out.println("ln(" + angleNR[0] + ") + i(" + ((angleNR[1] / Math.PI) + "π") + ")  --> " + lnRealNum + " + i(" + angleNR[1] + ")");
		} else if (angleNR[0] == 1 && angleNR[1] != 0) {
			System.out.println("i(" + ((angleNR[1] / Math.PI) + " π") + ")");
		} else if (angleNR[0] == 0) {
			throw new IllegalArgumentException("Error");
		} else if (angleNR[0] != 1) {
			System.out.println("ln(" + angleNR[0] + ") --> " + lnRealNum);
		} else System.out.println(0);

	}

	public void expoEqn(double real, double imaginaryNum) {
		double realExpo = Math.exp(real);
		double imaginaryCos = Math.cos(Math.toRadians(imaginaryNum));
		double imaginarySin = Math.sin(Math.toRadians(imaginaryNum));
		if (real != 0 && imaginaryNum != 0) {
			System.out.println("e^(" + real + ")(Cos (" + imaginaryNum + ") + iSin(" + imaginaryNum + ")) --> " + realExpo * imaginaryCos + " + i " + imaginarySin);
		} else if (real == 0 && imaginaryNum != 0) {
			System.out.println("(Cos(" + imaginaryNum + ") + iSin(" + imaginaryNum + ")) --> " + imaginaryCos + " + i" + imaginarySin);
		} else {
			System.out.println("e^(" + real + ") --> " + realExpo);
		}
	}

	public void trigEqn(double realNum, double imaginaryNum) {
		System.out.println("0.Sin\t\t1.Cos");
		int trigChoice = sc.nextInt();
		switch (trigChoice) {
			case 0 -> sinEqn(realNum, imaginaryNum);
			case 1 -> cosEqn(realNum, imaginaryNum);

		}

	}

	public static void sinEqn(double realNum, double imaginaryNum) {
		double realSin = Math.sin(Math.toRadians(realNum));
		double imaginarySinh = Math.sinh(Math.toRadians(imaginaryNum));
		double realCos = Math.cos(Math.toRadians(realNum));
		double imaginaryCosh = Math.cosh(Math.toRadians(imaginaryNum));
		if (realNum != 0 && imaginaryNum != 0) {
			System.out.println("Sin(" + realNum + ")Cosh(" + imaginaryNum + ") + iCos(" + realNum + ")Sinh(" + imaginaryNum + ") --> " + (realSin * imaginaryCosh) + " + i(" + (realCos * imaginarySinh) + ")");
		} else if (realNum == 0 && imaginaryNum != 0) {
			System.out.println("iSinh(" + imaginaryNum + ") --> " + "i(" + imaginarySinh + ")");
		} else {
			System.out.println("Sin(" + realNum + ") --> " + Math.sin(Math.toRadians(realNum)));
		}
	}

	public static void cosEqn(double realNum, double imaginaryNum) {
		double realSin = Math.sin(Math.toRadians(realNum));
		double imaginarySinh = Math.sinh(Math.toRadians(imaginaryNum));
		double realCos = Math.cos(Math.toRadians(realNum));
		double imaginaryCosh = Math.cosh(Math.toRadians(imaginaryNum));
		if (realNum != 0 && imaginaryNum != 0) {
			System.out.println("Cos(" + realNum + ")Cosh(" + imaginaryNum + ") − iSin(" + realNum + ")Sinh(" + imaginaryNum + ") -->" + (realCos * imaginaryCosh) + " - i(" + (realSin * imaginarySinh) + ")");
		} else if (realNum == 0 && imaginaryNum != 0) {
			System.out.println("Cosh(" + imaginaryNum + ") --> " + imaginaryCosh);
		} else {
			System.out.println("Cos(" + realNum + ") --> " + realCos);
		}
	}

	public void hyperbolicEqn(double realNum, double imaginaryNum) {
		System.out.println("0.Sinh\t\t1.Cosh");
		int trigChoice = sc.nextInt();
		switch (trigChoice) {
			case 0 -> sinhEqn(realNum, imaginaryNum);
			case 1 -> coshEqn(realNum, imaginaryNum);

		}

	}

	public static void sinhEqn(double realNum, double imaginaryNum) {
		double imaginarySin = Math.sin(Math.toRadians(imaginaryNum));
		double realSinh = Math.sinh(Math.toRadians(realNum));
		double imaginaryCosh = Math.cos(Math.toRadians(imaginaryNum));
		double realCosh = Math.cosh(Math.toRadians(realNum));
		if (realNum != 0 && imaginaryNum != 0) {
			System.out.println("Sinh(" + realNum + ")Cos(" + imaginaryNum + ") + iCosh(" + realNum + ")Sin(" + imaginaryNum + ") --> " + (realSinh * imaginaryCosh) + " + i(" + (realCosh * imaginarySin) + ")");
		} else if (realNum == 0 && imaginaryNum != 0) {
			System.out.println("iSin(" + imaginaryNum + ") --> " + "i(" + imaginarySin + ")");
		} else {
			System.out.println("Sinh(" + realNum + ") --> " + realSinh);
		}
	}

	public static void coshEqn(double realNum, double imaginaryNum) {
		double imaginarySin = Math.sin(Math.toRadians(imaginaryNum));
		double realSinh = Math.sinh(Math.toRadians(realNum));
		double imaginaryCosh = Math.cos(Math.toRadians(imaginaryNum));
		double realCosh = Math.cosh(Math.toRadians(realNum));
		if (realNum != 0 && imaginaryNum != 0) {
			System.out.println("Cosh(" + realNum + ")Cos(" + imaginaryNum + ")+iSinh(" + realNum + ")Sin(" + imaginaryNum + ") --> " + (realCosh * imaginaryCosh) + " + i (" + (realSinh * imaginarySin) + ")");
		} else if (realNum == 0 && imaginaryNum != 0) {
			System.out.println("Cos(" + imaginaryNum + ") --> " + imaginaryCosh);
		} else {
			System.out.println("Cosh(" + realNum + ") --> " + realCosh);
		}
	}


	public static double[] computeAngleAndR(double realNum, double imaginaryNum) {
		double[] AngleNR = new double[2];
		AngleNR[0] = Math.sqrt(Math.pow(realNum, 2) + Math.pow(imaginaryNum, 2)); // Calculates R
		AngleNR[1] = Math.atan2(imaginaryNum, realNum); // Calculates The Angle
		return AngleNR; // AngleNR[0] = Angle  AngleNR[1] = R
	}

}
