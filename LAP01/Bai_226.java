
import javax.swing.JOptionPane;

public class Bai_226 {
    public static void main(String[] args) {

        // Phương trình bậc nhất
        JOptionPane.showMessageDialog(null, "Linear Equation: ax + b = 0");

        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions");
            } else {
                JOptionPane.showMessageDialog(null, "No solution");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Solution x = " + x);
        }

        // Hệ phương trình
        JOptionPane.showMessageDialog(null, "System of equations:\na1*x + b1*y = c1\na2*x + b2*y = c2");

        double a1 = Double.parseDouble(JOptionPane.showInputDialog("Enter a1:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
        double c1 = Double.parseDouble(JOptionPane.showInputDialog("Enter c1:"));

        double a2 = Double.parseDouble(JOptionPane.showInputDialog("Enter a2:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));
        double c2 = Double.parseDouble(JOptionPane.showInputDialog("Enter c2:"));

        double D = a1 * b2 - a2 * b1;
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;

        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions");
            } else {
                JOptionPane.showMessageDialog(null, "No solution");
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            JOptionPane.showMessageDialog(null, "Solution:\nx = " + x + "\ny = " + y);
        }

        // Phương trình bậc hai
        JOptionPane.showMessageDialog(null, "Quadratic Equation: ax^2 + bx + c = 0");

        double qa = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double qb = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double qc = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        if (qa == 0) {
            if (qb == 0) {
                if (qc == 0) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions");
                } else {
                    JOptionPane.showMessageDialog(null, "No solution");
                }
            } else {
                double x = -qc / qb;
                JOptionPane.showMessageDialog(null, "Linear solution x = " + x);
            }
        } else {
            double delta = qb * qb - 4 * qa * qc;

            if (delta > 0) {
                double x1 = (-qb + Math.sqrt(delta)) / (2 * qa);
                double x2 = (-qb - Math.sqrt(delta)) / (2 * qa);
                JOptionPane.showMessageDialog(null, "Two solutions:\nx1 = " + x1 + "\nx2 = " + x2);
            } else if (delta == 0) {
                double x = -qb / (2 * qa);
                JOptionPane.showMessageDialog(null, "Double root x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "No real solution");
            }
        }
    }
}