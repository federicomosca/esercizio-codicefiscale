package it.federicomosca.codicefiscale.DTO;

import java.time.LocalDate;

public class Person {

    private LocalDate birthday;
    private int age;

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
}
