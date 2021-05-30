package fr.eql.ticketting.controller.refacto.sessionDataStored.groupDashboard;

import fr.eql.ticketting.entity.User;

/**
 * Data user connected
 * 
 * @author Furvent
 *
 */
public class UserData {

	private long id;

	private String pseudo;

	public UserData(User user) {
		this.id = user.getId();
		this.pseudo = user.getPseudo();
	}

	public long getId() {
		return id;
	}

	public String getPseudo() {
		return pseudo;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", pseudo=" + pseudo + "]";
	}

}
