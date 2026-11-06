package com.efs.sdk.base.protocol.file.section;

import com.tapsdk.tapad.internal.runtime.view.TextViewManager;

/* JADX INFO: loaded from: classes2.dex */
public class TextSection extends AbsSection {
    private String body;

    public TextSection(String str) {
        super(TextViewManager.NAME);
        this.name = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        return getDeclarationLine() + "\n" + this.body + "\n";
    }
}
