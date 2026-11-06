package com.anythink.core.common.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.anythink.core.api.ATCommonConfig;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.p;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final int a = -1;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static volatile a f;
    private final String e = "AdxSDKDetectManager";
    private final AtomicBoolean g = new AtomicBoolean(false);

    private a() {
    }

    public static a a() {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a();
                }
            }
        }
        return f;
    }

    public static b a(Context context) {
        try {
            try {
                Object objInvoke = Class.forName("com.anythink.network.adx.AdxATInitManager").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                if (objInvoke != null && (objInvoke instanceof ATInitMediation)) {
                    try {
                        Class.forName(((ATInitMediation) objInvoke).getNetworkSDKClass());
                    } catch (Throwable th) {
                        String string = "There is a problem with the integrated AnyThink SDK:Adx aar is missing";
                        if (context != null) {
                            string = context.getResources().getString(p.a(context, "adx_sdk_check_tips_miss_sdk", "string"));
                            try {
                                string = String.format(string, "anythink");
                            } catch (Throwable unused) {
                            }
                        }
                        return new b(2, string, th.getMessage());
                    }
                }
            } catch (Throwable th2) {
                String string2 = "There is a problem with the integrated AnyThink SDK:Adx Adapter is missing";
                if (context != null) {
                    string2 = context.getResources().getString(p.a(context, "adx_sdk_check_tips_miss_adapter", "string"));
                    try {
                        string2 = String.format(string2, "anythink");
                    } catch (Throwable unused2) {
                    }
                }
                return new b(1, string2, th2.getMessage());
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    public final void a(final Activity activity) {
        final b bVarA;
        if (activity == null) {
            return;
        }
        s.b();
        if (!ATCommonConfig.isShowInitErrorTips || this.g.get() || (bVarA = a((Context) activity)) == null) {
            return;
        }
        activity.getWindow().getDecorView().post(new Runnable() { // from class: com.anythink.core.common.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String string = activity.getResources().getString(p.a(activity, "adx_sdk_check_tips_title", "string"));
                    String string2 = activity.getResources().getString(p.a(activity, "adx_sdk_check_tips_confirm", "string"));
                    Activity activity2 = activity;
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity2, p.a(activity2, "system_dialog", "style"));
                    builder.setTitle(string).setMessage(bVarA.b).setCancelable(true).setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.anythink.core.common.e.a.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.anythink.core.common.e.a.1.2
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            a.this.g.set(true);
                        }
                    });
                    alertDialogCreate.show();
                } catch (Throwable unused) {
                }
            }
        });
    }
}
