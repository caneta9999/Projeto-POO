import java.util.Random;
import java.lang.Thread;
import java.lang.Math;
public final class JogoPerguntas{
   private static Pergunta p1 = new Pergunta("Em que ano o Python foi lancado?","2000","1991","1995","1998",2);
   private static Pergunta p2 = new Pergunta("Em que ano surgiu o paradgima da orientacao a objetos","1970","1962","1975","1959",2);
   private static Pergunta p3 = new Pergunta("Qual dessas linguagens de progamacao eh uma linguagem de programacao estruturada e nao voltada a orientacao a objetos","Python","Java","PHP","Algol",4);
   private static Pergunta p4 = new Pergunta("Em que dia eh comemorado o dia do progamador?","13 de setembro","dia 256 do ano", "dia 220 do ano","14 de agosto",2);
   private static Pergunta p5 = new Pergunta("Em que pais o dia do programador eh um feriado nacional?","Russia","Brasil","Argentina","Nenhuma dessas alternativas",1);
   private static Pergunta p6 = new Pergunta("Em que ano a linguagem Java comecou a ser desenvolvida","1991","1999","1989","1994",1);
   private static Pergunta p7 = new Pergunta("Em que empresa a linguagem Java comecou a ser desenvolvida?","Oracle","IBM","Sun Microsystems","Microsoft",3);
   private static Pergunta p8 = new Pergunta("Em que dia a linguagem Java foi lancada","23 de maio de 1995","31 de dezembro de 1999","5 de janeiro de 1990","2 de dezembro de 1994",1);
   private static Pergunta p9 = new Pergunta("Em que ano foi lancado a primeira versao da linguagem C","1978","1966","1974","1972",4);
   private static Pergunta p10 = new Pergunta("Qual dessas afirmacoes eh verdadeira sobre a linguagem C++","A linguagem foi lancada em 1960","A linguagem foi lancada como um adicional a linguagem C","A linguagem nao eh orientada a objetos","A linguagem nao suporta muitos paradigmas",2);
   private static Pergunta[] listaPerguntas = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
   static public void jogar(int numeroPerguntas){
      if(numeroPerguntas < 3 || numeroPerguntas > 10){
         System.out.println("Numero invalido de perguntas, o intervalo tem que ser entre (3 a 10)");
         return;
      }
      int[] ordenacaoPerguntas = {0,1,2,3,4,5,6,7,8,9};
      Random random = new Random();
		for (int i=0; i < 10; i++) {
			int j = random.nextInt(10);
			int temp = ordenacaoPerguntas[i];
			ordenacaoPerguntas[i] = ordenacaoPerguntas[j];
			ordenacaoPerguntas[j] = temp;
		}
      System.out.println("Quiz de perguntas");
      int respostasCertas = 0;
      for(int i=0; i<numeroPerguntas;i++){
         try{Thread.sleep(1500);} catch (InterruptedException ex) {}
         System.out.println("Pergunta " + (i+1));
         try{Thread.sleep(1500);} catch (InterruptedException ex) {}
         listaPerguntas[ordenacaoPerguntas[i]].enunciar();
         boolean acertou = listaPerguntas[ordenacaoPerguntas[i]].responder();
         if(acertou){
            Pessoa.numeroRespostasCertasUsuario++;
            respostasCertas++;
         }else{
            Pessoa.numeroRespostasErradasUsuario++;
         }
      }
      try{Thread.sleep(2000);} catch (InterruptedException ex) {}
      System.out.println("Voce acertou " + respostasCertas + " de " + numeroPerguntas + " perguntas");
      System.out.println("Sua taxa de acerto foi de " + Math.round(respostasCertas*100.00/numeroPerguntas*100.00)/100.00 + "%");
   }
}