
public class Dog extends Animal {
    private String breed;
    
    protected int example;
    
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
    
    
    
}
