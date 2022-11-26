import java.util.Scanner;
import java.lang.Thread;
public class Pergunta{
   String enunciado;
   String[] respostas = new String[4];
   int respostaCerta;
   public Pergunta(String enunciadoP, String resposta1P, String resposta2P, String resposta3P, String resposta4P, int respostaCertaP){
      enunciado = enunciadoP;
      respostas[0] = resposta1P;
      respostas[1] = resposta2P;
      respostas[2] = resposta3P;
      respostas[3] = resposta4P;
      respostaCerta = respostaCertaP;
   }
   public void enunciar(){
      System.out.println(enunciado);
      for(int i=0;i<4;i++){
         try{Thread.sleep(500);} catch (InterruptedException ex) {}
         System.out.println((i+1) + " - " + respostas[i]);
      }
   }
   public boolean responder(){
      try{Thread.sleep(500);} catch (InterruptedException ex) {}
      System.out.println("Qual a resposta certa? (Digite o numero da resposta): ");
      int uResposta;
      Scanner ler = new Scanner(System.in);
      try{uResposta = ler.nextInt();}
      catch(Exception e){
         uResposta = 1;
      }
      if(uResposta < 1 || uResposta > 4){
         uResposta = 1;
      }
      try{Thread.sleep(500);} catch (InterruptedException ex) {}
      System.out.println("Sua resposta foi: " + respostas[uResposta-1]);
      try{Thread.sleep(500);} catch (InterruptedException ex) {}
      boolean decisao = (uResposta == respostaCerta);
      if(decisao){
         System.out.println("Parabens, voce acertou");}
      else{
         System.out.println("Que pena, voce errou");
      }
      try{Thread.sleep(500);} catch (InterruptedException ex) {}
      System.out.println("A resposta era " + respostas[respostaCerta-1]);
      return decisao?true:false;
   }
}