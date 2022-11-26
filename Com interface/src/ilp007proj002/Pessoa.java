package ilp007proj002;
public class Pessoa implements Mamifero{
   String nome;
   DataNascimento dataNascimento;
   
   static Pessoa[] pessoasVetor = new Pessoa[64];
   static int pessoaAtual = 0;
   
   static int numeroRespostasCertasUsuario = 0;
   static int numeroRespostasErradasUsuario = 0;
   
	public void definir(String nomeP,DataNascimento dataNascimentoP){
		nome = nomeP;
      dataNascimento = dataNascimentoP;}
  	
   public String exibir(){
      if(dataNascimento != null){
         return "Nome: " + nome + "\n" + dataNascimento.exibir();}
      else{
        return "Nome: " + nome;
      }
    }
   
   
   public String getNome() {
       return nome;
   }
     
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
   
   public String falar(){
      return "Ola, meu nome eh " + nome;
   }
   static public void exibirPessoas(){
      for(int i = 0;i < 10;i++){
         if(pessoasVetor[i] != null){
            pessoasVetor[i].exibir();
            System.out.println("");
         }}}
}