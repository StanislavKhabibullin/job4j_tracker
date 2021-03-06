package ru.job4j.hash;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

   @SuppressWarnings({"checkstyle:EqualsHashCode", "checkstyle:EmptyLineSeparator"})
  @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (name == null ? 0 : name.hashCode());
        result = 37 * result + children;
        result = 37 * result + birthday.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        Map<User, Object> mappy = new HashMap<>(2);
        User user1 = new User("Fill", 2, new GregorianCalendar(1980, Calendar.JANUARY, 12));
        User user2 = new User("Fill", 2, new GregorianCalendar(1980, Calendar.JANUARY, 12));
        User user3 = new User("Fill", 2, new GregorianCalendar(1980, Calendar.JANUARY, 12));
        mappy.put(user1, 1);
        mappy.put(user2, 2);
        mappy.put(user2, 1);
        var collect = user1.hashCode();
        System.out.println("collect = " + collect);
        mappy.entrySet().stream().forEach(t -> System.out.println("key = " + t.getKey() + "value = " + t.getValue()));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
