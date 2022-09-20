package server;

import java.sql.Date;
import java.time.LocalDateTime;

public class BeanOperations {
    /*
        id bigint primary key auto_increment,
    `type` varchar(15) not null,
    first_number double not null,
    second_number double not null default 0,
    result double not null,
    create_at datetime not null default now()
     */

    private long id;
    private String operationType;
    private double firstNumber;
    private double secondNumber;
    private double result;
    private Date createAt;

    public BeanOperations() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
