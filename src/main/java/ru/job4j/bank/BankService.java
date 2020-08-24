package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
    if (!users.containsKey(user)) {
        users.put(user, new ArrayList<Account>());
    }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (findByPassport(passport) != null) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
            for (User name:users.keySet()
                 ) {
                if (name.getPassport().equals(passport)) {
                    return name;
                }
            }
        return null;
        }

        public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account find:users.get(user)
                 ) {
                if (find.getRequisite().equals(requisite)) {
                    return find;
                }
            }
        }
        return null;
        }

        public boolean transferMoney(String srcPassport, String srcRequisite,
                                     String destPassport, String destRequisite, double amount) {
            boolean rls = false;
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (source != null && dest != null) {
            if (source.isBalance() >= amount) {
                source.setBalance(source.isBalance() - amount);
                dest.setBalance(dest.isBalance() + amount);
                return true;
            }

        }
        return rls;
        }
    }
