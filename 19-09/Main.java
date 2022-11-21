public class Main {

	public static void main(String args[]){

		System.out.println("#### MAIN ###");

		Aluno aluno = new Aluno("14578945745", "Roque Junior", "ABC", "Sem adv.");
		System.out.println(aluno.getCpf());
		System.out.println(aluno.getNome());
		System.out.println(aluno.getTurma());
		System.out.println(aluno.getAdvertencia());
		
	}

}