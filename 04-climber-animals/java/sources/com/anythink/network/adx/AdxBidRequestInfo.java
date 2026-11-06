package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.c;
import com.anythink.basead.f.d.b;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.common.a.d;
import com.anythink.core.common.a.f;
import com.anythink.core.common.a.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.k;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdxBidRequestInfo extends ATBidRequestInfo {
    JSONObject a;

    /* JADX WARN: Code duplicated, block: B:41:0x00d1 A[Catch: all -> 0x0123, TryCatch #2 {all -> 0x0123, blocks: (B:38:0x00a8, B:40:0x00b8, B:41:0x00d1, B:43:0x00ee, B:46:0x00ff, B:48:0x0112), top: B:63:0x0099 }] */
    public AdxBidRequestInfo(Context context, String str, Map<String, Object> map, Map<String, Object> map2, int i) {
        int intFromMap;
        int intFromMap2;
        JSONObject jSONObject = new JSONObject();
        this.a = jSONObject;
        try {
            AdxATInitManager.getInstance();
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SUPPORT_TEMPLATE_VERSION, AdxATInitManager.a() ? 1 : 0);
            l lVarB = n.a(context).b(str);
            if (lVarB != null) {
                int iAO = lVarB.aO();
                if (iAO > 0) {
                    List<j> listA = d.a().a(iAO);
                    if (listA.size() > 0) {
                        this.a.put(l.a.P, a(listA));
                    }
                }
                int iAN = lVarB.aN();
                if (iAN > 0) {
                    List<j> listB = d.a().b(iAN);
                    if (listB.size() > 0) {
                        this.a.put(l.a.O, a(listB));
                    }
                }
            }
            String strBp = lVarB.bp();
            if (!TextUtils.isEmpty(strBp)) {
                try {
                    AdxATInitManager.getInstance();
                    JSONArray jSONArrayA = AdxATInitManager.a(strBp, i);
                    if (jSONArrayA != null && jSONArrayA.length() > 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(b.a, jSONArrayA);
                        this.a.put("ss_dsp_rt", jSONObject2);
                    }
                } catch (Throwable unused) {
                }
            }
            JSONObject jSONObject3 = this.a;
            if (jSONObject3 != null) {
                try {
                    if (i == 0) {
                        if (map2 != null) {
                            intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH);
                            intFromMap2 = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT);
                        } else {
                            intFromMap = -1;
                            intFromMap2 = -1;
                        }
                        if (intFromMap > 0) {
                            jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, Math.min(context.getResources().getDisplayMetrics().widthPixels, intFromMap));
                        }
                        if (intFromMap2 > 0) {
                            jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, Math.min(context.getResources().getDisplayMetrics().heightPixels, intFromMap2));
                        }
                    } else if (i == 1) {
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, context.getResources().getDisplayMetrics().widthPixels);
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, context.getResources().getDisplayMetrics().heightPixels);
                    } else if (i == 2) {
                        String string = map.get("size").toString();
                        if (!TextUtils.isEmpty(string)) {
                            String[] strArrSplit = string.split("x");
                            int i2 = Integer.parseInt(strArrSplit[0]);
                            int i3 = Integer.parseInt(strArrSplit[1]);
                            jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, i2);
                            jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, i3);
                        }
                    } else if (i == 3 || i == 4) {
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, context.getResources().getDisplayMetrics().widthPixels);
                        jSONObject3.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, context.getResources().getDisplayMetrics().heightPixels);
                    }
                } catch (Throwable unused2) {
                }
            }
            f.a().a(str, this.a);
            String strE = com.anythink.basead.j.f.a().e();
            if (!TextUtils.isEmpty(strE)) {
                this.a.put("om_ver", strE);
            }
            if (t.b().c("sensor_deny")) {
                this.a.put("sensor_deny", 1);
            }
        } catch (Throwable unused3) {
        }
    }

    public void fillBannerData(Map<String, Object> map) {
        fillAdAcceptType(2, null);
    }

    public void fillSplashData() {
        try {
            this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(4);
            jSONArray.put(5);
            this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_MTG_DSP_MIX_TYPE, jSONArray);
        } catch (Throwable unused) {
        }
        fillAdAcceptType(4, null);
    }

    public void fillInterstitial(Map<String, Object> map) {
        String stringFromMap;
        try {
            String stringFromMap2 = ATInitMediation.getStringFromMap(map, "unit_type");
            if (!TextUtils.isEmpty(stringFromMap2)) {
                this.a.put("unit_type", Integer.parseInt(stringFromMap2));
            }
            stringFromMap = ATInitMediation.getStringFromMap(map, k.aF);
            try {
                if (!TextUtils.isEmpty(stringFromMap)) {
                    this.a.put("ir_type", stringFromMap);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            stringFromMap = null;
        }
        fillAdAcceptType(3, stringFromMap);
    }

    public void fillRewardedVideo(Map<String, Object> map) {
        fillAdAcceptType(1, null);
    }

    public void fillNative(Map<String, Object> map) {
        if (TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "layout_type"))) {
            fillAdAcceptType(0, null);
            AdxATInitManager.getInstance();
            fillTemplateIds(AdxATInitManager.a(map));
        } else {
            try {
                this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY_ONLY_PMP_SELF_REDNER));
            } catch (Throwable unused) {
            }
        }
    }

    private static JSONObject a(List<j> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap map = new HashMap();
            for (j jVar : list) {
                List arrayList = (List) map.get(jVar.a());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(jVar.a(), arrayList);
                }
                arrayList.add(jVar.b());
            }
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void fillAdAcceptType(int i, String str) {
        try {
            if (this.a != null) {
                JSONArray jSONArray = new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY);
                if ((i == 1 || i == 3 || i == 4) && c.a().g()) {
                    jSONArray.put(4);
                }
                this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, jSONArray);
                this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_VAST_VER, new JSONArray(ATAdConst.AD_SUPPORT_VAST_VERSION_ARRAY));
            }
        } catch (Throwable unused) {
        }
    }

    public void fillTemplateIds(JSONArray jSONArray) {
        try {
            if (this.a == null || jSONArray == null) {
                return;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                jSONArray2.put(jSONArray.getInt(i));
            }
            this.a.put("nv_unit_type", jSONArray2);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.a;
    }

    private static void a(Context context, JSONObject jSONObject, Map<String, Object> map, Map<String, Object> map2, int i) {
        int intFromMap;
        int intFromMap2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (i == 0) {
                if (map2 != null) {
                    intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH);
                    intFromMap2 = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT);
                } else {
                    intFromMap = -1;
                    intFromMap2 = -1;
                }
                if (intFromMap > 0) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, Math.min(context.getResources().getDisplayMetrics().widthPixels, intFromMap));
                }
                if (intFromMap2 > 0) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, Math.min(context.getResources().getDisplayMetrics().heightPixels, intFromMap2));
                    return;
                }
                return;
            }
            if (i != 1) {
                if (i == 2) {
                    String string = map.get("size").toString();
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    String[] strArrSplit = string.split("x");
                    int i2 = Integer.parseInt(strArrSplit[0]);
                    int i3 = Integer.parseInt(strArrSplit[1]);
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, i2);
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, i3);
                    return;
                }
                if (i != 3 && i != 4) {
                    return;
                }
            }
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, context.getResources().getDisplayMetrics().widthPixels);
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, context.getResources().getDisplayMetrics().heightPixels);
        } catch (Throwable unused) {
        }
    }
}
