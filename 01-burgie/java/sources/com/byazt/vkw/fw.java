package com.byazt.vkw;

import android.content.Context;
import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface fw {

    public interface hw {
        long pr();

        void pr(long j, boolean z);

        void pr(String str, JSONObject jSONObject);
    }

    public interface pr {
        void pr(JSONObject jSONObject);
    }

    String hn();

    Context hw();

    String hw(String str, String str2);

    void hw(String str);

    boolean hw(int i);

    String pr();

    String pr(String str, long j, int i, boolean z);

    void pr(double d, long j);

    void pr(int i);

    void pr(long j, int i);

    void pr(MotionEvent motionEvent);

    void pr(pr prVar);

    void pr(JSONObject jSONObject);

    boolean pr(String str);

    boolean pr(String str, String str2) throws Exception;

    boolean x();
}
