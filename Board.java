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

  /**Returns the width/height of the board.
  *@return the width/height as an int.
  */
  public int getWidth(){
    return board.size();
  }

  /**Deletes a block. Helper function for combining blocks.
  *@param b is the block to be deleted.
  */
  public void delete(Block b){
    b.setValue(0);
    //insert code to reset its physical appearance
  }

  /**Combines two blocks.
  *@param this is the block that will remain.
  *@param other is the block that will be combined into Block this and be deleted.
  */
  public void combine(Block this, Block other){
    delete(other);
    this.setValue(this.getValue()*2);
    //insert code to change its physical appearance
  }
}
