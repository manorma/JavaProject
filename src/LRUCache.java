import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
//If the required page is not in the memory, we bring that in memory. In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.
public class LRUCache {
    private int csize;
    private List<Integer> dq;
    private Map<Integer,List<Integer>> map;
    LRUCache(int size){
        this.csize = size;
        dq = new ArrayList<>();
        map = new HashMap<>();
    }

    private void refer(int page){

        //page not present in map
        if(map.get(page) == null){
            //queue size is full
            System.out.println("size is full "+page);
            if(dq.size() == csize){
                int key = dq.get(0);
                dq.remove(0);
                map.remove(key);

            }
        }
        else {
            System.out.println("page is in memory "+page);
            List<Integer> dqref = map.get(page);
            dq.remove(dqref.indexOf(page));
        }
        dq.add(page);
        map.put(page,dq);

    }


    private void display(){
        for(int i=0;i<dq.size();i++){
            System.out.print(dq.get(i));
        }

        System.out.print("\n");
    }




    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);
        lruCache.display();
        lruCache.refer(2);
        lruCache.display();
        lruCache.refer(3);
        lruCache.display();
        lruCache.refer(1);
        lruCache.display();
        lruCache.refer(4);
        lruCache.display();
        lruCache.refer(5);
        lruCache.display();


    }
}
