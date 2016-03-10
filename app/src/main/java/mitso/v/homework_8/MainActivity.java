package mitso.v.homework_8;

/**    У мене різні дії з RecyclerView в різних класах.
 *     Треба було 2 інтерфейса, щоб описати всі дії.
 *     Я реалізував один просто для прикладу.
 *     MainActivity implements RecyclerViewActions.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import mitso.v.homework_8.models.Person;
import mitso.v.homework_8.recyclerView.PersonAdapter;

public class MainActivity extends AppCompatActivity implements RecyclerViewActions {

    public static PersonAdapter personAdapter;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_RecyclerView_AM);
        personAdapter = new PersonAdapter(this, getPersons());
        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      }

    private ArrayList<Person> getPersons() {
        return new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivityForResult(intent, Constants.REQUEST_ACTIVITY_CREATE);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == Constants.REQUEST_ACTIVITY_CREATE) {
            Bundle bundle = data.getExtras();
            Person person = (Person) bundle.getSerializable(Constants.BUNDLE_PERSON_CREATE);
            addPerson(person);
        }
    }

    @Override
    public void addPerson(Person person) {
        personAdapter.addPerson(person);
        personAdapter.notifyItemInserted(personAdapter.getAllPersons().size() - 1);
    }
}