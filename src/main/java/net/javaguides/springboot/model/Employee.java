package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity(name = "Employee")
@Table(name = "employee",
        uniqueConstraints = {
        @UniqueConstraint(name = "employee_email_unique", columnNames = "email")
})
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "main_image", nullable = true)
    private String mainImage;

    @Column(name = "extra_image1", nullable = true)
    private String extraImage1;

    @Column(name = "extra_image2", nullable = true)
    private String extraImage2;

    @Column(name = "extra_image3", nullable = true)
    private String extraImage3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getExtraImage1() {
        return extraImage1;
    }

    public void setExtraImage1(String extraImage1) {
        this.extraImage1 = extraImage1;
    }

    public String getExtraImage2() {
        return extraImage2;
    }

    public void setExtraImage2(String extraImage2) {
        this.extraImage2 = extraImage2;
    }

    public String getExtraImage3() {
        return extraImage3;
    }

    public void setExtraImage3(String extraImage3) {
        this.extraImage3 = extraImage3;
    }

    @Transient
    public String getMainImagePath() {
        if(id == null || mainImage == null) return "/employee-images/unknown.jpg";
        return "/employee-images/" + this.id + "/" + this.mainImage;
    }

    @Transient
    public String getExtraImagePath1() {
        if(id == null || extraImage1 == null) return "/employee-images/unknown.jpg";
        return "/employee-images/" + this.id + "/" + this.extraImage1;
    }

    @Transient
    public String getExtraImagePath2() {
        if(id == null || extraImage2 == null) return "/employee-images/unknown.jpg";
        return "/employee-images/" + this.id + "/" + this.extraImage2;
    }

    @Transient
    public String getExtraImagePath3() {
        if(id == null || extraImage3 == null) return "/employee-images/unknown.jpg";
        return "/employee-images/" + this.id + "/" + this.extraImage3;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
