package com.viscount.freedom.user.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Base DAO Implementation.
 *
 * @author Aloha
 *
 */
public class BaseDAO {

    public static final Logger LOG = Logger.getLogger(BaseDAO.class);
    
    public boolean closeSession(Session session) {
        try{
            if(session != null && session.isOpen()) {
                session.flush();
                session.close();
            }
        } catch (Exception e) {
            LOG.error("Session not closed : ", e);
        }

        return true;
    }
    
	    
}