package it.federicomosca.codicefiscale.DTO;

import java.time.LocalDate;

public class Person {

    private LocalDate birthday;
    private String age;
    
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    
}
