package com.byazt.iy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1110, 5})
public class uc implements com.byazt.nq.hw.pr {
    public static List<com.byazt.nq.hw.pr> hn;
    public static WeakReference<Context> hw;
    public static volatile uc pr;

    static {
        List<com.byazt.nq.hw.pr> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        hn = listSynchronizedList;
        listSynchronizedList.add(new hn());
        hn.add(new com.byazt.ad.hw());
        hn.add(new com.byazt.im.pr());
        hn.add(new pr(zo.nt().ny()));
        Iterator<com.byazt.nq.hw.pr> it = hn.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    public static uc pr(Context context) {
        if (context != null) {
            hw = new WeakReference<>(context.getApplicationContext());
        }
        if (pr == null) {
            synchronized (uc.class) {
                if (pr == null) {
                    pr = new uc();
                }
            }
        }
        return pr;
    }

    private uc() {
    }

    private com.byazt.nq.hw.pr pr(Uri uri) {
        if (uri == null || !hw(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.nq.hw.pr prVar : hn) {
            if (str.equals(prVar.getTableName())) {
                return prVar;
            }
        }
        return null;
    }

    private boolean hw(Uri uri) {
        return true;
    }

    private Context getContext() {
        WeakReference<Context> weakReference = hw;
        return (weakReference == null || weakReference.get() == null) ? a.getContext() : hw.get();
    }

    @Override // com.byazt.nq.hw.pr
    public void injectContext(Context context) {
        Iterator<com.byazt.nq.hw.pr> it = hn.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    @Override // com.byazt.nq.hw.pr
    public String getTableName() {
        return "";
    }

    @Override // com.byazt.nq.hw.pr
    public void init() {
    }

    @Override // com.byazt.nq.hw.pr
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            com.byazt.nq.hw.pr prVarPr = pr(uri);
            if (prVarPr == null) {
                return null;
            }
            return prVarPr.query(uri, strArr, str, strArr2, str2);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.byazt.nq.hw.pr
    public String getType(Uri uri) {
        try {
            com.byazt.nq.hw.pr prVarPr = pr(uri);
            if (prVarPr == null) {
                return null;
            }
            return prVarPr.getType(uri);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.byazt.nq.hw.pr
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            com.byazt.nq.hw.pr prVarPr = pr(uri);
            if (prVarPr == null) {
                return null;
            }
            return prVarPr.insert(uri, contentValues);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.byazt.nq.hw.pr
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            com.byazt.nq.hw.pr prVarPr = pr(uri);
            if (prVarPr == null) {
                return 0;
            }
            return prVarPr.delete(uri, str, strArr);
        } catch (Throwable th) {
            return 0;
        }
    }

    @Override // com.byazt.nq.hw.pr
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            com.byazt.nq.hw.pr prVarPr = pr(uri);
            if (prVarPr == null) {
                return 0;
            }
            return prVarPr.update(uri, contentValues, str, strArr);
        } catch (Throwable th) {
            return 0;
        }
    }
}
