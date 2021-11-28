package gmibank.com.tests;

import gmibank.com.utilities.DatabaseConnector;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_02_Test {

    @Test
    public void test() throws SQLException {
        // How many "true" in "tp_custemer" in
        // "zelle_enrolled" ? Find and verify?

        String tc_02_01="select count (zelle_enrolled)\n" +
                        "from tp_customer\n" +
                        "where zelle_enrolled='true';";
        List<Map<String,String>> tc_01= DatabaseConnector.getEmployeesAsListOfMap(tc_02_01);
        System.out.println(tc_01.get(0).get("true_count"));
        Assert.assertEquals(tc_01.get(0).get("true_count"),"137");

    }
    @Test
    public void test01() throws SQLException {
        String tc_02_01_Tekrar="select count (zelle_enrolled)\n" +
                "from tp_customer\n" +
                "where zelle_enrolled='true'";
        List<Map<String,String>>tc_02_01_Tekrarli=DatabaseConnector.getEmployeesAsListOfMap(tc_02_01_Tekrar);
    }


}
