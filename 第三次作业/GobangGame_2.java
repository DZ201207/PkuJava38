package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	
	private boolean isFirst=true;
	//电脑上一步的X,Y；玩家上一步的X，Y
	private int cPrePosX;
	private int cPrePosY;
	private int pPrePosX;
	private int pPrePosY;
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
			pPrePosX = posX;
			pPrePosY = posY;
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
	public void start() throws Exception {
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

//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "十" ) {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
//		int[] result = { posX, posY };
//		return result;
		
//		String[][] board = chessboard.getBoard();
//		int [] result ={0,0};
//		int posX=1;
//		int posY=1;
//		//第一步下在中间位置（有四个），若被玩家占了，就换一个，我在这里任选了两个
//		if(isFirst==true){
//			if(board[11][11]=="十"){
//				posX = 11;
//				posY = 11;
//				cPrePosX=11;
//				cPrePosY=11;
//			}
//			else if(board[11][12]=="十") {
//				posX = 11;
//				posY = 12;
//				cPrePosX=11;
//				cPrePosY=12;
//			}
//			isFirst=false;
//		}
//		else{
//			int k=0;
//			int countBlank=0;
//			for(;k<=7;k++){
//				if(k==0){posX=cPrePosX+1;posY=cPrePosY;}
//				if(k==1){posX=cPrePosX-1;posY=cPrePosY;}
//				if(k==2){posX=cPrePosX;posY=cPrePosY+1;}
//				if(k==3){posX=cPrePosX;posY=cPrePosY-1;}
//				if(k==4){posX=cPrePosX+1;posY=cPrePosY+1;}
//				if(k==5){posX=cPrePosX+1;posY=cPrePosY-1;}
//				if(k==6){posX=cPrePosX-1;posY=cPrePosY+1;}
//				if(k==7){posX=cPrePosX-1;posY=cPrePosY-1;}
//				if(board[posX][posY] == "十") countBlank++;
//			}
//			
//			if(countBlank>=1){
//				k = (int) (Math.random()*7 );
//				if(k==0){posX=cPrePosX+1;posY=cPrePosY;}
//				if(k==1){posX=cPrePosX-1;posY=cPrePosY;}
//				if(k==2){posX=cPrePosX;posY=cPrePosY+1;}
//				if(k==3){posX=cPrePosX;posY=cPrePosY-1;}
//				if(k==4){posX=cPrePosX+1;posY=cPrePosY+1;}
//				if(k==5){posX=cPrePosX+1;posY=cPrePosY-1;}
//				if(k==6){posX=cPrePosX-1;posY=cPrePosY+1;}
//				if(k==7){posX=cPrePosX-1;posY=cPrePosY-1;}
//				while(board[posX][posY] != "十" )
//				{
//					k = (int) (Math.random()*7 );
//					if(k==0){posX=cPrePosX+1;posY=cPrePosY;}
//					if(k==1){posX=cPrePosX-1;posY=cPrePosY;}
//					if(k==2){posX=cPrePosX;posY=cPrePosY+1;}
//					if(k==3){posX=cPrePosX;posY=cPrePosY-1;}
//					if(k==4){posX=cPrePosX+1;posY=cPrePosY+1;}
//					if(k==5){posX=cPrePosX+1;posY=cPrePosY-1;}
//					if(k==6){posX=cPrePosX-1;posY=cPrePosY+1;}
//					if(k==7){posX=cPrePosX-1;posY=cPrePosY-1;}
//				}
//			}
//			else{
//				//在玩家下棋周围随机下
//				
//				int k2=0;
//				int countBlank2=0;
//				for(;k2<=7;k2++){
//					if(k2==0){posX=pPrePosX+1;posY=pPrePosY;}
//					if(k2==1){posX=pPrePosX-1;posY=pPrePosY;}
//					if(k2==2){posX=pPrePosX;posY=pPrePosY+1;}
//					if(k2==3){posX=pPrePosX;posY=pPrePosY-1;}
//					if(k2==4){posX=pPrePosX+1;posY=pPrePosY+1;}
//					if(k2==5){posX=pPrePosX+1;posY=pPrePosY-1;}
//					if(k2==6){posX=pPrePosX-1;posY=pPrePosY+1;}
//					if(k2==7){posX=pPrePosX-1;posY=pPrePosY-1;}
//					if(board[posX][posY] == "十") countBlank2++;
//				}
//				
//				if(countBlank2>=1){
//					while(board[posX][posY] != "十" )
//					{
//						k2 = (int) (Math.random()*7 );
//						if(k2==0){posX=pPrePosX+1;posY=pPrePosY;}
//						if(k2==1){posX=pPrePosX-1;posY=pPrePosY;}
//						if(k2==2){posX=pPrePosX;posY=pPrePosY+1;}
//						if(k2==3){posX=pPrePosX;posY=pPrePosY-1;}
//						if(k2==4){posX=pPrePosX+1;posY=pPrePosY+1;}
//						if(k2==5){posX=pPrePosX+1;posY=pPrePosY-1;}
//						if(k2==6){posX=pPrePosX-1;posY=pPrePosY+1;}
//						if(k2==7){posX=pPrePosX-1;posY=pPrePosY-1;}
//					}
//				}
//				//棋盘上随机下
//				else {
//					posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//					posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//					while (board[posX][posY] != "十" ) {
//						posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//						posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//					}
//				}
//			}
//			//越界处理
//			if(posX>(chessboard.BOARD_SIZE-1)||posY>(chessboard.BOARD_SIZE-1)||posX<0||posY<0){
//				posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//				posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//				while (board[posX][posY] != "十" ) {
//					posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//					posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//				}
//			}
//		}
//		result[0] = posX ;
//		result[1] = posY ;
//		cPrePosX=posX;cPrePosY=posY;
//		return result;
		
		//获取用户下棋的坐标
				int x= posX, y = posY;
				/**
				*用户的棋子
				****/
				String client = Chessman.BLACK.getChessman();
				/**
				 * 计算机棋子
				 * */
				String computer = Chessman.WHITE.getChessman();
				String[][] board = chessboard.getBoard();
				int max = checkCount(x, y, client);
				//从玩家周围的棋子考虑
				for (int i = 0; i < 22; i++) {
					for (int j = 0; j < 22; j++) {
						if (board[i][j] == "十") {
							int k = checkCount(i, j, client);
							if (k>max) {
								max = k;
								posX = i;
								posY = j;
							}
						}
					}
					
				}
				int max1 = 0;
				int x1=0,y1=0;
				//从电脑周围的棋子考虑
				for (int i = 0; i < 22; i++) {
					for (int j = 0; j < 22; j++) {
						if (board[i][j] == "十") {
							int k = checkCount(i, j, computer);
							if (k>max1) {
								max1 = k;
								x1 = i;
								y1 = j;
							}
						}
					}
					
				}
				//在自己的周围下棋
				if (max1 >= max){
					int[] result = { x1, y1 };
					return result; 
				}
				//在玩家的周围下棋
				else{
					int[] result = { posX, posY };
					return result;
				}
	}

	
	/**
	 * 记录棋子连子数
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型，黑白
	 * @return 最大连子数
	 */
	//四个方向检查棋盘		
	//棋子在0~21的范围内
		private int checkCount(int posX, int posY, String ico) {
		
			String[][] board = chessboard.getBoard();
			int max=0;//记录一个棋最多的连子数
			
			//直线起点和终点坐标
	        int startX=0;
	        int startY=0;
	        int endX=chessboard.BOARD_SIZE-1;
	        int endY=chessboard.BOARD_SIZE-1;
			

			
			//横向 
			int i1 = 1; // 用他来循环第几个棋子
			int count1 = 1; // 用它来计数有多少个棋子连起来
			//判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
			while (board[posX + i1][posY] == ico&&(posX+i1)<=endX)  {
				i1++;
				count1++;
			}
			while (board[posX - i1][posY] == ico&&(posX-i1)>=startX) {
				i1++;
				count1++;
			}
			max=max>count1?max:count1;
			
			 //纵向
	        int i2 = 1;  
	        int count2 = 1;
	      //判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
	       while(board[posX][posY + i2]==ico&&(posY+i2)<=endY){
	               i2++;
	               count2 ++;
	        }
	        while(board[posX][posY - i2]==ico&&(posY-i2)>=startY) {
	               i2++;
	               count2 ++;       
	       }
	        max=max>count2?max:count2;
	       
	       //斜上
	       int i3 = 1;
	       int count3 = 1;
	     //判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
	       while(board[posX + i3][posY - i3]==ico&&(posX+i3)<=endX&&(posY-i3)>=startY){
	               i3++;
	               count3 ++;
	        }
	        while(board[posX - i3][posY + i3]==ico&&(posX-i3)>=startX&&(posY+i3)<=endY) {
	               i3++;
	               count3 ++;       
	       }
	        max=max>count3?max:count3;
	       
	      //斜下
	       int i4 =1;
	       int count4 = 1;
	     //判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
	       while(board[posX + i4][posY + i4]==ico&&(posX+i4)<=endX&&(posY+i4)<=endY){
	               i4++;
	               count4 ++;
	        }
	        while(board[posX - i4][posY - i4]==ico&&(posX-i4)>=startX&&(posY-i4)>=startY) {
	               i4++;
	               count4 ++;       
	       }
	        max=max>count4?max:count4;
			return max;
		}
			
//			int xx1=posX,yy1=posY;
//			int xx2=posX,yy2=posY;
//			while(true){
//				if (yy1>0 && board[xx1][yy1-1]==ico) {
//					--yy1;
//					chesscount++;
//				}else break;
//			}
//			while(true){
//				if (yy2<21 && board[xx2][1+yy2]==ico) {
//					yy2++;
//					chesscount++;
//				}else{ max=max>chesscount?max:chesscount;  break;}
//			}
//			//2竖直方向
//			xx1=posX;yy1=posY;xx2=posX;yy2=posY;
//			chesscount=1;
//			while(true){
//				if (xx1>0 && board[xx1-1][yy1]==ico) {
//					xx1--;
//					chesscount++;
//				}
//				else break;
//			}
//			while(true){
//				if (xx2<21 && board[1+xx2][yy2]==ico) {
//					xx2++;
//					chesscount++;
//				}else{ max=max>chesscount?max:chesscount;  break;}
//			}
//			//3 左上方到右下方向
//			xx1=posX;yy1=posY;xx2=posX;yy2=posY;
//			chesscount=1;
//			while(true){
//				if (xx1>0 && yy1>0 && board[xx1-1][yy1-1]==ico) {
//					xx1--;
//					yy1--;
//					chesscount++;
//				}
//				else break;
//			}
//			while(true){
//				if (xx2<21 && yy2<21 && board[1+xx2][1+yy2]==ico) {
//					xx2++;
//					yy2++;
//					chesscount++;
//				}else{ max=max>chesscount?max:chesscount;  break;}
//			}
//			//4 右上到左下方向
//			xx1=posX;yy1=posY;xx2=posX;yy2=posY;
//			chesscount=1;
//			while(true){
//				if (xx1>0 && yy1<21 && board[xx1-1][1+yy1]==ico) {
//					xx1--;
//					yy1++;
//					chesscount++;
//				}
//				else break;
//			}
//			while(true){
//				if (xx2<21 && yy2>0 && board[1+xx2][yy2-1]==ico) {
//					xx2++;
//					yy2--;
//					chesscount++;
//				}else{ max=max>chesscount?max:chesscount;  break;}
//			}
		
	
	
	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型，黑白
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {

		boolean flag = false; // 一开始不赢
		//直线起点和终点坐标
        int startX=0;
        int startY=0;
        int endX=chessboard.BOARD_SIZE-1;
        int endY=chessboard.BOARD_SIZE-1;
		
		String[][] board = chessboard.getBoard();
		
		//横向 
		int i1 = 1; // 用他来循环第几个棋子
		int count1 = 1; // 用它来计数有多少个棋子连起来
		//判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
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
		} // 棋子>=5就赢了 flag为true

		 //纵向
        int i2 = 1;  
        int count2 = 1;
      //判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
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
		} // 棋子>=5就赢了 flag为true
       
       //斜上
       int i3 = 1;
       int count3 = 1;
     //判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
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
		} // 棋子>=5就赢了 flag为true
       
      //斜下
       int i4 =1;
       int count4 = 1;
     //判断是否是posX,posY同色的棋子，判断是否越界，若都符合条件则计数加1
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
		} // 棋子>=5就赢了 flag为true

		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
