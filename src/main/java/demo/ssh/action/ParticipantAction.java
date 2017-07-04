package demo.ssh.action;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import demo.ssh.dao.ParticipantDAO;
import demo.ssh.model.Participant;

@Component(value = "participantAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ParticipantAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ParticipantDAO dao;
	
	private final List<String> genderOptions = Arrays.asList("Male", "Female");

	private Participant participant;

	private List<Participant> participants;

	@Override
	public void prepare() throws Exception {
		if (null != participant && null != participant.getId()) {
			this.participant = this.dao.getParticipant(participant.getId());
		}
	}

	public String list() {
		this.participants = this.dao.getAllParticipants();
		return SUCCESS;
	}

	public String input() {
		return INPUT;
	}

	public String save() {
		if (null == this.participant.getId()) {
			this.dao.createParticipant(this.participant);
		} else {
			this.dao.updateParticipant(this.participant);
		}
		return SUCCESS;
	}

	public String delete() {
		this.dao.deleteParticipant(this.participant.getId());
		return SUCCESS;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<String> getGenderOptions() {
		return genderOptions;
	}


}
