package bsuir.scouting.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Skills implements Serializable {
    private long skillsId;
    private Long shooting;
    private Long passing;
    private Long dribbling;
    private Long defence;
    private Long speed;
    private Long energy;
    private Long stamina;
    private Set<Player> playersBySkillsId = new HashSet<>(0);
    private Set<Team> teamsBySkillsId = new HashSet<>(0);

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "skills_id", nullable = false, insertable = true, updatable = true)
    public long getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(long skillsId) {
        this.skillsId = skillsId;
    }

    @Basic
    @Column(name = "shooting", nullable = true, insertable = true, updatable = true)
    public Long getShooting() {
        return shooting;
    }

    public void setShooting(Long shooting) {
        this.shooting = shooting;
    }

    @Basic
    @Column(name = "passing", nullable = true, insertable = true, updatable = true)
    public Long getPassing() {
        return passing;
    }

    public void setPassing(Long passing) {
        this.passing = passing;
    }

    @Basic
    @Column(name = "dribbling", nullable = true, insertable = true, updatable = true)
    public Long getDribbling() {
        return dribbling;
    }

    public void setDribbling(Long dribbling) {
        this.dribbling = dribbling;
    }

    @Basic
    @Column(name = "defence", nullable = true, insertable = true, updatable = true)
    public Long getDefence() {
        return defence;
    }

    public void setDefence(Long defence) {
        this.defence = defence;
    }

    @Basic
    @Column(name = "speed", nullable = true, insertable = true, updatable = true)
    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "energy", nullable = true, insertable = true, updatable = true)
    public Long getEnergy() {
        return energy;
    }

    public void setEnergy(Long energy) {
        this.energy = energy;
    }

    @Basic
    @Column(name = "stamina", nullable = true, insertable = true, updatable = true)
    public Long getStamina() {
        return stamina;
    }

    public void setStamina(Long stamina) {
        this.stamina = stamina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        if (skillsId != skills.skillsId) return false;
        if (shooting != null ? !shooting.equals(skills.shooting) : skills.shooting != null) return false;
        if (passing != null ? !passing.equals(skills.passing) : skills.passing != null) return false;
        if (dribbling != null ? !dribbling.equals(skills.dribbling) : skills.dribbling != null) return false;
        if (defence != null ? !defence.equals(skills.defence) : skills.defence != null) return false;
        if (speed != null ? !speed.equals(skills.speed) : skills.speed != null) return false;
        if (energy != null ? !energy.equals(skills.energy) : skills.energy != null) return false;
        if (stamina != null ? !stamina.equals(skills.stamina) : skills.stamina != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (skillsId ^ (skillsId >>> 32));
        result = 31 * result + (shooting != null ? shooting.hashCode() : 0);
        result = 31 * result + (passing != null ? passing.hashCode() : 0);
        result = 31 * result + (dribbling != null ? dribbling.hashCode() : 0);
        result = 31 * result + (defence != null ? defence.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (energy != null ? energy.hashCode() : 0);
        result = 31 * result + (stamina != null ? stamina.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "skillsBySkillsId")
    @JsonIgnore
    public Set<Player> getPlayersBySkillsId() {
        return playersBySkillsId;
    }

    public void setPlayersBySkillsId(Set<Player> playersBySkillsId) {
        this.playersBySkillsId = playersBySkillsId;
    }

    @OneToMany(mappedBy = "skillsBySkillsId")
    @JsonIgnore
    public Set<Team> getTeamsBySkillsId() {
        return teamsBySkillsId;
    }

    public void setTeamsBySkillsId(Set<Team> teamsBySkillsId) {
        this.teamsBySkillsId = teamsBySkillsId;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skillsId=" + skillsId +
                ", shooting=" + shooting +
                ", passing=" + passing +
                ", dribbling=" + dribbling +
                ", defence=" + defence +
                ", speed=" + speed +
                ", energy=" + energy +
                ", stamina=" + stamina +
                ", playersBySkillsId=" + playersBySkillsId +
                ", teamsBySkillsId=" + teamsBySkillsId +
                '}';
    }
}
