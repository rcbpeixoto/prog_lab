package rcbop;

public class Questao03 {
		public static void main(String[] args) {

			int contador = 0;
			
			while (contador < 17){
				if ((contador>11)||(contador%2==1)){
					contador = contador + 1;
				}
				else {
					contador = contador + 3;
				}
			}
			System.out.println("contador = "+contador);

		}

	}

