package com.anythink.dlopt.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;
import com.anythink.dlopt.api.ATApkDialogClickListener;
import com.anythink.dlopt.api.ATApkListener;
import com.anythink.dlopt.api.ATApkManager;
import com.anythink.dlopt.common.a.j;
import com.anythink.dlopt.common.a.n;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ATApkManager {
    public static final String a = "ApkDeveloperManager";
    private n b;
    private ATApkListener c;
    private final Context d;
    private final List<String> e = new ArrayList();
    private final List<String> f = new ArrayList();

    private static String a() {
        return "anythink_ApkDeveloperManager";
    }

    public a(Context context, n nVar) {
        this.b = nVar;
        this.d = context;
    }

    @Override // com.anythink.dlopt.api.ATApkManager
    public final void showOpenOrInstallAppDialog(final ATApkDialogClickListener aTApkDialogClickListener) {
        final Context context = this.d;
        if (!(context instanceof Activity)) {
            Log.e("anythink_ApkDeveloperManager", "showOpenOrInstallAppDialog() failed. context must be activity.");
            return;
        }
        n nVar = this.b;
        if (nVar == null) {
            Log.e("anythink_ApkDeveloperManager", "showOpenOrInstallAppDialog() >>> context: " + this.d + " apkManager is null.");
            a(aTApkDialogClickListener, 0);
        } else {
            nVar.a(new com.anythink.dlopt.common.a.d.b() { // from class: com.anythink.dlopt.common.a.1
                @Override // com.anythink.dlopt.common.a.d.b
                public final void a(List<j> list) {
                    final j jVar;
                    if (list.size() == 0) {
                        a.this.a(aTApkDialogClickListener, 0);
                        return;
                    }
                    int i = 0;
                    while (true) {
                        try {
                            if (i >= list.size()) {
                                jVar = null;
                                break;
                            }
                            jVar = list.get(i);
                            if (!a.this.e.contains(jVar.o)) {
                                break;
                            } else {
                                i++;
                            }
                        } catch (Throwable th) {
                            Object[] objArr = new Object[1];
                            th.getMessage();
                            return;
                        }
                    }
                    if (jVar == null) {
                        a.this.e.clear();
                        jVar = list.get(0);
                    }
                    a.this.e.add(jVar.o);
                    Object[] objArr2 = new Object[2];
                    String str = jVar.o;
                    jVar.a();
                    t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (jVar.h() && a.this.b.a(jVar.o)) {
                                a.a(a.this, context, jVar, a.b(context, "btn_install_tip", jVar.c), a.b(context, "btn_install", new Object[0]), 1, aTApkDialogClickListener);
                                a.this.a(aTApkDialogClickListener, 1);
                            } else if (jVar.g()) {
                                a.a(a.this, context, jVar, a.b(context, "btn_open_tip", jVar.c), a.b(context, "btn_open", new Object[0]), 2, aTApkDialogClickListener);
                                a.this.a(aTApkDialogClickListener, 2);
                            }
                        }
                    });
                }
            });
        }
    }

    private void a(Context context, j jVar, String str, String str2, int i, ATApkDialogClickListener aTApkDialogClickListener) {
        if (!(context instanceof Activity)) {
            Log.e("anythink_ApkDeveloperManager", "showDialog() failed. context must be activity.");
            return;
        }
        try {
            new AlertDialog.Builder(context).setMessage(str).setNegativeButton(b(context, "btn_cancel", new Object[0]), new AnonymousClass3(aTApkDialogClickListener)).setPositiveButton(str2, new AnonymousClass2(aTApkDialogClickListener, i, jVar)).create().show();
        } catch (Throwable th) {
            Log.e("anythink_ApkDeveloperManager", "showDialog() >>> failed: " + th.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.a$3, reason: invalid class name */
    final class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ ATApkDialogClickListener a;

        AnonymousClass3(ATApkDialogClickListener aTApkDialogClickListener) {
            this.a = aTApkDialogClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            ATApkDialogClickListener aTApkDialogClickListener = this.a;
            if (aTApkDialogClickListener != null) {
                aTApkDialogClickListener.onButtonClick(2);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.a$2, reason: invalid class name */
    final class AnonymousClass2 implements DialogInterface.OnClickListener {
        final /* synthetic */ ATApkDialogClickListener a;
        final /* synthetic */ int b;
        final /* synthetic */ j c;

        AnonymousClass2(ATApkDialogClickListener aTApkDialogClickListener, int i, j jVar) {
            this.a = aTApkDialogClickListener;
            this.b = i;
            this.c = jVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            ATApkDialogClickListener aTApkDialogClickListener = this.a;
            if (aTApkDialogClickListener != null) {
                aTApkDialogClickListener.onButtonClick(1);
            }
            dialogInterface.dismiss();
            int i2 = this.b;
            if (i2 == 2) {
                a.this.b.a(this.c, 3);
            } else if (i2 == 1) {
                a.this.b.b(this.c, 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str, Object... objArr) {
        if (context == null) {
            return "";
        }
        int iA = q.a(context, str, "string");
        if (objArr != null) {
            return context.getString(iA, objArr);
        }
        return context.getString(iA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ATApkDialogClickListener aTApkDialogClickListener, final int i) {
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.a.4
            @Override // java.lang.Runnable
            public final void run() {
                ATApkDialogClickListener aTApkDialogClickListener2 = aTApkDialogClickListener;
                if (aTApkDialogClickListener2 != null) {
                    aTApkDialogClickListener2.onShowResult(i);
                }
            }
        });
    }

    static /* synthetic */ void a(a aVar, Context context, j jVar, String str, String str2, int i, ATApkDialogClickListener aTApkDialogClickListener) {
        if (!(context instanceof Activity)) {
            Log.e("anythink_ApkDeveloperManager", "showDialog() failed. context must be activity.");
            return;
        }
        try {
            new AlertDialog.Builder(context).setMessage(str).setNegativeButton(b(context, "btn_cancel", new Object[0]), aVar.new AnonymousClass3(aTApkDialogClickListener)).setPositiveButton(str2, aVar.new AnonymousClass2(aTApkDialogClickListener, i, jVar)).create().show();
        } catch (Throwable th) {
            Log.e("anythink_ApkDeveloperManager", "showDialog() >>> failed: " + th.getMessage());
        }
    }
}
