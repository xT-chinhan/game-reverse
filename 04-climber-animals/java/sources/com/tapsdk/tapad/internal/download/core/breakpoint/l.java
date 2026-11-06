package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class l implements Handler.Callback {
    private static final String d = "RemitSyncExecutor";
    static final int e = 0;
    static final int f = -1;
    static final int g = -2;
    static final int h = -3;
    private final Handler a;
    private final Set<Integer> b;
    private final a c;

    interface a {
        void a(List<Integer> list) throws IOException;

        void d(int i);

        void f(int i) throws IOException;
    }

    l(a aVar) {
        this.c = aVar;
        this.b = new HashSet();
        HandlerThread handlerThread = new HandlerThread("OkDownload RemitHandoverToDB");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper(), this);
    }

    l(a aVar, Handler handler, Set<Integer> set) {
        this.c = aVar;
        this.a = handler;
        this.b = set;
    }

    void a() {
        this.a.getLooper().quit();
    }

    public void a(int i, long j) {
        this.a.sendEmptyMessageDelayed(i, j);
    }

    public void a(List<Integer> list) {
        Message messageObtainMessage = this.a.obtainMessage(-1);
        messageObtainMessage.obj = list;
        this.a.sendMessage(messageObtainMessage);
    }

    void a(int[] iArr) {
        for (int i : iArr) {
            this.a.removeMessages(i);
        }
    }

    boolean a(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    public void b(int i) {
        Message messageObtainMessage = this.a.obtainMessage(-2);
        messageObtainMessage.arg1 = i;
        this.a.sendMessage(messageObtainMessage);
    }

    public void b(List<Integer> list) {
        Message messageObtainMessage = this.a.obtainMessage(0);
        messageObtainMessage.obj = list;
        this.a.sendMessage(messageObtainMessage);
    }

    public void c(int i) {
        Message messageObtainMessage = this.a.obtainMessage(-3);
        messageObtainMessage.arg1 = i;
        this.a.sendMessage(messageObtainMessage);
    }

    public void d(int i) {
        this.a.sendEmptyMessage(i);
    }

    void e(int i) {
        this.a.removeMessages(i);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        StringBuilder sb;
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        int i2 = message.what;
        if (i2 != -3) {
            if (i2 == -2) {
                i = message.arg1;
                this.b.remove(Integer.valueOf(i));
                sb = new StringBuilder("remove free bunch id ");
            } else {
                if (i2 != -1) {
                    if (i2 != 0) {
                        try {
                            this.c.f(i2);
                            this.b.add(Integer.valueOf(i2));
                            com.tapsdk.tapad.internal.download.m.c.a(d, "sync info with id: " + i2);
                            return true;
                        } catch (IOException unused) {
                            sbAppend2 = new StringBuilder("sync cache to db failed for id: ").append(i2);
                        }
                    } else {
                        List<Integer> list = (List) message.obj;
                        try {
                            this.c.a(list);
                            this.b.addAll(list);
                            com.tapsdk.tapad.internal.download.m.c.a(d, "sync bunch info with ids: " + list);
                            return true;
                        } catch (IOException unused2) {
                            sbAppend2 = new StringBuilder("sync info to db failed for ids: ").append(list);
                        }
                    }
                    com.tapsdk.tapad.internal.download.m.c.c(d, sbAppend2.toString());
                    return true;
                }
                List list2 = (List) message.obj;
                this.b.removeAll(list2);
                sbAppend = new StringBuilder("remove free bunch ids ").append(list2);
            }
            com.tapsdk.tapad.internal.download.m.c.a(d, sbAppend.toString());
            return true;
        }
        i = message.arg1;
        this.b.remove(Integer.valueOf(i));
        this.c.d(i);
        sb = new StringBuilder("remove info ");
        sbAppend = sb.append(i);
        com.tapsdk.tapad.internal.download.m.c.a(d, sbAppend.toString());
        return true;
    }
}
