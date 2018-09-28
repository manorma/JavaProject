package Thread.proble;

import java.util.ArrayList;


public class StockBuySell {

    private void stockBuySell(int[] price,int l){

        if(l == 1){
            return;
        }
        int count =0;
        ArrayList<Interval> sol = new ArrayList<>();
        int i=0;
        while (i<l-1){
            //find local minima
            while(i<l-1 && price[i+1]< price[i] ){
                i++;
            }
            if(i == l-1){
                break;
            }
            //store the index of minima
            Interval interval = new Interval();
            interval.buy=i++;
            //find local maxima
            while(i<l && price[i] >= price[i-1]){
                i++;
            }
            interval.sell = i-1;
            sol.add(interval);
            count++;


        }
        if(count == 0){
            System.out.println("There is no day");
        }
        else {
            for(int j=0;j<count;j++){
                System.out.println("Buy on day "+sol.get(j).buy +"  "+"Sell on day:"+sol.get(j).sell);
            }
        }

    }



    public static void main(String[] args){
        int[] price={100, 180, 260, 310, 40, 535, 695};
        int len = price.length;
        StockBuySell stockBuySell = new StockBuySell();
        stockBuySell.stockBuySell(price,len);
    }

    class Interval{
        int buy,sell;
    }
}
