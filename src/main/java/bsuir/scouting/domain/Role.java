package bsuir.scouting.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role implements Serializable {
    private long roleId;
    private String type;
    private Set<User> usersByRoleId = new HashSet<>(0);

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "role_id", nullable = false, insertable = true, updatable = true)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "type", nullable = true, insertable = true, updatable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleId != role.roleId) return false;
        if (type != null ? !type.equals(role.type) : role.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Set<User> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Set<User> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }
}
