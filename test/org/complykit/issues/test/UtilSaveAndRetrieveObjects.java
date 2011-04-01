/*
 * Created 31-mar-2011 by Michael Rice
 */

package org.complykit.issues.test;

import org.complykit.issues.model.Ticket;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mrice
 */
public class UtilSaveAndRetrieveObjects {
    /**
     * This throws an exception because I need to be able to trap it as a
     * fail() condition in the @Test
     *
     * @param saveTicket the new ticket to be saved
     * @return the ticket to be pulled from JPA
     * @throws Exception
     */
    public Ticket ticket(Ticket saveTicket) throws Exception {

        Ticket queriedInst=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.save(saveTicket);

        Long id=saveTicket.getId();

        String hql="from Ticket where id="+id.longValue();
        Query query=session.createQuery(hql);
        queriedInst=(Ticket)query.uniqueResult();

        session.close();

        return queriedInst;
    }
}
