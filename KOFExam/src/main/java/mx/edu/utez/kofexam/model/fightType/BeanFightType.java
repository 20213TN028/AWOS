package mx.edu.utez.kofexam.model.fightType;

import java.sql.Date;

public class BeanFightType {
    private Long fightId;
    private String fightName;

    public BeanFightType() {
    }

    public Long getFightId() {
        return fightId;
    }

    public void setFightId(Long fightId) {
        this.fightId = fightId;
    }

    public String getFightName() {
        return fightName;
    }

    public void setFightName(String fightName) {
        this.fightName = fightName;
    }
}
