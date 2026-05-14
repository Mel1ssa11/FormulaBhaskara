/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formulabhaskara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormulaBhaskara extends JFrame {

    Container tela;
    JLabel labelA, labelB, labelC, labelX1, labelX2,titulo, subtitulo;
    JTextField textoA, textoB, textoC, textoX1, textoX2;
    JButton calcular;

    public FormulaBhaskara() {

        super("Formula de Bhaskara");

        tela = getContentPane();
        tela.setLayout(null);
        tela.setBackground(new Color(142, 210, 188));

        titulo = new JLabel("Formula de Bhaskara");
        titulo.setBounds(0, 20, 400, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titulo.setForeground(new Color(26, 75, 131));

        subtitulo = new JLabel("ax² + bx + c = 0");
        subtitulo.setBounds(0, 55, 400, 20);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitulo.setForeground(new Color(26, 75, 131));

        labelA = new JLabel("Valor de a:");
        labelB = new JLabel("Valor de b:");
        labelC = new JLabel("Valor de c:");
        labelA.setBounds(50, 100, 100, 25);
        labelB.setBounds(50, 140, 100, 25);
        labelC.setBounds(50, 180, 100, 25);

        textoA = new JTextField();
        textoB = new JTextField();
        textoC = new JTextField();
        textoA.setBounds(150, 100, 150, 25);
        textoB.setBounds(150, 140, 150, 25);
        textoC.setBounds(150, 180, 150, 25);

        calcular = new JButton("Calcular");
        calcular.setBounds(80, 230, 220, 30);
        calcular.setBackground(new Color(246, 86, 65));
        calcular.setForeground(Color.WHITE);

        labelX1 = new JLabel("x':");
        labelX2 = new JLabel("x'':");
        labelX1.setBounds(100, 290, 40, 25);
        labelX2.setBounds(100, 330, 40, 25);
        
        textoX1 = new JTextField();
        textoX2 = new JTextField();
        textoX1.setBounds(150, 290, 120, 25);
        textoX2.setBounds(150, 330, 120, 25);
        textoX1.setEditable(false);
        textoX2.setEditable(false);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    double a = Double.parseDouble(textoA.getText().replace(",", "."));
                    double b = Double.parseDouble(textoB.getText().replace(",", "."));
                    double c = Double.parseDouble(textoC.getText().replace(",", "."));

                    double delta = (b * b) - (4 * a * c);

                    if (delta < 0) {

                        JOptionPane.showMessageDialog(null,
                                "Delta negativo, nao existem raizes reais.");

                        textoX1.setText("");
                        textoX2.setText("");

                    } else {

                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);

                        textoX1.setText(String.valueOf(x1));
                        textoX2.setText(String.valueOf(x2));
                    }

                } catch (NumberFormatException erro) {

                    JOptionPane.showMessageDialog(null,
                            "Digite apenas numeros validos");

                }
            }
        });

        tela.add(titulo);
        tela.add(subtitulo);
        
        tela.add(labelA);
        tela.add(labelB);
        tela.add(labelC);

        tela.add(textoA);
        tela.add(textoB);
        tela.add(textoC);

        tela.add(calcular);

        tela.add(labelX1);
        tela.add(labelX2);

        tela.add(textoX1);
        tela.add(textoX2);

        setSize(400, 450);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}