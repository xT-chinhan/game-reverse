package com.byazt.dg;

import com.kwad.sdk.api.loader.ApiSpUtils;
import com.varbto.utils.api.UtilConst;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1140, 19})
public class n {
    public static qg n(JSONObject jSONObject, JSONObject jSONObject2) {
        qg qgVar;
        qg qgVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            qg qgVar3 = new qg();
            qgVar3.n = jSONObject.optString("gameType", UtilConst.CRASH_CAT_A);
            qgVar3.qg = jSONObject.optString("initial", "defer");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("templates");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject2 != null) {
                        qg.q qVar = new qg.q();
                        qVar.n = next;
                        qVar.qg = n(jSONObjectOptJSONObject2.optString("src"), jSONObject2);
                        qVar.s = s.n(qVar.qg);
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("size");
                        if (jSONObjectOptJSONObject3 != null) {
                            qVar.q = jSONObjectOptJSONObject3.optInt("width", 68);
                            qVar.l = jSONObjectOptJSONObject3.optInt("height", 68);
                        }
                        qVar.w = jSONObjectOptJSONObject2.optString("category");
                        qVar.x = jSONObjectOptJSONObject2.optDouble("scoreDelta", 0.0d);
                        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("position");
                        if (jSONObjectOptJSONObject4 != null) {
                            qVar.fs = n(jSONObjectOptJSONObject4.optString("left"), jSONObject2, 0.0d);
                            if (jSONObjectOptJSONObject4.has("top")) {
                                try {
                                    qVar.rv = n(jSONObjectOptJSONObject4.optString("top"), jSONObject2, 0.0d);
                                    qVar.tj = true;
                                } catch (Throwable unused) {
                                    return null;
                                }
                            }
                            if (jSONObjectOptJSONObject4.has("bottom")) {
                                qVar.cp = n(jSONObjectOptJSONObject4.optString("bottom"), jSONObject2, 0.0d);
                                qVar.d = true;
                            }
                        }
                        qgVar3.w.put(next, qVar);
                        qgVar3 = qgVar3;
                    }
                    qgVar2 = null;
                }
                qgVar = qgVar3;
                try {
                    qgVar.s = jSONObjectOptJSONObject.optString("collisionEffect", null);
                } catch (Throwable unused2) {
                    return null;
                }
            } else {
                qgVar = qgVar3;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("levels");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject5 != null) {
                        qg.C0152qg c0152qg = new qg.C0152qg();
                        c0152qg.n = jSONObjectOptJSONObject5.optInt("levelId", i + 1);
                        c0152qg.qg = n(jSONObjectOptJSONObject5.optString("targetScore"), jSONObject2, 5.0d);
                        c0152qg.s = n(jSONObjectOptJSONObject5.optString("timeLimit"), jSONObject2, 15000.0d);
                        c0152qg.q = jSONObjectOptJSONObject5.optInt("fallDuration", 2800);
                        c0152qg.x = n(jSONObjectOptJSONObject5.optString("runSpeed"), jSONObject2, 0.0d);
                        c0152qg.fs = n(jSONObjectOptJSONObject5.optString("groundHeight"), jSONObject2, 0.0d);
                        c0152qg.cp = n(jSONObjectOptJSONObject5.optString("collisionRatio"), jSONObject2, 1.0d);
                        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("jump");
                        if (jSONObjectOptJSONObject6 != null) {
                            c0152qg.rv = jSONObjectOptJSONObject6.optDouble("velocity", 0.0d);
                            c0152qg.tj = jSONObjectOptJSONObject6.optDouble("gravity", 0.0d);
                        }
                        JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject5.optJSONObject("spawner");
                        if (jSONObjectOptJSONObject7 != null) {
                            c0152qg.l = (int) n(jSONObjectOptJSONObject7.optString(ApiSpUtils.SP_INTERVAL), jSONObject2, 800.0d);
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject7.optJSONArray("spawnRules");
                            if (jSONArrayOptJSONArray2 != null) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                    JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                    if (jSONObjectOptJSONObject8 != null) {
                                        qg.s sVar = new qg.s();
                                        sVar.n = jSONObjectOptJSONObject8.optString("template");
                                        sVar.qg = jSONObjectOptJSONObject8.optInt("weight", 0);
                                        c0152qg.w.add(sVar);
                                    }
                                }
                            }
                        }
                        c0152qg.d = n(c0152qg);
                        qgVar.x.add(c0152qg);
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("rules");
            if (jSONObjectOptJSONObject9 != null) {
                JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject9.optJSONObject("winCondition");
                JSONObject jSONObjectOptJSONObject11 = jSONObjectOptJSONObject9.optJSONObject("loseCondition");
                if (jSONObjectOptJSONObject10 != null) {
                    qgVar.q = new qg.n(jSONObjectOptJSONObject10.optString("type", "score_reach"), jSONObjectOptJSONObject10.optString("source", "${level.targetScore}"));
                }
                if (jSONObjectOptJSONObject11 != null) {
                    qgVar.l = new qg.n(jSONObjectOptJSONObject11.optString("type", "time_expire"), jSONObjectOptJSONObject11.optString("source", "${level.timeLimit}"));
                }
            }
            if (qgVar.n()) {
                return qgVar;
            }
            return null;
        } catch (Throwable unused3) {
            return qgVar2;
        }
    }

    private static JSONObject n(qg.C0152qg c0152qg) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("levelId", c0152qg.n);
            jSONObject.put("targetScore", c0152qg.qg);
            jSONObject.put("timeLimit", c0152qg.s);
            jSONObject.put("fallDuration", c0152qg.q);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String n(String str, JSONObject jSONObject) {
        String strN;
        if (str == null) {
            return null;
        }
        return (!str.contains("${") || (strN = com.byazt.mcb.qg.n(str, jSONObject)) == null) ? str : strN;
    }

    private static double n(String str, JSONObject jSONObject, double d) {
        try {
            String strN = n(str, jSONObject);
            if (strN != null && strN.length() != 0) {
                return Double.parseDouble(strN);
            }
        } catch (Throwable unused) {
        }
        return d;
    }
}
