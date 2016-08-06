import java.util.*;

//https://open.kattis.com/problems/hittingtargets


public class Main {


	public char type;
	public int x1, x2, y1 , y2;
	public int r;


	public Main(String type, int x1, int y1, int x2 , int y2, int r) {
		this.type = type.charAt(0);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1; 
		this.y2 = y2;
	}

	public boolean isInside(int x, int y) {
		boolean ans = true;

		if(this.type == 'c') {
			long v1 = (x - x1)*(x - x1);
			long v2 = (y - y1)*(y - y1);

			if(v1+v2 <= r*r) ans = true;
			else ans = false;
		}else {
			ans = ( x >= x1 && x <= x2 && y >= y1 && y <= y2 ) ;
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		Main[] tab = new Main[N];
		for(int i =0; i < N; i++) {
			String type = in.next();
			Main m = null;
			if(type.equals("rectangle")) {
				m = new Main(type, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), 0);
			}else  {
				m = new Main(type, in.nextInt(), in.nextInt(), 0, 0, in.nextInt());
			}

			tab[i] = m;
		}
		int T = in.nextInt();
		for(int i = 0; i < T; i++) {
			int count = 0;
			int x = in.nextInt();
			int y = in.nextInt();

			for(int j = 0; j < N;j++) {
				if(tab[j].isInside(x, y)) count++;
			}

			System.out.println(count);
		}


	}


}