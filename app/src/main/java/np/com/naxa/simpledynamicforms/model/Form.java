package np.com.naxa.simpledynamicforms.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.io.Serializable;
import java.util.ArrayList;

import np.com.naxa.simpledynamicforms.savedform.QuestionAnswer;
import np.com.naxa.simpledynamicforms.uitils.TimeUtils;

/**
 * Created by Nishon Tandukar on 19 Jun 2017 .
 *
 * @email nishon.tan@gmail.com
 */

@Table
public class Form extends SugarRecord implements Serializable {


    private String formName;
    private String filledDateTime;
    private String formJson;

    public Form() {
    }

    public Form(String formName, String formJson) {
        this.formName = formName;
        this.formJson = formJson;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFilledDateTime() {
        return filledDateTime;
    }

    public void setFilledDateTime(String filledDateTime) {
        this.filledDateTime = filledDateTime;
    }

    public String getFormJson() {
        return formJson;
    }

    public void setFormJson(String formJson) {
        this.formJson = formJson;
    }

    private static int lastContactId = 0;

    public static ArrayList<Form> createFormlist(int numContacts) {
        ArrayList<Form> contacts = new ArrayList<Form>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Form("Form " + ++lastContactId, "a"));
        }

        return contacts;
    }




    public static Form getInstance(String formName, String jsonToSend) {
        Form form = new Form();
        String currentDateTime = TimeUtils.getNowString();
        form.setFilledDateTime(currentDateTime);
        form.setFormName(formName);
        form.setFormJson(jsonToSend);

        return form;
    }
}
