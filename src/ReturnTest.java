public class ReturnTest {

    public static void checkReturn(){
        int i = 1,j=2;
        if(i>0){
            if(j>1){
                System.out.println("j="+j);
                return;
            }
            System.out.println("i ="+i);
        }
        System.out.println("i= "+i+"j= "+j);

    }

    public static void main(String[] args){
        checkReturn();
    }
}
