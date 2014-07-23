package com.harreke.utils.widgets;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.EditText;

import com.harreke.utils.tools.FileUtil;
import com.harreke.utils.tools.Regular;

import java.util.regex.Matcher;

public class EmotionEditText extends EditText {
    private String mCacheDir;
    private int mEmotionSize;

    public EmotionEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mCacheDir = context.getCacheDir().getAbsolutePath() + "/Emotion";
        mEmotionSize = (int) (context.getResources().getDisplayMetrics().density * 48f);
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        ClipboardManager manager;
        SpannableStringBuilder builder;
        Matcher matcher;
        CharSequence emotionUBB;
        String[] emotion;
        int start;

        manager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        if (id == android.R.id.paste && manager.getPrimaryClip() != null && manager.getPrimaryClip().getItemCount() > 0) {
            builder = new SpannableStringBuilder(getText());
            emotionUBB = manager.getPrimaryClip().getItemAt(0).getText();
            if (emotionUBB != null && emotionUBB.length() > 0) {
                matcher = Regular.getMatcher("\\[emot=([\\S\\s]+?)/\\]", emotionUBB);
                while (matcher.find()) {
                    emotion = matcher.group(1).split(",");
                    builder.setSpan(new ImageSpan(FileUtil.readDrawable(mCacheDir + "/" + emotion[0] + "/" + emotion[1], mEmotionSize, mEmotionSize)),
                            matcher.start(0), matcher.end(0), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                start = getSelectionStart();
                builder.insert(start, emotionUBB);

                setText(builder);
                setSelection(start + emotionUBB.length());

                return true;
            }
        }

        return super.onTextContextMenuItem(id);
    }
}