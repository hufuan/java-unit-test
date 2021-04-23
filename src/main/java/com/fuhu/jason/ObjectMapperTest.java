package com.fuhu.jason;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ObjectMapperTest {

    static private void test1(ObjectMapper mapper ) {
        System.out.println("1.对象转json字符串");
        User user=new User();
        try {
            String userJson = mapper.writeValueAsString(user);
            System.out.println("userJson = " + userJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        userJson = {"name":"unknow","password":123456}
         */
    }
    static private void test2(ObjectMapper mapper ) {
        System.out.println("2.Map转json字符串");
        Map map=new HashMap<Integer, User>();
        map.put(1,new User("lisi", 11111));
        map.put(2,new User("zhangsan", 2222));
        try {
            String outputStr=mapper.writeValueAsString(map);
            System.out.println("outputStr = " + outputStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        outputStr = {"1":{"name":"lisi","password":11111},"2":{"name":"zhangsan","password":2222}}
         */
    }

    static private void test3(ObjectMapper mapper ) {
        System.out.println("数组list转json字符串");
        List list=new ArrayList<User>();
        list.add(new User("lisi", 11111));
        list.add(new User("zhangsan", 2222));
        try {
            String outputStr=mapper.writeValueAsString(list);
            System.out.println("outputStr = " + outputStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        outputStr = [{"name":"lisi","password":11111},{"name":"zhangsan","password":2222}]

         */
    }
    static private void test4(ObjectMapper mapper ) {
        System.out.println("json字符串转对象");
        try {
            String expected = "{\"name\": \"zhangsan\", \"password\": 789}";
            User user = mapper.readValue(expected, User.class);
            System.out.println("user:" + user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        user:User{name='zhangsan', password=789}
         */
    }

    //{"1":{"name":"lisi","password":11111},"2":{"name":"zhangsan","password":2222}}
    static private void test5(ObjectMapper mapper ) {
        System.out.println("json字符串转Map");

        Map map3= new HashMap<>();
        Object obj1 = map3;
        Map<Integer, User> userMap1=map3;
        map3 = userMap1;
        Object obj2 = userMap1;
        userMap1.put(1,new User());
        try {
            String expected = "{\"1\":{\"name\":\"lisi\",\"password\":1.5},\"2\":{\"name\":\"zhangsan\",\"password\":2222}}";
            Map<Integer, User> userMap = mapper.readValue(expected, Map.class);
            System.out.println("userMap size" + userMap.size());
            for (Map.Entry<?, ?> entry: userMap.entrySet()) {
                System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
                System.out.println("map key type: " + entry.getKey().getClass().getSimpleName() +
                        " map value: "  + entry.getValue().getClass().getSimpleName());
                //System.out.println("key:" + entry.getKey() + "class name:" + entry.getKey().getClass().getSimpleName() + "value: " + entry.getValue());

            }
            //System.out.println("userMap:" + userMap + "userMap" + userMap.get(1).getName());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        key: 1 value: {name=lisi, password=1.5}
map key type: String map value: LinkedHashMap
key: 2 value: {name=zhangsan, password=2222}
map key type: String map value: LinkedHashMap
         */
    }

    static private void test6(ObjectMapper mapper ) {
        System.out.println("json字符串转对象数组List<object>");
        try {
            String expected="[{\"name\":\"lisi\",\"password\":11111},{\"name\":\"zhangsan\",\"password\":2222}]";
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
            List<User> userList = mapper.readValue(expected, listType);
            //System.out.println("userMap:" + userMap + "userMap" + userMap.get(1).getName());
            System.out.println("userList:" + userList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        userList:[User{name='lisi', password=11111}, User{name='zhangsan', password=2222}]

         */
    }

    static private void test7(ObjectMapper mapper ) {
        System.out.println("json字符串转Map数组List<Map<String,Object>>");
        try {
            String expected="[{\"1\": {\"name\":\"lisi\",\"password\":11111} }, {\"2\": {\"name\":\"zhangsan\",\"password\":2222}}]";
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Map.class);
            List<Map<String,LinkedHashMap>> userMap = mapper.readValue(expected, listType);
            System.out.println("userList:" + userMap);
            Map<String,LinkedHashMap> map1 = userMap.get(1);
            LinkedHashMap user1 = map1.get("2");
            System.out.println("map1:" + map1);
            //System.out.println("user1:" + user1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        userList:[{1={name=lisi, password=11111}}, {2={name=zhangsan, password=2222}}]
map1:{2={name=zhangsan, password=2222}}
         */
    }

    static private void test8(ObjectMapper mapper ) {
        System.out.println("jackson默认将对象转换为LinkedHashMap：");
        try {
            String expected = "[{\"name\":\"Ryan\"},{\"name\":\"Test\"},{\"name\":\"Leslie\"}]";
            ArrayList arrayList = mapper.readValue(expected, ArrayList.class);
            System.out.println("arrayList:" + arrayList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        arrayList:[{name=Ryan}, {name=Test}, {name=Leslie}]
         */
    }
    //9 json字符串与list或map互转的方法
    static private void test9(ObjectMapper mapper ) {
        System.out.println("json字符串与list或map互转的方法");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //遇到date按照这种格式转换
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            objectMapper.setDateFormat(fmt);

            String preference = "{\"name\":\"hello\"}";
            //json字符串转map
            Map<String, String> preferenceMap = new HashMap<String, String>();
            preferenceMap = objectMapper.readValue(preference, preferenceMap.getClass());

            //map转json字符串
            String result=objectMapper.writeValueAsString(preferenceMap);
            System.out.println("result:" + result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        result:{"name":"hello"}
         */
    }
    //10.bean转换为map
    static private void test10(ObjectMapper mapper ) {
        System.out.println("json字符串与list或map互转的方法");
        try {
            List menuList=new ArrayList<User>();
            menuList.add(new User("lisi", 11111));
            menuList.add(new User("zhangsan", 2222));
             //用jackson将bean转换为map
            List<Map<String, String>> returnList=mapper.convertValue(menuList,new TypeReference<List<Map<String, String>>>(){});
            System.out.println("returnList:" + returnList);
            //Map<String, String> map1 = returnList.get(1);
            Map<?,?> map1 = returnList.get(1);
            for (Map.Entry<?, ?> entry: map1.entrySet())
            System.out.println("key: "+ entry.getKey().getClass().getSimpleName() + ": " + entry.getKey()  + " value: "+ entry.getValue().getClass().getSimpleName() + ": " + entry.getValue() );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        /*
        returnList:[{name=lisi, password=11111}, {name=zhangsan, password=2222}]
        key: String: name value: String: zhangsan
        key: String: password value: String: 2222
         */
    }
    static public void main(String argv[]) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //1.对象转json字符串
        //test1(mapper);
        //2.Map转json字符串
        //test2(mapper);
        //3.数组list转json字符串
        //test3(mapper);
        //4.json字符串转对象
        //test4(mapper);
        //5.json字符串转Map
        //test5(mapper);
        //6.json字符串转对象数组List<object>
        //test6(mapper);
        //7.7.json字符串转Map数组List<Map<String,Object>>
        //test7(mapper);
        //8jackson默认将对象转换为LinkedHashMap：
        //test8(mapper);
        //9.json字符串与list或map互转的方法
        //test9(mapper);
       // 10.bean转换为map
        test10(mapper);
    }

}
