package com.efs.sdk.pa.a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.pa.PA;
import com.efs.sdk.pa.PAANRListener;
import com.efs.sdk.pa.PAMsgListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements PA {
    private boolean a;
    private e c;
    private f d;
    private a e;
    private boolean h;
    private boolean i;
    private Looper b = Looper.myLooper();
    private b f = new b();
    private g g = new g();

    @Override // com.efs.sdk.pa.PA
    public final void unregisterPAANRListener() {
    }

    public c(boolean z) {
        this.i = z;
    }

    @Override // com.efs.sdk.pa.PA
    public final void start() {
        if (this.i || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.h = true;
            e eVar = this.c;
            if (eVar != null) {
                this.b.setMessageLogging(eVar);
            }
            a aVar = this.e;
            if (aVar == null || !aVar.f) {
                return;
            }
            aVar.f = false;
            aVar.g.post(aVar.m);
            aVar.j = SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void stop() {
        this.h = false;
        this.b.setMessageLogging(null);
        a aVar = this.e;
        if (aVar != null) {
            aVar.f = true;
            aVar.g.removeCallbacksAndMessages(null);
            aVar.a = true;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalFPS(String str, View view) {
        if (this.h) {
            b bVar = this.f;
            if (str == null || str.trim().length() == 0 || view == null || bVar.a.get(str) != null) {
                return;
            }
            b.a aVar = new b.a((byte) 0);
            if (view != null) {
                aVar.d = view;
                b.a.AnonymousClass1 anonymousClass1 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.efs.sdk.pa.a.b.a.1
                    AnonymousClass1() {
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public final boolean onPreDraw() {
                        a.this.b++;
                        return true;
                    }
                };
                aVar.c = anonymousClass1;
                aVar.d.getViewTreeObserver().addOnPreDrawListener(anonymousClass1);
                aVar.a = System.currentTimeMillis();
            }
            bVar.a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final int endCalFPS(String str) {
        if (!this.h) {
            return -1;
        }
        b bVar = this.f;
        int i = 0;
        if (str != null && str.trim().length() != 0) {
            b.a aVar = bVar.a.get(str);
            if (aVar == null) {
                return 0;
            }
            if (aVar.d != null && aVar.c != null) {
                aVar.d.getViewTreeObserver().removeOnPreDrawListener(aVar.c);
            }
            bVar.a.remove(str);
            int iCurrentTimeMillis = (int) (aVar.b / ((System.currentTimeMillis() - aVar.a) / 1000.0f));
            i = iCurrentTimeMillis > 0 ? iCurrentTimeMillis : 0;
            if (bVar.b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",fps=" + i);
            }
        }
        return i;
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalTime(String str) {
        if (this.h) {
            g gVar = this.g;
            if (str == null || str.trim().length() == 0 || gVar.a.get(str) != null) {
                return;
            }
            g.a aVar = new g.a((byte) 0);
            aVar.a = System.currentTimeMillis();
            gVar.a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final long endCalTime(String str) {
        if (!this.h) {
            return -1L;
        }
        g gVar = this.g;
        long jCurrentTimeMillis = 0;
        if (str != null && str.trim().length() != 0) {
            g.a aVar = gVar.a.get(str);
            if (aVar == null) {
                return 0L;
            }
            gVar.a.remove(str);
            jCurrentTimeMillis = System.currentTimeMillis() - aVar.a;
            if (gVar.b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",consumeTime=" + jCurrentTimeMillis);
            }
        }
        return jCurrentTimeMillis;
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableLog(boolean z) {
        this.a = z;
        this.f.b = z;
        this.g.b = z;
        f fVar = this.d;
        if (fVar != null) {
            fVar.b = z;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableDumpToFile(String str) {
        FileOutputStream fileOutputStream;
        f fVar = this.d;
        if (fVar == null || str == null || str.trim().length() == 0) {
            return;
        }
        fVar.c = str;
        if (fVar.d != null) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fVar.d = new BufferedOutputStream(fileOutputStream);
            } catch (Exception unused) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.c == null) {
            this.c = new e();
        }
        this.b.setMessageLogging(this.c);
        if (this.d == null) {
            this.d = new f();
        }
        this.d.b = this.a;
        this.d.a = pAMsgListener;
        e eVar = this.c;
        eVar.a.add(this.d);
    }

    @Override // com.efs.sdk.pa.PA
    public final void unRegisterPAMsgListener() {
        f fVar = this.d;
        if (fVar != null) {
            fVar.a = null;
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.a.remove(this.d);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, com.anythink.basead.exoplayer.i.a.f);
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j) {
        registerPAANRListener(context, pAANRListener, j, Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j, Thread thread) {
        if (this.e == null) {
            if (thread != null) {
                this.e = new a((Application) context.getApplicationContext(), j);
            } else {
                this.e = new a((Application) context.getApplicationContext(), j, false);
            }
        }
        this.e.h = pAANRListener;
    }
}
