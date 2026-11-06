package com.byazt.gox;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.byazt.cl.Collector;
import com.byazt.ec.g;
import com.byazt.ec.k;
import com.byazt.ec.m;
import com.byazt.ec.w;
import com.byazt.xa.aj;
import com.byazt.xa.zo;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 121})
public class x implements Handler.Callback, Comparator<com.byazt.kg.pr> {
    public static x hw;
    public static long m;
    public fw aj;
    public aj fw;
    public pr hn;
    public uc k;
    public Application pr;
    public com.byazt.kg.hw uc;
    public k vk;
    public Handler w;
    public zo x;
    public Handler zo;
    public final ArrayList<com.byazt.kg.pr> c = new ArrayList<>(32);
    public CopyOnWriteArrayList<Message> g = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<com.byazt.kg.fw> ho = new CopyOnWriteArrayList<>();

    public static void pr() {
        if (hw != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - m) > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                m = jCurrentTimeMillis;
                hw.pr((String[]) null, true);
            }
        }
    }

    private x() {
    }

    public Context getContext() {
        return this.pr;
    }

    public com.byazt.kg.hw hw() {
        return this.uc;
    }

    public zo hn() {
        return this.x;
    }

    public aj x() {
        return this.fw;
    }

    public static x c() {
        if (hw == null) {
            synchronized (x.class) {
                if (hw == null) {
                    hw = new x();
                }
            }
        }
        return hw;
    }

    public fw uc() {
        return this.aj;
    }

    public k fw() {
        if (this.vk == null) {
            k kVarVk = this.x.i().vk();
            this.vk = kVarVk;
            if (kVarVk == null) {
                this.vk = m.pr(0);
            }
        }
        return this.vk;
    }

    public void pr(Application application, zo zoVar, aj ajVar, com.byazt.cl.pr prVar) {
        this.pr = application;
        this.uc = new com.byazt.kg.hw(this);
        this.x = zoVar;
        this.fw = ajVar;
        this.aj = new fw(this.fw, this.x);
        this.pr.registerActivityLifecycleCallbacks(prVar);
        Looper looperPr = g.pr(zoVar);
        if (looperPr == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            looperPr = handlerThread.getLooper();
        }
        Handler handler = new Handler(looperPr, this);
        this.w = handler;
        handler.sendEmptyMessage(1);
        com.byazt.ec.zo.pr(zoVar.aj() != 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 1:
                    w.pr = this.x.ny();
                    if (!this.fw.uc()) {
                        this.w.removeMessages(1);
                        this.w.sendEmptyMessageDelayed(1, 1000L);
                    } else if (this.x.yb()) {
                        Looper looperHw = g.hw(this.x);
                        if (looperHw == null) {
                            HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                            handlerThread.start();
                            looperHw = handlerThread.getLooper();
                        }
                        Handler handler = new Handler(looperHw, this);
                        this.zo = handler;
                        handler.sendEmptyMessage(2);
                        if (this.c.size() > 0) {
                            this.w.removeMessages(4);
                            this.w.sendEmptyMessageDelayed(4, 1000L);
                        }
                        w.x("net|worker start", null);
                    }
                    com.byazt.xa.hw.pr();
                    return true;
                case 2:
                    ArrayList<hw> arrayList = new ArrayList(4);
                    arrayList.add(new c(this));
                    arrayList.add(new hn(this));
                    uc ucVar = new uc(this);
                    this.k = ucVar;
                    arrayList.add(ucVar);
                    for (hw hwVar : arrayList) {
                        if (hwVar instanceof uc) {
                            this.k.pr(g.pr());
                        }
                        long jFw = hwVar.fw();
                        if (jFw < 864000000) {
                            int i = (int) jFw;
                            Message messageObtainMessage = this.w.obtainMessage(6, i, i, hwVar);
                            this.g.add(messageObtainMessage);
                            this.zo.sendMessageDelayed(messageObtainMessage, jFw);
                        }
                    }
                    this.k.pr(true);
                    w();
                    return true;
                case 4:
                    pr((String[]) null, false);
                    return true;
                case 5:
                    pr((String[]) message.obj, false);
                    return true;
                case 6:
                    hw hwVar2 = (hw) message.obj;
                    try {
                        this.g.remove(message);
                        break;
                    } catch (Exception e) {
                    }
                    if (!hwVar2.uc()) {
                        long jFw2 = hwVar2.fw();
                        if (jFw2 < 864000000 && !pr(this.g, hwVar2)) {
                            int i2 = (int) jFw2;
                            Message messageObtainMessage2 = this.w.obtainMessage(6, i2, i2, hwVar2);
                            this.g.add(messageObtainMessage2);
                            this.zo.sendMessageDelayed(messageObtainMessage2, jFw2);
                        }
                        w();
                    }
                    this.k.pr(true);
                    return true;
                case 7:
                    synchronized (this.c) {
                        this.c.add(fw.c());
                        break;
                    }
                    pr((String[]) null, false);
                    return true;
                case 89:
                    aj ajVar = this.fw;
                    if (ajVar != null) {
                        ajVar.c();
                    }
                    return true;
                default:
                    w.hw((Throwable) null);
                    return true;
            }
        } catch (Throwable th) {
            w.pr("engine:" + th.getMessage());
        }
    }

    private boolean pr(List<Message> list, hw hwVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).obj == hwVar) {
                return true;
            }
        }
        return false;
    }

    private void w() {
        if (this.x.cz()) {
            if (this.hn == null) {
                pr prVar = new pr(this);
                this.hn = prVar;
                Message messageObtainMessage = this.zo.obtainMessage(6, prVar);
                this.g.add(messageObtainMessage);
                messageObtainMessage.sendToTarget();
                return;
            }
            return;
        }
        pr prVar2 = this.hn;
        if (prVar2 != null) {
            prVar2.c();
            this.hn = null;
        }
    }

    private void pr(String[] strArr, boolean z) {
        ArrayList<com.byazt.kg.pr> arrayList;
        synchronized (this.c) {
            arrayList = (ArrayList) this.c.clone();
            this.c.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(com.byazt.kg.pr.pr(str));
            }
        }
        boolean zPr = this.x.pr(arrayList);
        if (arrayList.size() > 0) {
            if (this.x.yb()) {
                if (zPr || arrayList.size() > 100) {
                    Collections.sort(arrayList, this);
                    ArrayList<com.byazt.kg.pr> arrayList2 = new ArrayList<>(arrayList.size());
                    boolean zPr2 = false;
                    boolean zPr3 = false;
                    for (com.byazt.kg.pr prVar : arrayList) {
                        zPr2 |= this.aj.pr(prVar, arrayList2);
                        if (prVar instanceof com.byazt.kg.aj) {
                            zPr3 = fw.pr(prVar);
                            i = 1;
                        }
                    }
                    this.uc.pr(arrayList2);
                    if (i != 0) {
                        if (zPr3) {
                            this.w.removeMessages(7);
                        } else if (!g.hw() && g.pr()) {
                            this.w.sendEmptyMessageDelayed(7, this.x.fo());
                        }
                    }
                    if (zPr2 || z) {
                        k();
                        return;
                    }
                    return;
                }
                synchronized (this.c) {
                    this.c.addAll(arrayList);
                }
                return;
            }
            Intent intent = new Intent(this.pr, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int length = 0;
            while (i < size) {
                String string = arrayList.get(i).c().toString();
                strArr2[i] = string;
                length += string.length();
                i++;
            }
            if (length >= 307200) {
                w.hw((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.pr.sendBroadcast(intent);
            } catch (Exception e) {
                w.hw(e);
            }
        }
    }

    private void k() {
        if (w.hw) {
            w.pr("packAndSend once, " + this.aj.pr() + ", hadUI:" + this.aj.hw(), null);
        }
        uc ucVar = this.k;
        if (ucVar != null) {
            ucVar.zo();
        }
        if (this.zo != null) {
            this.k.pr(g.pr());
            Message messageObtainMessage = this.w.obtainMessage(6, this.k);
            this.g.add(messageObtainMessage);
            this.zo.sendMessage(messageObtainMessage);
        }
    }

    public static void pr(com.byazt.kg.pr prVar) {
        int size;
        Handler handler;
        x xVar = hw;
        if (xVar == null) {
            w.hw("Init comes First!", null);
            com.byazt.xa.hw.pr(prVar);
            return;
        }
        if (prVar.hw == 0) {
            w.hw((Throwable) null);
        }
        synchronized (xVar.c) {
            size = xVar.c.size();
            xVar.c.add(prVar);
        }
        if (size % 10 == 0 && (handler = xVar.w) != null) {
            handler.removeMessages(4);
            xVar.w.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
        }
    }

    public static void pr(String[] strArr) {
        x xVar = hw;
        if (xVar == null) {
            w.hw(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = xVar.w;
        if (handler != null) {
            handler.removeMessages(4);
            xVar.w.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public int compare(com.byazt.kg.pr prVar, com.byazt.kg.pr prVar2) {
        long j = prVar.hw - prVar2.hw;
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            return 1;
        }
        return 0;
    }

    public void zo() {
        Handler handler = this.w;
        if (handler != null && !handler.hasMessages(89)) {
            this.w.sendEmptyMessage(89);
        }
    }

    public void aj() {
        if (this.zo.hasMessages(6)) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                this.ho.add(com.byazt.kg.fw.pr(this.g.get(i)));
            }
            this.g.clear();
            this.zo.removeMessages(6);
        }
    }

    public void vk() {
        if (this.zo != null && !this.ho.isEmpty()) {
            int size = this.ho.size();
            for (int i = 0; i < size; i++) {
                try {
                    com.byazt.kg.fw fwVar = this.ho.get(i);
                    Message messagePr = com.byazt.kg.fw.pr(this.zo, fwVar);
                    long jPr = com.byazt.kg.fw.pr(fwVar);
                    if (messagePr.what == 6) {
                        this.g.add(messagePr);
                        this.zo.sendMessageDelayed(messagePr, jPr);
                    }
                } catch (Exception e) {
                }
            }
            this.ho.clear();
        }
    }
}
