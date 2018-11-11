package sobrecarga;

public class Ultima {
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("um");
		StringBuffer sb2 = new StringBuffer("um");
		System.out.println(sb.equals(sb2));
		//sao dois objetos entao n tem como eles se compararem
		//comparacao de espacos de memoria diferente
		
		System.out.println(sb.toString().equals(sb2.toString()));
		//aqui é o conteudo dos stringbuffer
	}
}
