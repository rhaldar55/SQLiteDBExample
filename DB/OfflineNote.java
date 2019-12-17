package dkd.odfs.rh.odfjhr.DB;

import android.util.Log;

public class OfflineNote {

    public static final String TABLE_NAME_HOUSE_HOLD_DETAILS = "household_details";
    public static final String TABLE_NAME_HOUSE_HOLD_SURVEY = "household_survey";
    



    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public static final String USER_ID = "USER_ID";
    public static final String FORM_ID = "FORM_ID";
    public static final String lat = "lat";
    public static final String lng = "lng";
    public static final String INST_STATE = "INST_STATE";
    public static final String INST_DISTRICT = "INST_DISTRICT";
    public static final String INST_BLOCK = "INST_BLOCK";
    public static final String INST_PANCHAYAT = "INST_PANCHAYAT";
    public static final String INST_VILLAGE = "INST_PANCHAYAT";

    //Household Details
    public static final String HABITATION_ID = "HABITATION_ID";
    public static final String HABITATION_NAME = "HABITATION_NAME";
    public static final String BENEF_ID_CODE = "BENEF_ID_CODE";
    public static final String FAMILY_ID = "FAMILY_ID";
    public static final String FAMILY_HEAD = "FAMILY_HEAD";
    public static final String FATHER_NAME = "FATHER_NAME";
    public static final String VILLAGE_ID = "VILLAGE_ID";

    //HouseHold Survey
    public static final String habitation_id = "habitation_id";
    public static final String benefidcode = "benefidcode";
    public static final String familyhead_id = "familyhead_id";
    public static final String familyhead_name = "familyhead_name";
    public static final String fathername = "fathername";
    public static final String availablity_of_toilet = "availablity_of_toilet";
    public static final String use_of_toilet = "use_of_toilet";
    public static final String child_feaces = "child_feaces";
    public static final String type_of_toilet = "type_of_toilet";
    public static final String eff_mang = "eff_mang";
    public static final String dis_type_issue = "dis_type_issue";
    public static final String super_issue = "super_issue";
    public static final String sub_issue = "sub_issue";
    public static final String household_image = "household_image";
    public static final String non_usage = "non_usage";
    public static final String other_toilet = "other_toilet";
    public static final String other_eff_mag = "other_eff_mag";
    public static final String other_non_usage = "other_non_usage";
    public static final String other_super_issue = "other_super_issue";
    public static final String other_sub_issue = "other_sub_issue";


  





    private int id;
    private String note;
    private String timestamp;

    // HouseHold Details Create table SQL query
    public static final String CREATE_HOUSE_HOLD_DETAILS_TABLE =
            "CREATE TABLE " + TABLE_NAME_HOUSE_HOLD_DETAILS + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + HABITATION_ID + " TEXT,"
                    + HABITATION_NAME + " TEXT,"
                    + BENEF_ID_CODE + " TEXT,"
                    + FAMILY_ID + " TEXT,"
                    + FAMILY_HEAD + " TEXT,"
                    + FATHER_NAME + " TEXT,"
                    + VILLAGE_ID + " TEXT"
                    + ")";





    //creating household survey table sql query
    public static final String CREATE_TABLE_HOUSE_HOLD_SURVEY =
            "CREATE TABLE " + TABLE_NAME_HOUSE_HOLD_SURVEY + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
                    + USER_ID + " TEXT, "
                    + FORM_ID + " TEXT, "
                    + habitation_id + " TEXT, "
                    + benefidcode + " TEXT, "
                    + familyhead_id + " TEXT, "
                    + familyhead_name + " TEXT, "
                    + fathername + " TEXT, "
                
                    + ")";




    // End of CREATE QUERY FOR VERIFIER AKA To manage Old Data

    public OfflineNote() {
    }

    public OfflineNote(int id, String note, String timestamp) {
        this.id = id;
        this.note = note;
        this.timestamp = timestamp;
    }
}
