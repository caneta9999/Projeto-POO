public final class Medico extends Pessoa{
   double salario;
   public void exibir(){
      super.exibir();
      System.out.println("Salario do(a) medico(a): " + salario);}
   private void validar(){
      if(salario<0){
         salario = 1000;   
      }
   }
   public Medico(String nomeP,DataNascimento dataNascimentoP,double salarioM){
      super(nomeP,dataNascimentoP);
      salario = salarioM;
      validar();}
}