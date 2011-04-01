/*
 * Created 31-mar-2011 by Michael Rice
 */

package org.complykit.issues.test;

/**
 *
 * @author mrice
 */
public class UtilTestCaseMaker {
    public String makeLongString() {
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        return testVal;
    }
}
