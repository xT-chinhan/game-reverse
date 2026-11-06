package com.byazt.uq;

import android.view.View;
import com.byazt.hg.b;
import com.byazt.hg.fo;
import com.byazt.hg.of;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 20})
public class hn {
    public static void pr(of ofVar, com.byazt.hg.m mVar, JSONObject jSONObject) {
        if (ofVar == null || mVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("style_id", mVar.c());
            jSONObject.put("component_type", mVar.pr());
            jSONObject.put("render_sequence", mVar.hn());
            jSONObject.put("display_area", mVar.x());
            if (mVar.hw()) {
                jSONObject.put("style_category", b.c(ofVar));
                jSONObject.put("exp_id", b.uc(ofVar));
                jSONObject.put("group_id", b.fw(ofVar));
            }
        } catch (Exception e) {
        }
    }

    public static void pr(of ofVar, com.byazt.hg.m mVar) {
        JSONObject jSONObject = new JSONObject();
        pr(ofVar, mVar, jSONObject);
        com.byazt.pj.pr.pr(ofVar, "easy_play_start_load", jSONObject);
    }

    public static void pr(of ofVar, com.byazt.hg.m mVar, boolean z) {
        pr(ofVar, mVar, z, 0, (JSONObject) null);
    }

    public static void pr(of ofVar, com.byazt.hg.m mVar, boolean z, int i) {
        pr(ofVar, mVar, z, i, (JSONObject) null);
    }

    public static void pr(of ofVar, com.byazt.hg.m mVar, boolean z, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(TrackAction.SUCCESS, z ? 1 : 0);
            jSONObject.put(Constants.ERROR_CODE_FIELD, i);
        } catch (Exception e) {
        }
        pr(ofVar, mVar, jSONObject);
        com.byazt.pj.pr.pr(ofVar, "easy_play_load_result", jSONObject);
    }

    public static void hw(of ofVar, com.byazt.hg.m mVar) {
        JSONObject jSONObject = new JSONObject();
        pr(ofVar, mVar, jSONObject);
        com.byazt.pj.pr.pr(ofVar, "easy_play_start_render", jSONObject);
    }

    public static void hw(of ofVar, com.byazt.hg.m mVar, boolean z) {
        pr(ofVar, mVar, z, 0, (String) null);
    }

    public static void pr(of ofVar, com.byazt.hg.m mVar, boolean z, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackAction.SUCCESS, z ? 1 : 0);
            jSONObject.put(Constants.ERROR_CODE_FIELD, i);
            if (str != null) {
                jSONObject.put(Constants.ERROR_MSG_FIELD, str);
            }
        } catch (Exception e) {
        }
        pr(ofVar, mVar, jSONObject);
        com.byazt.pj.pr.pr(ofVar, "easy_play_render_result", jSONObject);
    }

    public static void pr(of ofVar, com.byazt.hg.m mVar, boolean z, JSONObject jSONObject) {
        hw(ofVar, mVar, z, 0, jSONObject);
    }

    public static void hw(of ofVar, com.byazt.hg.m mVar, boolean z, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(TrackAction.SUCCESS, z ? 1 : 0);
            jSONObject.put(Constants.ERROR_CODE_FIELD, i);
        } catch (Exception e) {
        }
        pr(ofVar, mVar, jSONObject);
        com.byazt.pj.pr.pr(ofVar, "easy_play_show", jSONObject);
    }

    public static void hw(of ofVar, com.byazt.hg.m mVar, boolean z, JSONObject jSONObject) {
        pr(ofVar, mVar, z, jSONObject, false);
    }

    public static void pr(of ofVar, com.byazt.hg.m mVar, boolean z, JSONObject jSONObject, boolean z2) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = 2;
        try {
            jSONObject.put("area_type", z ? 1 : 2);
            int iPr = mVar.pr();
            if (iPr == 1 || iPr == 3) {
                if (!z2) {
                    i = 1;
                }
                jSONObject.put("click_type", i);
            }
        } catch (Exception e) {
        }
        pr(ofVar, mVar, jSONObject);
        com.byazt.pj.pr.pr(ofVar, "easy_play_click", jSONObject);
    }

    public static boolean pr(View view, com.byazt.dj.hn hnVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (hnVar instanceof fo) {
                fo foVar = (fo) hnVar;
                return pr(i, i2, width, height, foVar.pr, foVar.hw);
            }
        }
        return false;
    }

    private static boolean pr(int i, int i2, int i3, int i4, float f, float f2) {
        return f >= ((float) i) && f <= ((float) (i3 + i)) && f2 >= ((float) i2) && f2 <= ((float) (i4 + i2));
    }
}
