

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class OfflineDataBaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DATABASE_NAME";


    public OfflineDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(OfflineNote.CREATE_HOUSE_HOLD_DETAILS_TABLE);
        sqLiteDatabase.execSQL(OfflineNote.CREATE_TABLE_HOUSE_HOLD_SURVEY);
        

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + OfflineNote.TABLE_NAME_HOUSE_HOLD_DETAILS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + OfflineNote.TABLE_NAME_HOUSE_HOLD_SURVEY);
       


        // Create tables again
        onCreate(sqLiteDatabase);
    }





    /*String HABITATION_ID, String HABITATION_NAME, String BENEF_ID_CODE,
     String FAMILY_ID, String FAMILY_HEAD, String FATHER_NAME*/
    public Boolean insertFamilyHeadData(ArrayList<HHFormFamilyHeadListItem> hhFormFamilyHeadListItem,String village_id) {

        long id = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        for (HHFormFamilyHeadListItem hh : hhFormFamilyHeadListItem) {

            ContentValues values = new ContentValues();

            values.put(OfflineNote.HABITATION_ID, hh.getHabitationdid());
            values.put(OfflineNote.HABITATION_NAME, hh.getHabitationname());
            values.put(OfflineNote.BENEF_ID_CODE, hh.getBenefidcode());
            values.put(OfflineNote.FAMILY_ID, hh.getFamilyid());
            values.put(OfflineNote.FAMILY_HEAD, hh.getFamilyhead());
            values.put(OfflineNote.FATHER_NAME, hh.getFathername());
            values.put(OfflineNote.VILLAGE_ID,village_id);

            // insert row
            id = db.insert(OfflineNote.TABLE_NAME_HOUSE_HOLD_DETAILS, null, values);

        }

        // close db connection
        db.close();

        // return newly inserted row id
        return id > 0;
    }


    public ArrayList<HHFormFamilyHeadListItem> getFamilyHeadRecords(String village_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(OfflineNote.TABLE_NAME_HOUSE_HOLD_DETAILS, null, OfflineNote.VILLAGE_ID+"=?", new String[]{village_id}, null, null, null);

        ArrayList<HHFormFamilyHeadListItem> familyHeadListItems = new ArrayList<>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                HHFormFamilyHeadListItem headListItem = new HHFormFamilyHeadListItem();
                headListItem.setHabitationdid(cursor.getString(2));
                headListItem.setHabitationname(cursor.getString(3));
                headListItem.setBenefidcode(cursor.getString(4));
                headListItem.setFamilyid(cursor.getString(5));
               
				
                familyHeadListItems.add(headListItem);
            }
        }
        cursor.close();
        db.close();
        return familyHeadListItems;
    }

  

   



    public Boolean saveHouseHoldSurvey(String userid, String habit_id, String benefidcode, String familyhead_id,
                                       String familyhead_name, String fathername,
                                       String lat, String longg, String formID, String availablity_of_toilet,
                                       String use_of_toilet, String child_feaces,
                                       String type_of_toilet, String eff_mang, String dis_type_issue, String super_issue,
                                       String sub_issue, String non_usage, String other_toilet, String other_eff_mag, String other_non_usage,
                                       String other_super_issue, String other_sub_issue, String household_image) {

        long id = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(OfflineNote.USER_ID, userid);
        values.put(OfflineNote.FORM_ID, formID);
        values.put(OfflineNote.habitation_id, habit_id);
        values.put(OfflineNote.benefidcode, benefidcode);
        values.put(OfflineNote.familyhead_id, familyhead_id);
        values.put(OfflineNote.familyhead_name, familyhead_name);
        values.put(OfflineNote.fathername, fathername);
        values.put(OfflineNote.availablity_of_toilet, availablity_of_toilet);
        values.put(OfflineNote.use_of_toilet, use_of_toilet);
       

        id = db.insert(OfflineNote.TABLE_NAME_HOUSE_HOLD_SURVEY, null, values);
        // close db connection
        db.close();

        // return newly inserted row id
        return id > 0;
    }
  


    public int getFamilyHeadId(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(OfflineNote.TABLE_NAME_HOUSE_HOLD_SURVEY,null,OfflineNote.familyhead_id+"=?",new String[]{id},null,null,null,null);
        return cursor.getCount();
    }

 



     public ArrayList<HouseHoldSurveyDataSync> getHouseHoldSurveyRecords(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(OfflineNote.TABLE_NAME_HOUSE_HOLD_SURVEY,null,null,null,null,null,null);
        ArrayList<HouseHoldSurveyDataSync> houseHoldSurveyList=new ArrayList<>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                HouseHoldSurveyDataSync houseHoldSurveyDataSync=new HouseHoldSurveyDataSync();
                houseHoldSurveyDataSync.setId (Integer.parseInt((cursor.getString(0))));
                houseHoldSurveyDataSync.setUserid(cursor.getString(2));
                houseHoldSurveyDataSync.setFormID(cursor.getString(3));
                houseHoldSurveyDataSync.setHabit_id(cursor.getString(4));
                houseHoldSurveyDataSync.setBenefidcode(cursor.getString(5));
               

                houseHoldSurveyList.add(houseHoldSurveyDataSync);


            }
        }
        cursor.close();
        db.close();
        return houseHoldSurveyList;

    }

	
	

}
