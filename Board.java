import java.util.ArrayList;
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
  *@param t is the block that will remain.
  *@param o is the block that will be combined into Block this and be deleted.
  */
  public void combine(Block t, Block o){
    delete(o);
    t.setValue(t.getValue()*2);
    //insert code to change its physical appearance
  }

  public static void main(String[]args){
    Terminal terminal = TerminalFacade.createTextTerminal();
      System.out.println(terminal.getTerminalSize()+"");
    terminal.enterPrivateMode();
    terminal.setCursorVisible(false);
    boolean running = true;
    while (running){
      Key key = terminal.readInput();
      if (key!=null){
        boolean won=false;
        if (key.getKind() == Key.Kind.Escape) {
					terminal.exitPrivateMode();
					running = false;
				}
				if (key.getKind() == Key.Kind.ArrowLeft) {

				}

				if (key.getKind() == Key.Kind.ArrowRight) {

				}

				if (key.getKind() == Key.Kind.ArrowUp) {

				}

				if (key.getKind() == Key.Kind.ArrowDown) {

				}
        if (won){running=false;}
      }
    }
  }
}
