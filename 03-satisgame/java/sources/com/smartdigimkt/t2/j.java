package com.smartdigimkt.t2;

import android.database.Cursor;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static volatile j d;
    public final String a = j.class.getName();
    public final com.smartdigimkt.z2.i b;
    public final com.smartdigimkt.z2.h c;

    public j() {
        if (SDKContext.getInstance().d() != null) {
            com.smartdigimkt.z2.d dVarA = com.smartdigimkt.z2.d.a(SDKContext.getInstance().d());
            if (com.smartdigimkt.z2.i.b == null) {
                synchronized (com.smartdigimkt.z2.i.class) {
                    if (com.smartdigimkt.z2.i.b == null) {
                        com.smartdigimkt.z2.i.b = new com.smartdigimkt.z2.i(dVarA);
                    }
                }
            }
            this.b = com.smartdigimkt.z2.i.b;
            this.c = com.smartdigimkt.z2.h.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d()));
        }
    }

    public static j a() {
        if (d == null) {
            synchronized (j.class) {
                if (d == null) {
                    d = new j();
                }
            }
        }
        return d;
    }

    public final ArrayList b(int i) {
        ArrayList arrayList;
        com.smartdigimkt.z2.i iVar = this.b;
        synchronized (iVar) {
            arrayList = new ArrayList();
            if (i > 0) {
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = iVar.a().query("dsp_offer_show_record", null, "show_count > show_limit", null, null, null, "last_update_time DESC", i + "");
                        ArrayList arrayListA = iVar.a(cursorQuery);
                        arrayListA.size();
                        cursorQuery.close();
                        arrayList.addAll(arrayListA);
                    } catch (Throwable th) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                    }
                    return arrayList;
                } catch (OutOfMemoryError unused2) {
                    System.gc();
                    if (cursorQuery != null) {
                    }
                    return arrayList;
                } catch (Throwable unused3) {
                    if (cursorQuery != null) {
                    }
                    return arrayList;
                }
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    public final ArrayList a(int i) {
        ArrayList arrayList;
        com.smartdigimkt.z2.h hVar = this.c;
        synchronized (hVar) {
            try {
                arrayList = new ArrayList();
                if (i > 0) {
                    Cursor cursorQuery = null;
                    try {
                        try {
                            cursorQuery = hVar.a().query("dsp_offer_install_record", null, null, null, null, null, "last_update_time DESC", i + "");
                            ArrayList arrayListA = hVar.a(cursorQuery);
                            cursorQuery.close();
                            arrayListA.size();
                            arrayList.addAll(arrayListA);
                        } catch (Throwable th) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    } catch (Exception unused) {
                        if (cursorQuery != null) {
                        }
                        return arrayList;
                    } catch (OutOfMemoryError unused2) {
                        System.gc();
                        if (cursorQuery != null) {
                        }
                        return arrayList;
                    } catch (Throwable unused3) {
                        if (cursorQuery != null) {
                        }
                        return arrayList;
                    }
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }
}
