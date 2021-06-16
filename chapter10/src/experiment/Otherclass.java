package experiment;

import experiment.ExampleWithInnerClass.InnerClass;

public class Otherclass {
    public static void main(String[] args) {
        InnerClass object = new ExampleWithInnerClass().createObject();
        object.run();
    }
}
