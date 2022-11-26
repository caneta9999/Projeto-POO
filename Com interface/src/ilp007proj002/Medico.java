package ilp007proj002;
public final class Medico extends Pessoa{
   double salario;
   public String exibir(){
      return super.exibir() + "\nSalario do(a) medico(a): " + salario;}
   private void validar(){
      if(salario<0){
         salario = 1000;   
      }
   }
   
   public Medico() {
       
   }
   
   public Medico(String nomeP,DataNascimento dataNascimentoP,double salarioM){
      super(nomeP,dataNascimentoP);
      salario = salarioM;
      validar();}
}