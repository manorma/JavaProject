
public class ReplaceString {


    public static void main(String[] args){
        String str = "xxxfoxxrxx";
        String old = "xx";
        String replacew="geeks";
        String res= replaceOldWithNew(str.toCharArray(),old.toCharArray(),replacew.toCharArray());
        System.out.println("Result string is "+res);
    }

    private static int substr(char[] str ,char[] old,int start){
        for(int i=start;i<str.length;i++){
            for(int j=0;j<old.length;j++){
                if(str[i+j] == old[j]){
                    if(j == old.length-1){
                        return i;
                    }
                }else{
                    break;
                }
            }
        }
        return -1;
    }
    private static String replaceOldWithNew(char[] str, char[] old, char[] replacew) {
        int countOld = 0, i=0;
        int lenOld = old.length;
        int lenNew = replacew.length;
        String res = null;
        while(i<str.length){
            int pos = substr(str,old,i);
            i= pos+lenOld;
            countOld++;

        }

        System.out.println("Count is "+countOld);
        StringBuilder stringBuilder = new StringBuilder();
        char[] result = new char[str.length+(lenNew -lenOld)*countOld];
        i=0;
        int j=0;
        while(i< str.length){
            if(substr(str,old,i) == i){
                System.out.println("pos is "+i);
                int k = 0;
               while(k<lenNew){

                   result[j] = replacew[k];
                   //System.out.println("result  "+j+result[j]+replacew[k]);
                   j++;
                   k++;
               }
               i =i+lenOld;
            }
            else {
                result[j++] = str[i++];
            }
        }

        String output = new String(result);
        //System.out.println("Result is "+output +output.length());

        return output;
    }
}
