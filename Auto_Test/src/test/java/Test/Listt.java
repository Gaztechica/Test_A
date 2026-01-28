package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Listt {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//
//        list.add("Sergey");
//        list.add("Anna");
//        list.add("Lusy");
//
//        System.out.println(list);
//
//        for (String lis : list){
//            System.out.println(lis);
//        }
//
//        list.remove(2);
//
//        System.out.println(list);
//
//
//        ArrayList<Integer> iList = new ArrayList<>();
//
//        iList.add(1);
//        iList.add(1);
//        iList.add(2);
//        iList.add(3);
//
//        System.out.println(iList);
//
//
//        HashSet<String> from = new HashSet<>();
//        from.add("11");
//        from.add("11");
//        from.add("22");
//        from.add("33");
//        System.out.println(from);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Sergey", 25);
        map.put("Igory", 29);
        map.put("Koly", 25);
        map.put("Sergey4", 65);
        System.out.println(map);
        System.out.println(map.get("Igory"));

        for (String age : map.keySet()) {
            System.out.println(map.get(age));
        }


//        анонимные функции
//                лямбды
//                        (параметр)-> выражение
        List<Integer> numb = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> evenNumb = numb.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumb);
    }
}
