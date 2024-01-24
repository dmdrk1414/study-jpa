package ch02.jpa.start1;

public enum OrderStatus {
    ORDER("주문", 100),

    CANCEL("취소", 200);

    private final String state;
    private final Integer    code;

    public String getState() {
        return state;
    }

    public Integer getCode() {
        return code;
    }

    OrderStatus(String state, Integer code) {
        this.state = state;
        this.code = code;
    }
}
