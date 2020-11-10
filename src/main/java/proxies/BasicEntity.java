package proxies;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BasicEntity implements Serializable{
	private static final long serialVersionUID = -1247459189884826799L;
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
