//package Pattern.FlyweightPattern.Recode;
//
//import Pattern.FlyweightPattern.Designed.ConcreteFlyweight;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class FlyweightFactory {
//    private Map<String, Flyweight> fsMap = new HashMap<>();
//
//    public Flyweight getFlyweight(String key) {
//        Flyweight flyweight = fsMap.get(key);
//
//        if (flyweight == null) {
//            flyweight = new ConcreteFlyweight(key);
//
//            fsMap.put(key, flyweight);
//        }
//        return flyweight;
//    }
//}
