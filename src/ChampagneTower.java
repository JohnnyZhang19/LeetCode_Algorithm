public class ChampagneTower {

    public static void main(String[] args) {
        System.out.println(champagneTower(5,2,2));
    }

    public static double champagneTower(int poured, int query_row, int query_glass){
        double[][] ca = new double[100][100];
        ca[0][0] = poured;
        for (int row = 0; row <= query_row; row++){
            for (int column = 0; column <= row; column++){
                double d = (ca[row][column] - 1.0)/2;
                if (d > 0){
                    ca[row+1][column] += d;
                    ca[row+1][column+1] += d;
                }
            }
        }
        return Math.min(1,ca[query_row][query_glass]);
    }
}
