package com.epam.reportportal.service.logs;

import com.epam.ta.reportportal.ws.model.log.SaveLogRQ;

import java.util.LinkedList;
import java.util.List;

class LoggingContext {
    private static final List<SaveLogRQ> logRQList = new LinkedList<>();

    public synchronized static void appendLog(SaveLogRQ saveLogRQ) {
        logRQList.add(saveLogRQ);
    }

    public synchronized static List<SaveLogRQ> getLogRQList() {
        return new LinkedList<>(logRQList);
    }

    public synchronized static void clearLogRQList() {
        logRQList.clear();
    }

    public synchronized static int size() {
        return logRQList.size();
    }

    public synchronized static boolean isEmpty() {
        return logRQList.isEmpty();
    }

}
