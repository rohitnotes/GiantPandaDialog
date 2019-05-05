package com.nasduck.dialoglib.dialog.builder;

import android.content.Context;
import android.view.View;

import com.nasduck.dialoglib.dialog.config.BodyConfig;
import com.nasduck.dialoglib.dialog.view.DialogBody;

public class DialogBodyBuilder implements IBuilder {

    private BodyConfig config;

    private DialogBodyBuilder(BodyConfig config) {
        this.config = config;
    }

    public static DialogBodyBuilder getInstance() {
        return create(BodyConfig.newInstance());
    }

    public static DialogBodyBuilder create(BodyConfig config) {
        return new DialogBodyBuilder(config);
    }

    @Override
    public View getView(Context context) {
        return DialogBody.create(context, config);
    }

    public DialogBodyBuilder setContent(String content) {
        this.config.setContent(content);
        return this;
    }

    public DialogBodyBuilder setContentColor(int contentColor) {
        this.config.setContentTextColor(contentColor);
        return this;
    }

    public DialogBodyBuilder setContentSize(int contentSize) {
        this.config.setContentTextSize(contentSize);
        return this;
    }

    public DialogBodyBuilder setGravity(int gravity) {
        this.config.setGravity(gravity);
        return this;
    }

    public DialogBodyBuilder setLayoutGravity(int gravity) {
        this.config.setLayoutGravity(gravity);
        return this;
    }

    public DialogBodyBuilder setPaddingTop(int paddingTop) {
        this.config.setPaddingTop(paddingTop);
        return this;
    }

    public DialogBodyBuilder setPaddingBottom(int paddingBottom) {
        this.config.setPaddingBottom(paddingBottom);
        return this;
    }

    public DialogBodyBuilder setPaddingLeft(int paddingLeft) {
        this.config.setPaddingLeft(paddingLeft);
        return this;
    }

    public DialogBodyBuilder setPaddingRight(int paddingRight) {
        this.config.setPaddingRight(paddingRight);
        return this;
    }

    public DialogBodyBuilder setBgColor(int color) {
        this.config.setBgColor(color);
        return this;
    }

}