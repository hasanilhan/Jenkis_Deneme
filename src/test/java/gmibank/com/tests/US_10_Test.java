package gmibank.com.tests;

import gmibank.com.utilities.DatabaseConnector;
import gmibank.com.utilities.DatabaseConnector2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_10_Test {

    ResultSet resultSet;

    @Test
    public void tc1001() throws SQLException {
        // tc1001 -->Kullanıcı tp_account tablosunda
        // balance sütunundaki toplam miktarı bulur
        // toplam miktarin 1000000000'dan büyük oldugunu assert ediniz.

        String tc1001Query ="select sum(balance) as sum_balance_total\n" +
                "from tp_account";

        double tc01 =0;
        double actualSum =1000000000;
        resultSet =DatabaseConnector.getResultSet(tc1001Query);
        while (resultSet.next()){
            tc01=resultSet.getDouble(1);
            System.out.println(tc01);
        }
        Assert.assertTrue(tc01>actualSum);

    }

    @Test
    public void tc1002() throws SQLException {
        // US_10==>TC_02==> Kullancı ülkesi France olanların
        // balance sütunundaki toplam miktarı bulur

        String tc10_02 ="select sum(balance) as total_balance_of_france\n" +
                "from tp_account\n" +
                "join tp_country on tp_country.id=tp_account.id\n" +
                "where name ='FRANCE';";
        List<Map<String,String>> tc02=DatabaseConnector.getQueryAsAListOfMaps(tc10_02);
        System.out.println(tc02);
        Assert.assertEquals(tc02.get(0).get("total_balance_of_france"),null);


    }

    @Test
    public void tc1003() throws SQLException {
       // US_10==>TC_1003 Kullanıcı 2020 yılı ekim ayında gerçekleşen
       // toplam transfer miktarını bulur (Use tp_transaction_log table)

        String tc10_03="select sum(transaction_amount) as total_amount\n" +
                "from tp_transaction_log\n" +
                "where transaction_date between 'Oct 1, 2020, 7:53:30 PM' and 'Oct 30, 2020, 7:53:30 PM';\n";

        List<Map<String,String>> tc03=DatabaseConnector.getQueryAsAListOfMaps(tc10_03);
        System.out.println(tc03.get(0).get("total_amount"));
        String actualAmmount= tc03.get(0).get("total_amount");
        Assert.assertEquals(actualAmmount,"7060");

    }


}
