package ru.job4j.hash;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        user1.setName("Fill");
        user1.setChildren(2);
        user1.setBirthday(new GregorianCalendar(1980, Calendar.JANUARY, 12));
        user2.setName("Fillius");
        user2.setChildren(1);
        user2.setBirthday(new GregorianCalendar(1982, Calendar.MAY, 2));
        Map<User, Object> map = new Map<User, Object>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(User key, Object value) {
                return null;
            }

            @Override
            public Object remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends User, ?> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<User> keySet() {
                return null;
            }

            @Override
            public Collection<Object> values() {
                return null;
            }

            @Override
            public Set<Entry<User, Object>> entrySet() {
                return null;
            }
        };
        map.put(user1, 1);
        map.put(user2, 2);
        System.out.println(map);
    }
}
