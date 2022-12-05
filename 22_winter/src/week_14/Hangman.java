package week_14;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman extends JFrame implements ActionListener {
 String[] words = new String[201];
 int[] checked = new int[201];
 int word_length;
 int guessNum;
 int level;
 char[] word1 = new char[12];
 String[] slevel = new String[]{"Easy", "Medium", "Hard"};
 String[] word2 = new String[12];
 String check_word;
 double wins;
 double looses;
 double winRate;
 JButton a = new JButton("A");
 JButton b = new JButton("B");
 JButton c = new JButton("C");
 JButton d = new JButton("D");
 JButton e = new JButton("E");
 JButton f = new JButton("F");
 JButton g = new JButton("G");
 JButton h = new JButton("H");
 JButton i = new JButton("I");
 JButton j = new JButton("J");
 JButton k = new JButton("K");
 JButton l = new JButton("L");
 JButton m = new JButton("M");
 JButton n = new JButton("N");
 JButton o = new JButton("O");
 JButton p = new JButton("P");
 JButton q = new JButton("Q");
 JButton r = new JButton("R");
 JButton s = new JButton("S");
 JButton t = new JButton("T");
 JButton u = new JButton("U");
 JButton v = new JButton("V");
 JButton w = new JButton("W");
 JButton x = new JButton("X");
 JButton y = new JButton("Y");
 JButton z = new JButton("Z");
 JButton begin = new JButton("BEGIN");
 JButton hint = new JButton("HINT");
 JButton easy = new JButton("EASY");
 JButton medium = new JButton("MEDIUM");
 JButton hard = new JButton("HARD");
 JLabel text = new JLabel("Skill level: ", 2);
 JPanel displayTOP = new JPanel();
 JPanel display1 = new JPanel();
 JPanel display2 = new JPanel();
 Font normalFont = new Font("Arial", 1, 16);
 Font warningFont = new Font("Arial", 1, 20);

 public Hangman() {
     this.setTitle("행맨 게임");
     this.setDefaultCloseOperation(3);
     this.setSize(850, 700);
     this.setVisible(true);
 }

 public void init() {
     this.a.addActionListener(this);
     this.b.addActionListener(this);
     this.c.addActionListener(this);
     this.d.addActionListener(this);
     this.e.addActionListener(this);
     this.f.addActionListener(this);
     this.g.addActionListener(this);
     this.h.addActionListener(this);
     this.i.addActionListener(this);
     this.j.addActionListener(this);
     this.k.addActionListener(this);
     this.l.addActionListener(this);
     this.m.addActionListener(this);
     this.n.addActionListener(this);
     this.o.addActionListener(this);
     this.p.addActionListener(this);
     this.q.addActionListener(this);
     this.r.addActionListener(this);
     this.s.addActionListener(this);
     this.t.addActionListener(this);
     this.u.addActionListener(this);
     this.v.addActionListener(this);
     this.w.addActionListener(this);
     this.x.addActionListener(this);
     this.y.addActionListener(this);
     this.z.addActionListener(this);
     this.begin.addActionListener(this);
     this.hint.addActionListener(this);
     this.easy.addActionListener(this);
     this.medium.addActionListener(this);
     this.hard.addActionListener(this);
     GridLayout var1 = new GridLayout(3, 0);
     FlowLayout var2 = new FlowLayout(1, 10, 50);
     FlowLayout var3 = new FlowLayout(1, 10, 70);
     GridLayout var4 = new GridLayout(3, 9, 10, 10);
     Container var5 = this.getContentPane();
     var5.setLayout(var1);
     var5.setBackground(Color.white);
     this.displayTOP.add(this.begin);
     this.displayTOP.add(this.hint);
     this.displayTOP.setLayout(var2);
     this.displayTOP.setBackground(Color.white);
     var5.add(this.displayTOP);
     this.display1.setLayout(var4);
     this.display1.setBackground(Color.white);
     this.a.setBackground(Color.orange);
     this.b.setBackground(Color.orange);
     this.c.setBackground(Color.orange);
     this.d.setBackground(Color.orange);
     this.e.setBackground(Color.orange);
     this.f.setBackground(Color.orange);
     this.g.setBackground(Color.orange);
     this.h.setBackground(Color.orange);
     this.i.setBackground(Color.orange);
     this.j.setBackground(Color.orange);
     this.k.setBackground(Color.orange);
     this.l.setBackground(Color.orange);
     this.m.setBackground(Color.orange);
     this.n.setBackground(Color.orange);
     this.o.setBackground(Color.orange);
     this.p.setBackground(Color.orange);
     this.q.setBackground(Color.orange);
     this.r.setBackground(Color.orange);
     this.s.setBackground(Color.orange);
     this.t.setBackground(Color.orange);
     this.u.setBackground(Color.orange);
     this.v.setBackground(Color.orange);
     this.w.setBackground(Color.orange);
     this.x.setBackground(Color.orange);
     this.y.setBackground(Color.orange);
     this.z.setBackground(Color.orange);
     this.display1.add(this.a);
     this.display1.add(this.b);
     this.display1.add(this.c);
     this.display1.add(this.d);
     this.display1.add(this.e);
     this.display1.add(this.f);
     this.display1.add(this.g);
     this.display1.add(this.h);
     this.display1.add(this.i);
     this.display1.add(this.j);
     this.display1.add(this.k);
     this.display1.add(this.l);
     this.display1.add(this.m);
     this.display1.add(this.n);
     this.display1.add(this.o);
     this.display1.add(this.p);
     this.display1.add(this.q);
     this.display1.add(this.r);
     this.display1.add(this.s);
     this.display1.add(this.t);
     this.display1.add(this.u);
     this.display1.add(this.v);
     this.display1.add(this.w);
     this.display1.add(this.x);
     this.display1.add(this.y);
     this.display1.add(this.z);
     var5.add(this.display1);
     this.display2.setLayout(var3);
     this.display2.setBackground(Color.white);
     this.display2.add(this.text);
     this.display2.add(this.easy);
     this.display2.add(this.medium);
     this.display2.add(this.hard);
     var5.add(this.display2);
     this.setContentPane(var5);
     this.a.setEnabled(false);
     this.b.setEnabled(false);
     this.c.setEnabled(false);
     this.d.setEnabled(false);
     this.e.setEnabled(false);
     this.f.setEnabled(false);
     this.g.setEnabled(false);
     this.h.setEnabled(false);
     this.i.setEnabled(false);
     this.j.setEnabled(false);
     this.k.setEnabled(false);
     this.l.setEnabled(false);
     this.m.setEnabled(false);
     this.n.setEnabled(false);
     this.o.setEnabled(false);
     this.p.setEnabled(false);
     this.q.setEnabled(false);
     this.r.setEnabled(false);
     this.s.setEnabled(false);
     this.t.setEnabled(false);
     this.u.setEnabled(false);
     this.v.setEnabled(false);
     this.w.setEnabled(false);
     this.x.setEnabled(false);
     this.y.setEnabled(false);
     this.z.setEnabled(false);
     this.easy.setEnabled(false);
     this.medium.setEnabled(true);
     this.hard.setEnabled(true);
     this.words[0] = "korea";
     this.words[1] = "hansung";
     this.words[2] = "computer";
     this.words[3] = "engineering";
     this.words[4] = "science";
     this.words[5] = "university";
     this.words[6] = "college";
     this.words[7] = "eclipse";
     this.words[8] = "major";
     this.words[9] = "release";
     this.words[10] = "library";
     this.words[11] = "float";
     this.words[12] = "double";
     this.words[13] = "dictionary";
     this.words[14] = "poland";
     this.words[15] = "evolution";
     this.words[16] = "revolution";
     this.words[17] = "reject";
     this.words[18] = "subject";
     this.words[19] = "vector";
     this.words[20] = "applet";
     this.words[21] = "repository";
     this.words[22] = "remote";
     this.words[23] = "branch";
     this.words[24] = "environment";
     this.words[25] = "short";
     this.words[26] = "electronic";
     this.words[27] = "reference";
     this.words[28] = "agreement";
     this.words[29] = "fashion";
     this.words[30] = "configure";
     this.words[31] = "programming";
     this.words[32] = "request";
     this.words[33] = "database";
     this.words[34] = "jealous";
     this.words[35] = "amazon";
     this.words[36] = "password";
     this.words[37] = "compliment";
     this.words[38] = "complication";
     this.words[39] = "description";
     this.words[40] = "default";
     this.words[41] = "account";
     this.words[42] = "innovation";
     this.words[43] = "collaborate";
     this.words[44] = "germany";
     this.words[45] = "syndrome";
     this.words[46] = "report";
     this.words[47] = "gender";
     this.words[48] = "coffee";
     this.words[49] = "design";
     this.words[50] = "translate";
     this.words[51] = "analyze";
     this.words[52] = "image";
     this.words[53] = "segment";
     this.words[54] = "private";
     this.words[55] = "public";
     this.words[56] = "protect";
     this.words[57] = "editor";
     this.words[58] = "identify";
     this.words[59] = "statement";
     this.words[60] = "access";
     this.words[61] = "download";
     this.words[62] = "upload";
     this.words[63] = "address";
     this.words[64] = "relieve";
     this.words[65] = "satisfied";
     this.words[66] = "health";
     this.words[67] = "static";
     this.words[68] = "decrease";
     this.words[69] = "increase";
     this.words[70] = "practice";
     this.words[71] = "yield";
     this.words[72] = "success";
     this.words[73] = "failure";
     this.words[74] = "proof";
     this.words[75] = "evidence";
     this.words[76] = "innocence";
     this.words[77] = "virtual";
     this.words[78] = "urgent";
     this.words[79] = "desperate";
     this.words[80] = "indifferent";
     this.words[81] = "apologize";
     this.words[82] = "grateful";
     this.words[83] = "critical";
     this.words[84] = "struct";
     this.words[85] = "insistence";
     this.words[86] = "encourage";
     this.words[87] = "persuade";
     this.words[88] = "discourage";
     this.words[89] = "enable";
     this.words[90] = "disable";
     this.words[91] = "force";
     this.words[92] = "compel";
     this.words[93] = "inhabit";
     this.words[94] = "permit";
     this.words[95] = "admit";
     this.words[96] = "forbid";
     this.words[97] = "infinite";
     this.words[98] = "destination";
     this.words[99] = "board";
     this.words[100] = "destiny";
     this.words[101] = "community";
     this.words[102] = "support";
     this.words[103] = "tutor";
     this.words[104] = "spark";
     this.words[105] = "company";
     this.words[106] = "trend";
     this.words[107] = "apparel";
     this.words[108] = "modify";
     this.words[109] = "appropriate";
     this.words[110] = "indicate";
     this.words[111] = "ensure";
     this.words[112] = "proper";
     this.words[113] = "suitable";
     this.words[114] = "accept";
     this.words[115] = "verify";
     this.words[116] = "device";
     this.words[117] = "deviate";
     this.words[118] = "certain";
     this.words[119] = "interact";
     this.words[120] = "restrict";
     this.words[121] = "confident";
     this.words[122] = "optimistic";
     this.words[123] = "social";
     this.words[124] = "forget";
     this.words[125] = "network";
     this.words[126] = "string";
     this.words[127] = "stream";
     this.words[128] = "stock";
     this.words[129] = "select";
     this.words[130] = "selfish";
     this.words[131] = "forward";
     this.words[132] = "frequency";
     this.words[133] = "fiction";
     this.words[134] = "novel";
     this.words[135] = "egoism";
     this.words[136] = "ambiguous";
     this.words[137] = "abstract";
     this.words[138] = "vague";
     this.words[139] = "insight";
     this.words[140] = "deposit";
     this.words[141] = "switch";
     this.words[142] = "estimate";
     this.words[143] = "quote";
     this.words[144] = "confirm";
     this.words[145] = "instinctive";
     this.words[146] = "cinically";
     this.words[147] = "lobbyist";
     this.words[148] = "replay";
     this.words[149] = "executive";
     this.words[150] = "occasion";
     this.words[151] = "desire";
     this.words[152] = "explosive";
     this.words[153] = "trigger";
     this.words[154] = "induce";
     this.words[155] = "reduce";
     this.words[156] = "feast";
     this.words[157] = "reception";
     this.words[158] = "diplomacy";
     this.words[159] = "motivator";
     this.words[160] = "problem";
     this.words[161] = "christmas";
     this.words[162] = "banquet";
     this.words[163] = "occasion";
     this.words[164] = "national";
     this.words[165] = "domestic";
     this.words[166] = "represent";
     this.words[167] = "thunder";
     this.words[168] = "attention";
     this.words[169] = "memory";
     this.words[170] = "speech";
     this.words[171] = "season";
     this.words[172] = "grade";
     this.words[173] = "professor";
     this.words[174] = "lecture";
     this.words[175] = "laboratory";
     this.words[176] = "experiment";
     this.words[177] = "hypothesis";
     this.words[178] = "observation";
     this.words[179] = "require";
     this.words[180] = "distant";
     this.words[181] = "accurate";
     this.words[182] = "precise";
     this.words[183] = "notation";
     this.words[184] = "competent";
     this.words[185] = "dedicate";
     this.words[186] = "devote";
     this.words[187] = "debate";
     this.words[188] = "discuss";
     this.words[189] = "foreign";
     this.words[190] = "forever";
     this.words[191] = "justice";
     this.words[192] = "topic";
     this.words[193] = "shield";
     this.words[194] = "swear";
     this.words[195] = "accuse";
     this.words[196] = "ability";
     this.words[197] = "original";
     this.words[198] = "believe";
     this.words[199] = "trust";
     this.words[200] = "violence";

     int var6;
     for(var6 = 0; var6 < this.checked.length; ++var6) {
         this.checked[var6] = 0;
     }

     for(var6 = 0; var6 < 12; ++var6) {
         this.word1[var6] = ' ';
         this.word2[var6] = " ";
     }

     this.wins = 0.0;
     this.looses = 0.0;
     this.winRate = 0.0;
 }

 public void paint(Graphics var1) {
     super.paint(var1);
     Graphics2D var2 = (Graphics2D)var1;
     var2.setFont(this.warningFont);
     var2.drawLine(70, 60, 130, 60);
     var2.drawLine(70, 60, 70, 80);
     var2.drawLine(130, 60, 130, 170);
     var2.drawLine(60, 170, 160, 170);
     if (this.level == 0) {
         switch (this.guessNum) {
             case 1:
                 var2.drawOval(60, 80, 20, 20);
                 break;
             case 2:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 110);
                 break;
             case 3:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 120);
                 break;
             case 4:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 break;
             case 5:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(70, 110, 90, 110);
                 break;
             case 6:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 break;
             case 7:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 85, 140);
                 break;
             case 8:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 85, 150);
                 break;
             case 9:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 55, 140);
                 var2.drawLine(70, 130, 85, 150);
                 break;
             case 10:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 55, 150);
                 var2.drawLine(70, 130, 85, 150);
         }
     }

     if (this.level == 1) {
         switch (this.guessNum) {
             case 1:
                 var2.drawOval(60, 80, 20, 20);
                 break;
             case 2:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 110);
                 break;
             case 3:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 120);
                 break;
             case 4:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 break;
             case 5:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 70, 110);
                 break;
             case 6:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 break;
             case 7:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 85, 150);
                 break;
             case 8:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 55, 150);
                 var2.drawLine(70, 130, 85, 150);
         }
     }

     if (this.level == 2) {
         switch (this.guessNum) {
             case 1:
                 var2.drawOval(60, 80, 20, 20);
                 break;
             case 2:
                 var2.drawOval(60, 80, 20, 20);
                 break;
             case 3:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 break;
             case 4:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 break;
             case 5:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 85, 150);
                 break;
             case 6:
                 var2.drawOval(60, 80, 20, 20);
                 var2.drawLine(70, 100, 70, 130);
                 var2.drawLine(50, 110, 90, 110);
                 var2.drawLine(70, 130, 55, 150);
                 var2.drawLine(70, 130, 85, 150);
         }
     }

     var2.setColor(Color.RED);
     var2.drawString(Integer.toString(this.guessNum) + " guesses left", 340, 240);
     var2.setFont(this.normalFont);
     var2.setColor(Color.BLACK);
     var2.drawString("Current skill level: " + this.slevel[this.level], 300, 220);
     var2.drawString("Wins ", 220, 200);
     var2.drawString(Integer.toString((int)this.wins), 265, 200);
     var2.drawString("Looses", 300, 200);
     var2.drawString(Integer.toString((int)this.looses), 365, 200);
     var2.drawString("winRate", 400, 200);
     var2.drawString(Double.toString(this.winRate) + "%", 555, 200);
     if (this.word_length == 4) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 150);
         var2.drawString(this.word2[1], 320, 150);
         var2.drawString(this.word2[2], 340, 150);
         var2.drawString(this.word2[3], 360, 150);
     }

     if (this.word_length == 5) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 150);
         var2.drawString(this.word2[1], 320, 150);
         var2.drawString(this.word2[2], 340, 150);
         var2.drawString(this.word2[3], 360, 150);
         var2.drawString(this.word2[4], 380, 150);
     }

     if (this.word_length == 6) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 150);
         var2.drawString(this.word2[1], 320, 150);
         var2.drawString(this.word2[2], 340, 150);
         var2.drawString(this.word2[3], 360, 150);
         var2.drawString(this.word2[4], 380, 150);
         var2.drawString(this.word2[5], 400, 150);
     }

     if (this.word_length == 7) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 150);
         var2.drawString(this.word2[1], 320, 150);
         var2.drawString(this.word2[2], 340, 150);
         var2.drawString(this.word2[3], 360, 150);
         var2.drawString(this.word2[4], 380, 150);
         var2.drawString(this.word2[5], 400, 150);
         var2.drawString(this.word2[6], 420, 150);
     }

     if (this.word_length == 8) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 150);
         var2.drawString(this.word2[1], 320, 150);
         var2.drawString(this.word2[2], 340, 150);
         var2.drawString(this.word2[3], 360, 150);
         var2.drawString(this.word2[4], 380, 150);
         var2.drawString(this.word2[5], 400, 150);
         var2.drawString(this.word2[6], 420, 150);
         var2.drawString(this.word2[7], 440, 150);
     }

     if (this.word_length == 9) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 150);
         var2.drawString(this.word2[1], 320, 150);
         var2.drawString(this.word2[2], 340, 150);
         var2.drawString(this.word2[3], 360, 150);
         var2.drawString(this.word2[4], 380, 150);
         var2.drawString(this.word2[5], 400, 150);
         var2.drawString(this.word2[6], 420, 150);
         var2.drawString(this.word2[7], 440, 150);
         var2.drawString(this.word2[8], 460, 150);
     }

     if (this.word_length == 10) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 150);
         var2.drawString(this.word2[1], 320, 150);
         var2.drawString(this.word2[2], 340, 150);
         var2.drawString(this.word2[3], 360, 150);
         var2.drawString(this.word2[4], 380, 150);
         var2.drawString(this.word2[5], 400, 150);
         var2.drawString(this.word2[6], 420, 150);
         var2.drawString(this.word2[7], 440, 150);
         var2.drawString(this.word2[8], 460, 150);
         var2.drawString(this.word2[9], 480, 150);
     }

     if (this.word_length == 11) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 160);
         var2.drawString(this.word2[1], 320, 160);
         var2.drawString(this.word2[2], 340, 160);
         var2.drawString(this.word2[3], 360, 160);
         var2.drawString(this.word2[4], 380, 160);
         var2.drawString(this.word2[5], 400, 160);
         var2.drawString(this.word2[6], 420, 160);
         var2.drawString(this.word2[7], 440, 160);
         var2.drawString(this.word2[8], 460, 160);
         var2.drawString(this.word2[9], 480, 160);
         var2.drawString(this.word2[10], 500, 160);
     }

     if (this.word_length == 12) {
         var2.setFont(this.normalFont);
         var2.setColor(Color.BLACK);
         var2.drawString(this.word2[0], 300, 160);
         var2.drawString(this.word2[1], 320, 160);
         var2.drawString(this.word2[2], 340, 160);
         var2.drawString(this.word2[3], 360, 160);
         var2.drawString(this.word2[4], 380, 160);
         var2.drawString(this.word2[5], 400, 160);
         var2.drawString(this.word2[6], 420, 160);
         var2.drawString(this.word2[7], 440, 160);
         var2.drawString(this.word2[8], 460, 160);
         var2.drawString(this.word2[9], 480, 160);
         var2.drawString(this.word2[10], 500, 160);
         var2.drawString(this.word2[11], 520, 160);
     }

 }

 public void wordSelect() {
     double var1 = Math.random() * 201.0;

     int var3;
     for(var3 = (int)Math.floor(var1); this.checked[var3] != 0; var3 = (int)Math.floor(var1)) {
         var1 = Math.random() * 201.0;
     }

     this.checked[var3] = 1;
     if (this.words[var3] != null) {
         String var4 = this.words[var3].toLowerCase();
         this.word_length = var4.length();
         char[] var5 = var4.toCharArray();

         int var6;
         for(var6 = 0; var6 < this.word_length; ++var6) {
             this.word1[var6] = var5[var6];
         }

         for(var6 = 0; var6 < this.word_length; ++var6) {
             this.word2[var6] = "_";
         }
     }

 }

 public void word_reset() {
     for(int var1 = 0; var1 < 12; ++var1) {
         this.word2[var1] = "_";
     }

     this.wordSelect();
 }

 public void spell_check(char var1) {
     boolean var2 = false;

     for(int var3 = 0; var3 < 12; ++var3) {
         if (this.word1[var3] != ' ' && this.word1[var3] == var1) {
             this.word2[var3] = "" + var1;
             var2 = true;
             this.repaint();
         }
     }

     if (!var2) {
         --this.guessNum;
         this.repaint();
     }

     this.Adjust_display();
     this.repaint();
 }

 public void Adjust_display() {
     if (this.word_length == 4 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 5 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 6 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_" && this.word2[5] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 7 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_" && this.word2[5] != "_" && this.word2[6] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 8 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_" && this.word2[5] != "_" && this.word2[6] != "_" && this.word2[7] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 9 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_" && this.word2[5] != "_" && this.word2[6] != "_" && this.word2[7] != "_" && this.word2[8] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 10 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_" && this.word2[5] != "_" && this.word2[6] != "_" && this.word2[7] != "_" && this.word2[8] != "_" && this.word2[9] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 11 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_" && this.word2[5] != "_" && this.word2[6] != "_" && this.word2[7] != "_" && this.word2[8] != "_" && this.word2[9] != "_" && this.word2[10] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.word_length == 12 && this.word2[0] != "_" && this.word2[1] != "_" && this.word2[2] != "_" && this.word2[3] != "_" && this.word2[4] != "_" && this.word2[5] != "_" && this.word2[6] != "_" && this.word2[7] != "_" && this.word2[8] != "_" && this.word2[9] != "_" && this.word2[10] != "_" && this.word2[11] != "_") {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);
         this.hint.setEnabled(false);
         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.wins;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

     if (this.guessNum <= 0) {
         this.a.setEnabled(false);
         this.b.setEnabled(false);
         this.c.setEnabled(false);
         this.d.setEnabled(false);
         this.e.setEnabled(false);
         this.f.setEnabled(false);
         this.g.setEnabled(false);
         this.h.setEnabled(false);
         this.i.setEnabled(false);
         this.j.setEnabled(false);
         this.k.setEnabled(false);
         this.l.setEnabled(false);
         this.m.setEnabled(false);
         this.n.setEnabled(false);
         this.o.setEnabled(false);
         this.p.setEnabled(false);
         this.q.setEnabled(false);
         this.r.setEnabled(false);
         this.s.setEnabled(false);
         this.t.setEnabled(false);
         this.u.setEnabled(false);
         this.v.setEnabled(false);
         this.w.setEnabled(false);
         this.x.setEnabled(false);
         this.y.setEnabled(false);
         this.z.setEnabled(false);

         for(int var1 = 0; var1 < 12; ++var1) {
             char var10002 = this.word1[var1];
             this.word2[var1] = "" + var10002;
         }

         this.begin.setEnabled(true);
         if (this.level == 0) {
             this.medium.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 1) {
             this.easy.setEnabled(true);
             this.hard.setEnabled(true);
         } else if (this.level == 2) {
             this.easy.setEnabled(true);
             this.medium.setEnabled(true);
         }

         ++this.looses;
         this.winRate = this.wins / (this.wins + this.looses) * 100.0;
         this.repaint();
     }

 }


 public void actionPerformed(ActionEvent var1) {
     String var2 = var1.getActionCommand();
     if (var2.equals("BEGIN")) {
         for(int var3 = 0; var3 < 12; ++var3) {
             this.word1[var3] = ' ';
             this.word2[var3] = "_";
         }

         this.easy.setEnabled(false);
         this.medium.setEnabled(false);
         this.hard.setEnabled(false);
         if (this.level == 0) {
             this.guessNum = 10;
         } else if (this.level == 1) {
             this.guessNum = 8;
         } else if (this.level == 2) {
             this.guessNum = 6;
         }

         this.repaint();
         this.a.setEnabled(true);
         this.b.setEnabled(true);
         this.c.setEnabled(true);
         this.d.setEnabled(true);
         this.e.setEnabled(true);
         this.f.setEnabled(true);
         this.g.setEnabled(true);
         this.h.setEnabled(true);
         this.i.setEnabled(true);
         this.j.setEnabled(true);
         this.k.setEnabled(true);
         this.l.setEnabled(true);
         this.m.setEnabled(true);
         this.n.setEnabled(true);
         this.o.setEnabled(true);
         this.p.setEnabled(true);
         this.q.setEnabled(true);
         this.r.setEnabled(true);
         this.s.setEnabled(true);
         this.t.setEnabled(true);
         this.u.setEnabled(true);
         this.v.setEnabled(true);
         this.w.setEnabled(true);
         this.x.setEnabled(true);
         this.y.setEnabled(true);
         this.z.setEnabled(true);
         this.hint.setEnabled(true);
         this.begin.setEnabled(false);
         this.word_reset();
     }

     if (var2.equals("A")) {
         this.a.setEnabled(false);
         this.spell_check('a');
     }

     if (var2.equals("B")) {
         this.b.setEnabled(false);
         this.spell_check('b');
     }

     if (var2.equals("C")) {
         this.c.setEnabled(false);
         this.spell_check('c');
     }

     if (var2.equals("D")) {
         this.d.setEnabled(false);
         this.spell_check('d');
     }

     if (var2.equals("E")) {
         this.e.setEnabled(false);
         this.spell_check('e');
     }

     if (var2.equals("F")) {
         this.f.setEnabled(false);
         this.spell_check('f');
     }

     if (var2.equals("G")) {
         this.g.setEnabled(false);
         this.spell_check('g');
     }

     if (var2.equals("H")) {
         this.h.setEnabled(false);
         this.spell_check('h');
     }

     if (var2.equals("I")) {
         this.i.setEnabled(false);
         this.spell_check('i');
     }

     if (var2.equals("J")) {
         this.j.setEnabled(false);
         this.spell_check('j');
     }

     if (var2.equals("K")) {
         this.k.setEnabled(false);
         this.spell_check('k');
     }

     if (var2.equals("L")) {
         this.l.setEnabled(false);
         this.spell_check('l');
     }

     if (var2.equals("M")) {
         this.m.setEnabled(false);
         this.spell_check('m');
     }

     if (var2.equals("N")) {
         this.n.setEnabled(false);
         this.spell_check('n');
     }

     if (var2.equals("O")) {
         this.o.setEnabled(false);
         this.spell_check('o');
     }

     if (var2.equals("P")) {
         this.p.setEnabled(false);
         this.spell_check('p');
     }

     if (var2.equals("Q")) {
         this.q.setEnabled(false);
         this.spell_check('q');
     }

     if (var2.equals("R")) {
         this.r.setEnabled(false);
         this.spell_check('r');
     }

     if (var2.equals("S")) {
         this.s.setEnabled(false);
         this.spell_check('s');
     }

     if (var2.equals("T")) {
         this.t.setEnabled(false);
         this.spell_check('t');
     }

     if (var2.equals("U")) {
         this.u.setEnabled(false);
         this.spell_check('u');
     }

     if (var2.equals("V")) {
         this.v.setEnabled(false);
         this.spell_check('v');
     }

     if (var2.equals("W")) {
         this.w.setEnabled(false);
         this.spell_check('w');
     }

     if (var2.equals("X")) {
         this.x.setEnabled(false);
         this.spell_check('x');
     }

     if (var2.equals("Y")) {
         this.y.setEnabled(false);
         this.spell_check('y');
     }

     if (var2.equals("Z")) {
         this.z.setEnabled(false);
         this.spell_check('z');
     }

     if (var2.equals("EASY")) {
         this.easy.setEnabled(false);
         this.medium.setEnabled(true);
         this.hard.setEnabled(true);
         this.level = 0;
         this.repaint();
     }

     if (var2.equals("MEDIUM")) {
         this.medium.setEnabled(false);
         this.hard.setEnabled(true);
         this.easy.setEnabled(true);
         this.level = 1;
         this.repaint();
     }

     if (var2.equals("HARD")) {
         this.hard.setEnabled(false);
         this.medium.setEnabled(true);
         this.easy.setEnabled(true);
         this.level = 2;
         this.repaint();
     }

 }

 public static void main(String[] var0) {
     Hangman var1 = new Hangman();
     var1.init();
 }
}
