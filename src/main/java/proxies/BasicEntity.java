package proxies;

import java.time.LocalDateTime;

public class BasicEntity {
	protected long id;
	public void setId(long id) {
		this.id = id;
	}

	private LocalDateTime modified = LocalDateTime.now();

	public long getId() {
		return id;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	



}