package gmibank.com.tests;

import gmibank.com.utilities.DatabaseConnector;
import gmibank.com.utilities.DatabaseConnector2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_10_Deneme {
    ResultSet resultSet;

    @Test
    public void tc1001() throws SQLException {

        // tc1001 -->Kullanıcı tp_account tablosunda
        // balance sütunundaki toplam miktarı bulur
        // toplam miktarin 1000000000'dan büyük oldugunu assert ediniz.

        String tc1001Query = "select sum(balance) as sum_total_balance\n" +
                "from tp_account";

        double tc10 = 0;
        double actualSum = 1000000000;
        resultSet = DatabaseConnector2.getResultSet(tc1001Query);
        System.out.println(resultSet);
        while (resultSet.next()) {
            tc10 = resultSet.getDouble(1);
            System.out.println(tc10);

            }
        Assert.assertTrue(tc10>actualSum);

    }
    @Test
    public void tc1002() throws SQLException {

        String tc10_02Query="select sum(balance) as total_balance_of_france\n" +
                "from tp_account\n" +
                "join tp_country on tp_country.id=tp_account.id\n" +
                "where name='FRANCE'";
        List<Map<String,String>> tc02= DatabaseConnector.getQueryAsAListOfMaps(tc10_02Query);
        System.out.println(tc02);
        Assert.assertEquals(tc02.get(0).get("total_balance_of_france"),null);


    }






}




