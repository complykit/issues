/*
 * Created 23-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import java.util.Date;
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
public class RISCIssueInstructionTest {

    public RISCIssueInstructionTest() {}
    @BeforeClass public static void setUpClass() throws Exception {}
    @AfterClass public static void tearDownClass() throws Exception {}
    @Before public void setUp() {}
    @After public void tearDown() {}

    /**
     * Test of getId method, of class RISCIssueInstruction.
     */
    @Test
    public void testId() {
        RISCIssueInstruction instance1=new RISCIssueInstruction();
        RISCIssueInstruction instance2=new RISCIssueInstruction();

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
     * Test of getDisplayOrder method, of class RISCIssueInstruction.
     */
    @Test
    public void testDisplayOrder() {
        RISCIssueInstruction inst=new RISCIssueInstruction();
        RISCIssueInstruction queriedInst=new RISCIssueInstruction();
        String testVal="test fsds fd";
        inst.setDisplayOrder(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssueInstruction where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssueInstruction)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getDisplayOrder());
        assertTrue(queriedInst.getDisplayOrder().equals(testVal));
    }

    /**
     * Test of getTitle method, of class RISCIssueInstruction.
     */
    @Test
    public void testTitle() {
        RISCIssueInstruction inst=new RISCIssueInstruction();
        RISCIssueInstruction queriedInst=new RISCIssueInstruction();
        String testVal="test fsds fd";
        inst.setTitle(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssueInstruction where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssueInstruction)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getTitle());
        assertTrue(queriedInst.getTitle().equals(testVal));
    }

    /**
     * Test of getDescription method, of class RISCIssueInstruction.
     */
    @Test
    public void testDescription() {
        RISCIssueInstruction inst=new RISCIssueInstruction();
        RISCIssueInstruction queriedInst=new RISCIssueInstruction();
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        inst.setDescription(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssueInstruction where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssueInstruction)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getDescription());
        assertTrue(queriedInst.getDescription().equals(testVal));
    }

    /**
     * Test of getStatus method, of class RISCIssueInstruction.
     */
    @Test
    public void testStatus() {
        RISCIssueInstruction inst=new RISCIssueInstruction();
        RISCIssueInstruction queriedInst=new RISCIssueInstruction();
        String testVal="test fsds fd";
        inst.setStatus(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssueInstruction where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssueInstruction)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getStatus());
        assertTrue(queriedInst.getStatus().equals(testVal));
    }

    /**
     * Test of getStatusDescription method, of class RISCIssueInstruction.
     */
    @Test
    public void testStatusDescription() {
        RISCIssueInstruction inst=new RISCIssueInstruction();
        RISCIssueInstruction queriedInst=new RISCIssueInstruction();
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        inst.setStatusDescription(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssueInstruction where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssueInstruction)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getStatusDescription());
        assertTrue(queriedInst.getStatusDescription().equals(testVal));
    }

    /**
     * Test of getStatusDate method, of class RISCIssueInstruction.
     */
    @Test
    public void testStatusDate() {
        RISCIssueInstruction inst=new RISCIssueInstruction();
        RISCIssueInstruction queriedInst=new RISCIssueInstruction();
        Date testVal=new Date();
        inst.setStatusDate(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from RISCIssueInstruction where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssueInstruction)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getStatusDate());
        assertTrue(queriedInst.getStatusDate().equals(testVal));
    }

    /**
     * Test of getIssue method, of class RISCIssueInstruction.
     */
    @Test
    public void testIssue() {
        RISCIssue inst=new RISCIssue();
        RISCIssueInstruction queriedInst=new RISCIssueInstruction();

        RISCIssueInstruction instruction1=new RISCIssueInstruction();
        instruction1.setTitle("instruction 1");
        instruction1.setIssue(inst);

        inst.getInstructions().add(instruction1); 

        Long instructionId=null;
        Long riscId=null;
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);
            session.save(instruction1); //maybe I should get rid of this...

            riscId=inst.getId();
            
            //get the ID from the saved instruction
            instructionId=((RISCIssueInstruction)inst.getInstructions().iterator().next()).getId();

            String hql="from RISCIssueInstruction where id="+instructionId.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(RISCIssueInstruction)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getIssue());
        assertTrue(queriedInst.getIssue().getId().longValue()==riscId.longValue());
    }

}