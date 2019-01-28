// TODO: copyright

package com.mongodb.crypt.internal.logging;

import java.util.logging.Level;

import static java.util.logging.Level.FINE;
import static java.util.logging.Level.FINER;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

class JULLogger implements Logger {

    private final java.util.logging.Logger delegate;

    JULLogger(final String name) {
        this.delegate = java.util.logging.Logger.getLogger(name);
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return isEnabled(FINER);
    }

    @Override
    public void trace(final String msg) {
        log(FINER, msg);
    }

    @Override
    public void trace(final String msg, final Throwable t) {
        log(FINER, msg, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return isEnabled(FINE);
    }

    @Override
    public void debug(final String msg) {
        log(FINE, msg);
    }

    @Override
    public void debug(final String msg, final Throwable t) {
        log(FINE, msg, t);
    }

    @Override
    public boolean isInfoEnabled() {
        return delegate.isLoggable(INFO);
    }

    @Override
    public void info(final String msg) {
        log(INFO, msg);
    }

    @Override
    public void info(final String msg, final Throwable t) {
        log(INFO, msg, t);
    }

    @Override
    public boolean isWarnEnabled() {
        return delegate.isLoggable(WARNING);
    }

    @Override
    public void warn(final String msg) {
        log(WARNING, msg);
    }

    @Override
    public void warn(final String msg, final Throwable t) {
        log(WARNING, msg, t);
    }


    @Override
    public boolean isErrorEnabled() {
        return delegate.isLoggable(SEVERE);
    }

    @Override
    public void error(final String msg) {
        log(SEVERE, msg);
    }

    @Override
    public void error(final String msg, final Throwable t) {
        log(SEVERE, msg, t);
    }


    private boolean isEnabled(final Level level) {
        return delegate.isLoggable(level);
    }

    private void log(final Level level, final String msg) {
        delegate.log(level, msg);
    }

    public void log(final Level level, final String msg, final Throwable t) {
        delegate.log(level, msg, t);
    }
}
