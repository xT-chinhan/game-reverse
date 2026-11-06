package com.byazt.ci;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 5})
public class q implements qg {
    @Override // com.byazt.ci.qg
    public void n(String str, x.qg qgVar, w wVar, x.n nVar, com.byazt.ci.n nVar2) {
        com.byazt.gwu.l lVarN = n();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(lVarN.qg(s(str), copyOnWriteArraySet));
        if (nVar.q() <= 0) {
            return;
        }
        if (nVar.q() > 0 && copyOnWriteArraySet.size() >= nVar.q()) {
            n nVar3 = null;
            long j = 0;
            String str2 = null;
            for (String str3 : copyOnWriteArraySet) {
                n nVarN = n.n(str3);
                if (str2 == null || j < nVarN.n) {
                    j = nVarN.n;
                    str2 = str3;
                    nVar3 = nVarN;
                }
            }
            if (nVar3 != null) {
                nVar2.n(new x.qg(nVar3.q, nVar3.n, nVar3.qg, nVar3.w));
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new n(qgVar.s, qgVar.n, qgVar.qg, wVar.n, qgVar.l, wVar.qg, wVar.s).toString());
        lVarN.n(s(str), copyOnWriteArraySet);
    }

    @Override // com.byazt.ci.qg
    public x.qg n(String str, x.n nVar, long j, List<String> list) {
        com.byazt.gwu.l lVarN = n();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(lVarN.qg(s(str), copyOnWriteArraySet));
        return n(copyOnWriteArraySet, nVar, j, list);
    }

    private x.qg n(CopyOnWriteArraySet<String> copyOnWriteArraySet, x.n nVar, long j, List<String> list) {
        Iterator<String> it = copyOnWriteArraySet.iterator();
        n nVar2 = null;
        while (it.hasNext()) {
            n nVarN = n.n(it.next());
            if (nVarN.n(nVar)) {
                String str = nVarN.w;
                if (list == null || str == null || !list.contains(str)) {
                    if (j <= 0 || nVarN.n >= j) {
                        int iL = nVar.l();
                        if (iL != 1) {
                            if (iL != 2) {
                                if (iL == 3) {
                                    if (nVar2 == null || nVar2.fs > nVarN.fs || (nVar2.fs == nVarN.fs && nVar2.n < nVarN.n)) {
                                        nVar2 = nVarN;
                                    }
                                } else {
                                    return new x.qg(nVarN.q, nVarN.n, nVarN.qg, nVarN.w);
                                }
                            } else if (nVar2 == null || nVar2.x < nVarN.x) {
                                nVar2 = nVarN;
                            }
                        } else if (nVar2 == null || nVar2.n < nVarN.n) {
                            nVar2 = nVarN;
                        }
                    }
                }
            }
        }
        if (nVar2 != null) {
            return new x.qg(nVar2.q, nVar2.n, nVar2.qg, nVar2.w);
        }
        return null;
    }

    @Override // com.byazt.ci.qg
    public void n(String str) {
        n().n(s(str));
    }

    @Override // com.byazt.ci.qg
    public void n(x.n nVar) {
        n().n();
    }

    @Override // com.byazt.ci.qg
    public void n(String str, x.n nVar, com.byazt.ci.n nVar2) {
        com.byazt.gwu.l lVarN = n();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(lVarN.qg(s(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            n nVarN = n.n((String) it.next());
            if (!nVarN.qg(nVar)) {
                copyOnWriteArraySet2.add(nVarN.toString());
            } else if (nVar2 != null) {
                nVar2.n(new x.qg(nVarN.q, nVarN.n, nVarN.qg, nVarN.w));
            }
        }
        lVarN.n(s(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.ci.qg
    public void n(String str, String str2) {
        com.byazt.gwu.l lVarN = n();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(lVarN.qg(s(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            if (!TextUtils.equals(n.n(str3).w, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        lVarN.n(s(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.ci.qg
    public void qg(String str) {
        com.byazt.gwu.l lVarN = n();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(lVarN.qg(s(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            n nVarN = n.n((String) it.next());
            nVarN.s = false;
            copyOnWriteArraySet2.add(nVarN.toString());
        }
        lVarN.n(s(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.ci.qg
    public void n(String str, String str2, boolean z) {
        com.byazt.gwu.l lVarN = n();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(lVarN.qg(s(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            n nVarN = n.n(str3);
            if (TextUtils.equals(nVarN.w, str2)) {
                nVarN.s = z;
                copyOnWriteArraySet2.add(nVarN.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        lVarN.n(s(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.ci.qg
    public boolean n(String str, x.n nVar) {
        com.byazt.gwu.l lVarN = n();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(lVarN.qg(s(str), copyOnWriteArraySet));
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            if (n.n((String) it.next()).n(nVar)) {
                return true;
            }
        }
        return false;
    }

    private com.byazt.gwu.l n() {
        return com.byazt.lk.l.n(com.byazt.vgx.s.q(), "open_ad_sdk_union_meta_cache_kv", 0, null);
    }

    private String s(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n {
        public int fs;
        public int l;
        public long n;
        public String q;
        public long qg;
        public boolean s;
        public String w;
        public long x;

        public static n n(String str) {
            long jOptLong;
            long jOptLong2;
            int iOptInt;
            String str2;
            long j;
            String str3;
            String str4;
            long j2;
            int iOptInt2;
            boolean z;
            long j3;
            long j4;
            String strOptString = "";
            long jOptLong3 = 0;
            boolean zOptBoolean = true;
            try {
                JSONObject jSONObject = new JSONObject(str);
                jOptLong = jSONObject.optLong("create_time", 0L);
                try {
                    jOptLong2 = jSONObject.optLong("expire_time", 0L);
                    try {
                        zOptBoolean = jSONObject.optBoolean("is_using", false);
                        String strOptString2 = jSONObject.optString("material_data", "");
                        try {
                            iOptInt = jSONObject.optInt("save_version", 0);
                            try {
                                strOptString = jSONObject.optString("uuid", "");
                                jOptLong3 = jSONObject.optLong("priority", 0L);
                                str4 = strOptString;
                                j2 = jOptLong3;
                                z = zOptBoolean;
                                iOptInt2 = jSONObject.optInt("index", 0);
                                j3 = jOptLong;
                                j4 = jOptLong2;
                                str3 = strOptString2;
                            } catch (JSONException unused) {
                                j = jOptLong3;
                                str2 = strOptString;
                                strOptString = strOptString2;
                                str3 = strOptString;
                                str4 = str2;
                                j2 = j;
                                iOptInt2 = 0;
                                z = zOptBoolean;
                                j3 = jOptLong;
                                j4 = jOptLong2;
                            }
                        } catch (JSONException unused2) {
                            iOptInt = 0;
                        }
                    } catch (JSONException unused3) {
                        zOptBoolean = zOptBoolean;
                        iOptInt = 0;
                        j = 0;
                        str2 = "";
                    }
                } catch (JSONException unused4) {
                    jOptLong2 = 0;
                    zOptBoolean = true;
                    iOptInt = 0;
                    str2 = "";
                    j = jOptLong2;
                    str3 = strOptString;
                    str4 = str2;
                    j2 = j;
                    iOptInt2 = 0;
                    z = zOptBoolean;
                    j3 = jOptLong;
                    j4 = jOptLong2;
                    return new n(str3, j3, j4, z, str4, j2, iOptInt2, iOptInt);
                }
            } catch (JSONException unused5) {
                jOptLong = 0;
                jOptLong2 = 0;
            }
            return new n(str3, j3, j4, z, str4, j2, iOptInt2, iOptInt);
        }

        public n(String str, long j, long j2, boolean z, String str2, long j3, int i, int i2) {
            this.n = j;
            this.qg = j2;
            this.s = z;
            this.q = str;
            this.w = str2;
            this.x = j3;
            this.fs = i;
            this.l = i2;
        }

        public n(String str, long j, long j2, boolean z, String str2, long j3, int i) {
            this(str, j, j2, z, str2, j3, i, 7814);
        }

        public boolean n(x.n nVar) {
            return (qg(nVar) || this.s) ? false : true;
        }

        public boolean qg(x.n nVar) {
            if (System.currentTimeMillis() <= this.qg && !TextUtils.isEmpty(this.q)) {
                return nVar.s() && 7814 != this.l;
            }
            return true;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.n);
                jSONObject.put("expire_time", this.qg);
                jSONObject.put("is_using", this.s);
                jSONObject.put("material_data", this.q);
                jSONObject.put("save_version", this.l);
                jSONObject.put("uuid", this.w);
                jSONObject.put("priority", this.x);
                jSONObject.put("index", this.fs);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }
}
