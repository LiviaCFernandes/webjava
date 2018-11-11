package sobrecarga;

import java.util.Arrays;

public class Funcionario {
	int a =10;
	{
		System.out.println("Dois inicios");
		a++;//comeca com 10, passa aq vira 11
	}
	
	public Funcionario(int a) {
		System.out.println(this.a);//aqui ta trabalhando com o atributo
		System.out.println(a++);//se fosse antes daria 101, mas como foi apos só imprime 100
	}
	{
		a++;//vem 11, passa aq vira 12
	}
	
	public void escrever() throws Exception {
		System.out.println("sobrescrita");
	}
	
	public void print(int a) {
		System.out.println("um "+a);
	}
	{
		a++;//vem 12, passa aq vira 13
	}
	
	public void print(long a) {
		System.out.println("dois "+a);
	}
		
	public void print(int ...a) {
		System.out.println("tres "+Arrays.asList(a));
	}
	
	public static void main(String[] args) {
		new Funcionario(100);
	}
	
}
