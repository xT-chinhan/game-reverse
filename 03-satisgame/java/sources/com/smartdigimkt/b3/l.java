package com.smartdigimkt.b3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends c {
    public long S;
    public String T;
    public int U;
    public String V;
    public n W;
    public String X;
    public int Y;
    public int Z;
    public int a0;
    public int b0;
    public String c0;
    public String d0;
    public int e0;
    public int f0;
    public long g0;
    public final ConcurrentHashMap h0 = new ConcurrentHashMap();
    public String i0 = "";

    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:33:0x008f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0093  */
    /* JADX WARN: Code duplicated, block: B:37:0x009b  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:76:0x0143  */
    /* JADX WARN: Code duplicated, block: B:79:0x014c  */
    @Override // com.smartdigimkt.b3.c
    public final ArrayList a(e eVar, boolean z) {
        boolean z2;
        m mVar = (m) eVar;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.equals(String.valueOf(mVar.a), "0")) {
            if (!TextUtils.isEmpty(this.i)) {
                arrayList.add(this.i);
            }
            if (!z && !TextUtils.isEmpty(this.f)) {
                arrayList.add(this.f);
            }
        }
        if (TextUtils.equals(String.valueOf(mVar.a), "1")) {
            if (!TextUtils.isEmpty(this.e)) {
                arrayList.add(this.e);
            }
            if (TextUtils.isEmpty(this.f)) {
                if (TextUtils.isEmpty(this.i)) {
                    stringBuffer.append("full_u,");
                    z2 = false;
                }
                if (TextUtils.isEmpty(this.i)) {
                    if (mVar.i0 == 1 && mVar.j0 <= 0) {
                        stringBuffer.append("video_u,");
                    } else if (mVar.j0 != 1) {
                        if (TextUtils.isEmpty(this.f)) {
                            stringBuffer.append("full_u,");
                        } else if (!arrayList.contains(this.f)) {
                            arrayList.add(this.f);
                        }
                    }
                    z2 = false;
                } else {
                    arrayList.add(this.i);
                }
            } else {
                arrayList.add(this.f);
            }
            z2 = true;
            if (TextUtils.isEmpty(this.i)) {
                arrayList.add(this.i);
            } else if (mVar.i0 == 1) {
                if (mVar.j0 != 1) {
                    if (TextUtils.isEmpty(this.f)) {
                        stringBuffer.append("full_u,");
                        z2 = false;
                    } else if (!arrayList.contains(this.f)) {
                        arrayList.add(this.f);
                    }
                }
            } else if (mVar.j0 != 1) {
                if (TextUtils.isEmpty(this.f)) {
                    stringBuffer.append("full_u,");
                    z2 = false;
                } else if (!arrayList.contains(this.f)) {
                    arrayList.add(this.f);
                }
            }
        } else {
            z2 = true;
        }
        if (TextUtils.equals(String.valueOf(mVar.a), "3")) {
            if (!TextUtils.isEmpty(this.e)) {
                arrayList.add(this.e);
            }
            if (TextUtils.isEmpty(this.f)) {
                stringBuffer.append("full_u,");
                z2 = false;
            } else {
                arrayList.add(this.f);
            }
            if (h() && this.n == 1) {
                arrayList.add(this.i);
            }
        }
        if (TextUtils.equals(mVar.a + "", "2")) {
            int i = this.U;
            if (i != 1) {
                if (i == 2) {
                    if (TextUtils.isEmpty(this.V)) {
                        stringBuffer.append("img_list,");
                        z2 = false;
                    }
                } else if (i != 3) {
                    if (i == 4) {
                        if (TextUtils.isEmpty(this.V)) {
                            stringBuffer.append("img_list,");
                            z2 = false;
                        }
                    }
                } else if (!TextUtils.isEmpty(this.i)) {
                    arrayList.add(this.i);
                    if (!TextUtils.isEmpty(this.f)) {
                        arrayList.add(this.f);
                    }
                } else if (TextUtils.isEmpty(this.f)) {
                    stringBuffer.append("full_u,");
                    z2 = false;
                } else {
                    arrayList.add(this.f);
                }
            } else if (!TextUtils.isEmpty(this.i)) {
                arrayList.add(this.i);
                if (!TextUtils.isEmpty(this.f)) {
                    arrayList.add(this.f);
                }
            } else if (TextUtils.isEmpty(this.f)) {
                stringBuffer.append("full_u,");
                z2 = false;
            } else {
                arrayList.add(this.f);
            }
        }
        if (TextUtils.equals(String.valueOf(mVar.a), "4")) {
            if (!TextUtils.isEmpty(this.i)) {
                arrayList.add(this.i);
                if (!TextUtils.isEmpty(this.f)) {
                    arrayList.add(this.f);
                }
            } else if (TextUtils.isEmpty(this.f)) {
                stringBuffer.append("full_u,");
            } else {
                arrayList.add(this.f);
            }
            if (z2) {
                return arrayList;
            }
        } else if (z2) {
            return arrayList;
        }
        this.i0 = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    @Override // com.smartdigimkt.b3.c
    public final ArrayList b(e eVar) {
        m mVar = (m) eVar;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(mVar.a + "", "2") && this.U == 3 && !TextUtils.isEmpty(this.e)) {
            arrayList.add(this.e);
        }
        if (TextUtils.equals(String.valueOf(mVar.a), "4") && 1 != this.U && !TextUtils.isEmpty(this.e)) {
            arrayList.add(this.e);
        }
        return arrayList;
    }

    public final boolean j() {
        return System.currentTimeMillis() >= this.g0;
    }

    @Override // com.smartdigimkt.b3.c
    public String a() {
        return this.i0;
    }

    public final boolean a(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                return this.Y == 1;
            }
            return this.Z == 1;
        }
        if (z2) {
            return this.a0 == 1;
        }
        return this.b0 == 1;
    }
}
