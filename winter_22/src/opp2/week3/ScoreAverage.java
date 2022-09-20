package week3;

public class ScoreAverage {

	public static void main(String[] args) {
		double score[] [] = {{3.3, 3.4}, //1학년 1,2학기
							{3.5, 3.6}, //2학년 1,2학기
							{3.7, 4.0},   //3학년
							{4.1, 4.2} }; //4학년
		double sum=0;
		for(int year=0; year<score.length; year++)//각학년별로 반복
			for(int term=0; term<score[year].length; term++) //각 학기별로 반복
				sum += score[year][term];
		
		int n=score.length;
		int m=score[0].length;
		System.out.println("4년 전체 평점 평균은 " + sum/(n*m));
		
		
	}

}
