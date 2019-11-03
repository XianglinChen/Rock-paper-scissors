package xlchen;

import java.util.Scanner;

public class Game {
	private Player player;
	
	public Game(Player player){
		this.player = player;
	}
	
	/**
	 * 开始
	 */
	public void start(){
		System.out.println("开始游戏");
		System.out.println(player.getName()+"进入了游戏!" + "初试积分" + player.getScore());
		String[] arr = new String[]{"剪刀","石头","布"};
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入剪刀、石头、布，其中的一个：");
		while(true){
			String s1 = sc.next();//玩家的输入
			if(filter(s1) == 0){
				System.out.println("输入错误！请输入剪刀、石头、布，其中的一个：");
				continue;
			}
			if(filter(s1) == -1){
				System.exit(1);
			}
			int count = (int)(Math.random()*3);
			String s2 = arr[count];
			int flag = rule(s1,s2);
			System.out.println("你出的是"+s1+","+"电脑出的事"+s2);
			if(flag > 0){
				System.out.println("恭喜"+player.getName() + "赢得了奖励10分");
				player.setScore(player.getScore() + 10);
				System.out.println("目前积分" + player.getScore());
			}else if(flag < 0){
				System.out.println("遗憾"+player.getName() + "扣除了奖励10分");
				player.setScore(player.getScore() - 10);
				System.out.println("目前积分" + player.getScore());
			}else{
				System.out.println("打平了！");
			}
		}
	}
	
	/**
	 * 过滤
	 * @param s
	 * @return
	 */
	public int filter(String s){
		if(s.equals("剪刀")||s.equals("石头")||s.equals("布")){
			return 1;
		}else if(s.equals("exit")){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 游戏规则
	 * @return
	 */
	public int rule(String s1, String s2){
		if(s1.equals(s2)){
			return 0;
		}
		if(s1.equals("剪刀")){
			 if(s2.equals("石头")){
				 return -1;
			 }
			 if(s2.equals("布")){
				 return 1;
			 }
		}
		if(s1.equals("石头")){
			if(s2.equals("剪刀")){
				return 1;
			}
			if(s2.equals("布")){
				return -1;
			}
		}
		if(s1.equals("布")){
			if(s2.equals("石头")){
				return 1;
			}
			if(s2.equals("布")){
				return -1;
			}
		}
		return 0;
	}
}
