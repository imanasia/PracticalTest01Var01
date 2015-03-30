package ro.pub.cs.systems.pdsd.practicaltest01var01;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends Activity {
	CheckBox cbphone, cbemail, cbmesaj;
	Button bnavigate;
	EditText etcount;
	
	private class Action implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			int nr = Integer.parseInt(etcount.getText().toString());
			
			switch(v.getId()){
				case R.id.checkBoxPhone:
					if(cbphone.isChecked())
					{
						nr++;
						etcount.setText(String.valueOf(nr));
					}
					else if(nr>0)
					{
						nr--;
						etcount.setText(String.valueOf(nr));
					}
						
					break;
				case R.id.checkBoxEmail:
					if(cbemail.isChecked())
					{
						nr++;
						etcount.setText(String.valueOf(nr));
					}
					else if(nr>0)
					{
						nr--;
						etcount.setText(String.valueOf(nr));
					}
					break;
				case R.id.checkBoxMessage:
					if(cbmesaj.isChecked())
					{
						nr++;
						etcount.setText(String.valueOf(nr));
					}
					else if(nr>0)
					{
						nr--;
						etcount.setText(String.valueOf(nr));
					}
					
					break;
					
				case R.id.buttonNavigate:
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var01SecondaryActivity");
					String s="ceva";
					if(cbphone.isChecked())
						s+=cbphone.getText().toString();
					if(cbemail.isChecked())
						s+=cbemail.getText().toString();
					if(cbmesaj.isChecked())
						s+=cbmesaj.getText().toString();
					
					intent.putExtra("activate",s);
					startActivityForResult(intent, 2015);
					break;
			}
			
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_main);
		
		cbphone = (CheckBox)findViewById(R.id.checkBoxPhone);
		cbemail = (CheckBox)findViewById(R.id.checkBoxEmail);
		cbmesaj = (CheckBox)findViewById(R.id.checkBoxMessage);
		etcount = (EditText)findViewById(R.id.editTextCount);
		bnavigate = (Button)findViewById(R.id.buttonNavigate);
		Action actiune = new Action();
		
		cbphone.setOnClickListener(actiune);
		cbemail.setOnClickListener(actiune);
		cbmesaj.setOnClickListener(actiune);
		bnavigate.setOnClickListener(actiune);
		if(savedInstanceState != null)
		{
			String st = savedInstanceState.getString("count");
			if(st != null)
				etcount.setText(st);
			String p = savedInstanceState.getString("phone");
			String e = savedInstanceState.getString("email");
			String m = savedInstanceState.getString("mesaj");
			if(p != null)
				cbphone.setChecked(true);
			if(e != null)
				cbemail.setChecked(true);
			if(m != null)
				cbmesaj.setChecked(true);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var01_main, menu);
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
	
	@Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    EditText etcount = (EditText)findViewById(R.id.editTextCount);
	    cbphone = (CheckBox)findViewById(R.id.checkBoxPhone);
		cbemail = (CheckBox)findViewById(R.id.checkBoxEmail);
		cbmesaj = (CheckBox)findViewById(R.id.checkBoxMessage);
		
	    savedInstanceState.putString("count",etcount.getText().toString());
	    if(cbphone.isChecked())
	    	savedInstanceState.putString("phone",cbphone.getText().toString());
	    if(cbemail.isChecked())
	    	savedInstanceState.putString("email",cbemail.getText().toString());
	    if(cbmesaj.isChecked())
	    	savedInstanceState.putString("mesaj",cbmesaj.getText().toString());
	   
	  }
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode+" "+requestCode, Toast.LENGTH_LONG).show();
	  }
}
