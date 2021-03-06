package io.github.bananalang.parse.token;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class ReservedToken extends Token {
    public static final long serialVersionUID = -7739649703677026647L;

    public static final String BREAK    = "break"   .intern(),
                               CONTINUE = "continue".intern(),
                               DEF      = "def"     .intern(),
                               ELSE     = "else"    .intern(),
                               FALSE    = "false"   .intern(),
                               FOR      = "for"     .intern(),
                               IF       = "if"      .intern(),
                               IMPORT   = "import"  .intern(),
                               NULL     = "null"    .intern(),
                               RETURN   = "return"  .intern(),
                               THIS     = "this"    .intern(),
                               TRUE     = "true"    .intern(),
                               VAR      = "var"     .intern(),
                               WHILE    = "while"   .intern();

    public static final Set<String> RESERVED_WORDS = Collections.unmodifiableSet(new HashSet<>(
        Arrays.asList(BREAK, CONTINUE, DEF, ELSE, FALSE, FOR, IF, IMPORT, NULL, RETURN, THIS, TRUE, VAR, WHILE)
    ));

    public final String word;

    public ReservedToken(String word, int row, int column) {
        super(row, column);
        if (!RESERVED_WORDS.contains(word)) {
            throw new IllegalArgumentException("ReservedToken argument not a reserved word!");
        }
        this.word = word;
    }

    public ReservedToken(String word) {
        this(word, 0, 0);
    }

    @Override
    public String toString() {
        return word;
    }

    public static boolean matchReservedWord(Token tok, String word) {
        return tok instanceof ReservedToken && ((ReservedToken)tok).word.equals(word);
    }

    public static boolean matchSituationallyReservedWord(Token tok, String word) {
        return tok instanceof IdentifierToken && ((IdentifierToken)tok).identifier.equals(word);
    }
}
