package bichel.yauhen.shapes;

/**
 * 3D Shape PlatonicSolid
 */
public class PlatonicSolid extends Shape3D {

    private final int q;
    private final int p;
    private final double a;

    public PlatonicSolid(int q, int p, double a) {
        this.q = q;
        this.p = p;
        this.a = a;
    }

    /**
     * Computes area of platonic solid
     * @return area of platonic solid
     */
    @Override
    public double area() {
        double faces = computeFaces();
        return Math.pow(a / 2, 2) * faces * p * (1 / Math.tan(Math.PI / p));
    }

    /**
     * Computes volume of platonic solid
     * @return perimeter of platonic solid
     */
    @Override
    public double volume() {
        //compute the dihedral angle Theta
        double sinOfDihedralAngle = computeSinOfDihedralAngle();
        double tanOfDihedralAngle = computeTanOfDihedralAngle(sinOfDihedralAngle);

        //then compute the inradius
        double inradius = (a / 2) * (1 / Math.tan(Math.PI / p)) * tanOfDihedralAngle;
        return inradius * area() / 3.0;
    }


    private double computeSinOfDihedralAngle() {
        return Math.cos(Math.PI / q) / Math.sin(Math.PI / p);
    }

    private double computeTanOfDihedralAngle(double sinOfDihedralAngle) {
        return sinOfDihedralAngle / (Math.sqrt(1 - Math.pow(sinOfDihedralAngle, 2)));
    }

    private double computeFaces() {
        return 4 * q / (4 - (p - 2) * (q - 2));
    }
}
