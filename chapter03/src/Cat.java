public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public int humanAge() {
        int age = getAge();
        int humanAge = 0;
        
        if(age == 1) {
            humanAge = 16;
        } else if(age == 2) {
            humanAge = 24;
        } else if(age > 2) {
            humanAge = 24 + (age - 2) * 4;
        }
        
        return humanAge;
    }

    public void makeSound() {
        System.out.println("...");
    }

}
