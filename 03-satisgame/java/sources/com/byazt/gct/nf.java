package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME})
public class nf {
    public static JSONObject tj;
    public su fs;
    public int l;
    public int n;
    public int q;
    public int qg;
    public JSONObject rv;
    public int s;
    public int w;
    public dw x;

    public nf(JSONObject jSONObject, String str, y yVar) {
        this.n = 2;
        this.qg = 0;
        this.s = 1;
        this.q = 0;
        this.l = 100;
        if (jSONObject == null) {
            return;
        }
        this.n = jSONObject.optInt("render_control", yVar != null ? yVar.x : 1);
        this.w = jSONObject.optInt("template_business_type", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject != null) {
            this.qg = jSONObjectOptJSONObject.optInt("render_sequence", 0);
            this.s = jSONObjectOptJSONObject.optInt("backup_render_control", 1);
            this.q = jSONObjectOptJSONObject.optInt("render_thread", 0);
            this.l = jSONObjectOptJSONObject.optInt("reserve_time", 100);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject2 != null) {
            dw dwVar = new dw();
            dwVar.qg(jSONObjectOptJSONObject2.optString("id"));
            dwVar.s(jSONObjectOptJSONObject2.optString("md5"));
            dwVar.q(jSONObjectOptJSONObject2.optString(ImagesContract.URL));
            dwVar.l(jSONObjectOptJSONObject2.optString(com.anythink.core.common.l.f.R));
            dwVar.w(jSONObjectOptJSONObject2.optString("diff_data"));
            dwVar.x(jSONObjectOptJSONObject2.optString("dynamic_creative"));
            dwVar.n(jSONObjectOptJSONObject2.optString("version"));
            dwVar.fs(jSONObjectOptJSONObject2.optString("material_type"));
            dwVar.rv(jSONObjectOptJSONObject2.optString("ugen_url"));
            dwVar.tj(jSONObjectOptJSONObject2.optString("ugen_md5"));
            dwVar.d(jSONObjectOptJSONObject2.optString("express_gesture_priority"));
            dwVar.cp(jSONObjectOptJSONObject2.optString("engine_version"));
            this.x = dwVar;
            com.byazt.px.q qVarN = n(str);
            if (qVarN != null) {
                com.byazt.mzw.qg.n(qVarN);
            }
            com.byazt.ep.cp.n(dwVar.rv(), dwVar.tj(), (com.byazt.ep.s) null);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject3 != null) {
            su suVarN = su.n(jSONObjectOptJSONObject3);
            this.fs = suVarN;
            com.byazt.ysr.qg.n().n(suVarN, str, "ad");
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject4 != null) {
            this.rv = jSONObjectOptJSONObject4;
        }
    }

    public static void n(pk pkVar, int i) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return;
        }
        nfVarK.n = i;
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                if (jSONObjectOptJSONObject != null) {
                    tj = jSONObjectOptJSONObject.optJSONObject("dark_mode_config");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void n(com.byazt.gwu.l lVar) {
        try {
            lVar.n("dark_mode_config", tj.toString());
        } catch (Exception unused) {
        }
    }

    public static void qg(com.byazt.gwu.l lVar) {
        try {
            tj = new JSONObject(lVar.getString("dark_mode_config", ""));
        } catch (Exception unused) {
        }
    }

    public static JSONObject n() {
        return tj;
    }

    public void qg(JSONObject jSONObject) {
        try {
            jSONObject.put("render_control", this.n);
            jSONObject.put("template_business_type", this.w);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("render_sequence", this.qg);
            jSONObject2.put("backup_render_control", this.s);
            jSONObject2.put("render_thread", this.q);
            jSONObject2.put("reserve_time", this.l);
            jSONObject.put("render", jSONObject2);
            if (this.x != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", this.x.qg());
                jSONObject3.put("md5", this.x.s());
                jSONObject3.put(ImagesContract.URL, this.x.q());
                jSONObject3.put(com.anythink.core.common.l.f.R, this.x.l());
                jSONObject3.put("diff_data", this.x.w());
                jSONObject3.put("version", this.x.n());
                jSONObject3.put("dynamic_creative", this.x.x());
                jSONObject3.put("material_type", this.x.fs());
                jSONObject3.put("ugen_url", this.x.rv());
                jSONObject3.put("ugen_md5", this.x.tj());
                jSONObject3.put("engine_version", this.x.cp());
                jSONObject3.put("express_gesture_priority", this.x.d());
                jSONObject.put("tpl_info", jSONObject3);
            }
            jSONObject.put("dynamic_creative", this.rv);
            su suVar = this.fs;
            if (suVar != null) {
                jSONObject.put("tpl_info_v3", suVar.rv());
            }
        } catch (JSONException unused) {
        }
    }

    private com.byazt.px.q n(String str) {
        dw dwVar = this.x;
        if (dwVar == null) {
            return null;
        }
        String strQg = dwVar.qg();
        String strQ = this.x.q();
        String strS = this.x.s();
        String strL = this.x.l();
        return com.byazt.px.q.n().n(strQg).qg(strS).s(strQ).q(strL).l(this.x.n()).w(String.valueOf(str));
    }

    private static nf k(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.nk();
    }

    public static int n(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return 2;
        }
        return nfVarK.n;
    }

    public static boolean qg(pk pkVar) {
        nf nfVarK = k(pkVar);
        return nfVarK != null && (nfVarK.w & 1) == 1;
    }

    public static int s(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return 0;
        }
        return nfVarK.qg;
    }

    public static int q(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return 1;
        }
        return nfVarK.s;
    }

    public static int l(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return 0;
        }
        return nfVarK.q;
    }

    public static int w(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return 100;
        }
        return nfVarK.l;
    }

    public static dw x(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return null;
        }
        return nfVarK.x;
    }

    public static su fs(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return null;
        }
        return nfVarK.fs;
    }

    public static boolean rv(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return false;
        }
        dw dwVar = nfVarK.x;
        if (dwVar != null) {
            return !TextUtils.isEmpty(dwVar.cp());
        }
        int i = nfVarK.qg;
        return i == 9 || i == 10;
    }

    public static com.byazt.px.q tj(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return null;
        }
        return nfVarK.n(String.valueOf(com.byazt.vgx.w.cy(pkVar)));
    }

    public static boolean cp(pk pkVar) {
        return pkVar != null && s(pkVar) == 7;
    }

    public static boolean d(pk pkVar) {
        return pkVar != null && s(pkVar) == 3;
    }

    public static boolean oa(pk pkVar) {
        return pkVar != null && s(pkVar) == 10;
    }

    public static boolean n(int i) {
        JSONObject jSONObject = tj;
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
        } catch (Exception unused) {
            return i == 1 || i == 5 || i == 8;
        }
    }

    public static JSONObject sz(pk pkVar) {
        nf nfVarK = k(pkVar);
        if (nfVarK == null) {
            return null;
        }
        return nfVarK.rv;
    }

    public static double n(pk pkVar, double d) {
        JSONObject jSONObject;
        double d2;
        nf nfVarK = k(pkVar);
        if (nfVarK == null || nfVarK.n != 2) {
            return 0.0d;
        }
        int i = nfVarK.qg;
        if ((i != 10 && i != 9) || (jSONObject = nfVarK.rv) == null) {
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
                    d2 = 0.8999999761581421d;
                    break;
                case 3:
                    d2 = 1.0d;
                    break;
                case 4:
                    d2 = 0.5d;
                    break;
                case 5:
                case 6:
                    d2 = 2.4000000953674316d;
                    break;
                case 7:
                    d2 = 2.0d;
                    break;
                default:
                    return 0.0d;
            }
            return d / d2;
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
