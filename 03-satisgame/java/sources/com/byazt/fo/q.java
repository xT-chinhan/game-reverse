package com.byazt.fo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.byazt.km.cp;
import com.byazt.km.d;
import com.byazt.km.oa;
import com.byazt.km.sz;
import com.byazt.ko.fs;
import com.byazt.ko.rv;
import com.byazt.ni.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1154, 5})
public class q implements Handler.Callback, Comparator<com.byazt.yi.n> {
    public static long oa;
    public static q qg;
    public Handler cp;
    public w d;
    public Handler fs;
    public Application n;
    public fs q;
    public x rv;
    public n s;
    public d tj;
    public com.byazt.yi.qg w;
    public rv x;
    public final ArrayList<com.byazt.yi.n> l = new ArrayList<>(32);
    public CopyOnWriteArrayList<Message> sz = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<com.byazt.yi.x> k = new CopyOnWriteArrayList<>();

    public static void n() {
        if (qg != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - oa) > 10000) {
                oa = jCurrentTimeMillis;
                qg.n((String[]) null, true);
            }
        }
    }

    private q() {
    }

    public Context getContext() {
        return this.n;
    }

    public com.byazt.yi.qg qg() {
        return this.w;
    }

    public fs s() {
        return this.q;
    }

    public rv q() {
        return this.x;
    }

    public static q l() {
        if (qg == null) {
            synchronized (q.class) {
                if (qg == null) {
                    qg = new q();
                }
            }
        }
        return qg;
    }

    public x w() {
        return this.rv;
    }

    public d x() {
        if (this.tj == null) {
            d dVarTj = this.q.wo().tj();
            this.tj = dVarTj;
            if (dVarTj == null) {
                this.tj = oa.n(0);
            }
        }
        return this.tj;
    }

    public void n(Application application, fs fsVar, rv rvVar, com.byazt.ni.n nVar) {
        this.n = application;
        this.w = new com.byazt.yi.qg(this);
        this.q = fsVar;
        this.x = rvVar;
        this.rv = new x(this.x, this.q);
        this.n.registerActivityLifecycleCallbacks(nVar);
        Looper looperN = sz.n(fsVar);
        if (looperN == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            looperN = handlerThread.getLooper();
        }
        Handler handler = new Handler(looperN, this);
        this.cp = handler;
        handler.sendEmptyMessage(1);
        com.byazt.km.fs.n(fsVar.rv() != 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i = message.what;
            if (i == 1) {
                cp.n = this.q.ou();
                if (this.x.w()) {
                    if (this.q.hd()) {
                        Looper looperQg = sz.qg(this.q);
                        if (looperQg == null) {
                            HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                            handlerThread.start();
                            looperQg = handlerThread.getLooper();
                        }
                        Handler handler = new Handler(looperQg, this);
                        this.fs = handler;
                        handler.sendEmptyMessage(2);
                        if (this.l.size() > 0) {
                            this.cp.removeMessages(4);
                            this.cp.sendEmptyMessageDelayed(4, 1000L);
                        }
                        cp.q("net|worker start", null);
                    }
                } else {
                    this.cp.removeMessages(1);
                    this.cp.sendEmptyMessageDelayed(1, 1000L);
                }
                com.byazt.ko.qg.n();
            } else if (i == 2) {
                ArrayList<qg> arrayList = new ArrayList(4);
                arrayList.add(new l(this));
                arrayList.add(new s(this));
                w wVar = new w(this);
                this.d = wVar;
                arrayList.add(wVar);
                for (qg qgVar : arrayList) {
                    if (qgVar instanceof w) {
                        this.d.n(sz.n());
                    }
                    long jX = qgVar.x();
                    if (jX < 864000000) {
                        int i2 = (int) jX;
                        Message messageObtainMessage = this.cp.obtainMessage(6, i2, i2, qgVar);
                        this.sz.add(messageObtainMessage);
                        this.fs.sendMessageDelayed(messageObtainMessage, jX);
                    }
                }
                this.d.n(true);
                cp();
            } else if (i == 4) {
                n((String[]) null, false);
            } else if (i == 5) {
                n((String[]) message.obj, false);
            } else if (i == 6) {
                qg qgVar2 = (qg) message.obj;
                try {
                    this.sz.remove(message);
                } catch (Exception unused) {
                }
                if (!qgVar2.w()) {
                    long jX2 = qgVar2.x();
                    if (jX2 < 864000000 && !n(this.sz, qgVar2)) {
                        int i3 = (int) jX2;
                        Message messageObtainMessage2 = this.cp.obtainMessage(6, i3, i3, qgVar2);
                        this.sz.add(messageObtainMessage2);
                        this.fs.sendMessageDelayed(messageObtainMessage2, jX2);
                    }
                    cp();
                }
                this.d.n(true);
            } else if (i == 7) {
                synchronized (this.l) {
                    this.l.add(x.l());
                }
                n((String[]) null, false);
            } else if (i == 89) {
                rv rvVar = this.x;
                if (rvVar != null) {
                    rvVar.l();
                }
            } else {
                cp.qg((Throwable) null);
            }
        } catch (Throwable th) {
            cp.n("engine:" + th.getMessage());
        }
        return true;
    }

    private boolean n(List<Message> list, qg qgVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).obj == qgVar) {
                return true;
            }
        }
        return false;
    }

    private void cp() {
        if (this.q.py()) {
            if (this.s == null) {
                n nVar = new n(this);
                this.s = nVar;
                Message messageObtainMessage = this.fs.obtainMessage(6, nVar);
                this.sz.add(messageObtainMessage);
                messageObtainMessage.sendToTarget();
                return;
            }
            return;
        }
        n nVar2 = this.s;
        if (nVar2 != null) {
            nVar2.l();
            this.s = null;
        }
    }

    private void n(String[] strArr, boolean z) {
        ArrayList<com.byazt.yi.n> arrayList;
        synchronized (this.l) {
            arrayList = (ArrayList) this.l.clone();
            this.l.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(com.byazt.yi.n.n(str));
            }
        }
        boolean zN = this.q.n(arrayList);
        if (arrayList.size() > 0) {
            if (this.q.hd()) {
                if (zN || arrayList.size() > 100) {
                    Collections.sort(arrayList, this);
                    ArrayList<com.byazt.yi.n> arrayList2 = new ArrayList<>(arrayList.size());
                    boolean zN2 = false;
                    boolean zN3 = false;
                    for (com.byazt.yi.n nVar : arrayList) {
                        zN2 |= this.rv.n(nVar, arrayList2);
                        if (nVar instanceof com.byazt.yi.rv) {
                            zN3 = x.n(nVar);
                            i = 1;
                        }
                    }
                    this.w.n(arrayList2);
                    if (i != 0) {
                        if (zN3) {
                            this.cp.removeMessages(7);
                        } else if (!sz.qg() && sz.n()) {
                            this.cp.sendEmptyMessageDelayed(7, this.q.wm());
                        }
                    }
                    if (zN2 || z) {
                        d();
                        return;
                    }
                    return;
                }
                synchronized (this.l) {
                    this.l.addAll(arrayList);
                }
                return;
            }
            Intent intent = new Intent(this.n, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int length = 0;
            while (i < size) {
                String string = arrayList.get(i).l().toString();
                strArr2[i] = string;
                length += string.length();
                i++;
            }
            if (length >= 307200) {
                cp.qg((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.n.sendBroadcast(intent);
            } catch (Exception e) {
                cp.qg(e);
            }
        }
    }

    private void d() {
        if (cp.qg) {
            cp.n("packAndSend once, " + this.rv.n() + ", hadUI:" + this.rv.qg(), null);
        }
        w wVar = this.d;
        if (wVar != null) {
            wVar.fs();
        }
        if (this.fs != null) {
            this.d.n(sz.n());
            Message messageObtainMessage = this.cp.obtainMessage(6, this.d);
            this.sz.add(messageObtainMessage);
            this.fs.sendMessage(messageObtainMessage);
        }
    }

    public static void n(com.byazt.yi.n nVar) {
        int size;
        Handler handler;
        q qVar = qg;
        if (qVar == null) {
            cp.qg("Init comes First!", null);
            com.byazt.ko.qg.n(nVar);
            return;
        }
        if (nVar.qg == 0) {
            cp.qg((Throwable) null);
        }
        synchronized (qVar.l) {
            size = qVar.l.size();
            qVar.l.add(nVar);
        }
        if (size % 10 != 0 || (handler = qVar.cp) == null) {
            return;
        }
        handler.removeMessages(4);
        qVar.cp.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void n(String[] strArr) {
        q qVar = qg;
        if (qVar == null) {
            cp.qg(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = qVar.cp;
        if (handler != null) {
            handler.removeMessages(4);
            qVar.cp.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compare(com.byazt.yi.n nVar, com.byazt.yi.n nVar2) {
        long j = nVar.qg - nVar2.qg;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public void fs() {
        Handler handler = this.cp;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.cp.sendEmptyMessage(89);
    }

    public void rv() {
        if (this.fs.hasMessages(6)) {
            int size = this.sz.size();
            for (int i = 0; i < size; i++) {
                this.k.add(com.byazt.yi.x.n(this.sz.get(i)));
            }
            this.sz.clear();
            this.fs.removeMessages(6);
        }
    }

    public void tj() {
        if (this.fs == null || this.k.isEmpty()) {
            return;
        }
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            try {
                com.byazt.yi.x xVar = this.k.get(i);
                Message messageN = com.byazt.yi.x.n(this.fs, xVar);
                long jN = com.byazt.yi.x.n(xVar);
                if (messageN.what == 6) {
                    this.sz.add(messageN);
                    this.fs.sendMessageDelayed(messageN, jN);
                }
            } catch (Exception unused) {
            }
        }
        this.k.clear();
    }
}
