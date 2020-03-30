
package GameLogic;
/*
class for the game:
have methods: 
    -constructor() -> initialize gameBoard with '-' and symbol with 'X'
    -constructor(char c)->initialize gameBoard with - and symbol with c
    -changeSymbol() -> X to O and viseversa
    -checkColumns() -> return if there is a win in the columns or not
    -checkRows() ->return if there is a win in the Rows or not
    -checkCross() -> return if there is a win in both corsses or not
    -checkForwin() -> return if the is a win in cols or rows or cross
    -playMove(int x, int y) -> assign current symbol in board[x][y] and increse moves +1
    -printBoard()-> print the board in console
    -resetBoard() -> re initialize gameBoard with '-' and moves=0
    -setSymbol(char c) -> assign c to symbol
    -getSymbol()-> return current symbol
    -getMoves() -> return current moves count
*/
public class GameLogic
{
    
    BoardPostion[][] gameBoard;
    BoardPostion[] winPostions;
    char symbol;
    int moves;
    boolean isWin=false;

    public GameLogic() // constructor
    {
        symbol='X';
        moves=0;
        gameBoard=new BoardPostion[3][3];
        winPostions=new BoardPostion[3];
        for(int i=0;i<3;i++) // initialize gameBoard with -
        {
            
            for(int j=0;j<3;j++)
            {
                gameBoard[i][j]=new BoardPostion(i,j,'-');
            }
           
        }
    }
    public GameLogic(char c)//if the player choose he want to start with 'O'
    {
        symbol=c;
        System.out.println("symbol "+symbol);
         gameBoard=new BoardPostion[3][3];
        moves=0;
        winPostions=new BoardPostion[3];
        for(int i=0;i<3;i++) // initialize gameBoard with -
        {
            
            for(int j=0;j<3;j++)
            {
                gameBoard[i][j]=new BoardPostion(i,j,'-');
            }
           
        }
    }
    
   public void printBoard()
    {
        for(int i=0;i<3;i++)
        {
            System.out.print("|");
            for(int j=0;j<3;j++)
            {
                System.out.print(gameBoard[i][j].value+"|");
            }
            System.out.println("");
        }
    }
   public void changeSymbol()
    {
        if(symbol=='X') symbol='O';
        else symbol='X';
    }
    
   public void resetBoard()
    {
        for(int i=0;i<3;i++)
        {
           
            for(int j=0;j<3;j++)
            {
                gameBoard[i][j].value='-';
               
            }
           
        }
        isWin=false;
        winPostions=new BoardPostion[3];
        moves=0;
        changeSymbol();
    }
    
   public boolean checkForWin()
    {
        
        return checkColumns()||checkCross()||checkRows();
        
    }
    
   public boolean checkRows()
    {
        boolean retval=false;
        for(int i=0;i<3;i++)
        {
            if(gameBoard[i][0].getValue()==gameBoard[i][1].getValue()&&gameBoard[i][1].getValue()==gameBoard[i][2].getValue()&&(gameBoard[i][2].getValue()=='O'||gameBoard[i][2].getValue()=='X'))
            {
                winPostions[0]=gameBoard[i][0];
                winPostions[1]=gameBoard[i][1];
                winPostions[2]=gameBoard[i][2];
 
               retval=true;
            }
        }
        return retval;
    }
    
  public   boolean checkColumns()
    {
        boolean retval=false;
        for(int i=0;i<3;i++)
        {
            if(gameBoard[0][i].getValue()==gameBoard[1][i].getValue()&&gameBoard[1][i].getValue()==gameBoard[2][i].getValue()&&(gameBoard[2][i].getValue()=='O'||gameBoard[2][i].getValue()=='X'))
            {
                 winPostions[0]=gameBoard[0][i];
                winPostions[1]=gameBoard[1][i];
                winPostions[2]=gameBoard[2][i];
               retval=true;
            }
        }
        return retval;
    }
     
   public  boolean checkCross()
     {
         boolean retval=false;
        for(int i=0;i<3;i++)
        {
            if(gameBoard[0][0].getValue()==gameBoard[1][1].getValue()&&gameBoard[1][1].getValue()==gameBoard[2][2].getValue()&&(gameBoard[2][2].getValue()=='O'||gameBoard[2][2].getValue()=='X'))
            {
               retval=true;
                winPostions[0]=gameBoard[0][0];
                winPostions[1]=gameBoard[1][1];
                winPostions[2]=gameBoard[2][2];
            }
            else if(gameBoard[0][2].getValue()==gameBoard[1][1].getValue()&&gameBoard[1][1].getValue()==gameBoard[2][0].getValue()&&(gameBoard[2][0].getValue()=='O'||gameBoard[2][0].getValue()=='X'))//0 2 , 1 1 , 2 0
            {
                 winPostions[0]=gameBoard[0][2];
                winPostions[1]=gameBoard[1][1];
                winPostions[2]=gameBoard[2][0];
                retval=true;
            }
        }
        return retval;
     }
     
    public void setSymbol(char c)
     {
         symbol='c';
     }

    public char getSymbol()
    {
        return symbol;
    }
    
    public boolean playMove(int x, int y)
    {
        boolean retval=false;
        if(x<3&&y<3&&gameBoard[x][y].getValue()=='-')
        {
            
                
             gameBoard[x][y].setValue(symbol);
             retval=true;
             changeSymbol();
             moves++;
             if(moves>4)
             if(checkForWin()) isWin=true;
        }
        return retval;
    }
    
    
    
    public boolean isFill()
    {
        return moves==9;
    }

    public boolean isWin() {
        return isWin;
    }
    

    public int getMoves() 
    {
        return moves;
    }
    public BoardPostion getPos(int x,int y)
    {
        return gameBoard[x][y];
    }
    public BoardPostion computerMove()
    {
        
        int x,y;
        do {    
             x=(int) (Math.random()*3);
             y=(int)(Math.random()*3);
            
        } while (!playMove(x, y));
        
        
//        System.out.println(gameBoard[x][y].getX()+" "+gameBoard[x][y].getY()+" "+gameBoard[x][y].getValue());
        return gameBoard[x][y];
    }

    public BoardPostion[][] getGameBoard() {
        return gameBoard;
    }

    public BoardPostion[] getWinPostions() {
        return winPostions;
    }
    
}


