package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
        
        if (this.name == null || this.name.isEmpty()){
            throw new IllegalArgumentException("Name does not exist");
        }
        
        if (this.name.length() > 40){
            throw new IllegalArgumentException("Name is too long");
        }
        
        if (this.age < 0 || this.age > 120){
            throw new IllegalArgumentException("Age not allowed");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
