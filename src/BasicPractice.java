import java.util.ArrayList;

public class BasicPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = true;
		
		System.out.println("Boolean value is: "+b);
		
		int[] arr = new int[2];
		arr[0]=12;
		arr[1]=14;
		
		int[] a = {1,2,0};
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		for (int i : a) {
			System.out.println(i);
		}
		
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
			
		}
		
		String[] strAr2 = {"Ani", "Sam", " Joe"}; 
		
		for (String string : strAr2) {
			System.out.println(string);
		}
		
		String[] strings = new String[2];
		strings[0]="abc";
		strings[1]="123";
		
		for (String string : strings) {
			System.out.println(string);
		}
		
		int[] a1 = {1,2,0,12,11,23,24};
		for (int i : a1) {
			if(i%2==0)
				System.out.println(i);
		}
		
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("Priya");
		arrList.add("Munu");
		for (String string : arrList) {
			System.out.println(string);
		}
		System.out.println(arrList.size());
		
		String s = "a b c d";
		String[] ar = s.split(" ");
				System.out.println(ar[2]);
		//Print reverse order	
		for(int i=s.length()-1; i>=0; i--) {
			System.out.println(s.charAt(i));
		}
		
	}

}
