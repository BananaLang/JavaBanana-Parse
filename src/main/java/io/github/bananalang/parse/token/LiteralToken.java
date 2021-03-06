package io.github.bananalang.parse.token;

public final class LiteralToken extends Token {
    public static final long serialVersionUID = 7013960656416789816L;

    public final String literal;

    public LiteralToken(String literal, int row, int column) {
        super(row, column);
        this.literal = literal;
    }

    public LiteralToken(String literal) {
        this(literal, 0, 0);
    }

    @Override
    public String toString() {
        return literal;
    }

    public static boolean matchLiteral(Token tok, String check) {
        return tok instanceof LiteralToken && ((LiteralToken)tok).literal.equals(check);
    }
}
