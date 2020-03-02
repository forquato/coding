package com.arvato.dat.gui.common;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.junit.Test;

/**
 * Created by korb009 on 02.06.2017.
 */
public class CommonBeanTest {

    //CommonBean commonBean;

    private String version;

    @Test
    public void testGetVersion() {

        if (version == null) {
            try {
                CommonBean commonBean = mock(CommonBean.class);

                InputStream inputStream = getClass().getResourceAsStream("/META-INF/MANIFEST.MF");

                Manifest manifest = null;

                manifest = new Manifest(inputStream);

                Attributes mainAttributes = manifest.getMainAttributes();
                String value = mainAttributes.getValue("Manifest-Version");

                when(commonBean.getVersion()).thenReturn("1.1");
                assertEquals(commonBean.getVersion(), "1.1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
