package org.spring.boot.dubbo.api.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Word implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4898252480805741515L;

    @Length(message = "参数错误", min = 1)
    private String word;
    @NotNull
    private int num;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
