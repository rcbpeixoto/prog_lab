package rcbop;

public class Questao06_Prova {

	
	// fun��o para espelhar uma matriz
	
	public static void main(String[] args) {

		int mat[][] = new int [2][2];
		
		mat[0][0] = 1;
		mat[0][1] = 2;
		mat[1][0] = 3;
		mat[1][1] = 4;

 		int mat2[][] = new int[mat.length][mat[0].length];
        mat2 = espelho(mat);
        for (int i = 0; i < mat.length; i++) {
        	for ( int j = 0; j<mat[i].length; j++){
        		System.out.println(mat2[i][j]);
        	}
        } 
	}
	
	public static int [][] espelho(int mat[][]){
		int mat2[][] = new int[mat.length][mat[0].length];
		int n=0;
		
		for (int i=0; i < mat.length; i++){
			for (int j=mat[i].length - 1; j>=0; j--){
				mat2[i][n] = mat[i][j];
				n++;
			}
				n=0;
		}
		
		return mat2;
	}
}
