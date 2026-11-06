package com.byazt.ee;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.byazt.hb.fs;
import com.byazt.imu.s;
import com.byazt.mcb.qg;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.q;
import com.byazt.pp.rv;
import com.byazt.si.cy;
import com.byazt.si.m;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 84, 19})
public class n implements q {
    public final LottieAnimationView n;
    public final JSONObject qg;
    public final Map<String, Bitmap> s = new ConcurrentHashMap();
    public final Map<String, Boolean> q = new ConcurrentHashMap();
    public final Map<String, Boolean> l = new ConcurrentHashMap();

    public n(LottieAnimationView lottieAnimationView, JSONObject jSONObject) {
        this.n = lottieAnimationView;
        this.qg = jSONObject;
    }

    @Override // com.byazt.pp.q
    public Bitmap n(final rv rvVar) {
        if (rvVar == null) {
            return null;
        }
        final String strQg = qg(rvVar);
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        Bitmap bitmap = this.s.get(strQg);
        if (bitmap != null) {
            return bitmap;
        }
        if (Boolean.TRUE.equals(this.l.get(strQg)) || Boolean.TRUE.equals(this.q.get(strQg))) {
            return null;
        }
        this.q.put(strQg, Boolean.TRUE);
        s.n(strQg).s(2).n(new m<Bitmap>() { // from class: com.byazt.ee.n.1
            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                final Bitmap bitmapS = cyVar != null ? cyVar.s() : null;
                n.this.q.remove(strQg);
                if (bitmapS == null) {
                    n.this.l.put(strQg, Boolean.TRUE);
                } else {
                    n.this.s.put(strQg, bitmapS);
                    fs.n(new Runnable() { // from class: com.byazt.ee.n.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.n.n(rvVar.d(), bitmapS);
                        }
                    });
                }
            }

            @Override // com.byazt.si.m
            public void n(int i, String str, Throwable th) {
                n.this.q.remove(strQg);
                n.this.l.put(strQg, Boolean.TRUE);
            }
        });
        return null;
    }

    private String qg(rv rvVar) {
        String strSz = rvVar.sz();
        String strOa = rvVar.oa();
        String strQ = rvVar.q();
        if (!TextUtils.isEmpty(strQ) && strQ.startsWith("${") && "image:".equals(strSz)) {
            return qg.n(strQ, this.qg);
        }
        if (!TextUtils.isEmpty(strSz) && TextUtils.isEmpty(strOa)) {
            return qg.n(strSz, this.qg);
        }
        if (!TextUtils.isEmpty(strOa) && TextUtils.isEmpty(strSz)) {
            return qg.n(strOa, this.qg);
        }
        if (TextUtils.isEmpty(strOa) || TextUtils.isEmpty(strSz)) {
            return null;
        }
        return qg.n(strSz, this.qg) + qg.n(strOa, this.qg);
    }
}
