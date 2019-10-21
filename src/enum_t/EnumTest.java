package enum_t;

public class EnumTest {



    public enum UserInfo{
        NAME("Manorma","Mini"),
        ID("123","555"),
        Mobile("58904860","1234556"),
        Pincode("560097","846007");

        private String type1,type2;
        UserInfo(String type1,String type2){
            this.type1= type1;
            this.type2 = type2;
        }

        public String getType1() {
            return type1;
        }

        public String getType2(){
            return type2;
        }

    }


    public enum EmployeeType{
        MANAGER("manager"),
        EXECUTIVE("executive"),
        STAFF("staff");

        private String value;
        EmployeeType(String val){
            value = val;
        }

        //override toString if you want to return some other value thean name
        @Override
        public String toString() {
            return value;
        }

    }

    public static void main(String[] args){
        System.out.println(UserInfo.NAME.getType1());
        System.out.println(UserInfo.Mobile.getType2());
        System.out.println(EmployeeType.MANAGER.toString()+ " "+EmployeeType.MANAGER.name());
        for (UserInfo userInfo :UserInfo.values()){
            System.out.println(userInfo.type1+" "+userInfo.type2);
        }


    }
}
