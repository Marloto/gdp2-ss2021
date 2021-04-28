public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public boolean equals(Object obj) {
        if(obj instanceof Dog) {
            Dog dog = (Dog) obj;
            return super.equals(obj) &&
                    this.breed.equals(dog.breed);
        }
        
        return false;
    }
    
    public void makeSound() {
        System.out.println("Wuff!");
    }
    
    public int humanAge() {
        int age = getAge();
        int humanAge = 0;
        
        if(age == 1) {
            humanAge = 14;
        } else if(age == 2) {
            humanAge = 22;
        } else if(age > 2) {
            humanAge = 22 + (age - 2) * 5;
        }
        
        return humanAge;
    }

}
