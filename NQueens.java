public class NQueens
{
    private static int N;
    private static int[][] board;

	public NQueens(int size)
	{
		this.N = size;
		board = new int[N][N];
	}

    private static boolean canPlaceAQueen(int row, int col)
    {
		for (int x = 0; x < N; x++)
        {
            if((board[row][x] == 1) || (board[x][col] == 1))
			{
				return true;
			}
        }

        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                if ( ((x + y) == (row + col)) || ((x - y) == (row - col)) )
                {
                    if (board[x][y] == 1)
					{
						return true;
					}
                }
            }
        }

        return false;
    }

    private static boolean nQueenSolver(int n) throws Exception
    {
        if (n == 2 || n == 3)
		{
            throw new Exception();
        }
        if (n <= 0)
		{
            throw new Exception();
        }

        if (n > 0)
		{
            return true;
        }
		
		if(n == 0)
		{
			return true;
		}

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if ( (!canPlaceAQueen(i,j)) && (board[i][j] != 1))
                {
                    board[i][j] = 1;

                    if (nQueenSolver(n - 1) == true)
                    {
                        return true;
                    }

                    board[i][j] = 0;
                }
            }
        }

        return false;
    }

	public boolean placeNQueens() throws Exception
	{
		//printToConsole();
		return nQueenSolver(N);	
	}

	public static void printToConsole()
	{
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
			{
				if (board[i][j] == 1)
				{
					System.out.print("Q\t");
				}

				else
				{
					System.out.print("_\t");
				}
			}
                
            System.out.print("\n");
        }
	}

}