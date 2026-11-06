package com.onevcat.uniwebview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/onevcat/uniwebview/UniWebViewProxyActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "Lcom/onevcat/uniwebview/y;", "handler", "Lcom/onevcat/uniwebview/y;", "Companion", "com/onevcat/uniwebview/W1", "uniwebview_release"}, k = 1, mv = {1, 6, 0})
public class UniWebViewProxyActivity extends Activity {
    public static final W1 Companion = new W1();
    public static final String HANDLER_ID = "com.uniwebview.UniWebViewProxyActivity.handlerId";
    private InterfaceC0772y handler;

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        InterfaceC0772y interfaceC0772y = this.handler;
        if (interfaceC0772y != null) {
            interfaceC0772y.a(this, requestCode, resultCode, data);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        InterfaceC0772y interfaceC0772y;
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra(HANDLER_ID);
        InterfaceC0772y.a.getClass();
        LinkedHashMap linkedHashMap = C0769x.b;
        InterfaceC0772y interfaceC0772y2 = (InterfaceC0772y) linkedHashMap.get(stringExtra);
        if (interfaceC0772y2 != null) {
            this.handler = interfaceC0772y2;
            interfaceC0772y2.a(this);
            return;
        }
        C0731l c0731l = C0731l.b;
        String message = "No handler found for this activity: " + this + ". Usually this means a wrong implementation of the browser that does not start the callback URI intent in the desired way. Trying to recover by force dismiss and go back to the normal flow...If you know the browser you are using when seeing this, please report back to the developer.";
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.CRITICAL, message);
        Iterator it = linkedHashMap.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                interfaceC0772y = null;
                break;
            }
            interfaceC0772y = (InterfaceC0772y) ((Map.Entry) it.next()).getValue();
        } while (interfaceC0772y == null);
        if (interfaceC0772y != null) {
            C0731l c0731l2 = C0731l.b;
            String message2 = "handler is null for " + this + ". Forwarding intent to the first handler: " + interfaceC0772y;
            c0731l2.getClass();
            Intrinsics.checkNotNullParameter(message2, "message");
            c0731l2.a(EnumC0728k.DEBUG, message2);
            interfaceC0772y.a(getIntent());
            interfaceC0772y.a();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        InterfaceC0772y interfaceC0772y = this.handler;
        if (interfaceC0772y != null) {
            interfaceC0772y.b();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        InterfaceC0772y interfaceC0772y = this.handler;
        if (interfaceC0772y != null) {
            interfaceC0772y.a(intent);
        }
    }
}
