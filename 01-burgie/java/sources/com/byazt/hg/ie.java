package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.an;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 585})
public class ie {
    public static JSONObject vk;
    public JSONObject aj;
    public int c;
    public iy fw;
    public int hn;
    public int hw;
    public int pr;
    public int uc;
    public int x;
    public cr zo;

    public ie(JSONObject jSONObject, String str, i iVar) {
        int i;
        this.pr = 2;
        this.hw = 0;
        this.hn = 1;
        this.x = 0;
        this.c = 100;
        if (jSONObject == null) {
            return;
        }
        if (iVar == null) {
            i = 1;
        } else {
            i = iVar.fw;
        }
        this.pr = jSONObject.optInt("render_control", i);
        this.uc = jSONObject.optInt("template_business_type", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject != null) {
            this.hw = jSONObjectOptJSONObject.optInt("render_sequence", 0);
            this.hn = jSONObjectOptJSONObject.optInt("backup_render_control", 1);
            this.x = jSONObjectOptJSONObject.optInt("render_thread", 0);
            this.c = jSONObjectOptJSONObject.optInt("reserve_time", 100);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject2 != null) {
            iy iyVar = new iy();
            iyVar.hw(jSONObjectOptJSONObject2.optString("id"));
            iyVar.hn(jSONObjectOptJSONObject2.optString("md5"));
            iyVar.x(jSONObjectOptJSONObject2.optString(BreakpointSQLiteKey.URL));
            iyVar.c(jSONObjectOptJSONObject2.optString("data"));
            iyVar.uc(jSONObjectOptJSONObject2.optString("diff_data"));
            iyVar.fw(jSONObjectOptJSONObject2.optString("dynamic_creative"));
            iyVar.pr(jSONObjectOptJSONObject2.optString("version"));
            iyVar.zo(jSONObjectOptJSONObject2.optString("material_type"));
            iyVar.aj(jSONObjectOptJSONObject2.optString("ugen_url"));
            iyVar.vk(jSONObjectOptJSONObject2.optString("ugen_md5"));
            iyVar.k(jSONObjectOptJSONObject2.optString("express_gesture_priority"));
            iyVar.w(jSONObjectOptJSONObject2.optString("engine_version"));
            this.fw = iyVar;
            com.byazt.hfm.x xVarPr = pr(str);
            if (xVarPr != null) {
                com.byazt.ce.hw.pr(xVarPr);
            }
            com.byazt.ea.w.pr(iyVar.aj(), iyVar.vk(), (com.byazt.ea.hn) null);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject3 != null) {
            cr crVarPr = cr.pr(jSONObjectOptJSONObject3);
            this.zo = crVarPr;
            com.byazt.ir.hw.pr().pr(crVarPr, str, an.aw);
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject4 != null) {
            this.aj = jSONObjectOptJSONObject4;
        }
    }

    public static void pr(of ofVar, int i) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return;
        }
        ieVarHo.pr = i;
    }

    public static void pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                if (jSONObjectOptJSONObject != null) {
                    vk = jSONObjectOptJSONObject.optJSONObject("dark_mode_config");
                }
            } catch (Exception e) {
            }
        }
    }

    public static void pr(com.byazt.zq.c cVar) {
        try {
            cVar.pr("dark_mode_config", vk.toString());
        } catch (Exception e) {
        }
    }

    public static void hw(com.byazt.zq.c cVar) {
        try {
            vk = new JSONObject(cVar.getString("dark_mode_config", ""));
        } catch (Exception e) {
        }
    }

    public static JSONObject pr() {
        return vk;
    }

    public void hw(JSONObject jSONObject) {
        try {
            jSONObject.put("render_control", this.pr);
            jSONObject.put("template_business_type", this.uc);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("render_sequence", this.hw);
            jSONObject2.put("backup_render_control", this.hn);
            jSONObject2.put("render_thread", this.x);
            jSONObject2.put("reserve_time", this.c);
            jSONObject.put("render", jSONObject2);
            if (this.fw != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", this.fw.hw());
                jSONObject3.put("md5", this.fw.hn());
                jSONObject3.put(BreakpointSQLiteKey.URL, this.fw.x());
                jSONObject3.put("data", this.fw.c());
                jSONObject3.put("diff_data", this.fw.uc());
                jSONObject3.put("version", this.fw.pr());
                jSONObject3.put("dynamic_creative", this.fw.fw());
                jSONObject3.put("material_type", this.fw.zo());
                jSONObject3.put("ugen_url", this.fw.aj());
                jSONObject3.put("ugen_md5", this.fw.vk());
                jSONObject3.put("engine_version", this.fw.w());
                jSONObject3.put("express_gesture_priority", this.fw.k());
                jSONObject.put("tpl_info", jSONObject3);
            }
            jSONObject.put("dynamic_creative", this.aj);
            cr crVar = this.zo;
            if (crVar != null) {
                jSONObject.put("tpl_info_v3", crVar.aj());
            }
        } catch (JSONException e) {
        }
    }

    private com.byazt.hfm.x pr(String str) {
        iy iyVar = this.fw;
        if (iyVar == null) {
            return null;
        }
        String strHw = iyVar.hw();
        String strX = this.fw.x();
        String strHn = this.fw.hn();
        String strC = this.fw.c();
        return com.byazt.hfm.x.pr().pr(strHw).hw(strHn).hn(strX).x(strC).c(this.fw.pr()).uc(String.valueOf(str));
    }

    private static ie ho(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.rk();
    }

    public static int pr(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return 2;
        }
        return ieVarHo.pr;
    }

    public static boolean hw(of ofVar) {
        ie ieVarHo = ho(ofVar);
        return ieVarHo != null && (ieVarHo.uc & 1) == 1;
    }

    public static int hn(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return 0;
        }
        return ieVarHo.hw;
    }

    public static int x(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return 1;
        }
        return ieVarHo.hn;
    }

    public static int c(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return 0;
        }
        return ieVarHo.x;
    }

    public static int uc(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return 100;
        }
        return ieVarHo.c;
    }

    public static iy fw(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return null;
        }
        return ieVarHo.fw;
    }

    public static cr zo(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return null;
        }
        return ieVarHo.zo;
    }

    public static boolean aj(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return false;
        }
        iy iyVar = ieVarHo.fw;
        if (iyVar != null) {
            return !TextUtils.isEmpty(iyVar.w());
        }
        int i = ieVarHo.hw;
        return i == 9 || i == 10;
    }

    public static com.byazt.hfm.x vk(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return null;
        }
        return ieVarHo.pr(String.valueOf(com.byazt.wt.ls.m(ofVar)));
    }

    public static boolean w(of ofVar) {
        return ofVar != null && hn(ofVar) == 7;
    }

    public static boolean k(of ofVar) {
        return ofVar != null && hn(ofVar) == 3;
    }

    public static boolean m(of ofVar) {
        return ofVar != null && hn(ofVar) == 10;
    }

    public static boolean pr(int i) {
        JSONObject jSONObject = vk;
        if (jSONObject == null) {
            return i == 1 || i == 5 || i == 8;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("support_slot_type");
            if (jSONArrayOptJSONArray == null) {
                return i == 1 || i == 5 || i == 8;
            }
            int length = jSONArrayOptJSONArray.length();
            if (length == 0) {
                return i == 1 || i == 5 || i == 8;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (i == jSONArrayOptJSONArray.optInt(i2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return i == 1 || i == 5 || i == 8;
        }
    }

    public static JSONObject g(of ofVar) {
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null) {
            return null;
        }
        return ieVarHo.aj;
    }

    public static double pr(of ofVar, double d) {
        JSONObject jSONObject;
        ie ieVarHo = ho(ofVar);
        if (ieVarHo == null || ieVarHo.pr != 2) {
            return 0.0d;
        }
        int i = ieVarHo.hw;
        if ((i != 10 && i != 9) || (jSONObject = ieVarHo.aj) == null) {
            return 0.0d;
        }
        try {
            int iOptInt = jSONObject.optInt("layout_type");
            if (iOptInt <= 0) {
                return 0.0d;
            }
            switch (iOptInt) {
                case 1:
                case 2:
                    return d / 0.8999999761581421d;
                case 3:
                    return d / 1.0d;
                case 4:
                    return d / 0.5d;
                case 5:
                case 6:
                    return d / 2.4000000953674316d;
                case 7:
                    return d / 2.0d;
                default:
                    return 0.0d;
            }
        } catch (Exception e) {
            return 0.0d;
        }
    }
}
