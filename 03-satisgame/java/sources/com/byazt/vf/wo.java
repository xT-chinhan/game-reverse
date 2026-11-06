package com.byazt.vf;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface wo {

    public interface n {
        void n(Message message);
    }

    ScheduledExecutorService fs();

    Handler l();

    Handler n(n nVar, String str);

    Handler n(String str);

    ExecutorService n();

    ExecutorService n(int i, int i2);

    void n(Handler handler);

    void n(Runnable runnable);

    void n(Runnable runnable, int i);

    void n(JSONObject jSONObject);

    Handler q();

    ExecutorService qg();

    void qg(Runnable runnable);

    ExecutorService s();

    void s(Runnable runnable);

    Handler w();

    ExecutorService x();
}
