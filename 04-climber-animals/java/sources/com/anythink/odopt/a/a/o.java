package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    private static final String a = "OppoOaid";
    private Context b;
    private com.anythink.odopt.a.a c;
    private p d;
    private final ServiceConnection e = new ServiceConnection() { // from class: com.anythink.odopt.a.a.o.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            o.this.d = p.a.a(iBinder);
            o.a(o.this);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            o.this.d = null;
        }
    };

    public o(Context context) {
        this.b = context;
    }

    public final boolean a(com.anythink.odopt.a.a aVar) {
        if (this.b == null) {
            return false;
        }
        this.c = aVar;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            return this.b.bindService(intent, this.e, 1);
        } catch (Throwable th) {
            a("", "bindService failed: " + th.getMessage());
            return false;
        }
    }

    private void a() {
        try {
            if (this.d != null) {
                String strB = b("OUID");
                if (!TextUtils.isEmpty(strB)) {
                    a(strB, "");
                    Context context = this.b;
                    if (context != null) {
                        try {
                            context.unbindService(this.e);
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    return;
                }
                try {
                    SystemClock.sleep(com.tapsdk.tapad.e.a.f);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                a(b("OUID"), "");
            } else {
                a("", "get oaid failed: oppoOaidInterface is null.");
            }
            Context context2 = this.b;
            if (context2 != null) {
                try {
                    context2.unbindService(this.e);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable th2) {
            try {
                a("", "get oaid failed: " + th2.getMessage());
            } finally {
                Context context3 = this.b;
                if (context3 != null) {
                    try {
                        context3.unbindService(this.e);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }
    }

    private void a(String str) {
        a(str, "");
    }

    private void a(String str, String str2) {
        if (this.c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.c.a(str, false);
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "oaid is null or empty.";
            }
            this.c.a(str2);
        }
    }

    private String b(String str) {
        Signature[] signatureArr;
        String packageName = this.b.getPackageName();
        String string = null;
        try {
            signatureArr = this.b.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (Exception e) {
            e.printStackTrace();
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(com.tapsdk.tapad.internal.utils.i.b);
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                    }
                    string = sb.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return ((p.a.C0138a) this.d).a(packageName, string, str);
    }

    static /* synthetic */ void a(o oVar) {
        try {
            if (oVar.d != null) {
                String strB = oVar.b("OUID");
                if (!TextUtils.isEmpty(strB)) {
                    oVar.a(strB, "");
                    Context context = oVar.b;
                    if (context != null) {
                        try {
                            context.unbindService(oVar.e);
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    return;
                }
                try {
                    SystemClock.sleep(com.tapsdk.tapad.e.a.f);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                oVar.a(oVar.b("OUID"), "");
            } else {
                oVar.a("", "get oaid failed: oppoOaidInterface is null.");
            }
            Context context2 = oVar.b;
            if (context2 != null) {
                try {
                    context2.unbindService(oVar.e);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable th2) {
            try {
                oVar.a("", "get oaid failed: " + th2.getMessage());
            } finally {
                Context context3 = oVar.b;
                if (context3 != null) {
                    try {
                        context3.unbindService(oVar.e);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }
    }
}
