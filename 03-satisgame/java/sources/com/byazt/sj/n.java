package com.byazt.sj;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 83, 19})
public class n {
    public final String n;
    public InterfaceC0334n qg;

    /* JADX INFO: renamed from: com.byazt.sj.n$n, reason: collision with other inner class name */
    public interface InterfaceC0334n {
        void l(int i);

        void n(int i);

        void n(String str, int i);

        void q(int i);

        void qg(int i);

        void s(int i);

        void w(int i);
    }

    public n(String str) {
        this.n = str;
    }

    public void n(InterfaceC0334n interfaceC0334n) {
        this.qg = interfaceC0334n;
    }

    public void n(double d) {
        HashMap map = new HashMap();
        map.put(NotificationCompat.CATEGORY_PROGRESS, Double.valueOf(d));
        n("gameScore", map);
    }

    public void n(boolean z) {
        HashMap map = new HashMap();
        map.put("result", z ? "win" : "lose");
        n("gameResult", map);
    }

    private void n(String str, Map<String, Object> map) {
        try {
            com.byazt.sx.q.n().n(this.n, str, map);
        } catch (Throwable unused) {
        }
    }

    public void n(String str, int i) {
        if (this.qg == null) {
        }
        str.hashCode();
        switch (str) {
            case "game_interact":
                this.qg.q(i);
                break;
            case "game_restart":
                this.qg.s(i);
                break;
            case "game_finish":
                this.qg.l(i);
                break;
            case "game_pause":
                this.qg.qg(i);
                break;
            case "game_start":
                this.qg.n(i);
                break;
            case "game_next":
                this.qg.w(i);
                break;
        }
    }

    public void qg(String str, int i) {
        InterfaceC0334n interfaceC0334n = this.qg;
        if (interfaceC0334n != null) {
            interfaceC0334n.n(str, i);
        }
    }

    public void n() {
        try {
            com.byazt.sx.q.n().n(this.n);
        } catch (Throwable unused) {
        }
    }
}
