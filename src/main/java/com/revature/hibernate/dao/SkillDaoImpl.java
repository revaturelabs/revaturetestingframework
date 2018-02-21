package com.revature.hibernate.dao;

import static com.revature.hibernate.HibernateUtil.getSession;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.HibernateUtil;
import com.revature.hibernate.model.Skill;

public class SkillDaoImpl implements SkillDao {

	private static final Logger logger = Logger.getLogger(SkillDaoImpl.class);
	
	private static SkillDaoImpl daoImpl;
	
	private SkillDaoImpl () {}
	
	public static SkillDaoImpl getInstance() {
		if (daoImpl == null) {
			daoImpl = new SkillDaoImpl();
		}
		return daoImpl;
	}
	
	@Override
	public void insertSkill(Skill skill) {
		Session session = null;
		try {
			session = getSession();
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(skill);
			t.commit();
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void deleteSkill(String skillName) {
		Session session = null;
		try {
			session = getSession();
			Transaction t = session.beginTransaction();
			Skill skill = (Skill) session.createCriteria(Skill.class).add(Restrictions.eq("skillName", skillName)).list().get(0);
			session.delete(skill);
			t.commit();
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Skill selectSkill(String skillName) {
		Skill skill = null;
		Session session = null;
		try {
			session = getSession();
			skill = (Skill) session.createCriteria(Skill.class).add(Restrictions.eq("skillName", skillName)).list().get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return skill;
	}
	
	
	public List<Skill> selectAllSkills() {
		return HibernateUtil.getSession().createQuery("from Skill").list();
	}

}
