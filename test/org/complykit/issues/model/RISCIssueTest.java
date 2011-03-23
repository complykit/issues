/*
 * Created 21-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import org.hibernate.Query;
import org.complykit.issues.test.HibernateUtil;
import org.hibernate.Session;
import java.util.Date;
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
public class RISCIssueTest {
    @BeforeClass public static void setUpClass() throws Exception { }
    @AfterClass public static void tearDownClass() throws Exception { }
    @Before public void setUp() { }
    @After public void tearDown() { }

    /**
     * GOAL: make sure the auto number generator is working and generating
     * sequential numbers.
     */
    @Test
    public void testId() {
        RISCIssue instance1=new RISCIssue();
        RISCIssue instance2=new RISCIssue();

        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(instance1);
            session.save(instance2);
            session.close();
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
     * Test of getRiskMagnitude method, of class RISCIssue.
     */
    @Test
    public void testRiskMagnitude() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        Double testVal=new Double(10.231);
        inst.setRiskMagnitude(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }

        assertTrue(queriedInst.getRiskMagnitude().doubleValue()==testVal.doubleValue());
    }

    /**
     * Test of getRiskProbability method, of class RISCIssue.
     */
    @Test
    public void testRiskProbability() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        Double testVal=new Double(10.32432);
        inst.setRiskProbability(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }

        assertTrue(queriedInst.getRiskProbability().doubleValue()==testVal.doubleValue());
    }

    /**
     * Test of getIssueTitle method, of class RISCIssue.
     */
    @Test
    public void testIssueTitle() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="test fsds fd";
        inst.setIssueTitle(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getIssueTitle());
        assertTrue(queriedInst.getIssueTitle().equals(testVal));
    }

    /**
     * Test of getIssueDescription method, of class RISCIssue.
     */
    @Test
    public void testIssueDescription() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        inst.setIssueDescription(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getIssueDescription());
        assertTrue(queriedInst.getIssueDescription().equals(testVal));
    }

    /**
     * Test of getStatusDate method, of class RISCIssue.
     */
    @Test
    public void testStatusDate() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        Date testVal=new Date();
        inst.setStatusDate(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getStatusDate());
        assertTrue(queriedInst.getStatusDate().equals(testVal));
    }


    /**
     * Test of getStatusDescription method, of class RISCIssue.
     */
    @Test
    public void testStatusDescription() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        inst.setStatusDescription(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getStatusDescription());
        assertTrue(queriedInst.getStatusDescription().equals(testVal));
    }

    /**
     * Test of getStatusTitle method, of class RISCIssue.
     */
    @Test
    public void testStatusTitle() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="test fsds fd";
        inst.setStatusTitle(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getStatusTitle());
        assertTrue(queriedInst.getStatusTitle().equals(testVal));
    }

    /**
     * Test of getCategory method, of class RISCIssue.
     */
    @Test
    public void testCategory() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="test fsds fd";
        inst.setCategory(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getCategory());
        assertTrue(queriedInst.getCategory().equals(testVal));
    }

}