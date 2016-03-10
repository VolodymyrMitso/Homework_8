package mitso.v.homework_8.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mitso.v.homework_8.R;
import mitso.v.homework_8.models.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private ArrayList<Person> persons;
    private Context context;

    public PersonAdapter(Context context, ArrayList<Person> persons) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Person currentPerson = persons.get(i);
        if (currentPerson.atLeastOneEmptyField())
            personViewHolder.mCardView_Card.setCardBackgroundColor(context.getResources().getColor(R.color.c_card_emptyFields));
        personViewHolder.mTextView_FirstName.setText(currentPerson.getFirstName());
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_card, viewGroup, false);
        return new PersonViewHolder(context, itemView);
    }

    @Override
    public int getItemCount(){
        return persons.size();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void deletePerson(int i) {
        persons.remove(i);
    }

    public Person getPerson(int i) {
        return persons.get(i);
    }

    public ArrayList<Person> getAllPersons() {
        return persons;
    }
}
