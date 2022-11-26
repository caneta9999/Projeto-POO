public class Pessoa implements Mamifero{
	String nome;
   DataNascimento dataNascimento;
   
   static Pessoa[] pessoasVetor = new Pessoa[64];
   static int pessoaAtual = 0;
   
   int vitoriasJokenpo = 0;
   int derrotasJokenpo = 0;
   int torneiosJokenpoGanhos = 0;
   static int vitoriasJokenpoUsuario = 0;
   static int derrotasJokenpoUsuario = 0;
   static int torneiosJokenpoGanhosUsuario = 0;
   
   static int numeroRespostasCertasUsuario = 0;
   static int numeroRespostasErradasUsuario = 0;
   
	public void definir(String nomeP,DataNascimento dataNascimentoP){
		nome = nomeP;
      dataNascimento = dataNascimentoP;}
  	
   public void exibir(){
		System.out.println("Nome: " + nome);
      if(dataNascimento != null)
         dataNascimento.exibir();}
     
   //construtores
   public Pessoa(){//construtor simples
      nome = "";
      dataNascimento = null;
      if(Pessoa.pessoaAtual < 64){
         pessoasVetor[Pessoa.pessoaAtual] = this;
         Pessoa.pessoaAtual++;
      }
    }
   public Pessoa(String nomeP, DataNascimento dataNascimentoP){//construtor inicializador
      nome = nomeP;
      dataNascimento = dataNascimentoP;
      if(Pessoa.pessoaAtual < 64){
         pessoasVetor[Pessoa.pessoaAtual] = this;
         Pessoa.pessoaAtual++;
      }
   }
   public Pessoa(Pessoa p){//construtor copia
      nome = new String(p.nome);
      if(p.dataNascimento != null)
         dataNascimento = new DataNascimento(p.dataNascimento);
      else
         dataNascimento = null;
      if(Pessoa.pessoaAtual < 64){
         pessoasVetor[Pessoa.pessoaAtual] = this;
         Pessoa.pessoaAtual++;
      }
  }
   
   public void falar(){
      System.out.println("Ola, meu nome eh " + nome);
   }
   static public void exibirPessoas(){
      for(int i = 0;i < 10;i++){
         if(pessoasVetor[i] != null){
            pessoasVetor[i].exibir();
            System.out.println("");
         }}}
}