public class App{
   public static void main(String args[]){
      DataNascimento d1 = new DataNascimento(1,1,1900);
      DataNascimento d2 = new DataNascimento(2,2,1922);
      DataNascimento d3 = new DataNascimento(3,3,1944);
      DataNascimento d4 = new DataNascimento(8,8,1990);
      DataNascimento d5 = new DataNascimento(4,4,1844);
      DataNascimento d6 = new DataNascimento(8,8,1988);
      DataNascimento d7 = new DataNascimento(10,10,1990);
      DataNascimento d8 = new DataNascimento(31,2,1990);
   
      Pessoa p1 = new Pessoa();
      p1.definir("Pedro",null);
      Pessoa p2 = new Pessoa();
      p2.definir("Andre",d2);
      Medico m1 = new Medico("Erika",d3,-800);
      Pessoa p3 = new Pessoa("Felipe",d4);
      Pessoa p4 = new Pessoa("Anderson",d5);
      Pessoa p5 = new Pessoa("Jessica",d6);
      Pessoa p6 = new Pessoa("Ligia",d8);
      p4 = new Pessoa(p2);
      Pessoa.exibirPessoas();
      m1.falar();
      
      Jokenpo.jogar(p1,p2);
      System.out.println(p1.vitoriasJokenpo);
      System.out.println(p1.derrotasJokenpo);
      System.out.println(p2.vitoriasJokenpo);
      System.out.println(p2.derrotasJokenpo);
      
      Jokenpo.jogar(p2);
      System.out.println(Pessoa.vitoriasJokenpoUsuario);
      System.out.println(Pessoa.derrotasJokenpoUsuario);
      System.out.println(p2.vitoriasJokenpo);
      System.out.println(p2.derrotasJokenpo);
      
      d1.proposito();
      
      Jokenpo.torneio(4);
      
      JogoPerguntas.jogar(3);
   }
}