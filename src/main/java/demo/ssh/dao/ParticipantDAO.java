package demo.ssh.dao;

import java.util.List;

import demo.ssh.model.Participant;

public interface ParticipantDAO {

	public void createParticipant(Participant participant);
	
	public void deleteParticipant(int id);

	public Participant updateParticipant(Participant participant);

	public Participant getParticipant(int id);
	
	public List<Participant> getAllParticipants();

}
