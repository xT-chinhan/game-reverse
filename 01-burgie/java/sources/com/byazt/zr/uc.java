package com.byazt.zr;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.af.w;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.hg.f;
import com.byazt.hg.lv;
import com.byazt.hg.of;
import com.byazt.hg.qi;
import com.byazt.hg.yb;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.cz;
import com.byazt.sd.zo;
import com.byazt.wt.ls;
import com.byazt.wt.ww;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 5})
public abstract class uc extends com.byazt.zr.pr {
    public String c;
    public volatile SoftReference<of> uc;
    public String x;

    protected interface pr {
        void pr(boolean z);
    }

    @Override // com.byazt.zr.pr, com.byazt.zr.x
    public void pr(Function<SparseArray<Object>, Object> function) {
        super.pr(function);
    }

    @Override // com.byazt.zr.pr
    public void a_(String str) {
        this.c = str;
    }

    @Override // com.byazt.zr.x
    public int pr(final Context context, final w wVar, final Map<String, Object> map) {
        int i;
        String str;
        lv lvVarX;
        hn(wVar);
        final int iC = wVar.c();
        if (iC == 9 && Objects.equals(map.get("saas_status_while_click"), 2) && wVar.I_() != null && wVar.I_().hn() != null) {
            i = 2;
        } else {
            i = iC;
        }
        if (!pr(wVar.vk(), i)) {
            return 6;
        }
        if (map == null) {
            str = "";
        } else {
            str = (String) map.get("event_tag");
        }
        if (!uc()) {
            pr(com.byazt.lx.hw.pr(wVar, map), str, iC, 1, i == 7 ? 1 : 2);
            return 1;
        }
        com.byazt.lx.hw.pr(wVar, map).le();
        if (this.pr != null) {
            this.hw = str;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final String str2 = str;
            if (c() != 2 ? pr(wVar, new pr() { // from class: com.byazt.zr.uc.1
                @Override // com.byazt.zr.uc.pr
                public void pr(boolean z) {
                    boolean z2;
                    if (!atomicBoolean.compareAndSet(false, true)) {
                        z2 = true;
                    } else {
                        uc ucVar = uc.this;
                        ucVar.pr(context, wVar, iC, ucVar.hw, (Map<String, Object>) map);
                        z2 = false;
                    }
                    com.byazt.xk.hw.pr().pr(com.byazt.lx.hw.pr(wVar, (Map<String, Object>) map), System.currentTimeMillis() - jCurrentTimeMillis, z, z2);
                }
            }, true, map) : false) {
                lv lvVarH_ = wVar.H_();
                if (wVar.c() != 9) {
                    lvVarX = lvVarH_;
                } else if (wVar.I_() != null) {
                    lvVarX = wVar.I_().x();
                } else {
                    lvVarX = null;
                }
                if (lvVarX != null) {
                    long jC = lvVarX.c();
                    if (jC > 0) {
                        aj.hn().postDelayed(new Runnable() { // from class: com.byazt.zr.uc.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    uc.this.pr(context, wVar, iC, str2, (Map<String, Object>) map);
                                }
                            }
                        }, jC);
                    }
                    if (lvVarX.uc() == 1 && zo.nt().hn() != null) {
                        new com.byazt.pj.fw().pr(new com.byazt.pj.fw.pr() { // from class: com.byazt.zr.uc.3
                            @Override // com.byazt.pj.fw.pr
                            public void pr(long j) {
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    uc.this.pr(context, wVar, iC, str2, (Map<String, Object>) map);
                                }
                            }

                            @Override // com.byazt.pj.fw.pr
                            public void pr(String str3) {
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    uc.this.pr(context, wVar, iC, str2, (Map<String, Object>) map);
                                }
                            }

                            @Override // com.byazt.pj.fw.pr
                            public void pr(boolean z) {
                            }
                        });
                    }
                }
                return 0;
            }
            return pr(context, wVar, i, str2, map);
        }
        return 4;
    }

    public boolean pr(w wVar, final pr prVar, boolean z, Map<String, Object> map) {
        if (this.c == null) {
            return false;
        }
        lv lvVarH_ = wVar.H_();
        if (wVar.c() == 9) {
            if (wVar.I_() != null) {
                lvVarH_ = wVar.I_().x();
            } else {
                lvVarH_ = null;
            }
        }
        if (lvVarH_ == null || lvVarH_.hn() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.c.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception e) {
        }
        int iHw = lvVarH_.hw();
        boolean z2 = iHw > 0;
        if (z) {
            z2 = iHw == 3;
        }
        if (!z2) {
            return false;
        }
        this.uc = new SoftReference<>(com.byazt.lx.hw.pr(wVar, map));
        return pr(new com.byazt.mh.hw() { // from class: com.byazt.zr.uc.4
            @Override // com.byazt.mh.hw
            public void pr(Object obj) {
                boolean z3 = false;
                if (obj instanceof Map) {
                    Map map2 = (Map) obj;
                    if (map2.containsKey(PluginConstants.KEY_ERROR_CODE)) {
                        Object obj2 = map2.get(PluginConstants.KEY_ERROR_CODE);
                        if (obj2 instanceof String) {
                            try {
                                if (Integer.parseInt((String) obj2) == 1) {
                                    z3 = true;
                                }
                            } catch (NumberFormatException e2) {
                            }
                        }
                    }
                }
                prVar.pr(z3);
            }
        }, iHw == 3) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pr(Context context, w wVar, int i, String str, Map<String, Object> map) {
        int iIntValue;
        int i2;
        int i3;
        int i4;
        com.byazt.lx.hw.pr(wVar, map).le();
        if (this.pr != null) {
            int iHw = 0;
            Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(0).pr(Integer.class).pr(0, new ww().pr(d.R, context).pr("bundle", hw(context, wVar, map))).hw());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            this.hw = str;
            this.x = wVar.cz();
            int i5 = 2;
            if (iIntValue == 0) {
                this.uc = new SoftReference<>(com.byazt.lx.hw.pr(wVar, map));
                int iPr = com.byazt.dz.hn.pr(map);
                if (iPr == 101 || iPr == 102) {
                    iIntValue |= iPr << 8;
                    i5 = i;
                } else if (pr(wVar, iPr)) {
                    iHw = hw(wVar);
                    if (iHw == 0) {
                        try {
                            new com.byazt.nl.pr().pr(str).pr(context, map, wVar);
                            iIntValue |= iPr << 8;
                        } catch (Exception e) {
                        }
                        i = 7;
                        i5 = 7;
                    } else {
                        i = 7;
                    }
                } else if (wVar.c() != 9) {
                    i5 = i;
                }
            } else {
                iHw = 3;
                i5 = i;
            }
            i2 = i;
            i3 = i5;
            i4 = iHw;
        } else {
            iIntValue = 4;
            i2 = i;
            i3 = i2;
            i4 = 1;
        }
        pr(com.byazt.lx.hw.pr(wVar, map), str, i2, i3, i4);
        return iIntValue;
    }

    @Override // com.byazt.zr.pr
    public boolean w_() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:129:0x01df  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:149:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:152:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:157:0x0320 A[Catch: Exception -> 0x0344, TRY_LEAVE, TryCatch #9 {Exception -> 0x0344, blocks: (B:155:0x031a, B:157:0x0320), top: B:196:0x031a }] */
    /* JADX WARN: Code duplicated, block: B:165:0x035d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:166:0x035e  */
    /* JADX WARN: Code duplicated, block: B:168:0x0368  */
    /* JADX WARN: Code duplicated, block: B:170:0x0374  */
    /* JADX WARN: Code duplicated, block: B:184:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x031a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    /* JADX WARN: Code duplicated, block: B:79:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0151  */
    /* JADX WARN: Code duplicated, block: B:93:0x0157 A[Catch: Exception -> 0x0165, TryCatch #6 {Exception -> 0x0165, blocks: (B:85:0x013d, B:93:0x0157, B:95:0x0161), top: B:190:0x013d }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0161 A[Catch: Exception -> 0x0165, TRY_LEAVE, TryCatch #6 {Exception -> 0x0165, blocks: (B:85:0x013d, B:93:0x0157, B:95:0x0161), top: B:190:0x013d }] */
    private Bundle hw(Context context, w wVar, Map<String, Object> map) {
        yb ybVarHn;
        int i;
        int i2;
        String strPr;
        JSONArray jSONArrayZo;
        JSONObject jSONObject;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String string;
        Object obj;
        long jLongValue;
        Map<String, Object> map2 = map;
        Bundle bundle = new Bundle();
        if (wVar != null) {
            try {
                bundle.putLong("room_id", Long.parseLong(wVar.vk()));
            } catch (Exception e) {
            }
            Bundle bundle2 = new Bundle();
            yb ybVarG = wVar.g();
            if (wVar.c() == 9) {
                ybVarHn = wVar.I_() != null ? wVar.I_().hn() : null;
            } else {
                ybVarHn = ybVarG;
            }
            int iPr = com.byazt.dz.hn.pr(map);
            lv lvVarH_ = wVar.H_();
            if (wVar.c() == 9) {
                lvVarH_ = wVar.I_() != null ? wVar.I_().x() : null;
            }
            if (lvVarH_ == null || lvVarH_.hn() != 0) {
                i = iPr;
            } else {
                int iHw = lvVarH_.hw();
                if (iHw == 1) {
                    i = 101;
                } else if (iHw == 3) {
                    i = 104;
                } else {
                    i = iPr;
                }
            }
            int iC = wVar.c();
            int iX = x(wVar);
            qi qiVarW = wVar.w();
            if (wVar.c() == 9) {
                qiVarW = wVar.I_() != null ? wVar.I_().uc() : null;
            }
            String strK = wVar.k();
            if (wVar.c() == 9) {
                strK = wVar.I_() != null ? wVar.I_().c() : null;
            }
            if (!com.byazt.ye.uc.pr(i)) {
                if (iX > 0 && c() != 2) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        cz.pr(wVar.cz(), new Integer(1), Integer.class);
                        jSONObject2.put("auth_reward_gold", iX);
                        bundle2.putString("live_auth_extra_info", jSONObject2.toString());
                    } catch (JSONException e2) {
                    }
                } else if (hw(wVar) == 0) {
                    if (wVar.c() == 7) {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } else if (wVar.c() == 8) {
                        bundle2.putInt("live_popup_dou_deeplink_dialog", 1);
                        bundle2.putString("live_popup_dou_deeplink_url", ybVarHn != null ? ybVarHn.hw() : "");
                    }
                }
                i = iC;
                i2 = -1;
            } else if (i == 101 || i == 102 || i == 104) {
                try {
                    jSONObject = new JSONObject();
                    if (qiVarW != null) {
                        if (i == 101) {
                            i4 = 1;
                        } else {
                            i4 = i == 104 ? 3 : 2;
                        }
                        try {
                            jSONObject.put("live_auto_auth_login_source", i4);
                            i5 = i4;
                            try {
                                jSONObject.put("live_auto_auth_success_has_ticket", com.byazt.dz.hn.pr(strK));
                                jSONObject.put("live_auto_auth_promotion_id", qiVarW.hw());
                                i3 = i5;
                            } catch (Exception e3) {
                                i = iC;
                                i2 = i5;
                            }
                        } catch (Exception e4) {
                            i5 = i4;
                        }
                    } else {
                        i = iC;
                        i3 = -1;
                    }
                    if (iX > 0) {
                        if (jSONObject == null) {
                            try {
                                jSONObject = new JSONObject();
                            } catch (Exception e5) {
                                i6 = i3;
                                i7 = i;
                                i2 = i6;
                                i = i7;
                                if (qiVarW != null) {
                                    if (!TextUtils.isEmpty(qiVarW.fw())) {
                                        bundle2.putString("live_csj_libra_param", qiVarW.fw());
                                    }
                                    jSONArrayZo = qiVarW.zo();
                                    if (jSONArrayZo != null) {
                                        pr(jSONArrayZo, wVar);
                                        bundle.putString("live_tob_task_center_config", jSONArrayZo.toString());
                                        bundle.putString("live_tob_task_key", wVar.cz());
                                    }
                                }
                                if (ybVarHn != null) {
                                    strPr = null;
                                } else {
                                    strPr = null;
                                }
                                if (TextUtils.isEmpty(strPr)) {
                                    strPr = pr(ls.k(com.byazt.lx.hw.pr(wVar, map)));
                                }
                                bundle2.putString("enter_from_merge", strPr);
                                bundle2.putString("enter_method", hw(ls.k(com.byazt.lx.hw.pr(wVar, map))));
                                bundle2.putInt("live_pangle_interaction_type", i);
                                bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                if (i2 != -1) {
                                    try {
                                        if (!TextUtils.isEmpty(strK)) {
                                            JSONObject jSONObject3 = new JSONObject(strK);
                                            JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("enter_request");
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("live_auto_auth_login_source", i2);
                                            jSONObjectOptJSONObject.put("live_commerce_sdk_custom_params", jSONObject4);
                                            jSONObject3.remove("enter_request");
                                            jSONObject3.put("enter_request", jSONObjectOptJSONObject);
                                            strK = jSONObject3.toString();
                                        }
                                    } catch (Exception e6) {
                                    }
                                }
                                map2 = map;
                                bundle.putString("ecom_live_params", pr(wVar, strK, map2));
                                if (!wVar.D_()) {
                                    return bundle;
                                }
                                obj = map2.get("reward_countdown");
                                if (obj instanceof Long) {
                                    jLongValue = ((Long) obj).longValue();
                                    if (jLongValue > 0) {
                                        bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                        bundle.putInt("android.app.activity.request_code", 1);
                                        if (map2 != null) {
                                            bundle.putInt("live_popup_reward_auth", 1);
                                        }
                                    }
                                }
                                return bundle;
                            }
                        }
                        i6 = i3;
                        try {
                            i7 = i;
                            try {
                                cz.pr(wVar.cz(), new Integer(1), Integer.class);
                                jSONObject.put("auth_reward_gold", iX);
                            } catch (Exception e7) {
                                i2 = i6;
                                i = i7;
                            }
                        } catch (Exception e8) {
                            i7 = i;
                            i2 = i6;
                            i = i7;
                        }
                    } else {
                        i6 = i3;
                        i7 = i;
                    }
                    if (jSONObject != null) {
                        string = jSONObject.toString();
                        if (!TextUtils.isEmpty(string)) {
                            bundle2.putString("live_auth_extra_info", string);
                        }
                    }
                    i2 = i6;
                    i = i7;
                } catch (Exception e9) {
                    i = iC;
                    i2 = -1;
                }
            } else {
                if (i == 103) {
                    try {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                        jSONObject = null;
                        i3 = -1;
                    } catch (Exception e10) {
                        i2 = -1;
                    }
                } else {
                    i = iC;
                    jSONObject = null;
                    i3 = -1;
                }
                if (iX > 0) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    i6 = i3;
                    i7 = i;
                    cz.pr(wVar.cz(), new Integer(1), Integer.class);
                    jSONObject.put("auth_reward_gold", iX);
                } else {
                    i6 = i3;
                    i7 = i;
                }
                if (jSONObject != null) {
                    string = jSONObject.toString();
                    if (!TextUtils.isEmpty(string)) {
                        bundle2.putString("live_auth_extra_info", string);
                    }
                }
                i2 = i6;
                i = i7;
            }
            if (qiVarW != null) {
                if (!TextUtils.isEmpty(qiVarW.fw())) {
                    bundle2.putString("live_csj_libra_param", qiVarW.fw());
                }
                jSONArrayZo = qiVarW.zo();
                if (jSONArrayZo != null) {
                    pr(jSONArrayZo, wVar);
                    bundle.putString("live_tob_task_center_config", jSONArrayZo.toString());
                    bundle.putString("live_tob_task_key", wVar.cz());
                }
            }
            if (ybVarHn != null || TextUtils.isEmpty(ybVarHn.hw())) {
                strPr = null;
            } else {
                try {
                    Uri uri = Uri.parse(ybVarHn.hw());
                    JSONObject jSONObject5 = new JSONObject(uri.getQueryParameter("ad_data_params"));
                    String strOptString = jSONObject5.optString("log_extra");
                    HashMap map3 = new HashMap();
                    JSONObject jSONObject6 = new JSONObject();
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject7 = new JSONObject(strOptString);
                        jSONObject7.put("ad_event_aid", jSONObject5.optString("aid"));
                        jSONObject7.put("ad_event_source", com.byazt.eg.hn.pr(uri, "source"));
                        jSONObject7.put("ad_event_gd_label", com.byazt.eg.hn.pr(uri, "gd_label"));
                        jSONObject7.put("ad_event_union_user_id", com.byazt.eg.hn.pr(uri, "union_user_id"));
                        jSONObject7.put("ad_event_app_siteid", zo.nt().ny());
                        jSONObject7.put("ad_event_live_type", "1");
                        map3.put("log_extra", jSONObject7.toString());
                        jSONObject6.put("log_extra", jSONObject7.toString());
                    }
                    String strOptString2 = jSONObject5.optString("cid");
                    jSONObject6.put("creativeID", strOptString2);
                    bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject6.toString());
                    map3.put("is_other_channel", "union_ad");
                    map3.put(Constants.VALUE_FIELD, strOptString2);
                    bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                    String strPr2 = com.byazt.eg.hn.pr(uri, "pangle_live_room_data");
                    if (!TextUtils.isEmpty(strPr2)) {
                        bundle.putString("pangle_live_room_data", strPr2);
                    }
                    String strPr3 = com.byazt.eg.hn.pr(uri, "owner_open_id");
                    if (TextUtils.isEmpty(strPr3)) {
                        strPr3 = com.byazt.eg.hn.pr(uri, Common.System.USER_ID);
                    }
                    bundle2.putString("anchor_id", strPr3);
                    bundle2.putString("live.intent.extra.REQUEST_ID", com.byazt.eg.hn.pr(uri, com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID));
                    strPr = com.byazt.eg.hn.pr(uri, "enter_from_merge");
                } catch (Exception e11) {
                    strPr = null;
                }
            }
            if (TextUtils.isEmpty(strPr)) {
                strPr = pr(ls.k(com.byazt.lx.hw.pr(wVar, map)));
            }
            bundle2.putString("enter_from_merge", strPr);
            bundle2.putString("enter_method", hw(ls.k(com.byazt.lx.hw.pr(wVar, map))));
            bundle2.putInt("live_pangle_interaction_type", i);
            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
            if (i2 != -1) {
                if (!TextUtils.isEmpty(strK)) {
                    JSONObject jSONObject8 = new JSONObject(strK);
                    JSONObject jSONObjectOptJSONObject2 = jSONObject8.optJSONObject("enter_request");
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("live_auto_auth_login_source", i2);
                    jSONObjectOptJSONObject2.put("live_commerce_sdk_custom_params", jSONObject9);
                    jSONObject8.remove("enter_request");
                    jSONObject8.put("enter_request", jSONObjectOptJSONObject2);
                    strK = jSONObject8.toString();
                }
            }
            map2 = map;
            bundle.putString("ecom_live_params", pr(wVar, strK, map2));
        }
        if (!wVar.D_()) {
            return bundle;
        }
        obj = map2.get("reward_countdown");
        if (obj instanceof Long) {
            jLongValue = ((Long) obj).longValue();
            if (jLongValue > 0) {
                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                bundle.putInt("android.app.activity.request_code", 1);
                if (map2 != null && map2.containsKey("reward_live_scene") && ((Integer) map2.get("reward_live_scene")).intValue() == 1) {
                    bundle.putInt("live_popup_reward_auth", 1);
                }
            }
        }
        return bundle;
    }

    private void pr(JSONArray jSONArray, w wVar) {
        com.byazt.qt.pr prVar;
        if (wVar == null || jSONArray == null || (prVar = (com.byazt.qt.pr) cz.pr(wVar.cz(), com.byazt.qt.pr.class)) == null || prVar.hw.isEmpty()) {
            return;
        }
        String strX = wVar.x();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (prVar.hw.contains(strX + "_" + jSONObject.optString("type"))) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
            } catch (Exception e) {
            }
        }
    }

    private int x(w wVar) {
        String strNt = wVar.nt();
        Integer num = (Integer) cz.pr(wVar.cz(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(strNt)) {
            return 0;
        }
        try {
            return new JSONObject(strNt).optInt("auth_reward_gold");
        } catch (Throwable th) {
            ho.pr(com.byazt.ay.hn.TAG, th);
            return 0;
        }
    }

    public static String pr(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        if (i == 1) {
            return "ad_union_banner";
        }
        if (i == 3 || i == 4) {
            return "ad_union_topview";
        }
        if (i == 2) {
            return "ad_union_former_insert";
        }
        if (i == 6) {
            return "ad_union_patch";
        }
        return EnterFromMerge.NO_VALUE.lowerName();
    }

    public static String hw(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    @Override // com.byazt.zr.x
    public int pr(Context context, of ofVar, Map<String, Object> map) {
        long jLongValue;
        if (map != null) {
            try {
                Object obj = map.get("reward_countdown");
                if (obj instanceof Long) {
                    jLongValue = ((Long) obj).longValue();
                } else {
                    jLongValue = 0;
                }
            } catch (Exception e) {
                jLongValue = 0;
            }
        } else {
            jLongValue = 0;
        }
        if (context == null || ofVar == null) {
            return 5;
        }
        if (!(context instanceof Activity)) {
            return 7;
        }
        if (!f.pr(ofVar)) {
            return 5;
        }
        if (jLongValue < 0) {
            return 8;
        }
        if (f.hw(ofVar) == 1) {
            return 9;
        }
        return pr(context, (w) ofVar, map);
    }

    @Override // com.byazt.zr.x
    public boolean a_(of ofVar) {
        return pr((w) ofVar);
    }

    @Override // com.byazt.zr.x
    @Deprecated
    public int hw(of ofVar) {
        return 2;
    }

    @Override // com.byazt.zr.x
    public String fw() {
        return this.c;
    }

    @Override // com.byazt.zr.x
    public int pr(w wVar, hn hnVar, String str, Map<String, Object> map) {
        return -1;
    }

    @Override // com.byazt.zr.x
    public int pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return 15;
        }
        if (this.pr != null) {
            if (uc()) {
                Object objLv = zo.nt().lv();
                if (objLv == null) {
                    return 13;
                }
                try {
                    Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(8).pr(Boolean.class).pr(0, new ww().pr(d.R, objLv).pr("scheme_uri", str)).hw());
                    if (objApply != null ? ((Boolean) objApply).booleanValue() : false) {
                        return 1;
                    }
                    return 10;
                } catch (Exception e) {
                    return 14;
                }
            }
            return 11;
        }
        return 12;
    }

    @Override // com.byazt.zr.x
    public int pr(com.byazt.mh.hw hwVar, boolean z) {
        if (this.pr != null) {
            if (uc()) {
                HashMap map = new HashMap();
                map.put("expand_method_name", "requestDyAuth");
                map.put("expand_method_param", new Object[]{zo.nt().lv(), hwVar, Boolean.valueOf(z)});
                new StringBuilder("requestDyAuth:").append(this.pr.apply(com.byazt.xi.hw.pr().pr(7).pr(Void.class).pr(0, map).hw())).append(", syncAuth = ").append(z);
                return 1;
            }
            return 11;
        }
        return 12;
    }

    @Override // com.byazt.zr.pr, com.byazt.zr.x
    public void pr(String str, of ofVar, long j) {
        com.byazt.lpk.pr.pr(str, ofVar, j);
    }

    @Override // com.byazt.zr.x
    public void pr(String str, boolean z) {
        if (this.pr == null || !uc()) {
            return;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", str);
        map.put("expand_method_param", new Object[]{Boolean.valueOf(z)});
        this.pr.apply(com.byazt.xi.hw.pr().pr(7).pr(Void.class).pr(0, map).hw());
    }
}
