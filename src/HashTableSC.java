import java.util.LinkedList;

public class HashTableSC<T> {

	LinkedList<T>[] arr;
	
	@SuppressWarnings("unchecked")
	public HashTableSC(int size){
		arr = (LinkedList<T>[]) new LinkedList[size];
		for(int i = 0; i<arr.length; i++)
			arr[i] = new LinkedList<T>();
	}
	
	private int hash(T value){
		return Math.abs(value.hashCode())%arr.length;
	}
	
	public void insert(T value){
		int hashVal = hash(value);
		arr[hashVal].addFirst(value);
	}
	
	public void delete(T value){
		int hashVal = hash(value);
		if(arr[hashVal].contains(value)){
			arr[hashVal].remove(value);
			System.out.println(value + " deleted");
		}
		else
			System.out.println("element not in list");
	}
	
	public boolean find(T value){
		int hashVal = hash(value);
		return arr[hashVal].contains(value);
	}
	
	public boolean isEmpty(){
		for(LinkedList<T> list:arr)
			if(list.size() != 0)
				return false;
		return true;
	}
	
	public void print(){
		for(int i = 0; i<arr.length; i++){
			System.out.print(i + ":");
			for(T element:arr[i])
				System.out.print(" " + element.hashCode());
			System.out.println("\r");
		}
	}
}
