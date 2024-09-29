package com.Surethan.ElectronicShop;
import com.Surethan.ElectronicShop.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		String name="SURETHAN";
		Customer1 c=null;
		Inventory1 inv=new Inventory1();
		Scanner sc=new Scanner(System.in);
		User u=new User();
		System.out.println("Enter 1 to continue...!");
		int o=sc.nextInt();
		do {
			System.out.println("ENTER USERNAME: ");
			u.setUsername(sc.next()+sc.nextLine());
			System.out.println("ENTER PASSWORD: ");
			u.setPassword(sc.next()+sc.nextLine());
		    String n=u.getUsername();
		
		if(n.equals(name)) {
		String id;
		System.out.println("1.ADD\n2.UPDATE\n3.SEARCH\n4.REMOVE\n5.SHOW\n6.EXIT");
		int opt=sc.nextInt();
		do {
			switch(opt) {
			case 1:
				System.out.println("ADDING....");
				c=new Customer1();
				c.setName(sc.next()+sc.nextLine());
				//c.setId(sc.next()+sc.nextLine());
				c.setQty(sc.nextInt());
				c.setPrice(sc.nextFloat());
				c.setBrand(sc.next()+sc.nextLine());
				inv.add(c);
				break;
			case 2:
				System.out.println("UPDATING....");
				//id=sc.next()+sc.nextLine();
				//c=inv.search(id);
				int Id=sc.nextInt();
				c=new Customer1();
				c.setId(Id);
				c.setName(sc.next()+sc.nextLine());
				c.setQty(sc.nextInt());
				c.setPrice(sc.nextFloat());
				inv.update(c);
				break;
			case 3:
				try {
					System.out.println("SEARCHING....");
					id=sc.next()+sc.nextLine();
					c=inv.search(id);
					if(c!=null) {
					System.out.println("ID: "+c.getId());
					System.out.println("NAME: "+c.getName());
					System.out.println("QTY: "+c.getQty());
					System.out.println("PRICE: "+c.getPrice());
					System.out.println("Brand: "+c.getBrand());
					}
					else {
						throw new InvalidSeriesException();
					}
					} catch(InvalidSeriesException e){
						System.out.println(e.getMessage());
					}
					break;
			case 4:
				System.out.println("REMOVING....");
				id=sc.next()+sc.nextLine();
				inv.remove(id);
				break;
			case 5:
				System.out.println("SHOWING....");
				inv.show();
				break;
			}
			System.out.println("1.ADD\n2.UPDATE\n3.SEARCH\n4.REMOVE\n5.SHOW\n6.EXIT");
			opt=sc.nextInt();
		}while(opt!=6);
		}
		else {
			try { 
				if(c.toString()!=null) {
					System.out.println("SHOWING....");
					inv.show();
				}
			} catch(NullPointerException e) {
				System.out.println("1st Admin want's to login!");
			}
			
		}
		System.out.println("Want to continue...?");
		o=sc.nextInt();
		}while(o!=3);
		}
	}
