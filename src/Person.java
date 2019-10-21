public class Person {

    public final String name;
    public final String id;
    public final String address;
    public final String phone;
    public final String company;

    private Person(String name,String id,String address,String phone,String company){
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.company = company;

    }

    @Override
    public String toString() {
        return "Person{name=" +this.name  + ", id="+this.id  + ",address=" + this.address  + ",phone=" +this.phone  + ",company=" +this.company +'}';
    }

    public static Person.Builder builder() {
        return new Person.Builder();
    }

    public static class Builder {
        private String name;
        private String id;
        private String address;
        private String phone;
        private String company;

        Builder(){
            this.company ="Resideo";
        }

        public Person.Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Person.Builder addId(String id) {
            this.id = id;
            return this;
        }

        public Person.Builder addAddress(String address) {
            this.address = address;
            return this;
        }

        public Person.Builder addPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person build(){
            return new Person(name,id,address,phone,company);
        }





    }

    public static void main(String[] args){
        //
            Person p = Person.builder()
                    .addName("Manorma Bharti")
                    .addPhone("8618799846")
                    .addId("H323034")
                    .addAddress("Thindlu Bengaluru")
                    .build();
            System.out.println(p.toString());
            Person p1 = new Person("Manorma","576777887","H#23HRI","Bihar","Honeywell");
            System.out.println(p1.toString());
        }
    }
