 private void downloadFamilyHead(){

      
        new Thread(new Runnable() {
            @Override
            public void run() {
                int jumpTime = 0;

                if(new OfflineDataBaseHelper(getActivity()).getFamilyHeadRecord()!=0) {

                    OfflineDataBaseHelper hHoldDataBaseHelper = new OfflineDataBaseHelper(getActivity());
                    hHoldDataBaseHelper.deleteHouseHoldDetailRecords();
                    Log.i("TEST", "Delete----->" + hHoldDataBaseHelper.deleteHouseHoldDetailRecords());
                }

                OfflineDataBaseHelper hHoldDataBaseHelper = new OfflineDataBaseHelper(getActivity());
                added = hHoldDataBaseHelper.insertFamilyHeadData(hhFormFamilyHeadListItem,village_id);
                Log.i("TEST", "************added "+added);
                
            }
        }).start();


    }


	////////////************************************************************************
	
	
	
	
	
    private void getFamilyHead(){
       
        hhFormFamilyHeadListItem=dataBaseHelper.getFamilyHeadRecords(CommonMethod.getVillageID(getActivity()));
      
        if (hhFormFamilyHeadListItem.size() != 0) {
           


    }
	
	
	////////****************************************
	
	
            boolean added =  dataBaseHelper.saveHouseHoldSurvey(CommonMethod.getUserId(getActivity()),habitation_id,benefidcode,familyhead_id,familyHeadName,father_name,latvalue,longValue,formId.getText().toString(),availability_of_toilet,use_of_toilet,
                    child_feaces,type_of_toilet,eff_management,dysfunctional_type_issue,super_issue,sub_issue,reg_for_non_use,
                    otherSpecifyOptionType.getText().toString(),otherSpecifyOptionEffluent.getText().toString(),
                    otherSpecifyOptionNonUsage.getText().toString(),otherSpecifyOptionSuperIssue.getText().toString(),otherSpecifyOptionSubIssue.getText().toString(),imageurl_hh);

            Log.i("TEST", "************saveHouseHoldSurvey "+added);

///////////////////**************

 //HouseHold Survey Sync
    private void syncHouseHoldSurveyData(){
      
     new Thread(new Runnable() {
    @Override
    public void run() {
        houseHoldSurveyDataSyncslist=dataBaseHelper.getHouseHoldSurveyRecords();
        Log.i("TEST","Size survey----"+houseHoldSurveyDataSyncslist.size());


      
    }
}).start();

    }