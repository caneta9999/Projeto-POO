import java.util.Random;
import java.lang.Thread;
import java.util.Scanner;
public final class Jokenpo{
   static int numerotorneio = 1;
   static final String[] jogadas = {"Pedra","Papel","Tesoura"};
   public static int decidirJogada(){
      Random random = new Random();
      int numero = random. nextInt(3);
      return numero;
   }
   public static int decidirVitoria(int Jogada1, int Jogada2){
      if(Jogada1 == 0 && Jogada2 == 0){
         return 0;}
      else if(Jogada1 == 0 && Jogada2 == 1){
         return -1;}
      else if(Jogada1 == 0 && Jogada2 == 2){
         return 1;}
      else if(Jogada1 == 1 && Jogada2 == 0){
         return 1;}
      else if(Jogada1 == 1 && Jogada2 == 1){
         return 0;}
      else if(Jogada1 == 1 && Jogada2 == 2){
         return -1;}
      else if(Jogada1 == 2 && Jogada2 == 0){
         return -1;}
      else if(Jogada1 == 2 && Jogada2 == 1){
         return 1;}
      else if(Jogada1 == 2 && Jogada2 == 2){
         return 0;}
      return 0;
   }
   public static Pessoa jogar(Pessoa p1, Pessoa p2){
      int p1Vitoria = 0;
      int p2Vitoria = 0;
      System.out.println("Inicio da partida entre " + p1.nome + " e " + p2.nome);
      while(p1Vitoria != 2 && p2Vitoria != 2){
      int p1Jogada = decidirJogada();
      int p2Jogada = decidirJogada();
      int vitoria = decidirVitoria(p1Jogada,p2Jogada);
      try{Thread.sleep(1000);} catch (InterruptedException ex) {}
      System.out.print(p1.nome + " jogou " + Jokenpo.jogadas[p1Jogada] + ". " + p2.nome + " jogou " + Jokenpo.jogadas[p2Jogada]);
      try{Thread.sleep(200);} catch (InterruptedException ex) {}
      if(vitoria == 1){
         System.out.println(". Vitoria de " + p1.nome + "!");
         p1Vitoria++;}
      else if(vitoria == -1){
         System.out.println(". Vitoria de " + p2.nome + "!");
         p2Vitoria++;}
      else{
         System.out.println(". Empate!");
      }
     }
     try{Thread.sleep(1000);} catch (InterruptedException ex) {}
     if(p1Vitoria == 2){
         System.out.println(p1.nome + " ganha a partida!");
         p1.vitoriasJokenpo++;
         p2.derrotasJokenpo++;
         return p1;
         }
      else{
         System.out.println(p2.nome + " ganha a partida!");
         p1.derrotasJokenpo++;
         p2.vitoriasJokenpo++;
         return p2;
      }
   }
   public static Pessoa jogar(Pessoa p2){
      int uVitoria = 0;
      int p2Vitoria = 0;
      System.out.println("Inicio da partida entre " + "Usuario" + " e " + p2.nome);
      while(uVitoria != 2 && p2Vitoria != 2){
      Scanner ler = new Scanner(System.in);
      System.out.printf("Informe sua jogada(0 para Pedra, 1 para Papel, 2 para Tesoura): ");
      int uJogada;
      try{uJogada = ler.nextInt();}
      catch(Exception e){
         uJogada = 0;
      }
      if(uJogada < 0 || uJogada > 2){
         uJogada = 0;
      }
      int p2Jogada = decidirJogada();
      int vitoria = decidirVitoria(uJogada,p2Jogada);
      try{Thread.sleep(1000);} catch (InterruptedException ex) {}
      System.out.print("Usuario jogou " + Jokenpo.jogadas[uJogada] + ". " + p2.nome + " jogou " + Jokenpo.jogadas[p2Jogada]);
      try{Thread.sleep(200);} catch (InterruptedException ex) {}
      if(vitoria == 1){
         System.out.println(". Vitoria do Usuario!");
         uVitoria++;}
      else if(vitoria == -1){
         System.out.println(". Vitoria de " + p2.nome + "!");
         p2Vitoria++;}
      else{
         System.out.println(". Empate!");
      }
     }
     if(uVitoria == 2){
         System.out.println("Usuario ganha a partida!");
         Pessoa.vitoriasJokenpoUsuario++;
         p2.derrotasJokenpo++;
         return null;
         }
      else{
         System.out.println(p2.nome + " ganha a partida!");
         Pessoa.derrotasJokenpoUsuario++;
         p2.vitoriasJokenpo++;
         return p2;
      }
   }
   public static void torneio(int numeroParticipantes){
      if(numeroParticipantes > 64 || numeroParticipantes < 4 || (numeroParticipantes != 64 && numeroParticipantes != 32 && numeroParticipantes != 16 && numeroParticipantes != 8 && numeroParticipantes != 4)){
         System.out.println("Numero invalido de participantes, o torneio suporta os seguintes formatos: 64 pessoas, 32 pessoas, 16 pessoas, 8 pessoas ou 4 pessoas, contando com o jogador");
         return;
      }
      int numeroPessoasVetor = 0;
      Pessoa[] participantes = new Pessoa[numeroParticipantes];
      for(int i = 0; i<numeroParticipantes-1;i++){
         if(Pessoa.pessoasVetor[i]!= null){
            participantes[numeroPessoasVetor++] = Pessoa.pessoasVetor[i];
         }
      }
      //incluir o usu�rio
      participantes[numeroPessoasVetor++] = null;
      if(numeroPessoasVetor != numeroParticipantes){
         System.out.println("Faltam pessoas para participar do torneio, crie mais pessoas para a efetivacao do torneio");
         return;
      }
      //embaralhar os participantes
      Random random = new Random();
		for (int i=0; i < numeroParticipantes; i++) {
			int j = random.nextInt(numeroParticipantes);
			Pessoa temp = participantes[i];
			participantes[i] = participantes[j];
			participantes[j] = temp;
		}
      System.out.println("Torneio " + Jokenpo.numerotorneio + " de Jokenpo");
      Jokenpo.numerotorneio++;
      Pessoa[] participantesRemanescentes = new Pessoa[numeroParticipantes];
      while(numeroParticipantes != 1){
         try{Thread.sleep(2000);} catch (InterruptedException ex) {}
         numeroPessoasVetor = 0;
         if(numeroParticipantes != 2){
            participantesRemanescentes = new Pessoa[numeroParticipantes/2];}
         for(int i=0; i < numeroParticipantes; i+=2){
            try{Thread.sleep(1000);} catch (InterruptedException ex) {}
            if(participantes[i]!=null && participantes[i+1]!=null){
               System.out.println(participantes[i].nome + " vs " + participantes[i+1].nome);
               participantesRemanescentes[numeroPessoasVetor++] = jogar(participantes[i],participantes[i+1]);
            }
            else if(participantes[i] == null){
               System.out.println("Usuario vs " + participantes[i+1].nome);
               participantesRemanescentes[numeroPessoasVetor++] = jogar(participantes[i+1]);
            }
            else{
               System.out.println(participantes[i].nome + " vs Usuario");
               participantesRemanescentes[numeroPessoasVetor++] = jogar(participantes[i]);           
            }
         }
         numeroParticipantes = numeroParticipantes/2;
         participantes = participantesRemanescentes.clone();
      }
      if(participantesRemanescentes[0] == null){
         System.out.println("O torneio foi ganho pelo usuario. Parabens!");
         Pessoa.torneiosJokenpoGanhosUsuario++;
      }else{
         System.out.println("O torneio foi ganho por " + participantesRemanescentes[0].nome + ". Parabens!");
         participantesRemanescentes[0].torneiosJokenpoGanhos++; 
      }  
   }
}