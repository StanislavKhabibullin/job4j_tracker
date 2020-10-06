package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
    users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> optionalUser = Optional.ofNullable(users.keySet().stream().
                filter(x -> x.getPassport().equals(passport)).findFirst().orElse(null));
        return optionalUser;

         /*   for (User name:users.keySet()
                 ) {
                if (name.getPassport().equals(passport)) {
                    return name;
                }
            }
        return null; */
        }

        public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (!user.isPresent()) {
            return null;
        }
        Optional<Account> result = Optional.of(users.get(user.get()).stream().
                filter(x -> x.getRequisite().equals(requisite)).
                findFirst().orElse(null));
           return result;
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
        Optional<Account> source = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (source.isPresent() && dest.isPresent()) {
            if (source.get().isBalance() >= amount) {
                source.get().setBalance(source.get().isBalance() - amount);
                dest.get().setBalance(dest.get().isBalance() + amount);
                return true;
            }

        }
        return rls;
        }
    }

