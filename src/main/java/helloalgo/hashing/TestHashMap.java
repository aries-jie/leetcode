package helloalgo.hashing;

public class TestHashMap {

    public static void main(String[] args) {
        HashMapChaining hashMap = new HashMapChaining();

        hashMap.put(4, "a");
        hashMap.put(5, "b");
        hashMap.put(6, "c");
        hashMap.put(7, "d");
        hashMap.put(8, "e");
        hashMap.put(9, "f");

        hashMap.remove(10);
        hashMap.remove(8);

        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(6));
        System.out.println(hashMap.get(7));
        System.out.println(hashMap.get(8));
        System.out.println(hashMap.get(9));
    }
}
