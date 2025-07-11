package JavaCore_Sun;

public class Slide1 {
    public static void main(String[] args) {
        //Tao object Person
        Person p1 = new Person("Nam", 21, "Ha Noi");
        //Goi method introducted()
        p1.introduced();
    }
}
//Tao lop Person
class Person {
    public String name;    //khai bao bien va pham vi truy cap
    private int age;
    protected String address;

    //Ham khoi tao
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    //method introducted()
    public void introduced(){
        System.out.println("My name is: " + name + " I'm " + age + " year old and I'm living in " + address);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }
}

