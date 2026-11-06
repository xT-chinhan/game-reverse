package com.byazt.ua;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 13})
public final class hw {
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    public static void pr(com.byazt.qe.hw hwVar, boolean z, final String str) {
        Boolean bool;
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!zo.pr(hn.pr(), str)) {
                return;
            }
            Activity activityPr = pr();
            Boolean bool2 = Boolean.FALSE;
            String str4 = null;
            if (activityPr == null) {
                bool = bool2;
                str2 = null;
                str3 = null;
            } else {
                String strUc = x.uc();
                w.pr(activityPr);
                CharSequence title = activityPr.getTitle();
                String name = activityPr.getClass().getName();
                Boolean boolValueOf = Boolean.valueOf(activityPr.hasWindowFocus());
                if (title != null) {
                    String string = title.toString();
                    if (!TextUtils.isEmpty(string)) {
                        str4 = name;
                        bool = boolValueOf;
                        str3 = strUc;
                        str2 = string;
                    } else {
                        str3 = strUc;
                        str2 = null;
                        str4 = name;
                        bool = boolValueOf;
                    }
                } else {
                    str3 = strUc;
                    str2 = null;
                    str4 = name;
                    bool = boolValueOf;
                }
            }
            String strM = hwVar != null ? hwVar.m() : " ";
            if (z) {
                pr.pr(str, new pr.C0204pr(str2, str4, str3, bool, null, null, strM));
                if (zo.pr(hn.c(), str)) {
                    final StackTraceElement[] stackTraceElementArrPr = zo.pr();
                    final int iHw = hn.hw();
                    com.byazt.zp.zo.pr(new com.byazt.xlm.fw("stage_feature") { // from class: com.byazt.ua.hw.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                JSONArray jSONArrayPr = zo.pr(stackTraceElementArrPr, iHw);
                                pr.pr(str, jSONArrayPr, (jSONArrayPr == null || jSONArrayPr.length() <= 0) ? " " : zo.pr(jSONArrayPr));
                            } catch (Throwable th) {
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void pr(of ofVar, String str) {
        if (ofVar == null || TextUtils.isEmpty(ofVar.pr())) {
            return;
        }
        try {
            if (!zo.pr(hn.pr(), ofVar.pr())) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            pr.C0204pr c0204prPr = pr.pr(ofVar.pr());
            if (c0204prPr != null) {
                jSONObject.put("top_page_title", c0204prPr.pr);
                jSONObject.put("top_page_name", c0204prPr.hw);
                jSONObject.put("t_name", c0204prPr.hn);
                jSONObject.put("has_window_focus", c0204prPr.x.booleanValue());
                jSONObject.put("call_chain", c0204prPr.c != null ? c0204prPr.c.toString() : " ");
                jSONObject.put("stack_hash", c0204prPr.uc != null ? c0204prPr.uc : " ");
                jSONObject.put("media_extra", c0204prPr.fw);
                jSONObject.put("is_hit_chain", zo.pr(hn.c(), ofVar.pr()));
            } else {
                w.pr(jSONObject, (Activity) null);
                com.byazt.qe.hw hwVarP = ofVar.p();
                if (hwVarP != null) {
                    jSONObject.put("media_extra", TextUtils.isEmpty(hwVarP.m()) ? " " : hwVarP.m());
                }
            }
            jSONObject.put("app_version", ls.vk());
            jSONObject.put("app_no_tab", fw.hn());
            com.byazt.pj.pr.hw(ofVar, str, "load_feature", jSONObject);
        } catch (Throwable th) {
        }
    }

    public static void pr(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!zo.pr(hn.c(), str)) {
                return;
            }
            final StackTraceElement[] stackTraceElementArrPr = zo.pr();
            final int iHw = hn.hw();
            com.byazt.zp.zo.pr(new com.byazt.xlm.fw("stage_feature") { // from class: com.byazt.ua.hw.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        pr.pr(str, zo.pr(stackTraceElementArrPr, iHw));
                    } catch (Throwable th) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public static void pr(of ofVar, String str, View view, boolean z) {
        if (ofVar == null || view == null) {
            return;
        }
        try {
            if (!zo.pr(hn.pr(), ofVar.pr())) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            w.pr(jSONObject, (Activity) null);
            JSONArray jSONArrayHn = pr.hn(ofVar.pr());
            if (jSONArrayHn != null) {
                jSONObject.put("call_chain", jSONArrayHn.toString());
                jSONObject.put("stack_hash", zo.pr(jSONArrayHn));
            } else {
                jSONObject.put("call_chain", " ");
                jSONObject.put("stack_hash", " ");
            }
            boolean zPr = zo.pr(hn.c(), ofVar.pr());
            k.pr(jSONObject, view, hn.hw(), zPr);
            jSONObject.put("is_preload", z);
            jSONObject.put("app_version", ls.vk());
            jSONObject.put("is_hit_chain", zPr);
            com.byazt.pj.pr.hw(ofVar, str, "show_feature", jSONObject);
        } catch (Throwable th) {
        }
    }

    public static void pr(final of ofVar, final String str, Activity activity, String str2, boolean z) {
        final StackTraceElement[] stackTraceElementArrPr;
        if (ofVar == null) {
            return;
        }
        try {
            if (!zo.pr(hn.pr(), ofVar.pr())) {
                return;
            }
            boolean zPr = zo.pr(hn.c(), ofVar.pr());
            if (!zPr) {
                stackTraceElementArrPr = null;
            } else {
                stackTraceElementArrPr = zo.pr();
            }
            final int iHw = hn.hw();
            final JSONObject jSONObject = new JSONObject();
            w.pr(jSONObject, activity);
            if (TextUtils.isEmpty(str2)) {
                str2 = " ";
            }
            jSONObject.put("rit_scene", str2);
            jSONObject.put("is_preload", z);
            jSONObject.put("app_version", ls.vk());
            jSONObject.put("is_hit_chain", zPr);
            com.byazt.zp.zo.pr(new com.byazt.xlm.fw("stage_feature") { // from class: com.byazt.ua.hw.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        StackTraceElement[] stackTraceElementArr = stackTraceElementArrPr;
                        if (stackTraceElementArr == null) {
                            jSONObject.put("call_chain", " ");
                            jSONObject.put("stack_hash", " ");
                        } else {
                            JSONArray jSONArrayPr = zo.pr(stackTraceElementArr, iHw);
                            jSONObject.put("call_chain", jSONArrayPr.toString());
                            jSONObject.put("stack_hash", zo.pr(jSONArrayPr));
                        }
                        com.byazt.pj.pr.hw(ofVar, str, "show_feature", jSONObject);
                    } catch (Throwable th) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    private static Activity pr() {
        try {
            com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
            WeakReference<Activity> weakReferencePr = prVarHn != null ? prVarHn.pr() : null;
            if (weakReferencePr != null) {
                return weakReferencePr.get();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
