package com.byazt.vkw;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface qi {

    public interface pr {
        void pr(Message message);
    }

    Handler c();

    ExecutorService fw();

    ExecutorService hn();

    void hn(Runnable runnable);

    ExecutorService hw();

    void hw(Runnable runnable);

    Handler pr(pr prVar, String str);

    Handler pr(String str);

    ExecutorService pr();

    ExecutorService pr(int i, int i2);

    void pr(Handler handler);

    void pr(Runnable runnable);

    void pr(Runnable runnable, int i);

    void pr(JSONObject jSONObject);

    Handler uc();

    Handler x();

    ScheduledExecutorService zo();
}
