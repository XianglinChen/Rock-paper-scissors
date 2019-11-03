package xlchen;

import java.util.Scanner;

public class Game {
	private Player player;
	
	public Game(Player player){
		this.player = player;
	}
	
	/**
	 * ��ʼ
	 */
	public void start(){
		System.out.println("��ʼ��Ϸ");
		System.out.println(player.getName()+"��������Ϸ!" + "���Ի���" + player.getScore());
		String[] arr = new String[]{"����","ʯͷ","��"};
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������ʯͷ���������е�һ����");
		while(true){
			String s1 = sc.next();//��ҵ�����
			if(filter(s1) == 0){
				System.out.println("������������������ʯͷ���������е�һ����");
				continue;
			}
			if(filter(s1) == -1){
				System.exit(1);
			}
			int count = (int)(Math.random()*3);
			String s2 = arr[count];
			int flag = rule(s1,s2);
			System.out.println("�������"+s1+","+"���Գ�����"+s2);
			if(flag > 0){
				System.out.println("��ϲ"+player.getName() + "Ӯ���˽���10��");
				player.setScore(player.getScore() + 10);
				System.out.println("Ŀǰ����" + player.getScore());
			}else if(flag < 0){
				System.out.println("�ź�"+player.getName() + "�۳��˽���10��");
				player.setScore(player.getScore() - 10);
				System.out.println("Ŀǰ����" + player.getScore());
			}else{
				System.out.println("��ƽ�ˣ�");
			}
		}
	}
	
	/**
	 * ����
	 * @param s
	 * @return
	 */
	public int filter(String s){
		if(s.equals("����")||s.equals("ʯͷ")||s.equals("��")){
			return 1;
		}else if(s.equals("exit")){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * ��Ϸ����
	 * @return
	 */
	public int rule(String s1, String s2){
		if(s1.equals(s2)){
			return 0;
		}
		if(s1.equals("����")){
			 if(s2.equals("ʯͷ")){
				 return -1;
			 }
			 if(s2.equals("��")){
				 return 1;
			 }
		}
		if(s1.equals("ʯͷ")){
			if(s2.equals("����")){
				return 1;
			}
			if(s2.equals("��")){
				return -1;
			}
		}
		if(s1.equals("��")){
			if(s2.equals("ʯͷ")){
				return 1;
			}
			if(s2.equals("��")){
				return -1;
			}
		}
		return 0;
	}
}
