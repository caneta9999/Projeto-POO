/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ilp007proj002;

import java.util.Random;

/**
 *
 * @author italo7937
 */
public class RodadaJokenpo {

    private int p1Vitorias = 0;  
    private int p2Vitorias = 0;
    private int uVitorias = 0;
    private boolean finalizada = false;
    private int vencedor;
    private int numPartida = 1;
    

    public boolean isFinalizada() {
        return finalizada;
    }
    
    public int getP1Vitorias() {
        return p1Vitorias;
    }

    public int getP2Vitorias() {
        return p2Vitorias;
    }
    
    public int getUVitorias() {
        return uVitorias;
    }
    
    public int getNumPartida() {
        return numPartida;
    }
    
    public int getVencedor() {
        return vencedor;
    }
    
    public void iniciarRodada() {
        //this.p1 = p1;
        //this.p2 = p2;
        p1Vitorias = 0;
        p2Vitorias = 0;
        uVitorias = 0;
        finalizada = false;
        numPartida = 1;
    }
    
    public static int decidirJogada() {
        Random random = new Random();
        int numero = random.nextInt(3);
        return numero;
    }

    public static int decidirVitoria(int Jogada1, int Jogada2) {
        if (Jogada1 == 0 && Jogada2 == 0) {
            return 0;
        } else if (Jogada1 == 0 && Jogada2 == 1) {
            return -1;
        } else if (Jogada1 == 0 && Jogada2 == 2) {
            return 1;
        } else if (Jogada1 == 1 && Jogada2 == 0) {
            return 1;
        } else if (Jogada1 == 1 && Jogada2 == 1) {
            return 0;
        } else if (Jogada1 == 1 && Jogada2 == 2) {
            return -1;
        } else if (Jogada1 == 2 && Jogada2 == 0) {
            return -1;
        } else if (Jogada1 == 2 && Jogada2 == 1) {
            return 1;
        } else if (Jogada1 == 2 && Jogada2 == 2) {
            return 0;
        }
        return 0;
    }

    public void atribuirPontos(int resultado) {
        if (!finalizada) {
            if (resultado == 1) {
                p1Vitorias++;
            } else if (resultado == -1) {
                p2Vitorias++;
            }

            if (p1Vitorias == 2) {
                //p1.vitoriasJokenpo++;
                //p2.derrotasJokenpo++;
                vencedor = 1;
                finalizada = true; 
            } else if (p2Vitorias == 2) {
                //p1.derrotasJokenpo++;
                //p2.vitoriasJokenpo++;
                vencedor = 2;
                finalizada = true;
            } else {
               numPartida++;
            }
            
        }
    }

    public void atribuirPontos(int resultado, int numUsuario, int numOutroParticipante) {
        if (!finalizada) {
            if ((resultado == 1 && numUsuario == 1) || (resultado == -1 && numUsuario == 2)) {
                uVitorias++;
            } else if ((resultado == 1 && numUsuario == 2) || (resultado == -1 && numUsuario == 1)) {
                if (numOutroParticipante == 1) {
                    p1Vitorias++;
                } else {
                    p2Vitorias++;
                }
            }

            if (uVitorias == 2) {
                //Pessoa.vitoriasJokenpoUsuario++;
                //p2.derrotasJokenpo++;
                vencedor = numUsuario;
                finalizada = true;
            } else if (p1Vitorias == 2 || p2Vitorias == 2) {
                //Pessoa.derrotasJokenpoUsuario++;
                //p2.vitoriasJokenpo++;
                vencedor = numOutroParticipante;
                finalizada = true;
            } else {
               numPartida++; 
            }                     
        }
    }
}
