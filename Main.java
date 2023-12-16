package com.example.demo11;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


/**
 * This class represents the main application for Simon's Obstacle Board game.
 * It initializes the game board, player positions, buttons, and GUI components.
 * The game allows two players to roll a dice, move their pieces on the board,
 * and interact with various buttons to play and control the game.
 */

public class javafx extends Application implements EventHandler<ActionEvent>{

    private Stage f = new Stage();
    Label  a3;
    static Label l[];
    static Label[] m;
    Label z1;
    public static TextField tf1, tf2;
    Button b1, b2, b3,b4;
    TextField screen;
    TextArea score;
    Label myimage = new Label(" ");
    static Pane root;

    public javafx d;
    static int rno;
    static int x1;
    static int y1;
    static int pc1 = 0;
    static int pc2 = 0;
    static int w;
    static boolean b4Clicked = false;
    static Bounds r;
    static double y;
    static double z;
    static boolean player1PassedBlock13 = false;
    static boolean player2PassedBlock13 = false;

    static boolean executeB2Conditions = true;


    @Override
    public void start(Stage primaryStage) {
        f = primaryStage;
        f.setTitle("Simon's Obstacle Board");

        displayTopScores();
        // Load the image
        Image image = new Image("C:/Users/JAGRUTI/Desktop/kirabiz/demo11/cut/1.png"); // Replace with your image path
        ImageView imageView = new ImageView(image);
        // Optional: if you want the image to fit the window exactly without preserving the ratio
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        root = new Pane();
        tf1 = new TextField("Player 1");
        tf2 = new TextField("Player 2");
        screen = new TextField("Roll The Dice");


        root.getChildren().add(imageView);
        imageView.toFront(); // Display the image on top of other elements
        Scene scene = new Scene(root, 1000, 800);

        l = new Label[101];

    {

        int width = 70;
        int height = 70;
        int j = 0;

        j = 0;
        for (int i = 66; i < 71; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(690);
            l[i].setLayoutY(210 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 76; i > 70; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(270 + j * 70);
            l[i].setLayoutY(490);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 80; i > 76; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            //imageView.setPreserveRatio(true);
            l[i].setLayoutX(270);
            l[i].setLayoutY(210 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 81; i < 86; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(340 + j * 70);
            l[i].setLayoutY(210);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 86; i < 89; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(620);
            l[i].setLayoutY(280 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 92; i > 88; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(340 + j * 70);
            l[i].setLayoutY(420);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 94; i > 92; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(340);
            l[i].setLayoutY(280 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 95; i < 98; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(410 + j * 70);
            l[i].setLayoutY(280);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 100; i > 97; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(410 + j * 70);
            l[i].setLayoutY(350);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        // Tiles 81 to 91
        j = 0;
        for (int i = 59; i < 66; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));

            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(270 + j * 70);
            l[i].setLayoutY(140);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }


        j = 0;
        for (int i = 58; i > 52; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200);
            l[i].setLayoutY(140 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }

        j = 0;
        for (int i = 52; i > 44; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(560);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }

        j = 0;
        for (int i = 38; i < 45; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(760);
            l[i].setLayoutY(140 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }


        j = 0;
        for (int i = 29; i < 38; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }


        j = 0;
        for (int i = 28; i > 19; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(0);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }


        j = 0;
        for (int i = 19; i > 10; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(830);
            l[i].setLayoutY(0 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }

        // Tiles 1 to 11
        j = 0;
        for (int i = 1; i < 11; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(630);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
    }

        m=new Label[6];
        m[1] = new Label();
        m[1].setGraphic(new ImageView(new Image("file:./cut/player2.png")));
        m[1].setLayoutX(140);
        m[1].setLayoutY(650);
        // Display the image on top of other elements
        root.getChildren().add(m[1]);


        m[2] = new Label();
        m[2].setGraphic(new ImageView(new Image("file:./cut/player1.png")));
        m[2].setLayoutX(70);
        m[2].setLayoutY(650);
        // Display the image on top of other elements
        root.getChildren().add(m[2]);

        m[4] = new Label();
        m[4].setGraphic(new ImageView(new Image("file:./cut/player2.png")));
        m[4].setLayoutX(5);
        m[4].setLayoutY(290);
        // Display the image on top of other elements
        root.getChildren().add(m[4]);

        m[5] = new Label();
        m[5].setGraphic(new ImageView(new Image("file:./cut/player1.png")));
        m[5].setLayoutX(5);
        m[5].setLayoutY(340);
        // Display the image on top of other elements
        root.getChildren().add(m[5]);

        m[1].toFront();
        m[2].toFront();
        m[4].toFront();
        m[5].toFront();

        // Set the stage with the scen

        z1 = new Label();
        z1.setLayoutX(0);
        z1.setLayoutY(0);
        z1.setPrefSize(200, 100);
        //change path
        z1.setGraphic(new ImageView(new Image("C://Users//JAGRUTI//Desktop//kirabiz//demo11//cut//play.gif")));

        screen = new TextField("Roll The Dice");
        screen.setEditable(false);
        screen.setLayoutX(2);
        screen.setLayoutY(150);
        screen.setPrefSize(190, 100);
        screen.setStyle("-fx-background-color: black; -fx-text-fill: green;");


        score = new TextArea();
        score.setEditable(false);
        String content = displayTopScores();
        content = content.replace(",", "\n"); // Replace commas with new line characters
        score.setText("Score Board:\n\n" +content);

        score.setLayoutX(1000);
        score.setLayoutY(200);
        score.setPrefSize(200, 190);
        score.setWrapText(true);
        score.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;");


        tf1 = new TextField("Player 1");
        tf1.setLayoutX(25);
        tf1.setLayoutY(310);
        tf1.setPrefSize(150, 35);
        tf1.setStyle("-fx-background-color: yellow;");

        tf2 = new TextField("Player 2");
        tf2.setLayoutX(25);
        tf2.setLayoutY(350);
        tf2.setPrefSize(150, 35);
        tf2.setStyle("-fx-background-color: yellow;");

        a3 = new Label();
        a3.setLayoutX(50);
        a3.setLayoutY(400);
        a3.setPrefSize(100, 100);
        //change the path
        a3.setGraphic(new ImageView(new Image("C://Users//JAGRUTI//Desktop//kirabiz//demo11//cut/dice.gif")));

        b1 = new Button("Roll");
        b1.setLayoutX(15);
        b1.setLayoutY(490);
        b1.setPrefSize(80, 35);
        b1.setOnAction(this::handle);
        b1.setStyle("-fx-background-color: red; -fx-text-fill: black;");

        // Button 2 - Play
        b2 = new Button("Play");
        b2.setLayoutX(110);
        b2.setLayoutY(490);
        b2.setPrefSize(80, 35);
        b2.setOnAction(this::handle);
        b2.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        // Button 3 - Reset
        b3 = new Button("Reset");
        b3.setLayoutX(70);
        b3.setLayoutY(530);
        b3.setPrefSize(90, 30);
        b3.setOnAction(this::handle);
        b3.setStyle("-fx-background-color: green; -fx-text-fill: black;");


        // Button 4 - Change Level
        b4 = new Button("Change Level");
        b4.setLayoutX(15);
        b4.setLayoutY(260);
        b4.setPrefSize(170, 30);
        b4.setOnAction(this::handle);
        b4.setStyle("-fx-background-color: green; -fx-text-fill: black;");

        // Font configuration
        Font font = Font.font("Book Antiqua", 20);
        Font font1 = Font.font("Tecton Pro", 26); // Make sure this font is installed on your system
        Font font2 = Font.font("Comic Sans MS",  18);
        Font font3 = Font.font("Forte",  30); // Make sure this font is installed on your system
        Font font4 = Font.font("Book Antiqua",16);

        tf1.setFont(font);
        screen.setFont(font2);
        tf2.setFont(font);
        score.setFont(font2);

        a3.setFont(font1);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);

        root.getChildren().addAll(z1, screen, tf1 ,tf2,a3,b1,b2,b3,b4,score);
        root.setStyle("-fx-background-color: rgb(255, 130, 4);");



        // Scene and Stage setup
        primaryStage.setTitle("Simon's Obstacle Java Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }


    /**
     * This method removes existing blocks (JLabels) from the game board.
     * It iterates through the JLabel array and removes any non-null labels from the JFrame.
     * After removal, it revalidates and repaints the JFrame to reflect the changes.
     */
    public static void removeExistingBlocks() {
        // Iterate through the children of the Pane and remove labels
        for (int i = 1; i < l.length; i++) {
            if (l[i] != null) {
                root.getChildren().remove(l[i]); // Remove the Label from the Pane
                l[i] = null; // Set the Label reference to null
            }
        }
    }

    /**
     * Writes the player's score and name to a score file.
     * @param playerName The name of the player.
     * @param score The player's score to be written.
     */
    public static void writeScoreToFile(String playerName, int score) {
        File scoreFile = new File("./cut/top_scores.txt");
        List<String> scores = new ArrayList<>();

        // Read existing scores from the file
        try (BufferedReader br = new BufferedReader(new FileReader(scoreFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                scores.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the score file.");
            e.printStackTrace();
        }

        // Add the new score
        scores.add(playerName + "," + score);

        // Sort the scores (assuming higher scores are better)
        scores.sort((a, b) -> Integer.compare(Integer.parseInt(b.split(",")[1]), Integer.parseInt(a.split(",")[1])));

        // Keep only top 10 scores
        if (scores.size() > 10) {
            scores = scores.subList(0, 10);
        }

        // Write back to the file
        try (FileWriter fw = new FileWriter(scoreFile, false); // false to overwrite the file
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (String s : scores) {
                out.println(s);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the score file.");
            e.printStackTrace();
        }
    }
    static void hardLevel() {
        int j = 0;
        l = new Label[101];
        Image image = new Image("file://cut//1.png"); // Replace with your image path
        ImageView imageView = new ImageView(image);
        // Optional: if you want the image to fit the window exactly without preserving the ratio
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        int width = 70;
        int height = 70;


        j = 0;
        for (int i = 66; i < 71; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(690);
            l[i].setLayoutY(210 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 76; i > 70; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(270 + j * 70);
            l[i].setLayoutY(490);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 80; i > 76; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            //imageView.setPreserveRatio(true);
            l[i].setLayoutX(270);
            l[i].setLayoutY(210 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 81; i < 86; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(340 + j * 70);
            l[i].setLayoutY(210);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 86; i < 89; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(620);
            l[i].setLayoutY(280 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 92; i > 88; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(340 + j * 70);
            l[i].setLayoutY(420);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 94; i > 92; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(340);
            l[i].setLayoutY(280 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 95; i < 98; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(410 + j * 70);
            l[i].setLayoutY(280);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 100; i > 97; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(410 + j * 70);
            l[i].setLayoutY(350);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        // Tiles 81 to 91
        j = 0;
        for (int i = 59; i < 66; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(270 + j * 70);
            l[i].setLayoutY(140);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }


        j = 0;
        for (int i = 58; i > 52; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200);
            l[i].setLayoutY(140 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }

        j = 0;
        for (int i = 52; i > 44; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(560);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }

        j = 0;
        for (int i = 38; i < 45; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(760);
            l[i].setLayoutY(140 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }


        j = 0;
        for (int i = 29; i < 38; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 28; i > 19; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(0);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }


        j = 0;
        for (int i = 19; i > 10; i--) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(830);
            l[i].setLayoutY(0 + j * 70);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }

        // Tiles 1 to 11
        j = 0;
        for (int i = 1; i < 11; i++) {
            l[i] = new Label();
            l[i].setGraphic(new ImageView(new Image("file:.//cut/" + i + ".png")));
            imageView.setFitWidth(width);  // Set the width of the ImageView
            imageView.setFitHeight(height); // Set the height of the ImageView
            imageView.setPreserveRatio(true);
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(630);
            l[i].setStyle("-fx-border-color: black; -fx-border-width: 3;");
            root.getChildren().add(l[i]);
            j++;
        }
        m[1].toFront();
        m[2].toFront();

    }
    private String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file!";
        }

        return content.toString();
    }
    static void easyLevel()
    {

        int j = 0;
        l = new Label[101];
        Image image = new Image("file://cut//1.png"); // Replace with your image path
        ImageView imageView = new ImageView(image);
        // Optional: if you want the image to fit the window exactly without preserving the ratio
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        j = 0;
        for (int i = 66; i < 71; i++) {
            l[i] = new Label();
            l[i].setLayoutX(690); // j needs to be defined in your context
            l[i].setLayoutY(210+j*70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==69)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//7.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }
        j = 0;
        for (int i = 76; i > 70; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(270 + j * 70);
            l[i].setLayoutY(490);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;

        }
        j = 0;
        for (int i = 80; i > 76; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(270);
            l[i].setLayoutY(210 + j * 70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==79)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//7.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }
        j = 0;
        for (int i = 81; i < 86; i++) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(340 + j * 70);
            l[i].setLayoutY(210);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==85)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//89.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }
        j = 0;
        for (int i = 86; i < 89; i++) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));

            l[i].setLayoutX(620);
            l[i].setLayoutY(280 + j * 70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 92; i > 88; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));

            l[i].setLayoutX(340 + j * 70);
            l[i].setLayoutY(420);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==91)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//89.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }
        j = 0;
        for (int i = 94; i > 92; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(340);
            l[i].setLayoutY(280 + j * 70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 95; i < 98; i++) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(410 + j * 70);
            l[i].setLayoutY(280);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
        }
        j = 0;
        for (int i = 100; i > 97; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(410 + j * 70);
            l[i].setLayoutY(350);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==100)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//100.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }
        // Tiles 81 to 91
        j = 0;
        for (int i = 59; i < 66; i++) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));

            l[i].setLayoutX(270 + j * 70);
            l[i].setLayoutY(140);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==62)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//89.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }


        j = 0;
        for (int i = 58; i > 52; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(200);
            l[i].setLayoutY(140 + j * 70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==56)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//89.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }

        j = 0;
        for (int i = 52; i > 44; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(560);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==45)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//7.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }
        }

        j = 0;
        for (int i = 38; i < 45; i++) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(760);
            l[i].setLayoutY(140 + j * 70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==42)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//89.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }


        j = 0;
        for (int i = 29; i < 38; i++) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==36)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//7.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }
        j = 0;
        for (int i = 28; i > 19; i--) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));

            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(0);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==22)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//22.png")));
                imageView.setFitWidth(60);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));

            }
            if(i==23)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//23.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }
            if(i==24)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//24.png")));
                imageView.setFitWidth(70);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }
        }
        j = 0;

        for (int i = 19; i > 10; i--) {

            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(830);
            l[i].setLayoutY(0 + j * 70);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==17)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//7.png")));
                imageView.setFitWidth(60);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                //l[i].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }

        }

        // Tiles 1 to 11
        j = 0;
        for (int i = 1; i < 11; i++) {
            l[i] = new Label();
            l[i] = new Label(String.valueOf(i));
            l[i].setLayoutX(200 + j * 70);
            l[i].setLayoutY(630);
            l[i].setPrefSize(70, 70);
            l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            l[i].setText(String.valueOf(i));
            l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            root.getChildren().add(l[i]);
            j++;
            if(i==10)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//7.png")));
                imageView.setFitWidth(50);
                imageView.setFitHeight(70);
                l[i].setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setBorder(new Border(new BorderStroke(null,null,null,null)));
            }
            if(i==1)
            {
                l[i].setGraphic(new ImageView(new Image("file:.//cut//1.png")));
                l[i].setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                l[i].setText(String.valueOf(i));
                l[i].setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            }
        }

        m[1].toFront();
        m[2].toFront();
        m[4].toFront();
        m[5].toFront();

    }

    /**
     * This method displays the top scores from a score file.
     * It reads score data from a text file, sorts the scores in descending order,
     * and prints the top 10 scores along with player names to the console.
     */
    public static String displayTopScores() {
        StringBuilder formattedScores = new StringBuilder();
        File scoreFile = new File("./cut/top_scores.txt");
        try {
            List<String> scoreLines = Files.readAllLines(scoreFile.toPath());
            List<PlayerScore> scores = new ArrayList<>();

            for (String line : scoreLines) {
                String[] parts = line.split(",");
                scores.add(new PlayerScore(parts[0], Integer.parseInt(parts[1])));
            }

            scores.sort(Comparator.comparingInt(PlayerScore::getScore).reversed());

            System.out.println("Top Scores:");
            for (int i = 0; i < Math.min(scores.size(), 10); i++) {
                System.out.println((i + 1) + ". " + scores.get(i).getPlayerName() + " - " + scores.get(i).getScore());

                formattedScores.append((i + 1))
                        .append(". ")
                        .append(scores.get(i).getPlayerName())
                        .append(" - ")
                        .append(scores.get(i).getScore())
                        .append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the score file.");
            e.printStackTrace();
        }
        return formattedScores.toString();
    }

     //The main method of the program.
    public static void main(String[] args) {
        launch(args);
        //displayTopScores();

    }


    /**
     * Generates a random number and updates the game interface accordingly.
     * It sets the dice number and displays it to the player.
     */
     void randomNumber() {
        Random generator = new Random();
        rno = generator.nextInt(9) + 1;
        myimage.setText(String.valueOf(rno));
        a3.setVisible(true);
        System.out.println("random function");
        screen.setText(String.valueOf("Dice number : "+rno));

     }
    /**
     * Handles various button clicks and game actions based on the event source.
     * It includes actions for resetting, rolling the dice, changing levels, and more.
     * @param e The ActionEvent object representing the button click event.
     */

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == b3) {

            // Create an alert with a specific type
            //reset

            screen.setText("Play again! ");
            int[] a = new int[100];

            for (int i = 0; i < a.length; i++) {
                a[i] = i + 1;
            }
            int [] b=new int[100];
            for (int i = 0; i < b.length; i++) {
                b[i] = 1;
            }

            for (int i = 0; i < 100; i++) {
                if (pc2 == a[i]) {
                    r = l[b[i]].localToScene(l[b[i]].getBoundsInLocal());
                    y = r.getMinX();
                    z = r.getMinY();
                    x1 = (int) Math.round(y);
                    y1 = (int) Math.round(z);
                    m[2].setLayoutX(x1 + 17);
                    m[2].setLayoutY(y1 + 17);
                    m[2].setPrefWidth(20);
                    m[2].setPrefHeight(52);
                    pc2 = b[i];
                }
                if (pc1 == a[i]) {
                    r = l[b[i]].localToScene(l[b[i]].getBoundsInLocal());
                    y = r.getMinX();
                    z = r.getMinY();
                    x1 = (int) Math.round(y);
                    y1 = (int) Math.round(z);
                    m[1].setLayoutX(x1 + 10);
                    m[1].setLayoutY(y1 + 17);
                    m[1].setPrefWidth(20);
                    m[1].setPrefHeight(52);
                    pc1 = b[i];
                }

            }
            javafx.removeExistingBlocks();
            javafx.hardLevel();
            myimage.setText(" ");
            //root = new Pane();
            w = 0;
        }
        else if (e.getSource() == b1) {
            // Calls the randomNumber() method to
            // generate a random number and update the game interface.
            randomNumber();
            System.out.println("b1 clicked");
        }
        else if(e.getSource()==b4 )
        {
            //Removes existing blocks, sets the game to Easy Level, and updates the button text.
            // Also triggers actions in the Level class.

            // Create an alert with a specific type
            removeExistingBlocks();
            easyLevel();
            b4.setText("Easy Level");
            b4Clicked = true;
            //Level.actionPerformeded();

        }
        else if (e.getSource() == b2 && executeB2Conditions) {
            // Handles player movements based on the dice roll and checks for collisions and obstacles.
            // Adjusts player positions and updates the game interface accordingly
            if (w % 2 == 0) //w=2,pc1=3,rno=2
            {
                screen.setText(tf2.getText() + " chance");
                /**
                 * Handles collision and obstacle detection for player movements in the game.
                 * Checks if player 2 collides with player 1 and handles the collision.
                 * Also, checks for spike pits and prevents player 1 from advancing if encountered.
                 * @param pc1 The current position of player 1 on the game board.
                 * @param pc2 The current position of player 2 on the game board.
                 * @param rno The randomly generated dice roll value.
                 */
                if ((pc1 + rno) < 101) {

                    if (pc2 == pc1 + rno) {
                        screen.setText(tf1.getText() + " collided!");
                        pc2 = 1; // Player 2 returns to the starting position
                        m[2].setLayoutX(70);
                        m[2].setLayoutY(650);
                        m[2].setPrefSize(20, 52); // Reset player 2's position
                    }

                    // Checks for spike pits and prevents player 1 from advancing if encountered.
                    if ((pc1 == 13 && (pc1 + rno == 22))) {
                        rno = 0; // Set the dice roll to zero to prevent player 1 from advancing.
                    }
                    if ((pc1 == 13 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 13 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 14 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 14 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 14 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 15 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 15 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 15 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 16 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 16 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 16 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 17 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 17 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 17 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 18 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 18 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 18 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 19 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 19 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 19 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 20 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 20 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 20 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if ((pc1 == 21 && (pc1 + rno == 22))) {
                        rno = 0;
                    }
                    if ((pc1 == 21 && (pc1 + rno == 23))) {
                        rno = 0;
                    }
                    if ((pc1 == 21 && (pc1 + rno == 24))) {
                        rno = 0;
                    }
                    if (!b4Clicked) {
                        if ((pc1 == 33 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 33 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 33 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 34 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 34 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 34 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 35 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 35 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 35 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 36 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 36 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 36 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 37 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 37 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 37 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 38 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 38 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 38 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 39 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 39 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 39 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 40 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 40 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 40 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 41 && (pc1 + rno == 42))) {
                            rno = 0;
                        }
                        if ((pc1 == 41 && (pc1 + rno == 43))) {
                            rno = 0;
                        }
                        if ((pc1 == 41 && (pc1 + rno == 44))) {
                            rno = 0;
                        }
                        if ((pc1 == 56 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 56 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 56 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 57 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 57 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 57 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 58 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 58 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 58 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 59 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 59 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 59 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 60 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 60 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 60 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 61 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 61 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 61 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 62 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 62 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 62 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 63 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 63 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 63 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                        if ((pc1 == 64 && (pc1 + rno == 65))) {
                            rno = 0;
                        }
                        if ((pc1 == 64 && (pc1 + rno == 66))) {
                            rno = 0;
                        }
                        if ((pc1 == 64 && (pc1 + rno == 67))) {
                            rno = 0;
                        }
                    }


                    /**
                     * Handles player 1 movements, obstacle detection, and fire skips based on game rules.
                     * If the "Easy Level" button (b4Clicked) is not clicked:
                     * - Checks if player 1 encounters fire skips at specific block positions.
                     * - If fire skips are not encountered, updates player 1's position and displays it on the game board.
                     * If the "Easy Level" button is clicked:
                     * - Checks if player 1 encounters fire skips at specific block positions in the advanced level.
                     * - If fire skips are not encountered, updates player 1's position in the advanced level and displays it on the game board.
                     * @param pc1 The current position of player 1 on the game board.
                     * @param rno The randomly generated dice roll value for player 1.
                     * @param player1PassedBlock13 Indicates whether player 1 has passed Block 13 in the game.
                     * @param w The current turn or move count of player 1.
                     */

                    if (!b4Clicked) {
                        // Handle fire skips in the standard level
                        if (pc1 + rno == 3 || pc1 + rno == 7 || pc1 + rno == 17 || pc1 + rno == 31 || pc1 + rno == 35 || pc1 + rno == 40 || pc1 + rno == 54 || pc1 + rno == 55 || pc1 + rno == 76 || pc1 + rno == 82 || pc1 + rno == 93 || pc1 + rno == 99 && !player1PassedBlock13) {
                            player1PassedBlock13 = true;
                            screen.setText(tf1.getText() + " fire skips!");
                        } else {
                            // Update player 1's position and display it on the game board
                            w++;
                            pc1 = pc1 + rno;
                            System.out.println("Player1 position: " + pc1);

                            r = l[pc1].localToScene(l[pc1].getBoundsInLocal());
                            y = r.getMinX();
                            z = r.getMinY();
                            x1 = (int) Math.round(y);
                            y1 = (int) Math.round(z);
                            m[1].setLayoutX(x1 + 10);
                            m[1].setLayoutY(y1 + 20);
                            m[1].setPrefWidth(20);
                            m[1].setPrefHeight(52);

                            System.out.println("Is m[1] in scene? " + (m[1].getParent() != null));

                        }
                    } else if (b4Clicked) {
                        // Handle fire skips in the advanced level
                        if (pc1 + rno == 10 || pc1 + rno == 17 || pc1 + rno == 36 || pc1 + rno == 45 || pc1 + rno == 69 || pc1 + rno == 79 || pc1+rno==79 && !player1PassedBlock13) {
                            player1PassedBlock13 = true;
                            screen.setText(tf1.getText() + " fire skips!");
                        } else {


                            w++;
                            pc1 = pc1 + rno;
                            System.out.println("Player1 position: " + pc1);
                            r = l[pc1].localToScene(l[pc1].getBoundsInLocal());
                            y = r.getMinX();
                            z = r.getMinY();
                            x1 = (int) Math.round(y);
                            y1 = (int) Math.round(z);
                            m[1].setLayoutX(x1 + 10);
                            m[1].setLayoutY(y1 + 20);
                            m[1].setPrefWidth(20);
                            m[1].setPrefHeight(52);


                        }
                    }
                    /**  * Handles player 1 and player 2 movements, obstacle detection, and blackhole-fall events based on game rules.
                     * If the "Easy Level" button (b4Clicked) is not clicked:
                     * - Checks if player 1 encounters blackhole blocks at specific positions and updates player 1's position if necessary.
                     * - Handles player 2's movements and obstacle detection for standard level.*/
                    if (!b4Clicked) {
                        //blackhole
                        int ay[] = new int[]{10, 20, 27, 60, 78, 81, 89, 98};
                        int b[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

                        for (int i = 0; i < 8; i++) {
                            if (pc1 == ay[i]) {
                                r = l[b[i]].localToScene(l[b[i]].getBoundsInLocal());
                                y = r.getMinX();
                                z = r.getMinY();
                                x1 = (int) Math.round(y);
                                y1 = (int) Math.round(z);
                                m[1].setLayoutX(x1 + 10);
                                m[1].setLayoutY(y1 + 17);
                                m[1].setPrefWidth(20);
                                m[1].setPrefHeight(52);
                                pc1 = b[i];
                                screen.setText(tf1.getText() + " blackhole-fall!");

                            }
                        }
                    }
                    /** * If the "Easy Level" button is clicked:
                     * - Checks if player 1 encounters blackhole blocks at specific positions in the advanced level and updates player 1's position if necessary.
                     * - Handles player 2's movements and obstacle detection for advanced level.
                     * @param pc1 The current position of player 1 on the game board.
                     * @param rno The randomly generated dice roll value for player 1.
                     * @param b4Clicked Indicates whether the "Easy Level" button has been clicked.
                     * @param pc2 The current position of player 2 on the game board.
                     */
                    else {
                        int a4[] = new int[]{42, 62, 56, 85, 91};
                        int b4[] = new int[]{1, 1, 1, 1, 1};

                        for (int i = 0; i < 5; i++) {
                            if (pc1 == a4[i]) {
                                r = l[b4[i]].localToScene(l[b4[i]].getBoundsInLocal());
                                y = r.getMinX();
                                z = r.getMinY();
                                x1 = (int) Math.round(y);
                                y1 = (int) Math.round(z);
                                m[1].setLayoutX(x1 + 10);
                                m[1].setLayoutY(y1 + 17);
                                m[1].setPrefWidth(20);
                                m[1].setPrefHeight(52);
                                pc1 = b4[i];
                                screen.setText(tf1.getText() + " blackhole-fall!");

                            }
                        }
                    }
                }
            } else {
                screen.setText(tf1.getText() + " chance");

                if ((pc2 == 13 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 13 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 13 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 14 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 14 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 14 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 15 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 15 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 15 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 16 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 16 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 16 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 17 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 17 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 17 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 18 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 18 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 18 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 19 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 19 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 19 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 20 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 20 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 20 && (pc2 + rno == 24))) {
                    rno = 0;
                }
                if ((pc2 == 21 && (pc2 + rno == 22))) {
                    rno = 0;
                }
                if ((pc2 == 21 && (pc2 + rno == 23))) {
                    rno = 0;
                }
                if ((pc2 == 21 && (pc2 + rno == 24))) {
                    rno = 0;
                }

                if (!b4Clicked) {
                    if ((pc2 == 33 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 33 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 33 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 34 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 34 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 34 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 35 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 35 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 35 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 36 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 36 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 36 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 37 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 37 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 37 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 38 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 38 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 38 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 39 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 39 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 39 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 40 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 40 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 40 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 41 && (pc2 + rno == 42))) {
                        rno = 0;
                    }
                    if ((pc2 == 41 && (pc2 + rno == 43))) {
                        rno = 0;
                    }
                    if ((pc2 == 41 && (pc2 + rno == 44))) {
                        rno = 0;
                    }
                    if ((pc2 == 56 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 56 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 56 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 57 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 57 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 57 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 58 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 58 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 58 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 59 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 59 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 59 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 60 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 60 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 60 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 61 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 61 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 61 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 62 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 62 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 62 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 63 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 63 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 63 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                    if ((pc2 == 64 && (pc2 + rno == 65))) {
                        rno = 0;
                    }
                    if ((pc2 == 64 && (pc2 + rno == 66))) {
                        rno = 0;
                    }
                    if ((pc2 == 64 && (pc2 + rno == 67))) {
                        rno = 0;
                    }
                }

                /**
                 * Handles player movements, collisions, obstacle detection, and blackhole-fall events for both player 1 and player 2 based on game rules.
                 *
                 * @param pc1 The current position of player 1 on the game board.
                 * @param rno The randomly generated dice roll value for player 1.
                 * @param b4Clicked Indicates whether the "Easy Level" button has been clicked.
                 * @param pc2 The current position of player 2 on the game board.
                 */
                //code for collision for player
                if ((pc2 + rno) < 101) {
                    if (pc1 == pc2 + rno) {
                        screen.setText(tf2.getText() + " collided!");
                        pc1 = 1; // Player 1 returns to the starting position
                        m[1].setLayoutX(140);
                        m[1].setLayoutY(650);
                        m[1].setPrefWidth(20);
                        m[1].setPrefHeight(52);
                    }

                    if (!b4Clicked) {
                        // Handle skipping turns for player 2 in the standard level
                        boolean skipTurn = (pc2 + rno == 3 || pc2 + rno == 7 || pc2 + rno == 17 || pc2 + rno == 31 || pc2 + rno == 35 || pc2 + rno == 40 || pc2 + rno == 54 || pc2 + rno == 55 || pc2 + rno == 76 || pc2 + rno == 82 || pc2 + rno == 93 || pc2 + rno == 99 && !player2PassedBlock13);
                        if (skipTurn) {
                            player2PassedBlock13 = true;
                            screen.setText(tf2.getText() + " fire skips!");
                        } else {
                            // Handle skipping turns for player 2 in the advanced level
                            w++;
                            pc2 = pc2 + rno;
                            System.out.println("Player2 position: " + pc2);
                            r = l[pc2].localToScene(l[pc2].getBoundsInLocal());
                            y = r.getMinX();
                            z = r.getMinY();
                            x1 = (int) Math.round(y);
                            y1 = (int) Math.round(z);
//                            System.out.println("New X position: " + (x1 + 10));
//                            System.out.println("New Y position: " + (y1 + 20));
                            m[2].setLayoutX(x1 + 10);
                            m[2].setLayoutY(y1 + 20);
                            m[2].setPrefWidth(20);
                            m[2].setPrefHeight(52);

                        }
                    } else {
                        boolean skipTurn = (pc2 + rno == 10 || pc2 + rno == 17 || pc2 + rno == 36 || pc2 + rno == 45 || pc2 + rno == 69 || pc2 + rno == 79 && !player2PassedBlock13);
                        if (skipTurn) {
                            player2PassedBlock13 = true;
                            screen.setText(tf2.getText() + " fire skips!");
                        } else {

                            w++;
                            pc2 = pc2 + rno;
                            System.out.println("Player2 position: " + pc2);
                            r = l[pc2].localToScene(l[pc2].getBoundsInLocal());
                            y = r.getMinX();
                            z = r.getMinY();
                            x1 = (int) Math.round(y);
                            y1 = (int) Math.round(z);
                            m[2].setLayoutX(x1 + 10);
                            m[2].setLayoutY(y1 + 20);
                            m[2].setPrefWidth(20);
                            m[2].setPrefHeight(52);
                        }
                    }
                    if (!b4Clicked) {
                        //code for black hole
                        int ax[] = new int[]{10, 20, 27, 60, 78, 81, 89, 98};
                        int b[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

                        for (int i = 0; i < 8; i++) {
                            if (pc2 == ax[i]) {
                                r = l[b[i]].localToScene(l[b[i]].getBoundsInLocal());
                                y = r.getMinX();
                                z = r.getMinY();
                                x1 = (int) Math.round(y);
                                y1 = (int) Math.round(z);
                                m[2].setLayoutX(x1 + 10);
                                m[2].setLayoutY(y1 + 17);
                                m[2].setPrefWidth(20);
                                m[2].setPrefHeight(52);
                                pc2 = b[i];
                                screen.setText(tf2.getText() + " blackhole fall!");
                            }
                        }
                    } else {
                        int ax[] = new int[]{42, 62, 56, 85, 91};
                        int b[] = new int[]{1, 1, 1, 1, 1};

                        for (int i = 0; i < 5; i++) {
                            if (pc2 == ax[i]) {
                                r = l[b[i]].localToScene(l[b[i]].getBoundsInLocal());
                                y = r.getMinX();
                                z = r.getMinY();
                                x1 = (int) Math.round(y);
                                y1 = (int) Math.round(z);
                                m[2].setLayoutX(x1 + 10);
                                m[2].setLayoutY(y1 + 20);
                                m[2].setPrefWidth(20);
                                pc2 = b[i];
                                screen.setText(tf2.getText() + " blackhole fall!");
                            }
                        }
                    }

                }
            }
            if (pc1 == 100) {
                screen.setText(tf1.getText() + " wins!");
                javafx.writeScoreToFile(String.valueOf(tf1.getText()), pc1);
                javafx.writeScoreToFile(String.valueOf(tf1.getText()),pc2);
                javafx.displayTopScores();
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), event -> System.exit(10)));
                timeline.setCycleCount(1); // Equivalent to non-repeating in Swing Timer
                timeline.play();

            } else if (pc2 == 100) {
                screen.setText(tf2.getText() + " wins!");

                javafx.writeScoreToFile(String.valueOf(tf2.getText()), pc2);
                javafx.writeScoreToFile(String.valueOf(tf1.getText()),pc1);
                javafx.displayTopScores();
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), event -> System.exit(10)));
                timeline.setCycleCount(1); // Equivalent to non-repeating in Swing Timer
                timeline.play();
            }
        }
        }
}

/**
 * Represents a player's score in the game.
 */
class PlayerScore {
    private String playerName;
    private int score;
    /**
     * Constructs a PlayerScore object with the specified player name and score.
     *
     * @param playerName The name of the player.
     * @param score      The player's score.
     */
    public PlayerScore(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }
    /**
     * Gets the name of the player.
     *
     * @return The player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Gets the score of the player.
     *
     * @return The player's score.
     */
    public int getScore() {
        return score;
    }
}

class GameResultApp extends Application {

    private Label screen;
    private String player1Name = "Player 1"; // Replace with actual player names
    private String player2Name = "Player 2"; // Replace with actual player names

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Result");

        screen = new Label();
        StackPane root = new StackPane(screen);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();

        int pc1 = 100; // Replace with the actual value
        int pc2 = 100; // Replace with the actual value

        if (pc1 == 100) {
            String winnerName = player1Name;
            screen.setText(winnerName + " wins!");
            showWinnerAlert(winnerName);
        } else if (pc2 == 100) {
            String winnerName = player2Name;
            screen.setText(winnerName + " wins!");
            showWinnerAlert(winnerName);
        }
    }

    private void showWinnerAlert(String winnerName) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner!");
        alert.setHeaderText(null);
        alert.setContentText(winnerName + " is the Winner!!!");

        // Create a timeline to close the application after 5 seconds
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), e -> System.exit(0))
        );
        timeline.setCycleCount(1);
        timeline.play();

        alert.showAndWait();
    }
}



