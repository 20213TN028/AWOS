package mx.edu.utez.kofexam.model.character;

import mx.edu.utez.kofexam.model.fightType.BeanFightType;
import mx.edu.utez.kofexam.model.magic.BeanMagic;

import java.sql.Date;

public class BeanCharacter {
    private Long id;
    private String name;
    private String lastname;
    private Date birthday;
    private Short hasMagic;
    private Double height;
    private Double weight;
    private Integer team;
    private BeanMagic magicId;
    private BeanFightType fightTypeId;

    public BeanCharacter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Short getHasMagic() {
        return hasMagic;
    }

    public void setHasMagic(Short hasMagic) {
        this.hasMagic = hasMagic;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public BeanMagic getMagicId() {
        return magicId;
    }

    public void setMagicId(BeanMagic magicId) {
        this.magicId = magicId;
    }

    public BeanFightType getFightTypeId() {
        return fightTypeId;
    }

    public void setFightTypeId(BeanFightType fightTypeId) {
        this.fightTypeId = fightTypeId;
    }
}
