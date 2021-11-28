package gmibank.com.tests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import gmibank.com.utilities.DatabaseConnector;
import gmibank.com.utilities.DatabaseConnector2;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_03_Test {

    public US_03_Test() throws SQLException {
        // tp_account tablosunda id 3000 den kucuk  kisilerin account_type
        // sadece saving olanarin hesabinda toplam 50 00000 mi
        // var ve bu sartlardaki hesap sahiplerinin  sayisi 16 mi oldugunu sorgulayin.

        String query01="select count(account_type) as account_count\n" +
                "from tp_account\n" +
                "where id<30000 and account_type='SAVING';";
        List<Map<String,String>> list = DatabaseConnector.getQueryAsAListOfMaps(query01);
    }
    @Test
    public void TC0303() throws SQLException {

        String query3="update jhi_user " +
                "set last_name='TeamTryCatch' " +
                "where last_modified_by like 'ad%' and id<2740";

        DatabaseConnector2.executeUpdateQuery(query3);

        String afterUpdate="select last_name " +
                "from jhi_user " +
                "where last_name='TeamTryCatch' and last_modified_by like 'ad%' and id<2740 " +
                "limit 5";

        List<Map<String,String>> list3=DatabaseConnector.getQueryAsAListOfMaps(afterUpdate);
        System.out.println(list3);

    }

}
