package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.Cliente;

public class InputCliente {
	
	public String lerNomeConsole() {
		System.out.println("Digite o nome: ");
		Scanner in = new Scanner (System.in);
		return in.nextLine();
	}
	
	public String lerNomeVisual() {
		String nome = JOptionPane.showInputDialog("Nome: ", "");
		return nome;
	}
	
	public String lerEmailConsole() {
		System.out.println("Digite o email: ");
		Scanner in = new Scanner (System.in);
		return in.nextLine();
	}
	
	public String lerSexoConsole() {
		System.out.println("Digite o sexo(f/m): ");
		Scanner in = new Scanner (System.in);
		return in.next();
	}

	public String lerNomePlanoConsole() {
		System.out.println("Digite o nome do plano: ");
		Scanner in = new Scanner (System.in);
		return in.nextLine();
	}
	
	public Double lerValorPlanoConsole() {
		System.out.println("Digite o valor do plano: ");
		Scanner in = new Scanner (System.in);
		return in.nextDouble();
	}
	
	public Integer lerCodigoClienteConsole() {
		System.out.println("Digite o código do cliente: ");
		Scanner in = new Scanner (System.in);
		return in.nextInt();
	}
	
	public static void main(String[] args) {
		InputCliente i = new InputCliente();
		Cliente c = new Cliente();
		try {
			c.setIdCliente(i.lerCodigoClienteConsole());
			c.setNome(i.lerNomeConsole());
			c.setEmail(i.lerEmailConsole());
			c.setSexo(i.lerSexoConsole());
			c.setNomePlano(i.lerNomePlanoConsole());
			c.setValorPlano(i.lerValorPlanoConsole());			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
