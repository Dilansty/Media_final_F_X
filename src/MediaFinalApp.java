package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.Button;
import java.util.Optional;

public class MediaFinalApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Determinar o tamanho do stage (tela/janela)
        stage.setWidth(600);
        stage.setHeight(500);

        //Determinar o título do stage (tela/janela)
        stage.setTitle("Média Final");

        //Painel Raiz (root)
        BorderPane root = new BorderPane();

        Label labelTitulo = new Label();
        labelTitulo.setText("Escola \"Prof. Vicente Amato\"");
        //Formatação do texto da Label
        labelTitulo.setStyle("-fx-text-fill: #005aff; -fx-font-size: 32; -fx-font-weight: bold;");
        labelTitulo.setPadding(new Insets(10, 0, 10, 10));

        root.setTop(labelTitulo);

        Scene scene = new Scene(root);

        stage.setScene(scene);

        VBox painelResultado = new VBox();
        painelResultado.setPadding(new Insets(10, 0, 10, 10));
        Label labelAluno = new Label("Nome do aluno: ");
        Label labelMediaFinal = new Label("Média Final: ");
        Label labelSituacao = new Label("Situação: ");
        painelResultado.getChildren().addAll(labelAluno, labelMediaFinal, labelSituacao);

        //Painel de botões
        VBox painelDeBotoes = new VBox();
        painelDeBotoes.setPadding(new Insets(10, 10, 10, 0));
        painelDeBotoes.setSpacing(10);
        Button buttonCalcularMedia = new Button("Cácular média");
        buttonCalcularMedia.setPrefWidth(100);
        buttonCalcularMedia.setPrefHeight(-100);

        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(100);
        buttonLimpar.setPrefHeight(-100);

        Button buttonSair = new Button("Sair");
        buttonSair.setPrefWidth(100);
        buttonSair.setPrefHeight(-100);
        painelDeBotoes.getChildren().addAll(buttonCalcularMedia, buttonLimpar, buttonSair);

        //Painel de formulário
        VBox paineFormulario = new VBox();
        paineFormulario.setPadding(new Insets(10, 0, 10, 10));
        Label labelNome = new Label("Nome do Aluno:");
        Label labelNota1 = new Label("Nota 1:");
        Label labelNota2 = new Label("Nota 2:");
        Label labelNota3 = new Label("Nota 3:");
        Label labelNota4 = new Label("Nota 4:");

        TextField  = new TextField();
        TextField textFieldNome = new TextField();
        TextField textFieldNota1 = new TextField();
        TextField textFieldNota2 = new TextField();
        TextField textFieldNota3 = new TextField();
        TextField textFieldNota4 = new TextField();

        paineFormulario.getChildren().addAll(
                labelNome, textFieldNome,
                labelNota1, textFieldNota1,
                labelNota2, textFieldNota2,
                labelNota3, textFieldNota3,
                labelNota4, textFieldNota4
        );

        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);
        root.setLeft(paineFormulario);

        //Mostrar o stage (tela/janela)
        stage.show();

        //Eventos de clique dos botões
        buttonCalcularMedia.setOnAction(click ->{
            System.out.println("botão clicado!");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do aluno: " + nomeDigitado);

            //CALCULAR MÉDIA
            //OBTER AS NOTAS
            //CRIAR UM VETOR(array) DE NOTAS

            double[] notas = new double[4];
            String[] notasStr = new String[4];


            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] = textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3] = textFieldNota4.getText();
            notas[3] = Double.parseDouble(notasStr[3]);

            double mediaFinal = 0.0;
            int voltaMedia = 0;
            while (voltaMedia < notas.length) {
                mediaFinal = mediaFinal + notas[voltaMedia];
                voltaMedia = voltaMedia + 1;
            }
            mediaFinal = mediaFinal /notas.length;
            String mediaFinalStr = String.format("%.1f", mediaFinal);

            labelMediaFinal.setText("Media Final:" + mediaFinalStr);

            //USO DE LOOP while(ENQUANTO)
            int volta = 0;
            while (volta <10){
                System.out.println("SENAI JANDIRA");
                volta = volta + 1;
            }

            if (mediaFinal < 4){
                labelSituacao.setText("Situação: R E P R O V A D O !");
            }
            else if (mediaFinal >= 6) {
                labelSituacao.setText("Situação: APROVADO");
            }
            else labelSituacao.setText("Situação: RECUPERAÇÃO!");

        });
        buttonLimpar.setOnAction( click -> {
            textFieldNome.clear();
            textFieldNota1.clear();
            textFieldNota2.clear();
            textFieldNota3.clear();
            textFieldNota4.clear();
            labelNome.setText("Nome do Aluno: ");
            labelMediaFinal.setText("Média Final: ");
            labelSituacao.setText("Situação: ");
            textFieldNome.requestFocus();
        });
        buttonSair.setOnAction(click ->{
            Alert alerta = new Alert(AlertType.WARNING, "Fechar aplicação?",ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> botaoPressionado = aleta.showAndWait();

            if (botaoPressionado.get()==ButtonType.YES){
             Alert alerta2 = new Alert(Alert.AlertType.INFORMATION, "Até Logo!");
             alerta2.showAndWait();
            System.exit(0);
            }

        });
    }
}
