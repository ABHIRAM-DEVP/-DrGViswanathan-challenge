import java.util.Arrays;
import java.util.PriorityQueue;

public class AUGUST232026{
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        class Entry{
            int capital, profit;
            Entry(int capital,int profit){
                this.capital=capital;
                this.profit = profit;
            }
        }
        PriorityQueue<Entry>minCapitalHeap = new PriorityQueue<>(
            (a,b)->Integer.compare(a.capital, b.capital) //ascending
        );
        for(int i=0; i<capital.length; i++){
            Entry entry = new Entry(capital[i], profits[i]);
            minCapitalHeap.offer(entry);
        }

        PriorityQueue<Entry>maxProfitHeap = new PriorityQueue<>(
            (a,b)->Integer.compare(b.profit, a.profit) //descending
        );

        for(int i=0; i<k; i++){
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w){
                Entry ent = minCapitalHeap.poll();
                maxProfitHeap.offer(ent);
            }
            if(maxProfitHeap.isEmpty()){
                break;
            }
            Entry bestEntry = maxProfitHeap.poll();
            w+= bestEntry.profit;
        }
        return w;
    }
}

//time complexity: O(N log N + K log N) — O(N log N)
//space complexity: O(N)