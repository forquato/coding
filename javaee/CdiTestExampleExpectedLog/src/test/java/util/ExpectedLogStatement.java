package util;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static org.apache.openejb.log.logger.Log4jLogger.TRACE;


//import ch.qos.logback.classic.Logger;

/**
 * Based on https://gist.github.com/tux2323/1005996
 */
public class ExpectedLogStatement extends TestWatcher {

    private final ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
    private final LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    private final List<Class<?>> loggingSources = new ArrayList<>();

    private Level level = TRACE;

    @Override
    public void starting(Description description) {
        before();
    }

    @Override
    public void finished(Description description) {
        after();
    }

    private void before() {
        resetLoggingContext();
        loggingSources.forEach(this::addAppenderToType);
        listAppender.start();
    }

    private void after() {
        listAppender.stop();
        resetLoggingContext();
    }

    public void recordLevel(Level theLevel) {
        this.level = theLevel;
    }

    public void recordLoggingForObject(Object sut) {
        Class<?> type = sut.getClass();
        recordLoggingForType(type);
    }

    private <T> void recordLoggingForType(Class<T> type) {
        loggingSources.add(type);
        addAppenderToType(type);
    }

    public String getLogMessage(int index) {
        return getLogEvent(index).getFormattedMessage();
    }

    private List<ILoggingEvent> getLogEvents() {
        return listAppender.list;
    }

    private ILoggingEvent getLogEvent(int index) {
        return getLogEvents().get(index);
    }

    private <T> void addAppenderToType(Class<T> type) {
        Logger logger = (Logger) LoggerFactory.getLogger(type);
        logger.addAppender(listAppender);
        logger.setLevel(level);
    }

    private void resetLoggingContext() {
        lc.reset();
    }
}
