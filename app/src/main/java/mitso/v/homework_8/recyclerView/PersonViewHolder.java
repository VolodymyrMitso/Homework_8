package mitso.v.homework_8.recyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mitso.v.homework_8.Constants;
import mitso.v.homework_8.InfoActivity;
import mitso.v.homework_8.MainActivity;
import mitso.v.homework_8.R;
import mitso.v.homework_8.models.Person;

public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public CardView mCardView_Card;
    public TextView mTextView_FirstName;
    private Context context;

    public PersonViewHolder(Context context, View itemView){
        super(itemView);
        this.context = context;

        mCardView_Card = (CardView) itemView.findViewById(R.id.cv_Card_PC);

        mTextView_FirstName = (TextView)itemView.findViewById(R.id.tv_FirstName_AC);
        mTextView_FirstName.setOnClickListener(this);

        Button mButton_Delete = (Button)itemView.findViewById(R.id.btn_Delete_PC);
        mButton_Delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.tv_FirstName_AC:
                showPersonInfo();
                break;
            case R.id.btn_Delete_PC:
                deletePerson();
                break;
        }
    }

    private void showPersonInfo() {
        Activity mainActivity = (Activity) context;
        Intent intent = new Intent(mainActivity, InfoActivity.class);
        int position = getAdapterPosition();
        Person person = MainActivity.personAdapter.getPerson(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.BUNDLE_PERSON_INFO, person);
        intent.putExtras(bundle);
        mainActivity.startActivity(intent);
    }

    private void deletePerson() {
        int position = getAdapterPosition();
        MainActivity.personAdapter.deletePerson(position);
        MainActivity.personAdapter.notifyItemRemoved(position);
    }
}