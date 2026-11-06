package com.byazt.me;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.umeng.analytics.pro.an;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 126, 2305})
public class ApiDownloadHandlerService extends Service {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        hn hnVarPr = hn.pr();
        if (hnVarPr != null) {
            HashMap map = new HashMap();
            map.put(an.aB, this);
            hnVarPr.pr(map, 157);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        hn hnVarPr = hn.pr();
        if (hnVarPr != null) {
            HashMap map = new HashMap();
            map.put(an.aC, intent);
            map.put(an.aF, this);
            hnVarPr.pr(map, 158);
        }
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
