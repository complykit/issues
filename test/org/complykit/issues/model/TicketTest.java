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
public class TicketTest {

    public TicketTest() { }
    @BeforeClass public static void setUpClass() throws Exception { }
    @AfterClass public static void tearDownClass() throws Exception { }
    @Before public void setUp() { }
    @After public void tearDown() { }

    /**
     * Test of getId method, of class Ticket.
     */
    @Test
    public void testId() {
        Ticket instance1=new Ticket();
        Ticket instance2=new Ticket();

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
     * Test of getSubmittedDate method, of class Ticket.
     */
    @Test
    public void testSubmittedDate() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        Date testVal=new Date();
        inst.setSubmittedDate(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getSubmittedDate());
        assertTrue(queriedInst.getSubmittedDate().equals(testVal));
    }


    /**
     * Test of getResolvedDate method, of class Ticket.
     */
    @Test
    public void testResolvedDate() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        Date testVal=new Date();
        inst.setResolvedDate(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getResolvedDate());
        assertTrue(queriedInst.getResolvedDate().equals(testVal));
    }

    /**
     * Test of getTitle method, of class Ticket.
     */
    @Test
    public void testTitle() { 
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        String testVal="test fsds fd";
        inst.setTitle(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getTitle());
        assertTrue(queriedInst.getTitle().equals(testVal));
    }

    /**
     * Test of getDescription method, of class Ticket.
     */
    @Test
    public void testDescription() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        String testVal="";
        for (int i=0; i<1000; i++) {
            testVal=testVal+i;
        }
        inst.setDescription(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getDescription());
        assertTrue(queriedInst.getDescription().equals(testVal));
    }

    /**
     * Test of getSubmitter method, of class Ticket.
     */
    @Test
    public void testSubmitter() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        String testVal="test fsds fd";
        inst.setSubmitter(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getSubmitter());
        assertTrue(queriedInst.getSubmitter().equals(testVal));
    }

    /**
     * Test of getAssignedTo method, of class Ticket.
     */
    @Test
    public void testAssignedTo() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        String testVal="test fsds fd";
        inst.setAssignedTo(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getAssignedTo());
        assertTrue(queriedInst.getAssignedTo().equals(testVal));
    }

    /**
     * Test of getStatus method, of class Ticket.
     */
    @Test
    public void testStatus() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        String testVal="test fsds fd";
        inst.setStatus(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getStatus());
        assertTrue(queriedInst.getStatus().equals(testVal));
    }

    /**
     * Test of getCategory method, of class Ticket.
     */
    @Test
    public void testCategory() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        String testVal="test fsds fd";
        inst.setCategory(testVal);
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.save(inst);

            Long id=inst.getId();

            String hql="from Ticket where id="+id.longValue();
            Query query=session.createQuery(hql);
            queriedInst=(Ticket)query.uniqueResult();
            session.close();
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getCategory());
        assertTrue(queriedInst.getCategory().equals(testVal));
    }

}