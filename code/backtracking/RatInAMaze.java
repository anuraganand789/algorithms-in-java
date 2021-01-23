public class RatInAMaze{
    static final int sizeOfX = 5;
    static final int sizeOfY = 5;

    public static void main(final String[] args){
        final boolean[][] maze = {
				     {true,  true,  false, true,  true},
				     {false, true,  true,  false, false},
				     {true,  false, true,  false, false},
				     {true,  false, true,  true,   true},
				     {true,  true,  false, true,  true},
	                         };

        final boolean[][] path = {
				     {false,  false,  false,  false,  false},
				     {false,  false,  false,  false,  false},
				     {false,  false,  false,  false,  false},
				     {false,  false,  false,  false,  false},
				     {false,  false,  false,  false,  false},
	                         };
        ratIsInMaze(maze, path, 0, 0);
	printPath(path);
    }

    private static void printPath(final boolean[][] path){
        for(int x = 0; x < sizeOfX; ++x){
	    for(int y = 0; y < sizeOfY; ++y){
	        if(path[x][y]) System.out.format("[%d, %d] ", x, y);
	    }
	}
    }

    private static boolean coordinatesAreSafe(final boolean[][] maze, final int xCoordinate, final int yCoordinate){
        return (xCoordinate >= 0 && xCoordinate < sizeOfX) && 
	       (yCoordinate >= 0 && yCoordinate < sizeOfY) && 
	       maze[xCoordinate][yCoordinate];
    }
    private static boolean ratIsInMaze(final boolean[][] maze, final boolean[][] path,
                                       final int xCoordinate, final int yCoordinate){
       if(xCoordinate == sizeOfX - 1 && yCoordinate == sizeOfY -1 &&  maze[xCoordinate][yCoordinate]){
           path[xCoordinate][yCoordinate] = true;
	   return true;
       }
       
       if(coordinatesAreSafe(maze, xCoordinate, yCoordinate)){

	   path[xCoordinate][yCoordinate] = true;

           if(ratIsInMaze(maze, path, xCoordinate + 1, yCoordinate) || 
	      ratIsInMaze(maze, path, xCoordinate ,    yCoordinate + 1)) return true;

	   path[xCoordinate][yCoordinate] = false;
       }
       
       return false;
    }
}
