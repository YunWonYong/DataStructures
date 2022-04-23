package list;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Integer> list = new List<>();
		
		int index = 0;
		int range = 10;
		boolean flag = true;
		while(true) {
			if (flag && index < range) {
				list.add(++index);
			} else if (flag && index == range) {
				range = list.size();
				index = 0;
				flag = false;
			} else if (index < range) {
				System.out.println(list.get(index++));
			} else {
				System.out.println("끝");
				return;	
			}
		}
	}

}
