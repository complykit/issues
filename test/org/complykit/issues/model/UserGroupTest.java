/*
 * Created 4-apr-2011 by Michael Rice
 */

package org.complykit.issues.model;

import org.complykit.issues.test.UtilSaveAndRetrieveObjects;
import org.hibernate.Query;
import org.complykit.issues.test.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mrice
 */
public class UserGroupTest {

    UtilSaveAndRetrieveObjects saveAndRetrieve;

    public UserGroupTest() {}
    @BeforeClass public static void setUpClass() throws Exception { }
    @AfterClass public static void tearDownClass() throws Exception { }
    @Before public void setUp() {
        this.saveAndRetrieve=new UtilSaveAndRetrieveObjects();
    }
    @After public void tearDown() {}

    /**
     * Test of getId method, of class UserGroup.
     */
    @Test
    public void testId() {
        UserGroup instance1=new UserGroup();
        UserGroup instance2=new UserGroup();

        try {
            saveAndRetrieve.userGroup(instance1);
            saveAndRetrieve.userGroup(instance2);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertTrue(instance1.getId()!=null);
        assertTrue(instance1.getId().longValue()>0);

        assertTrue(instance2.getId()!=null);
        assertTrue(instance2.getId().longValue()>0);

        assertTrue(instance1.getId().longValue()<instance2.getId().longValue());
    }

    /**
     * Test of getName method, of class UserGroup.
     */
    @Test
    public void testName() {
        UserGroup inst=new UserGroup();
        UserGroup queriedInst=new UserGroup();
        String testVal="A";
        inst.setName(testVal);
        try {
            queriedInst=saveAndRetrieve.userGroup(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getName());
        assertTrue(queriedInst.getName().equals(testVal));
    }

    /**
     * Test of getUsers method, of class UserGroup.
     */
    @Test
    public void testUsers() {
        UserGroup inst=new UserGroup();
        UserGroup queriedInst=new UserGroup();

        User user1=new User();
        user1.setEmail("test email 1");
        user1.setUserGroup(inst);
        User user2=new User();
        user2.setEmail("test email 2");
        user2.setUserGroup(inst);

        inst.getUsers().add(user1);
        inst.getUsers().add(user2);

        String testVal="test fsds fd";
        inst.setName(testVal);
        try {
            saveAndRetrieve.user(user1);
            saveAndRetrieve.user(user2);
            queriedInst=saveAndRetrieve.userGroup(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getUsers());
        assertTrue(queriedInst.getUsers().size()==2);
    }

}