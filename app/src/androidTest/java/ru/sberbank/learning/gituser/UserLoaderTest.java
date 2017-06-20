package ru.sberbank.learning.gituser;

import android.test.LoaderTestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Eugene on 20.06.2017.
 */

public class UserLoaderTest extends LoaderTestCase {

    private static final String LOGIN = "login";

    @Mock
    private UserLoader mLoader;


    @Before
    public void setUp() throws Exception {
        mLoader = mock(UserLoader.class);
    }

    @Test
    public void testOnStartLoading() throws Exception {
        doCallRealMethod().when(mLoader).onStartLoading();
        mLoader.onStartLoading();

        verify(mLoader, never()).deliverResult(getUser());
        verify(mLoader).forceLoad();
    }

    @Test
    public void testDeliveryResult() throws Exception {
        doCallRealMethod().when(mLoader).deliverResult(getUser());
        mLoader.deliverResult(getUser());

        verify(mLoader).isReset();
        verify(mLoader).isStarted();
    }
}
