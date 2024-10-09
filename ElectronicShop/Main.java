package com.Surethan.ElectronicShop;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("**************************************************");
        System.out.println("*          WELCOME TO  ELECTRONICS Shop      *");
        System.out.println("*               Your Trusted Shop                *");
        System.out.println("**************************************************\n");

        String name = "SURETHAN";
        Customer1 c = null;
        Inventory1 inv = new Inventory1();
        Scanner sc = new Scanner(System.in);
        User u = new User();

        System.out.println("Enter 1 to continue...!");
        int o = sc.nextInt();
        while (o != 3) {
            System.out.println("\n⚙️  Please LOGIN to continue: ");
            System.out.print("👤 ENTER USERNAME: ");
            u.setUsername(sc.next() + sc.nextLine());
            System.out.print("🔑 ENTER PASSWORD: ");
            u.setPassword(sc.next() + sc.nextLine());
            String n = u.getUsername();

            if (n.equals(name)) {
                System.out.println("\n✔️  Login successful! Welcome, Admin!");
                int id;
                int opt;
                
                do {
                    System.out.println("\n================ MENU ==================");
                    System.out.println("1. ➕ ADD");
                    System.out.println("2. ✏️  UPDATE");
                    System.out.println("3. 🔍 SEARCH");
                    System.out.println("4. 🗑️  REMOVE");
                    System.out.println("5. 📋 SHOW");
                    System.out.println("6. 🚪 EXIT");
                    System.out.println("=========================================");
                    System.out.print("Please select an option: ");
                    opt = sc.nextInt();

                    switch (opt) {
                        case 1:
                            System.out.println("\n➕ ADDING a new product....");
                            c = new Customer1();
                            System.out.print("Enter Name: ");
                            c.setName(sc.next() + sc.nextLine());
                            System.out.print("Enter Quantity: ");
                            c.setQty(sc.nextInt());
                            System.out.print("Enter Price: ");
                            c.setPrice(sc.nextFloat());
                            System.out.print("Enter Brand: ");
                            c.setBrand(sc.next() + sc.nextLine());
                            inv.add(c);
                            System.out.println("✔️  Product added successfully!\n");
                            Thread.sleep(500); 
                            break;
                        case 2:
                            System.out.println("\n✏️  UPDATING product....");
                            System.out.print("Enter Product ID to update: ");
                            int Id = sc.nextInt();
                            c = new Customer1();
                            c.setId(Id);
                            System.out.print("Enter Updated Name: ");
                            c.setName(sc.next() + sc.nextLine());
                            System.out.print("Enter Updated Quantity: ");
                            c.setQty(sc.nextInt());
                            System.out.print("Enter Updated Price: ");
                            c.setPrice(sc.nextFloat());
                            inv.update(c);
                            System.out.println("✔️  Product updated successfully!\n");
                            Thread.sleep(500); 
                            break;
                        case 3:
                            try {
                                System.out.println("\n🔍 SEARCHING for a product....");
                                System.out.print("Enter Product ID to search: ");
                                id = sc.nextInt();
                                c = inv.search(id);
                                if (c != null) {
                                    System.out.println("================================");
                                    System.out.println("📄 ID: " + c.getId());
                                    System.out.println("👤 NAME: " + c.getName());
                                    System.out.println("📦 QTY: " + c.getQty());
                                    System.out.println("💲 PRICE: " + c.getPrice());
                                    System.out.println("🏷️  BRAND: " + c.getBrand());
                                    System.out.println("================================");
                                } else {
                                    throw new InvalidSeriesException();
                                }
                            } catch (InvalidSeriesException e) {
                                System.out.println("❌ " + e.getMessage());
                            }
                            break;
                        case 4:
                            System.out.println("\n🗑️  REMOVING product....");
                            System.out.print("Enter Product ID to remove: ");
                            id = sc.nextInt();
                            inv.remove(id);
                            System.out.println("✔️  Product removed successfully!\n");
                            Thread.sleep(500); 
                            break;
                        case 5:
                            System.out.println("\n📋 SHOWING all products....\n");
                            inv.show();
                            Thread.sleep(500); 
                            break;
                    }
                } while (opt != 6);
            } else {
                try {
                    if (c != null) {
                        System.out.println("\n📋 Showing product data....");
                        inv.show();
                    }
                } catch (NullPointerException e) {
                    System.out.println("❗ First, an Admin must login to access the system.");
                }
            }

            System.out.println("\nWould you like to continue? (1 for Yes, 3 for No)");
            o = sc.nextInt();
        }

        System.out.println("\n🚪 Exiting the system. Thank you for using My Electronics!");
    }
}
