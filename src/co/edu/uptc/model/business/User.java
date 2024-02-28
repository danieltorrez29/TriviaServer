package co.edu.uptc.model.business;

/**
 * 
 * User class
 * 
 * @author Daniel Torres
 */

public class User implements Comparable<User> {

	/**
	 * Email
	 */

	private String email;

	/**
	 * Username
	 */

	private String username;

	/**
	 * Password
	 */

	private String password;

	/**
	 * Profile picture path
	 */

	private String profilePicPath;

	/**
	 * Stats
	 */

	private Stats stats;

	/**
	 * Constructor method
	 * 
	 * @param email
	 * @param username
	 * @param password
	 * @param profilePicPath
	 * @param stats
	 */

	public User(String email, String username, String password, String profilePicPath, Stats stats) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.profilePicPath = profilePicPath;
		this.stats = stats;
	}

	/**
	 * getEmail method
	 * 
	 * @return email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * getUsername method
	 * 
	 * @return username
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * getPassword method
	 * 
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * getProfilePicPath method
	 * 
	 * @return profilePicPath
	 */

	public String getProfilePicPath() {
		return profilePicPath;
	}

	/**
	 * getStats method
	 * 
	 * @return stats
	 */

	public Stats getStats() {
		return stats;
	}

	/**
	 * setStats method
	 * 
	 * @param stats
	 */

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	/**
	 * toString overwrite method
	 */

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", profilePicPath="
				+ profilePicPath + ", stats=" + stats + "]";
	}

	/**
	 * compareTo overwrite method
	 */

	@Override
	public int compareTo(User o) {
		return stats.getScore() - o.getStats().getScore();
	}
}