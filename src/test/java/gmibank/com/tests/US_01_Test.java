package gmibank.com.tests;

import gmibank.com.utilities.DatabaseConnector;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class US_01_Test {

    ResultSet resultSet;
    List<Map<String,String>> list;


    String query_tc11_01="select *\n" +
            "from jhi_user\n" +
            "join tp_customer on tp_customer.user_id=jhi_user.\"id\"\n" +
            "where \"state\" in ('USA', 'Miami','Adana','Amsterdam')";

    String query_tc11_03= "select *\n" +
            "from tp_customer\n" +
            "where id<40000 city like %is";

    String query_tc11_04="select first_name, last_name, email, zip_code\n" +
            "from tp_customer\n" +
            "join tp_state on tp_state.tpcountry_id=tp_customer.id\n" +
            "where zip_code in ('10433', '25000','456');";

    @Test
    public void ustc04 () {

    }

}
