package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	
	private boolean isFirst=true;
	//������һ����X,Y�������һ����X��Y
	private int cPrePosX;
	private int cPrePosY;
	private int pPrePosX;
	private int pPrePosY;
	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
			pPrePosX = posX;
			pPrePosY = posY;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {

//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "ʮ" ) {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
//		int[] result = { posX, posY };
//		return result;
		String[][] board = chessboard.getBoard();
		int [] result ={0,0};
		int posX=1;
		int posY=1;
		//��һ�������м�λ�ã����ĸ������������ռ�ˣ��ͻ�һ��������������ѡ������
		if(isFirst==true){
			if(board[11][11]=="ʮ"){
				posX = 11;
				posY = 11;
				cPrePosX=11;
				cPrePosY=11;
			}
			else if(board[11][12]=="ʮ") {
				posX = 11;
				posY = 12;
				cPrePosX=11;
				cPrePosY=12;
			}
			isFirst=false;
		}
		else{
			int k=0;
			int countBlank=0;
			for(;k<=7;k++){
				if(k==0){posX=cPrePosX+1;posY=cPrePosY;}
				if(k==1){posX=cPrePosX-1;posY=cPrePosY;}
				if(k==2){posX=cPrePosX;posY=cPrePosY+1;}
				if(k==3){posX=cPrePosX;posY=cPrePosY-1;}
				if(k==4){posX=cPrePosX+1;posY=cPrePosY+1;}
				if(k==5){posX=cPrePosX+1;posY=cPrePosY-1;}
				if(k==6){posX=cPrePosX-1;posY=cPrePosY+1;}
				if(k==7){posX=cPrePosX-1;posY=cPrePosY-1;}
				if(board[posX][posY] == "ʮ") countBlank++;
			}
			
			if(countBlank>=1){
				k = (int) (Math.random()*7 );
				if(k==0){posX=cPrePosX+1;posY=cPrePosY;}
				if(k==1){posX=cPrePosX-1;posY=cPrePosY;}
				if(k==2){posX=cPrePosX;posY=cPrePosY+1;}
				if(k==3){posX=cPrePosX;posY=cPrePosY-1;}
				if(k==4){posX=cPrePosX+1;posY=cPrePosY+1;}
				if(k==5){posX=cPrePosX+1;posY=cPrePosY-1;}
				if(k==6){posX=cPrePosX-1;posY=cPrePosY+1;}
				if(k==7){posX=cPrePosX-1;posY=cPrePosY-1;}
				while(board[posX][posY] != "ʮ" )
				{
					k = (int) (Math.random()*7 );
					if(k==0){posX=cPrePosX+1;posY=cPrePosY;}
					if(k==1){posX=cPrePosX-1;posY=cPrePosY;}
					if(k==2){posX=cPrePosX;posY=cPrePosY+1;}
					if(k==3){posX=cPrePosX;posY=cPrePosY-1;}
					if(k==4){posX=cPrePosX+1;posY=cPrePosY+1;}
					if(k==5){posX=cPrePosX+1;posY=cPrePosY-1;}
					if(k==6){posX=cPrePosX-1;posY=cPrePosY+1;}
					if(k==7){posX=cPrePosX-1;posY=cPrePosY-1;}
				}
			}
			else{
				//�����������Χ�����
				
				int k2=0;
				int countBlank2=0;
				for(;k2<=7;k2++){
					if(k2==0){posX=pPrePosX+1;posY=pPrePosY;}
					if(k2==1){posX=pPrePosX-1;posY=pPrePosY;}
					if(k2==2){posX=pPrePosX;posY=pPrePosY+1;}
					if(k2==3){posX=pPrePosX;posY=pPrePosY-1;}
					if(k2==4){posX=pPrePosX+1;posY=pPrePosY+1;}
					if(k2==5){posX=pPrePosX+1;posY=pPrePosY-1;}
					if(k2==6){posX=pPrePosX-1;posY=pPrePosY+1;}
					if(k2==7){posX=pPrePosX-1;posY=pPrePosY-1;}
					if(board[posX][posY] == "ʮ") countBlank2++;
				}
				
				if(countBlank2>=1){
					while(board[posX][posY] != "ʮ" )
					{
						k2 = (int) (Math.random()*7 );
						if(k2==0){posX=pPrePosX+1;posY=pPrePosY;}
						if(k2==1){posX=pPrePosX-1;posY=pPrePosY;}
						if(k2==2){posX=pPrePosX;posY=pPrePosY+1;}
						if(k2==3){posX=pPrePosX;posY=pPrePosY-1;}
						if(k2==4){posX=pPrePosX+1;posY=pPrePosY+1;}
						if(k2==5){posX=pPrePosX+1;posY=pPrePosY-1;}
						if(k2==6){posX=pPrePosX-1;posY=pPrePosY+1;}
						if(k2==7){posX=pPrePosX-1;posY=pPrePosY-1;}
					}
				}
				//�����������
				else {
					posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
					posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
					while (board[posX][posY] != "ʮ" ) {
						posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
						posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
					}
				}
			}
			//Խ�紦��
			if(posX>(chessboard.BOARD_SIZE-1)||posY>(chessboard.BOARD_SIZE-1)||posX<0||posY<0){
				posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
				posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
				while (board[posX][posY] != "ʮ" ) {
					posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
					posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
				}
			}
		}
		result[0] = posX ;
		result[1] = posY ;
		cPrePosX=posX;cPrePosY=posY;
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            �������ͣ��ڰ�
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {

		boolean flag = false; // һ��ʼ��Ӯ
		//ֱ�������յ�����
        int startX=0;
        int startY=0;
        int endX=chessboard.BOARD_SIZE-1;
        int endY=chessboard.BOARD_SIZE-1;
		
		String[][] board = chessboard.getBoard();
		
		//���� 
		int i1 = 1; // ������ѭ���ڼ�������
		int count1 = 1; // �����������ж��ٸ�����������
		//�ж��Ƿ���posX,posYͬɫ�����ӣ��ж��Ƿ�Խ�磬�������������������1
		while (board[posX + i1][posY] == ico&&(posX+i1)<=endX)  {
			i1++;
			count1++;
		}
		while (board[posX - i1][posY] == ico&&(posX-i1)>=startX) {
			i1++;
			count1++;
		}
		if (count1 >= 5) {
			flag = true;
			return true;
		} // ����>=5��Ӯ�� flagΪtrue

		 //����
        int i2 = 1;  
        int count2 = 1;
      //�ж��Ƿ���posX,posYͬɫ�����ӣ��ж��Ƿ�Խ�磬�������������������1
       while(board[posX][posY + i2]==ico&&(posY+i2)<=endY){
               i2++;
               count2 ++;
        }
        while(board[posX][posY - i2]==ico&&(posY-i2)>=startY) {
               i2++;
               count2 ++;       
       }
       if(count2 >= 5){
			flag = true;
			return true;
		} // ����>=5��Ӯ�� flagΪtrue
       
       //б��
       int i3 = 1;
       int count3 = 1;
     //�ж��Ƿ���posX,posYͬɫ�����ӣ��ж��Ƿ�Խ�磬�������������������1
       while(board[posX + i3][posY - i3]==ico&&(posX+i3)<=endX&&(posY-i3)>=startY){
               i3++;
               count3 ++;
        }
        while(board[posX - i3][posY + i3]==ico&&(posX-i3)>=startX&&(posY+i3)<=endY) {
               i3++;
               count3 ++;       
       }
       if(count3 >= 5){
			flag = true;
			return true;
		} // ����>=5��Ӯ�� flagΪtrue
       
      //б��
       int i4 =1;
       int count4 = 1;
     //�ж��Ƿ���posX,posYͬɫ�����ӣ��ж��Ƿ�Խ�磬�������������������1
       while(board[posX + i4][posY + i4]==ico&&(posX+i4)<=endX&&(posY+i4)<=endY){
               i4++;
               count4 ++;
        }
        while(board[posX - i4][posY - i4]==ico&&(posX-i4)>=startX&&(posY-i4)>=startY) {
               i4++;
               count4 ++;       
       }
       if(count4 >= 5){
			flag = true;
			return true;
		} // ����>=5��Ӯ�� flagΪtrue

		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
