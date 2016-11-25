package bsuir.scouting.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User implements Serializable {
    private long userId;
    private String name;
    private String login;
    private String password;
    private String mail;
    private Long teamId;
    private Long roleId;
    private Set<Comment> commentsByUserId = new HashSet<>(0);
    private Role roleByRoleId;
    private Team teamByTeamId;
    private Set<Player> players = new HashSet<>(0);
    private String photo;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", unique = true, nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "login", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mail", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "team_id", nullable = true, insertable = true, updatable = true)
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "role_id", nullable = true, insertable = true, updatable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (teamId != null ? !teamId.equals(user.teamId) : user.teamId != null) return false;
        if (roleId != null ? !roleId.equals(user.roleId) : user.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Set<Comment> getCommentsByUserId() {
        return commentsByUserId;
    }

    public void setCommentsByUserId(Set<Comment> commentsByUserId) {
        this.commentsByUserId = commentsByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Player> getUserPlayersByUserId() {
        return players;
    }

    public void setUserPlayersByUserId(Set<Player> players) {
        this.players = players;
    }

    @Basic
    @Column(name = "photo", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
