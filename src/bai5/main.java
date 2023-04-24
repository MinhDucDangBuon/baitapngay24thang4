package bai5;

public class main {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
            }
            int gcd = findGCD(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
            if (this.denominator < 0) {
                this.numerator *= -1;
                this.denominator *= -1;
            }
        }

        public Fraction simplify() {
            int gcd = findGCD(this.numerator, this.denominator);
            return new Fraction(this.numerator / gcd, this.denominator / gcd);
        }

        public Fraction inverse() {
            return new Fraction(this.denominator, this.numerator);
        }

        public Fraction subtract(Fraction other) {
            int commonDenominator = findLCM(this.denominator, other.denominator);
            int numerator1 = this.numerator * (commonDenominator / this.denominator);
            int numerator2 = other.numerator * (commonDenominator / other.denominator);
            return new Fraction(numerator1 - numerator2, commonDenominator);
        }

        public Fraction add(Fraction other) {
            int commonDenominator = findLCM(this.denominator, other.denominator);
            int numerator1 = this.numerator * (commonDenominator / this.denominator);
            int numerator2 = other.numerator * (commonDenominator / other.denominator);
            return new Fraction(numerator1 + numerator2, commonDenominator);
        }

        public Fraction multiply(Fraction other) {
            int numerator = this.numerator * other.numerator;
            int denominator = this.denominator * other.denominator;
            return new Fraction(numerator, denominator);
        }

        public Fraction divide(Fraction other) {
            return this.multiply(other.inverse());
        }

        public int compareTo(Fraction other) {
            Fraction diff = this.subtract(other);
            if (diff.numerator == 0) {
                return 0;
            } else if (diff.numerator > 0) {
                return 1;
            } else {
                return -1;
            }
        }

        private int findGCD(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b > 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        private int findLCM(int a, int b) {
            return (a * b) / findGCD(a, b);
        }

        @Override
        public String toString() {
            if (this.denominator == 1) {
                return Integer.toString(this.numerator);
            } else {
                return String.format("%d/%d", this.numerator, this.denominator);
            }
        }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 9);
        Fraction f2 = new Fraction(5, 6);

        Fraction sum = f1.add(f2);
        Fraction product = f1.multiply(f2);

        System.out.println(sum);
        System.out.println(product);

        Fraction f3 = new Fraction(2, 3);
        Fraction f4 = new Fraction(3, 4);

        Fraction diff = f3.subtract(f4);

        System.out.println(diff);

        Fraction f5 = new Fraction(4, 5);
        Fraction f6 = new Fraction(2, 3);

        Fraction quotient = f5.divide(f6);

        System.out.println(quotient);

        Fraction f7 = new Fraction(3, 9);
        Fraction f8 = new Fraction(2, 6);

        int comparison = f7.compareTo(f8);

        System.out.println(comparison);
    }



}
