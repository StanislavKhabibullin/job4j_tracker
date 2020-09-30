package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
    users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        Optional<User> result = users.keySet().stream().
                filter(x -> x.getPassport().equals(passport)).findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
         /*   for (User name:users.keySet()
                 ) {
                if (name.getPassport().equals(passport)) {
                    return name;
                }
            }
        return null; */
        }

        public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Optional<Account> result = users.get(user).stream().
                filter(x -> x.getRequisite().equals(requisite)).
                findFirst();
            if (result.isPresent()) {
                return result.get();
            } else {
                return null;
            }
        /*
        if (user != null) {
            for (Account find:users.get(user)
                 ) {
                if (find.getRequisite().equals(requisite)) {
                    return find;
                }
            }
        }
        return null; */
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

