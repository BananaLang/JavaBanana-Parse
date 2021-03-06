package io.github.bananalang.parse;

public class SyntaxException extends RuntimeException {
    static final long serialVersionUID = 673969799682597808L;

    public final int row, column;

    /** Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SyntaxException() {
        super();
        row = column = 0;
    }

    public SyntaxException(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    /** Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public SyntaxException(String message) {
        super(message);
        row = column = 0;
    }

    public SyntaxException(String message, int row, int column) {
        super(message);
        this.row = row;
        this.column = column;
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <code>null</code> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public SyntaxException(String message, Throwable cause) {
        super(message, cause);
        row = column = 0;
    }

    public SyntaxException(String message, Throwable cause, int row, int column) {
        super(message, cause);
        this.row = row;
        this.column = column;
    }

    /** Constructs a new runtime exception with the specified cause and a
     * detail message of <code>(cause==null ? null : cause.toString())</code>
     * (which typically contains the class and detail message of
     * <code>cause</code>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <code>null</code> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public SyntaxException(Throwable cause) {
        super(cause);
        row = column = 0;
    }

    public SyntaxException(Throwable cause, int row, int column) {
        super(cause);
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        if (row != 0 || column != 0) {
            result.append(" at [");
            if (row != 0) result.append(row);
            result.append(',');
            if (column != 0) result.append(column);
            result.append(']');
        }
        return result.toString();
    }

    /**
     * Constructs a new runtime exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param  message the detail message.
     * @param cause the cause.  (A {@code null} value is permitted,
     * and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     *
     * @since 1.7
     */
    protected SyntaxException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        row = column = 0;
    }
}
