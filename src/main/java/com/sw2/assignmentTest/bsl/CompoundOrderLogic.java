package com.sw2.assignmentTest.bsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.springframework.stereotype.Service;
import com.sw2.assignmentTest.models.CompoundOrder;
import com.sw2.assignmentTest.models.CompoundOrderItem;
import com.sw2.assignmentTest.models.Customer;
import com.sw2.assignmentTest.models.Order;
import com.sw2.assignmentTest.models.Product;

@Service
public class CompoundOrderLogic {
    public static List<CompoundOrder> CompoundOrderData = new ArrayList<>();

    public static List<CompoundOrder> getCompoundOrderData() {
        return CompoundOrderData;
    }
    public static String MakeCompundOrder(CompoundOrder compoundOrder){

    CompoundOrderData.add(compoundOrder);
    /*System.out.println("...................................");
    System.out.println(compoundOrder.orderedProducts.get(0).orderedProducts.orderedProducts.get(0).getPrice());
     System.out.println("...................................");*/
    List<CompoundOrderItem> AllCoumpoundOrder=compoundOrder.orderedProducts;
    /*System.out.println("...................... customers.............");
    System.out.println(CustomerLogic.Customers.get(0).name);
     System.out.println("...................................");*/
    for(Customer c : CustomerLogic.Customers){
      for(CompoundOrderItem it:AllCoumpoundOrder)
      {
if(Objects.equals(c.getName(), it.productOwner)){


        Random random = new Random();
        int fees = random.nextInt(10) + 1;
        int totalsum=fees+CalcTotalSum(it.orderedProducts);

                if(c.getBalance()-totalsum<0)
                {
                    return "not enough Balance for user";
                }
                c.setBalance(c.getBalance()-totalsum);
                
            }
      }
            
        }
        
        return "Order Done Successfully";
    }

    private static int CalcTotalSum(Order order)
    {
        int sum=0;

        for(Integer itemserial : order.orderedProducts){
            
                sum+=ProductLogic.getProduct(itemserial).getPrice();
            
        }

        return sum;

    }
    
}
