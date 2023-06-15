public class TictacToe {

    public static void main(String[] args) {
        System.out.println(validBoard(new String[]{"XXX", "OX ", "O O"}));
    }

    public static boolean validBoard(String[] board){
        //X赢了 X - O = 1     XXX
        //O赢了 X - O = 0     OOO
        //胜负未分 X - O = 1    X - O = 0
        int xCount = 0, oCount = 0;
        for (String row : board){
            for (char ch : row.toCharArray()){
                if (ch == 'X'){
                    xCount++;
                }
                if (ch =='O'){
                    oCount++;
                }
            }
        }
        if (xCount != oCount && xCount - oCount != 1){
            return false;
        }
        if (win(board,"XXX") && xCount-oCount!=1){
            return false;
        }
        if (win(board,"OOO") && xCount-oCount!=0){
            return false;
        }
        return true;
    }

    static boolean win(String[] board, String flag){
        for (int i = 0; i < 3; i++){
            //纵向3连
            if (flag.equals(""+board[0].charAt(i)+board[1].charAt(i)+board[2].charAt(i)))
                return true;

            //横向3连
            if (flag.equals(board[i]))
                return true;
        }
        // \向3连
        if (flag.equals(""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2)))
            return true;
        // /向3连
        if (flag.equals(""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0)))
            return true;
        return false;
    }

}
