package com.byazt.yb;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.anythink.core.common.f.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 110})
public final class sz implements hd {
    public qg<Boolean> n = new qg<Boolean>() { // from class: com.byazt.yb.sz.1
        @Override // com.byazt.yb.qg
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Boolean n(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    @Override // com.byazt.yb.hd
    public boolean qg(Context context) {
        if (context == null) {
            return false;
        }
        return this.n.qg(context).booleanValue();
    }

    @Override // com.byazt.yb.hd
    public hd.n s(Context context) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery != null) {
                try {
                    hd.n nVar = new hd.n();
                    nVar.qg = n(cursorQuery);
                    com.byazt.km.sz.n(cursorQuery);
                    return nVar;
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.byazt.km.cp.n(th);
                        return null;
                    } finally {
                        com.byazt.km.sz.n(cursorQuery);
                    }
                }
            }
            com.byazt.km.sz.n(cursorQuery);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    private String n(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(e.a.d);
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
