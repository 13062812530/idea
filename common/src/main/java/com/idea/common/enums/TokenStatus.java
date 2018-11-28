package com.idea.common.enums;

public enum TokenStatus {
    success("2001"),
    failed("2001"),
    overdue("2003"),
    exception("2004"),
    other("9999");

    private String code;

    TokenStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public TokenStatus getByCode(String code){
        for (TokenStatus status:values()) {
            if(status.code.equals(code)){
                return status;
            }
        }
        return other;
    }
}
