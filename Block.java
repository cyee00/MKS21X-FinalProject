public class Block{
  private int x;
  private int y;
  private int value;
  public Block(int xcor, int ycor, int val){
    x=xcor;
    y=ycor;
    value=val;
  }
  public int getValue(){
    return value;
  }
  public void setValue(int newVal){
    value=newVal;
  }
  public void moveTo(int newx, int newy){
    x=newx;
    y=newy;
  }
}
