package demo.ssh.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.ssh.model.Participant;

@Repository
@Transactional
public class ParticipantDAOImpl implements ParticipantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createParticipant(final Participant participant) {
		sessionFactory.getCurrentSession().saveOrUpdate(participant);
	}

	@Override
	public void deleteParticipant(final int id) {
		final Participant participant = (Participant) sessionFactory.getCurrentSession().load(Participant.class, id);
		if (null != participant) {
			this.sessionFactory.getCurrentSession().delete(participant);
		}
	}

	@Override
	public Participant updateParticipant(final Participant participant) {
		sessionFactory.getCurrentSession().update(participant);
		return participant;
	}

	@Override
	public Participant getParticipant(final int id) {
		return (Participant) sessionFactory.getCurrentSession().get(Participant.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Participant> getAllParticipants() {
		return sessionFactory.getCurrentSession().createQuery("from Participant")
				.list();
	}

}
