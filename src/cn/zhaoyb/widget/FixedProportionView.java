package cn.zhaoyb.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/** 
 * 
 * 固定比例的自定试图
 * 可动态修改调用
 * 
 * @author zhaoyb (http://www.zhaoyb.cn)
 *
 */
public class FixedProportionView extends LinearLayout {

	/** 宽高比例,,默认不处理*/
	private int proportionW;
	private int proportionH;
	/** 最终真实的宽度*/
	private int realWidth = -1;
	
	public FixedProportionView(Context context) {
		super(context);
	}

	public FixedProportionView(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FixedProportionView);
		proportionW = a.getInteger(R.styleable.FixedProportionView_proportionW, 0);
		proportionH = a.getInteger(R.styleable.FixedProportionView_proportionH, 0);
		a.recycle();
	}

	/** 更新宽高比例,并导致重新布局*/
	public void updateProportion(int proportionW, int proportionH) {
		this.proportionW = proportionW;
		this.proportionH = proportionH;
		requestLayout();
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (proportionW <=0 || proportionH <= 0 || getParent() == null) {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			return;
		}
		// 获取父容器的宽
		int measuredWidth = ((View) getParent()).getWidth();
		if (measuredWidth > 0 && measuredWidth < 3000) {
			realWidth = measuredWidth;
		}
		if (realWidth != -1) {
			setMeasuredDimension(realWidth, realWidth * proportionH / proportionW);
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
	}
}