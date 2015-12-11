package excise;

public class T292 {
	public static boolean canWinNim(int n) {
		/*if(n<=3) return true;
		if(n==4) return false;
		for(int i =1; i<4; i++){
			if(!canWinNim(n-i)) return true;
		}
		return false;*/
		if(n%4==0) return false;
		else return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWinNim(8));
	}

}
