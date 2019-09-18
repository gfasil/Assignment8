package HWL8.q2;

public class MyStringList{
	private final int INITIAL_LENGTH = 4;
	private Person[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new Person[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(Person s){
		if(size == strArray.length) resize();
		strArray[size++] = s;
	}
	
	public Person get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return strArray[i];
	}
	
	public boolean find(String lname){
		for(Person test : strArray){
			
			if(test!=null) {
			if(test.getLast().equals(lname)) return true;
		}}
		return false;
	}
	
	public void insert(Person s, int pos){
		if(pos > size) return;
		if(pos >= strArray.length||size+1 > strArray.length) {
			resize();
		}
		Person[] temp = new Person[strArray.length+1];
		System.arraycopy(strArray,0,temp,0,pos);
		temp[pos] = s;
		
		System.arraycopy(strArray,pos,temp,pos+1, strArray.length - pos);
		strArray = temp;
		++size;
		
	}
	
	public boolean remove(Person s){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(strArray[i].equals(s)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		Person[] temp = new Person[strArray.length];
		System.arraycopy(strArray,0,temp,0,index);
		System.arraycopy(strArray,index+1,temp,index,strArray.length-(index+1));
		strArray = temp;
		--size;
		return true;
	}
	
	
	private void resize(){
		System.out.println("resizing");
		int len = strArray.length;
		int newlen = 2*len;
		Person[] temp = new Person[newlen];
		System.arraycopy(strArray,0,temp,0,len);
		strArray = temp;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size-1; ++i){
			sb.append(strArray[i]+", ");
			System.out.println();
		}
		sb.append(strArray[size-1]+"]");
		return sb.toString();
	}
	public int size() {
		return size;
	}

	public void minSort(){
		if(strArray == null || size<=1) return;
		
		for(int i = 0; i < size; ++i){
			int nextMinPos = minpos(i);
			swap(i,nextMinPos); 
		}
		
	}
	void swap(int i, int j){
		Person temp = strArray[i];
		strArray[i] = strArray[j];
		strArray[j] = temp;
		
	}
	//find minimum of arr between the indices bottom and top
	public int minpos(int bottom){		
		Person min = strArray[bottom];
		int index = bottom;
		for(int i = bottom+1; i <= size-1; ++i){
			if(strArray[i].getLast().compareTo(min.getLast())<0){ 
				min = strArray[i];
				index = i;
			}
		}
		//return location of min, not the min itself
		return index;
	}
	public boolean search(Person val) {
		
	return recurse(0,size-1,val);
			
	}

	
	boolean recurse(int a, int b, Person val) {
		
		if(val==null) return false;
		
		int mid = (a+b)/2;
		if(strArray[mid]!=null) {
		if(strArray[mid].equals(val)) return true;
		if(a > b) return false;
		if((val.getLast().compareTo(strArray[mid].getLast())>0)) return recurse(mid+1, b, val);
	}
		return recurse(a,mid-1,val);
	}


	public static void main(String[] args){
		MyStringList l = new MyStringList();
		
		l.add(new Person("Jhon","Doe",17));
		l.add(new Person("Apple","Bee",20));
		l.add(new Person("Mac","Donalds",22));
		
		
		
		System.out.println(l);
		System.out.println("\n found?"+l.find("Jon"));
		
		
		l.insert(new Person("Abate","robel",90 ) ,3);
		System.out.println(l);
		Person person2=l.get(3);
		System.out.println(person2);
		System.out.println(l.size);
		
		System.out.println();
		l.insert(new Person("abate","robel",80 ) ,4);
		System.out.println(l);
		
		Person person3=l.get(4);
		System.out.println("using get method"+ person3);
		
		System.out.println(l.size);
		
		l.remove(person3);
		System.out.println("\n"+l);
		
		l.minSort();
		System.out.println("\n"+l);
		
		boolean x=l.search(person2);
		System.out.println("\n"+x);
		
		
	}

}

