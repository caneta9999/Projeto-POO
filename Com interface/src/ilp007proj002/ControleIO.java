/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ilp007proj002;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author italo7937
 */
public class ControleIO {
    public static Database database = new Database();
    
    private static final String ARQUIVO_SALVAMENTO = "db.json";
    
    private static final ObjectMapper OM = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    public static void salvar() {
    OM.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        try {
            OM.writeValue(new File("./" + ARQUIVO_SALVAMENTO), database);
        } catch (IOException e) {
            System.out.println("Não foi possível salvar:\n" + e.getMessage());
        }
    }
    
    public static void carregar() {
    OM.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
       try {
           Database dbCarregado = OM.readerFor(Database.class).readValue(new File("./" + ARQUIVO_SALVAMENTO));
           database.datasNascimento = OM.convertValue(dbCarregado.datasNascimento, new TypeReference<ArrayList<DataNascimento>>() {});
           database.pessoas = OM.convertValue(dbCarregado.pessoas, new TypeReference<ArrayList<Pessoa>>() {});
           database.medicos = OM.convertValue(dbCarregado.medicos, new TypeReference<ArrayList<Medico>>() {});
           database.jokenpos = OM.convertValue(dbCarregado.jokenpos, new TypeReference<ArrayList<Jokenpo>>() {});
           database.perguntas = OM.convertValue(dbCarregado.perguntas, new TypeReference<ArrayList<Pergunta>>() {});
           database.jogosPerguntas = OM.convertValue(dbCarregado.jogosPerguntas, new TypeReference<ArrayList<JogoPerguntas>>() {});
       } catch (IOException e) {
          System.out.println("Não foi possível carregar:\n" + e.getMessage());
       }
    }
}
