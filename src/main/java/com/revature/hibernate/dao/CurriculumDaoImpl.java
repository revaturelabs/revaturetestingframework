package com.revature.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.HibernateUtil;
import com.revature.hibernate.model.Curriculum;
import com.revature.hibernate.model.Skill;

public class CurriculumDaoImpl implements CurriculumDao {

	private static final Logger logger = Logger.getLogger(CurriculumDaoImpl.class);
	private static CurriculumDaoImpl currDao;
	
	private CurriculumDaoImpl () {}
	
	public static CurriculumDaoImpl getInstance() {
		if (currDao == null) {
			currDao = new CurriculumDaoImpl();
		}
		return currDao;
	}
	
	
	public void insertCurriculum(Curriculum curriculum) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(curriculum);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
			logger.warn(e);
		} finally {
			session.close();
		}
	}
	
	public Curriculum selectCurriculumByName(String name) {
		Session session = HibernateUtil.getSession();
		Curriculum curriculum = null;
		try {
			curriculum = (Curriculum) session.createCriteria(Curriculum.class).add(Restrictions.eq("curriculumName", name)).list().get(0);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return curriculum;
	}
	
	public Curriculum selectCurriculumById(int id) {
		Session session = HibernateUtil.getSession();
		Curriculum curriculum = null;
		try {
			curriculum = (Curriculum) session.load(Curriculum.class, id);
			//curriculum = (Curriculum) session.createCriteria(Curriculum.class).add(Restrictions.eq("curriculumId", id)).list().get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.warn(e);
		} finally {
			session.close();
		}
		return curriculum;
	}
	
	public List<Curriculum> selectAllCurriculum() {
		Session session = HibernateUtil.getSession();
		List<Curriculum> list = null;
		try {
			list = session.createQuery("from Curriculum").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void updateCurriculum(Curriculum curriculum, String name) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			curriculum.setCurriculumName(name);
			session.update(curriculum);
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
	
	public void addSkill(String curriculumName, Skill skill) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			Curriculum curriculum = (Curriculum) session.createCriteria(Curriculum.class).add(Restrictions.eq("curriculumName", curriculumName)).list().get(0);
			curriculum.getCurriculumSkill().add(skill);
			t = session.beginTransaction();
			session.persist(curriculum);
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
	
	public void deleteCurriculum(String name) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			Curriculum curriculum = (Curriculum) session.createCriteria(Curriculum.class).add(Restrictions.eq("curriculumName", name)).list().get(0);
			t = session.beginTransaction();
			session.delete(curriculum);
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
}
