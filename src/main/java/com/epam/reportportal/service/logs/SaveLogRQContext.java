package com.epam.reportportal.service.logs;

import com.epam.ta.reportportal.ws.model.log.SaveLogRQ;

import java.util.ArrayList;
import java.util.List;

class SaveLogRQContext {

    private static final List<SaveLogRQ> BUFFER_ITEM_LOGS = new ArrayList<>();

    public static void appendBufferLogRQList(SaveLogRQ rq) {
        BUFFER_ITEM_LOGS.add(rq);
    }

    public static void clearBufferLogList() {
        BUFFER_ITEM_LOGS.clear();
    }

    public static boolean isEmpty() {
        return BUFFER_ITEM_LOGS.isEmpty();
    }

    public static List<SaveLogRQ> getSaveLogRQ() {
        return new ArrayList<>(BUFFER_ITEM_LOGS);
    }

    public static int size() {
        return BUFFER_ITEM_LOGS.size();
    }
}
