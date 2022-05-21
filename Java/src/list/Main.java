package list;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		List<Integer> list = new List<>();
		
		int index = 0;
		int range = 2000;
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
