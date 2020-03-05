import java.util.*;


//When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
//If the required page is not in the memory, we bring that in memory. In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.
public class LRUCache {
    private int csize;
    private Queue<Integer> dq;
    private HashSet<Integer> map;
    LRUCache(int size){
        this.csize = size;
        dq = new LinkedList<>();
        map = new HashSet<>();
    }

    private void refer(int page){

        //page not present in map
        if(!map.contains(page)){
            //queue size is full
            if(dq.size() == csize){
                System.out.println("size is full "+page);
                int key = dq.remove();
                map.remove(key);

            }
        }
        else {
            System.out.println("page is in memory "+page);
            Iterator<Integer> iterator = dq.iterator();
            dq.remove(page);
            display();
        }
        dq.add(page);//add an element to head
        map.add(page);

    }


    private void display(){
        Iterator<Integer> iterator = dq.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
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
        lruCache.refer(1);
        lruCache.display();


    }
}
