package dev.sstrunin.questGame.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class User {
    private String username;
    @Setter
    private int level;

    public User(String username) {
        this.username = username;
        this.level = 0;
    }

}
