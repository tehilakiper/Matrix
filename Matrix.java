import java.util.Random;

public class Matrix {
    public static void main(String[] args ) {
    	
        // Check if command line arguments are valid
        if (args.length != 3) {
            System.out.println("Please enter matrix dimensions as command line arguments in the format: A height B height/ A width B width");
            return;
        }

        // Parse matrix dimensions from command line arguments
        int X = Integer.parseInt(args[0]);
        int Y = Integer.parseInt(args[1]);
        int Z = Integer.parseInt(args[2]);

        // Create matrixes  
        int[][] A = new int[X][Y];
        int[][] B = new int[Y][Z];
        int[][] C = new int[X][Z];
        
        Random rand = new Random();

        // Fill matrix A with random values
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                A[i][j] = rand.nextInt(10);
            }
        }

        // Fill matrix B with random values
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < Z; j++) {
                B[i][j] = rand.nextInt(10);
            }
        }

        // Display matrix A
        System.out.println("Matrix A:");
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        // Display matrix B
        System.out.println("Matrix B:");
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < Z; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }

        // Declare threads
        Thread[][] threads = new Thread[X][Y];
        System.out.println("\nthreads by their operating order: \n");
        // Create threads, each evaluating its own part
        for (int i = 0; i < X; i++) {
        	     for (int j = 0; j < Z; j++) {
            
        	    	 threads[i][j] = new Thread(new mult(i, j, X, Y, Z, A, B, C));
            
        	    	 threads[i][j].start();
        	    	 
        	    	 try {
        	                threads[i][j].join();
        	            } catch (InterruptedException e) {
        	                e.printStackTrace();
        	            }
        	
        	     }
        }

     
        // Display the result matrix
        System.out.println("\nMultiplication of A and B:");
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Z; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}