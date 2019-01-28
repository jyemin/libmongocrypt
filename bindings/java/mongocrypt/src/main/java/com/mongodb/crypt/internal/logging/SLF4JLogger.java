// TODO: copyright

package com.mongodb.crypt.internal.logging;

import org.slf4j.LoggerFactory;

class SLF4JLogger implements Logger {

    private final org.slf4j.Logger delegate;

    SLF4JLogger(final String name) {
        this.delegate = LoggerFactory.getLogger(name);
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return delegate.isTraceEnabled();
    }

    @Override
    public void trace(final String msg) {
        delegate.trace(msg);
    }

    @Override
    public void trace(final String msg, final Throwable t) {
        delegate.trace(msg, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return delegate.isDebugEnabled();
    }

    @Override
    public void debug(final String msg) {
        delegate.debug(msg);
    }

    @Override
    public void debug(final String msg, final Throwable t) {
        delegate.debug(msg, t);
    }

    @Override
    public boolean isInfoEnabled() {
        return delegate.isInfoEnabled();
    }

    @Override
    public void info(final String msg) {
        delegate.info(msg);
    }

    @Override
    public void info(final String msg, final Throwable t) {
        delegate.info(msg, t);
    }

    @Override
    public boolean isWarnEnabled() {
        return delegate.isWarnEnabled();
    }

    @Override
    public void warn(final String msg) {
        delegate.warn(msg);
    }

    @Override
    public void warn(final String msg, final Throwable t) {
        delegate.warn(msg, t);
    }

    @Override
    public boolean isErrorEnabled() {
        return delegate.isErrorEnabled();
    }

    @Override
    public void error(final String msg) {
        delegate.error(msg);
    }

    @Override
    public void error(final String msg, final Throwable t) {
        delegate.error(msg, t);
    }
}
