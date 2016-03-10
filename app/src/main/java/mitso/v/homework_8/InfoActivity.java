package mitso.v.homework_8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import mitso.v.homework_8.models.Person;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

            String actionBarTitle = getResources().getString(R.string.s_actionBarTitle_AI);
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>" + actionBarTitle + "</font>"));
        }

        TextView mTextView_FirstName = (TextView) findViewById(R.id.tv_FirstName_AI);
        TextView mTextView_LastName = (TextView) findViewById(R.id.tv_LastName_AI);
        TextView mTextView_Gender = (TextView) findViewById(R.id.tv_Gender_AI);
        TextView mTextView_Age = (TextView) findViewById(R.id.tv_Age_AI);
        TextView mTextView_PhoneNumber = (TextView) findViewById(R.id.tv_PhoneNumber_AI);

        Bundle bundle = getIntent().getExtras();
        Person person = (Person) bundle.getSerializable(Constants.BUNDLE_PERSON_INFO);

        mTextView_FirstName.setText(person.getFirstName());
        mTextView_LastName.setText(person.getLastName());
        mTextView_Gender.setText(person.getGender());
        mTextView_Age.setText(person.getAge());
        mTextView_PhoneNumber.setText(person.getPhoneNumber());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
