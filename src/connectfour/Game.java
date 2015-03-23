/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import static connectfour.ConnectFour.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamil I
 */
public class Game extends javax.swing.JFrame {

    boolean turno = true;
    int height[] = {0,0,0,0,0,0,0};
    public static int[][] board = new int[6][7];
    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
    }
    
    //TODO: Funcion que gane el segundo jugador.
   
    private void history(boolean x){
        rearrange();
        if(x){
            Ranking.checkRanking();
            history[0][current] = "- " + player1 + " le haga ganado a " + player2 + ".";
            JOptionPane.showMessageDialog(null,"El jugador "+ConnectFour.player1+" ha ganado!!!","Woot!",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Ranking.checkRanking();
            history[0][current] = "- " + player2 + " le haga ganado a " + player1 + ".";
            JOptionPane.showMessageDialog(null,"El jugador "+ConnectFour.player2+" ha ganado!!!","Woot!",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void rearrange(){
        int x = ConnectFour.current;
        for(int y = 9; y >= 0; y--){
            if(!ConnectFour.history[y][x].isEmpty())
            {
                if(y == 9){
                    ConnectFour.history[y][x] = "";
                }
                else{
                    ConnectFour.history[y+1][x] = ConnectFour.history[y][x];
                    ConnectFour.history[y][x] = "";
                }
            }
        }
    }
    
    private void check(){
        if(turno){
            Arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connectfour/LeftArrow_1.png")));
        }
        else{
            Arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connectfour/RightArrow_1.png")));
        }
    }

    private void checkwin(){
            if((board[5][0] == 1 || board[5][0] == 2) && (board[5][1] == 1 || board[5][1] == 2) && (board[5][2] == 1 || board[5][2] == 2)
            && (board[5][3] == 1 || board[5][3] == 2) && (board[5][4] == 1 || board[5][4] == 2) && (board[5][5] == 1 || board[5][5] == 2)
            && (board[5][6] == 1 || board[5][6] == 2)){
                for(int a = 0; a < 10; a++){
                    if(user[a][0].equalsIgnoreCase(player1) || user[a][0].equalsIgnoreCase(player2)){
                        score[a][0] += 1;
                    }
                }
                rearrange();
                Ranking.checkRanking();
                history[0][current] = "- " + player1 + " a empatado con " + player2 + ".";
                JOptionPane.showMessageDialog(null,"EMPATE!!!","Woot!",JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }

       for(int x = 0; x < 3; x++){
           for(int y = 0; y < 7; y++){
            if(board[x][y] == 1 && board[x+1][y] == 1 && board[x+2][y] == 1 && board[x+3][y] == 1){
                for(int a = 0; a < 10; a++){
                    if(user[a][0].equalsIgnoreCase(player1)){
                        score[a][0] += 3;
                        history(true);
                        this.dispose();
                    }
                }
            }
            else if(board[x][y] == 2 && board[x+1][y] == 2 && board[x+2][y] == 2 && board[x+3][y] == 2){   
                for(int z = 0; z < 10; z++){
                    if(user[z][0].equalsIgnoreCase(player2)){
                        score[z][0] += 3;
                        history(false);
                        this.dispose();
                    }
                }   
            }               
        }
        }
       
       for(int x = 0; x < 6; x++){
           for(int y = 0; y < 4; y++){
            if(board[x][y] == 1 && board[x][y+1] == 1 && board[x][y+2] == 1 && board[x][y+3] == 1){
                for(int z = 0; z < 10; z++){
                    if(user[z][0].equalsIgnoreCase(player1)){
                        score[z][0] += 3;
                        history(true);
                        this.dispose();
                    }
                }
                }
            else if(board[x][y] == 2 && board[x][y+1] == 2 && board[x][y+2] == 2 && board[x][y+3] == 2){
                for(int z = 0; z < 10; z++){
                    if(user[z][0].equalsIgnoreCase(player2)){
                        score[z][0] += 3;
                        history(false);
                        this.dispose();
                    }
                }    
            }
            }
       }
       
        for(int x = 0; x < 3; x++){
           for(int y = 3; y < 7; y++){
                if(board[x][y] == 1 && board[x+1][y-1] == 1 && board[x+2][y-2] == 1 && board[x+3][y-3] == 1){
                    for(int z = 0; z < 10; z++){
                    if(user[z][0].equalsIgnoreCase(player1)){
                        score[z][0] += 3;
                        history(true);
                        this.dispose();
                    }
                    }
                    
                }
                else if(board[x][y] == 2 && board[x+1][y-1] == 2 && board[x+2][y-2] == 2 && board[x+3][y-3] == 2){
                    for(int z = 0; z < 10; z++){
                    if(user[z][0].equalsIgnoreCase(player2)){
                        score[z][0] += 3;
                        history(false);
                        this.dispose();
                    }
                    }
                    
                }
            }                  
            }
        
        for(int x = 3; x < 6; x++){
           for(int y = 3; y < 7; y++){
                if(board[x][y] == 1 && board[x-1][y-1] == 1 && board[x-2][y-2] == 1 && board[x-3][y-3] == 1){
                    for(int z = 0; z < 10; z++){
                    if(user[z][0].equalsIgnoreCase(player1)){
                        score[z][0] += 3;
                        history(true);
                        this.dispose();
                    }
                    }
                    
                }
                else if(board[x][y] == 2&& board[x-1][y-1] == 2 && board[x-2][y-2] == 2 && board[x-3][y-3] == 2){
                    for(int z = 0; z < 10; z++){
                    if(user[z][0].equalsIgnoreCase(player2)){
                        score[z][0] += 3;
                        history(false);
                        this.dispose();
                    }
                    }
                    
                }
            }                  
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        button16 = new javax.swing.JLabel();
        button26 = new javax.swing.JLabel();
        button15 = new javax.swing.JLabel();
        button66 = new javax.swing.JLabel();
        button56 = new javax.swing.JLabel();
        button36 = new javax.swing.JLabel();
        button46 = new javax.swing.JLabel();
        button76 = new javax.swing.JLabel();
        button25 = new javax.swing.JLabel();
        button35 = new javax.swing.JLabel();
        button45 = new javax.swing.JLabel();
        button55 = new javax.swing.JLabel();
        button65 = new javax.swing.JLabel();
        button75 = new javax.swing.JLabel();
        button14 = new javax.swing.JLabel();
        button24 = new javax.swing.JLabel();
        button34 = new javax.swing.JLabel();
        button44 = new javax.swing.JLabel();
        button54 = new javax.swing.JLabel();
        button64 = new javax.swing.JLabel();
        button74 = new javax.swing.JLabel();
        button13 = new javax.swing.JLabel();
        button23 = new javax.swing.JLabel();
        button12 = new javax.swing.JLabel();
        button63 = new javax.swing.JLabel();
        button53 = new javax.swing.JLabel();
        button33 = new javax.swing.JLabel();
        button43 = new javax.swing.JLabel();
        button73 = new javax.swing.JLabel();
        button22 = new javax.swing.JLabel();
        button32 = new javax.swing.JLabel();
        button42 = new javax.swing.JLabel();
        button52 = new javax.swing.JLabel();
        button62 = new javax.swing.JLabel();
        button72 = new javax.swing.JLabel();
        button11 = new javax.swing.JLabel();
        button21 = new javax.swing.JLabel();
        button31 = new javax.swing.JLabel();
        button41 = new javax.swing.JLabel();
        button51 = new javax.swing.JLabel();
        button61 = new javax.swing.JLabel();
        button71 = new javax.swing.JLabel();
        Arrow = new javax.swing.JLabel();
        MainMenuButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 700));
        setMinimumSize(new java.awt.Dimension(640, 700));
        setPreferredSize(new java.awt.Dimension(640, 700));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connectfour/Connect4Board.png"))); // NOI18N
        jLabel1.setFocusable(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 140, 640, 480);

        button16.setBackground(new java.awt.Color(204, 0, 0));
        button16.setForeground(new java.awt.Color(204, 0, 0));
        button16.setFocusable(false);
        button16.setMaximumSize(new java.awt.Dimension(80, 80));
        button16.setMinimumSize(new java.awt.Dimension(80, 80));
        button16.setPreferredSize(new java.awt.Dimension(80, 80));
        button16.setRequestFocusEnabled(false);
        getContentPane().add(button16);
        button16.setBounds(10, 540, 80, 80);

        button26.setFocusable(false);
        button26.setInheritsPopupMenu(false);
        button26.setMaximumSize(new java.awt.Dimension(80, 80));
        button26.setMinimumSize(new java.awt.Dimension(80, 80));
        button26.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button26);
        button26.setBounds(100, 540, 80, 80);

        button15.setFocusable(false);
        button15.setInheritsPopupMenu(false);
        button15.setMaximumSize(new java.awt.Dimension(80, 80));
        button15.setMinimumSize(new java.awt.Dimension(80, 80));
        button15.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button15);
        button15.setBounds(10, 460, 80, 80);

        button66.setToolTipText("");
        button66.setFocusable(false);
        button66.setMaximumSize(new java.awt.Dimension(80, 80));
        button66.setMinimumSize(new java.awt.Dimension(80, 80));
        button66.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button66);
        button66.setBounds(460, 540, 80, 80);

        button56.setToolTipText("");
        button56.setFocusable(false);
        button56.setMaximumSize(new java.awt.Dimension(80, 80));
        button56.setMinimumSize(new java.awt.Dimension(80, 80));
        button56.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button56);
        button56.setBounds(370, 540, 80, 80);

        button36.setToolTipText("");
        button36.setFocusable(false);
        button36.setMaximumSize(new java.awt.Dimension(80, 80));
        button36.setMinimumSize(new java.awt.Dimension(80, 80));
        button36.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button36);
        button36.setBounds(190, 540, 80, 80);

        button46.setToolTipText("");
        button46.setFocusable(false);
        button46.setMaximumSize(new java.awt.Dimension(80, 80));
        button46.setMinimumSize(new java.awt.Dimension(80, 80));
        button46.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button46);
        button46.setBounds(280, 540, 80, 80);

        button76.setToolTipText("");
        button76.setFocusable(false);
        button76.setMaximumSize(new java.awt.Dimension(80, 80));
        button76.setMinimumSize(new java.awt.Dimension(80, 80));
        button76.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button76);
        button76.setBounds(550, 540, 80, 80);

        button25.setToolTipText("");
        button25.setFocusable(false);
        button25.setMaximumSize(new java.awt.Dimension(80, 80));
        button25.setMinimumSize(new java.awt.Dimension(80, 80));
        button25.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button25);
        button25.setBounds(100, 460, 80, 80);

        button35.setToolTipText("");
        button35.setFocusable(false);
        button35.setMaximumSize(new java.awt.Dimension(80, 80));
        button35.setMinimumSize(new java.awt.Dimension(80, 80));
        button35.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button35);
        button35.setBounds(190, 460, 80, 80);

        button45.setToolTipText("");
        button45.setFocusable(false);
        button45.setMaximumSize(new java.awt.Dimension(80, 80));
        button45.setMinimumSize(new java.awt.Dimension(80, 80));
        button45.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button45);
        button45.setBounds(280, 460, 80, 80);

        button55.setToolTipText("");
        button55.setFocusable(false);
        button55.setMaximumSize(new java.awt.Dimension(80, 80));
        button55.setMinimumSize(new java.awt.Dimension(80, 80));
        button55.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button55);
        button55.setBounds(370, 460, 80, 80);

        button65.setToolTipText("");
        button65.setFocusable(false);
        button65.setMaximumSize(new java.awt.Dimension(80, 80));
        button65.setMinimumSize(new java.awt.Dimension(80, 80));
        button65.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button65);
        button65.setBounds(460, 460, 80, 80);

        button75.setToolTipText("");
        button75.setFocusable(false);
        button75.setMaximumSize(new java.awt.Dimension(80, 80));
        button75.setMinimumSize(new java.awt.Dimension(80, 80));
        button75.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button75);
        button75.setBounds(550, 460, 80, 80);

        button14.setToolTipText("");
        button14.setFocusable(false);
        button14.setMaximumSize(new java.awt.Dimension(80, 80));
        button14.setMinimumSize(new java.awt.Dimension(80, 80));
        button14.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button14);
        button14.setBounds(10, 380, 80, 80);

        button24.setToolTipText("");
        button24.setFocusable(false);
        button24.setMaximumSize(new java.awt.Dimension(80, 80));
        button24.setMinimumSize(new java.awt.Dimension(80, 80));
        button24.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button24);
        button24.setBounds(100, 380, 80, 80);

        button34.setToolTipText("");
        button34.setFocusable(false);
        button34.setMaximumSize(new java.awt.Dimension(80, 80));
        button34.setMinimumSize(new java.awt.Dimension(80, 80));
        button34.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button34);
        button34.setBounds(190, 380, 80, 80);

        button44.setToolTipText("");
        button44.setFocusable(false);
        button44.setMaximumSize(new java.awt.Dimension(80, 80));
        button44.setMinimumSize(new java.awt.Dimension(80, 80));
        button44.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button44);
        button44.setBounds(280, 380, 80, 80);

        button54.setToolTipText("");
        button54.setFocusable(false);
        button54.setMaximumSize(new java.awt.Dimension(80, 80));
        button54.setMinimumSize(new java.awt.Dimension(80, 80));
        button54.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button54);
        button54.setBounds(370, 380, 80, 80);

        button64.setToolTipText("");
        button64.setFocusable(false);
        button64.setMaximumSize(new java.awt.Dimension(80, 80));
        button64.setMinimumSize(new java.awt.Dimension(80, 80));
        button64.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button64);
        button64.setBounds(460, 380, 80, 80);

        button74.setToolTipText("");
        button74.setFocusable(false);
        button74.setMaximumSize(new java.awt.Dimension(80, 80));
        button74.setMinimumSize(new java.awt.Dimension(80, 80));
        button74.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button74);
        button74.setBounds(550, 380, 80, 80);

        button13.setBackground(new java.awt.Color(204, 0, 0));
        button13.setForeground(new java.awt.Color(204, 0, 0));
        button13.setFocusable(false);
        button13.setMaximumSize(new java.awt.Dimension(80, 80));
        button13.setMinimumSize(new java.awt.Dimension(80, 80));
        button13.setPreferredSize(new java.awt.Dimension(80, 80));
        button13.setRequestFocusEnabled(false);
        getContentPane().add(button13);
        button13.setBounds(10, 300, 80, 80);

        button23.setFocusable(false);
        button23.setInheritsPopupMenu(false);
        button23.setMaximumSize(new java.awt.Dimension(80, 80));
        button23.setMinimumSize(new java.awt.Dimension(80, 80));
        button23.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button23);
        button23.setBounds(100, 300, 80, 80);

        button12.setFocusable(false);
        button12.setInheritsPopupMenu(false);
        button12.setMaximumSize(new java.awt.Dimension(80, 80));
        button12.setMinimumSize(new java.awt.Dimension(80, 80));
        button12.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button12);
        button12.setBounds(10, 220, 80, 80);

        button63.setToolTipText("");
        button63.setFocusable(false);
        button63.setMaximumSize(new java.awt.Dimension(80, 80));
        button63.setMinimumSize(new java.awt.Dimension(80, 80));
        button63.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button63);
        button63.setBounds(460, 300, 80, 80);

        button53.setToolTipText("");
        button53.setFocusable(false);
        button53.setMaximumSize(new java.awt.Dimension(80, 80));
        button53.setMinimumSize(new java.awt.Dimension(80, 80));
        button53.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button53);
        button53.setBounds(370, 300, 80, 80);

        button33.setToolTipText("");
        button33.setFocusable(false);
        button33.setMaximumSize(new java.awt.Dimension(80, 80));
        button33.setMinimumSize(new java.awt.Dimension(80, 80));
        button33.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button33);
        button33.setBounds(190, 300, 80, 80);

        button43.setToolTipText("");
        button43.setFocusable(false);
        button43.setMaximumSize(new java.awt.Dimension(80, 80));
        button43.setMinimumSize(new java.awt.Dimension(80, 80));
        button43.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button43);
        button43.setBounds(280, 300, 80, 80);

        button73.setToolTipText("");
        button73.setFocusable(false);
        button73.setMaximumSize(new java.awt.Dimension(80, 80));
        button73.setMinimumSize(new java.awt.Dimension(80, 80));
        button73.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button73);
        button73.setBounds(550, 300, 80, 80);

        button22.setToolTipText("");
        button22.setFocusable(false);
        button22.setMaximumSize(new java.awt.Dimension(80, 80));
        button22.setMinimumSize(new java.awt.Dimension(80, 80));
        button22.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button22);
        button22.setBounds(100, 220, 80, 80);

        button32.setToolTipText("");
        button32.setFocusable(false);
        button32.setMaximumSize(new java.awt.Dimension(80, 80));
        button32.setMinimumSize(new java.awt.Dimension(80, 80));
        button32.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button32);
        button32.setBounds(190, 220, 80, 80);

        button42.setToolTipText("");
        button42.setFocusable(false);
        button42.setMaximumSize(new java.awt.Dimension(80, 80));
        button42.setMinimumSize(new java.awt.Dimension(80, 80));
        button42.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button42);
        button42.setBounds(280, 220, 80, 80);

        button52.setToolTipText("");
        button52.setFocusable(false);
        button52.setMaximumSize(new java.awt.Dimension(80, 80));
        button52.setMinimumSize(new java.awt.Dimension(80, 80));
        button52.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button52);
        button52.setBounds(370, 220, 80, 80);

        button62.setToolTipText("");
        button62.setFocusable(false);
        button62.setMaximumSize(new java.awt.Dimension(80, 80));
        button62.setMinimumSize(new java.awt.Dimension(80, 80));
        button62.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button62);
        button62.setBounds(460, 220, 80, 80);

        button72.setToolTipText("");
        button72.setFocusable(false);
        button72.setMaximumSize(new java.awt.Dimension(80, 80));
        button72.setMinimumSize(new java.awt.Dimension(80, 80));
        button72.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button72);
        button72.setBounds(550, 220, 80, 80);

        button11.setToolTipText("");
        button11.setFocusable(false);
        button11.setMaximumSize(new java.awt.Dimension(80, 80));
        button11.setMinimumSize(new java.awt.Dimension(80, 80));
        button11.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button11);
        button11.setBounds(10, 140, 80, 80);

        button21.setToolTipText("");
        button21.setFocusable(false);
        button21.setMaximumSize(new java.awt.Dimension(80, 80));
        button21.setMinimumSize(new java.awt.Dimension(80, 80));
        button21.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button21);
        button21.setBounds(100, 140, 80, 80);

        button31.setToolTipText("");
        button31.setFocusable(false);
        button31.setMaximumSize(new java.awt.Dimension(80, 80));
        button31.setMinimumSize(new java.awt.Dimension(80, 80));
        button31.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button31);
        button31.setBounds(190, 140, 80, 80);

        button41.setToolTipText("");
        button41.setFocusable(false);
        button41.setMaximumSize(new java.awt.Dimension(80, 80));
        button41.setMinimumSize(new java.awt.Dimension(80, 80));
        button41.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button41);
        button41.setBounds(280, 140, 80, 80);

        button51.setToolTipText("");
        button51.setFocusable(false);
        button51.setMaximumSize(new java.awt.Dimension(80, 80));
        button51.setMinimumSize(new java.awt.Dimension(80, 80));
        button51.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button51);
        button51.setBounds(370, 140, 80, 80);

        button61.setToolTipText("");
        button61.setFocusable(false);
        button61.setMaximumSize(new java.awt.Dimension(80, 80));
        button61.setMinimumSize(new java.awt.Dimension(80, 80));
        button61.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button61);
        button61.setBounds(460, 140, 80, 80);

        button71.setToolTipText("");
        button71.setFocusable(false);
        button71.setMaximumSize(new java.awt.Dimension(80, 80));
        button71.setMinimumSize(new java.awt.Dimension(80, 80));
        button71.setPreferredSize(new java.awt.Dimension(80, 80));
        getContentPane().add(button71);
        button71.setBounds(550, 140, 80, 80);

        Arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connectfour/LeftArrow_1.png"))); // NOI18N
        Arrow.setFocusable(false);
        getContentPane().add(Arrow);
        Arrow.setBounds(180, 20, 280, 100);

        MainMenuButton.setText("Main Menu");
        MainMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainMenuButtonMouseClicked(evt);
            }
        });
        getContentPane().add(MainMenuButton);
        MainMenuButton.setBounds(250, 640, 140, 23);

        jLabel2.setText(ConnectFour.player1);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 30, 150, 60);

        jLabel3.setText(ConnectFour.player2);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(450, 30, 160, 80);

        jButton1.setText("Player 1 Retire");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 630, 120, 40);

        jButton2.setText("Player 2 Retire");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(480, 630, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       if(evt.getX() < 95){
            switch(height[0]){
                case 0: yay(button16, 0);  break;
                case 1: yay(button15, 0);  break;
                case 2: yay(button14, 0);  break;
                case 3: yay(button13, 0);  break;
                case 4: yay(button12, 0);  break;
                case 5: yay(button11, 0);  break;
            }   
        }
        else if(evt.getX() < 185){
            switch(height[1]){
               case 0: yay(button26, 1); break;
               case 1: yay(button25, 1); break;
               case 2: yay(button24, 1); break;
               case 3: yay(button23, 1); break;
               case 4: yay(button22, 1); break;
               case 5: yay(button21, 1); break;
            }   
        }
        
        else if(evt.getX() < 275){
            switch(height[2]){
                case 0: yay(button36, 2); break;
                case 1: yay(button35, 2); break;
                case 2: yay(button34, 2); break;
                case 3: yay(button33, 2); break;
                case 4: yay(button32, 2); break;
                case 5: yay(button31, 2); break;
            }   
        }
         else if(evt.getX() < 365){
            switch(height[3]){
                case 0: yay(button46, 3); break;
                case 1: yay(button45, 3); break;
                case 2: yay(button44, 3); break;
                case 3: yay(button43, 3); break;
                case 4: yay(button42, 3); break;
                case 5: yay(button41, 3); break;
            }   
        }
         else if(evt.getX() < 455){
            switch(height[4]){
                case 0: yay(button56, 4); break;
                case 1: yay(button55, 4); break;
                case 2: yay(button54, 4); break;
                case 3: yay(button53, 4); break;
                case 4: yay(button52, 4); break;
                case 5: yay(button51, 4); break;
            }   
        }
         else if(evt.getX() < 546){
            switch(height[5]){
                case 0: yay(button66, 5); break;
                case 1: yay(button65, 5); break;
                case 2: yay(button64, 5); break;
                case 3: yay(button63, 5); break;
                case 4: yay(button62, 5); break;
                case 5: yay(button61, 5); break;
            }   
        }
         else if(evt.getX() < 640){
            switch(height[6]){
                case 0: yay(button76, 6); break;
                case 1: yay(button75, 6); break;
                case 2: yay(button74, 6); break;
                case 3: yay(button73, 6); break;
                case 4: yay(button72, 6); break;
                case 5: yay(button71, 6); break;
            }   
        }
     check();   
     checkwin();        
    }//GEN-LAST:event_formMouseClicked

    
    private void yay(JLabel z, int y){
        
        if(turno){
                z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connectfour/redsquare.png")));
                board[height[y]][y] = 1;
        }
        else{
                z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connectfour/yellowsquare.png")));     
                board[height[y]][y] = 2;
        }
        
        height[y]++;
        turno = !turno;
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        for(int x = 0; x < 6; x++){
            for(int y = 0; y < 7; y++){
                board[x][y] = 0;
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void MainMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_MainMenuButtonMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
                for(int a = 0; a < 10; a++){
                    if(user[a][0].equalsIgnoreCase(player2)){
                        score[a][0] += 3;
                        history(false);
                        this.dispose();
                    }
                }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
                for(int a = 0; a < 10; a++){
                    if(user[a][0].equalsIgnoreCase(player1)){
                        score[a][0] += 3;
                        history(true);
                        this.dispose();
                    }
                }
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arrow;
    private javax.swing.JButton MainMenuButton;
    private javax.swing.JLabel button11;
    private javax.swing.JLabel button12;
    private javax.swing.JLabel button13;
    private javax.swing.JLabel button14;
    private javax.swing.JLabel button15;
    private javax.swing.JLabel button16;
    private javax.swing.JLabel button21;
    private javax.swing.JLabel button22;
    private javax.swing.JLabel button23;
    private javax.swing.JLabel button24;
    private javax.swing.JLabel button25;
    private javax.swing.JLabel button26;
    private javax.swing.JLabel button31;
    private javax.swing.JLabel button32;
    private javax.swing.JLabel button33;
    private javax.swing.JLabel button34;
    private javax.swing.JLabel button35;
    private javax.swing.JLabel button36;
    private javax.swing.JLabel button41;
    private javax.swing.JLabel button42;
    private javax.swing.JLabel button43;
    private javax.swing.JLabel button44;
    private javax.swing.JLabel button45;
    private javax.swing.JLabel button46;
    private javax.swing.JLabel button51;
    private javax.swing.JLabel button52;
    private javax.swing.JLabel button53;
    private javax.swing.JLabel button54;
    private javax.swing.JLabel button55;
    private javax.swing.JLabel button56;
    private javax.swing.JLabel button61;
    private javax.swing.JLabel button62;
    private javax.swing.JLabel button63;
    private javax.swing.JLabel button64;
    private javax.swing.JLabel button65;
    private javax.swing.JLabel button66;
    private javax.swing.JLabel button71;
    private javax.swing.JLabel button72;
    private javax.swing.JLabel button73;
    private javax.swing.JLabel button74;
    private javax.swing.JLabel button75;
    private javax.swing.JLabel button76;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
