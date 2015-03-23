
package connectfour;

public class ConnectFour {

    public static String[][] user = new String[10][3];
    public static int[][] score = new int[10][2];
    public static String history[][] = new String[10][10];
    public static String player1, player2;
    public static int num = 0;
    public static int current = 0;
    
    public static void main(String[] args) {
      for(int x = 0; x < 10; x++){
            score[x][0] = 0;
            score[x][1] = 0;
          for(int y = 0; y < 3; y++){
            user[x][y] = " ";}
          for(int z = 0; z < 10; z++){
              history[x][z] = " ";
          }
      }
      new StartScreen().setVisible(true);
    }
    
}
