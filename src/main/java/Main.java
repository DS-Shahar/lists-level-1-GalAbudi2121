package Abudi;

import java.util.Scanner;

public class Abudi {
	public static Node<Integer> a(int[] a){
		Node<Integer> fr = new Node<Integer>(a[0]);
		Node<Integer> last = fr;
		for(int i=1;i<a.length;i++) {
			Node<Integer> x = new Node<Integer>(a[i]);
			last.setNext(x);
			last=x;
		}
		return fr;
	}
	public static Node<Integer> buildNode(int x, int y,int n) {
		Node<Integer> a = new Node<Integer>((int)(Math.random()*(x+y-1)+x));
		Node<Integer> last = a;
		for(int i=0;i<n-1;i++) {
			Node<Integer> k = new Node<Integer>((int)(Math.random()*(x+y-1)+x));
			last.setNext(k);
			last = k;
		}
		return a;
	}
	public static int count(Node<Integer> h, int x) {
		int count=0;
		while(h!=null) {
			if(x==h.getValue())
				count++;
			h = h.getNext();
		}
		return count;
	}
	public static void printList(Node<Integer> a) {
		while(a.getNext()!=null) {
			System.out.println(a.getValue());
			a = a.getNext();
		}
	}
	public static void printListRec(Node<Integer> a) {
		if(a==null)
			return;
		System.out.println(a.getValue());
		printListRec(a.getNext());
	}
	public static void printListRecRev(Node<Integer> a) {
		if(a==null)
			return;
		printListRecRev(a.getNext());
		System.out.println(a.getValue());
		
	}
	public static Node<Integer> inputList(){
		System.out.println("enter num or -1 to stop");
		Node<Integer> first = new Node<Integer>(null);
		Node<Integer> p = first;
		int num = reader.nextInt();
		Node<Integer> x;
		while(num!=-1) {
			x = new Node<Integer>(num);
			p.setNext(x);
			p=x;
			System.out.println("enter num or -1 to stop");
			num = reader.nextInt();
		}
		return first.getNext();
	}
	public static void printZogi(Node<Integer> a) {
		while(a!=null) {
			if(a.getValue()%2==0)
				System.out.println(a.getValue());
			a=a.getNext();
		}
	}
	public static boolean check(Node<Integer> h, int x) {
		while(h!=null) {
			if(x==h.getValue())
				return true;
			h = h.getNext();
		}
		return false;
	}
	public static boolean checkRec(Node<Integer> h, int x) {
		if(h==null) {
			return false;
		}
		if(h.getValue()==x)
			return true;
		return checkRec(h.getNext(),x);
			
	}
  public static Node<Integer> delete(int num, Node<Integer> h) {
	  	Node<Integer> x = h;
	  	Node<Integer> z = h;
	  	
        if(h.getValue()==num) {
        	return h.getNext();
        }
        while (h.getNext() != null) {
            if (h.getValue() == num) {
                z.setNext(h.getNext()); 
            } 
            z = h;
            h = h.getNext(); 
        }
        return x;
    }
  public static Node<Integer> deleteIndex(int num, Node<Integer> h) {
	  if(num == 1) {
		  return h.getNext();
	  }
	  Node<Integer> x = h;
	  for(int i = 2; i<=num; i++) {
		  if(i==num) {
			  h.setNext(h.getNext().getNext());
			  return x;
		  }
		  h = h.getNext();
	  }
	  return x;
  }
  public static boolean cmpRec(Node<Integer> L1, Node<Integer> L2, Node<Integer> save) {
	  	if(L1 == null) {
	  		return true;
	  	}
	  	if(L2 == null) {
	  		return false;
	  	}
	  	if(L1.getValue() == L2.getValue()) {
	  		return cmpRec(L1.getNext(),save,save);
	  	}
	  	return cmpRec(L1,L2.getNext(),save);
	}
  
  public static void nine(Node<Integer> L1,Node<Integer> L2) {
		Node<Integer> saveL2 = L2;
		while(L1!=null) {
			
			L2=saveL2;
			while(L2!=null) {
				if(L1.getValue()==L2.getValue())
					System.out.println(L1.getValue());
				L2=L2.getNext();
			}
			L1=L1.getNext();
		}
	}
  
  public static Node<Integer> ten(Node<Integer> L1, Node<Integer> L2) {
			Node<Integer> fir = new Node<Integer>(null);
			Node<Integer> d = fir;
			Node<Integer> saveL2 = L2;
			while(L1!=null) {
				
				L2=saveL2;
				while(L2!=null) {
					if(L1.getValue()==L2.getValue()) {
						Node<Integer> a = new Node<Integer>(L1.getValue());
						d.setNext(a);
						d=a;
					}
					L2=L2.getNext();
				}
				L1=L1.getNext();
			}
			return fir.getNext();
		}
  public static Node<Integer> q11(Node<Integer> L1, Node<Integer> L2) {
	  Node<Integer> saveL2 = L2;
	  Node<Integer> saveL1 = L1;
		while(L1!=null) {
			
			L2=saveL2;
			while(L2!=null) {
				if(L1.getValue()==L2.getValue())
				L1 = delete(L1.getValue(),saveL1);
				L2=L2.getNext();
			}
			L1=L1.getNext();
		}
		return L1;
	}
  
  	public static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		Node<Integer> rachel = buildNode(1,10,20);
		Node<Integer> eran = buildNode(1,10,20);
		System.out.println(rachel);
		System.out.println(eran);
		System.out.println(q11(rachel,eran));
		
	}

	}


