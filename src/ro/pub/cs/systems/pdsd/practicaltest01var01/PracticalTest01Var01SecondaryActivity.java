package ro.pub.cs.systems.pdsd.practicaltest01var01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var01SecondaryActivity extends Activity {
	EditText etactive;
	Button bok, bcancel;
	
	private class Action implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch(v.getId()){
				case R.id.buttonOk:
					setResult(RESULT_OK, new Intent());
					finish();
					break;
				case R.id.buttonCancel:
					setResult(RESULT_CANCELED, new Intent());
					finish();
					break;
			}
			
		}
		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_secondary);
		etactive = (EditText)findViewById(R.id.editTextActive);
		
		bok = (Button)findViewById(R.id.buttonOk);
		bcancel = (Button)findViewById(R.id.buttonCancel);
		
		Action act = new Action();
		Intent intent = getIntent();
		String s = intent.getStringExtra("activate");
		if(s != null)
			etactive.setText(s);
		
		bok.setOnClickListener(act);
		bcancel.setOnClickListener(act);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var01_secondary, menu);
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
}
