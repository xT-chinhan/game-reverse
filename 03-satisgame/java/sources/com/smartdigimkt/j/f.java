package com.smartdigimkt.j;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.smartdigimkt.dlopt.api.ATApkDialogClickListener;
import com.smartdigimkt.dlopt.api.ATApkManager;
import com.smartdigimkt.k.b0;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements ATApkManager {
    public final b0 a;
    public final Context b;
    public final ArrayList c = new ArrayList();

    public f(Context context, u uVar) {
        this.a = uVar;
        this.b = context;
        new ArrayList();
    }

    public static void a(f fVar, Context context, com.smartdigimkt.k.r rVar, String str, String str2, int i, ATApkDialogClickListener aTApkDialogClickListener) {
        fVar.getClass();
        if (context instanceof Activity) {
            try {
                new AlertDialog.Builder(context).setMessage(str).setNegativeButton(a(context, "btn_cancel", new Object[0]), new d(aTApkDialogClickListener)).setPositiveButton(str2, new c(fVar, aTApkDialogClickListener, i, rVar)).create().show();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // com.smartdigimkt.dlopt.api.ATApkManager
    public final void showOpenOrInstallAppDialog(ATApkDialogClickListener aTApkDialogClickListener) {
        Context context = this.b;
        if (context instanceof Activity) {
            b0 b0Var = this.a;
            if (b0Var == null) {
                Objects.toString(context);
                com.smartdigimkt.q3.f.a().a(new e(aTApkDialogClickListener, 0));
                return;
            }
            b bVar = new b(this, aTApkDialogClickListener, context);
            com.smartdigimkt.k.o oVar = ((u) b0Var).o;
            if (oVar == null || oVar.b == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(2);
            oVar.c.b(new com.smartdigimkt.k.k(oVar, arrayList, 0, bVar));
        }
    }

    public static String a(Context context, String str, Object... objArr) {
        return context == null ? "" : context.getString(com.smartdigimkt.r4.k.a(context, str, "string"), objArr);
    }
}
