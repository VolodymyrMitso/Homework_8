package mitso.v.homework_8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mitso.v.homework_8.models.Person;

public class CreateActivity extends AppCompatActivity {

    private EditText mEditText_FirstName;
    private EditText mEditText_LastName;
    private EditText mEditText_Gender;
    private EditText mEditText_Age;
    private EditText mEditText_PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

            String actionBarTitle = getResources().getString(R.string.s_actionBarTitle_AC);
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>" + actionBarTitle + "</font>"));
        }

        mEditText_FirstName = (EditText) findViewById(R.id.et_FirstName_AC);
        mEditText_LastName = (EditText) findViewById(R.id.et_LastName_CA);
        mEditText_Gender = (EditText) findViewById(R.id.et_Gender_CA);
        mEditText_Age = (EditText) findViewById(R.id.et_Age_CA);
        mEditText_PhoneNumber = (EditText) findViewById(R.id.et_PhoneNumber_CA);

        Button mButton_Create = (Button) findViewById(R.id.btn_Create_CA);
        mButton_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CreateSupport.emptyFieldsCheck(CreateActivity.this, mEditText_FirstName, mEditText_PhoneNumber)) {
                    if (CreateSupport.phoneNumberCheck(CreateActivity.this, mEditText_PhoneNumber))
                        if (CreateSupport.genderCheck(CreateActivity.this, mEditText_Gender))
                            if (CreateSupport.ageCheck(CreateActivity.this, mEditText_Age))

                                sendPerson(createPerson());
                } else {
                    setResult(RESULT_CANCELED);
                }
            }
        });
    }

    private void sendPerson(Person person) {
        Intent intent = new Intent(CreateActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.BUNDLE_PERSON_CREATE, person);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

    private Person createPerson() {
        Person person = new Person();
        String firstNameString = mEditText_FirstName.getText().toString();
        if (!firstNameString.isEmpty())
            firstNameString = firstNameString.substring(0, 1).toUpperCase() + firstNameString.substring(1);
        person.setFirstName(firstNameString);
        String lastNameString = mEditText_LastName.getText().toString();
        if (!lastNameString.isEmpty())
            lastNameString = lastNameString.substring(0, 1).toUpperCase() + lastNameString.substring(1);
        person.setLastName(lastNameString);
        person.setGender(mEditText_Gender.getText().toString().toUpperCase());
        person.setAge(mEditText_Age.getText().toString());
        person.setPhoneNumber(mEditText_PhoneNumber.getText().toString());
        return person;
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