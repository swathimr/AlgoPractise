import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class Java8Practise {

  public static void main(String[] args) {
    forEach();
    mapSample();
  }

  public static void forEach() {

    HashMap test = new HashMap();
    test.put("1",0);
    test.put("yeah",30);
    test.put("poland", 50);

    System.out.println("Printing Map");
    test.forEach((key,value)->
      System.out.println(key)
    );

    System.out.println("Printing List");
    List<String> names = Arrays.asList("Larry", "Steve", "James");
    names.forEach(System.out::println);

  }

  public static void mapSample()
  {
    Map<String, Integer> map = new HashMap<>();
      map.put("Java", 0);
      map.put("Jakarta", 0);
      map.put("Eclipse", 0);

      String text = "Java Jakarta Eclipse22";

    System.out.println("Compute If Present");
      for(String word:text.split(" ")){
      map.computeIfPresent(word, (String key, Integer value)-> ++value);
      }

      map.forEach((key,value)-> System.out.println(key+"::"+value));

  }


  /**
   * map,filter, flatmap, sorted,peek,limit, collect, builder
   */
  public static void stream(){

  }


}
