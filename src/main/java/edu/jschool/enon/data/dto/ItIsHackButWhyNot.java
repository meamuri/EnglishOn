package edu.jschool.enon.data.dto;

public class ItIsHackButWhyNot {
    private int val;
    private Long id;

    public ItIsHackButWhyNot() {}

    public ItIsHackButWhyNot(int val, Long id) {
        this.val = val;
        this.id = id;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
