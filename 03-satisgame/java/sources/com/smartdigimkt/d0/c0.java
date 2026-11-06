package com.smartdigimkt.d0;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {
    public static b0 a(String str) {
        b0 b0Var = null;
        try {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return null;
            }
            b0 b0Var2 = new b0();
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaMetadataRetriever.release();
                b0Var2.a = Integer.parseInt(strExtractMetadata);
                b0Var2.b = Integer.parseInt(strExtractMetadata2);
                return b0Var2;
            } catch (Exception e) {
                e = e;
                b0Var = b0Var2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return b0Var;
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.b3.e eVar) {
        if (cVar == null) {
            return;
        }
        synchronized (cVar) {
            if (!cVar.C && !TextUtils.isEmpty(cVar.i)) {
                cVar.C = true;
                if (cVar.G <= 0 && cVar.H <= 0) {
                    if (eVar != null && eVar.a == 3 && cVar.n == 1 && TextUtils.equals(eVar.w, "2")) {
                        com.smartdigimkt.q3.f.a().c(new a0(cVar));
                    }
                }
            }
        }
    }
}
