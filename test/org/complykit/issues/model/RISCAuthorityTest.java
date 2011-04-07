/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.complykit.issues.model;

import org.complykit.issues.test.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.complykit.issues.test.UtilSaveAndRetrieveObjects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michael
 */
public class RISCAuthorityTest {

    private UtilSaveAndRetrieveObjects saveAndRetrieve;

    public RISCAuthorityTest() {}
    @BeforeClass public static void setUpClass() throws Exception {}
    @AfterClass public static void tearDownClass() throws Exception {}
    @Before public void setUp() {
        saveAndRetrieve=new UtilSaveAndRetrieveObjects();
    }
    @After public void tearDown() {}

    /**
     * Test of id methods of class RISCAuthority.
     */
    @Test
    public void testId() {
        RISCAuthority instance1=new RISCAuthority();
        RISCAuthority instance2=new RISCAuthority();

        try {
            saveAndRetrieve.authority(instance1);
            saveAndRetrieve.authority(instance2);
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
     * Test of type methods of class RISCAuthority.
     */
    @Test
    public void testType() {
        RISCAuthority inst=new RISCAuthority();
        RISCAuthority queriedInst=new RISCAuthority();
        String testVal="A";
        inst.setType(testVal);
        try {
            queriedInst=saveAndRetrieve.authority(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getType());
        assertTrue(queriedInst.getType().equals(testVal));
    }

    /**
     * Test of source methods of class RISCAuthority.
     */
    @Test
    public void testSource() {
        RISCAuthority inst=new RISCAuthority();
        RISCAuthority queriedInst=new RISCAuthority();
        String testVal="A";
        inst.setSource(testVal);
        try {
            queriedInst=saveAndRetrieve.authority(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getSource());
        assertTrue(queriedInst.getSource().equals(testVal));
    }


    /**
     * Test of issue methods of class RISCAuthority.
     */
    @Test
    public void testIssue() {
        RISCIssue inst=new RISCIssue();
        RISCAuthority queriedInst=new RISCAuthority();

        RISCAuthority authority1=new RISCAuthority();
        authority1.setType("caselaw");
        authority1.setSource("Ruby v. Java, 434 F.3d 653 (9th Cir. 2009)");
        authority1.setIssue(inst);

        inst.getAuthorities().add(authority1);

        Long authorityId=null;
        Long riscId=null;
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);
            session.save(authority1); //maybe I should get rid of this...

            riscId=inst.getId();

            //get the ID from the saved instruction
            authorityId=((RISCAuthority)inst.getAuthorities().iterator().next()).getId();

            String hql="from RISCAuthority where id="+authorityId.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCAuthority)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getIssue());
        assertTrue(queriedInst.getIssue().getId().longValue()==riscId.longValue());
    }

}