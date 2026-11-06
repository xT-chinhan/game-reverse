package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f4872ms;

    public z0(Context context) {
        this.f4872ms = context;
    }

    public final String ms() {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f4872ms.getContentResolver().acquireContentProviderClient(Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e663cd", new byte[]{119, 59, 75, 83, 89, 125, 114, 77, 40, 44, 119, 58, 11, 73, 73, 113, 111, 22, 41, 106, 112, 49, 75, 83, 85, 103, 127, 88, 110, 103, 113, 58, 81, 78, 72, 106})));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5f1afc", new byte[]{35, 97, 86, 58, 120, 93, 18}), null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall.getInt((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "447ffa", new byte[]{38, 57, com.anythink.core.common.s.a.c.b, 23}), -1) == 0) {
                return bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7d1671", new byte[]{47, 98}));
            }
            bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "19262e", new byte[]{45, 62, 82, 81, 12, 117, 55}));
            return null;
        } catch (Exception unused) {
        }
    }
}
