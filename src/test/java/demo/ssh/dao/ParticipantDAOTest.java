package demo.ssh.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.ssh.model.Participant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.testing.xml" })
public class ParticipantDAOTest {

	@Autowired
	private ParticipantDAO dao;

	@Test
	public void testCRUD() {
		// Make sure table is empty
		assertTrue(this.dao.getAllParticipants().isEmpty());

		// Create new participant
		final Participant participant = new Participant();
		participant.setFirstName("John");
		participant.setLastName("Doe");
		participant.setEmail("john.doe@anonymous.com");
		participant.setGender("N/A");
		this.dao.createParticipant(participant);
		assertNotNull(participant.getId());

		final List<Participant> founds = this.dao.getAllParticipants();
		assertEquals(1, founds.size());
		assertEquals("John", founds.get(0).getFirstName());

		// Update participant
		participant.setFirstName("Jane");
		assertNotNull(this.dao.updateParticipant(participant));
		final Participant found = this.dao.getParticipant(participant.getId());
		assertNotNull(found);
		assertEquals("Jane", found.getFirstName());

		// Delete participant
		this.dao.deleteParticipant(participant.getId());
		assertTrue(this.dao.getAllParticipants().isEmpty());

	}

}
