package com.example.Sport.bean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Body {
    ALLBODY(1, "ALLBODY"),
    UPPER(2, "UPPER"),
    BOTTOM(3, "BOTTOM"),
    PRESS(4, "PRESS"),
    DEFAULT(5, "DEFAULT");

    public  int id;

    public String body;

    public static Body getById(int id) {
        for(Body e : values()) {
            if(e.id == id) return e;
        }
        return DEFAULT;
    }
}


