package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 86})
public class cd {
    public String fs;
    public int l;
    public String n;
    public int q;
    public int qg;
    public String rv;
    public int s;
    public int tj;
    public int w;
    public boolean x;

    public cd(JSONObject jSONObject) {
        this.qg = 0;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("reward_browse_type", 0);
        this.qg = iOptInt;
        if (iOptInt < 0 || iOptInt > 3) {
            this.qg = 0;
        }
        if (this.qg == 2) {
            this.qg = 3;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
        if (jSONObjectOptJSONObject != null) {
            this.n = jSONObjectOptJSONObject.optString("direct_landing_url");
            this.s = jSONObjectOptJSONObject.optInt("display_duration", 0);
            this.q = jSONObjectOptJSONObject.optInt("close_time", 0);
            this.l = jSONObjectOptJSONObject.optInt("page_type");
            this.w = jSONObjectOptJSONObject.optInt("show_type");
            this.x = jSONObjectOptJSONObject.optBoolean("is_landing_with_sound", false);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_browse_banner");
            if (jSONObjectOptJSONObject2 != null) {
                this.fs = jSONObjectOptJSONObject2.optString("ugen_url");
                this.rv = jSONObjectOptJSONObject2.optString("ugen_md5");
            }
            this.tj = jSONObjectOptJSONObject.optInt("close_btn_position");
        }
    }

    public void n(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.qg);
        } catch (Exception unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.n);
            jSONObject2.put("display_duration", this.s);
            jSONObject2.put("close_time", this.q);
            jSONObject2.put("page_type", this.l);
            jSONObject2.put("show_type", this.w);
            jSONObject2.put("close_btn_position", this.tj);
            jSONObject2.put("is_landing_with_sound", this.x);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.fs);
            jSONObject3.put("ugen_md5", this.rv);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception unused2) {
        }
    }

    public static boolean n(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return (cdVarCd == null || tj(pkVar) == 0 || TextUtils.isEmpty(cdVarCd.n)) ? false : true;
    }

    public static boolean qg(pk pkVar) {
        if (n(pkVar)) {
            return rv(pkVar);
        }
        return false;
    }

    public static boolean s(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return cdVarCd != null && cdVarCd.qg == 1 && cdVarCd.l == 1;
    }

    public static boolean q(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return cdVarCd != null && n(pkVar) && cdVarCd.qg == 1 && cdVarCd.l == 2;
    }

    public static boolean l(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        if (cdVarCd == null || cdVarCd.l != 4) {
            return false;
        }
        int iD = com.byazt.vgx.w.d(pkVar);
        return iD == 3 || iD == 4 || iD == 5 || iD == 9;
    }

    public static boolean w(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return cdVarCd != null && cdVarCd.l == 3;
    }

    public static boolean x(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return cdVarCd != null && cdVarCd.w == 3;
    }

    public static String fs(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return cdVarCd == null ? "" : cdVarCd.n;
    }

    public static boolean rv(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        if (cdVarCd == null) {
            return false;
        }
        return cdVarCd.x;
    }

    public static int tj(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        if (cdVarCd == null) {
            return 0;
        }
        return cdVarCd.qg;
    }

    private static cd cd(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.qn();
    }

    public static int cp(pk pkVar) {
        int i;
        cd cdVarCd = cd(pkVar);
        if (cdVarCd != null && (i = cdVarCd.s) >= 0) {
            return i;
        }
        return 0;
    }

    public static int d(pk pkVar) {
        int i;
        cd cdVarCd = cd(pkVar);
        if (cdVarCd != null && (i = cdVarCd.q) >= 0) {
            return i;
        }
        return 0;
    }

    public static boolean oa(pk pkVar) {
        return cd(pkVar) != null && tj(pkVar) == 3 && n(pkVar);
    }

    public static com.byazt.ai.n sz(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        if (cdVarCd == null || TextUtils.isEmpty(cdVarCd.fs)) {
            return null;
        }
        com.byazt.ai.n nVar = new com.byazt.ai.n();
        nVar.s(cdVarCd.fs);
        nVar.qg(cdVarCd.rv);
        nVar.n(cdVarCd.fs);
        return nVar;
    }

    public static boolean k(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return cdVarCd != null && cdVarCd.tj == 1;
    }

    public static boolean cy(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        return cdVarCd != null && cdVarCd.tj == 2;
    }

    public static int hd(pk pkVar) {
        cd cdVarCd = cd(pkVar);
        if (cdVarCd == null) {
            return 0;
        }
        return cdVarCd.tj;
    }
}
