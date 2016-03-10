package mitso.v.homework_8;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class CreateSupport {

    public static boolean emptyFieldsCheck(Context context, EditText firstName, EditText phoneNumber) {
        if (firstName.getText().toString().isEmpty() || phoneNumber.getText().toString().isEmpty()) {
            Toast.makeText(context, R.string.s_warning_emptyFields, Toast.LENGTH_LONG).show();
            return false;
        } else
            return true;
    }

    public static boolean genderCheck(Context context, EditText gender) {
        String genderString = gender.getText().toString();
        if (!genderString.isEmpty()) {
            if (genderString.toLowerCase().equals("m") || genderString.toLowerCase().equals("f")) {
                return true;
            } else {
                Toast.makeText(context, R.string.s_warning_gender, Toast.LENGTH_LONG).show();
                return false;
            }
        } else
            return true;
    }

    public static boolean ageCheck(Context context, EditText age) {
        String ageString = age.getText().toString();
        if (!ageString.isEmpty()) {
            if (ageString.matches("[0-9]+")) {
                int ageInt = Integer.parseInt(ageString);
                if (ageInt < 21 || ageInt > 65) {
                    Toast.makeText(context, R.string.s_warning_ageQuantity, Toast.LENGTH_LONG).show();
                    return false;
                } else
                    return true;
            } else {
                Toast.makeText(context, R.string.s_warning_ageInput, Toast.LENGTH_LONG).show();
                return false;
            }
        } else
            return true;
    }

    public static boolean phoneNumberCheck(Context context, EditText phoneNumber) {
        String phoneNumberString = phoneNumber.getText().toString();
        if (phoneNumberString.matches("(\\+)(\\d{12})") || phoneNumberString.matches("\\d{3}")) {
            return true;
        } else {
            Toast.makeText(context, R.string.s_warning_phoneNumber, Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
