package minh.interview;

public class AppleStockExample {

    public static void main(String[] args) {
        int[] stocks = {10, 7, 5, 8, 11, 9, 19};
        maxProfit(stocks);
        int[] ints = {10, 9, 8, 6, 3};
        maxProfit(ints);
    }

    public static int maxProfit(int[] stocks) {
        // array need to have at least 2 elements
        if (stocks.length < 2) {
            throw new IllegalArgumentException("input array has only 1 element");
        }

        int buyingPoint = 0;
        int sellingPoint = 1;
        int max_profit = stocks[1] - stocks[0];
        int tmpBuyingPoint = 0;

        for (int i = 1; i < stocks.length; i++) {
            int current_profit = stocks[i] - stocks[tmpBuyingPoint];
            // if profit is more, take it
            if (current_profit > max_profit) {
                sellingPoint = i;
                buyingPoint = tmpBuyingPoint;
                max_profit = current_profit;
            }

            // if next is less, make it as buying point
            if (stocks[i] < stocks[tmpBuyingPoint]) {
                tmpBuyingPoint = i;
            }

        }



        System.out.format("buy at: %d price: %d\n", buyingPoint, stocks[buyingPoint]);
        System.out.format("sell at: %d price: %d\n", sellingPoint, stocks[sellingPoint]);
        System.out.format("Max profit: %d\n", max_profit);
        return max_profit;
    }
}
