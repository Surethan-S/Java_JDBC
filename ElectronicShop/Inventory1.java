package com.Surethan.ElectronicShop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Inventory1 {
	Statement stmt;
	ResultSet rs;
	String qty=null;
	ElectronicShopDB db= new ElectronicShopDB();
	Connection con;
	List<Customer1> list=new ArrayList();
	public void add(Customer1 c) {
		//list.add(c);
		try {
			con=db.getDBConnection();
		    stmt=con.createStatement();
		    int count = stmt.executeUpdate("insert into Customer(name,qty,price,brand) values('"+c.getName()+"','"+c.getQty()+"','"+c.getPrice()+"','"+c.getBrand()+"')");
		    System.out.println("Inserted Successfully");
		}
		catch(Exception e) {
		      System.out.println(e.getMessage());
		      }
		
	}
	public void show() {
		/*for(Customer1 c: list) {
			System.out.println("ID: "+c.getId());
			System.out.println("NAME: "+c.getName());
			System.out.println("QTY: "+c.getQty());
			System.out.println("PRICE: "+c.getPrice());
			System.out.println("Brand: "+c.getBrand());
		} */
		try {
		      con=db.getDBConnection();
		      stmt=con.createStatement();
		      rs=stmt.executeQuery("select * from customer");
		      while(rs.next())
		      System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
		      }
		      catch(Exception e) {
		      System.out.println(e.getMessage());
		      }
	}
	public Customer1 search(String id) {
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				return list.get(i);
			}
		}
		return null;
	}
	public void update(Customer1 c) {
		try {
			con=db.getDBConnection();
		    stmt=con.createStatement();
		    int count = stmt.executeUpdate("Update customer set name='"+c.getName()+"',qty="+c.getQty()+",price="+c.getPrice()+" where Id="+c.getId());
		    System.out.println("Updated Successfully");
		    }
		catch(Exception e) {
		      System.out.println(e.getMessage());
		      }
	}
	public void remove(String id) {
		/*for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				list.remove(i);
			}
		} */
		try {
			con=db.getDBConnection();
		    stmt=con.createStatement();
		    int count = stmt.executeUpdate("delete from customer where Id="+id);
		    System.out.println("Deleted Successfully");
		}
		catch(Exception e) {
		      System.out.println(e.getMessage());
		      }
	}
}
