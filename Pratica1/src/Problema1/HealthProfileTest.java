package Problema1;
import java.util.Scanner;

public class HealthProfileTest {
    
    public static void main(String[] args) {
        
        String nome, sobrenome, sexo;
        Integer dia_nascimento, mes_nascimento, ano_nascimento;
        Float altura, peso;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        nome = sc.nextLine();

        System.out.println("Digite o sobrenome: ");
        sobrenome = sc.nextLine();

        System.out.println("Digite o sexo: ");
        sexo = sc.nextLine();

        System.out.println("Digite o dia de nascimento: ");
        dia_nascimento = sc.nextInt();

        System.out.println("Digite o mes de nascimento: ");
        mes_nascimento = sc.nextInt();

        System.out.println("Digite o ano de nascimento: ");
        ano_nascimento = sc.nextInt();

        System.out.println("Digite a altura: ");
        altura = sc.nextFloat();

        System.out.println("Digite o peso: ");
        peso = sc.nextFloat();

        HealthProfile usuario = new HealthProfile(nome, sobrenome, sexo, dia_nascimento, mes_nascimento, ano_nascimento, altura, peso);

        Integer idade = usuario.calculaIdade();
        Float IMC = usuario.calculaIMC();
        Float[] intervalo = usuario.intervaloFrequenciaAlvo();

        System.out.printf("%d %.2f %.2f-%.2f", idade, IMC, intervalo[0], intervalo[1]);

    }
}
