package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class op {
    private xr ah;
    private int d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3073ms;
    private ms xr;

    public op(JSONObject jSONObject) {
        this.f3073ms = false;
        if (jSONObject == null) {
            return;
        }
        this.f3073ms = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (jSONObjectOptJSONObject != null) {
            this.xr = new ms(jSONObjectOptJSONObject.optJSONObject("components"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("easy_playable");
        if (jSONObjectOptJSONObject2 != null) {
            this.ah = new xr(jSONObjectOptJSONObject2.optJSONObject("components"));
        }
        this.d = jSONObject.optInt("style_category");
    }

    public static boolean ms(lm lmVar) {
        op opVarGk;
        ms msVar;
        return (lmVar == null || (opVarGk = lmVar.gk()) == null || (msVar = opVarGk.xr) == null || !msVar.ab()) ? false : true;
    }

    public static boolean xr(lm lmVar) {
        op opVarGk;
        xr xrVar;
        return (lmVar == null || (opVarGk = lmVar.gk()) == null || !opVarGk.f3073ms || (xrVar = opVarGk.ah) == null || !xrVar.ms()) ? false : true;
    }

    public static String ah(lm lmVar) {
        op opVarGk;
        ms msVar;
        if (lmVar == null || (opVarGk = lmVar.gk()) == null || (msVar = opVarGk.xr) == null) {
            return null;
        }
        return msVar.xr();
    }

    public static int d(lm lmVar) {
        if (lmVar == null) {
            return 0;
        }
        return lmVar.gk().d;
    }

    public static boolean ms() {
        return (com.bytedance.sdk.openadsdk.core.g.xr >= 6322 && com.bytedance.sdk.openadsdk.core.g.xr < 6400) || com.bytedance.sdk.openadsdk.core.g.xr >= 6406;
    }

    public static xr ka(lm lmVar) {
        op opVarGk;
        if (lmVar == null || (opVarGk = lmVar.gk()) == null) {
            return null;
        }
        return opVarGk.ah;
    }

    public static ms c(lm lmVar) {
        op opVarGk;
        if (lmVar == null || (opVarGk = lmVar.gk()) == null) {
            return null;
        }
        return opVarGk.xr;
    }

    public static class ms {
        private int ab;
        private String ah;
        private int c;
        private String d;
        private int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f3074ms;
        private String ny;
        private int x;
        private int xr;

        public ms(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.xr = jSONObject.optInt("displayAreaAndroid");
            this.ah = jSONObject.optString("ugen_md5");
            this.d = jSONObject.optString("ugen_url");
            this.ka = jSONObject.optInt("need_backup_convert_area", 0);
            this.c = jSONObject.optInt("min_height", 0);
            this.ab = jSONObject.optInt("min_width", 0);
            this.x = jSONObject.optInt("min_ratio", 0);
            this.ny = jSONObject.optString("ugen_id");
            this.f3074ms = jSONObject.optInt("render_sequence", 2);
        }

        public int ms() {
            return this.f3074ms;
        }

        public String xr() {
            return this.ny;
        }

        public int ah() {
            return this.xr;
        }

        public String d() {
            return this.ah;
        }

        public String ka() {
            return this.d;
        }

        public boolean c() {
            return this.ka == 1;
        }

        public boolean ab() {
            return !TextUtils.isEmpty(this.d);
        }

        public boolean ms(int i, int i2) {
            int iD = com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), i);
            int iD2 = com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), i2);
            int i3 = this.ab;
            if (i3 != 0 && iD < i3) {
                return false;
            }
            int i4 = this.c;
            if (i4 == 0 || iD2 >= i4) {
                return iD == 0 || iD2 == 0 || ((float) iD2) / ((float) iD) >= ((float) this.x);
            }
            return false;
        }
    }

    public static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        ms f3075ms;
        ms xr;

        public xr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f3075ms = new ms(jSONObject.optJSONObject("vertical"));
            this.xr = new ms(jSONObject.optJSONObject("horizontal"));
        }

        public boolean ms() {
            ms msVar = this.xr;
            if (msVar != null && msVar.ms()) {
                return true;
            }
            ms msVar2 = this.f3075ms;
            return msVar2 != null && msVar2.ms();
        }

        public String ms(boolean z) {
            ms msVar;
            if (z && (msVar = this.f3075ms) != null && msVar.ms()) {
                return this.f3075ms.f3076ms;
            }
            ms msVar2 = this.xr;
            if (msVar2 != null && msVar2.ms()) {
                return this.xr.f3076ms;
            }
            ms msVar3 = this.f3075ms;
            return (msVar3 == null || !msVar3.ms()) ? "" : this.f3075ms.f3076ms;
        }

        public int xr() {
            ms msVar = this.f3075ms;
            if (msVar != null) {
                return msVar.xr;
            }
            ms msVar2 = this.xr;
            if (msVar2 != null) {
                return msVar2.xr;
            }
            return 0;
        }

        public static class ms {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            String f3076ms;
            int xr;

            public ms(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.f3076ms = jSONObject.optString("entry");
                this.xr = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean ms() {
                return !TextUtils.isEmpty(this.f3076ms);
            }
        }
    }
}
