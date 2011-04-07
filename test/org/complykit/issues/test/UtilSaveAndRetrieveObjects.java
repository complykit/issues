/*
 * Created 31-mar-2011 by Michael Rice
 */

package org.complykit.issues.test;

import org.complykit.issues.model.RISCAuthority;
import org.complykit.issues.model.RISCIssue;
import org.complykit.issues.model.Ticket;
import org.complykit.issues.model.User;
import org.complykit.issues.model.UserGroup;
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

    /**
     *
     * @param saveUser the new user to be saved
     * @return the user to be pulled from the JPA
     * @throws Exception
     */
    public User user(User saveUser) throws Exception {

        User queriedInst=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.save(saveUser);

        Long id=saveUser.getId();

        String hql="from User where id="+id.longValue();
        Query query=session.createQuery(hql);
        queriedInst=(User)query.uniqueResult();

        session.close();

        return queriedInst;
    }

    /**
     *
     * @param saveUser the new user to be saved
     * @return the user to be pulled from the JPA
     * @throws Exception
     */
    public UserGroup userGroup(UserGroup saveUserGroup) throws Exception {

        UserGroup queriedInst=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.save(saveUserGroup);

        Long id=saveUserGroup.getId();

        String hql="from UserGroup where id="+id.longValue();
        Query query=session.createQuery(hql);
        queriedInst=(UserGroup)query.uniqueResult();

        session.close();

        return queriedInst;
    }

    /**
     *
     * @param saveUser the new user to be saved
     * @return the user to be pulled from the JPA
     * @throws Exception
     */
    public RISCIssue riscIssue(RISCIssue riscIssue) throws Exception {

        RISCIssue queriedInst=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.save(riscIssue);

        Long id=riscIssue.getId();

        String hql="from RISCIssue where id="+id.longValue();
        Query query=session.createQuery(hql);
        queriedInst=(RISCIssue)query.uniqueResult();

        session.close();

        return queriedInst;
    }

    /**
     *
     * @param authority the new user to be saved
     * @return the authority to be pulled from the JPA
     * @throws Exception
     */
    public RISCAuthority authority(RISCAuthority authority) throws Exception {

        RISCAuthority queriedInst=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.save(authority);

        Long id=authority.getId();

        String hql="from RISCAuthority where id="+id.longValue();
        Query query=session.createQuery(hql);
        queriedInst=(RISCAuthority)query.uniqueResult();

        session.close();

        return queriedInst;
    }
}
