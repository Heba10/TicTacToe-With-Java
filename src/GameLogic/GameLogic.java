
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
    
    char[][] gameBoard;
    char symbol;
    int moves;

    public GameLogic() // constructor
    {
        symbol='X';
        moves=0;
        gameBoard=new char[3][3];
        for(int i=0;i<3;i++) // initialize gameBoard with -
        {
            
            for(int j=0;j<3;j++)
            {
                gameBoard[i][j]='-';
            }
           
        }
    }
    public GameLogic(char c)//if the player choose he want to start with 'O'
    {
        symbol=c;
        gameBoard=new char[3][3];
        moves=0;
        for(int i=0;i<3;i++) // initialize gameBoard with -
        {
            
            for(int j=0;j<3;j++)
            {
                gameBoard[i][j]='-';
            }
           
        }
    }
    
    void printBoard()
    {
        for(int i=0;i<3;i++)
        {
            System.out.print("|");
            for(int j=0;j<3;j++)
            {
                System.out.print(gameBoard[i][j]+"|");
            }
            System.out.println("");
        }
    }
    void changeSymbol()
    {
        if(symbol=='X') symbol='O';
        else symbol='X';
    }
    
    void resetBoard()
    {
        for(int i=0;i<3;i++)
        {
           
            for(int j=0;j<3;j++)
            {
                gameBoard[i][j]='-';
            }
           
        }
    }
    
    boolean checkForWin()
    {
        
        return checkColumns()||checkCross()||checkRows();
        
    }
    
    boolean checkRows()
    {
        boolean retval=false;
        for(int i=0;i<3;i++)
        {
            if(gameBoard[i][0]==gameBoard[i][1]&&gameBoard[i][1]==gameBoard[i][2]&&(gameBoard[i][2]=='O'||gameBoard[i][2]=='X'))
            {
               retval=true;
            }
        }
        return retval;
    }
    
     boolean checkColumns()
    {
        boolean retval=false;
        for(int i=0;i<3;i++)
        {
            if(gameBoard[0][i]==gameBoard[1][i]&&gameBoard[1][i]==gameBoard[2][i]&&(gameBoard[2][i]=='O'||gameBoard[2][i]=='X'))
            {
               retval=true;
            }
        }
        return retval;
    }
     
     boolean checkCross()
     {
         boolean retval=false;
        for(int i=0;i<3;i++)
        {
            if(gameBoard[0][0]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][2]&&(gameBoard[2][2]=='O'||gameBoard[2][2]=='X'))
            {
               retval=true;
            }
            else if(gameBoard[0][2]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][0]&&(gameBoard[2][0]=='O'||gameBoard[2][0]=='X'))//0 2 , 1 1 , 2 0
            {
                retval=true;
            }
        }
        return retval;
     }
     
     void setSymbol(char c)
     {
         symbol='c';
     }

    public char getSymbol()
    {
        return symbol;
    }
    
    boolean playMove(int x, int y)
    {
        boolean retval=false;
        if(x<3&&y<3&&gameBoard[x][y]=='-')
        {
             gameBoard[x][y]=symbol;
             retval=true;
             changeSymbol();
             moves++;
        }
        return retval;
    }
    
    
    
    boolean isFill()
    {
        return moves==9;
    }

    public int getMoves() 
    {
        return moves;
    }
    
    
    
    
}


