package com.byazt.ie;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.vy.py;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 21})
public class x implements n.InterfaceC0201n {
    public List<n> n;
    public int q;
    public com.byazt.zb.qg qg;
    public int s;

    public static /* synthetic */ int q(x xVar) {
        int i = xVar.s;
        xVar.s = i + 1;
        return i;
    }

    public static /* synthetic */ int w(x xVar) {
        int i = xVar.q;
        xVar.q = i + 1;
        return i;
    }

    public x(List<n> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.n = copyOnWriteArrayList;
        this.s = 0;
        this.q = 0;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    @Override // com.byazt.ie.n.InterfaceC0201n
    public void n(com.byazt.zb.qg qgVar) {
        if (this.qg != qgVar && qgVar != null) {
            this.qg = qgVar;
        }
        if (py.n(this.n)) {
            return;
        }
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.ie.x.1
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.s == 0 && x.this.qg != null) {
                    x.this.qg.qg(SystemClock.elapsedRealtime());
                }
                if (x.this.n.size() > x.this.s) {
                    ((n) x.this.n.get(x.q(x.this))).n(x.this);
                }
            }
        });
    }

    @Override // com.byazt.ie.n.InterfaceC0201n
    public com.byazt.zb.qg n() {
        return this.qg;
    }

    @Override // com.byazt.ie.n.InterfaceC0201n
    public void n(String str) {
        com.byazt.zb.qg qgVar;
        if (!TextUtils.isEmpty(str) && (qgVar = this.qg) != null) {
            qgVar.qg(str);
        }
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.ie.x.2
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.n.size() > x.this.q) {
                    ((n) x.this.n.get(x.w(x.this))).qg(x.this);
                }
            }
        });
    }
}
