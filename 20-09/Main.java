import java.util.Scanner;

public class Main {

    private static final String LOGIN = "ATOS";
    private static final String SENHA = "123";

    public static void main(String[] args) {
        System.out.println("## LOGIN ##");
        String nomeDigitado;
        String senhaDigitada;

        Scanner entradaDados = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        nomeDigitado = entradaDados.next();

        System.out.println("Digite sua senha:");
        senhaDigitada = entradaDados.next();

        if (nomeDigitado.equals(LOGIN) && senhaDigitada.equals(SENHA)) {
            System.out.println("LOGIN REALIZADO COM SUCESSO");
        } else {
            System.out.println("LOGIN INVALIDO!");
            return;
        }

        System.out.println("### MENU ###");
        System.out.println("1- Cadastrar Gerente");
        System.out.println("2- Cadastrar Coordenador");

        String opccaoSelecionada = entradaDados.next();
        String nome;
        String cpf;
        Double horasTrabalhada;

        switch (opccaoSelecionada) {

            case "1":

                System.out.println("Nome:");
                nome = entradaDados.next();
                System.out.println("CPF:");
                cpf = entradaDados.next();
                System.out.println("REGIONAL:");
                String regional = entradaDados.next();
                System.out.println("META REGIONAL:");
                Double metaRegional = entradaDados.nextDouble();

                Gerente gerente = new Gerente(nome, 0.0, cpf, regional, metaRegional);

                System.out.println("Horas trabalhada:");
                horasTrabalhada = entradaDados.nextDouble();

                gerente.calcularSalarioGerente(horasTrabalhada);

                System.out.println("CADASTRO");
                System.out.println("NOME >> " + gerente.getNome());
                System.out.println("SALARIO LIQUIDO >> " + gerente.getSalarioLiquido());

                break;
            case "2":

                System.out.println("Nome:");
                nome = entradaDados.next();
                System.out.println("CPF:");
                cpf = entradaDados.next();
                System.out.println("LOJA:");
                String loja = entradaDados.next();
                System.out.println("META LOJA:");
                Double metaLoja = entradaDados.nextDouble();

                Coordenador coordenador = new Coordenador(nome, 0.0, cpf, loja, metaLoja);

                System.out.println("Horas trabalhada:");
                horasTrabalhada = entradaDados.nextDouble();

                coordenador.calcularSalarioGerente(horasTrabalhada);

                System.out.println("CADASTRO");
                System.out.println("NOME >> " + coordenador.getNome());
                System.out.println("SALARIO LIQUIDO >> " + coordenador.getSalarioLiquido());
                break;
        }

    }
}
