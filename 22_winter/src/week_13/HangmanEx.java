package week_13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangmanEx extends JFrame implements ActionListener{
	String[] words = new String[201];
	int[] checked = new int [201]; // 나왔던 단어 체크하는 배열
	int word_length; // 단어의 길이
	int guessNum; // 맞추는 횟수 (10번만에 맞추는지 8번만에 맞추는지)
	int level; // 게임 난이도 
	char[] word1 = new char[12]; // 프로그램 안에서 돌아가는 char
	String[] slevel= {"Easy","Medium","Hard"}; // 난이도
	String[] word2 = new String[12]; // 화면에 출력할 String
	String check_word;
	double wins;
	double looses;
	double winningProsentige;
	
	JButton a = new JButton("A");	JButton b = new JButton("B");
	
	JButton y = new JButton("Y");	JButton z = new JButton("Z");
	
	JButton begin = new JButton("BEGIN");
	JButton easy = new JButton("EASY");
	JButton medium = new JButton("MEDIUM");
	JButton hard = new JButton("HARD");
	JLabel text = new JLabel("Skill level: ", JLabel.LEFT); // 레벨 레이블로 띄우기
	
	JPanel displayTOP = new JPanel();
	JPanel display1 = new JPanel();  	
	JPanel display2 = new JPanel();
	
	Font normalFont = new Font("Arial", Font.BOLD, 16);
	Font warningFont = new Font("Arial", Font.BOLD, 20);
	
	public HangmanEx() {
		setTitle("행맨 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(850,700);
		setVisible(true);
	}
	
	public void init() {
		a.addActionListener(this);		b.addActionListener(this);
		
		y.addActionListener(this);		z.addActionListener(this);
		
		begin.addActionListener(this);
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		
		GridLayout aaa = new GridLayout(3,0); // 전체 panel에 대한 layout 설정
		FlowLayout bbb = new FlowLayout();  // displayTOP에 대한 layout // begin버튼
                           FlowLayout ccc = new FlowLayout(); // display2에 대한 layout
                           GridLayout ddd = new GridLayout(); // display1에 대한 layout // 알파벳
    
	    Container root = getContentPane(); // 컨테이너 타입의 객체 root
		root.setLayout(aaa); //grid
		root.setBackground(Color.white);
		
		displayTOP.add(begin);
		displayTOP.setLayout(bbb);
		displayTOP.setBackground(Color.white);
					
		root.add(displayTOP); // TOP을 컨테이너에 등록
		display1.setLayout(ddd); 
		display1.setBackground(Color.white);
		
		a.setBackground(Color.orange);		b.setBackground(Color.orange);
		
		y.setBackground(Color.orange);		z.setBackground(Color.orange);
		
		display1.add(a);	display1.add(b);	
		display1.add(y);	display1.add(z);
		
		root.add(display1);
		
		display2.setLayout(ccc);
		display2.setBackground(Color.white);
		display2.add(text);
		display2.add(easy);
		display2.add(medium);
		display2.add(hard);
		root.add(display2);
		setContentPane(root);
		
		a.setEnabled(false);		b.setEnabled(false); 
		
		y.setEnabled(false);		z.setEnabled(false); 
		
		// begin이 눌리면 그때부터 활성화 (true)
		easy.setEnabled(false);
		medium.setEnabled(true);
		hard.setEnabled(true);
		
		words[0] = "korea";     // 200개 이상의 단어 구성, 철자 4개 이상 12개 이하
		words[1] = "hansung";
		
		words[199] = "trust";
		words[200] = "violence";
		
		for(int i=0;i<checked.length;i++) {
			checked[i]=0; // 아직 선택되지 않은 단어 (0)으로 초기화
		}
		
		for(int i=0;i<12;i++) {
			word1[i]=' '; // character // 프로그램 안에서 맞는지 틀린지
			word2[i]=" "; // string // 화면에 내보낼 때 
		}
				
		/* 필요한 변수들의 초기치 설정 */
		wins = 0;
		looses =0 ;
		winningProsentige = 0.0;
	}

	public void paint(Graphics screen) {
		super.paint(screen);
		Graphics2D screen2D = (Graphics2D) screen;
		screen2D.setFont(warningFont);
	
		screen2D.drawLine(70,60,130,60);
		screen2D.drawLine(70,60,70,80);
		screen2D.drawLine(130,60,130,170);
		screen2D.drawLine(60,170,160,170);
		
		if(level == 0) {
			switch(guessNum) {
			case 1:
				screen2D.drawOval(60,80,20,20); // 얼굴
				break;
			
			
			case 10:
				screen2D.drawOval(60,80,20,20); // 얼굴
				screen2D.drawLine(70,100,70,130); // 몸통
				screen2D.drawLine(50,110,90,110); // 팔
				screen2D.drawLine(70,130,55,150); // 왼 다리
				screen2D.drawLine(70,130,85,150); // 오른 다리
				break;
			}
		}
		
		
		if(level == 1) {
			switch(guessNum) {
			case 1:
				screen2D.drawOval(60,80,20,20); // 얼굴
				break;
			
			case 8:
				screen2D.drawOval(60,80,20,20); // 얼굴
				screen2D.drawLine(70,100,70,130); // 몸통
				screen2D.drawLine(50,110,90,110); // 팔
				screen2D.drawLine(70,130,55,150); // 왼 다리
				screen2D.drawLine(70,130,85,150); // 오른 다리
				break;
			}
		}
		
		if(level == 2) {
			switch(guessNum) {
			case 1:
				screen2D.drawOval(60,80,20,20); // 얼굴
				break;
			
			case 6:
				screen2D.drawOval(60,80,20,20); // 얼굴
				screen2D.drawLine(70,100,70,130); // 몸통
				screen2D.drawLine(50,110,90,110); // 팔
				screen2D.drawLine(70,130,55,150); // 왼 다리
				screen2D.drawLine(70,130,85,150); // 오른 다리
				break;
			}
		}

		screen2D.setColor(Color.RED);
		screen2D.drawString(Integer.toString(guessNum)+" guesses left", 340, 240 );
		screen2D.setFont(normalFont);
		screen2D.setColor(Color.BLACK);
		screen2D.drawString("Current skill level: "+slevel[level], 300, 220 );
		screen2D.drawString("Wins ", 220, 200 );
		screen2D.drawString(Integer.toString((int)wins), 265, 200 );
		screen2D.drawString("Looses", 300, 200 );
		screen2D.drawString(Integer.toString((int)looses), 365, 200 );
		screen2D.drawString("WinningProsentige", 400, 200 );
		screen2D.drawString(Double.toString(winningProsentige)+"%", 555, 200 );
		
		if(word_length == 4) { // 단어의 길이 4-12로 제한
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			//screen2D.drawImage(img, 100, 100, this);
			screen2D.drawString(word2[0], 300, 150 );
			screen2D.drawString(word2[1], 320, 150 );
			screen2D.drawString(word2[2], 340, 150 );
			screen2D.drawString(word2[3], 360, 150 );
		}
		
		if(word_length == 12) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 160 );
			
			screen2D.drawString(word2[11], 520, 160 );
		}
		//답이 맞은 단어에 대한 화면 표시
		//답이 틀린 단어에 대한 화면 표시   
		//시도한 횟수에 대하여 맞은 단어와 틀린 단어의 수 등을 표시 
	}
	public void wordSelect() {
		double sel_num = Math.random() * 201;// 0~200.xx
		int selection = (int) Math.floor(sel_num); // 0~200
		while(true) {  /* 이미 선택된 단어가 다시 선택되는 경우는 배제해야 함 */ // 나왔던 단어가 또 나오면 안됨
			if(checked[selection] == 0) { // 아직 뽑힌 단어가 아니라면 0
				
			}
			else {
				
			}
		}
   /*     String sel_Word;     
		if(words[selection] != null) { // 고른 단어가 null이 아닐때까지
			sel_Word = words[selection].toLowerCase();
			word_length = sel_Word.length();

			char[] temp = sel_Word.toCharArray();   // character 배열로 변환
			for(int index1 = 0; index1 < word_length; index1++) {
				 word1[index1] = temp[index1];
			}
			 for(int index2 = 0; index2 < word_length; index2++) {
				 word2[index2] = "_"; // .또는 _로 유저에게 단어의 철자 수를 알려줌
			}
		}*/
	}
	public void word_reset() { 
		for(int i=0;i<12;i++) {
			word2[i]="_";
		}
		wordSelect();
	}
	public void spell_check(char spell) {
		int check_key = 0;
		for(int i=0; i<12; i++) {  //12는 좋은 표현이 아님
			if(word1[i] != ' ') {
				if(word1[i] == spell) {
					word2[i] = "" + spell;
					check_key = 1;
					repaint();
				}
			}
		}
		
		if(check_key == 0) { // 끝까지 다 찾았는데 check_key가 0이면 특정 알파(a)가 없음
			guessNum--;
			repaint();
		}
		Adjust_display();
		repaint();
	}
	
	public void Adjust_display() {
		if(word_length == 4) {
			if(word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_") {
                                // 단어 추정 성공
				a.setEnabled(false);		b.setEnabled(false); 
				
				y.setEnabled(false);		z.setEnabled(false);
				begin.setEnabled(true);
				if(level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if(level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if(level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins/(wins+looses))*100.0;
				repaint(); 
				
			}
		}
		
		
		
		if(word_length == 12) {
			
		}

		

		if(guessNum <= 0) {  // 단어 추정 실패 
			
			// 버튼 눌릴 수 없게 만듬
			a.setEnabled(false);		b.setEnabled(false); 
			
			y.setEnabled(false);		z.setEnabled(false);
			
			// 정답을 화면에 표시
			for(int i=0;i<12;i++){
				word2[i] = "" + word1[i];
			}
                        
			begin.setEnabled(true);	
			// level에 따른 버튼 활성화 작업 
			if(level == 0) {
				medium.setEnabled(true);
				hard.setEnabled(true);
			} else if(level == 1) {
				easy.setEnabled(true); 
				hard.setEnabled(true);
			} else if(level == 2) {
				easy.setEnabled(true);
				medium.setEnabled(true);
			}
			looses++;
			winningProsentige = (wins/(wins+looses))*100.0;
			repaint();
			
			
		}

	}
	
	public void actionPerformed(ActionEvent event) {
		String typed = event.getActionCommand(); // 어떤 버튼을 눌렀는지 알려줌
		if(typed.equals("BEGIN")) {
			for(int i=0; i<12; i++){
				word1[i] = ' ';
				word2[i] = "_";
			}
				
			easy.setEnabled(false);
			medium.setEnabled(false);
			hard.setEnabled(false);

			if(level == 0) {
				guessNum = 10;
			} 
			else if(level == 1) {
				guessNum = 8;
			} 
			else if(level == 2) {
				guessNum = 6;
			}

			repaint();
			a.setEnabled(true);		b.setEnabled(true); 
			
			y.setEnabled(true);		z.setEnabled(true);
			
			begin.setEnabled(false);
			word_reset();

			
		}
		if(typed.equals("A")) {
			a.setEnabled(false);
			spell_check('a');
		}
		
		if(typed.equals("Z")) {
			z.setEnabled(false);
			spell_check('z');
		}
		if(typed.equals("EASY")) {
			easy.setEnabled(false);
			medium.setEnabled(true);
			hard.setEnabled(true);
			level = 0;
			repaint();
		}
		if(typed.equals("MEDIUM")) {
			
		}
		if(typed.equals("HARD")) {
			
		}
	}
	public static void main(String [] args) {
		HangmanEx h=new HangmanEx();
		
		h.init();
	}
}
