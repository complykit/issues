/*
 * Created 21-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import org.complykit.issues.test.UtilSaveAndRetrieveObjects;
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

    private UtilSaveAndRetrieveObjects saveAndRetrieve;

    @BeforeClass public static void setUpClass() throws Exception { }
    @AfterClass public static void tearDownClass() throws Exception { }
    @Before public void setUp() {
        saveAndRetrieve=new UtilSaveAndRetrieveObjects();
    }
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
     * Test of getIssueTitle method, of class RISCIssue.
     */
    @Test
    public void testDisplayOrder() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="A";
        inst.setDisplayOrder(testVal);
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
        assertNotNull(queriedInst.getDisplayOrder());
        assertTrue(queriedInst.getDisplayOrder().equals(testVal));
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
    public void testTitle() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="test fsds fd";
        inst.setTitle(testVal);
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
        assertNotNull(queriedInst.getTitle());
        assertTrue(queriedInst.getTitle().equals(testVal));
    }

    /**
     * Test of getIssueDescription method, of class RISCIssue.
     */
    @Test
    public void testSummary() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        inst.setSummary(testVal);
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
        assertNotNull(queriedInst.getSummary());
        assertTrue(queriedInst.getSummary().equals(testVal));
    }

    /**
     * Test of getIssueDescription method, of class RISCIssue.
     */
    @Test
    public void testDetailedDescription() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        inst.setDetailedDescription(testVal);
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
        assertNotNull(queriedInst.getDetailedDescription());
        assertTrue(queriedInst.getDetailedDescription().equals(testVal));
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

    /**
     * Test of submitter methods, of class Ticket.
     */
    @Test
    public void testSubmitter() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        User submitter=new User();
        submitter.setEmail("test@test.com");
        inst.setSubmitter(submitter);
        try {
            saveAndRetrieve.user(submitter);
            queriedInst=saveAndRetrieve.riscIssue(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getSubmitter());
        assertTrue(queriedInst.getSubmitter().getId()==submitter.getId());
    }

    /**
     * Test of getCategory method, of class Ticket.
     */
    @Test
    public void testUserGroup() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        UserGroup group=new UserGroup();
        group.setName("group 1");
        inst.setUserGroup(group);
        try {
            saveAndRetrieve.userGroup(group);
            queriedInst=saveAndRetrieve.riscIssue(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getUserGroup());
        assertTrue(queriedInst.getUserGroup().getId()==group.getId());
    }


    /**
     * Test of getIssueTitle method, of class RISCIssue.
     */
    @Test
    public void testInstructionDisplayMode() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();
        String testVal="test fsds fd";
        inst.setInstructionDisplayMode(testVal);
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
        assertNotNull(queriedInst.getInstructionDisplayMode());
        assertTrue(queriedInst.getInstructionDisplayMode().equals(testVal));
    }

    /**
     * Test of instruction methods, of class Ticket.
     */
    @Test
    public void testInstructions() {
        RISCIssue inst=new RISCIssue();
        RISCIssue queriedInst=new RISCIssue();

        RISCIssueInstruction instruction1=new RISCIssueInstruction();
        instruction1.setTitle("instruction 1");
        RISCIssueInstruction instruction2=new RISCIssueInstruction();
        instruction2.setTitle("instruction 2");

        inst.getInstructions().add(instruction1);
        inst.getInstructions().add(instruction2);

        String testVal="test fsds fd";
        inst.setCategory(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);
            //TODO do I need to save those too?

            Long id=inst.getId();

            String hql="from RISCIssue where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssue)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getInstructions());
        assertTrue(queriedInst.getInstructions().size()==2);
    }
}