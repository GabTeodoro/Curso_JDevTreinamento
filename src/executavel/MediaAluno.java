package executavel;

import javax.swing.JOptionPane;

public class MediaAluno {
    public static void main(String[] args) {
        
        String notaUm = JOptionPane.showInputDialog("Informe a primeira nota.");
        String notaDois = JOptionPane.showInputDialog("Informe a segunda nota.");
        String notaTres = JOptionPane.showInputDialog("Informe a terceira nota.");
        String notaQuatro = JOptionPane.showInputDialog("Informe a quarta nota.");

        Double nota1 = Double.parseDouble(notaUm);
        Double nota2 = Double.parseDouble(notaDois);
        Double nota3 = Double.parseDouble(notaTres);
        Double nota4 = Double.parseDouble(notaQuatro);

        double mediaFinal = (nota1 + nota2 + nota3 + nota4) / 4;

        int mostra = JOptionPane.showConfirmDialog(null, "Você quer ver sua média final?");
        if(mostra == 0){
            if(mediaFinal < 70 && mediaFinal > 50 ) {
                JOptionPane.showMessageDialog(null, "Você está de sub, sua média atual é: " + mediaFinal);
            }else if(mediaFinal >= 70){
                JOptionPane.showMessageDialog(null, "Parabéns, você foi aprovado! Sua média é: " + mediaFinal);
            }else{
                JOptionPane.showMessageDialog(null, "Você foi reprovado! Sua média foi: " + mediaFinal);
            }
        }else if(mostra == 1){
            mostra = JOptionPane.showConfirmDialog(null, "Quer saber se foi aprovado/reprovado/sub? ");
            if(mostra == 0){
                if(mediaFinal < 70 && mediaFinal > 50 ) {
                    JOptionPane.showMessageDialog(null, "Você está de sub.");
                }else if(mediaFinal >= 70){
                    JOptionPane.showMessageDialog(null, "Parabéns, você foi aprovado!");
                }else{
                    JOptionPane.showMessageDialog(null, "Você foi reprovado!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ok, Volte sempre!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ok, Volte sempre!");
        }

    }
}