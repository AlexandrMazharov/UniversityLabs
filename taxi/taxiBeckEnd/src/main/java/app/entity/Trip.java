package app.entity;

import javax.persistence.*;

@Entity
@Table
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trip_id;
    private String trip_adress_a;
    private String trip_adress_b;
    private int trip_price;
    private String trip_feedback;
    @ManyToOne
    @JoinColumn(name = "user_id_u")
    private UserTaxi trip_user;
    @ManyToOne
    @JoinColumn(name = "user_id_d")
    private UserTaxi trip_dirver;

    public Trip() {
    }

    public Long getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Long trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_adress_a() {
        return trip_adress_a;
    }

    public void setTrip_adress_a(String trip_adress_a) {
        this.trip_adress_a = trip_adress_a;
    }

    public String getTrip_adress_b() {
        return trip_adress_b;
    }

    public void setTrip_adress_b(String trip_adress_b) {
        this.trip_adress_b = trip_adress_b;
    }

    public int getTrip_price() {
        return trip_price;
    }

    public void setTrip_price(int price) {
        this.trip_price = price;
    }

    public String getTrip_feedback() {
        return trip_feedback;
    }

    public void setTrip_feedback(String trip_feedback) {
        this.trip_feedback = trip_feedback;
    }

    public UserTaxi getTrip_user() {
        return trip_user;
    }

    public void setTrip_user(UserTaxi trip_user) {
        this.trip_user = trip_user;
    }

    public UserTaxi getTrip_dirver() {
        return trip_dirver;
    }

    public void setTrip_dirver(UserTaxi trip_dirver) {
        this.trip_dirver = trip_dirver;
    }
}
