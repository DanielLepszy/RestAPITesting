package model.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    public String name;
    public String catchPhrase;
    public String bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", catchPhrase=" + catchPhrase +
                ", bs=" + bs +
                "}";
    }
}
