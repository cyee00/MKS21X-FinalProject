import java.util.ArrayList;

public class Board{
  private ArrayList<ArrayList<Block>> board;

  /**Creates a new 4 by 4 board.
  */
  public Board(){
    for (int i=0;i<4;i++){
      for (int n=0;n<4;n++){
        board.get(i).add(new Block(i,n,0));
      }
    }
  }

  /**Creates a new x by x board.
  *@param x is the new width and height.
  */
  public Board(int x){
    //insert constraints on x here
    for (int i=0;i<x;i++){
      for (int n=0;n<x;n++){
        board.get(i).add(new Block(i,n,0));
      }
    }
  }
}
