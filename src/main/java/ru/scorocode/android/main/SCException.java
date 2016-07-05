package ru.scorocode.android.main;

import ru.scorocode.android.model.Object;

public class SCException extends RuntimeException {
    static final long serialVersionUID = 100;

    /**
     * Constructs a new SCException.
     */
    public SCException() {
        super();
    }

    /**
     * Constructs a new SCException.
     *
     * @param message the detail message of this exception
     */
    public SCException(String message) {
        super(message);
    }

    /**
     * Constructs a new SCException.
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter.
     */
    public SCException(String format, Object... args) {
        this(String.format(format, args));
    }

    /**
     * Constructs a new SCException.
     *
     * @param message   the detail message of this exception
     * @param throwable the cause of this exception
     */
    public SCException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a new SCException.
     *
     * @param throwable the cause of this exception
     */
    public SCException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String toString() {
        // Throwable.toString() returns "SCException:{message}". Returning just "{message}"
        // should be fine here.
        return getMessage();
    }
}
