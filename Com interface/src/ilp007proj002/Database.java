/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ilp007proj002;

import java.util.ArrayList;

/**
 *
 * @author italo7937
 */
public class Database {
    ArrayList datasNascimento = new ArrayList<DataNascimento>();
    ArrayList pessoas = new ArrayList<Pessoa>();
    ArrayList medicos = new ArrayList<Medico>();
    ArrayList jokenpos = new ArrayList<Jokenpo>();
    ArrayList perguntas = new ArrayList<Pergunta>();
    ArrayList jogosPerguntas = new ArrayList<JogoPerguntas>();

    public ArrayList getDatasNascimento() {
        return datasNascimento;
    }

    public void setDatasNascimento(ArrayList datasNascimento) {
        this.datasNascimento = datasNascimento;
    }

    public ArrayList getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList pessoas) {
        this.pessoas = pessoas;
    }

    public ArrayList getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList medicos) {
        this.medicos = medicos;
    }

    public ArrayList getJokenpos() {
        return jokenpos;
    }

    public void setJokenpos(ArrayList jokenpos) {
        this.jokenpos = jokenpos;
    }

    public ArrayList getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList perguntas) {
        this.perguntas = perguntas;
    }

    public ArrayList getJogosPerguntas() {
        return jogosPerguntas;
    }

    public void setJogosPerguntas(ArrayList jogosPerguntas) {
        this.jogosPerguntas = jogosPerguntas;
    }

    
    public Database() {
        
    }

    public Database(ArrayList<DataNascimento> DatasNascimento, ArrayList<Pessoa> Pessoas, ArrayList<Medico> Medicos,
            ArrayList<Jokenpo> Jokenpos, ArrayList<Pergunta> Perguntas, ArrayList<JogoPerguntas> JogosPerguntas) {
        this.datasNascimento = DatasNascimento;
        this.pessoas = Pessoas;
        this.medicos = Medicos;
        this.jokenpos = Jokenpos;
        this.perguntas = Perguntas;
        this.jogosPerguntas = JogosPerguntas;
    }
    
    
       
}
