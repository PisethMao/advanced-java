package org.example.allnewfeaturesinjava8.map.hashmapcollision;

public class UserKey {
    private final int id;

    public UserKey(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserKey other)) {
            return false;
        }
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "UserKey{id=" + id + "}";
    }
}
