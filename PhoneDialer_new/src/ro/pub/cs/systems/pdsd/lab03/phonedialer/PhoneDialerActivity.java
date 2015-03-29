package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private final int[] ImageButtonIds =
		{
			R.id.imageButton1,
			R.id.imageButton2,
			R.id.imageButton3
		};
	
	private final int[] ButtonIds =
		{
			R.id.button1,
			R.id.button2,
			R.id.button3,
			R.id.button4,
			R.id.button5,
			R.id.button6,
			R.id.button7,
			R.id.button8,
			R.id.button9,
			R.id.button10,
			R.id.button11,
			R.id.button12
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_phone_dialer);
		for(int i = 0; i < ImageButtonIds.length; i++)
		{
			ImageButton im = (ImageButton)findViewById(ImageButtonIds[i]);
			im.setOnClickListener(buttonClickListener);
		}
		
		for(int i = 0; i < ButtonIds.length; i++)
		{
			Button b = (Button)findViewById(ButtonIds[i]);
			b.setOnClickListener(buttonClickListener);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	
	private class ButtonClickListener implements Button.OnClickListener {

		@Override
		@SuppressWarnings("all")
		public void onClick(View view) {
			EditText ed = (EditText) findViewById(R.id.editText1);
			
			if(view  instanceof ImageButton) {
				if(((ImageButton)view).getId() == R.id.imageButton1)
				{
					//backspace
					if(ed.getText().length() > 0)
					{
						ed.setText(ed.getText().subSequence(0,ed.getText().length() -1));
					}
				} 
				
				if(((ImageButton)view).getId() == R.id.imageButton2)
				{
					//call
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:"+ed.getText().toString()));
					startActivity(intent);
				} 
				
				if(((ImageButton)view).getId() == R.id.imageButton3)
				{
					//hangup
					finish();
				} 
				
				
				
			} else if (view instanceof Button)
			{
				CharSequence nr = ((Button)view).getText();
				ed.setText(ed.getText() + nr.toString());
			}
		}		
	}
}
