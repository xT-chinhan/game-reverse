package com.byazt.eg;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.byazt.af.w;
import com.byazt.hg.of;
import com.byazt.hg.qi;
import com.byazt.is.aj;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.zr.c;
import com.byazt.zr.fw;
import com.byazt.zr.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1609, 13})
public class hw {
    public final x pr;

    private hw() {
        if (!aj.pr()) {
            this.pr = new com.byazt.zr.hw();
            return;
        }
        if (iu.fw) {
            this.pr = new fw();
        } else if (iu.fw()) {
            this.pr = new c();
        } else {
            this.pr = new com.byazt.zr.hw();
        }
    }

    public static final hw pr() {
        return pr.pr;
    }

    public void pr(Function<SparseArray<Object>, Object> function) {
        this.pr.pr(function);
    }

    public int pr(Context context, w wVar, Map<String, Object> map) {
        if (context == null || wVar == null) {
            return 5;
        }
        return this.pr.pr(context, wVar, map);
    }

    public int pr(Context context, long j) {
        return this.pr.pr(context, j);
    }

    public void pr(String str, boolean z) {
        this.pr.pr(str, z);
    }

    public int pr(w wVar, com.byazt.zr.hn hnVar, String str, Map<String, Object> map) {
        return this.pr.pr(wVar, hnVar, str, map);
    }

    public int pr(Context context, of ofVar, Map<String, Object> map) {
        return this.pr.pr(context, ofVar, map);
    }

    public boolean pr(of ofVar) {
        return this.pr.a_(ofVar);
    }

    public void pr(String str, of ofVar, long j) {
        this.pr.pr(str, ofVar, j);
    }

    public boolean hw(of ofVar) {
        if (ofVar == null || TextUtils.isEmpty(ofVar.vk())) {
            return false;
        }
        return pr(ofVar.vk(), ofVar.c());
    }

    public boolean pr(String str, int i) {
        return this.pr.pr(str, i);
    }

    public void hw() {
        this.pr.pr();
    }

    public int hn() {
        return this.pr.hw();
    }

    public int hn(of ofVar) {
        if (!a.hw().td()) {
            return 0;
        }
        return this.pr.hw(ofVar);
    }

    public void x() {
        this.pr.x();
    }

    public int c() {
        return this.pr.c();
    }

    public void x(final of ofVar) {
        if (ofVar == null) {
            return;
        }
        c(ofVar);
        if (TextUtils.isEmpty(ofVar.vk())) {
            return;
        }
        int iHn = com.byazt.mp.x.pr().hn() + 1;
        if (iHn > 100) {
            iHn = 100;
        }
        com.byazt.mp.x.pr().pr(iHn);
        final int iHn2 = hn();
        final int iC = c();
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        if (ofVar.c() == 1 && ofVar.uv() == 1) {
            com.byazt.xk.hw.pr().pr("saas_miss", new com.byazt.ttf.pr() { // from class: com.byazt.eg.hw.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ext", ofVar.B_());
                        jSONObject2.put("live_sdk_status", iHn2);
                        jSONObject2.put("live_auth_status", iC);
                        jSONObject2.put("app_start_time", jElapsedRealtime);
                        jSONObject2.put("is_web", ofVar.x_());
                    } catch (Throwable th) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    public int uc() {
        return com.byazt.mp.x.pr().hn();
    }

    public String fw() {
        return this.pr.fw();
    }

    public void pr(View view, qi qiVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view != null && qiVar != null && (tag = view.getTag(TTAdConstant.KEY_CLICK_AREA)) != null && (tag instanceof Integer)) {
            int iIntValue = ((Integer) tag).intValue();
            int i = iIntValue & 255;
            int i2 = (iIntValue & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
            if (i > 0 && i2 > 0) {
                if (i == 101 && !qiVar.hn()) {
                    i = 102;
                }
                map.put("live_saas_param_interaction_type", Integer.valueOf(i));
                map2.put("click_saas_area", Integer.valueOf(i2));
            }
        }
    }

    public JSONObject zo() {
        return this.pr.zo();
    }

    public int pr(String str) {
        return this.pr.pr(str);
    }

    public int pr(com.byazt.mh.hw hwVar, boolean z) {
        return this.pr.pr(hwVar, z);
    }

    public void c(of ofVar) {
        this.pr.hn(ofVar);
    }

    public void pr(com.byazt.igw.x xVar) {
        this.pr.pr(xVar);
    }

    public long aj() {
        return this.pr.hn();
    }

    public boolean uc(of ofVar) {
        return ofVar != null && ofVar.cr() == 2;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1609, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static final class pr {
        public static final hw pr = new hw();
    }
}
