package com.bytedance.sdk.openadsdk.core.ka.d;

import android.text.TextUtils;
import com.anythink.core.common.e.n;
import com.bytedance.sdk.openadsdk.core.jw.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements com.bytedance.sdk.openadsdk.core.ka.d.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final com.bytedance.sdk.component.d.ms.xr f2774ms = g.ms("open_ad_sdk_meta_cache_kv");

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
    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, ka.xr xrVar, boolean z, long j, ka.ms msVar) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f2774ms.xr(ah(str), copyOnWriteArraySet));
        if (msVar.ah() <= 0) {
            return;
        }
        if (msVar.ah() > 0 && copyOnWriteArraySet.size() >= msVar.ah()) {
            String str2 = null;
            long j2 = 0;
            for (String str3 : copyOnWriteArraySet) {
                ms msVarMs = ms.ms(str3);
                if (str2 == null || j2 < msVarMs.f2776ms) {
                    j2 = msVarMs.f2776ms;
                    str2 = str3;
                }
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new ms(xrVar.ah, xrVar.f2784ms, xrVar.xr, z, xrVar.ka, j).toString());
        f2774ms.ms(ah(str), copyOnWriteArraySet);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public ka.xr ms(String str, ka.ms msVar, long j) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(f2774ms.xr(ah(str), copyOnWriteArraySet));
        return ms(copyOnWriteArraySet, msVar, j, (List<String>) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public ka.xr ms(String str, ka.ms msVar, long j, List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(f2774ms.xr(ah(str), copyOnWriteArraySet));
        return ms(copyOnWriteArraySet, msVar, j, list);
    }

    private ka.xr ms(CopyOnWriteArraySet<String> copyOnWriteArraySet, ka.ms msVar, long j, List<String> list) {
        Iterator<String> it = copyOnWriteArraySet.iterator();
        ms msVar2 = null;
        while (it.hasNext()) {
            ms msVarMs = ms.ms(it.next());
            if (msVarMs.ms(msVar)) {
                String str = msVarMs.c;
                if (list == null || str == null || !list.contains(str)) {
                    if (j <= 0 || msVarMs.f2776ms >= j) {
                        int i = AnonymousClass1.f2775ms[msVar.d().ordinal()];
                        if (i != 1) {
                            if (i != 2) {
                                return new ka.xr(msVarMs.d, msVarMs.f2776ms, msVarMs.xr, msVarMs.c);
                            }
                            if (msVar2 == null || msVar2.ab < msVarMs.ab) {
                                msVar2 = msVarMs;
                            }
                        } else if (msVar2 == null || msVar2.f2776ms < msVarMs.f2776ms) {
                            msVar2 = msVarMs;
                        }
                    }
                }
            }
        }
        if (msVar2 != null) {
            return new ka.xr(msVar2.d, msVar2.f2776ms, msVar2.xr, msVar2.c);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ka.d.ah$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f2775ms;

        static {
            int[] iArr = new int[ka.ms.xr.values().length];
            f2775ms = iArr;
            try {
                iArr[ka.ms.xr.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2775ms[ka.ms.xr.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str) {
        f2774ms.ms(ah(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(ka.ms msVar) {
        f2774ms.ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, ka.ms msVar) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f2774ms.xr(ah(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ms msVarMs = ms.ms((String) it.next());
            if (!msVarMs.xr(msVar)) {
                copyOnWriteArraySet2.add(msVarMs.toString());
            }
        }
        f2774ms.ms(ah(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, String str2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f2774ms.xr(ah(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            if (!TextUtils.equals(ms.ms(str3).c, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        f2774ms.ms(ah(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void xr(String str) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f2774ms.xr(ah(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ms msVarMs = ms.ms((String) it.next());
            msVarMs.ah = false;
            copyOnWriteArraySet2.add(msVarMs.toString());
        }
        f2774ms.ms(ah(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, String str2, boolean z) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f2774ms.xr(ah(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            ms msVarMs = ms.ms(str3);
            if (TextUtils.equals(msVarMs.c, str2)) {
                msVarMs.ah = z;
                copyOnWriteArraySet2.add(msVarMs.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        f2774ms.ms(ah(str), copyOnWriteArraySet2);
    }

    private String ah(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    private static class ms {
        long ab;
        boolean ah;
        String c;
        String d;
        int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        long f2776ms;
        long xr;

        public static ms ms(String str) {
            long jOptLong;
            long jOptLong2;
            int i;
            boolean z;
            String str2;
            String str3;
            long jOptLong3;
            String str4;
            boolean z2;
            int i2;
            long j;
            long j2;
            String strOptString = "";
            boolean zOptBoolean = true;
            int iOptInt = 0;
            try {
                JSONObject jSONObject = new JSONObject(str);
                jOptLong = jSONObject.optLong("create_time", 0L);
                try {
                    jOptLong2 = jSONObject.optLong(n.a.g, 0L);
                    try {
                        zOptBoolean = jSONObject.optBoolean("is_using", false);
                        String strOptString2 = jSONObject.optString("material_data", "");
                        try {
                            iOptInt = jSONObject.optInt("save_version", 0);
                            strOptString = jSONObject.optString("uuid", "");
                            str4 = strOptString;
                            jOptLong3 = jSONObject.optLong("priority", 0L);
                            z2 = zOptBoolean;
                            i2 = iOptInt;
                            j = jOptLong;
                            j2 = jOptLong2;
                            str3 = strOptString2;
                        } catch (JSONException unused) {
                            i = iOptInt;
                            z = zOptBoolean;
                            str2 = strOptString;
                            strOptString = strOptString2;
                            str3 = strOptString;
                            jOptLong3 = 0;
                            str4 = str2;
                            z2 = z;
                            i2 = i;
                            j = jOptLong;
                            j2 = jOptLong2;
                        }
                    } catch (JSONException unused2) {
                        i = 0;
                        z = zOptBoolean;
                        str2 = "";
                        str3 = strOptString;
                        jOptLong3 = 0;
                        str4 = str2;
                        z2 = z;
                        i2 = i;
                        j = jOptLong;
                        j2 = jOptLong2;
                        return new ms(str3, j, j2, z2, str4, jOptLong3, i2);
                    }
                } catch (JSONException unused3) {
                    jOptLong2 = 0;
                }
            } catch (JSONException unused4) {
                jOptLong = 0;
                jOptLong2 = 0;
            }
            return new ms(str3, j, j2, z2, str4, jOptLong3, i2);
        }

        public ms(String str, long j, long j2, boolean z, String str2, long j3, int i) {
            this.f2776ms = j;
            this.xr = j2;
            this.ah = z;
            this.d = str;
            this.c = str2;
            this.ab = j3;
            this.ka = i;
        }

        public ms(String str, long j, long j2, boolean z, String str2, long j3) {
            this(str, j, j2, z, str2, j3, 6923);
        }

        public boolean ms(ka.ms msVar) {
            return (xr(msVar) || this.ah) ? false : true;
        }

        public boolean xr(ka.ms msVar) {
            if (System.currentTimeMillis() <= this.xr && !TextUtils.isEmpty(this.d)) {
                return msVar.xr() && 6923 != this.ka;
            }
            return true;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.f2776ms);
                jSONObject.put(n.a.g, this.xr);
                jSONObject.put("is_using", this.ah);
                jSONObject.put("material_data", this.d);
                jSONObject.put("save_version", this.ka);
                jSONObject.put("uuid", this.c);
                jSONObject.put("priority", this.ab);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }
}
