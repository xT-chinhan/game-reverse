package com.efs.sdk.base.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.c.b;
import com.anythink.core.common.m.e;
import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalInfo {
    private Map<String, Object> a = new ConcurrentHashMap();

    final void a(String str, Object obj) {
        if (obj != null) {
            this.a.put(str, obj);
        }
    }

    final Object b(String str, Object obj) {
        Object obj2 = this.a.get(str);
        return (obj2 != null || this.a.containsKey(str)) ? obj2 : obj;
    }

    public Map<String, Object> getGlobalInfoMap() {
        HashMap map = new HashMap(this.a);
        a.a();
        map.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        map.put("w_tm", Long.valueOf(a.b() / 1000));
        return map;
    }

    public List<AbsSection> getGlobalSectionList(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection kVSectionPut = kVSection.put("type", str).put("appid", this.a.get("appid")).put("wid", this.a.get("wid")).put("pid", this.a.get("pid")).put(b.a.A, this.a.get(b.a.A)).put("ver", this.a.get("ver")).put("vcode", this.a.get("vcode")).put(e.bc, this.a.get(e.bc)).put("stime", this.a.get("stime"));
        a.a();
        KVSection kVSectionPut2 = kVSectionPut.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        kVSectionPut2.put("w_tm", Long.valueOf(a.b() / 1000)).put("sdk_ver", this.a.get("sdk_ver"));
        String strValueOf = String.valueOf(b("uid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            kVSection.put("uid", strValueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection(com.anythink.basead.webtemplet.a.b.c.d);
        kVSection2.put(com.anythink.basead.webtemplet.a.b.c.j, this.a.get(com.anythink.basead.webtemplet.a.b.c.j)).put("brand", this.a.get("brand")).put("model", this.a.get("model")).put("build_model", this.a.get("build_model")).put("rom", this.a.get("rom")).put("sdk", this.a.get("sdk")).put("dsp_h", this.a.get("dsp_h")).put("dsp_w", this.a.get("dsp_w")).put("tzone", this.a.get("tzone")).put(TKDownloadReason.KSAD_TK_NET, this.a.get(TKDownloadReason.KSAD_TK_NET)).put("fr", this.a.get("fr"));
        try {
            if (this.a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    public String getUUID(Context context) {
        String strValueOf = String.valueOf(b("wid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            return strValueOf;
        }
        String strA = c.a(context);
        a("wid", strA);
        return strA;
    }
}
