package org.example.allnewfeaturesinjava9.collectionfactorymethods;

import java.util.HashSet;
import java.util.Set;

public class SetFactoryDemo {
    public static void run(){
        IO.println("========== Set.of() ==========");
        Set<String> roles = new HashSet<>(Set.of("ADMIN", "MANAGER", "USER"));
        IO.println("Roles: " + roles);
        IO.println("Contains ADMIN: " + roles.contains("ADMIN"));
        IO.println("Number of roles: " + roles.size());
        try {
            roles.add("GUEST");
        }catch (UnsupportedOperationException e){
            IO.println("Exception: " + e.getMessage());
        }
        Set<String> mutableRoles = new HashSet<>(roles);
        mutableRoles.add("OWNER");
        IO.println("Mutable Roles: " + mutableRoles);
    }
}
