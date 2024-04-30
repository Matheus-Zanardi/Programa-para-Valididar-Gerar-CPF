package model;

import javax.swing.*;
import java.util.Random;

public class Calculos_DAO {
    public static void gerar(){
        // criando as variaveis
        Random random  = new Random();
        int [] vetor = new int[11];
        int soma = 0;

// primeiro loop para criar array contendo valores aleatorios
        for(int i = 0; i < 9; i++){
            int vl = random.nextInt(10);
            vetor[i] = vl;
            //JOptionPane.showMessageDialog(null, "este é o valor:"+ i+"\neste é o valor inserido: "+vl);
        }
        for (int i = 0; i < 9; i++) {
           soma += vetor[i]*(10 - i);
           //JOptionPane.showMessageDialog(null, "a soma está em: "+soma+"\nestá multiplicando o valor:"+i+" por: "+(10-i));
        }
        // se o resto da soma dividida por 11 for menor que 2 é decimo digito é 10, caso contraio é 11 - resto
        int resto = soma%11;
        if(resto < 2){
            vetor[9] = 0;
        }else{
            vetor[9] = 11 - resto;
        }
        //reiniciando a variavel soma
        soma = 0;
        String confere = "";
        // calcula o ultimo digito
        for (int i = 0; i < 10; i++) {
            soma += vetor[i]*(11 - i);
            confere += "esse é o valor"+vetor[i] + "multiplicado por"+(11 - i)+"dando a soma ="+soma+"\n";
            //JOptionPane.showMessageDialog(null, confere+ (soma%11));
        }
        // faz a verificação para o valor
        resto = soma%11;
        if(resto < 2){
            vetor[10] = 0;
        }else{
        vetor[10] = 11 - resto;
        }
        String vt = "";
        for(int i = 0; i < 11; i++){
           vt += vetor[i]+ " ";
        }
        //exibe o cpf gerado
        JOptionPane.showMessageDialog(null,"o cpf gerado foi: "+ vt);
    }
    public static void verificar(){
        String x = "", cpf_s ="";
        int [] cpf = new int[11];


        x = JOptionPane.showInputDialog(null, "Digite o cpf");
        for (int i = 0; i < (x.length()); i++) {
            char digito = x.charAt(i);
            //JOptionPane.showMessageDialog(null, digito);
            int nmr = Character.getNumericValue(digito);
            cpf[i] = nmr;
            cpf_s += " "+cpf[i]+" ";

        }
        JOptionPane.showMessageDialog(null, cpf_s);
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpf[i]*(10 - i);
            //JOptionPane.showMessageDialog(null, "a soma está em: "+soma+"\nestá multiplicando o valor:"+i+" por: "+(10-i));
        }
        // se o resto da soma dividida por 11 for menor que 2 é decimo digito é 0, caso contraio é vetor[9]
        int resto = soma%11;
        if(resto < 2){
            if (cpf[9] == 0) {
                JOptionPane.showMessageDialog(null, "O cpf inserido é valido");
            }else{
                JOptionPane.showMessageDialog(null, "O cpf inserido é INVALIDO");
            }
        }else{
            if(cpf[9] != (11-resto)){
                JOptionPane.showMessageDialog(null, "O cpf inserido é INVALIDO");
            }else{
                JOptionPane.showMessageDialog(null, "O cpf inserido é valido");
            }
        }
    }
}
