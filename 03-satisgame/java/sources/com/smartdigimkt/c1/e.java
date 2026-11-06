package com.smartdigimkt.c1;

import android.text.TextUtils;
import android.view.View;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.n3.k;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g gVar = this.a;
        com.smartdigimkt.b3.c cVar = gVar.a;
        com.smartdigimkt.a3.a aVar = gVar.b;
        String str = TextUtils.isEmpty(gVar.q) ? "0" : this.a.q;
        String string = this.a.e.getText().toString();
        if (cVar != null && aVar != null) {
            com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
            cVar2.a = "1004652";
            cVar2.a(aVar);
            cVar2.l = String.valueOf(aVar.k);
            cVar2.m = aVar.f;
            if (cVar instanceof com.smartdigimkt.e3.a) {
                cVar2.n = "1";
            } else if (cVar instanceof com.smartdigimkt.b3.b) {
                cVar2.n = "2";
            }
            cVar2.o = str;
            cVar2.p = string;
            cVar2.q = cVar.a;
            cVar2.r = cVar.b;
            cVar2.s = cVar.m;
            cVar2.t = cVar.c;
            cVar2.u = cVar.d;
            cVar2.v = cVar.e;
            cVar2.w = cVar.f;
            cVar2.x = cVar.i;
            try {
                if (cVar instanceof l) {
                    StringBuilder sb = new StringBuilder();
                    String str2 = ((l) cVar).V;
                    if (!TextUtils.isEmpty(str2)) {
                        JSONArray jSONArray = new JSONArray(str2);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            sb.append(jSONArray.optString(i));
                            sb.append(",");
                        }
                        if (sb.length() > 1) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        cVar2.y = sb.toString();
                    }
                }
            } catch (Throwable unused) {
            }
            k.a(cVar2);
        }
        g gVar2 = this.a;
        com.smartdigimkt.x.k kVar = gVar2.c;
        gVar2.getClass();
        com.smartdigimkt.q3.f.a().a(30L, new f(gVar2));
    }
}
