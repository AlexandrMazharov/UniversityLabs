package app.entity;

import javax.persistence.*;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {
        super();
    }

    public Role(ERole name) {
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }

    public void setRoleId(Long role_id) {
        this.roleId = role_id;
    }

}
