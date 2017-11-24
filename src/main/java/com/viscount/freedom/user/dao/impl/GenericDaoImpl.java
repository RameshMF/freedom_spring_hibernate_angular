package com.viscount.freedom.user.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.viscount.freedom.dbconfig.util.ManageSessionFactory;
import com.viscount.freedom.user.dao.GenericDao;

/**
 * Base DAO Implementation.
 *
 * @author Aloha
 * @param <T>
 *
 */
public class GenericDaoImpl<T> extends BaseDAO implements GenericDao<T> {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(GenericDaoImpl.class);
	
	/** The type. */
	private Class<T> type;

	
	/**
	 * Instantiates a new generic dao impl.
	 */
	public GenericDaoImpl() {
	}

	/**
	 * Instantiates a new generic dao impl.
	 *
	 * @param type the type
	 */
	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	/**
	 * Save an instance to the table.
	 * 
	 * @param instance
	 *            row to add to table
	 */
	@Override
	public void save(T instance) {
		Session session = ManageSessionFactory.getSessionFactory().openSession();
		session.save(instance);
		closeSession(session);
	}

	/**
	 * Delete the supplied instance from the database table.
	 * 
	 * @param instance
	 *            to delete from the table
	 */
	@Override
	public void delete(T instance) {
		Session session = ManageSessionFactory.getSessionFactory().openSession();
		session.delete(instance);
		closeSession(session);
	}

	/**
	 * Finds the specific instance in the database which matches the 'id' passed
	 * in.
	 * 
	 * @param id
	 *            Id to find in database
	 * @return the instance with the given id, or <code>null</code> if it is not
	 *         found.
	 */
	@Override
	public T findById(long id) {
		
		Session session = null;
		try{
			session = ManageSessionFactory.getSessionFactory().openSession();
		return session.get(type, id);
		}finally{
			closeSession(session);	
		}

	}


	/**
	 * Find all instances in a table. The SQL equivalent is - select * from
	 * table.
	 * 
	 * @return List of table rows
	 */
	@Override
	public List<T> findAll(final Class<T> type) {
		 Session session = null;
		try{
			session = ManageSessionFactory.getSessionFactory().openSession();
			final Criteria crit = session.createCriteria(type);
			return crit.list();
			}finally{
				closeSession(session);	
			}
		}

	/**
	 * Update the instance.
	 */
	@Override
	public void update(T instance) {
		Session session = ManageSessionFactory.getSessionFactory().openSession();
		session.update(instance);
		closeSession(session);
	}
	
	/**
	 * Returns the row count for the particular table.
	 * 
	 * @return the number of rows in the table
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Delete all instances from the database. Equivalent to delete from table.
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
