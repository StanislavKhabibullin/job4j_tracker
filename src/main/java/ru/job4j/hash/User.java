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

   /*
  @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (name == null ? 0 : name.hashCode());
        result = 37 * result + children;
        result = 37 * result + birthday.hashCode();
        return result;
    }

  */

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        Map<User, Object> mappy = new HashMap<>();
        User user1 = new User();
        User user2 = new User();
        user1.setName("Fill");
        user1.setChildren(2);
        user1.setBirthday(new GregorianCalendar(1980, Calendar.JANUARY, 12));
        user2.setName("Fill");
        user2.setChildren(2);
        user2.setBirthday(new GregorianCalendar(1980, Calendar.JANUARY, 12));
        mappy.put(user1, 1);
        mappy.put(user2, 2);
        System.out.println(mappy);
    }
}
