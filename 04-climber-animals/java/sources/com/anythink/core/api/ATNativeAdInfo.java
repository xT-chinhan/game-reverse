package com.anythink.core.api;

import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ATNativeAdInfo {

    public interface AdController {
        void pauseVideo();

        void resumeVideo();

        void setVideoMute(boolean z);
    }

    AdController getAdController();

    IATThirdPartyMaterial getAdMaterial();

    void prepare(AdPrepareInfo adPrepareInfo);

    public static class AdPrepareInfo {
        private View adFromView;
        private View adLogoView;
        private List<View> appInfoClickViewList;
        FrameLayout.LayoutParams choiceViewLayoutParams;
        private final List<View> clickViewList = new ArrayList();
        private View closeView;
        private List<View> creativeClickViewList;
        private View ctaView;
        private View descView;
        private View domainView;
        private View iconView;
        private View mainImageView;
        private View parentView;
        private List<View> permissionClickViewList;
        private List<View> privacyClickViewList;
        private View titleView;
        private View warningView;

        public View getParentView() {
            return this.parentView;
        }

        public void setParentView(View view) {
            this.parentView = view;
        }

        public View getTitleView() {
            return this.titleView;
        }

        public void setTitleView(View view) {
            this.titleView = view;
            addClickView(view);
        }

        public View getIconView() {
            return this.iconView;
        }

        public void setIconView(View view) {
            this.iconView = view;
            addClickView(view);
        }

        public View getMainImageView() {
            return this.mainImageView;
        }

        public void setMainImageView(View view) {
            this.mainImageView = view;
            addClickView(view);
        }

        public View getDescView() {
            return this.descView;
        }

        public void setDescView(View view) {
            this.descView = view;
            addClickView(view);
        }

        public View getCtaView() {
            return this.ctaView;
        }

        public void setCtaView(View view) {
            this.ctaView = view;
            addClickView(view);
        }

        public View getCloseView() {
            return this.closeView;
        }

        public void setCloseView(View view) {
            this.closeView = view;
        }

        public View getAdFromView() {
            return this.adFromView;
        }

        public void setAdFromView(View view) {
            this.adFromView = view;
        }

        public View getAdLogoView() {
            return this.adLogoView;
        }

        public void setAdLogoView(View view) {
            this.adLogoView = view;
        }

        public View getDomainView() {
            return this.domainView;
        }

        public void setDomainView(View view) {
            this.domainView = view;
        }

        public View getWarningView() {
            return this.warningView;
        }

        public void setWarningView(View view) {
            this.warningView = view;
        }

        public List<View> getClickViewList() {
            return this.clickViewList;
        }

        public void setClickViewList(List<View> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                addClickView(it.next());
            }
        }

        public List<View> getCreativeClickViewList() {
            filterCloseView(this.creativeClickViewList);
            return this.creativeClickViewList;
        }

        public void setCreativeClickViewList(List<View> list) {
            this.creativeClickViewList = list;
        }

        public List<View> getPrivacyClickViewList() {
            filterCloseView(this.privacyClickViewList);
            return this.privacyClickViewList;
        }

        public void setPrivacyClickViewList(List<View> list) {
            this.privacyClickViewList = list;
        }

        public List<View> getPermissionClickViewList() {
            filterCloseView(this.permissionClickViewList);
            return this.permissionClickViewList;
        }

        public void setPermissionClickViewList(List<View> list) {
            this.permissionClickViewList = list;
        }

        public List<View> getAppInfoClickViewList() {
            filterCloseView(this.appInfoClickViewList);
            return this.appInfoClickViewList;
        }

        public void setAppInfoClickViewList(List<View> list) {
            this.appInfoClickViewList = list;
        }

        public FrameLayout.LayoutParams getChoiceViewLayoutParams() {
            return this.choiceViewLayoutParams;
        }

        public void setChoiceViewLayoutParams(FrameLayout.LayoutParams layoutParams) {
            this.choiceViewLayoutParams = layoutParams;
        }

        private synchronized void filterCloseView(List<View> list) {
            View view;
            if (list != null) {
                if (list.size() > 0 && (view = this.closeView) != null) {
                    list.remove(view);
                }
            }
        }

        private synchronized void addClickView(View view) {
            if (view == null) {
                return;
            }
            if (!this.clickViewList.contains(view)) {
                View view2 = this.closeView;
                if (view2 != null && view2 == view) {
                } else {
                    this.clickViewList.add(view);
                }
            }
        }
    }
}
