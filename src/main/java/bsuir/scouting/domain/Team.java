package bsuir.scouting.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Team implements Serializable {
    private long teamId;
    private String name;
    private Long skillsId;
    private Set<Player> playersByTeamId = new HashSet<>(0);
    private Skills skillsBySkillsId;
    private Set<User> usersByTeamId = new HashSet<>(0);
    private String country;
    private String photo;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "team_id", nullable = false, insertable = true, updatable = true)
    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "skills_id", nullable = true, insertable = true, updatable = true)
    public Long getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(Long skillsId) {
        this.skillsId = skillsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (teamId != team.teamId) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (skillsId != null ? !skillsId.equals(team.skillsId) : team.skillsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teamId ^ (teamId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (skillsId != null ? skillsId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Set<Player> getPlayersByTeamId() {
        return playersByTeamId;
    }

    public void setPlayersByTeamId(Set<Player> playersByTeamId) {
        this.playersByTeamId = playersByTeamId;
    }

    @ManyToOne
    @JoinColumn(name = "skills_id", referencedColumnName = "skills_id")
    public Skills getSkillsBySkillsId() {
        return skillsBySkillsId;
    }

    public void setSkillsBySkillsId(Skills skillsBySkillsId) {
        this.skillsBySkillsId = skillsBySkillsId;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Set<User> getUsersByTeamId() {
        return usersByTeamId;
    }

    public void setUsersByTeamId(Set<User> usersByTeamId) {
        this.usersByTeamId = usersByTeamId;
    }

    @Basic
    @Column(name = "country", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
