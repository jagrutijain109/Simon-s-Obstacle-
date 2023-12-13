import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * This class represents the main application for Simon's Obstacle Board game.
 * It initializes the game board, player positions, buttons, and GUI components.
 * The game allows two players to roll a dice, move their pieces on the board,
 * and interact with various buttons to play and control the game.
 */

public class Main
{
    /**
     * The main JFrame that represents the game's graphical user interface.
     */
    static JFrame f = new JFrame("Simons's Obstacle Board");

    // Various GUI components
    static JLabel tf;
    static JLabel dice;
    static JLabel a3;
    static JLabel[] l;
    static JLabel m[];
    static JLabel dc[];
    static JLabel z;
    static JLabel k;

    public static JTextField tf1,tf2;
    static JButton b1,b2,b3,b4,start;

    static JTextField screen;
    JLabel myimage =new JLabel(" ");
    Listener o = new Listener(this);
    int numPlayers;
    int[] playerPositions;

    /**
     * Constructor for the Main class. Initializes the game board, players, and GUI components.
     */





    Main()
    {
        // Initialize and configure the game board, players, and GUI components
        JLabel bg=new JLabel(new ImageIcon(".//simons_obstacle_course//assets/bg.jpg"));
        bg.setBounds(0,0,0,735);

        JWindow window = new JWindow();
        window.getContentPane().add(  new JLabel("", new ImageIcon(".//simons_obstacle_course//assets/splash0.jpg"), SwingConstants.LEFT));
        window.setBounds(0, 0, 1600, 1000);
        window.setVisible(true);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(screenSize1.width, screenSize1.height);
        window.pack();
        window.dispose();

        // Create and configure GUI components (labels, buttons, text fields, etc.)
        l=new JLabel[101];
        m=new JLabel[6];




        m[1]=new JLabel();
        m[1].setBounds(140,650,20,52);
        m[1].setIcon(new ImageIcon(".//simons_obstacle_course//assets/player2.png"));
        f.add(m[1]);

        m[2]=new JLabel();
        m[2].setBounds(70,650,20,52);
        m[2].setIcon(new ImageIcon(".//simons_obstacle_course//assets/player1.png"));
        f.add(m[2]);

        m[4]=new JLabel();
        m[4].setBounds(5,290,20,52);
        m[4].setIcon(new ImageIcon(".//simons_obstacle_course//assets/player2.png"));
        f.add(m[4]);

        m[5]=new JLabel();
        m[5].setBounds(5,340,20,52);
        m[5].setIcon(new ImageIcon(".//simons_obstacle_course//assets/player1.png"));
        f.add(m[5]);

        m[3]=new JLabel();
        m[3].setBounds(50,570,150,150);
        m[3].setIcon(new ImageIcon(".//simons_obstacle_course//assets/start.jpg"));
        f.add(m[3]);

        // Add components to the JFrame and set the JFrame's appearance
        int j=0;

        j=0;
        for(int i=1;i<11;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((200+j*70),630,70,70);
            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=19;i>10;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(830,(0+j*70),70,70);
            l[i].setIcon(new ImageIcon(".//simons_obstacle_course//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=28;i>19;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((200+j*70),0,70,70);

            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=29;i<38;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((200+j*70),70,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=38;i<45;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds(760,(140+j*70),70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=52;i>44;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((200+j*70),560,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=58;i>52;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(200,(140+j*70),70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=59;i<66;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((270+j*70),140,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=66;i<71;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds(690,(210+j*70),70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=76;i>70;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((270+j*70),490,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }

        j=0;
        for(int i=80;i>76;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(270,(210+j*70),70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=81;i<86;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((340+j*70),210,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=86;i<89;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds(620,(280+j*70),70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=92;i>88;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((340+j*70),420,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=94;i>92;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(340,(280+j*70),70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=95;i<98;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((410+j*70),280,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=100;i>97;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((410+j*70),350,70,70);

            l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut/"+i+".png"));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }

        // Configure the game board and GUI appearance
        tf=new JLabel();
        tf.setBounds(920,0,50,700);
        tf.setIcon(new ImageIcon(".//simons_obstacle_course//assets/bg.jpg"));
        f.add(tf);

        z=new JLabel();
        z.setBounds(0,0,200,100);
        z.setIcon(new ImageIcon(".//simons_obstacle_course//assets/play.gif"));
        f.add(z);




        screen= new JTextField("Roll The Dice");
        screen.setBounds(2,150,190,100);
        screen.setBackground(Color.BLACK);
        screen.setForeground(Color.GREEN);
        f.add(screen);

        tf1=new JTextField();
        tf1.setBounds(25,310,150,35);
        tf1.setText("Player 1 ");
        f.add(tf1);
        tf1.setBackground(Color.YELLOW);

        String valuetf1 = String.valueOf(tf1);

        tf2=new JTextField();
        tf2.setBounds(25,350,150,35);
        tf2.setText("Player 2");
        f.add(tf2);
        tf2.setBackground(Color.YELLOW);



        Font f1 =new Font("Bauhaus 93",Font.ITALIC,20);
        k=new JLabel();
        k.setBounds(60,400,100,100);
        f.add(k);

        a3=new JLabel();
        a3.setBounds(50,400,100,100);
        a3.setText("");
        a3.setIcon(new ImageIcon(".//simons_obstacle_course//assets/dice.gif"));
        f.add(a3);

        b1=new JButton();
        b1.setBounds(15,490,80,35);
        b1.setText("Roll");
        b1.addActionListener(o);
        b1.setBackground(Color.red);
        b1.setForeground(Color.black);
        f.add(b1);



        b2 =new JButton();
        b2.setBounds(110,490,80,35);
        b2.setText("Play");
        b2.addActionListener(o);
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        f.add(b2);

        b3 =new JButton();
        b3.setBounds(70,530,90,30);
        b3.setText("Reset");
        b3.addActionListener(o);
        b3.setBackground(Color.green);
        b3.setForeground(Color.black);
        f.add(b3);

        b4 =new JButton();
        b4.setBounds(15,260,170,30);
        b4.setText("Change Level");
        b4.addActionListener(o);
        b4.setBackground(Color.green);
        b4.setForeground(Color.black);
        f.add(b4);

        /**
         * Represents the initialization and configuration of various GUI components and styles in the game.
         */
        myimage =new JLabel(" ");
        myimage.setForeground(Color.WHITE);
        myimage.setBounds(120,400,100,100);
        f.add(myimage);

        // Configure fonts for different GUI components
        Font font = new Font("Book Antiqua", Font.BOLD,20);
        Font font1 = new Font("Tecton Pro", Font.BOLD,26);
        Font font2=new Font("Comic Sans MS",Font.BOLD,18);
        Font font3=new Font("forte",Font.BOLD,30);
        Font font4 = new Font("Book Antiqua", Font.BOLD,16);

        tf.setFont(font4);
        tf1.setFont(font);
        screen.setFont(font2);
        tf2.setFont(font);
        myimage.setFont(font3);

        a3.setFont(font1);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        f.setLayout(null);



        // Create and configure the "start" button
        start=new JButton();
        start.setIcon(new ImageIcon(".//simons_obstacle_course//assets/start.gif"));
        start.setBounds(50,580,150,60);
        start.addActionListener(o);
        f.add(start);

        // Configure the main JFrame
        f.setLayout(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.add(bg);

        f.setSize(1600,1000);
        f.getContentPane().setBackground(new Color(255,130,4));

        // Display a welcome message using a JOptionPane
        JOptionPane.showMessageDialog(null,
                "<html><body><div style='text-align: center;'>" +
                        "<h1>Welcome!!</h1>" +
                        "To The Simon's Obstacle Course Game<br/>" +
                        "Let's Start The Game<br/>" +
                        "</div></body></html>");
        displayTopScores();
    }

    /**
 * This method configures the game board for the Easy Level in Simon's Obstacle Course Game.
 * It sets up obstacles and styling for the game board, including background colors and images.*/
    static void EasyLevel()
    {
        int j=0;

        j=0;
        for(int i=1;i<11;i++)
        {

            l[i]=new JLabel();
            l[i].setBounds((200+j*70),630,70,70);
            l[i].setBackground(Color.blue);
            l[i].setText(String.valueOf(i));
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            if(i==10)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//7.png"));
            }
            if(i==1)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//1.png"));
            }
            j++;
        }

        j=0;
        for(int i=19;i>10;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(830,(0+j*70),70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==17)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//7.png"));
            }
        }
        j=0;
        for(int i=28;i>19;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((200+j*70),0,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            f.add(l[i]);
            j++;
            if(i==22)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//22.png"));
            }
            if(i==23)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//23.png"));
            }
            if(i==24)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//24.png"));
            }
        }
        j=0;
        for(int i=29;i<38;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((200+j*70),70,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==36)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//7.png"));
            }
        }
        j=0;
        for(int i=38;i<45;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds(760,(140+j*70),70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==42)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//89.png"));
            }
        }
        j=0;
        for(int i=52;i>44;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((200+j*70),560,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==45)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//7.png"));
            }
        }
        j=0;
        for(int i=58;i>52;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(200,(140+j*70),70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==56)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//89.png"));
            }
        }
        j=0;
        for(int i=59;i<66;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((270+j*70),140,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==62)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//89.png"));
            }
        }
        j=0;
        for(int i=66;i<71;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds(690,(210+j*70),70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==69)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//7.png"));
            }

        }
        j=0;
        for(int i=76;i>70;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((270+j*70),490,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }

        j=0;
        for(int i=80;i>76;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(270,(210+j*70),70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==79)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//7.png"));
            }
        }
        j=0;
        for(int i=81;i<86;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((340+j*70),210,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==85)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//89.png"));
            }
        }
        j=0;
        for(int i=86;i<89;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds(620,(280+j*70),70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=92;i>88;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((340+j*70),420,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==91)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//89.png"));
            }
        }
        j=0;
        for(int i=94;i>92;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds(340,(280+j*70),70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=95;i<98;i++)
        {
            l[i]=new JLabel();
            l[i].setBounds((410+j*70),280,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.BLUE);
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
        }
        j=0;
        for(int i=100;i>97;i--)
        {
            l[i]=new JLabel();
            l[i].setBounds((410+j*70),350,70,70);
            l[i].setText(String.valueOf(i));
            l[i].setBackground(Color.blue);
            l[i].setOpaque(true);
            l[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            f.add(l[i]);
            j++;
            if(i==100)
            {
                l[i].setIcon(new ImageIcon(".//simons_obstacle_course.//cut//100.png"));
            }
        }
    }

    /**
     * This method removes existing blocks (JLabels) from the game board.
     * It iterates through the JLabel array and removes any non-null labels from the JFrame.
     * After removal, it revalidates and repaints the JFrame to reflect the changes.
     */
    public static void removeExistingBlocks() {
        for (int i = 1; i < l.length; i++) {
            if (l[i] != null) {
                f.remove(l[i]); // Remove the JLabel from the JFrame
                   // Set the JLabel to null
            }
        }
        f.revalidate();        // Revalidate the JFrame to reflect changes
        f.repaint();           // Repaint the JFrame
    }

    /**
     * Constructor for the Main class.
     * Initializes the number of players and creates an array to store player positions.
     * @param numPlayers The number of players in the game.
     */
    Main(int numPlayers) {
        this.numPlayers = numPlayers;
        playerPositions = new int[numPlayers];
    }

    /**
     * Converts the JTextField tf1 to a string value and stores it in valuetf1.
     * Converts the JTextField tf2 to a string value and stores it in valuetf2.
     * These string values can be used elsewhere in the code.
     */
    static String valuetf1 = String.valueOf(tf1);

    static String valuetf2=String.valueOf(tf2);

    /**
     * Writes the player's score and name to a score file.
     * @param playerName The name of the player.
     * @param score The player's score to be written.
     */
    public static void writeScoreToFile(String playerName, int score) {
        File scoreFile = new File(".//simons_obstacle_course//top_scores.txt");
        try (FileWriter fw = new FileWriter(scoreFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(playerName + "," + score);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the score file.");
            e.printStackTrace();
        }
    }

    /**
     * This method displays the top scores from a score file.
     * It reads score data from a text file, sorts the scores in descending order,
     * and prints the top 10 scores along with player names to the console.
     */
    public static void displayTopScores() {
        File scoreFile = new File(".//simons_obstacle_course//top_scores.txt");
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
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the score file.");
            e.printStackTrace();
        }
    }

    /**
     * The main method of the program.
     * It initializes the Main class, creates a Level object, and sets the number of players.
     * @param s An array of command-line arguments (not used in this context).
     */
    public static void main(String []s)
    {
        new Main();
        //Level level=new Level();
        int numPlayers = 4;
        new Main(numPlayers);
    }
}

/**
 * This class implements an ActionListener for handling events in the Simon's Obstacle Course Game.
 * It contains various static variables and methods used to control the game flow and actions.
 * The class also handles button clicks, random number generation, and level changes.
 */
class Listener implements ActionListener {
    static String tf1=String.valueOf(Main.valuetf1);
    static String tf2=String.valueOf(Main.valuetf2);
    static Main d;
    static int rno;
    static int x1;
    static int y1;
    static int pc1=0;
    static int pc2 =0;
    static int w;
    Rectangle r = new Rectangle();
    static double y, z;
    static boolean player1PassedBlock13 = false;
    static boolean player2PassedBlock13 = false;
    static boolean executeB2Conditions = true;
    static boolean b4Clicked = false;

    /**
     * Constructor for the Listener class.
     * Initializes an instance of Listener with a reference to the Main class.
     * @param d The Main class instance to associate with this listener.
     */
    Listener(Main d) {
        this.d = d;
    }

    /**
     * Generates a random number and updates the game interface accordingly.
     * It sets the dice number and displays it to the player.
     */
    void randomNumber()
    {
        Random generator = new Random();
        rno = generator.nextInt(9) + 1;
        d.myimage.setText(String.valueOf(rno));
        d.a3.setVisible(true);
        d.screen.setText(String.valueOf("Dice number : "+rno));
    }
    /**
     * Handles various button clicks and game actions based on the event source.
     * It includes actions for resetting, rolling the dice, changing levels, and more.
     * @param e The ActionEvent object representing the button click event.
     */
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==d.b3)
        { for (int i = 0; i < d.numPlayers; i++) {
            d.m[i + 1].setBounds(140 - 70 * i, 650, 20, 52);
            d.playerPositions[i] = 0;
        }
            d.myimage.setText(" ");
            w = 0;

        }

        else if(e.getSource()==d.b1) {
            // Calls the randomNumber() method to
            // generate a random number and update the game interface.
            randomNumber();
        }
        else if(e.getSource()==d.b4 )
        {
            //Removes existing blocks, sets the game to Easy Level, and updates the button text.
            // Also triggers actions in the Level class.
            Main.removeExistingBlocks();
            Main.EasyLevel();
            d.b4.setText("Easy Level");
            b4Clicked = true;
            //Level.actionPerformeded();

        }
        else if(e.getSource()==d.b2 && executeB2Conditions ) {
            // Handles player movements based on the dice roll and checks for collisions and obstacles.
            // Adjusts player positions and updates the game interface accordingly
            if (w % 2 == 0) //w=2,pc1=3,rno=2
            {
                d.screen.setText(d.tf2.getText() + " chance");
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
                        d.screen.setText(d.tf1.getText() + "collided!");
                        pc2 = 0; // Player 2 returns to the starting position
                        d.m[2].setBounds(70, 650, 20, 52); // Reset player 2's position
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
                            d.screen.setText(d.tf1.getText() + " fire skips!");
                        } else {
                            // Update player 1's position and display it on the game board
                            w++;
                            pc1 = pc1 + rno;
                            System.out.println("Player1 position: " + pc1);
                            r = d.l[pc1].getBounds();
                            y = r.getX();
                            z = r.getY();
                            x1 = (int) Math.round(y);
                            y1 = (int) Math.round(z);
                            d.m[1].setBounds((x1 + 10), (y1 + 20), 20, 52);

                        }
                    } else if (b4Clicked) {
                        // Handle fire skips in the advanced level
                        if (Listener.pc1 + Listener.rno == 10 || Listener.pc1 + Listener.rno == 17 || Listener.pc1 + Listener.rno == 36 || Listener.pc1 + Listener.rno == 45 || Listener.pc1 + Listener.rno == 69 || Listener.pc1 + Listener.rno == 79 && !player1PassedBlock13) {
                            player1PassedBlock13 = true;
                            Listener.d.screen.setText(Listener.d.tf1.getText() + " fire skips!");
                        } else {


                            Listener.w++;
                            Listener.pc1 = Listener.pc1 + Listener.rno;
                            System.out.println("Player1 position: " + Listener.pc1);
                            r = Listener.d.l[Listener.pc1].getBounds();
                            y = r.getX();
                            z = r.getY();
                            Listener.x1 = (int) Math.round(y);
                            Listener.y1 = (int) Math.round(z);
                            Listener.d.m[1].setBounds((Listener.x1 + 10), (Listener.y1 + 20), 20, 52);

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
                                r = d.l[b[i]].getBounds();
                                y = r.getX();
                                z = r.getY();
                                x1 = (int) Math.round(y);
                                y1 = (int) Math.round(z);
                                d.m[1].setBounds((x1 + 10), (y1 + 17), 20, 52);
                                pc1 = b[i];
                                d.screen.setText(d.tf1.getText() + " blackhole-fall!");

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
                            if (Listener.pc1 == a4[i]) {
                                r = Listener.d.l[b4[i]].getBounds();
                                y = r.getX();
                                z = r.getY();
                                Listener.x1 = (int) Math.round(y);
                                Listener.y1 = (int) Math.round(z);
                                Listener.d.m[1].setBounds((Listener.x1 + 10), (Listener.y1 + 17), 20, 52);
                                Listener.pc1 = b4[i];
                                Listener.d.screen.setText(Listener.d.tf1.getText() + " blackhole-fall!");

                            }
                        }
                    }
                }
            }
            //player 2 conditions
            else {
                d.screen.setText(d.tf1.getText() + " chance");

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
                        d.screen.setText(d.tf2.getText() + " collided!");
                        pc1 = 0; // Player 1 returns to the starting position
                        d.m[1].setBounds(140, 650, 20, 52); // Reset player 1's position
                    }

                    if (!b4Clicked) {
                       // Handle skipping turns for player 2 in the standard level
                        boolean skipTurn = (pc2 + rno == 3 || pc2 + rno == 7 || pc2 + rno == 17 || pc2 + rno == 31 || pc2 + rno == 35 || pc2 + rno == 40 || pc2 + rno == 54 || pc2 + rno == 55 || pc2 + rno == 76 || pc2 + rno == 82 || pc2 + rno == 93 || pc2 + rno == 99 && !player2PassedBlock13);
                        if (skipTurn) {
                            player2PassedBlock13 = true;
                            d.screen.setText(d.tf2.getText() + " fire skips!");
                        } else {
                            // Handle skipping turns for player 2 in the advanced level
                            w++;
                            pc2 = pc2 + rno;
                            System.out.println("Player2 position: " + pc2);
                            r = d.l[pc2].getBounds();
                            y = r.getX();
                            z = r.getY();
                            x1 = (int) Math.round(y);
                            y1 = (int) Math.round(z);
                            d.m[2].setBounds((x1 + 10), (y1 + 20), 20, 52);
                        }
                    } else {
                        boolean skipTurn = (Listener.pc2 + Listener.rno == 10 || Listener.pc2 + Listener.rno == 17 || Listener.pc2 + Listener.rno == 36 || Listener.pc2 + Listener.rno == 45 || Listener.pc2 + Listener.rno == 69 || Listener.pc2 + Listener.rno == 79 && !player2PassedBlock13);
                        if (skipTurn) {
                            player2PassedBlock13 = true;
                            Listener.d.screen.setText(Listener.d.tf2.getText() + " fire skips!");
                        } else {

                            Listener.w++;
                            Listener.pc2 = Listener.pc2 + Listener.rno;
                            System.out.println("Player2 position: " + Listener.pc2);
                            r = Listener.d.l[Listener.pc2].getBounds();
                            y = r.getX();
                            z = r.getY();
                            Listener.x1 = (int) Math.round(y);
                            Listener.y1 = (int) Math.round(z);
                            Listener.d.m[2].setBounds((Listener.x1 + 10), (Listener.y1 + 20), 20, 52);
                        }
                    }
                    if (!b4Clicked) {
                        //code for black hole
                        int ax[] = new int[]{10, 20, 27, 60, 78, 81, 89, 98};
                        int b[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

                        for (int i = 0; i < 8; i++) {
                            if (pc2 == ax[i]) {
                                r = d.l[b[i]].getBounds();
                                y = r.getX();
                                z = r.getY();
                                x1 = (int) Math.round(y);
                                y1 = (int) Math.round(z);
                                d.m[2].setBounds((x1 + 10), (y1 + 17), 20, 52);
                                pc2 = b[i];
                                d.screen.setText(d.tf2.getText() + " blackhole fall!");


                            }
                        }
                    } else {
                        int ax[] = new int[]{42, 62, 56, 85, 91};
                        int b[] = new int[]{1, 1, 1, 1, 1};

                        for (int i = 0; i < 5; i++) {
                            if (Listener.pc2 == ax[i]) {
                                r = Listener.d.l[b[i]].getBounds();
                                y = r.getX();
                                z = r.getY();
                                Listener.x1 = (int) Math.round(y);
                                Listener.y1 = (int) Math.round(z);
                                Listener.d.m[2].setBounds((Listener.x1 + 10), (Listener.y1 + 17), 20, 52);
                                Listener.pc2 = b[i];
                                Listener.d.screen.setText(Listener.d.tf2.getText() + " blackhole fall!");
                            }
                        }
                    }

                }
            }


            //winner checking
            // Display winner message and write score to file

            if (pc1 == 100) {
                d.screen.setText(d.tf1.getText()+" wins!");
                JOptionPane.showMessageDialog(null,
                        "<html><body><div style='text-align: center; color: blue;'>" +
                                "<h2>" + d.tf1.getText() + " is the Winner!!!</h2>" +
                                "</div></body></html>");
                Main.writeScoreToFile(String.valueOf(d.tf1.getText()),100);
                Main.displayTopScores();
                Timer timer = new Timer(5000, d -> System.exit(10)); // 5000 milliseconds (5 seconds)
                timer.setRepeats(false); // Set to non-repeating
                timer.start();
            } else if (pc2 == 100) {
                d.screen.setText(d.tf2.getText()+" wins!");
                JOptionPane.showMessageDialog(null,
                        "<html><body><div style='text-align: center; color: blue;'>" +
                                "<h2>" + d.tf2.getText() + " is the Winner!!!</h2>" +
                                "</div></body></html>");
                Main.writeScoreToFile(String.valueOf(d.tf2.getText()),100);
                Main.displayTopScores();
                Timer timer = new Timer(5000, d -> System.exit(10)); // 5000 milliseconds (5 seconds)
                timer.setRepeats(false); // Set to non-repeating
                timer.start();
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


