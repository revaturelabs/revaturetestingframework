package com.revature.hibernate.dao;

import static com.revature.hibernate.HibernateUtil.getSession;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.HibernateUtil;
import com.revature.hibernate.model.Batch;
import com.revature.hibernate.model.Curriculum;
import com.revature.hibernate.model.Focus;
import com.revature.hibernate.model.Room;
import com.revature.hibernate.model.Trainer;

public class BatchDaoImpl implements BatchDao {
	
	private static final Logger logger = Logger.getLogger(BatchDaoImpl.class);

	private static BatchDaoImpl daoImpl;
	
	private BatchDaoImpl() {}
	
	public static BatchDaoImpl getInstance() {
		if (daoImpl == null) {
			daoImpl = new BatchDaoImpl();
		}
		return daoImpl;
	}
	
	@Override
	public void createBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.save(batch);				// creates a new batch
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void editBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.update(batch);				// updated a current batch
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
		} finally {
			session.close();
		}

	}

	@Override
	public void cloneBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.save(batch);				// creates a new batch with the same details of another batch (except batch ID)
			
			session.getTransaction().commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void deleteBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.delete(batch);				// delete a batch
			
			session.getTransaction().commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
		} finally {
			session.close();
		}
	}
	
	public Batch selectBatchByName(String name) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		Batch batch = null;
		try {
			batch = (Batch) session.createCriteria(Batch.class).add(Restrictions.eq("batchName", name)).list().get(0);
		} catch (HibernateException e ) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return batch;
	}
	
	
	public void addRoomToBatch(String batchName, Room room) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			Batch batch = (Batch) session.createCriteria(Batch.class).add(Restrictions.eq("batchName", batchName)).list().get(0);
			batch.setRoom(room);
			t = session.beginTransaction();
			session.save(batch);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void addFocusToBatch(String batchName, Focus focus) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			Batch batch = (Batch) session.createCriteria(Batch.class).add(Restrictions.eq("batchName", batchName)).list().get(0);
			batch.setFocus(focus);
			t = session.beginTransaction();
			session.save(batch);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void addCurriculumToBatch(String batchName, Curriculum curriculum) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			Batch batch = (Batch) session.createCriteria(Batch.class).add(Restrictions.eq("batchName", batchName)).list().get(0);
			batch.setCurriculum(curriculum);
			t = session.beginTransaction();
			session.save(batch);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
//			session.close();
		}
	}
	
	public void addTrainerToBatch(String batchName, Trainer trainer) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			Batch batch = (Batch) session.createCriteria(Batch.class).add(Restrictions.eq("batchName", batchName)).list().get(0);
			batch.setTrainer(trainer);
			t = session.beginTransaction();
			session.save(batch);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
//			session.close();
		}
	}
	
	public List<Batch> selectAllBatches() {
		Session session = HibernateUtil.getSession();
		List<Batch> list = null;
		try {
			list = session.createQuery("from Batch").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
