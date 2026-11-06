package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Handler.Callback, Comparator<tz> {
    private static b xr;
    private static long zb;
    private jw ab;
    private y ah;
    private ti c;
    private com.bytedance.embedapplog.util.ms ch;
    private pc d;
    private Handler hi;
    private final ArrayList<tz> ka = new ArrayList<>(32);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public Application f478ms;
    private w ny;
    private i sl;
    private Handler x;

    public static void ms() {
        if (xr != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - zb) > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                zb = jCurrentTimeMillis;
                xr.ms((String[]) null, true);
            }
        }
    }

    private b() {
    }

    public Context xr() {
        return this.f478ms;
    }

    public ti ah() {
        return this.c;
    }

    public pc d() {
        return this.d;
    }

    public jw ka() {
        return this.ab;
    }

    public static b c() {
        if (xr == null) {
            synchronized (b.class) {
                if (xr == null) {
                    xr = new b();
                }
            }
        }
        return xr;
    }

    public w ab() {
        return this.ny;
    }

    public com.bytedance.embedapplog.util.ms x() {
        if (this.ch == null) {
            com.bytedance.embedapplog.util.ms msVarHi = this.d.fm().hi();
            this.ch = msVarHi;
            if (msVarHi == null) {
                this.ch = com.bytedance.embedapplog.util.xr.ms(0);
            }
        }
        return this.ch;
    }

    public void ms(Application application, pc pcVar, jw jwVar, qv qvVar) {
        this.f478ms = application;
        this.c = new ti(this);
        this.d = pcVar;
        this.ab = jwVar;
        this.ny = new w(this.ab, this.d);
        this.f478ms.registerActivityLifecycleCallbacks(qvVar);
        Looper looperMs = zd.ms(pcVar);
        if (looperMs == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            looperMs = handlerThread.getLooper();
        }
        Handler handler = new Handler(looperMs, this);
        this.hi = handler;
        handler.sendEmptyMessage(1);
        jy.ms(pcVar.x() != 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i = message.what;
            if (i == 1) {
                oh.f511ms = this.d.b();
                if (this.ab.c()) {
                    if (this.d.h()) {
                        Looper looperXr = zd.xr(this.d);
                        if (looperXr == null) {
                            HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                            handlerThread.start();
                            looperXr = handlerThread.getLooper();
                        }
                        Handler handler = new Handler(looperXr, this);
                        this.x = handler;
                        handler.sendEmptyMessage(2);
                        if (this.ka.size() > 0) {
                            this.hi.removeMessages(4);
                            this.hi.sendEmptyMessageDelayed(4, 1000L);
                        }
                        oh.d("net|worker start", null);
                    }
                } else {
                    this.hi.removeMessages(1);
                    this.hi.sendEmptyMessageDelayed(1, 1000L);
                }
                op.ms();
            } else if (i == 2) {
                ArrayList<t> arrayList = new ArrayList(4);
                arrayList.add(new re(this));
                arrayList.add(new nw(this));
                i iVar = new i(this);
                this.sl = iVar;
                arrayList.add(iVar);
                for (t tVar : arrayList) {
                    if (tVar instanceof i) {
                        this.sl.ms(zd.ms());
                    }
                    long jAb = tVar.ab();
                    if (jAb < 864000000) {
                        this.x.sendMessageDelayed(this.hi.obtainMessage(6, tVar), jAb);
                    }
                }
                this.sl.ms(true);
                ch();
            } else if (i == 4) {
                ms((String[]) null, false);
            } else if (i == 5) {
                ms((String[]) message.obj, false);
            } else if (i == 6) {
                t tVar2 = (t) message.obj;
                if (!tVar2.c()) {
                    long jAb2 = tVar2.ab();
                    if (jAb2 < 864000000) {
                        this.x.sendMessageDelayed(this.hi.obtainMessage(6, tVar2), jAb2);
                    }
                    ch();
                }
                this.sl.ms(true);
            } else if (i == 7) {
                synchronized (this.ka) {
                    this.ka.add(w.ka());
                }
                ms((String[]) null, false);
            } else if (i == 89) {
                jw jwVar = this.ab;
                if (jwVar != null) {
                    jwVar.ka();
                }
            } else {
                oh.xr((Throwable) null);
            }
        } catch (Throwable th) {
            oh.ms("engine:" + th.getMessage());
        }
        return true;
    }

    private void ch() {
        if (this.d.nw()) {
            if (this.ah == null) {
                y yVar = new y(this);
                this.ah = yVar;
                this.x.obtainMessage(6, yVar).sendToTarget();
                return;
            }
            return;
        }
        y yVar2 = this.ah;
        if (yVar2 != null) {
            yVar2.ka();
            this.ah = null;
        }
    }

    private void ms(String[] strArr, boolean z) {
        ArrayList<tz> arrayList;
        synchronized (this.ka) {
            arrayList = (ArrayList) this.ka.clone();
            this.ka.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(tz.ms(str));
            }
        }
        boolean zMs = this.d.ms(arrayList);
        if (arrayList.size() > 0) {
            if (this.d.h()) {
                if (zMs || arrayList.size() > 100) {
                    Collections.sort(arrayList, this);
                    ArrayList<tz> arrayList2 = new ArrayList<>(arrayList.size());
                    boolean zMs2 = false;
                    boolean zMs3 = false;
                    for (tz tzVar : arrayList) {
                        zMs2 |= this.ny.ms(tzVar, arrayList2);
                        if (tzVar instanceof rt) {
                            zMs3 = w.ms(tzVar);
                            i = 1;
                        }
                    }
                    this.c.ms(arrayList2);
                    if (i != 0) {
                        if (zMs3) {
                            this.hi.removeMessages(7);
                        } else if (!zd.xr() && zd.ms()) {
                            this.hi.sendEmptyMessageDelayed(7, this.d.re());
                        }
                    }
                    if (zMs2 || z) {
                        hi();
                        return;
                    }
                    return;
                }
                synchronized (this.ka) {
                    this.ka.addAll(arrayList);
                }
                return;
            }
            Intent intent = new Intent(this.f478ms, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int length = 0;
            while (i < size) {
                String string = arrayList.get(i).ka().toString();
                strArr2[i] = string;
                length += string.length();
                i++;
            }
            if (length >= 307200) {
                oh.xr((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.f478ms.sendBroadcast(intent);
            } catch (Exception e) {
                oh.xr(e);
            }
        }
    }

    private void hi() {
        if (oh.xr) {
            oh.ms("packAndSend once, " + this.ny.ms() + ", hadUI:" + this.ny.xr(), null);
        }
        i iVar = this.sl;
        if (iVar != null) {
            iVar.x();
        }
        if (this.x != null) {
            this.sl.ms(zd.ms());
            this.x.sendMessage(this.hi.obtainMessage(6, this.sl));
        }
    }

    public static void ms(tz tzVar) {
        int size;
        Handler handler;
        b bVar = xr;
        if (bVar == null) {
            oh.xr("Init comes First!", null);
            op.ms(tzVar);
            return;
        }
        if (tzVar.xr == 0) {
            oh.xr((Throwable) null);
        }
        synchronized (bVar.ka) {
            size = bVar.ka.size();
            bVar.ka.add(tzVar);
        }
        if (size % 10 != 0 || (handler = bVar.hi) == null) {
            return;
        }
        handler.removeMessages(4);
        bVar.hi.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void ms(String[] strArr) {
        b bVar = xr;
        if (bVar == null) {
            oh.xr(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = bVar.hi;
        if (handler != null) {
            handler.removeMessages(4);
            bVar.hi.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public int compare(tz tzVar, tz tzVar2) {
        long j = tzVar.xr - tzVar2.xr;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public void ny() {
        Handler handler = this.hi;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.hi.sendEmptyMessage(89);
    }
}
