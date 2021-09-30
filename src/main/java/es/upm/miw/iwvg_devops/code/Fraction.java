package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) this.numerator / this.denominator;
    }

    public boolean isProper() {
        return this.numerator < this.denominator;
    }

    public boolean isImproper() {
        return !isProper();
    }

    public boolean isEquivalent(Fraction otherFraction) {
        return this.numerator * otherFraction.getDenominator() == this.denominator * otherFraction.getNumerator();
    }

    public Fraction add(Fraction otherFraction) {
        if (this.denominator == otherFraction.getDenominator())
            return new Fraction(this.numerator + otherFraction.numerator, this.denominator);
        else {
            int denominator = lcm(this.denominator, otherFraction.getDenominator());
            int numerator = denominator / this.denominator * this.numerator +
                    denominator / otherFraction.getDenominator() * otherFraction.getNumerator();
            return simplify(new Fraction(numerator, denominator));
        }
    }

    public Fraction multiply(Fraction otherFraction) {
        int newNum = this.numerator * otherFraction.getNumerator();
        int newDen = this.denominator * otherFraction.getDenominator();
        return simplify(new Fraction(newNum, newDen));
    }

    public Fraction divide(Fraction otherFraction) {
        int newNum = this.numerator * otherFraction.getDenominator();
        int newDen = this.denominator * otherFraction.getNumerator();
        return simplify(new Fraction(newNum, newDen));
    }

    private int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        int absHigherNumber = Math.max(absA, absB);
        int absLowerNumber = Math.min(absA, absB);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private Fraction simplify(Fraction fraction) {
        int gcd = gcd(fraction.getNumerator(), fraction.getDenominator());
        return new Fraction(fraction.getNumerator() / gcd, fraction.getDenominator() / gcd);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
