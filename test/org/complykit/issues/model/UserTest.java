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
public class UserTest {

    UtilSaveAndRetrieveObjects saveAndRetrieve;

    public UserTest() {}
    @BeforeClass public static void setUpClass() throws Exception {}
    @AfterClass public static void tearDownClass() throws Exception {}
    @Before public void setUp() {
        this.saveAndRetrieve=new UtilSaveAndRetrieveObjects();
    }
    @After public void tearDown() {}

    /**
     * Test of id methods, of class User.
     */
    @Test
    public void testId() {
        User instance1=new User();
        User instance2=new User();

        try {
            saveAndRetrieve.user(instance1);
            saveAndRetrieve.user(instance2);
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
     * Test of firstName methods, of class User.
     */
    @Test
    public void testFirstName() {
        User inst=new User();
        User queriedInst=new User();
        String testVal="A";
        inst.setFirstName(testVal);
        try {
            queriedInst=saveAndRetrieve.user(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getFirstName());
        assertTrue(queriedInst.getFirstName().equals(testVal));
    }

    /**
     * Test of lastName methods, of class User.
     */
    @Test
    public void testLastName() {
        User inst=new User();
        User queriedInst=new User();
        String testVal="A";
        inst.setLastName(testVal);
        try {
            queriedInst=saveAndRetrieve.user(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getLastName());
        assertTrue(queriedInst.getLastName().equals(testVal));
    }

    /**
     * Test of title methods, of class User.
     */
    @Test
    public void testTitle() {
        User inst=new User();
        User queriedInst=new User();
        String testVal="A";
        inst.setTitle(testVal);
        try {
            queriedInst=saveAndRetrieve.user(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getTitle());
        assertTrue(queriedInst.getTitle().equals(testVal));
    }

    /**
     * Test of email methods, of class User.
     */
    @Test
    public void testEmail() {
        User inst=new User();
        User queriedInst=new User();
        String testVal="A";
        inst.setEmail(testVal);
        try {
            queriedInst=saveAndRetrieve.user(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getEmail());
        assertTrue(queriedInst.getEmail().equals(testVal));
    }

    /**
     * Test of password methods, of class User.
     */
    @Test
    public void testPassword() {
        User inst=new User();
        User queriedInst=new User();
        String testVal="A";
        inst.setPassword(testVal);
        try {
            queriedInst=saveAndRetrieve.user(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getPassword());
        assertTrue(queriedInst.getPassword().equals(testVal));
    }

    @Test
    public void testActive() {
        User inst1=new User();
        User inst2=new User();
        User queriedInst1=new User();
        User queriedInst2=new User();
        boolean testDefaultVal=true;
        boolean testSetVal=false;
        //do not set inst1
        inst2.setActive(testSetVal);

        try {
            queriedInst1=saveAndRetrieve.user(inst1);
            queriedInst2=saveAndRetrieve.user(inst2);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertTrue(queriedInst1.isActive()==testDefaultVal);
        assertTrue(queriedInst2.isActive()==testSetVal);
    }

    @Test
    public void testAdministrator() {
        User inst1=new User();
        User inst2=new User();
        User queriedInst1=new User();
        User queriedInst2=new User();
        boolean testDefaultVal=false;
        boolean testSetVal=true;
        //do not set inst1
        inst2.setAdministrator(testSetVal);

        try {
            queriedInst1=saveAndRetrieve.user(inst1);
            queriedInst2=saveAndRetrieve.user(inst2);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertTrue(queriedInst1.isAdministrator()==testDefaultVal);
        assertTrue(queriedInst2.isAdministrator()==testSetVal);
    }
    /**
     * Test of userGroup methods, of class User.
     */
    @Test
    public void testUserGroup() {
        UserGroup inst=new UserGroup();
        User queriedInst=new User();

        User user1=new User();
        user1.setEmail("test email");
        user1.setUserGroup(inst);

        inst.getUsers().add(user1);

        Long userId=null;
        Long userGroupId=null;
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);
            session.save(user1); //maybe I should get rid of this...

            userGroupId=inst.getId();

            //get the ID from the saved step
            userId=((User)inst.getUsers().iterator().next()).getId();

            String hql="from User where id="+userId.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(User)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getUserGroup());
        assertTrue(queriedInst.getUserGroup().getId().longValue()==userGroupId.longValue());
    }

}