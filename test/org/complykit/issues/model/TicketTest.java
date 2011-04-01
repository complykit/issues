/*
 * Created 23-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import org.complykit.issues.test.UtilTestCaseMaker;
import org.complykit.issues.test.UtilSaveAndRetrieveObjects;
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
public class TicketTest {

    UtilSaveAndRetrieveObjects saveAndRetrieve;
    UtilTestCaseMaker testCaseMaker;
    public TicketTest() { }
    @BeforeClass public static void setUpClass() throws Exception { }
    @AfterClass public static void tearDownClass() throws Exception { }
    @Before public void setUp() { 
        saveAndRetrieve=new UtilSaveAndRetrieveObjects();
        testCaseMaker=new UtilTestCaseMaker();
    }
    @After public void tearDown() { }

    /**
     * Test of getId method, of class Ticket.
     */
    @Test
    public void testId() {
        Ticket instance1=new Ticket();
        Ticket instance2=new Ticket();

        try {
            saveAndRetrieve.ticket(instance1);
            saveAndRetrieve.ticket(instance2);
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
    public void testOpenedDate() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        Date testVal=new Date();
        inst.setOpenedDate(testVal);
        try {
            queriedInst=saveAndRetrieve.ticket(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getOpenedDate());
        assertTrue(queriedInst.getOpenedDate().equals(testVal));
    }


    /**
     * Test of the closed date aspects of the ticket
     */
    @Test
    public void testClosedDate() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        Date testVal=new Date();
        inst.setClosedDate(testVal);
        try {
            queriedInst=saveAndRetrieve.ticket(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getClosedDate());
        assertTrue(queriedInst.getClosedDate().equals(testVal));
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
            queriedInst=saveAndRetrieve.ticket(inst);
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
        String testVal=testCaseMaker.makeLongString();
        inst.setDescription(testVal);
        try {
            queriedInst=saveAndRetrieve.ticket(inst);
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
            queriedInst=saveAndRetrieve.ticket(inst);
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
            queriedInst=saveAndRetrieve.ticket(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getAssignedTo());
        assertTrue(queriedInst.getAssignedTo().equals(testVal));
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
            queriedInst=saveAndRetrieve.ticket(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getCategory());
        assertTrue(queriedInst.getCategory().equals(testVal));
    }

    /**
     * Test of getDescription method, of class Ticket.
     */
    @Test
    public void testCloseComments() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        String testVal=testCaseMaker.makeLongString();
        inst.setCloseComments(testVal);
        try {
            queriedInst=saveAndRetrieve.ticket(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertNotNull(queriedInst.getCloseComments());
        assertTrue(queriedInst.getCloseComments().equals(testVal));
    }

    /**
     * Test of getCategory method, of class Ticket.
     */
    @Test
    public void testCloseStatus() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        boolean testVal=true;
        inst.setClosed(testVal);
        try {
            queriedInst=saveAndRetrieve.ticket(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertTrue(queriedInst.isClosed()==testVal);
    }
    
    /**
     * Test of getCategory method, of class Ticket.
     */
    @Test
    public void testCloseResolved() {
        Ticket inst=new Ticket();
        Ticket queriedInst=new Ticket();
        boolean testVal=true;
        inst.setClosedResolved(testVal);
        try {
            queriedInst=saveAndRetrieve.ticket(inst);
        } catch (Exception e) {
            fail(e.getClass().getCanonicalName()+": "+e.getMessage());
        }
        assertTrue(queriedInst.isClosedResolved()==testVal);
    }
}