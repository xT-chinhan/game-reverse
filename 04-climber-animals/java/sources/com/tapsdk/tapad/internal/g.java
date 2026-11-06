package com.tapsdk.tapad.internal;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.model.entities.AdInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private final c a;
    private CountDownTimer b;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    final Handler g = new a(Looper.getMainLooper());
    private long c = 5000;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            g gVar = g.this;
            gVar.c = gVar.c > 1000 ? g.this.c : 0L;
            g.this.a.a(g.this.c);
        }
    }

    class b extends CountDownTimer {
        final /* synthetic */ AdInfo a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, long j2, AdInfo adInfo) {
            super(j, j2);
            this.a = adInfo;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            g.this.c = 0L;
            g.this.a.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            ExposureTrackerObject exposureTrackerObject;
            g.this.c = j;
            g.this.a.a(j);
            if (j <= 2500 && !g.this.d) {
                g.this.d = true;
                HashMap map = new HashMap();
                map.put("duration", String.valueOf(com.anythink.basead.exoplayer.d.c));
                TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
                if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
                    com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                    AdInfo adInfo = this.a;
                    cVarA.a(adInfo.viewMonitorUrls, map, adInfo.getViewMonitorHeaderListWrapper());
                } else {
                    exposureTrackerObject.b((Map<String, String>) null);
                }
            }
            if (j > com.anythink.basead.exoplayer.i.a.f || !g.this.e) {
                return;
            }
            g.this.e = false;
            g.this.g.sendMessageDelayed(Message.obtain(), 1000L);
        }
    }

    public interface c {
        void a();

        void a(long j);

        void onError(int i, String str);
    }

    public static class d extends com.tapsdk.tapad.internal.b {
        public AdInfo a;

        public d(AdInfo adInfo) {
            this.a = adInfo;
        }
    }

    public g(c cVar) {
        this.a = cVar;
    }

    private void b(AdInfo adInfo) {
        if (this.f) {
            return;
        }
        b bVar = new b(this.c, 1000L, adInfo);
        this.b = bVar;
        bVar.start();
        this.f = true;
    }

    private void c() {
        d();
    }

    private void d() {
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.b = null;
            this.f = false;
        }
    }

    public String a() {
        return Math.max((int) Math.ceil((this.c * 1.0f) / 1000.0f), 1) + " 秒";
    }

    public void a(com.tapsdk.tapad.internal.b bVar) {
        if (bVar instanceof d) {
            b(((d) bVar).a);
        } else if (bVar instanceof com.tapsdk.tapad.internal.d) {
            c();
        }
    }

    public void a(AdInfo adInfo) {
        if (this.f) {
            return;
        }
        b(adInfo);
    }

    public void b() {
        if (this.f) {
            this.b.cancel();
            this.f = false;
        }
    }
}
