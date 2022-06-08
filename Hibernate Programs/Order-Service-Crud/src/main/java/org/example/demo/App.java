package org.example.demo;


import java.util.List;
import java.util.Scanner;

import org.example.demo.entity.OrderEntity;
import org.example.demo.service.OrderService;
import org.example.demo.service.OrderServiceImpl;


public class App 
{
    public static void main( String[] args )
    {
    	OrderService orderService = new OrderServiceImpl();	
    
    	try {
    		
    		Scanner scn=new Scanner(System.in);
    	       int ch=9999;
    	    System.out.println("Enter 1 for create Order");
    	    System.out.println("Enter 2 for All Orders");
    	    System.out.println("Enter 3 for Search Order");
    	    System.out.println("Enter 4 for Update Order");
    	    System.out.println("Enter 5 for Delete Order");
    	        while(ch!=0) {
    	       ch=scn.nextInt();
    	        switch(ch) {
    	        case 1:
    	        try {
    	        	System.out.println("Enter Order Name");
    	        	String name=scn.next();
    	        	orderService.createOrder(new OrderEntity(2, name));
    	        }
    	        catch(Exception e) {
    	        	System.err.println(e.getMessage());
    	        }
    	        break;
    	        case 2:
    	        
    	        	try {
    	        		 List<OrderEntity> list=orderService.getAllOrders(); 
    	        		 if(list.isEmpty())
    	        			 System.out.println("No Order is Placed");
    	        		 for(OrderEntity e:list) 
    	        		 {
    	        			  System.out.println(e);
    	        		 }
    	    			 
    	        	}
    	        	catch(Exception e) {
    	        		System.err.println(e.getMessage());
    	        	}
    	        break;
    	        case 3:
    	        	try {
    	        		System.out.print("Enter Order  Id :: ");
    	        		int id=scn.nextInt();
    	        		OrderEntity orderEntity=orderService.findOrderById(id);
    	        		if(orderEntity==null)
    	       			  {
    	        			System.out.println("order not found");
    	        		} 
    	        		else {
    	       			  
    	       			  System.out.println(orderEntity);
    	       			  }	
    	        	}
    	        	catch(Exception e)
    	        	{
    	        		System.err.println("Order not found u put a Wrong Id");
    	        	}
    	        	break;
    	        case 4:
    	        try {
    	        	System.out.print("Enter Order  Id :: ");
	        		int id=scn.nextInt();
	        		orderService.updateOrderByOrderId(id);
    	        	
    	        }
    	        catch(Exception e) {
    	        	System.err.println("Order not found u put a Wrong Id");
    	        }
    	        break;
    	        case 5:
    	        
    	        try {
    	        	System.out.print("Enter Order  Id :: ");
	        		int id=scn.nextInt();
    	        	orderService.deleteOrderById(id);
    	        }
    	        catch(Exception e)
    	        {
    	        	System.err.println("Order not found u put a Wrong Id");
    	        }
    	        break;
    	        default:
    	        System.out.println("Thank u For Using us.");
    	        }
    	        }
    	        scn.close();
    	}
        catch (Exception e){
        	e.printStackTrace();
        }
    }
}
