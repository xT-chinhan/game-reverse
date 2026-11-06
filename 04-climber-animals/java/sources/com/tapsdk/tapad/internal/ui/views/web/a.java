package com.tapsdk.tapad.internal.ui.views.web;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.download.StatusUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Dialog {
    private static final String j = "BottomDownloadingDialog";
    com.tapsdk.tapad.internal.download.f a;
    private List<String> b;
    f c;
    ProgressBar d;
    ImageView e;
    ImageView f;
    TextView g;
    TextView h;
    com.tapsdk.tapad.internal.ui.views.web.b i;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.web.a$a, reason: collision with other inner class name */
    class C0641a implements f {

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.web.a$a$a, reason: collision with other inner class name */
        class RunnableC0642a implements Runnable {
            RunnableC0642a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.dismiss();
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.web.a$a$b */
        class b implements Consumer<String> {
            final /* synthetic */ HashMap a;

            b(HashMap map) {
                this.a = map;
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(String str) throws Exception {
                if (com.tapsdk.tapad.internal.utils.b.a(a.this.getContext(), str)) {
                    this.a.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.c));
                    com.tapsdk.tapad.internal.tracker.c.a().a(a.this.b, this.a);
                }
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.web.a$a$c */
        class c implements com.tapsdk.tapad.internal.n.c.a {
            final /* synthetic */ File a;
            final /* synthetic */ HashMap b;

            /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.web.a$a$c$a, reason: collision with other inner class name */
            class C0643a implements Consumer<String> {
                C0643a() {
                }

                @Override // io.reactivex.functions.Consumer
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(String str) throws Exception {
                    if (com.tapsdk.tapad.internal.utils.b.a(a.this.getContext(), str)) {
                        c.this.b.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.c));
                        com.tapsdk.tapad.internal.tracker.c.a().a(a.this.b, c.this.b);
                    }
                }
            }

            c(File file, HashMap map) {
                this.a = file;
                this.b = map;
            }

            @Override // com.tapsdk.tapad.internal.n.c.a
            public void a(boolean z) {
                if (!z || a.this.b.isEmpty()) {
                    return;
                }
                com.tapsdk.tapad.internal.utils.f.b(a.this.getContext(), this.a).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0643a());
            }
        }

        C0641a() {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void a(com.tapsdk.tapad.internal.download.f fVar) {
            File fileH;
            new Handler().postDelayed(new RunnableC0642a(), 300L);
            HashMap map = new HashMap();
            if (!a.this.b.isEmpty()) {
                map.put("timestamp", String.valueOf(System.currentTimeMillis()));
                map.put("inner_browser_action_url", fVar.e());
                map.put("interaction_type", String.valueOf(1));
                map.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.a));
                com.tapsdk.tapad.internal.tracker.c.a().a(a.this.b, map);
            }
            if (fVar == null || (fileH = fVar.h()) == null || !fileH.exists()) {
                return;
            }
            try {
                if (a.this.i.b.endsWith(com.anythink.dlopt.common.a.a.h)) {
                    if (!a.this.b.isEmpty()) {
                        map.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.b));
                        com.tapsdk.tapad.internal.tracker.c.a().a(a.this.b, map);
                        com.tapsdk.tapad.internal.utils.f.b(a.this.getContext(), fileH).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(map));
                    }
                    new com.tapsdk.tapad.internal.n.c(com.tapsdk.tapad.internal.utils.a.a(a.this.getContext()), fileH, null).a(new c(fileH, map));
                    return;
                }
                Uri uriForFile = FileProvider.getUriForFile(a.this.getContext(), a.this.getContext().getPackageName() + ".com.tds.ad.fileprovider", fileH);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, "resource/folder");
                a.this.getContext().startActivity(intent);
            } catch (Throwable unused) {
            }
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i) {
            ProgressBar progressBar = a.this.d;
            if (progressBar != null) {
                progressBar.setProgress(i);
            }
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void a(com.tapsdk.tapad.internal.download.f fVar, Exception exc) {
            a.this.dismiss();
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void b(com.tapsdk.tapad.internal.download.f fVar) {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void c(com.tapsdk.tapad.internal.download.f fVar) {
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageView imageView;
            int i;
            com.tapsdk.tapad.internal.download.f fVar = a.this.a;
            if (fVar != null) {
                if (StatusUtil.b(fVar) == StatusUtil.Status.RUNNING) {
                    a.this.a.f();
                    imageView = a.this.f;
                    i = R.drawable.tapad_webview_downloading_pause_icon;
                } else {
                    a.this.a();
                    imageView = a.this.f;
                    i = R.drawable.tapad_webview_downloading_icon;
                }
                imageView.setImageResource(i);
            }
        }
    }

    public a(Context context, com.tapsdk.tapad.internal.ui.views.web.b bVar, List<String> list) {
        super(context);
        this.a = null;
        this.b = new ArrayList();
        this.c = new C0641a();
        this.i = bVar;
        if (list != null) {
            this.b.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.a = e.a(this.i, com.tapsdk.tapad.internal.ui.views.web.c.a(getContext().getApplicationContext()), new d(this.c));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.i == null) {
            dismiss();
        }
        setContentView(R.layout.tapad_webview_bottom_downloading);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.d = (ProgressBar) findViewById(R.id.download_progress);
        this.e = (ImageView) findViewById(R.id.download_close_icon);
        this.g = (TextView) findViewById(R.id.download_file_name_text);
        this.h = (TextView) findViewById(R.id.download_file_size_text);
        this.f = (ImageView) findViewById(R.id.download_state_icon);
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(this.i.b);
        }
        if (this.h != null) {
            this.h.setText(this.i.c + "B");
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new c());
        }
        a();
    }
}
