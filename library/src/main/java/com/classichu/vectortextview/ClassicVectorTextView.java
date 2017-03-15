package com.classichu.vectortextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by louisgeek on 2017/3/15.
 */

public class ClassicVectorTextView extends AppCompatTextView {
    private Context mContext;
    public ClassicVectorTextView(Context context) {
        this(context,null);
    }

    public ClassicVectorTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ClassicVectorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        //
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.ClassicVectorTextView);
        initAttrs(typedArray);
        typedArray.recycle();


    }

    private void initAttrs( TypedArray typedArray) {
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int index=typedArray.getIndex(i);
           if (index==R.styleable.ClassicVectorTextView_classic_tint){
               setColorFilterLikeImage(typedArray.getColor(index, Color.WHITE));
           }
        }
    }

    private void setBgColorFilterLikeImage(int color) {
        Drawable drawable=this.getBackground();
        Drawable drawableNew;
        if (drawable!=null){
            //  DrawableCompat.setTint(drawable,color);
            drawableNew= drawable.mutate();
            drawableNew.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }


    public void setColorFilterLikeImage(int color) {
        Drawable drawableLeft=this.getCompoundDrawables()[0];
        Drawable drawableTop=this.getCompoundDrawables()[1];
        Drawable drawableRight=this.getCompoundDrawables()[2];
        Drawable drawableBottom=this.getCompoundDrawables()[3];
        Drawable drawableLeftNew = null;
        Drawable drawableTopNew = null;
        Drawable drawableRightNew = null;
        Drawable drawableBottomNew = null;
        if (drawableLeft!=null){
            // DrawableCompat.setTint(drawable,xxColor);
            //##会有缓存 drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP);
            //##无效  Drawable drawableNew = cloneNewDrawable(drawable);
             drawableLeftNew = drawableLeft.mutate();//使这个drawable不相互共享状态
            drawableLeftNew.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
        if (drawableTop!=null){
             drawableTopNew = drawableTop.mutate();
            drawableTopNew.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
        if (drawableRight!=null){
             drawableRightNew = drawableRight.mutate();
            drawableRightNew.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
        if (drawableBottom!=null){
             drawableBottomNew = drawableBottom.mutate();
            drawableBottomNew.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
        this.setCompoundDrawables(drawableLeftNew,drawableTopNew,drawableRightNew,drawableBottomNew);
        //
        setBgColorFilterLikeImage(color);
    }

    /**
     * drawable 复制
     * @param drawable
     * @return
     */
    @Deprecated
    private  Drawable cloneNewDrawable(Drawable drawable) {
        if (drawable!=null&&drawable.getConstantState()!=null){
            return drawable.getConstantState().newDrawable().mutate();
            // return drawable.getConstantState().newDrawable();
        }
       return drawable;
    }
}
