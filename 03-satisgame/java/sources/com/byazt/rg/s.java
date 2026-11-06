package com.byazt.rg;

import android.view.View;
import com.anythink.core.common.l.f;
import com.byazt.gct.h;
import com.byazt.gct.oa;
import com.byazt.gct.pk;
import com.byazt.gct.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 8})
public class s {
    private static boolean n(int i, int i2, int i3, int i4, float f, float f2) {
        return f >= ((float) i) && f <= ((float) (i3 + i)) && f2 >= ((float) i2) && f2 <= ((float) (i4 + i2));
    }

    public static void n(pk pkVar, oa oaVar, JSONObject jSONObject) {
        if (pkVar == null || oaVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("style_id", oaVar.l());
            jSONObject.put("component_type", oaVar.n());
            jSONObject.put("render_sequence", oaVar.s());
            jSONObject.put("display_area", oaVar.q());
            if (oaVar.qg()) {
                jSONObject.put("style_category", h.w(pkVar));
                jSONObject.put("exp_id", h.x(pkVar));
                jSONObject.put("group_id", h.fs(pkVar));
            }
        } catch (Exception unused) {
        }
    }

    public static void n(pk pkVar, oa oaVar) {
        JSONObject jSONObject = new JSONObject();
        n(pkVar, oaVar, jSONObject);
        com.byazt.hm.n.n(pkVar, "easy_play_start_load", jSONObject);
    }

    public static void n(pk pkVar, oa oaVar, boolean z) {
        n(pkVar, oaVar, z, 0, (JSONObject) null);
    }

    public static void n(pk pkVar, oa oaVar, boolean z, int i) {
        n(pkVar, oaVar, z, i, (JSONObject) null);
    }

    public static void n(pk pkVar, oa oaVar, boolean z, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("error_code", i);
        } catch (Exception unused) {
        }
        n(pkVar, oaVar, jSONObject);
        com.byazt.hm.n.n(pkVar, "easy_play_load_result", jSONObject);
    }

    public static void qg(pk pkVar, oa oaVar) {
        JSONObject jSONObject = new JSONObject();
        n(pkVar, oaVar, jSONObject);
        com.byazt.hm.n.n(pkVar, "easy_play_start_render", jSONObject);
    }

    public static void qg(pk pkVar, oa oaVar, boolean z) {
        n(pkVar, oaVar, z, 0, (String) null);
    }

    public static void n(pk pkVar, oa oaVar, boolean z, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("error_code", i);
            if (str != null) {
                jSONObject.put("error_msg", str);
            }
        } catch (Exception unused) {
        }
        n(pkVar, oaVar, jSONObject);
        com.byazt.hm.n.n(pkVar, "easy_play_render_result", jSONObject);
    }

    public static void qg(pk pkVar, oa oaVar, boolean z, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("error_code", i);
        } catch (Exception unused) {
        }
        n(pkVar, oaVar, jSONObject);
        com.byazt.hm.n.n(pkVar, "easy_play_show", jSONObject);
    }

    public static void n(pk pkVar, oa oaVar, JSONObject jSONObject, int i, View view) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        n(jSONObject, oaVar, i, view);
        qg(pkVar, oaVar, true, 0, jSONObject);
    }

    private static void n(JSONObject jSONObject, oa oaVar, int i, View view) {
        if (jSONObject == null || oaVar == null) {
            return;
        }
        if (i != -1) {
            try {
                jSONObject.put("api_version", i);
            } catch (Exception unused) {
                return;
            }
        }
        int iW = oaVar.w();
        if (iW > 0) {
            jSONObject.put("preferred_size_width", iW);
        }
        int iX = oaVar.x();
        if (iX > 0) {
            jSONObject.put("preferred_size_height", iX);
        }
        double dFs = oaVar.fs();
        if (dFs > 0.0d) {
            jSONObject.put("preferred_aspect_ratio", dFs);
        }
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        jSONObject.put("actual_size_width", com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), view.getWidth()));
        jSONObject.put("actual_size_height", com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), view.getHeight()));
    }

    public static void n(pk pkVar, oa oaVar, boolean z, JSONObject jSONObject) {
        n(pkVar, oaVar, z, jSONObject, false);
    }

    public static void n(pk pkVar, oa oaVar, boolean z, JSONObject jSONObject, boolean z2) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = 2;
        try {
            jSONObject.put(f.ad, z ? 1 : 2);
            int iN = oaVar.n();
            if (iN == 1 || iN == 3) {
                if (!z2) {
                    i = 1;
                }
                jSONObject.put("click_type", i);
            }
        } catch (Exception unused) {
        }
        n(pkVar, oaVar, jSONObject);
        com.byazt.hm.n.n(pkVar, "easy_play_click", jSONObject);
    }

    public static boolean n(View view, com.byazt.twc.s sVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (sVar instanceof wm) {
                wm wmVar = (wm) sVar;
                return n(i, i2, width, height, wmVar.n, wmVar.qg);
            }
        }
        return false;
    }
}
