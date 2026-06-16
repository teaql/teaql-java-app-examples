package com.doublechaintech.vendingmachineservice.dataservice;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class DataServiceExpression<T, E, U extends DataService> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public DataServiceExpression(Expression<T, U> expression){
        super(expression);
    }

    public DataServiceExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public DataServiceExpression<T, U, U> updateId(Long id){
        return new DataServiceExpression(this, $it -> {((DataService)$it).internalSet("id", id); return this;});
     }

     public DataServiceExpression<T, U, U> save(UserContext userContext){
        return new DataServiceExpression(this, $it -> ((DataService)$it).auditAs("Saved by Expression").save(userContext));
     }

     public DataServiceExpression<T, U, U> save(String intent, UserContext userContext){
        return new DataServiceExpression(this, $it -> ((DataService)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(DataService::getName);
    }
    public DataServiceExpression<T, U, U> updateName(String name){
       return new DataServiceExpression(this, $it ->  ((DataService)$it).updateName(name));
    }

    public Expression<T, String> getJdbcInfo(){
       return apply(DataService::getJdbcInfo);
    }
    public DataServiceExpression<T, U, U> updateJdbcInfo(String jdbcInfo){
       return new DataServiceExpression(this, $it ->  ((DataService)$it).updateJdbcInfo(jdbcInfo));
    }

}