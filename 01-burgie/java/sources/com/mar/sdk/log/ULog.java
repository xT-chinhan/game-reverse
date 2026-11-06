package com.mar.sdk.log;

import android.support.v4.app.NotificationCompat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ULog {
    public static final String L_DEBUG = "DEBUG";
    public static final String L_ERROR = "ERROR";
    public static final String L_INFO = "INFO";
    public static final String L_WARN = "WARNING";
    private String level;
    private String msg;
    private Throwable stack;
    private String tag;
    private Date time;

    public ULog() {
    }

    public ULog(String level, String tag, String msg) {
        this.level = level;
        this.tag = tag;
        this.msg = msg;
        this.stack = null;
        this.time = new Date();
    }

    public ULog(String level, String tag, String msg, Throwable e) {
        this.level = level;
        this.tag = tag;
        this.msg = msg;
        this.stack = e;
        this.time = new Date();
    }

    private String parseStack(Throwable e) {
        StringWriter result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        e.printStackTrace(printWriter);
        String stacktrace = result.toString();
        printWriter.close();
        return stacktrace;
    }

    public String toJSON() {
        try {
            JSONObject json = new JSONObject();
            json.put("level", this.level);
            json.put("tag", this.tag);
            json.put(NotificationCompat.CATEGORY_MESSAGE, this.msg);
            json.put("stack", this.stack == null ? "" : parseStack(this.stack));
            json.put("time", this.time);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
