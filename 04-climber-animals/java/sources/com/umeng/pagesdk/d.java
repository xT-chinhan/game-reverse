package com.umeng.pagesdk;

import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static Map<String, Map> a = new HashMap();
    private static c b;

    private static void a(String str) {
        Map map;
        if (TextUtils.isEmpty(str) || (map = a.get(str)) == null || (r0 = map.entrySet().iterator()) == null) {
            return;
        }
        JSONArray jSONArray = null;
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                String str2 = (String) entry.getKey();
                Long[] lArr = (Long[]) entry.getValue();
                if (!TextUtils.isEmpty(str2) && lArr != null && lArr.length >= 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mN", str2);
                        jSONObject.put("mBT", lArr[0]);
                        jSONObject.put("mET", lArr[1]);
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (jSONArray != null) {
            final JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("pN", str);
                jSONObject2.put("pL", jSONArray);
                b.a(PageManger.getApplicationContext()).a(new b.InterfaceC0679b() { // from class: com.umeng.pagesdk.d.1
                    @Override // com.umeng.pagesdk.b.InterfaceC0679b
                    public final void a(a aVar) {
                        try {
                            jSONObject2.put("te", aVar.c);
                            jSONObject2.put("le", aVar.a);
                            EfsJSONLog efsJSONLog = new EfsJSONLog("pageperf");
                            efsJSONLog.put("page", jSONObject2);
                            EfsReporter reporter = PageManger.getReporter();
                            if (reporter != null) {
                                reporter.send(efsJSONLog);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. parameter null!");
                return;
            }
            return;
        }
        if (!PageManger.isInit()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. not init!");
                return;
            }
            return;
        }
        PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. not rate!");
                return;
            }
            return;
        }
        if (z) {
            str2 = "UM_".concat(String.valueOf(str2));
        }
        if (a.containsKey(str)) {
            Map map = a.get(str);
            if (map == null) {
                if (PageManger.isDebug) {
                    Log.e("PageManger-PageTrace", "tracePageBegin. methodMap null!");
                    return;
                }
                return;
            } else {
                if (map.containsKey(str2)) {
                    return;
                }
                if (PageManger.isDebug) {
                    Log.i("PageManger-PageTrace", "tracePageBegin. begin add method. " + str2 + " - " + str);
                }
                if (z || map.size() <= 6) {
                    Long[] lArr = new Long[2];
                    lArr[0] = Long.valueOf(System.currentTimeMillis());
                    map.put(str2, lArr);
                    return;
                } else {
                    if (PageManger.isDebug) {
                        Log.e("PageManger-PageTrace", "tracePageBegin. user trace number of transfinite. " + str2 + "-" + str);
                        return;
                    }
                    return;
                }
            }
        }
        if (str2.equals("UM_onCreate")) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageTrace", "tracePageBegin. begin add onCreate. " + str2 + " - " + str);
            }
            Long[] lArr2 = new Long[2];
            lArr2[0] = Long.valueOf(System.currentTimeMillis());
            HashMap map2 = new HashMap();
            map2.put(str2, lArr2);
            a.put(str, map2);
            c cVar = b;
            if (cVar != null) {
                cVar.b();
                b.j = str;
                b.a();
            } else {
                c cVar2 = new c(PageManger.getApplicationContext());
                b = cVar2;
                cVar2.j = str;
                b.a();
            }
        }
    }

    public static void b(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. parameter null!");
                return;
            }
            return;
        }
        if (!PageManger.isInit()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. not init!");
                return;
            }
            return;
        }
        PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. not rate!");
                return;
            }
            return;
        }
        if (z) {
            str2 = "UM_".concat(String.valueOf(str2));
        }
        if (!a.containsKey(str)) {
            if (str2.equals("UM_onPause")) {
                if (PageManger.isDebug) {
                    Log.i("PageManger-PageTrace", "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str)));
                }
                c cVar = b;
                if (cVar != null) {
                    cVar.b();
                    return;
                }
                return;
            }
            return;
        }
        Map map = a.get(str);
        if (map == null) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. " + str + " is null in pageMap!");
                return;
            }
            return;
        }
        if (!map.containsKey(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. " + str2 + " non-exist in " + str + " map!");
                return;
            }
            return;
        }
        Long[] lArr = (Long[]) map.get(str2);
        if (lArr.length >= 2) {
            lArr[1] = Long.valueOf(System.currentTimeMillis());
        }
        if (str2.equals("UM_onResume")) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageTrace", "tracePageEnd. onResume save data. ".concat(String.valueOf(str)));
            }
            a(str);
            if (TextUtils.isEmpty(str) || !a.containsKey(str)) {
                return;
            }
            a.remove(str);
            return;
        }
        if (str2.equals("UM_onPause")) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageTrace", "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str)));
            }
            c cVar2 = b;
            if (cVar2 != null) {
                cVar2.b();
                b = null;
            }
        }
    }
}
