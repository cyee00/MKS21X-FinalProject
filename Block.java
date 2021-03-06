public class Block{
  private int x;
  private int y;
  private int value;
  private boolean shifted=false;

  /**Create a new Block with location at
  *(xcor, ycor) and value val.
  *@param xcor is its new column
  *@param ycor is its new row
<<<<<<< Updated upstream
=======
  *@param val is its value
>>>>>>> Charlotte
  */
  public Block(int xcor, int ycor, int val){
    x=xcor;
    y=ycor;
    value=val;
  }

  /**Returns current value of the block.
  *@return an int.
  */
  public int getValue(){
    return value;
  }

  /**Sets value of the block to int specified.
  *@param newVal is the desired new value.
  */
  public void setValue(int newVal){
    value=newVal;
  }

  /**Move the block to a new location by
  *setting a new x and new y.
  *@param newx is the new column
  *@param newy is the new row
  */
  public void moveTo(int newx, int newy){
    x=newx;
    y=newy;
  }

  public int getRow(){
    return y;
  }

  public int getCol(){
    return x;
  }

    public void shifted(boolean b){
      shifted=b;
    }
}
