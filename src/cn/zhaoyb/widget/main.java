package cn.zhaoyb.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class main extends Activity {

	private FixedProportionView mFixedProportionView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mFixedProportionView = (FixedProportionView) findViewById(R.id.test_proportion_view);
	}

	public void toUpdate(View v) {
		mFixedProportionView.updateProportion((int) (Math.random() * 3 + 1),
				(int) (Math.random() * 3 + 1));
	}
}
