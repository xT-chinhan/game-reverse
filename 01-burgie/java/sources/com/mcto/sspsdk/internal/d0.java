package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 {
    public static vh a(String str, mh mhVar) {
        JSONObject jSONObject = new JSONObject(str);
        if (j.b(9, mhVar.a)) {
            h1 h1VarA = h1.a();
            h1VarA.getClass();
            try {
                if (jSONObject.length() != 0) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("installApkList");
                    AtomicInteger atomicInteger = gj.a;
                    ArrayList arrayList = new ArrayList();
                    if (jSONArrayOptJSONArray != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            try {
                                Object objOpt = jSONArrayOptJSONArray.opt(i);
                                if (objOpt == null ? false : objOpt instanceof String) {
                                    arrayList.add(String.class.cast(objOpt));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                    h1VarA.b = arrayList;
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("globalConfig");
                    h1VarA.c = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optLong("installInterval", -1L) : -1L;
                    h1VarA.a(h1VarA.d);
                    h1VarA.d.clear();
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
            return null;
        }
        mhVar.m = jSONObject.optJSONObject("pc");
        mhVar.g = jSONObject.optString("videoEventId");
        mhVar.f = jSONObject.optString("requestId");
        mhVar.i = jSONObject.optString("sei");
        mhVar.e = jSONObject.optInt("network", 0);
        mhVar.j = jSONObject.optString("errMsg", "");
        mhVar.o = gj.a(jSONObject.optJSONObject("pbp"));
        mhVar.n = gj.a(jSONObject.optJSONObject("inv"));
        mhVar.u = jSONObject.optJSONObject("jgl");
        mhVar.v = jSONObject.optJSONObject("vdi");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("adc");
        if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() != 0) {
            mhVar.s = jSONObjectOptJSONObject2.optString("ai");
            mhVar.r = jSONObjectOptJSONObject2.optString("fp");
            mhVar.q = jSONObjectOptJSONObject2.optString("lm");
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("adnt");
        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
            mhVar.p = new ConcurrentHashMap();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                if (jSONObjectOptJSONObject3 != null) {
                    m0 m0Var = new m0(jSONObjectOptJSONObject3);
                    mhVar.p.put(m0Var.b, m0Var);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("cupidExtras");
        if (jSONObjectOptJSONObject4 != null) {
            mhVar.h = jSONObjectOptJSONObject4.optString("clientIp");
            mhVar.t = jSONObjectOptJSONObject4.optInt("admToApp", 0);
        }
        HashMap mapA = gj.a(jSONObject.optJSONObject("sbp"));
        mapA.putAll(gj.a(jSONObject.optJSONObject("smp")));
        mhVar.k = gj.a((Map) mapA, ";", ":", true);
        vh vhVar = new vh(mhVar, jSONObject);
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("third_uid");
        if (jSONObjectOptJSONObject5 != null) {
            mhVar.l = jSONObjectOptJSONObject5.optString("weid");
        }
        if (mhVar.c) {
            String strTrim = jSONObject.optString("ims").trim();
            h4.f = strTrim;
            nh.a(jd.a).a("iad_dev", "dims", strTrim);
            h4.g = jSONObject.optString("ck").trim();
            nh.a(jd.a).a("iad_dev", "dck", h4.g);
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("reqTimeouts");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                int[] iArr = new int[jSONArrayOptJSONArray3.length()];
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    iArr[i3] = jSONArrayOptJSONArray3.optInt(i3);
                }
                h4.h = iArr;
                nh.a(jd.a).a("iad_dev", "dmto", jSONArrayOptJSONArray3.toString());
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("urlConfig");
            if (jSONObjectOptJSONObject6 != null) {
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject6.optJSONArray("mixer");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    String strOptString = jSONArrayOptJSONArray4.optString(0);
                    if (!lj.b(strOptString)) {
                        h4.a = strOptString;
                        nh.a(jd.a).a("iad_dev", "dmu", h4.a);
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject6.optJSONArray("pingback");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    String strOptString2 = jSONArrayOptJSONArray5.optString(0);
                    if (!lj.b(strOptString2)) {
                        h4.e = strOptString2;
                        nh.a(jd.a).a("iad_dev", "dpbu", h4.e);
                    }
                }
                String strOptString3 = jSONObjectOptJSONObject6.optString("adxTracking");
                if (!lj.b(strOptString3)) {
                    h4.c = strOptString3;
                }
                String strOptString4 = jSONObjectOptJSONObject6.optString("cupidTracking");
                if (!lj.b(strOptString4)) {
                    h4.b = strOptString4;
                }
                String strOptString5 = jSONObjectOptJSONObject6.optString("qilinTracking");
                if (!lj.b(strOptString5)) {
                    h4.d = strOptString5;
                }
            }
            JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("globalConfig");
            if (jSONObjectOptJSONObject7 != null && jSONObjectOptJSONObject7.length() != 0) {
                HashMap map = new HashMap(4);
                map.put("ccm", jSONObjectOptJSONObject7.optString("ccm"));
                map.put("acm", jSONObjectOptJSONObject7.optString("acm"));
                map.put("qcm", jSONObjectOptJSONObject7.optString("qcm"));
                map.put("rao", jSONObjectOptJSONObject7.optString("rao"));
                map.put("dpws", jSONObjectOptJSONObject7.optString("dpws"));
                nh.a(jd.a).a(map);
                h4.j = jSONObjectOptJSONObject7.optInt("riskTime", 600) * 1000;
            }
            if (jSONObjectOptJSONObject5 != null) {
                String strOptString6 = jSONObjectOptJSONObject5.optString("qyid");
                boolean z = rd.a;
                if (!lj.b(strOptString6) && !strOptString6.equals(rd.g)) {
                    rd.g = strOptString6;
                    nh.a(jd.a).a("iad_dev", "dqyid", strOptString6);
                    if (!rd.a()) {
                        y4 y4Var = y4.r;
                        if (!lj.b(strOptString6)) {
                            y4Var.f = strOptString6;
                        }
                    }
                }
            }
            if (rd.a()) {
                if (((j.b(4, mhVar.a) || j.b(5, mhVar.a) || j.b(7, mhVar.a)) && jSONObject.has("sbp")) || jSONObject.has("adnData")) {
                    ik ikVarA = ik.a();
                    String strOptString7 = jSONObject.optString("adnData");
                    ikVarA.getClass();
                    if (TextUtils.isEmpty(strOptString7)) {
                        r9.a("ssp_sdk", "adn updateConfig(): close.", null);
                        if (ikVarA.a.compareAndSet(true, false)) {
                            nh.a(jd.a).a("iad_dev", "ladnc", "");
                        }
                    } else {
                        String strD = gj.d(strOptString7);
                        if (!TextUtils.equals(strD, ikVarA.d)) {
                            "adn updateConfig(): .".concat(strD);
                            try {
                                JSONObject jSONObject2 = new JSONObject(strOptString7);
                                ikVarA.d = strD;
                                ikVarA.a(jSONObject2);
                                nh.a(jd.a).a("iad_dev", "ladnc", ikVarA.d + "||" + gj.f(strOptString7));
                            } catch (JSONException e3) {
                                r9.a("ssp_sdk", "updateConfig json error", e3);
                            }
                        }
                    }
                }
                if (((j.b(8, mhVar.a) || j.b(7, mhVar.a)) && jSONObject.has("sbp")) || jSONObject.has("waterfallData")) {
                    gl glVarA = gl.a();
                    String strOptString8 = jSONObject.optString("waterfallData");
                    glVarA.getClass();
                    if (TextUtils.isEmpty(strOptString8)) {
                        nh.a(jd.a).a("iad_dev", "wadnc", "");
                        synchronized (glVarA) {
                            glVarA.b = null;
                            glVarA.a = null;
                        }
                    } else {
                        String strD2 = gj.d(strOptString8);
                        if (!TextUtils.equals(strD2, glVarA.b)) {
                            glVarA.b = strD2;
                            HashMap mapA2 = gl.a(strOptString8);
                            synchronized (glVarA) {
                                glVarA.a = mapA2;
                            }
                            nh.a(jd.a).a("iad_dev", "wadnc", glVarA.b + "||" + gj.f(strOptString8));
                        }
                    }
                    nh.a(jd.a).a("iad_dev", "dpwc", jSONObject.optString("pauseConfig"));
                }
            }
        }
        return vhVar;
    }
}
