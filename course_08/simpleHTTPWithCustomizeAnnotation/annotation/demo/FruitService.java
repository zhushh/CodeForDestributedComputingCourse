package annotation.demo;

import java.util.HashMap;
import java.util.Map;

public class FruitService {
    Map<String, Fruit> fruits = new HashMap<String, Fruit>();
    public FruitService() {
        init();
    }

    @MyPath("/fruits/")
    public Fruit getFruit(@MyParam("name") String fruitName) {
        Fruit f = fruits.get(fruitName);
        return f;
    }

    public void init() {
        Fruit apple = new Fruit("apple", "red");
        Fruit banana = new Fruit("banana", "yellow");

        fruits.put("apple", apple);
        fruits.put("banana", banana);
    }
}
