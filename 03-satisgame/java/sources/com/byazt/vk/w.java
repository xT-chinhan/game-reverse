package com.byazt.vk;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, 13})
public class w {
    public static volatile w n;
    public s l;
    public Context q;
    public qg w;
    public int x = 30;
    public boolean fs = false;
    public final Map<String, List<WeakReference<x>>> qg = new ConcurrentHashMap();
    public final Map<String, l> s = new ConcurrentHashMap();

    private w() {
    }

    public static w n() {
        if (n == null) {
            synchronized (w.class) {
                if (n == null) {
                    n = new w();
                }
            }
        }
        return n;
    }

    public void n(Context context) {
        if (context == null || this.q != null) {
            return;
        }
        this.q = context.getApplicationContext();
        fs.n().n(context);
        fs.n().n(this.x);
        n.n().n(context);
    }

    public void n(s sVar) {
        this.l = sVar;
    }

    public void n(qg qgVar) {
        this.w = qgVar;
    }

    public qg qg() {
        return this.w;
    }

    public void n(int i) {
        if (this.x == i) {
            return;
        }
        this.x = i;
        fs.n().n(i);
    }

    public void n(boolean z) {
        this.fs = z;
    }

    public boolean s() {
        return this.fs;
    }

    public void n(final q qVar, final x xVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.n())) {
            n(xVar, qVar, 1001, "Invalid zip config");
        } else if (this.fs) {
            n(xVar, qVar, 1001, "Zip download is disabled");
        } else {
            com.byazt.qit.l.qg(new com.byazt.qit.x("") { // from class: com.byazt.vk.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.qg(qVar, xVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(q qVar, x xVar) {
        final String strN = qVar.n();
        if (n(qVar)) {
            n(xVar, qVar);
            return;
        }
        synchronized (this) {
            List<WeakReference<x>> list = this.qg.get(strN);
            if (list != null && !list.isEmpty()) {
                list.add(new WeakReference<>(xVar));
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new WeakReference(xVar));
            this.qg.put(strN, arrayList);
            l lVar = new l(this.q);
            this.s.put(strN, lVar);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            lVar.n(qVar, new x() { // from class: com.byazt.vk.w.2
                @Override // com.byazt.vk.x
                public void n(q qVar2) {
                    w.this.n(qVar2, true, System.currentTimeMillis() - jCurrentTimeMillis, 0, (String) null);
                    w.this.n(strN, true, qVar2, 0, (String) null);
                    w.this.n(strN);
                }

                @Override // com.byazt.vk.x
                public void n(q qVar2, int i, String str) {
                    w.this.n(qVar2, false, System.currentTimeMillis() - jCurrentTimeMillis, i, str);
                    w.this.n(strN, false, qVar2, i, str);
                    w.this.n(strN);
                }
            });
        }
    }

    public static boolean n(q qVar) {
        Context context;
        File fileS;
        if (qVar == null || TextUtils.isEmpty(qVar.n()) || (context = n().q) == null || (fileS = com.byazt.qyu.qg.s(context)) == null) {
            return false;
        }
        String strQ = fs.q(qVar.n());
        String strS = qVar.s();
        if (TextUtils.isEmpty(strS)) {
            strS = "img_0.png";
        }
        return new File(fileS, "tt_lottie_imgcac" + File.separator + strQ + File.separator + strS).exists();
    }

    private void n(final x xVar, final q qVar) {
        if (xVar != null) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.vk.w.3
                @Override // java.lang.Runnable
                public void run() {
                    xVar.n(qVar);
                }
            });
        }
    }

    private void n(final x xVar, final q qVar, final int i, final String str) {
        if (xVar != null) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.vk.w.4
                @Override // java.lang.Runnable
                public void run() {
                    xVar.n(qVar, i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, boolean z, q qVar, int i, String str2) {
        List<WeakReference<x>> listRemove;
        synchronized (this) {
            listRemove = this.qg.remove(str);
        }
        if (listRemove == null || listRemove.isEmpty()) {
            return;
        }
        Iterator<WeakReference<x>> it = listRemove.iterator();
        while (it.hasNext()) {
            x xVar = it.next().get();
            if (xVar != null) {
                if (z) {
                    n(xVar, qVar);
                } else {
                    n(xVar, qVar, i, str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        this.s.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(q qVar, boolean z, long j, int i, String str) {
        if (this.l == null || qVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", z);
            jSONObject.put("duration_ms", j);
            jSONObject.put(ImagesContract.URL, qVar.n());
            if (!z) {
                jSONObject.put("error_code", i);
                jSONObject.put("error_desc", str);
            }
            this.l.n("lot_download", jSONObject);
        } catch (Exception unused) {
        }
    }
}
