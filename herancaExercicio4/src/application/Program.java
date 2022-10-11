package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Individual;
import entities.Juridica;
import entities.TaxPlayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPlayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Gastos de saúde: ");
				double gastosSaude = sc.nextDouble();
				list.add(new Individual(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Número de funcionários: ");
				Integer numeroFuncionarios = sc.nextInt();
				list.add(new Juridica(nome, rendaAnual, numeroFuncionarios));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPlayer tp : list) {
			System.out.println(tp.getNome() + ": $ " + String.format("%.2f", tp.taxa()));
		}
		
		double sum = 0.0;
		for(TaxPlayer tp : list) {
			sum += tp.taxa();
		}
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();

	}

}
