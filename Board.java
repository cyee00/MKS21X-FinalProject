// http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
import java.util.Random;

public class Board{
  public Block[][] board=new Block[4][4];
  boolean shifted=false;
  /**Creates a new 4 by 4 board.
  */
  public Board(){
    for (int i=0;i<4;i++){
      for (int n=0;n<4;n++){
        board[i][n]=new Block(i,n,0);
      }
    }
    Random rng=new Random();
    board[randomRow(rng.nextInt())][randomCol(rng.nextInt())].setValue(2);
  }

  /**Randomly generates a new row.
  *@param x is the seed, randomly generated in constructor.
  */
  public static int randomRow(int x){
    Random rng = new Random(x);
    int row=java.lang.Math.abs(rng.nextInt()%4);
    return row;
  }

  /**Randomly generates a new column.
  *@param x is the seed, randomly generated in constructor.
  */
  public static int randomCol(int x){
    Random rng = new Random(x);
    int col=java.lang.Math.abs(rng.nextInt()%4);
    return col;
  }

/*
  /**Creates a new x by x board.
  *@param x is the new width and height.

  public Board(int x){
    Block[][] board;
    for (int i=0;i<x;i++){
      for (int n=0;n<x;n++){
        board[i][n]=new Block(i,n,0);
      }
    }
  }
  */


  /**Returns the width/height of the board.
  *@return the width/height as an int.
  */
  public int getWidth(){
    return board.length;
  }

  public int valueAt(int r,int c){
    return board[r][c].getValue();
  }

  public Block blockAt(int r,int c){
    return board[r][c];
  }



  /**Deletes a block. Helper function for combining blocks.
  *@param b is the block to be deleted.
  */
  public void delete(Block b){
    b.setValue(0);
  }


  /**Combines two blocks.
  *@param t is the block that will remain.
  *@param o is the block that will be combined into Block this and be deleted.
  */
  public void combine(Block t, Block o){
    delete(o);
    t.setValue(t.getValue()*2);
  }

  public boolean move(Block block, String s){
    if (s.equals("left")){
      if (valueAt(block.getRow()-1,block.getCol())==0){
        delete(blockAt(block.getRow()-1,block.getCol()));
      }
    }
    if (s.equals("right")){

    }
    if (s.equals("up")){

    }
    if (s.equals("down")){

    }
    return true;
  }

  /**Configurates Terminal to look like 2048.
  */
  public static void putString(Board b, int x, int y, Terminal t){
    t.moveCursor(x,y);
    String s="";
    for (int r=0;r<b.getWidth();r++){
      for (int c=0;c<b.getWidth();c++){
        if (b.valueAt(r,c)==0){
          s+="\u25A0";
        }else{
          s+=b.valueAt(r,c);
        }
        if (c!=b.getWidth()-1){
          s+="\t";
        }
      }
      s+="\n\n";
    }
    for(int i = 0; i < s.length();i++){
      t.putCharacter(s.charAt(i));
    }
  }

  public static void main(String[]args){
    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();
    terminal.setCursorVisible(false);
    Board b = new Board();
    putString(b,0,0,terminal);
    boolean running = true;
    while (running){
      Key key = terminal.readInput();
      if (key!=null){
        boolean won=false;
        Random rng = new Random();
                if (key.getKind() == Key.Kind.Escape) {
                    terminal.exitPrivateMode();
                    running = false;
                }
                if (key.getKind() == Key.Kind.ArrowLeft) {
                  for (int i=1;i<b.getWidth();i++){
                    for (int n=0;n<b.getWidth();i++){
                      b.move(b.blockAt(i,n),"left");
                    }
                  }
                    if (won){
                      terminal.exitPrivateMode();
                      System.out.println("You got 2048 and won!!");
                    }
                }

                if (key.getKind() == Key.Kind.ArrowRight) {
                  for (int i=b.getWidth()-1;i>-1;i--){
                    for (int n=b.getWidth()-1;n>-1;n--){
                      b.move(b.blockAt(i,n),"right");
                    }
                  }
                  if (won){
                    terminal.exitPrivateMode();
                    System.out.println("You got 2048 and won!!");
                  }
                }

                if (key.getKind() == Key.Kind.ArrowUp) {
                  for (int n=1;n<b.getWidth();n++){
                    for (int i=0;i<b.getWidth();i++){
                      b.move(b.blockAt(i,n),"up");
                    }
                  }
                  if (won){
                    terminal.exitPrivateMode();
                    System.out.println("You got 2048 and won!!");
                  }
                }

                if (key.getKind() == Key.Kind.ArrowDown) {
                  for (int n=b.getWidth()-1;n>-1;n--){
                    for (int i=b.getWidth()-1;i>-1;i--){
                      b.move(b.blockAt(i,n),"down");
                    }
                  }
                  if (won){
                    terminal.exitPrivateMode();
                    System.out.println("You got 2048 and won!!");
                  }
                }
      }
    }
  }
}
