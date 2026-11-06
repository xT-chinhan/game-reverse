package com.tapsdk.tapad.internal.tracker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.tracker.entities.TrackADMessage;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d extends Handler {
    private static final String a = "TapADTrackerHandler";
    private static final int b = 1;
    private static final int c = 1;

    public d(Looper looper) {
        super(looper);
    }

    private boolean b(TrackADMessage trackADMessage) {
        com.tapsdk.tapad.internal.network.a aVarA = com.tapsdk.tapad.a.a().a(Constants.b.c);
        try {
            String strA = trackADMessage.a;
            if (trackADMessage.e != null) {
                strA = com.tapsdk.tapad.internal.network.c.a.c(strA, trackADMessage.e);
            }
            if (trackADMessage.c != null) {
                strA = com.tapsdk.tapad.internal.network.c.a.a(strA, trackADMessage.c);
            }
            Log.d("TapADTracker", "url:" + strA);
            HashMap map = new HashMap();
            if (trackADMessage.d != null && trackADMessage.d.size() > 0) {
                map.putAll(com.tapsdk.tapad.internal.network.c.a.a(trackADMessage.d));
            }
            aVarA.a(strA, (Map<String, String>) null, map);
            return true;
        } catch (com.tapsdk.tapad.internal.network.b.a | IOException unused) {
            return false;
        }
    }

    public void a(TrackADMessage trackADMessage) {
        if (b(trackADMessage) || trackADMessage.b() >= 1) {
            return;
        }
        sendMessage(Message.obtain(this, 1, trackADMessage));
    }

    public void a(String str, Map<String, String> map) {
        sendMessage(Message.obtain(this, 1, new TrackADMessage(str, map)));
    }

    public void a(String str, Map<String, String> map, List<DynamicHeader> list) {
        sendMessage(Message.obtain(this, 1, new TrackADMessage(str, map, list)));
    }

    public void a(String str, Map<String, String> map, List<DynamicHeader> list, Map<String, String> map2) {
        sendMessage(Message.obtain(this, 1, new TrackADMessage(str, map, list, map2)));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.what == 1 && (message.obj instanceof TrackADMessage)) {
                a((TrackADMessage) message.obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
