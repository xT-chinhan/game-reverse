package com.smartdigimkt.e3;

import android.text.TextUtils;
import com.anythink.core.common.h.y;
import com.anythink.core.e.d;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String a0;
    public String b0;
    public int c0;
    public long d0;
    public long e0;
    public int f0;
    public String g0;
    public String h0;
    public String i0;
    public String j0;
    public String k0;
    public String l0 = "";

    @Override // com.smartdigimkt.b3.c
    public final ArrayList b(e eVar) {
        b bVar = (b) eVar;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(String.valueOf(bVar.a), "2")) {
            String strA = a(bVar);
            if (!TextUtils.isEmpty(strA) && TextUtils.equals(strA, this.f) && !TextUtils.isEmpty(this.e)) {
                arrayList.add(this.e);
            }
        }
        return arrayList;
    }

    @Override // com.smartdigimkt.b3.c
    public final int e() {
        return 1;
    }

    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // com.smartdigimkt.b3.c
    public final ArrayList a(e eVar, boolean z) {
        boolean z2;
        b bVar = (b) eVar;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.equals(String.valueOf(bVar.a), "0") && !TextUtils.isEmpty(this.i)) {
            arrayList.add(this.i);
        }
        if (TextUtils.equals(String.valueOf(bVar.a), "2")) {
            String str = bVar.n;
            if (!TextUtils.isEmpty(this.i)) {
                arrayList.add(this.i);
            }
            String strA = a(bVar);
            if (!TextUtils.isEmpty(strA)) {
                arrayList.add(strA);
            }
            if (arrayList.size() == 0) {
                stringBuffer.append(str).append(" url,");
            }
        }
        if (TextUtils.equals(String.valueOf(bVar.a), "1")) {
            if (TextUtils.isEmpty(this.e)) {
                stringBuffer.append("icon_u,");
                z2 = false;
            } else {
                arrayList.add(this.e);
                z2 = true;
            }
            if (TextUtils.isEmpty(this.f)) {
                stringBuffer.append("full_u,");
                z2 = false;
            } else {
                arrayList.add(this.f);
            }
            if (TextUtils.isEmpty(this.i)) {
                stringBuffer.append("video_u,");
                z2 = false;
            } else {
                arrayList.add(this.i);
            }
        } else {
            z2 = true;
        }
        if (TextUtils.equals(bVar.a + "", "3")) {
            if (TextUtils.isEmpty(this.e)) {
                stringBuffer.append("icon_u,");
                z2 = false;
            } else {
                arrayList.add(this.e);
            }
            if (TextUtils.isEmpty(this.f)) {
                stringBuffer.append("full_u,");
                z2 = false;
            } else {
                arrayList.add(this.f);
            }
            if (this.n == 1) {
                if (TextUtils.isEmpty(this.i)) {
                    stringBuffer.append("video_u,");
                    z2 = false;
                } else {
                    arrayList.add(this.i);
                }
            }
        }
        if (TextUtils.equals(String.valueOf(bVar.a), "4")) {
            if (!TextUtils.isEmpty(this.i)) {
                arrayList.add(this.i);
                if (!TextUtils.isEmpty(this.f)) {
                    arrayList.add(this.f);
                }
            } else if (TextUtils.isEmpty(this.f)) {
                stringBuffer.append("full_u,");
            } else {
                arrayList.add(this.f);
            }
            if (z2) {
                return arrayList;
            }
        } else if (z2) {
            return arrayList;
        }
        this.l0 = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    public final String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.k0);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                str = str.replaceAll("\\{" + next + "\\}", jSONObject.optString(next));
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    @Override // com.smartdigimkt.b3.c
    public final String a() {
        return this.l0;
    }

    public static ArrayList a(String str, String str2, long j, b bVar) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                a aVar = new a();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                aVar.a = jSONObjectOptJSONObject.optString("o_id");
                aVar.b = jSONObjectOptJSONObject.optString("c_id");
                aVar.c = jSONObjectOptJSONObject.optString("t");
                aVar.m = jSONObjectOptJSONObject.optString("p_g");
                aVar.d = jSONObjectOptJSONObject.optString(d.a);
                aVar.e = jSONObjectOptJSONObject.optString("ic_u");
                jSONObjectOptJSONObject.optString("im_u");
                aVar.f = jSONObjectOptJSONObject.optString("f_i_u");
                aVar.g = jSONObjectOptJSONObject.optString("a_c_u");
                aVar.h = jSONObjectOptJSONObject.optString("c_t");
                aVar.i = jSONObjectOptJSONObject.optString("v_u");
                aVar.o = jSONObjectOptJSONObject.optInt("l_t");
                aVar.j = jSONObjectOptJSONObject.optString("p_u");
                aVar.k = jSONObjectOptJSONObject.optString("dl");
                aVar.l = jSONObjectOptJSONObject.optString("c_u");
                aVar.S = jSONObjectOptJSONObject.optString("ip_u");
                aVar.T = jSONObjectOptJSONObject.optString("t_u");
                aVar.U = jSONObjectOptJSONObject.optString("t_u_25");
                aVar.V = jSONObjectOptJSONObject.optString("t_u_50");
                aVar.W = jSONObjectOptJSONObject.optString("t_u_75");
                aVar.X = jSONObjectOptJSONObject.optString("t_u_100");
                aVar.Y = jSONObjectOptJSONObject.optString("s_e_c_t_u");
                aVar.Z = jSONObjectOptJSONObject.optString("c_t_u");
                aVar.a0 = jSONObjectOptJSONObject.optString("ip_n_u");
                aVar.b0 = jSONObjectOptJSONObject.optString("c_n_u");
                aVar.c0 = jSONObjectOptJSONObject.optInt("o_a_d_c");
                aVar.d0 = jSONObjectOptJSONObject.optLong("o_a_p");
                aVar.e0 = j;
                aVar.n = jSONObjectOptJSONObject.optInt("unit_type");
                aVar.f0 = jSONObjectOptJSONObject.optInt("c_m");
                aVar.g0 = jSONObjectOptJSONObject.optString("ext_h_pic");
                aVar.h0 = jSONObjectOptJSONObject.optString("ext_big_h_pic");
                aVar.i0 = jSONObjectOptJSONObject.optString("ext_rect_h_pic");
                aVar.j0 = jSONObjectOptJSONObject.optString("ext_home_h_pic");
                aVar.k0 = str2;
                aVar.r = jSONObjectOptJSONObject.optString("pub");
                aVar.s = jSONObjectOptJSONObject.optString("app_vc");
                aVar.t = jSONObjectOptJSONObject.optString("pvc");
                aVar.u = jSONObjectOptJSONObject.optString("pms");
                aVar.w = bVar;
                arrayList.add(aVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    @Override // com.smartdigimkt.b3.c
    public final String a(b bVar) {
        byte b;
        if (!TextUtils.equals(String.valueOf(bVar.a), "2")) {
            return "";
        }
        String str = bVar.n;
        int iHashCode = str.hashCode();
        if (iHashCode != -559799608) {
            if (iHashCode != 1507809730) {
                if (iHashCode != 1507809854) {
                    if (iHashCode == 1622564786 && str.equals(y.d)) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals(y.b)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals(y.a)) {
                b = 3;
            } else {
                b = -1;
            }
        } else if (str.equals(y.c)) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (!TextUtils.isEmpty(this.g0)) {
                        return this.g0;
                    }
                } else if (!TextUtils.isEmpty(this.j0)) {
                    return this.j0;
                }
            } else if (!TextUtils.isEmpty(this.i0)) {
                return this.i0;
            }
        } else if (!TextUtils.isEmpty(this.h0)) {
            return this.h0;
        }
        return this.f;
    }
}
