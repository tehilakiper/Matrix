class mult implements Runnable {
    int i;
    int j;
    int X;
    int Y;
    int Z;
    int [][] A = new int [X][Y] ;

	int [][] B = new int [Y][Z];

	int [][] C = new int [X][Z];
	
    mult(int i, int j, int X, int Y, int Z, int [][] A, int [][] B, int [][] C) {
        this.i = i;
        this.j = j;
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.A = A;
        this.B = B;
        this.C = C;

    }

    @Override
    public void run() {
    	
           
        	for (int k = 0; k < Y; k++) {
                C[i][j] += A[i][k] * B[k][j];
            }
        	System.out.println(C[i][j]);
        }
    
}