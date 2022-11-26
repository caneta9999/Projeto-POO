public final class DataNascimento extends Data{
   int dia;
   int mes;
   int ano;
   
   public static boolean bissexto(int ano) {
      if(ano % 400 == 0)
         return true;
      else if(ano % 4 == 0 && ano % 100 != 0)
         return true;
      else
         return false;
   }
   
   public static int diasMes(int m, int a){
      int meses[] = {31,28,31,30,31,30,31,31,30,31,30,31};
      if(m == 2){
         if(bissexto(a))
            meses[1] = 29;
      }
      if(m > 0 && m < 13)
         return meses[m-1];
      else
         return 0;
   }
   
   private void validar(){
      int numeroDeDiasDoMes = diasMes(this.mes,this.ano);
      if(this.dia > numeroDeDiasDoMes || this.dia < 1 || this.mes > 12 || this.mes < 1 || this.ano < 0 || numeroDeDiasDoMes == 0 || this.ano > 9999 || this.ano < 0){
         this.dia = 01;
         this.mes = 01;
         this.ano = 1;
      }
   }
   public DataNascimento(int diaD,int mesD,int anoD){
      dia = diaD;
      mes = mesD;
      ano = anoD;
      validar();
   }
   public DataNascimento(DataNascimento d){
      dia = d.dia;
      mes = d.mes;
      ano = d.ano;
   }
   public void exibir(){
      System.out.println("Data de nascimento: " + dia + "/" + mes + "/" + ano);
   }
   public void proposito(){
      System.out.println("Essa e uma data que registra o dia, mes e ano do nascimento de uma pessoa");
   }
}