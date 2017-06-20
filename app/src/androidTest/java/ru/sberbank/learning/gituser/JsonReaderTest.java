package ru.sberbank.learning.gituser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Eugene on 20.06.2017.
 */

public class JsonReaderTest {

    private User mUser;

    @Test
    public void testJsonReader() throws Exception {

        String login = "login";
        String name = "name";
        int id = 0;
        String location = "location";
        String type = "type";

        mUser = new User(login, name, id, location, type);

        User expected = JsonReader.getUser(mUser);
        User actual = JsonReader.readJsonFromUrl(jsonStr);

        assertThat(actual, is(expected));
    }

}
