package com.byazt.py;

import android.text.TextUtils;
import com.byazt.wt.y;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 438, 121})
public class x implements hw {
    public static final com.byazt.cr.c pr = y.pr("open_ad_sdk_union_meta_cache_kv");

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.byazt.py.hw
    public void pr(String str, fw.hw hwVar, uc ucVar, fw.pr prVar, com.byazt.py.pr prVar2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(pr.hw(hn(str), copyOnWriteArraySet));
        if (prVar.x() <= 0) {
            return;
        }
        long j = 0;
        if (prVar.x() > 0 && copyOnWriteArraySet.size() >= prVar.x()) {
            pr prVar3 = null;
            String str2 = null;
            for (String str3 : copyOnWriteArraySet) {
                pr prVarPr = pr.pr(str3);
                if (str2 == null || j < prVarPr.pr) {
                    j = prVarPr.pr;
                    str2 = str3;
                    prVar3 = prVarPr;
                }
            }
            if (prVar3 != null) {
                prVar2.pr(new fw.hw(prVar3.x, prVar3.pr, prVar3.hw, prVar3.uc));
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new pr(hwVar.hn, hwVar.pr, hwVar.hw, ucVar.pr, hwVar.c, ucVar.hw, ucVar.hn).toString());
        pr.pr(hn(str), copyOnWriteArraySet);
    }

    @Override // com.byazt.py.hw
    public fw.hw pr(String str, fw.pr prVar, long j, List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(pr.hw(hn(str), copyOnWriteArraySet));
        return pr(copyOnWriteArraySet, prVar, j, list);
    }

    private fw.hw pr(CopyOnWriteArraySet<String> copyOnWriteArraySet, fw.pr prVar, long j, List<String> list) {
        Iterator<String> it = copyOnWriteArraySet.iterator();
        pr prVar2 = null;
        while (it.hasNext()) {
            pr prVarPr = pr.pr(it.next());
            if (prVarPr.pr(prVar)) {
                String str = prVarPr.uc;
                if (list == null || str == null || !list.contains(str)) {
                    if (j <= 0 || prVarPr.pr >= j) {
                        switch (prVar.c()) {
                            case 1:
                                if (prVar2 == null || prVar2.pr < prVarPr.pr) {
                                    prVar2 = prVarPr;
                                }
                                break;
                            case 2:
                                if (prVar2 == null || prVar2.fw < prVarPr.fw) {
                                    prVar2 = prVarPr;
                                }
                                break;
                            case 3:
                                if (prVar2 == null || prVar2.zo > prVarPr.zo || (prVar2.zo == prVarPr.zo && prVar2.pr < prVarPr.pr)) {
                                    prVar2 = prVarPr;
                                }
                                break;
                            default:
                                return new fw.hw(prVarPr.x, prVarPr.pr, prVarPr.hw, prVarPr.uc);
                        }
                    }
                }
            }
        }
        if (prVar2 != null) {
            return new fw.hw(prVar2.x, prVar2.pr, prVar2.hw, prVar2.uc);
        }
        return null;
    }

    @Override // com.byazt.py.hw
    public void pr(String str) {
        pr.pr(hn(str));
    }

    @Override // com.byazt.py.hw
    public void pr(fw.pr prVar) {
        pr.pr();
    }

    @Override // com.byazt.py.hw
    public void pr(String str, fw.pr prVar, com.byazt.py.pr prVar2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(pr.hw(hn(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            pr prVarPr = pr.pr((String) it.next());
            if (prVarPr.hw(prVar)) {
                if (prVar2 != null) {
                    prVar2.pr(new fw.hw(prVarPr.x, prVarPr.pr, prVarPr.hw, prVarPr.uc));
                }
            } else {
                copyOnWriteArraySet2.add(prVarPr.toString());
            }
        }
        pr.pr(hn(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.py.hw
    public void pr(String str, String str2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(pr.hw(hn(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            if (!TextUtils.equals(pr.pr(str3).uc, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        pr.pr(hn(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.py.hw
    public void hw(String str) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(pr.hw(hn(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            pr prVarPr = pr.pr((String) it.next());
            prVarPr.hn = false;
            copyOnWriteArraySet2.add(prVarPr.toString());
        }
        pr.pr(hn(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.py.hw
    public void pr(String str, String str2, boolean z) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(pr.hw(hn(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            pr prVarPr = pr.pr(str3);
            if (TextUtils.equals(prVarPr.uc, str2)) {
                prVarPr.hn = z;
                copyOnWriteArraySet2.add(prVarPr.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        pr.pr(hn(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.py.hw
    public boolean pr(String str, fw.pr prVar) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(pr.hw(hn(str), copyOnWriteArraySet));
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            if (pr.pr((String) it.next()).pr(prVar)) {
                return true;
            }
        }
        return false;
    }

    private String hn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    @com.byazt.vzx.pr(pr = {0, 1, 438, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static class pr {
        public int c;
        public long fw;
        public boolean hn;
        public long hw;
        public long pr;
        public String uc;
        public String x;
        public int zo;

        public static pr pr(String str) {
            boolean z;
            long j;
            String str2;
            String str3;
            int iOptInt;
            long j2;
            long j3;
            boolean z2;
            long j4;
            int i;
            String strOptString = "";
            int iOptInt2 = 0;
            long jOptLong = 0;
            boolean zOptBoolean = true;
            try {
                JSONObject jSONObject = new JSONObject(str);
                long jOptLong2 = jSONObject.optLong("create_time", 0L);
                try {
                    jOptLong = jSONObject.optLong("expire_time", 0L);
                    try {
                        zOptBoolean = jSONObject.optBoolean("is_using", false);
                        String strOptString2 = jSONObject.optString("material_data", "");
                        try {
                            iOptInt2 = jSONObject.optInt("save_version", 0);
                            try {
                                strOptString = jSONObject.optString("uuid", "");
                                jOptLong = jSONObject.optLong("priority", 0L);
                                str2 = strOptString;
                                iOptInt = jSONObject.optInt(Constants.INDEX_FIELD, 0);
                                j3 = jOptLong;
                                z2 = zOptBoolean;
                                j2 = jOptLong2;
                                j4 = jOptLong;
                                str3 = strOptString2;
                                i = iOptInt2;
                            } catch (JSONException e) {
                                strOptString = strOptString;
                                strOptString = strOptString2;
                                z = zOptBoolean;
                                j = jOptLong;
                                jOptLong = jOptLong2;
                                str2 = strOptString;
                                str3 = strOptString;
                                iOptInt = 0;
                                j2 = jOptLong;
                                j3 = j;
                                z2 = z;
                                j4 = jOptLong;
                                i = iOptInt2;
                            }
                        } catch (JSONException e2) {
                            strOptString = "";
                            iOptInt2 = 0;
                        }
                    } catch (JSONException e3) {
                        strOptString = "";
                        iOptInt2 = 0;
                    }
                } catch (JSONException e4) {
                    jOptLong = jOptLong2;
                    z = true;
                    j = jOptLong;
                    str2 = strOptString;
                    str3 = strOptString;
                    iOptInt = 0;
                    j2 = jOptLong;
                    j3 = j;
                    z2 = z;
                    j4 = jOptLong;
                    i = iOptInt2;
                    return new pr(str3, j2, j4, z2, str2, j3, iOptInt, i);
                }
            } catch (JSONException e5) {
            }
            return new pr(str3, j2, j4, z2, str2, j3, iOptInt, i);
        }

        public pr(String str, long j, long j2, boolean z, String str2, long j3, int i, int i2) {
            this.pr = j;
            this.hw = j2;
            this.hn = z;
            this.x = str;
            this.uc = str2;
            this.fw = j3;
            this.zo = i;
            this.c = i2;
        }

        public pr(String str, long j, long j2, boolean z, String str2, long j3, int i) {
            this(str, j, j2, z, str2, j3, i, 7714);
        }

        public boolean pr(fw.pr prVar) {
            return (hw(prVar) || this.hn) ? false : true;
        }

        public boolean hw(fw.pr prVar) {
            if (System.currentTimeMillis() <= this.hw && !TextUtils.isEmpty(this.x)) {
                return prVar.hn() && 7714 != this.c;
            }
            return true;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.pr);
                jSONObject.put("expire_time", this.hw);
                jSONObject.put("is_using", this.hn);
                jSONObject.put("material_data", this.x);
                jSONObject.put("save_version", this.c);
                jSONObject.put("uuid", this.uc);
                jSONObject.put("priority", this.fw);
                jSONObject.put(Constants.INDEX_FIELD, this.zo);
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }
}
