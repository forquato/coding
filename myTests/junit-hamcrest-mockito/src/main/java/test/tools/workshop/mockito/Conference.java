package test.tools.workshop.mockito;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.util.List;

public class Conference {
	private final ConferenceType type;
	private final List<ConferenceMember> conferenceMembers;

	public Conference(ConferenceType type, ConferenceMember... conferenceMembers) {
		this.type = type;
		this.conferenceMembers = asList(conferenceMembers);
	}

	public ConferenceType getType() {
		return type;
	}

	public List<ConferenceMember> getConferenceMembers() {
		return unmodifiableList(conferenceMembers);
	}
}
