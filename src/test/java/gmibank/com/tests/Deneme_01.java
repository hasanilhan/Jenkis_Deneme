package gmibank.com.tests;

import gmibank.com.utilities.DatabaseConnector;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Deneme_01 {

    @Test
    public void deneme () throws SQLException {
        String query = "select *\n" +
                "from jhi_user\n" +
                "where jhi_user.login = 'adil'";
        List<Map<String, String>> deneme = DatabaseConnector.getQueryAsAListOfMaps(query);
        System.out.println(deneme.get(0).get("login"));
    }
}
