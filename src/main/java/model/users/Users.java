package model.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

    public Users() {
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", username=" + username +
                ", email=" + email +
                ", address=" + address +
                ", phone=" + phone +
                ", website=" + website +
                ", company=" + company +
                "}";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public Users(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

}
