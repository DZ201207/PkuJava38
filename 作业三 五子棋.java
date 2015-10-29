package PkuJava38;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������y����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

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
	public void start() throws Exception 
	{
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
				System.out.println("compu = "+computerPosArr[0]+"   "+ computerPosArr[1]);
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
		//��ȡ�û����������
		int xx= posX, yy = posY;
		/**
		*�û�������
		****/
		String client = Chessman.BLACK.getChessman();
		/**
		 * ���������
		 * */
		String computer = Chessman.WHITE.getChessman();
		String[][] board = chessboard.getBoard();
		int max = checkChessCount(xx, yy, client);
		//���˵�һ������
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 22; j++) {
				if (board[i][j] == "ʮ") {
					int k = checkChessCount(i, j, client);
					if (k>max) {
						max = k;
						posX = i;
						posY = j;
					}
				}
			}
			
		}
		int max1 = 0;
		int xx1=0,yy1=0;
		//�Ӽ������һ������
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 22; j++) {
				if (board[i][j] == "ʮ") {
					int k = checkChessCount(i, j, computer);
					if (k>max1) {
						max1 = k;
						xx1 = i;
						yy1 = j;
					}
				}
			}
			
		}
		//�Լ�ʤ��
		if (max1 >= max){
			int[] result = { xx1, yy1 };
			return result; 
		}
		//������������ʤ����
		else{
			int[] result = { posX, posY };
			return result;
		}
	}

	/**
	 * �ж���Ӯ
	 * 
	 *	private final int WIN_COUNT = 5;
	 *	private int posX = 0;
	 *	private int posY = 0;
	 *	private Chessboard chessboard;
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������  "ʮ"  BLACK("��"), WHITE("��");  
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��  
	 */
	public boolean isWon(int posX, int posY, String ico) {
		if (checkChessCount(posX, posY, ico)==5) {
			return true;
		}
		return false;
	}
	//������0~21�ķ�Χ��
	private int checkChessCount(int posX, int posY, String ico) {
		int chesscount=1;
		String[][] board = chessboard.getBoard();
		int max=0;//��¼һ��������������
		//�ĸ�����������
		//1ˮƽ����
		int xx1=posX,yy1=posY;
		int xx2=posX,yy2=posY;
		while(true){
			if (yy1>0 && board[xx1][yy1-1]==ico) {
				--yy1;
				chesscount++;
			}else break;
		}
		while(true){
			if (yy2<21 && board[xx2][1+yy2]==ico) {
				yy2++;
				chesscount++;
			}else{ max=max>chesscount?max:chesscount;  break;}
		}
		//2��ֱ����
		xx1=posX;yy1=posY;xx2=posX;yy2=posY;
		chesscount=1;
		while(true){
			if (xx1>0 && board[xx1-1][yy1]==ico) {
				xx1--;
				chesscount++;
			}
			else break;
		}
		while(true){
			if (xx2<21 && board[1+xx2][yy2]==ico) {
				xx2++;
				chesscount++;
			}else{ max=max>chesscount?max:chesscount;  break;}
		}
		//3 ���Ϸ������·���
		xx1=posX;yy1=posY;xx2=posX;yy2=posY;
		chesscount=1;
		while(true){
			if (xx1>0 && yy1>0 && board[xx1-1][yy1-1]==ico) {
				xx1--;
				yy1--;
				chesscount++;
			}
			else break;
		}
		while(true){
			if (xx2<21 && yy2<21 && board[1+xx2][1+yy2]==ico) {
				xx2++;
				yy2++;
				chesscount++;
			}else{ max=max>chesscount?max:chesscount;  break;}
		}
		//4 ���ϵ����·���
		xx1=posX;yy1=posY;xx2=posX;yy2=posY;
		chesscount=1;
		while(true){
			if (xx1>0 && yy1<21 && board[xx1-1][1+yy1]==ico) {
				xx1--;
				yy1++;
				chesscount++;
			}
			else break;
		}
		while(true){
			if (xx2<21 && yy2>0 && board[1+xx2][yy2-1]==ico) {
				xx2++;
				yy2--;
				chesscount++;
			}else{ max=max>chesscount?max:chesscount;  break;}
		}
		return max;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}