package PkuJava38;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的y坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception 
	{
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				System.out.println("compu = "+computerPosArr[0]+"   "+ computerPosArr[1]);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		//获取用户下棋的坐标
		int xx= posX, yy = posY;
		/**
		*用户的棋子
		****/
		String client = Chessman.BLACK.getChessman();
		/**
		 * 计算机棋子
		 * */
		String computer = Chessman.WHITE.getChessman();
		String[][] board = chessboard.getBoard();
		int max = checkChessCount(xx, yy, client);
		//从人的一方考虑
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 22; j++) {
				if (board[i][j] == "十") {
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
		//从计算机的一方考虑
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 22; j++) {
				if (board[i][j] == "十") {
					int k = checkChessCount(i, j, computer);
					if (k>max1) {
						max1 = k;
						xx1 = i;
						yy1 = j;
					}
				}
			}
			
		}
		//自己胜利
		if (max1 >= max){
			int[] result = { xx1, yy1 };
			return result; 
		}
		//堵它，不让他胜利了
		else{
			int[] result = { posX, posY };
			return result;
		}
	}

	/**
	 * 判断输赢
	 * 
	 *	private final int WIN_COUNT = 5;
	 *	private int posX = 0;
	 *	private int posY = 0;
	 *	private Chessboard chessboard;
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型  "十"  BLACK("●"), WHITE("○");  
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。  
	 */
	public boolean isWon(int posX, int posY, String ico) {
		if (checkChessCount(posX, posY, ico)==5) {
			return true;
		}
		return false;
	}
	//棋子在0~21的范围内
	private int checkChessCount(int posX, int posY, String ico) {
		int chesscount=1;
		String[][] board = chessboard.getBoard();
		int max=0;//记录一个琪最多的连子数
		//四个方向检查棋盘
		//1水平方向
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
		//2竖直方向
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
		//3 左上方到右下方向
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
		//4 右上到左下方向
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