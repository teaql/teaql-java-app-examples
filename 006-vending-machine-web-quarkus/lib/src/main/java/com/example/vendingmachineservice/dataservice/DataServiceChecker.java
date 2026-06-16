package com.example.vendingmachineservice.dataservice;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class DataServiceChecker implements Checker<DataService>{

    public String type(){
        return DataService.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, DataService dataService, ObjectLocation _parentLocation){
        if(needCheck(_ctx, dataService)){
            markAsChecked(_ctx, dataService);
            doCheck(_ctx, dataService, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, DataService dataService, ObjectLocation _parentLocation){
      if((dataService == null)){
         return;
      }
      if(dataService.newItem()){
      }else if(dataService.updateItem()){
      }
      checkName(_ctx, dataService.getProperty(DataService.NAME_PROPERTY), newLocation(_parentLocation, DataService.NAME_PROPERTY));
      checkJdbcInfo(_ctx, dataService.getProperty(DataService.JDBC_INFO_PROPERTY), newLocation(_parentLocation, DataService.JDBC_INFO_PROPERTY));
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkJdbcInfo(UserContext _ctx, String jdbcInfo, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, jdbcInfo);
    if((jdbcInfo == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, jdbcInfo);

    }
}