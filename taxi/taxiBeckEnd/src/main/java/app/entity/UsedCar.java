package app.entity;

import javax.persistence.*;

@Entity
@Table
public class UsedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long used_car__id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserTaxi used_car__driver;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car used_car__car;

    private String used_car__with;
    private String used_car__form;

    public UsedCar() {
    }

    public Long getUsed_car__id() {
        return used_car__id;
    }

    public void setUsed_car__id(Long used_car__id) {
        this.used_car__id = used_car__id;
    }

    public UserTaxi getUsed_car__driver() {
        return used_car__driver;
    }

    public void setUsed_car__driver(UserTaxi used_car__driver) {
        this.used_car__driver = used_car__driver;
    }

    public String getUsed_car__with() {
        return used_car__with;
    }

    public void setUsed_car__with(String used_car__with) {
        this.used_car__with = used_car__with;
    }

    public String getUsed_car__form() {
        return used_car__form;
    }

    public void setUsed_car__form(String used_car__form) {
        this.used_car__form = used_car__form;
    }

    public Car getUsed_car__car() {
        return used_car__car;
    }

    public void setUsed_car__car(Car used_car__car) {
        this.used_car__car = used_car__car;
    }
}
