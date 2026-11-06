package com.tapsdk.tapad.internal.ui.views.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class BottomDownloadingView extends LinearLayout {
    com.tapsdk.tapad.internal.download.f a;
    private List<String> b;
    private d c;
    f d;
    ProgressBar e;
    ImageView f;
    ImageView g;
    TextView h;
    TextView i;
    com.tapsdk.tapad.internal.ui.views.web.b j;

    class a implements f {
        private long a = System.currentTimeMillis();

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.web.BottomDownloadingView$a$a, reason: collision with other inner class name */
        class C0639a implements Consumer<String> {
            final /* synthetic */ HashMap a;

            C0639a(HashMap map) {
                this.a = map;
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(String str) throws Exception {
                if (com.tapsdk.tapad.internal.utils.b.a(BottomDownloadingView.this.getContext(), str)) {
                    this.a.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.c));
                    com.tapsdk.tapad.internal.tracker.c.a().a(BottomDownloadingView.this.b, this.a);
                }
            }
        }

        class b implements com.tapsdk.tapad.internal.n.c.a {
            final /* synthetic */ File a;
            final /* synthetic */ HashMap b;

            /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.web.BottomDownloadingView$a$b$a, reason: collision with other inner class name */
            class C0640a implements Consumer<String> {
                C0640a() {
                }

                @Override // io.reactivex.functions.Consumer
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(String str) throws Exception {
                    if (com.tapsdk.tapad.internal.utils.b.a(BottomDownloadingView.this.getContext(), str)) {
                        b.this.b.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.c));
                        com.tapsdk.tapad.internal.tracker.c.a().a(BottomDownloadingView.this.b, b.this.b);
                    }
                }
            }

            b(File file, HashMap map) {
                this.a = file;
                this.b = map;
            }

            @Override // com.tapsdk.tapad.internal.n.c.a
            public void a(boolean z) {
                if (!z || BottomDownloadingView.this.b.isEmpty()) {
                    return;
                }
                com.tapsdk.tapad.internal.utils.f.b(BottomDownloadingView.this.getContext(), this.a).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0640a());
            }
        }

        class c implements Runnable {
            final /* synthetic */ int a;

            c(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                ProgressBar progressBar = BottomDownloadingView.this.e;
                if (progressBar != null) {
                    progressBar.setProgress(this.a);
                }
                BottomDownloadingView.this.c.a(this.a);
            }
        }

        a() {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void a(com.tapsdk.tapad.internal.download.f fVar) {
            File fileH;
            BottomDownloadingView.this.c.onComplete();
            HashMap map = new HashMap();
            BottomDownloadingView.this.e.setProgress(100);
            if (!BottomDownloadingView.this.b.isEmpty()) {
                map.put("timestamp", String.valueOf(System.currentTimeMillis()));
                map.put("inner_browser_action_url", fVar.e());
                map.put("interaction_type", String.valueOf(1));
                map.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.a));
                com.tapsdk.tapad.internal.tracker.c.a().a(BottomDownloadingView.this.b, map);
            }
            if (fVar == null || (fileH = fVar.h()) == null || !fileH.exists()) {
                return;
            }
            try {
                if (BottomDownloadingView.this.j.b.endsWith(com.anythink.dlopt.common.a.a.h)) {
                    if (!BottomDownloadingView.this.b.isEmpty()) {
                        map.put(com.anythink.core.common.e.a.C0080a.b, String.valueOf(Constants.t.b));
                        com.tapsdk.tapad.internal.tracker.c.a().a(BottomDownloadingView.this.b, map);
                        com.tapsdk.tapad.internal.utils.f.b(BottomDownloadingView.this.getContext(), fileH).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0639a(map));
                    }
                    new com.tapsdk.tapad.internal.n.c(com.tapsdk.tapad.internal.utils.a.a(BottomDownloadingView.this.getContext()), fileH, null).a(new b(fileH, map));
                    return;
                }
                Uri uriForFile = FileProvider.getUriForFile(BottomDownloadingView.this.getContext(), BottomDownloadingView.this.getContext().getPackageName() + ".com.tds.ad.fileprovider", fileH);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, "resource/folder");
                BottomDownloadingView.this.getContext().startActivity(intent);
            } catch (Throwable unused) {
            }
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.a < 500) {
                return;
            }
            this.a = jCurrentTimeMillis;
            BottomDownloadingView.this.e.post(new c(i));
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void a(com.tapsdk.tapad.internal.download.f fVar, Exception exc) {
            BottomDownloadingView.this.setVisibility(8);
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void b(com.tapsdk.tapad.internal.download.f fVar) {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.f
        public void c(com.tapsdk.tapad.internal.download.f fVar) {
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a();
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ d a;

        c(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tapsdk.tapad.internal.download.f fVar = BottomDownloadingView.this.a;
            if (fVar != null) {
                if (StatusUtil.b(fVar) != StatusUtil.Status.RUNNING) {
                    BottomDownloadingView.this.b();
                    BottomDownloadingView.this.g.setImageResource(R.drawable.tapad_webview_downloading_icon);
                } else {
                    BottomDownloadingView.this.a.f();
                    BottomDownloadingView.this.g.setImageResource(R.drawable.tapad_webview_downloading_pause_icon);
                    this.a.b();
                }
            }
        }
    }

    public interface d {
        void a();

        void a(int i);

        void b();

        void onComplete();
    }

    public BottomDownloadingView(Context context) {
        super(context);
        this.a = null;
        this.b = new ArrayList();
        this.c = null;
        this.d = new a();
        a();
    }

    public BottomDownloadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = new ArrayList();
        this.c = null;
        this.d = new a();
        a();
    }

    public BottomDownloadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = new ArrayList();
        this.c = null;
        this.d = new a();
        a();
    }

    public BottomDownloadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = null;
        this.b = new ArrayList();
        this.c = null;
        this.d = new a();
        a();
    }

    private void a() {
        this.e = (ProgressBar) LinearLayout.inflate(getContext(), R.layout.tapad_webview_bottom_downloading, this).findViewById(R.id.download_progress);
        this.f = (ImageView) findViewById(R.id.download_close_icon);
        this.h = (TextView) findViewById(R.id.download_file_name_text);
        this.i = (TextView) findViewById(R.id.download_file_size_text);
        this.g = (ImageView) findViewById(R.id.download_state_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.a = e.a(this.j, com.tapsdk.tapad.internal.ui.views.web.c.a(getContext().getApplicationContext()), new com.tapsdk.tapad.internal.ui.views.web.d(this.d));
    }

    public void a(com.tapsdk.tapad.internal.ui.views.web.b bVar, List<String> list, d dVar) {
        this.b = list;
        this.j = bVar;
        this.c = dVar;
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(bVar.b);
        }
        if (this.i != null) {
            this.i.setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((bVar.c / 1024.0d) / 1024.0d)) + "MB");
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setOnClickListener(new b(dVar));
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new c(dVar));
        }
        b();
    }
}
