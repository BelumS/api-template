package com.belum.apitemplate.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FileWriteFailedException extends Exception {
    public FileWriteFailedException(String message) {
        super(message);
    }

    public FileWriteFailedException(Throwable cause) {
        super(cause);
    }

    public FileWriteFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
