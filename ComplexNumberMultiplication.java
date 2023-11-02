public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        int[] a = parse(num1);
        int[] b = parse(num2);
        int real = a[0] * b[0] - a[1] * b[1];
        int imag = a[0] * b[1] + a[1] * b[0];
        return real + "+" + imag + "i";
    }
    private int[] parse(String num){
        String[] parts = num.split("\\+");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1].substring(0, parts[1].length() - 1))};
    }
}
