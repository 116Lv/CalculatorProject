public enum OperatorType {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType getSymbol(String oper) {
        for(OperatorType ot : values()) {
            if (ot.getSymbol().equals(oper)) {
                return ot;
            }
        }
        return null;
    }
}