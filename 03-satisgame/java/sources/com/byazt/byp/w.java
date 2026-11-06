package com.byazt.byp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.nf.rv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 74, 13})
public class w implements com.byazt.lpr.q.n {
    public static volatile w n;
    public static WeakReference<Context> qg;
    public static List<com.byazt.lpr.q.n> s;

    private boolean qg(Uri uri) {
        return true;
    }

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return "";
    }

    @Override // com.byazt.lpr.q.n
    public void init() {
    }

    static {
        List<com.byazt.lpr.q.n> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        s = listSynchronizedList;
        listSynchronizedList.add(new s());
        s.add(new com.byazt.xp.qg());
        s.add(new com.byazt.vm.n());
        s.add(new n(com.byazt.vyf.s.cy().ou()));
        Iterator<com.byazt.lpr.q.n> it = s.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    public static w n(Context context) {
        if (context != null) {
            qg = new WeakReference<>(context.getApplicationContext());
        }
        if (n == null) {
            synchronized (w.class) {
                if (n == null) {
                    n = new w();
                }
            }
        }
        return n;
    }

    private w() {
    }

    private com.byazt.lpr.q.n n(Uri uri) {
        if (uri == null || !qg(uri)) {
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
        for (com.byazt.lpr.q.n nVar : s) {
            if (str.equals(nVar.getTableName())) {
                return nVar;
            }
        }
        return null;
    }

    private Context getContext() {
        WeakReference<Context> weakReference = qg;
        return (weakReference == null || weakReference.get() == null) ? rv.getContext() : qg.get();
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
        Iterator<com.byazt.lpr.q.n> it = s.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            com.byazt.lpr.q.n nVarN = n(uri);
            if (nVarN != null) {
                return nVarN.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        try {
            com.byazt.lpr.q.n nVarN = n(uri);
            if (nVarN != null) {
                return nVarN.getType(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            com.byazt.lpr.q.n nVarN = n(uri);
            if (nVarN != null) {
                return nVarN.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            com.byazt.lpr.q.n nVarN = n(uri);
            if (nVarN != null) {
                return nVarN.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            com.byazt.lpr.q.n nVarN = n(uri);
            if (nVarN != null) {
                return nVarN.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
