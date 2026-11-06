package com.bytedance.sdk.component.x.xr.ms.ms.xr;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.analytics.pro.bz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr extends com.bytedance.sdk.component.x.xr.ms.ms implements ah {
    private com.bytedance.sdk.component.x.ms.ka ah;
    private com.bytedance.sdk.component.x.xr.d.xr.ms d;
    private final Context xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final List<com.bytedance.sdk.component.x.ms.xr> f1568ms = new ArrayList();
    private boolean ka = false;
    private final Runnable c = new Runnable() { // from class: com.bytedance.sdk.component.x.xr.ms.ms.xr.xr.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (xr.this) {
                if (xr.this.f1568ms.isEmpty()) {
                    xr.this.ka = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(xr.this.f1568ms);
                xr.this.f1568ms.clear();
                xr.this.ka = false;
                xr.this.xr(arrayList);
            }
        }
    };

    abstract com.bytedance.sdk.component.x.ms.ka d();

    public abstract String ms();

    public xr(Context context, com.bytedance.sdk.component.x.ms.ka kaVar, com.bytedance.sdk.component.x.xr.d.xr.ms msVar) {
        this.xr = context;
        this.ah = kaVar;
        this.d = msVar;
    }

    private void xr() {
        if (this.ka) {
            return;
        }
        com.bytedance.sdk.component.x.xr.ab.ms msVarMs = com.bytedance.sdk.component.x.xr.ab.ms.ms(d());
        msVarMs.ms().postDelayed(this.c, msVarMs.xr());
        this.ka = true;
    }

    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, int i2, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z) {
        int iXr;
        if (this.d == null || xrVar == null || !com.bytedance.sdk.component.x.xr.ah.ms.ms(i) || !ms(xrVar) || (iXr = this.d.xr()) <= i2) {
            return null;
        }
        return ms(iXr - i2, bz.d, i, z);
    }

    public com.bytedance.sdk.component.x.xr.ms.xr ms(int i, List<com.bytedance.sdk.component.x.ms.xr> list) {
        com.bytedance.sdk.component.x.xr.ms.xr xrVar = new com.bytedance.sdk.component.x.xr.ms.xr();
        if (list != null && list.size() != 0 && list.get(0) != null && ms(list.get(0))) {
            if (i == 200 || i == -1 || i == -3) {
                xrVar.ms(delete(list));
            } else {
                xrVar.ms("code:".concat(String.valueOf(i)));
            }
            xrVar.ms(true);
            return xrVar;
        }
        xrVar.ms(false);
        return xrVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0026 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
      0x0026: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:13:0x0031, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE]
      0x0026: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:13:0x0031, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int ka() {
        Cursor cursorQuery = null;
        int i = 0;
        try {
            cursorQuery = com.bytedance.sdk.component.x.xr.ms.ms.xr.query(getContext(), ms(), new String[]{"count(1)"}, null, null, null, null, null, this.ah);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                i = cursorQuery.getInt(0);
            }
        } catch (Exception unused) {
        } finally {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
        }
        return i;
    }

    protected void ms(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.x.ms.xr> it = this.f1568ms.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.x.ms.xr next = it.next();
                if (next != null) {
                    String strAh = next.ah();
                    if (!TextUtils.isEmpty(strAh) && list.contains(strAh)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.x.xr.ah.ah.ms("DBInsertMemRepo", ms() + "deleteMemList: " + th.getMessage(), this.ah.ka());
        }
    }

    public synchronized void xr(com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (ms(xrVar) && xrVar.ab() != null && !TextUtils.isEmpty(xrVar.ah())) {
            this.f1568ms.add(xrVar);
            xr();
        }
    }

    public Context getContext() {
        return this.xr;
    }

    public void xr(List<com.bytedance.sdk.component.x.ms.xr> list) {
        com.bytedance.sdk.component.x.xr.ms.ms.xr.insert(getContext(), ms(), list, this.ah);
        Iterator<com.bytedance.sdk.component.x.ms.xr> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.x.xr.ah.ms.ms(it.next(), this.ah, "_db");
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public List<com.bytedance.sdk.component.x.ms.xr> xr(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, List<String> list, String str) {
        List<com.bytedance.sdk.component.x.ms.xr> listMs = ms(bz.d, i, z);
        if (!ms(listMs, list)) {
            return null;
        }
        ms();
        listMs.size();
        return listMs;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public boolean ms(String str) {
        if (this.d == null) {
            return false;
        }
        int iKa = ka();
        com.bytedance.sdk.component.x.xr.ah.ah.ms("check flush db " + ms() + " count:" + iKa, this.ah);
        return iKa > 0;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public boolean xr(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (this.d == null) {
            return false;
        }
        int iKa = ka();
        int iMs = this.d.ms();
        com.bytedance.sdk.component.x.xr.ah.ah.ms("check db " + ms() + " count:" + iKa + " MaxCacheCount:" + iMs + " message:" + com.bytedance.sdk.component.x.xr.ah.ms.xr(i), this.ah);
        return iKa >= iMs;
    }

    private boolean ms(List<com.bytedance.sdk.component.x.ms.xr> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.x.ms.xr> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.x.ms.xr next = it.next();
                    if (next != null) {
                        String strAh = next.ah();
                        if (!TextUtils.isEmpty(strAh) && list2.contains(strAh)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.x.xr.ah.ah.ms("DBInsertMemRepo", "deleteMemList: " + th.getMessage(), this.ah);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}
